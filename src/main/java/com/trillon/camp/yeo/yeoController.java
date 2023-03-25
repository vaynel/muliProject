package com.trillon.camp.yeo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/yeo")
public class yeoController {

	
	@GetMapping("/suggest/select")
	public void index() {
	}
	
	
	@GetMapping("/comewithme/comeWithMeList")
	public void comwithmeList() {
		
	}
	
	
}
