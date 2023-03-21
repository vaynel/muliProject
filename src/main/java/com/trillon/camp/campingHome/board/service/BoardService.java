package com.trillon.camp.campingHome.board.service;

import com.trillon.camp.campingHome.board.dto.BoardForm;

import java.util.List;
import java.util.Map;


public interface BoardService {
    int insertBoard(BoardForm boardForm);
    List<BoardForm> selectBoardAll();
    BoardForm selectBoardByBdIdx(int bdIdx);
    Map<String, Object> selectBoardList(int page);
}
