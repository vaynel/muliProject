package com.trillon.camp.members.service;

<<<<<<< Updated upstream
import org.springframework.security.crypto.password.PasswordEncoder;
=======
>>>>>>> Stashed changes
import org.springframework.stereotype.Service;

import com.trillon.camp.members.dto.Member;
import com.trillon.camp.members.repository.MemberRepository;
<<<<<<< Updated upstream
import com.trillon.camp.members.validator.form.SignUpForm;
=======
>>>>>>> Stashed changes

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
<<<<<<< Updated upstream
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

	
=======
public class MemberServiceImpl implements MemberService {
	
	private final MemberRepository memberRepository;
>>>>>>> Stashed changes

	@Override
	public Member authenticateUser(Member rowMember) {
		
		Member member = memberRepository.selectMemberByUserId(rowMember.getUserId());
<<<<<<< Updated upstream
		
		if(member == null) return null;
=======
		System.out.println(rowMember.getUserId() +" / "+ rowMember.getPassword());
		System.out.println(member.getUserId() +" / "+ member.getPassword());
		if(member==null) return null;
>>>>>>> Stashed changes
		
		return member;
	}

<<<<<<< Updated upstream
}
=======


}
>>>>>>> Stashed changes
