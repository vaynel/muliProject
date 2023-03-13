package com.trillon.camp.campingHome.board.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class BoardForm {

    private long bd_idk;
    private String id;
    private String title;
    private String text;
    private String hashtag;
    private List<MultipartFile> imageFiles;
}
