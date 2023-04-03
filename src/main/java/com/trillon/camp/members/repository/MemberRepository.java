package com.trillon.camp.members.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import com.trillon.camp.members.dto.Member;
import com.trillon.camp.members.dto.MemberGoogle;
import com.trillon.camp.members.validator.form.SignUpForm;


@Repository
public interface MemberRepository {

	
	@Select("SELECT * FROM camp.member WHERE userid = #{userId}")
	Member selectMemberByUserId(String userId);
	
	@Select("SELECT * FROM camp.member_google WHERE userid = #{userId}")
	Member selectMemberByUserIdGoogle(String userId);


	@Insert("insert into camp.member (userid, name, password, tell, gender, birth, role_grad) " + " values(#{userId}, #{name}, #{password},#{tell},#{gender},#{birth},'user')")
	void insertMember(SignUpForm form);
	
	@Insert("insert into camp.member_google (userid, name, tell, gender, birth, role_grad, email) " + " values(#{userId}, #{name},#{tell},#{gender},#{birth},'user',#{email})")
	void insertMemberGoogle(MemberGoogle member);
	
}
