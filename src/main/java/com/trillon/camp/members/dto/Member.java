package com.trillon.camp.members.dto;

import lombok.Data;

@Data
public class Member {
	
	private String userId;
<<<<<<< Updated upstream
	private String name;
	private String password;
	private String tell;
	private String gender;
	private String birth;
=======
	private String password;
	private String email;
	private String grade;
	private String tell;
>>>>>>> Stashed changes
	private boolean isLeave;

}
