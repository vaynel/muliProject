package com.trillon.camp.groupChat.dto;

import java.util.UUID;

import com.trillon.camp.util.chat.dto.ChatRoomDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class ChatRoom {

	private String roomId;
	private Integer groupIdx;
	
	public void setRoomId() {
		this.roomId = UUID.randomUUID().toString();
	}
	
	

}
