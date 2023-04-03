package com.trillon.camp.GroupChat;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.trillon.camp.group.dto.GroupMember;
import com.trillon.camp.group.repository.GroupRepository;
import com.trillon.camp.group.service.GroupSerivce;
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
	
	@Autowired
	private GroupSerivce groupService;
	
	
	
	@Test
	public void x() {

		GroupMember groupMember = new GroupMember();
		// Group1에 멤버 추가 
		for (int i = 1; i < 4; i++) {
			groupMember.setUserId("user"+i);
			groupMember.setGroupIdx(1);
			groupMember.setRoomId(groupChatRepository.selectChatRoomIdByGroupIdx(1));
			groupRepository.insertNewMemberToGroup(groupMember);
		}
		// Group2에 멤버 추가 
		for (int i = 1; i < 4; i++) {
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
					System.out.println(strKey+" - dateStart : "+ schedule.getDate()+  " / dateEnd : " +schedule.getDateEnd());
				}
			
				
		}
		
		
		
	}
	
	@Test
	public void testArgolizim() {
		
		Map<Date,Integer> recommandWeekEndMap = new TreeMap<>();
		// 그룹이 설정한 기간중에 주말만 받음
		Map<String,Object> data = new HashMap<String, Object>();

		// 설정한 기간
		data.put("date","2023-03-24");
		data.put("dateEnd","2023-04-01");
		List<Date> weekEnds = groupService.weekEndBetweedDate(data);
		
		//groupMember들의 개인 일정을 userId에 따라서 Map으로 담음
		Integer groupIdx = 1;
		Map<String,List<Schedule>> scheduleMap = new HashMap<>();
		List<GroupMember> groupMembers=groupRepository.selectAllGroupMemberByGroupIdx(groupIdx);
		List<Schedule> schedules= new ArrayList<Schedule>();
		
		int n =1;
		
		for (GroupMember groupMember : groupMembers) {
			schedules = scheduleRepository.selectScheduleByUserId(groupMember.getUserId());
			scheduleMap.put(groupMember.getUserId(), schedules);
			System.out.println(n+". "+groupMember.getUserId());
			System.out.println(schedules);
			int count = 0;
			for (Date weekEnd : weekEnds) {
				
				if(checkHowManyMemberCan(weekEnd,schedules)) {
					
					if(recommandWeekEndMap.get(weekEnd)!=null) count=recommandWeekEndMap.get(weekEnd);
					else count=0;
					count++;
					System.out.println("지금들어감" + count);
					recommandWeekEndMap.put(weekEnd, count);
					
				}
			}
			n++;
			
		}
		System.out.println(recommandWeekEndMap);
	}
	

	
	public boolean checkHowManyMemberCan(Date weekEnd, List<Schedule> schedules){
		
		if(schedules.size()==0) {
			System.out.println("해당 인원은 모든 날짜에 참석 가능");
			return true;
		}
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		
		for (Schedule schedule : schedules) {
			
			String dateStart = schedule.getDate();
			String dateEnd = schedule.getDateEnd();
			Date dateweek= new Date();
			
			Map<String,Object> data = new HashMap<>();
			data.put("date", dateStart);
			data.put("dateEnd", dateEnd);
			List<Date> userTodoWeekEnds = groupService.weekEndBetweedDate(data);
			
			
			
			
			System.out.println("검사하고 싶은 날짜 : "+simpleDateFormat.format(weekEnd)+"============================");
			for (Date userWeekEnd : userTodoWeekEnds) {
				System.out.println(simpleDateFormat.format(userWeekEnd));
				dateweek=userWeekEnd;
				// user의 todo가 group의 weekend보다 이후일 경우
				if(userWeekEnd.before(weekEnd)) {
					System.out.println("userWeekEnd.before(weekEnd)");
					continue;				
				}
				if(userWeekEnd.equals(weekEnd)) {
					System.out.println(simpleDateFormat.format(weekEnd)+" -> " + simpleDateFormat.format(userWeekEnd));
					System.out.println("일정이 겹쳐서 해당 인원은 이날 안됨");
					return false;
				}
			}
			
			if(dateweek.before(weekEnd)) {
				System.out.println("검사하기 전날의 날짜입니다");
				continue;
			}
			
		}
		
		System.out.println(simpleDateFormat.format(weekEnd)+"에 해당 인원은 가능합니다.");
		return true;
	}

}
