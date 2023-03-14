package com.trillon.camp.suggest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trillon.camp.suggest.dto.Answer;


@Controller
@RequestMapping("suggest")
public class SuggestController {
	
	@GetMapping("select")
	public void select() {
		System.out.println("select.jsp");
	}
	
	@GetMapping("suggestPlace")
	public void suggestPlace(Model model, Answer data) {
		System.out.println("suggsetPlace");			
		
	}
	
	@PostMapping("suggestPlace")
	@ResponseBody
	public void suggestPlace(@RequestBody Answer data,HttpSession session) {
		System.out.println("receiveData"+ data);
	}
}
