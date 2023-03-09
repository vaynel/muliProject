package com.trillon.camp.members;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/members")
public class MembersController {
	@GetMapping("/login")
	public void login() { System.out.println("login.jsp"); }
	
	@GetMapping("/signin")
	public void signIn() { System.out.println("signIn.jsp"); }
}
