package com.trillon.camp.campingHome.board.controller;
import com.trillon.camp.campingHome.board.dto.BoardForm;

import com.trillon.camp.campingHome.board.dto.Reply;
import com.trillon.camp.campingHome.board.service.BoardService;


import com.trillon.camp.campingHome.naverShopping.dto.Item;
import com.trillon.camp.campingHome.naverShopping.service.NaverShoppingSearch;
import com.trillon.camp.comewithme.dto.ComeWithMeBoard;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
@RequiredArgsConstructor
@RequestMapping("/campingHome")
@Slf4j
public class BoardController {


    private final BoardService boardService;
    private final NaverShoppingSearch shopping;


    @GetMapping("board/new") // 게시판 등록 폼
    public String newFile(){
        return "/campingHome/board-form";
    }


    @PostMapping("board/new")// 게시판 등록 버튼을 눌렀을 때 실행되는 메서드
    public String saveFile(
            @ModelAttribute BoardForm boardForm,
            @RequestParam("itemName") List<String> item,
            @RequestParam("file") List<MultipartFile> files) throws IOException, ParseException {

        System.out.println(item);

        item.removeIf(s->s.length() == 0);
        System.out.println(item);

        boardService.insertBoard(boardForm,item,files);
        return "redirect:/campingHome/boards";
    }

    @GetMapping("board/modify") // 게시판 수정 1-1
    public String modify(int bdIdx, Model model) {
        System.out.println("get modify: " + bdIdx);
        model.addAllAttributes(boardService.selectBoardByBdIdx(bdIdx));
        return "/campingHome/boardForm-modify";
    }

    @PostMapping("board/modify") // 게시판수정 1-2
    public String modify(@ModelAttribute BoardForm boardForm) {

        int bdIdx = boardForm.getBdIdx();
        boardService.updateBoard(boardForm);

        return "redirect:/campingHome/board/"+bdIdx;
    }

    
    @GetMapping("boards") // 게시판 목록페이지 접속
    public String boards(Model model,@RequestParam(required = false,defaultValue = "1") int page){
        model.addAllAttributes(boardService.selectBoardList(page));
        return "/campingHome/boards";
    }



    @GetMapping("board/{bdIdx}") // 게시판 상세페이지 접속
    public String boardDetail(@PathVariable("bdIdx") int bdIdx,Model model) {
        model.addAllAttributes(boardService.selectBoardByBdIdx(bdIdx));
        Object item = model.getAttribute("item");


        // 댓글 가져오기

        List<Reply> replies = boardService.selectReplyAll(bdIdx);
        model.addAttribute("replies",replies);
        return "/campingHome/boardDetail";
    }

    @PostMapping("board/{bdIdx}")// 게시판에서 쓴 댓글 저장
    @ResponseBody
    public Reply saveReply(@PathVariable int bdIdx, Model model,
                           @RequestBody Reply reply){
        reply.setBdIdx(bdIdx);
        boardService.insertReply(reply);
        //List<Reply> replies = boardService.selectReplyAll(bdIdx);
        return reply;
    }


    @ResponseBody
    @GetMapping("/images/{gnIdx}/{fileName}")  // 이미지를 출력해주는 메서드
    public Resource downloadImage(@PathVariable Object fileName,
                                  @PathVariable int gnIdx) throws MalformedURLException {
        return new UrlResource("file:"+"C:/campingHome/"+gnIdx+"/"+ fileName);
    }

    @GetMapping("remove") // 게시판 삭제
    public String remove(@RequestParam int bdIdx) {
        System.out.println("remove : " + bdIdx);
        boardService.deleteBoard(bdIdx);
        return "redirect:/campingHome/boards";
    }

}
