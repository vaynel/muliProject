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
    public String saveFile(@RequestBody BoardForm boardForm, RedirectAttributes redirectAttributes, Model model) throws IOException {
        int bd_idx = boardService.insertBoard(boardForm);
        redirectAttributes.addAttribute("bd_idx",bd_idx);
        model.addAttribute("bd_idx",bd_idx);

        return "redirect:/campingHome/boardDetail/{bd_idx}";


    }

    @GetMapping("/boardDetail/{bd_idx}") // 게시판 작성 후 해당 게시판 상세페이지
    public String boardDetail(@PathVariable("bd_idx") int bd_idx,Model model) {
        System.out.println("getMapping");
        BoardForm boardForm = boardService.selectBoardByBd_idx(bd_idx);
        log.info("get ={}", boardForm);
        model.addAttribute("board",boardForm);

        return "/campingHome/boardDetail";

    }

}
