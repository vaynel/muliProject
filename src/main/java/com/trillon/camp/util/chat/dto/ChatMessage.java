package com.trillon.camp.util.chat.dto;

import lombok.Data;

@Data
public class ChatMessage {
	
	 private String roomId;
	 private String writer;
	 private String message;

}
