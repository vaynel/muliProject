package com.trillon.camp.members.service;

import org.springframework.stereotype.Service;

import com.trillon.camp.members.dto.Member;
import com.trillon.camp.members.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private final MemberRepository memberRepository;

	@Override
	public Member authenticateUser(Member rowMember) {
		
		Member member = memberRepository.selectMemberByUserId(rowMember.getUserId());
		System.out.println(rowMember.getUserId() +" / "+ rowMember.getPassword());
		System.out.println(member.getUserId() +" / "+ member.getPassword());
		if(member==null) return null;
		
		return member;
	}



}
