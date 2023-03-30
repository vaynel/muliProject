package com.trillon.camp.members.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.trillon.camp.members.dto.Member;
import com.trillon.camp.members.repository.MemberRepository;
import com.trillon.camp.members.validator.form.SignUpForm;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
	
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public boolean existUser(String userId) {
		Member member = memberRepository.selectMemberByUserId(userId);
		return member != null;
	}

	@Override
	public void insertNewMember(SignUpForm form) {
		form.setPassword(passwordEncoder.encode(form.getPassword()));
		memberRepository.insertMember(form);
	}

	

	@Override
	public Member authenticateUser(Member rowMember) {
		
		System.out.println("rowMember확인"+rowMember);
		
		Member member = memberRepository.selectMemberByUserId(rowMember.getUserId());
		member.setUserId(rowMember.getUserId());
		
		if(member == null) return null;
		else if(!passwordEncoder.matches(rowMember.getPassword(), member.getPassword())) {
			return null;
		}
		else
			System.out.println("service확인"+member);
		return member;
	}

	@Override
	public boolean idCheck(String userId) {
		Member member = memberRepository.selectMemberByUserId(userId);
		
		if(member == null) return true;
		
		return false;
		
	
	}



}