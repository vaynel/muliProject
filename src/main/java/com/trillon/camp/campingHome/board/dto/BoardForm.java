package com.trillon.camp.campingHome.board.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class BoardForm {

    private Integer bdIdx;
    private String title;
    private LocalDateTime Date;
    private String text;
    private String hashtag;
    private String photo;
    private Integer like;
    private Integer share;
    private Integer comments;
    private String id;
    //private List<MultipartFile> imageFiles;
}
