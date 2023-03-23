package com.trillon.camp.groupChat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trillon.camp.groupChat.dto.ChatRoom;
import com.trillon.camp.groupChat.dto.GroupChat;
import com.trillon.camp.groupChat.repository.GroupChatRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupChatServiceImpl implements GroupChatService{
	
	private final GroupChatRepository groupChatRepository;


	@Override
	public List<ChatRoom> selectAllMygroupChatList(String id) {
		return  groupChatRepository.myGroupChatList(id);
	}


	@Override
	public void createNewChatRoom(ChatRoom newChatRoom) {
		groupChatRepository.insertNewChatRoom(newChatRoom);
		groupChatRepository.insertUserToChatRoomByChatRoom(newChatRoom);
		System.out.println("serviceImpi : creratNewChatRoom");
		
	}


	@Override
	public List<ChatRoom> findRoomById(String roomId) {
		return groupChatRepository.findRoomById(roomId);
	}

}
