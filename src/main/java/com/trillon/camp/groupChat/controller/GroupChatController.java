package com.trillon.camp.groupChat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/groupChat")
public class GroupChatController {
	
	@GetMapping("/groupChatList")
	public void groupChatList() {
		System.out.println("groupChatList");
		
	}
	@GetMapping("/groupChat")
	public void groupChat() {
		System.out.println("groupChat");
		
	}
	
}
