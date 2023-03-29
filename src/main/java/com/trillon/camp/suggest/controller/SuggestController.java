package com.trillon.camp.suggest.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("select2")
	public void selelct2(Model model,
			@RequestParam(value ="page", required = false,defaultValue = "1") int page,
			HttpSession session) {
		System.out.println("최종페이지");
		if(session.getAttribute("campsites")==null) System.out.println("session에 없음");
		if(model.getAttribute("campsites")==null) {
			System.out.println("model에 campsites가 없음");
			model.addAllAttributes(suggestService.selectCampsiteByPage(page));
		}
		
		
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
	
	@PostMapping("select2")
	public String PostSelect(@RequestBody Answer answer,
			@RequestParam(value = "page", required = false,defaultValue = "1" ) int page,
			HttpSession session,
			Model model,
			RedirectAttributes redirectAttributes) {		
		System.out.println(answer);
		
		model.addAllAttributes(suggestService.findCampingByAnswerWithPage(answer,page));
		System.out.println(model.getAttribute("campsites"));
		return "success";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}
