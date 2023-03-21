package com.trillon.camp.groupChat.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trillon.camp.groupChat.dto.ChatMember;
import com.trillon.camp.groupChat.dto.ChatRoom;
import com.trillon.camp.groupChat.service.GroupChatService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/groupChat")
@RequiredArgsConstructor
public class GroupChatController {
	
	private final GroupChatService groupChatService;
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/groupChatList")
	public void groupChatList(Model model,String userId) {
	
		System.out.println("groupChatList");
		userId="member1";
		//System.out.println(groupChatService.selectAllMygroupChatList(userId));
		
		model.addAttribute("MyGroupChatList", groupChatService.selectAllMygroupChatList(userId));		
	}
	
	@GetMapping("/groupChat")
	public void groupChat() {
		System.out.println("groupChat");
	}
	
	@PostMapping("/createChat")
	@ResponseBody
	public String createChat(@RequestBody ChatRoom chatRoom) {
		System.out.println("Post : createChat");
		ChatRoom newChatRoom = chatRoom;
		newChatRoom.setRoomId();
		System.out.println(newChatRoom);
		groupChatService.createNewChatRoom(newChatRoom);
		return "성공";
	}
	

	
	@GetMapping("/chatRoom")
    public void getRoom(@RequestParam("roomId") String roomId, Model model){
		
        log.info("# get Chat Room, roomID : " + roomId);
        List<ChatRoom> chatRooms = groupChatService.findRoomById(roomId);
        ChatRoom chatRoom  = new ChatRoom();
        chatRoom.setRoomId(chatRooms.get(0).getRoomId());
        chatRoom.setGroupName(chatRooms.get(0).getGroupName());
        chatRoom.setRoomMaster(chatRooms.get(0).getRoomMaster());
        chatRoom.setMaxMember(chatRooms.get(0).getMaxMember());
        chatRoom.setCurrentMember(chatRooms.get(0).getCurrentMember());
      
        model.addAttribute("room", chatRoom);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
