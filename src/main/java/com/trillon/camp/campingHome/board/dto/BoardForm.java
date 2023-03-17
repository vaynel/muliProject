package com.trillon.camp.campingHome.board.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;


@Data
public class BoardForm {

    private Integer bd_idx;
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
