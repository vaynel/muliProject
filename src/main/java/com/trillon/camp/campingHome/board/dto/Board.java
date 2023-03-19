package com.trillon.camp.campingHome.board.dto;

import lombok.Data;

import java.util.List;

@Data
public class Board {

    private Integer bdIdx;
    private String id;
    private String title;
    private String text;
    private String hashtag;
    private List<UploadFile> imageFiles;
}
