package com.trillon.camp.groupChat.service;

import java.util.List;

import com.trillon.camp.groupChat.dto.GroupChat;

public interface GroupChatService {

	List<GroupChat> selectAllMygroupChatList(String id);

}
