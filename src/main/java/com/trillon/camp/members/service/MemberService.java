package com.trillon.camp.members.service;

<<<<<<< Updated upstream

import com.trillon.camp.members.dto.Member;
import com.trillon.camp.members.validator.form.SignUpForm;

public interface MemberService {

	boolean existUser(String userId);

	void insertNewMember(SignUpForm form);

=======
import com.trillon.camp.members.dto.Member;

public interface MemberService {

>>>>>>> Stashed changes
	Member authenticateUser(Member member);

}
