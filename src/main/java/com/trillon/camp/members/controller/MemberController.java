package com.trillon.camp.members.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.trillon.camp.members.dto.Member;
import com.trillon.camp.members.service.MemberService;
import com.trillon.camp.members.validator.SignUpFormValidator;
import com.trillon.camp.members.validator.form.SignUpForm;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping ("/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	private final SignUpFormValidator signUpFormValidator;


	Logger logger = LoggerFactory.getLogger(this.getClass());

	@InitBinder(value = "signUpForm")
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(signUpFormValidator);
	}

	

	@GetMapping("/login")
	public void loginForm() {};

	@PostMapping("/afterlogin") 
	public String login(Member member, HttpSession session, RedirectAttributes redirectAttr) {
		
		System.out.println("넘어는오냐구요");
		if(member.getUserId().equals("") | member.getPassword().equals("")) {
			redirectAttr.addFlashAttribute("msg", "아이디나 비밀번호를 입력해주세요.");
			return "redirect:/members/login";
		} 
		
		Member auth = memberService.authenticateUser(member);
		System.out.println("확인" + auth);
		
		
		if (auth == null) {
			redirectAttr.addFlashAttribute("msg", "아이디나 비밀번호가 틀렸습니다.");
			System.out.println(" 아니면 auth = null");
			return "redirect:/members/login";
		}

		
		session.setAttribute("auth", auth);
		return "redirect:/schedule/calendar";
	}

	@GetMapping("/signin")
	public void registForm() {
	}

	@PostMapping("/signin")
	public String regist(HttpSession session, SignUpForm form) {

		session.setAttribute("form", form);

		memberService.insertNewMember(form);

		return "redirect:/members/login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("auth");
		return "redirect:/members/login";
	}
}
