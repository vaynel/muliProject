package com.trillon.camp.members.repository;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.trillon.camp.members.dto.Member;


@Repository
public interface MemberRepository {

	
	@Select("SELECT * FROM member WHERE user_id = #{userId}")
	Member selectMemberByUserId(String userId);

	
}
