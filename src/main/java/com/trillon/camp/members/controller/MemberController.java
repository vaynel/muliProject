package com.trillon.camp.members.controller;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trillon.camp.members.dto.Account;
import com.trillon.camp.members.dto.Member;
import com.trillon.camp.members.dto.MemberGoogle;
import com.trillon.camp.members.service.MemberService;
import com.trillon.camp.members.validator.SignUpFormValidator;
import com.trillon.camp.members.validator.form.SignUpForm;

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

	@ResponseBody
	@PostMapping("/afterlogin") 
	public String login(Member member, HttpSession session) {

		if(member.getUserId().equals("") | member.getPassword().equals("")) {
			
			return "failEmpty";
		} 
		Member auth = memberService.authenticateUser(member);
		System.out.println("확인" + auth);
		
		
		if (auth == null) {
			
			System.out.println(" 아니면 auth = null");
			return "failWrong";
		}

		
		
		
		Account account = new Account();
		account.setUserId(auth.getUserId());
		account.setPassword(auth.getPassword());
		account.setAuthority("ROLE_USER");
		
		
		SecurityContext context = SecurityContextHolder.createEmptyContext();
		Authentication authentication = new TestingAuthenticationToken(account.getUserId(), account.getPassword(),account.getAuthority());
		context.setAuthentication(authentication);
		
		SecurityContextHolder.setContext(context);
		
		session.setAttribute("loginId", account.getUserId());
		
		System.out.println(authentication);
		System.out.println(context);
		
		return "successLogin";
	}

	
	
	@ResponseBody
	@PostMapping("/google")
	public String google(HttpSession session, MemberGoogle member) {
		System.out.println("google 확인");
		System.out.println(member);
		
		if(memberService.idCheckGoogle(member.getUserId()))
		{	
			
			session.setAttribute("googleDataUserId", member.getUserId());
			session.setAttribute("googleDataName", member.getName());
			session.setAttribute("googleDataEmail", member.getEmail());
			return "firstLogin";
			
		}
		else {
			
			Account account = new Account();
			account.setUserId(member.getUserId());
			account.setPassword("googleUser");
			account.setAuthority("ROLE_USER");
			
			
			SecurityContext context = SecurityContextHolder.createEmptyContext();
			Authentication authentication = new TestingAuthenticationToken(account.getUserId(), account.getPassword(),account.getAuthority());
			context.setAuthentication(authentication);
			
			SecurityContextHolder.setContext(context);
			
			session.setAttribute("loginId", account.getUserId());
			
			System.out.println(authentication);
			System.out.println(context);
			

			return "successLogin";
			
		}
		
	
	}
	
	@GetMapping("/googleSignin")
	public void googleSignin() {
	}
	
	@ResponseBody
	@PostMapping("/googleSignin")
	public String googleSignin(HttpSession session, MemberGoogle member) {
		System.out.println("구글회원가입정보 확인");
		member.setUserId((String) session.getAttribute("googleDataUserId"));
		member.setName((String) session.getAttribute("googleDataName"));
		member.setEmail((String) session.getAttribute("googleDataEmail"));
		System.out.println(member);
		memberService.insertNewMemberGoogle(member);
		
		return "success";
	}
	

	
	
	
	
	@GetMapping("/signin")
	public void signin() {
	}

	@ResponseBody
	@PostMapping("/idCheck") 
	public String idCheck(Member member, HttpSession session) {
		
		System.out.println("idcheck 넘어오는지 확인");
		
		if(memberService.idCheck(member.getUserId())) {
			
			System.out.println("notToExist");
			return "notToExist";
			
		}
		else {
			System.out.println("Exist");
			return "exist";
		}
		
		
	}
	
	@ResponseBody
	@PostMapping("/signInData")
	public String signin(HttpSession session, SignUpForm form) {

		System.out.println(form);

		if(!memberService.idCheck(form.getUserId()))
		{
			return "idError";
		}
		
		System.out.println(form);
		
		memberService.insertNewMember(form);

		if(!memberService.idCheck(form.getUserId())){
			return "success";
		}
		else
		return "fail";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginId");
		SecurityContextHolder.clearContext();
		System.out.println("로그아웃");
		return "redirect:/members/login";
	}
	
	
	@GetMapping("/myPage")
	public void myPage(HttpSession session,
			Model model) {
		String userId =(String)session.getAttribute("loginId");
		System.out.println("get myPage userId -> "+ userId);
		Member member = new Member();
		
		// 일반 로그인시 
		if((member= memberService.idCheckRetrunMember(userId))!=null ) {
			model.addAttribute("member", member);
			model.addAttribute("age",getAge(member.getBirth()));
			return; 
		}
		
		else if((member= memberService.idCheckGoogleReturnMember(userId))!=null ) {
			model.addAttribute("member", member);
			model.addAttribute("age",getAge(member.getBirth()));
			return; 
		}
		
		
		
		
	}
	
	
	
	
	
	public int getAge(String birth)
	{
			int birthYear = Integer.valueOf(birth.substring(0, 4));
			int birthMonth = Integer.valueOf(birth.substring(5, 7));
			int birthDay= Integer.valueOf(birth.substring(8, 10));
			System.out.println(birthYear +"-"+birthMonth +"-"+birthDay);
			
			
			
	        Calendar current = Calendar.getInstance();
	        int currentYear  = current.get(Calendar.YEAR);
	        int currentMonth = current.get(Calendar.MONTH) + 1;
	        int currentDay   = current.get(Calendar.DAY_OF_MONTH);
	      
	        int age = currentYear - birthYear;
	        // 생일 안 지난 경우 -1
	        if (birthMonth * 100 + birthDay > currentMonth * 100 + currentDay) 
	            age--;
	      
	        return age;
	}
	
	

}
