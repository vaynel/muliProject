package com.trillon.camp.groupChat.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class ChatRoom {

	private String roomId;
	private Integer groupIdx;
	
	//여기에만 존재
	private String userId;
	
	public void setRoomId() {
		this.roomId = UUID.randomUUID().toString();
	}
	
	

}
