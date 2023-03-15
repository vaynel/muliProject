package com.trillon.camp.schedule.dto;

import lombok.Data;

@Data
public class Schedule {

	private String userId;
	private String title;
	private String date;
	private String dateEnd;
	//private boolean allday;
	private String startTime;
	//private boolean madeByGroup;
	//private String groupName;
	
	
}
