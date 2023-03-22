package com.trillon.camp.members.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Principal {
	
	private String userId;
	private String password;
	private String email;
	private String tell;
	private String grade;

	public Principal(Member member) {
		this.userId = member.getUserId();
		this.password = member.getPassword();
		this.email = member.getEmail();
		this.tell = member.getTell();
		this.grade = member.getGrade();
	}

	
	
}
