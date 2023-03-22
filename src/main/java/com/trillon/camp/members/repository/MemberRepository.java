package com.trillon.camp.members.repository;

<<<<<<< Updated upstream
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import com.trillon.camp.members.dto.Member;
import com.trillon.camp.members.validator.form.SignUpForm;
=======
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.trillon.camp.members.dto.Member;
>>>>>>> Stashed changes


@Repository
public interface MemberRepository {

	
<<<<<<< Updated upstream
	@Select("SELECT * FROM camp.member WHERE id = #{userId}")
	Member selectMemberByUserId(String userId);

	@Insert("insert into camp.member (id, name, password, tell, gender, birth, role_grad) " + " values(#{userId}, #{name}, #{password},#{tell},#{gender},#{birth},'user')")
	void insertMember(SignUpForm form);
=======
	@Select("SELECT * FROM member WHERE user_id = #{userId}")
	Member selectMemberByUserId(String userId);

>>>>>>> Stashed changes
	
}
