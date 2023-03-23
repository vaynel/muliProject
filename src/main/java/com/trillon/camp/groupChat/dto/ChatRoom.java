package com.trillon.camp.groupChat.dto;

import com.trillon.camp.util.chat.dto.ChatRoomDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ChatRoom extends ChatRoomDto{

	private String userId;
	private String roomMaster;
	private Integer currentMember;
	private Integer maxMember;
	
	

}
