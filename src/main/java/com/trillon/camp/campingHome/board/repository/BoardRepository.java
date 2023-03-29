package com.trillon.camp.campingHome.board.repository;

import com.trillon.camp.campingHome.board.dto.Board;
import com.trillon.camp.campingHome.board.dto.BoardForm;
import com.trillon.camp.campingHome.board.dto.Paging;
import com.trillon.camp.campingHome.board.dto.Reply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BoardRepository {


    /**
     *  게시글 저장
     */

    @Insert("insert into test(title, text, hashtag) values(#{title}, #{text}, #{hashtag})")
    @Options(useGeneratedKeys = true, keyProperty = "bdIdx")  // DB에서 증가되는 bd_idx값을 dto에 bd_idx로 넣어준다.
    Integer insertBoard(BoardForm boardForm); //앞에 데이터 형태 질문

    /**
     * 댓글 저장
     */
    @Insert("insert into reply(context,bd_Idx) values(#{context},#{bdIdx})")
    @Options(useGeneratedKeys = true, keyProperty = "reIdx")  // DB에서 증가되는 bd_idx값을 dto에 bd_idx로 넣어준다.
    Integer insertReply(Reply reply); //앞에 데이터 형태 질문


    /**
     * 전체 게시글 조회(역순으로 최신게시물이 위에 오게하기 위함)
     */
    //@Select("select * from test order by bd_idx desc")
    List<BoardForm> selectBoardAll();

    /**
     * 해당 게시글의 댓글 조회
     */
    @Select("select * from reply where bd_idx=#{bdIdx}")
    List<Reply> selectReplyAll(int bdIdx);


    /**
     * 특정 게시글 조회
     */
    @Select("select * from test where bd_idx = #{bdIdx}")
    BoardForm selectBoardByBdIdx(long bd_idx);

    
    /**
     * 페이징 처리를 위한 전체 게시글 조회 (해당게시물의 첫번째 사진 썸네일 처리)
     */

    @Select("with thumbnail as(" +
            "select min(file_idx)as poster from test2 group by gn_idx" +
            ") " +
            "select * from test2 f inner join thumbnail b on f.file_idx = b.poster " +
            "order by gn_idx desc limit #{start}, #{cntPerPage}")
    List<Board> selectBoardList(Paging paging);


    /**
     * 전체 게시글 갯수 조회
     */
    @Select("select count(1) from test")
    int countAllBoard();
}
