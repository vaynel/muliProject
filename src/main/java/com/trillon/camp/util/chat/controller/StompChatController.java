package com.trillon.camp.util.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.trillon.camp.util.chat.dto.ChatMessage;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StompChatController {
	
	private final SimpMessagingTemplate template;
	
	@MessageMapping(value = "/chat/enter")
	public void enter(ChatMessage message) {
		message.setMessage(message.getWriter()+"님이 채팅방에 참여하였습니다.");
		System.out.println(message.getWriter()+"님이 채팅방에 참여하였습니다.");
		message.setWriter("서버");
		template.convertAndSend("/sub/chat/room/"+ message.getRoomId(),message );
	}
	
	@MessageMapping(value = "/chat/message")
	public void message(ChatMessage message) {
		System.out.println(message.getWriter()+"님 : "+message.getMessage());
		template.convertAndSend("/sub/chat/room/"+ message.getRoomId(),message );
	}

}
