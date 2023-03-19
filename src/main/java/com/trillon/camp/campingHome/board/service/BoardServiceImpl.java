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
        int bdIdx = boardForm.getBdIdx();  // 해당 insert의 bd_idx값
        return bdIdx;
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
    public BoardForm selectBoardByBdIdx(int bdIdx) {
        BoardForm boardForm = boardRepository.selectBoardByBdIdx(bdIdx);
        return boardForm;
    }

}
