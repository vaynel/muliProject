package com.trillon.camp.suggest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("suggest")
public class suggestController {
	
	@GetMapping("select")
	public void select() {
		System.out.println("select.jsp");
	}
	
	@GetMapping("suggestPlace")
	public void suggestPlace() {
		System.out.println("suggsetPlace");
		
	}
	
	
}
