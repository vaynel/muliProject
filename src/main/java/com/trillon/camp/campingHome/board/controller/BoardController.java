package com.trillon.camp.campingHome.board.controller;
import com.trillon.camp.campingHome.board.dto.BoardForm;
import com.trillon.camp.campingHome.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/campingHome")
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/boards/new") // 게시판 등록 폼
    public String newFile(){
        return "/campingHome/board-form";
    }

    @PostMapping("boards/new")// 게시판 등록 버튼을 눌렀을 때 실행되는 메서드
    public String saveFile(@RequestBody BoardForm boardForm, HttpSession session ) throws IOException {

        int bd_idx = boardService.insertBoard(boardForm);
        log.info("post ={}", bd_idx);

        session.setAttribute("bd_idx",bd_idx);

        log.info("post ={}", boardForm);

        return "redirect:/campingHome/boardDetail";
    }

    @GetMapping("/boardDetail") // 게시판 조회
    public String boardDetail(@SessionAttribute("bd_idx") int bd_idx) {
        BoardForm boardForm = boardService.selectBoardByBd_idx(bd_idx);

        log.info("get ={}", boardForm);

        return "/campingHome/boardDetail";
    }



}
