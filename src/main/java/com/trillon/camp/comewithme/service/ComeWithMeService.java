package com.trillon.camp.comewithme.service;

import java.util.Map;

import com.trillon.camp.comewithme.common.Paging;
import com.trillon.camp.comewithme.dto.Answer;


public interface ComeWithMeService {

	Map<String, Object> selectBoardList(int page);

	Map<String, Object> selectMatchList(Answer answer);

}
