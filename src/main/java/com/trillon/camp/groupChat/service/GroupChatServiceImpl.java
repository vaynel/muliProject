package com.trillon.camp.groupChat.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.trillon.camp.group.dto.CampingGroup;
import com.trillon.camp.group.dto.GroupMember;
import com.trillon.camp.groupChat.dto.ChatRoom;
import com.trillon.camp.groupChat.repository.GroupChatRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupChatServiceImpl implements GroupChatService{
	
	private final GroupChatRepository groupChatRepository;


	@Override
	public List<CampingGroup> selectAllMygroupChatList(String userId) {
		return  groupChatRepository.myGroupChatList(userId);
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


	@Override
	public List<GroupMember> selectAllChatRoomList(String userId) {
		
		return groupChatRepository.selectAllChatRoomList(userId);
	}


	@Override
	public void insertNewGroup(CampingGroup campingGroup) {
		groupChatRepository.insertNewGroup(campingGroup);
		
	}


	@Override
	public void insertNewGroupChat(Map<String, Object> commandMap) {
		groupChatRepository.insertNewGroupChat(commandMap);
		
	}

}
