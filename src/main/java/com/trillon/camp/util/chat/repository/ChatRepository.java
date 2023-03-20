package com.trillon.camp.util.chat.repository;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Repository;

import com.trillon.camp.util.chat.dto.ChatRoom;

@Repository
public interface ChatRepository {

	LinkedHashMap<String, ChatRoom> findAllRooms();

}
