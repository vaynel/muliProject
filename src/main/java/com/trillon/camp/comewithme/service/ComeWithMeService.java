package com.trillon.camp.comewithme.service;

import java.util.List;
import java.util.Map;

import com.trillon.camp.comewithme.common.Paging;
import com.trillon.camp.comewithme.dto.Answer;
import com.trillon.camp.comewithme.dto.ComeWithMeBoard;


public interface ComeWithMeService {

	void insertBoard(ComeWithMeBoard board);

	Map<String, Object> selectBoardList(int page); // 목록전체보기

	Map<String, Object> selectBoardContentByBdIdx(int bdIdx); // 상세보기

	List<ComeWithMeBoard> selectMatchList(Answer answer);

	
	

}
