package com.trillon.camp.groupChat.dto;

import lombok.Data;

@Data
public class GroupChat {

	private Integer chatIdx;
	private String groupName;
	private Integer currentMember;
	private Integer maxMember;
	private String roomMaster;
	
}
