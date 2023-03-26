package com.trillon.camp.groupChat.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.trillon.camp.group.dto.CampingGroup;
import com.trillon.camp.group.dto.GroupMember;
import com.trillon.camp.groupChat.dto.ChatRoom;

@Repository
public interface GroupChatRepository {

	@Insert("insert into camping_group(group_name, group_master, current_member, max_member)"
			+ " values(#{groupName},#{groupMaster},#{currentMember},#{maxMember}) ")
	void insertNewGroup(CampingGroup campingGroup);

	
	@Select("select a.*, b.user_id"
			+ " from  camping_group a left join  group_member b"
			+ " on a.group_idx= b.group_idx "
			+ "where b.user_id = #{userId}")
	List<CampingGroup> myGroupChatList(String userId);

	@Insert("insert into chat_member(chat_idx,id) values(#{ChatIdx},#{Id})")
	void myGroup(GroupMember chatMember);

	@Insert("insert into camping_group(room_id,group_name, room_master, current_member, max_member)"
			+ " values(#{roomId},#{groupName},#{roomMaster},#{currentMember},#{maxMember}) ")
	void insertNewChatRoom(ChatRoom newChatRoom);

	@Insert("insert into chat_member(room_id,id)"
			+ "values(#{roomId},#{userId})")
	void insertUserToChatRoomByChatRoom(ChatRoom newChatRoom);

	
	@Insert("insert into chat_member(room_id,id)"
			+ "values(#{roomId},#{userId})")
	void insertUserToChatRoomByChatMember(GroupMember groupMember);

	@Select("select a.*, b.user_id"
			+" from group_chat_room a left join group_member b"
			+" on a.room_id = b.room_id"
			+" where b.room_id=#{roomId}")
	List<ChatRoom> findRoomById(String roomId);

	
	
	@Insert("insert into group_chat_room(room_id,group_idx)"
			+"values(#{roomId.roomId},#{groupIdx})")
	void insertNewGroupChat(Map<String, Object> commandMap);


	@Select("select room_id "
			+ "from group_chat_room "
			+ "where group_idx = #{groupIdx}")
	String selectChatRoomIdByGroupIdx(int groupIdx);

	@Select("select * from group_member where user_id=#{userId}")
	List<GroupMember> selectAllChatRoomList(String userId);


	@Insert("insert into temporary_recommand_date(group_idx,recommand_date,how_many_member_can) "
			+"values(#{groupIdx},#{weekEndDate},#{howMany})")
	void insertTemporaryDate(Map<String, Object> tempMap);
	
	
	
	
	
}
