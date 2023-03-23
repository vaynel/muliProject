package com.trillon.camp.campingHome.board.repository;

import com.trillon.camp.campingHome.board.dto.Board;
import com.trillon.camp.campingHome.board.dto.BoardForm;
import com.trillon.camp.campingHome.board.dto.Paging;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BoardRepository {

    //@Insert("insert into campinghome_board(title, date, content, hashtag, photo, like, share, comment_num, id) " +
    //        "values(#{title}, #{date}, #{text}, #{hashtag}, #{photo}, #{like}, #{share}, #{comments},#{id})")

    /**
     *  게시글 저장
     */

    @Insert("insert into test(title, text, hashtag) values(#{title}, #{text}, #{hashtag})")
    @Options(useGeneratedKeys = true, keyProperty = "bdIdx")  // DB에서 증가되는 bd_idx값을 dto에 bd_idx로 넣어준다.
    Integer insertBoard(BoardForm boardForm); //앞에 데이터 형태 질문

    //@Select("select * from campinghome_board where")

    /**
     * 전체 게시글 조회(역순으로 최신게시물이 위에 오게하기 위함)
     */
    //@Select("select * from test order by bd_idx desc")
    List<BoardForm> selectBoardAll();

    /**
     * 특정 게시글 조회
     */
    @Select("select * from test where bd_idx = #{bdIdx}")
    BoardForm selectBoardByBdIdx(long bd_idx);

    
    /**
     * 페이징 처리를 위한 젠체 게시글 조회
     */
    @Select("select * from test order by bd_idx desc limit #{start}, #{cntPerPage}")
    List<Board> selectBoardList(Paging paging);




    /**
     * 전체 게시글 갯수 조회
     */
    @Select("select count(1) from test")
    int countAllBoard();
}

