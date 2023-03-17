package com.trillon.camp.campingHome.board.service;

import com.trillon.camp.campingHome.board.dto.BoardForm;
import com.trillon.camp.campingHome.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    /**
     * 게시글 등록
     */
    @Override
    public int insertBoard(BoardForm boardForm){
        boardRepository.insertBoard(boardForm);
        int bd_idx = boardForm.getBd_idx();  // 해당 insert의 bd_idx값
        return bd_idx;
    }

    /**
     * 전체 게시글 조회
     */
    @Override
    public List<BoardForm> selectBoardAll() {
        return boardRepository.selectBoardAll();
    }

    /**
     *  특정 게시글 조회
     */
    @Override
    public BoardForm selectBoardByBd_idx(int bd_idx) {
        BoardForm boardForm = boardRepository.selectBoardByBdIdx(bd_idx);
        return boardForm;
    }

}
