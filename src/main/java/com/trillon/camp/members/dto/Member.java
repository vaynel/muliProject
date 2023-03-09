package com.trillon.camp.members.dto;

import lombok.Data;

@Data
public class Member {
	
	private String userId;
	private String password;
	private String email;
	private String grade;
	private String tell;
	private boolean isLeave;

}
