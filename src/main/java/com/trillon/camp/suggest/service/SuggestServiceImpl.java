package com.trillon.camp.suggest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.trillon.camp.common.paging.Paging;
import com.trillon.camp.suggest.dto.APIParsing;
import com.trillon.camp.suggest.dto.Answer;
import com.trillon.camp.suggest.dto.Campsite;
import com.trillon.camp.suggest.repository.SuggestRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SuggestServiceImpl  implements SuggestSerivce{

	
	private final SuggestRepository suggestRepository;

	@Override
	public void updateCampingData(APIParsing testData) {
		suggestRepository.insertNewCampingData(testData);
		
	}

	@Override
	public List<Campsite> findCampingByAnswer(Answer answer) {
		List<Campsite> campsites;
		answer.setInduty("%"+answer.getInduty()+"%");
		// lctCl이 무관이 아닌경우
		if(!answer.getLctCl().equals("무관")) {
			answer.setLctCl("%"+answer.getLctCl()+"%");
			System.out.println("1");
			campsites = suggestRepository.findCampingByAnswer(answer);
			return campsites;
		}
		// lctCl이 무관인 경우
		campsites = suggestRepository.findCampingByAnswerWithoutInduty(answer);
		return campsites;
	}

	@Override
	public List<Campsite> selectAllCampsite() {
		
		return suggestRepository.selectAllCampsite();
	}

	@Override
	public Map<String, Object> selectCampsiteByPage(int page) {
		int total = suggestRepository.countAllCampsite();
		
		Paging paging = Paging.builder()
				.cntPerPage(3)
				.currentPage(page)
				.total(total)
				.blockCnt(10)
				.build();
		
		return Map.of("campsites",suggestRepository.selectCampsiteByPage(paging),"paging",paging);
	}

	@Override
	public Map<String, Object> findCampingByAnswerWithPage(Answer answer, int page) {
		int total;
		
		answer.setInduty("%"+answer.getInduty()+"%");
		if(answer.getLctCl().equals("무관")) {total = suggestRepository.countCampsiteByAnswerWithoutLctCl(answer);}
		else {
			answer.setLctCl("%"+answer.getLctCl()+"%");
			total = suggestRepository.countCampsiteByAnswer(answer);
		}
		
		Paging paging = Paging.builder()
				.cntPerPage(3)
				.currentPage(page)
				.total(total)
				.blockCnt(10)
				.build();
		Map<String,Object> command = new HashMap<String, Object>();
		command.put("answer", answer);
		command.put("paging",paging);
		
		if(!answer.getLctCl().equals("무관")) {
			return Map.of("campsites",suggestRepository.selectCampsiteByAnswerWithPage(command),"paging",paging);
		}
		return Map.of("campsites",suggestRepository.selectCampsiteByAnswerWithPageWithoutLctCl(command),"paging",paging);
		
		
		
	}



	
}
