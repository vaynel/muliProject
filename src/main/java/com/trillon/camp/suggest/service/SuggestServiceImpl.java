package com.trillon.camp.suggest.service;

import java.util.List;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

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
		campsites = suggestRepository.findCampingByAnswer(answer);
		return campsites;
	}



	
}
