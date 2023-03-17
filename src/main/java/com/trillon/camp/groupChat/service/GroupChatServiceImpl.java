package com.trillon.camp.groupChat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trillon.camp.groupChat.dto.GroupChat;
import com.trillon.camp.groupChat.repository.GroupChatRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupChatServiceImpl implements GroupChatService{
	
	private final GroupChatRepository groupChatRepository;


	@Override
	public List<GroupChat> selectAllMygroupChatList(String id) {
		return  groupChatRepository.myGroupChatList(id);
	}

}
