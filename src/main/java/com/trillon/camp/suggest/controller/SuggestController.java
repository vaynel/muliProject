package com.trillon.camp.suggest.controller;

<<<<<<< Updated upstream
import java.util.List;

=======
>>>>>>> Stashed changes
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trillon.camp.suggest.dto.Answer;
<<<<<<< Updated upstream
import com.trillon.camp.suggest.dto.Campsite;
import com.trillon.camp.suggest.service.SuggestSerivce;

import lombok.RequiredArgsConstructor;
=======
>>>>>>> Stashed changes


@Controller
@RequestMapping("suggest")
<<<<<<< Updated upstream
@RequiredArgsConstructor
public class SuggestController {
	
	private final SuggestSerivce suggestService;
	
	@GetMapping("select")
	public void select() { 
=======
public class SuggestController {
	
	@GetMapping("select")
	public void select() {
>>>>>>> Stashed changes
		System.out.println("select.jsp");
	}
	
	
<<<<<<< Updated upstream
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
=======
	@PostMapping("select")
	@ResponseBody
	public void receiveDate(@RequestBody String data) {
		System.out.println(data);
	}
>>>>>>> Stashed changes
	
	
	
	@GetMapping("suggestPlace")
<<<<<<< Updated upstream
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
=======
	public void suggestPlace(Model model, Answer data) {
		System.out.println("suggsetPlace");			
		
	}
	
	@PostMapping("suggestPlace")
	@ResponseBody
	public void suggestPlace(@RequestBody String data,HttpSession session) {
		System.out.println("receiveData"+ data);
	}
>>>>>>> Stashed changes
}
