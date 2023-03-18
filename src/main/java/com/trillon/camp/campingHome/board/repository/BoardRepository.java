package com.trillon.camp.campingHome.board.repository;

import com.trillon.camp.campingHome.board.dto.Board;
import com.trillon.camp.campingHome.board.dto.BoardForm;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface BoardRepository {

    //@Insert("insert into campinghome_board(title, date, content, hashtag, photo, like, share, comment_num, id) " +
    //        "values(#{title}, #{date}, #{text}, #{hashtag}, #{photo}, #{like}, #{share}, #{comments},#{id})")

    /**
     *  게시글 저장
     */

    @Insert("insert into test(title, text, hashtag) values(#{title}, #{text}, #{hashtag})")
    @Options(useGeneratedKeys = true, keyProperty = "bd_idx")  // DB에서 증가되는 bd_idx값을 dto에 bd_idx로 넣어준다.
    Integer insertBoard(BoardForm boardForm); //앞에 데이터 형태 질문

    //@Select("select * from campinghome_board where")

    /**
     * 전체 게시글 조회
     */
    @Select("select * from campinghome_board")
    public List<BoardForm> selectBoardAll();

    //@Select("select * from campinghome_board where bd_idx = {bd_idx}")

    /**
     * 특정 게시글 조회
     */
    @Select("select * from test where bd_idx = #{bd_idx}")
    BoardForm selectBoardByBdIdx(long bd_idx);

}

