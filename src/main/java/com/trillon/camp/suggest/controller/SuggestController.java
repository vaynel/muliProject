package com.trillon.camp.suggest.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trillon.camp.suggest.dto.Answer;
import com.trillon.camp.suggest.dto.Campsite;
import com.trillon.camp.suggest.service.SuggestSerivce;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("suggest")
@RequiredArgsConstructor
public class SuggestController {
	
	private final SuggestSerivce suggestService;
	
	@GetMapping("select")
	public void select() { 
		System.out.println("select.jsp");
	}
	
	
	/*
	 * @PostMapping("select")
	 * 
	 * @ResponseBody public void receiveDate(@RequestBody HashMap<Integer,
	 * APIParsing> data) {
	 * 
	 * APIParsing testData;
	 * 
	 * for (Map.Entry<Integer, APIParsing> entry : data.entrySet()) { testData =
	 * entry.getValue(); suggestService.updateCampingData(testData); } }
	 */
	
	
	
	@GetMapping("suggestPlace")
	public void suggestPlace(HttpSession session,Model model) {
		System.out.println("suggsetPlace");
		List<Campsite> campsites = (List<Campsite>) session.getAttribute("campsites");
		model.addAttribute("campsites", campsites);
		for (Campsite campsite : campsites) {
			System.out.println(campsite);
		}
		
	}
	
	@PostMapping("select")
	@ResponseBody
	public void PostSelect(@RequestBody Answer answer,HttpSession session) {		
		
		List<Campsite> campsites;
		campsites=suggestService.findCampingByAnswer(answer);
		if(campsites!=null) {
			System.out.println("캠핑장 검색 성공");
			session.setAttribute("campsites", campsites);
		}
		else {
			System.out.println("캠핑장 검색 실패");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}
