package com.trillon.camp.util.chat.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.trillon.camp.util.chat.dto.ChatRoom;
import com.trillon.camp.util.chat.repository.ChatRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService {

	private final ChatRepository chatRepository;
	private Map<String, ChatRoom> chatRoomMap = new LinkedHashMap<String, ChatRoom>();
	

	@Override
	public List<ChatRoom> findAllRooms() {
//		chatRoomMap = chatRepository.findAllRooms();
		List<ChatRoom> result = new ArrayList<>(chatRoomMap.values());
		Collections.reverse(result);

		return result;
	}

	@Override
	public ChatRoom findRoomById(String Id) {
		
		return chatRoomMap.get(Id);
	}

	@Override
	public ChatRoom createChatRoom(String name) {
		ChatRoom room = ChatRoom.create(name);
		chatRoomMap.put(room.getRoomId(), room);

		return room;
	}

}
