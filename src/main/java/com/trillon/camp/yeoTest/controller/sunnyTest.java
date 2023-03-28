package com.trillon.camp.yeoTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping ("/yeo")
@RequiredArgsConstructor
public class sunnyTest {
	
	@GetMapping("/members/login")
	public void loginForm() {};
	
	@GetMapping("/suggest/select")
	public void select() { 
		System.out.println("select.jsp");
	}	
	
	@GetMapping("/schedule/schedulePopUp")
	public void schedulePopUp() { 
		System.out.println("schedulePopUp.jsp");
	}	
	
	@GetMapping("/schedule/calendar")
	public void calendar() { 
		System.out.println("calendar.jsp");
	}
	
	@GetMapping("comewithme/comeWithMeCreateBoard")
	public void comeWithMeCreateBoard() { 
		System.out.println("comeWithMeCreateBoard.jsp");
	}
	
	@GetMapping("comewithme/comeWithMeList")
	public void comeWithMeList() {
		System.out.println("comeWithMeList.jsp");
	}
	
	@GetMapping("campingHome/myPage")
	public void myPage() { 
		System.out.println("myPage.jsp");
	}
	
	@GetMapping("campingHome/boardDetail")
	public void boardDetail() { 
		System.out.println("boardDetail.jsp");
	}
	


}
