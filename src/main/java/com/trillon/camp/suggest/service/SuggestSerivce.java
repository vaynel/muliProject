package com.trillon.camp.suggest.service;

import java.util.List;

import com.trillon.camp.suggest.dto.APIParsing;
import com.trillon.camp.suggest.dto.Answer;
import com.trillon.camp.suggest.dto.Campsite;

public interface SuggestSerivce {

	void updateCampingData(APIParsing testData);

	List<Campsite> findCampingByAnswer(Answer answer);


}
