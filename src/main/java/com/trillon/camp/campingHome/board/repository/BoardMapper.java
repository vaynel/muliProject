package com.trillon.camp.campingHome.board.repository;


import com.trillon.camp.campingHome.board.dto.BoardForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    void save(BoardForm boardForm);

}
