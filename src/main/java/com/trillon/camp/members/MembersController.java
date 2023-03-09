package com.trillon.camp.members;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping ("/members")
public class MembersController {
	@GetMapping("/login")
	public void login() { System.out.println("login.jsp"); }
	
	@GetMapping("/signIn")
	public void signIn() { System.out.println("signin.jsp"); }
}
