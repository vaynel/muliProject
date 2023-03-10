package com.trillon.camp.suggest.service;

import org.springframework.stereotype.Service;

import com.trillon.camp.suggest.repository.SuggestRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SuggestServiceImpl  implements SuggestSerivce{

	
	private final SuggestRepository suggestRepository;
	
	
}
