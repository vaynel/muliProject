package com.trillon.camp.groupChat.service;

import java.util.List;

import com.trillon.camp.groupChat.dto.ChatRoom;
import com.trillon.camp.groupChat.dto.GroupChat;

public interface GroupChatService {

	List<ChatRoom> selectAllMygroupChatList(String id);

	void createNewChatRoom(ChatRoom newChatRoom);

	List<ChatRoom> findRoomById(String roomId);

}
