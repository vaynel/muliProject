package com.trillon.camp.groupChat.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.trillon.camp.groupChat.dto.ChatMember;
import com.trillon.camp.groupChat.dto.GroupChat;

@Repository
public interface GroupChatRepository {

	@Insert("insert into group_chat(group_name, room_master, current_member, max_member)"
			+ " values(#{groupName},#{roomMaster},#{correntMember},#{maxMember}) ")
	void insertNewGroup(GroupChat groupChat);

	
	@Select("select a.*, b.id"
			+ " from  group_chat a left join  chat_member b"
			+ " on a.chat_idx= b.chat_idx "
			+ "where b.chat_idx is not null and b.id = #{id}")
	List<GroupChat> myGroupChatList(String id);

	@Insert("insert into chat_member(chat_idx,id) values(#{ChatIdx},#{id})")
	void myGroup(ChatMember chatMember);
	
	

}
