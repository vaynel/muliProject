package com.trillon.camp.campingHome.board.controller;

import com.trillon.camp.campingHome.board.FileStore;
import com.trillon.camp.campingHome.board.dto.Board;
import com.trillon.camp.campingHome.board.dto.BoardForm;
import com.trillon.camp.campingHome.board.dto.UploadFile;
import com.trillon.camp.campingHome.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/campingHome")
public class BoardController {

    private final BoardRepository boardRepository;
    private final FileStore fileStore;

    @GetMapping("boards/new") // 게시판 등록 폼
    public String newFile(@ModelAttribute BoardForm Form){
        return "/campingHome/board-form";
    }

    @PostMapping("boards/new")// 게시판 등록
    @ResponseBody
    public String saveFile(@ModelAttribute BoardForm form, RedirectAttributes redirectAttributes,@RequestBody String data) throws IOException {
        List<UploadFile> storeImageFiles = fileStore.storeFiles(form.getImageFiles());

    // 데이터베이스에 저장
    Board board = new Board();
    board.setBd_idk(form.getBd_idk());
    board.setId(form.getId());
    board.setTitle(form.getTitle());
    board.setText(form.getText());
    board.setImageFiles(storeImageFiles);
    boardRepository.save(board);

    redirectAttributes.addAttribute("bd_idk",board.getBd_idk());
        System.out.println(data);
        return "redirect:/campingHome/boards/{bd_idk}";
    }

    @GetMapping("/boards/{bd_idk}") // 게시판 조회
    public String boardDetail(@PathVariable long bd_idk, Model model) {
        Board board = boardRepository.findByBd_idk(bd_idk);
        model.addAttribute("board",board);
        return "/campingHome/boardDetail";
    }
}
