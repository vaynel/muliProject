package com.trillon.camp.campingHome.board.service;

import com.trillon.camp.campingHome.board.dto.BoardForm;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


public interface BoardService {
    int insertBoard(BoardForm boardForm,List<MultipartFile> files);
    List<BoardForm> selectBoardAll();
    BoardForm selectBoardByBdIdx(int bdIdx);
    Map<String, Object> selectBoardList(int page);
}
