package com.trillon.camp.groupChat.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class ChatRoom {

	private String roomId;
	private Integer groupIdx;
	
	public void setRoomId() {
		this.roomId = UUID.randomUUID().toString();
	}
	
	

}
