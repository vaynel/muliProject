package com.trillon.camp.members.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< Updated upstream
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
=======
import org.springframework.web.bind.annotation.GetMapping;
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

<<<<<<< Updated upstream

import com.trillon.camp.members.dto.Member;
import com.trillon.camp.members.service.MemberService;
import com.trillon.camp.members.validator.SignUpFormValidator;
import com.trillon.camp.members.validator.form.SignUpForm;
=======
import com.trillon.camp.members.dto.Member;
import com.trillon.camp.members.service.MemberService;
>>>>>>> Stashed changes

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping ("/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
<<<<<<< Updated upstream
	private final SignUpFormValidator signUpFormValidator;


	Logger logger = LoggerFactory.getLogger(this.getClass());

	@InitBinder(value = "signUpForm")
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(signUpFormValidator);
	}

	

	@GetMapping("/login")
	public void loginForm() {};

	@PostMapping("/login") 
	public String login(Member member, HttpSession session, RedirectAttributes redirectAttr) {
		
		
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
		return "redirect:/index";
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
=======

	Logger log = LoggerFactory.getLogger(this.getClass());
<<<<<<< HEAD
		
	@GetMapping("/signin")
	public void signin() { System.out.println("signin.jsp"); }
	
=======


>>>>>>> e91d1b2264740c3f63e9fadd9d30d0229477ca42
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
<<<<<<< HEAD

//	@GetMapping("/signIn")
//=======
	
	
//	@GetMapping("/signin")
//>>>>>>> Stashed changes
//	public void signIn() { System.out.println("signin.jsp"); }
//}
=======
//
//	//@GetMapping("/signIn")
//=======
//
//
//	//@GetMapping("/signin")
//>>>>>>> Stashed changes
//	//public void signIn() { System.out.println("signin.jsp"); }
////}
>>>>>>> e91d1b2264740c3f63e9fadd9d30d0229477ca42
>>>>>>> Stashed changes
