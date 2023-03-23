package com.trillon.camp.members.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import com.trillon.camp.members.dto.Member;
import com.trillon.camp.members.validator.form.SignUpForm;


@Repository
public interface MemberRepository {

	
	@Select("SELECT * FROM camp.member WHERE id = #{userId}")
	Member selectMemberByUserId(String userId);

	@Insert("insert into camp.member (id, name, password, tell, gender, birth, role_grad) " + " values(#{userId}, #{name}, #{password},#{tell},#{gender},#{birth},'user')")
	void insertMember(SignUpForm form);
	
}
