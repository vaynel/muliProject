package com.trillon.camp.comewithme.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.trillon.camp.comewithme.dto.Answer;
import com.trillon.camp.comewithme.dto.ComeWithMeBoard;


public interface ComeWithMeService {

	void insertBoard(ComeWithMeBoard board, List<MultipartFile> files);

	Map<String, Object> selectBoardList(int page); // 목록전체보기

	Map<String, Object> selectBoardContentByBdIdx(int bdIdx); // 상세보기

	List<ComeWithMeBoard> selectMatchList(Answer answer); // 매칭
	
	void updateBoard(ComeWithMeBoard board); // 게시글 수정

	void deleteBoardByBdIdx(int bdIdx);  // 게시글 삭제



	
	

}
