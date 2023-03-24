package com.trillon.camp.members.service;


import com.trillon.camp.members.dto.Member;
import com.trillon.camp.members.validator.form.SignUpForm;

public interface MemberService {

	boolean existUser(String userId);

	void insertNewMember(SignUpForm form);

	Member authenticateUser(Member member);

	boolean idCheck(String userId);
}
