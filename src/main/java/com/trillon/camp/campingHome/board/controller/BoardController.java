package com.trillon.camp.campingHome.board.controller;
import com.trillon.camp.campingHome.board.dto.BoardForm;
import com.trillon.camp.campingHome.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



import java.io.IOException;
import java.util.List;
import java.util.Map;

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
    public void saveFile(@RequestBody BoardForm boardForm, Model model) throws IOException {
        int bdIdx = boardService.insertBoard(boardForm);
        //redirectAttributes.addAttribute("bdIdx",bdIdx);  // 확인이 안되는 이유는 무엇인가???
        //return "redirect:/campingHome/boards";
    }

    @GetMapping("/board/{bdIdx}") // 게시판 상세페이지 접속
    public String boardDetail(@PathVariable("bdIdx") int bdIdx,Model model) {
        System.out.println("getMapping");
        BoardForm boardForm = boardService.selectBoardByBdIdx(bdIdx);
        model.addAttribute("board",boardForm);
        return "/campingHome/boardDetail";
    }

    @GetMapping("boards") // 게시판 목록페이지 접속
    public void boards(Model model){
        List<BoardForm> boards =boardService.selectBoardAll();
        log.info("boards={}",boards);
        model.addAttribute("boards",boards);

    }

}


