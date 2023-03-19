package com.trillon.camp.campingHome.board.service;

import com.trillon.camp.campingHome.board.dto.BoardForm;

import java.util.List;



public interface BoardService {
    int insertBoard(BoardForm boardForm);
    List<BoardForm> selectBoardAll();
    BoardForm selectBoardByBdIdx(int bdIdx);
}
