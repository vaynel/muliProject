package com.trillon.camp.groupChat.service;

import java.util.List;
import java.util.Map;

import com.trillon.camp.group.dto.CampingGroup;
import com.trillon.camp.group.dto.GroupMember;
import com.trillon.camp.groupChat.dto.ChatRoom;

public interface GroupChatService {

	List<CampingGroup> selectAllMygroupChatList(String id);
	
	List<GroupMember> selectAllChatRoomList(String userId);

	void createNewChatRoom(ChatRoom newChatRoom);

	List<ChatRoom> findRoomById(String roomId);

	void insertNewGroup(CampingGroup campingGroup);

	void insertNewGroupChat(Map<String, Object> commandMap);

	

}
