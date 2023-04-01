package com.trillon.camp.group.dto;

import lombok.Data;

@Data
public class CampingGroup {

	private String groupName;
	private String groupMaster;
	private Integer currentMember;
	private Integer maxMember;
	private Integer groupIdx;

}