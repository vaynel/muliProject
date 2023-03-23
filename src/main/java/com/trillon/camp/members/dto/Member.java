package com.trillon.camp.members.dto;

import lombok.Data;

@Data
public class Member {
	
	private String userId;
	private String name;
	private String password;
	private String tell;
	private String gender;
	private String birth;
	private boolean isLeave;

}
