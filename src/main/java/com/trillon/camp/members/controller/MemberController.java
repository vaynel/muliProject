package com.trillon.camp.members.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.trillon.camp.members.dto.Member;
import com.trillon.camp.members.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping ("/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	Logger log = LoggerFactory.getLogger(this.getClass());


	@GetMapping("/login")
	public void login() {
		System.out.println("login.jsp");
	}

	@PostMapping("/login")
	public String loginUser(Member member, HttpSession session, RedirectAttributes rAttributes, String test) {
		System.out.println(test);
		System.out.println(member);
		Member auth = memberService.authenticateUser(member);

		if (auth == null) {
			System.out.println("auth=null");
			return "redirect:/members/login";
		}
		System.out.println(auth);

		session.setAttribute("auth", auth);
		return "redirect:/index";
	}
}
//<<<<<<< Updated upstream
//
//	//@GetMapping("/signIn")
//=======
//
//
//	//@GetMapping("/signin")
//>>>>>>> Stashed changes
//	//public void signIn() { System.out.println("signin.jsp"); }
////}
