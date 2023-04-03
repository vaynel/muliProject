package com.trillon.camp.campingHome.board.service;

import com.trillon.camp.campingHome.board.dto.BoardForm;
import com.trillon.camp.campingHome.board.dto.Reply;
import org.json.simple.parser.ParseException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public interface BoardService {
    int insertBoard(BoardForm boardForm,String itemName,List<MultipartFile> files) throws ParseException, IOException;

    int insertReply(Reply reply);

    List<BoardForm> selectBoardAll();

    List<Reply> selectReplyAll(int bdIdx);

    Map<String, Object> selectBoardByBdIdx(int bdIdx);

    Map<String, Object> selectBoardList(int page);




}