package com.trillon.camp.util.chat.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.trillon.camp.util.chat.dto.ChatRoomDto;
import com.trillon.camp.util.chat.repository.ChatRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService {

	private final ChatRepository chatRepository;
	private Map<String, ChatRoomDto> chatRoomMap = new LinkedHashMap<String, ChatRoomDto>();
	

	@Override
	public List<ChatRoomDto> findAllRooms() {
//		chatRoomMap = chatRepository.findAllRooms();
		List<ChatRoomDto> result = new ArrayList<>(chatRoomMap.values());
		Collections.reverse(result);

		return result;
	}

	@Override
	public ChatRoomDto findRoomById(String Id) {
		
		return chatRoomMap.get(Id);
	}

	@Override
	public ChatRoomDto createChatRoom(String name) {
		ChatRoomDto room = ChatRoomDto.create(name);
		chatRoomMap.put(room.getRoomId(), room);

		return room;
	}

}
