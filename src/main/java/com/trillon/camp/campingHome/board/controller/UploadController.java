package com.trillon.camp.campingHome.board.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class UploadController {

    @GetMapping("board-form")
    public void newFile(){
    }

    @PostMapping("board-form")
    public void saveFile(@RequestParam Long bd_idk,
                            @RequestParam String title,
                            @RequestParam String text,
                            @RequestParam String hashtag,
                            @RequestParam MultipartFile file){
    }



}
