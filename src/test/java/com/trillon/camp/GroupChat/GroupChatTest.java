package com.trillon.camp.GroupChat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.trillon.camp.groupChat.dto.ChatMember;
import com.trillon.camp.groupChat.dto.GroupChat;
import com.trillon.camp.groupChat.repository.GroupChatRepository;

@WebAppConfiguration

//JUNIT의 실행방법을 지정
@RunWith(SpringJUnit4ClassRunner.class)

//테스트 때 사용할 가상의 ApplicationContext를 생성하고 관리
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class GroupChatTest {
	
	@Autowired
	private GroupChatRepository groupChatRepository;
	
	@Test
	public void testGroupChatList() {
		
		GroupChat groupChat = new GroupChat();
		for (int i = 0; i < 10; i++) {
			groupChat.setRoomMaster("master"+i);
			groupChat.setGroupName("groupChat"+i);
			groupChat.setCurrentMember(3);
			groupChat.setMaxMember(5);
			groupChatRepository.insertNewGroup(groupChat);
		}
		
	}
	
	@Test
	public void testGroupId() {

		ChatMember chatMember = new ChatMember();
		
		for (int i = 1; i < 4; i++) {
			chatMember.setChatIdx(3);
			chatMember.setId("member"+i);
			groupChatRepository.myGroup(chatMember);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}