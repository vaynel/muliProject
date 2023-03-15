package com.trillon.camp.comewithme.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class ComeWithMeBoard {

	private Integer bdIdx;
	private String title;
	private String content;
	private Integer likeCount;
	private LocalDateTime createDate;
	private Integer numOfPerson ;
	private Integer isDel;
	
	public String getRegDateAsDate() {
		return createDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
	public String getRegDateAsTime() {
		return createDate.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}
}
