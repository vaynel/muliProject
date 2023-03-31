package com.trillon.camp.members.service;


import com.trillon.camp.members.dto.Member;
import com.trillon.camp.members.dto.MemberGoogle;
import com.trillon.camp.members.validator.form.SignUpForm;

public interface MemberService {

	boolean existUser(String userId);

	void insertNewMember(SignUpForm form);

	void insertNewMemberGoogle(MemberGoogle member);
	
	Member authenticateUser(Member member);

	boolean idCheck(String userId);
	
	boolean idCheckGoogle(String userId);
}
