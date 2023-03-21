package com.trillon.camp.campingHome.board.controller;
import com.trillon.camp.campingHome.board.dto.BoardForm;
import com.trillon.camp.campingHome.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



import java.io.IOException;


@Controller
@RequiredArgsConstructor
@RequestMapping("/campingHome")
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @GetMapping("board/new") // 게시판 등록 폼
    public String newFile(){
        return "/campingHome/board-form";
    }

    @PostMapping("board/new")// 게시판 등록 버튼을 눌렀을 때 실행되는 메서드
    @ResponseBody
    public void saveFile(@RequestBody BoardForm boardForm) throws IOException {
        boardService.insertBoard(boardForm);


    }

    @GetMapping("boards") // 게시판 목록페이지 접속
    public String boards(Model model,@RequestParam(required = false,defaultValue = "1") int page){
      //  model.addAllAttributes(boardService.selectBoardList(page));
        return "/campingHome/boards";
    }

    @GetMapping("/board/{bdIdx}") // 게시판 상세페이지 접속
    public String boardDetail(@PathVariable("bdIdx") int bdIdx,Model model) {
        System.out.println("getMapping");
        BoardForm boardForm = boardService.selectBoardByBdIdx(bdIdx);
        model.addAttribute("board",boardForm);
        return "/campingHome/boardDetail";
    }



}