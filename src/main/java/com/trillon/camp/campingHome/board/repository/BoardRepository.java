package com.trillon.camp.campingHome.board.repository;

import com.trillon.camp.campingHome.board.dto.Board;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BoardRepository {

    private final Map<Long, Board>store = new HashMap<>();
    private Long sequence = 0L;

    public Board save(Board board){
        board.setBd_idk(++sequence);
        store.put(board.getBd_idk(),board);
        return board;
    }

    public Board findByBd_idk(Long bd_idk){
        return store.get(bd_idk);
    }

}
