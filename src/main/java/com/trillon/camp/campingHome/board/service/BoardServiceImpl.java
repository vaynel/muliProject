package com.trillon.camp.campingHome.board.service;

import com.trillon.camp.campingHome.board.dto.BoardForm;
import com.trillon.camp.campingHome.board.dto.Paging;
import com.trillon.camp.campingHome.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


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

    /**
     * 페이징 처리
     */
    @Override
    public Map<String, Object> selectBoardList(int page) {

        int total = boardRepository.countAllBoard();  //총 게시물 수

        Paging paging = Paging.builder()
                .cntPerPage(5)
                .currentPage(page)        //현재 페이지는 파라미터로 넘어온 값
                .total(total)
                .blockCnt(10)
                .build();

        return Map.of("boards",boardRepository.selectBoardList(paging),"paging",paging);
    }

}
