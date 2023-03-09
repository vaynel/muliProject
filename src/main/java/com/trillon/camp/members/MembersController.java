package com.trillon.camp.members;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
=======

>>>>>>> 8a14df44f584564bd5eff3e980697548840257ac
@Controller
@RequestMapping ("/members")
public class MembersController {
	@GetMapping("/login")
	public void login() { System.out.println("login.jsp"); }
	
	@GetMapping("/signIn1")
	public void signIn() { System.out.println("signIn.jsp"); }
}
