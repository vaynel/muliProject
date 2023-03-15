package com.trillon.camp.comewithme.service;

import java.util.List;
import java.util.Map;

import com.trillon.camp.comewithme.dto.ComeWithMeBoard;

public interface ComeWithMeService {

	Map<String, Object> selectBoardList(int page);

	List<ComeWithMeBoard> selectBoardAll();

}
