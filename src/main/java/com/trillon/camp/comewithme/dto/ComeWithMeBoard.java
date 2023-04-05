package com.trillon.camp.comewithme.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.trillon.camp.members.dto.Member;

import lombok.Data;

@Data
public class ComeWithMeBoard extends Member{

	private Integer bdIdx;
	private String title;
	private String content;
	private Integer likeCount;
	private LocalDateTime createDate;
	private Integer numOfPerson ;
	private Integer isDel;
	private String place;  		// 산, 바다
	private String campingWay; // 캠핑 방식
	private String ageAverage;  // 연령층
	private String gender;
	private Integer groupIdx;
	
	// join에서 가져오는 내용
	private String groupName;
	private String groupMaster;
	private String crDate;
	
	public String getRegDateAsDate() {
		return createDate.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
	}
	
	public String getRegDateAsTime() {
		return createDate.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}
}
