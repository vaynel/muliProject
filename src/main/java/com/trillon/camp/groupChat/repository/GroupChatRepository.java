package com.trillon.camp.groupChat.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.trillon.camp.groupChat.dto.ChatMember;
import com.trillon.camp.groupChat.dto.ChatRoom;
import com.trillon.camp.groupChat.dto.GroupChat;

@Repository
public interface GroupChatRepository {

	@Insert("insert into group_chat(group_name, room_master, current_member, max_member)"
			+ " values(#{groupName},#{roomMaster},#{correntMember},#{maxMember}) ")
	void insertNewGroup(GroupChat groupChat);

	
	@Select("select a.*, b.id"
			+ " from  group_chat a left join  chat_member b"
			+ " on a.room_id= b.room_id "
			+ "where b.room_id is not null and b.id = #{Id}")
	List<ChatRoom> myGroupChatList(String id);

	@Insert("insert into chat_member(chat_idx,id) values(#{ChatIdx},#{Id})")
	void myGroup(ChatMember chatMember);

	@Insert("insert into group_chat(room_id,group_name, room_master, current_member, max_member)"
			+ " values(#{roomId},#{groupName},#{roomMaster},#{currentMember},#{maxMember}) ")
	void insertNewChatRoom(ChatRoom newChatRoom);

	@Insert("insert into chat_member(room_id,id)"
			+ "values(#{roomId},#{userId})")
	void insertUserToChatRoomByChatRoom(ChatRoom newChatRoom);

	
	@Insert("insert into chat_member(room_id,id)"
			+ "values(#{roomId},#{userId})")
	void insertUserToChatRoomByChatMember(ChatMember chatMember);

	@Select("select a.*, b.id"
			+" from group_chat a left join chat_member b"
			+" on a.room_id = b.room_id"
			+" where b.room_id=#{roomId}")
	List<ChatRoom> findRoomById(String roomId);
	
	

}
