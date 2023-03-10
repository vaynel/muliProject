package com.trillon.camp.comewithme.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class ComeWithMeBoard {

	private Integer comeSeq;
	private String userId;
	private LocalDateTime regDate;
	private String title;
	private String content;
	private Integer count;
	
	public String getRegDateAsDate() {
		return regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
	public String getRegDateAsTime() {
		return regDate.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}
}
