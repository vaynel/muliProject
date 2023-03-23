package com.trillon.camp.GroupChat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.trillon.camp.group.dto.GroupMember;
import com.trillon.camp.group.repository.GroupRepository;
import com.trillon.camp.groupChat.repository.GroupChatRepository;
import com.trillon.camp.schedule.dto.Schedule;
import com.trillon.camp.schedule.repository.ScheduleRepository;

@WebAppConfiguration

//JUNIT의 실행방법을 지정
@RunWith(SpringJUnit4ClassRunner.class)

//테스트 때 사용할 가상의 ApplicationContext를 생성하고 관리
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class GroupTest {
	
	@Autowired
	private GroupChatRepository groupChatRepository;
	
	@Autowired
	private GroupRepository groupRepository;
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Test
	public void insertNewMemberToGroup() {

		GroupMember groupMember = new GroupMember();
		// Group1에 멤버 추가 
		for (int i = 2; i < 4; i++) {
			groupMember.setUserId("user"+i);
			groupMember.setGroupIdx(1);
			groupMember.setRoomId(groupChatRepository.selectChatRoomIdByGroupIdx(1));
			groupRepository.insertNewMemberToGroup(groupMember);
		}
		// Group2에 멤버 추가 
		for (int i = 2; i < 4; i++) {
			groupMember.setUserId("user"+i);
			groupMember.setGroupIdx(2);
			groupMember.setRoomId(groupChatRepository.selectChatRoomIdByGroupIdx(2));
			groupRepository.insertNewMemberToGroup(groupMember);
		}
		// Group1에 master추가 
		groupMember.setUserId("master1");
		groupMember.setGroupIdx(1);
		groupMember.setRoomId(groupChatRepository.selectChatRoomIdByGroupIdx(1));
		groupRepository.insertNewMemberToGroup(groupMember);
		
		// Group2에 master추가 
		groupMember.setUserId("master2");
		groupMember.setGroupIdx(2);
		groupMember.setRoomId(groupChatRepository.selectChatRoomIdByGroupIdx(2));
		groupRepository.insertNewMemberToGroup(groupMember);
			
		
		
	}

	@Test
	public void selectAllGroupMemberByGroupIdx() {
		Integer groupIdx = 1;
		Map<String,List<Schedule>> scheduleMap = new HashMap<>();
		List<GroupMember> groupMembers=groupRepository.selectAllGroupMemberByGroupIdx(groupIdx);
		
		for (GroupMember groupMember : groupMembers) {
			List<Schedule> schedules = scheduleRepository.selectScheduleByUserId(groupMember.getUserId());
			scheduleMap.put(groupMember.getUserId(), schedules);
			
		}
		
		
		for (String strKey : scheduleMap.keySet()) {
				for (Schedule schedule : scheduleMap.get(strKey)) {
					System.out.println(schedule);
				}
			
				
		}
		
		
		
	}
	
	@Test
	public void test() {
		System.out.println(scheduleRepository.selectScheduleByUserId("user1"));
	}
	
	
	
	
	

}
