package com.trillon.camp.campingHome.board.dto;

import lombok.Data;

import java.util.List;

@Data
public class Board {

    private long bd_idx;
    private String id;
    private String title;
    private String text;
    private String hashtag;
    private List<UploadFile> imageFiles;
}
