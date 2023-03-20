package com.trillon.camp.util.chat.service;

import java.util.List;

import com.trillon.camp.util.chat.dto.ChatRoom;

public interface ChatRoomService {

	List<ChatRoom> findAllRooms();

	ChatRoom createChatRoom(String name);

	ChatRoom findRoomById(String roomId);

}
