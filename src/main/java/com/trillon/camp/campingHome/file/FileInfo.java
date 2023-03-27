package com.trillon.camp.campingHome.file;

import com.trillon.camp.campingHome.board.dto.Board;
import lombok.Data;

@Data
public class FileInfo {

    private String originFileName;
    private String renameFileName;
    private String savePath;
    private int gnIdx;

    public static String STORAGE_PATH = "C:/campingHome/";

    public String getFullPath() {
        return savePath + renameFileName;
    }
}
