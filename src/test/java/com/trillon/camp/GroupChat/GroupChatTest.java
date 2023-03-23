package com.trillon.camp.GroupChat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.trillon.camp.group.dto.CampingGroup;
import com.trillon.camp.group.dto.GroupMember;
import com.trillon.camp.group.repository.GroupRepository;
import com.trillon.camp.groupChat.dto.ChatRoom;
import com.trillon.camp.groupChat.repository.GroupChatRepository;

@WebAppConfiguration

//JUNIT의 실행방법을 지정
@RunWith(SpringJUnit4ClassRunner.class)

//테스트 때 사용할 가상의 ApplicationContext를 생성하고 관리
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class GroupChatTest {
	
	@Autowired
	private GroupChatRepository groupChatRepository;
	
	@Autowired
	private GroupRepository groupRepository;

	
//	@Test
//	public void testGroupId() {
//
//		ChatMember chatMember = new ChatMember();
//		
//		for (int i = 1; i < 4; i++) {
//			chatMember.setUserId("member"+i);
//			groupChatRepository.myGroup(chatMember);
//		}
//	}
//
//	
//	@Test
//	public void testCreateNewChatRoomDummy() {
//		
//		ChatRoom chatRoom = new ChatRoom();
//		ChatMember chatMember = new ChatMember();
//		
//		for (int i = 1; i < 6; i++) {
//			chatRoom.setRoomId();
//			chatRoom.setRoomMaster("master"+i);
//			chatRoom.setGroupName("chat"+i);
//			chatRoom.setCurrentMember(1);
//			chatRoom.setMaxMember(5);
//			groupChatRepository.insertNewChatRoom(chatRoom);
//			
//			chatMember.setRoomId(chatRoom.getRoomId());
//			for(int j=1; j<4;j++) {
//				chatMember.setUserId("member"+j);
//				groupChatRepository.insertUserToChatRoomByChatMember(chatMember);
//			}
//		}
//	}
	
	@Test
	public void testChatList() {
		System.out.println(groupChatRepository.myGroupChatList("member1"));
		
	}
	
	@Test
	public void testInsertNewGroup() {
		
		CampingGroup campingGroup = new CampingGroup();
		ChatRoom chatRoom = new ChatRoom();
		
		Map<String, Object> commandMap = new HashMap<>();
		
		
		for (int i = 1; i < 4; i++) {
			campingGroup.setGroupName("group"+i);
			campingGroup.setGroupMaster("master"+i);
			campingGroup.setCurrentMember(i);
			campingGroup.setMaxMember(5);
			groupRepository.insertNewCampingGroup(campingGroup);
			chatRoom.setRoomId();
			commandMap.put("roomId", chatRoom);
			commandMap.put("groupIdx", groupRepository.selectNewGampingGroup());
			
			groupChatRepository.insertNewGroupChat(commandMap);
			
			
		}
		
	}
	
	
	@Test
	public void insertNewMemberToGroup() {
		GroupMember groupMember = new GroupMember();
		groupMember.setUserId("user1");
		for (int i = 1; i < 4; i++) {
			groupMember.setGroupIdx(i);
			groupMember.setRoomId(groupChatRepository.selectChatRoomIdByGroupIdx(i));
			groupRepository.insertNewMemberToGroup(groupMember);
		}
		
			
		
		
	}
	
	
	
	@Test
	public void testSelectMygroup() {
		System.out.println(groupChatRepository.myGroupChatList("user4"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
