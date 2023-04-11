package com.trillon.camp.campingHome.board.repository;

import com.trillon.camp.campingHome.board.dto.Board;
import com.trillon.camp.campingHome.board.dto.BoardForm;
import com.trillon.camp.campingHome.board.dto.Paging;
import com.trillon.camp.campingHome.board.dto.Reply;
import com.trillon.camp.campingHome.naverShopping.dto.Item;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BoardRepository {


    /**
     *  게시글 저장
     */

    @Insert("insert into campinghome_board(title, text) values(#{title}, #{text})")
    @Options(useGeneratedKeys = true, keyProperty = "bdIdx")  // DB에서 증가되는 bd_idx값을 dto에 bd_idx로 넣어준다.
    int insertBoard(BoardForm boardForm); //앞에 데이터 형태 질문


    /**
     * 전체 게시글 조회(역순으로 최신게시물이 위에 오게하기 위함)
     */
    //@Select("select * from campinghome_board order by bd_idx desc")
    List<BoardForm> selectBoardAll();


    /**
     * 페이징 처리를 위한 전체 게시글 조회 (해당게시물의 첫번째 사진 썸네일 처리)
     */
    @Select("with thumbnail as(" +
            "select min(file_idx)as poster from campinghome_imagefile group by gn_idx" +
            ") " +
            "select * from (select * from campinghome_board a inner join campinghome_imagefile b on a.bd_idx = b.gn_idx)f " +
            "inner join thumbnail t on f.file_idx = t.poster " +
            "order by gn_idx desc limit #{start}, #{cntPerPage}")
    List<Board> selectBoardList(Paging paging);



    /**
     * 특정 게시글 조회
     */
    @Select("select * from campinghome_board where bd_idx = #{bdIdx}")
    BoardForm selectBoardByBdIdx(int bd_idx);


    /**
     * 전체 게시글 갯수 조회
     */
    @Select("select count(1) from campinghome_board")
    int countAllBoard();

    /**
     * 게시글 수정
     */
    @Update("update campinghome_board set title = #{title}, text= #{text} where bd_idx=#{bdIdx}")
    void updateBoard(BoardForm boardForm);

    /**
     * 게시글 삭제
     */
    @Delete("delete from campinghome_board where bd_idx = #{bdIdx}")
    void deleteBoard(int bdIdx);


    /**
     * 제품 등록
     */
    @Insert("insert into campinghome_item(bd_idx,itemname,link,image) values(#{bdIdx},#{itemName},#{link},#{image})")
    @Options(useGeneratedKeys = true, keyProperty = "itemIdx")
    int insertItem(Item item);


    /**
     * 해당 게시판 제품 리스트
     */
    @Select("select * from campinghome_item where bd_idx=#{bdIdx}")
    List<Item> selectItemAll(int bdIdx);

    /**
     * 해당 게시판 제품 수정
     */
    @Update("update campinghome_item set itemName = #{itemName}, link= #{link}, image= #{image} where bd_idx=#{bdIdx}")
    void updateItem(Item item);

    @Delete("delete from campinghome_item where bd_idx = #{bdIdx}")
    void deleteItem(int bdIdx);




    /**
     * 댓글 저장
     */
    @Insert("insert into campinghome_reply(context,bd_Idx) values(#{context},#{bdIdx})")
    @Options(useGeneratedKeys = true, keyProperty = "reIdx")  // DB에서 증가되는 bd_idx값을 dto에 bd_idx로 넣어준다.
    int insertReply(Reply reply); //앞에 데이터 형태 질문


    /**
     * 해당 게시글의 댓글 조회
     */
    @Select("select * from campinghome_reply where bd_idx=#{bdIdx}")
    List<Reply> selectReplyAll(int bdIdx);

    /**
     * 댓글 삭제
     */
    //@delete("delete form reply where re_idx = #{reIdx}")
    //int deleteReply(int reIdx);








}
