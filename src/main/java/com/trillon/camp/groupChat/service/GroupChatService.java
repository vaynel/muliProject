package com.trillon.camp.groupChat.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.trillon.camp.group.dto.CampingGroup;
import com.trillon.camp.group.dto.GroupMember;
import com.trillon.camp.group.dto.TemporaryDate;
import com.trillon.camp.groupChat.dto.ChatRoom;

public interface GroupChatService {

	List<CampingGroup> selectAllMygroupChatList(String id);
	
	List<GroupMember> selectAllChatRoomList(String userId);

	void createNewChatRoom(ChatRoom newChatRoom);

	List<ChatRoom> findRoomById(String roomId);

	void insertNewGroup(CampingGroup campingGroup);

	void insertNewGroupChat(Map<String, Object> commandMap);

	String findRoomIdByGroupIdx(Integer groupIdx);

	void sendMassageRecommandWeekEnd(Map<Date, Integer> recommandWeekEndMap, String roomId, String groupIdx, String title);

	void deletGroupChat(String groupIdx);


	

}
