package com.trillon.camp.members.service;

import com.trillon.camp.members.dto.Member;

public interface MemberService {

	Member authenticateUser(Member member);

}
