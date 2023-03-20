package com.trillon.camp.groupChat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trillon.camp.groupChat.service.GroupChatService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/groupChat")
@RequiredArgsConstructor
public class GroupChatController {
	
	private final GroupChatService groupChatService;
	
	@GetMapping("/groupChatList")
	public void groupChatList(Model model,String Id) {
	
		System.out.println("groupChatList");
		System.out.println(groupChatService.selectAllMygroupChatList(Id));
		
		model.addAttribute("MyGroupChatList", groupChatService.selectAllMygroupChatList(Id));		
	}
	
	@GetMapping("/groupChat")
	public void groupChat() {
		System.out.println("groupChat");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
