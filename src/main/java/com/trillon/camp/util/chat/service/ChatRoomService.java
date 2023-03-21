package com.trillon.camp.util.chat.service;

import java.util.List;

import com.trillon.camp.util.chat.dto.ChatRoomDto;

public interface ChatRoomService {

	List<ChatRoomDto> findAllRooms();

	ChatRoomDto createChatRoom(String name);

	ChatRoomDto findRoomById(String roomId);

}
