package com.trillon.camp.dummy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.trillon.camp.members.service.MemberService;
import com.trillon.camp.members.validator.form.SignUpForm;

import lombok.RequiredArgsConstructor;

@WebAppConfiguration

//JUNIT의 실행방법을 지정
@RunWith(SpringJUnit4ClassRunner.class)

//테스트 때 사용할 가상의 ApplicationContext를 생성하고 관리
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
@RequiredArgsConstructor
public class TestDummy {

	private final MemberService memberService;
	
	@Test // 더미 user생성 (1~10)
	public void TestMakeUser() { 
		for (int i = 1; i < 11; i++) {

			SignUpForm form = new SignUpForm();
			form.setUserId("user"+i);
			form.setPassword("1234");
			if(i%2==0) form.setGender("m");
			else form.setGender("f");
			form.setTell("010-0000-0000");
			form.setBirth("2000-01-01"); 
			memberService.insertNewMember(form);
			
		}
	}
	
	@Test
	public void TestCreateGroupWithBoardOfCampwithMe() {
		
		
		
		
	}
	

}
