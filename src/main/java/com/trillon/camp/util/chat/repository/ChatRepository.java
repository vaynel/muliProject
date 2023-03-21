package com.trillon.camp.util.chat.repository;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Repository;

import com.trillon.camp.util.chat.dto.ChatRoomDto;

@Repository
public interface ChatRepository {

	LinkedHashMap<String, ChatRoomDto> findAllRooms();

}
