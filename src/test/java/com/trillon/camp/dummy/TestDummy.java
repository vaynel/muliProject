package com.trillon.camp.dummy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.MultipartFile;

import com.trillon.camp.comewithme.dto.ComeWithMeBoard;
import com.trillon.camp.comewithme.service.ComeWithMeService;
import com.trillon.camp.group.dto.CampingGroup;
import com.trillon.camp.group.dto.GroupMember;
import com.trillon.camp.group.service.GroupSerivce;
import com.trillon.camp.groupChat.dto.ChatRoom;
import com.trillon.camp.groupChat.service.GroupChatService;
import com.trillon.camp.members.service.MemberService;
import com.trillon.camp.members.validator.form.SignUpForm;

@WebAppConfiguration

//JUNIT의 실행방법을 지정
@RunWith(SpringJUnit4ClassRunner.class)

//테스트 때 사용할 가상의 ApplicationContext를 생성하고 관리
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class TestDummy {

	@Autowired
	private  MemberService memberService;
	@Autowired
	private  GroupChatService groupChatService;
	@Autowired
	private  GroupSerivce groupService;
	@Autowired
	private  ComeWithMeService comeWithMeService;
	
	// 더미 user생성 (1~10)
	@Test 
	public void TestMakeUser() { 
		for (int i = 1; i < 11; i++) {

			SignUpForm form = new SignUpForm();
			form.setUserId("user"+i);
			form.setPassword("1234");
			if(i%2==0) form.setGender("m");
			else form.setGender("f");
			form.setTell("010-0000-0000");
			form.setBirth("2000-01-01"); 
			form.setName("유저"+i);
			memberService.insertNewMember(form);
			
		}
	}
	
	
	@Test
	public void TestCreateGroupWithBoardOfCampwithMe() {
		
		List<MultipartFile> files = new ArrayList<MultipartFile>();
		System.out.println(files);
		
		for (int i = 1; i < 8; i++) {
			//게시글 생성	
			
			ComeWithMeBoard board = new ComeWithMeBoard();
			board.setAgeAverage("20대");
			board.setContent("내용");
			board.setGroupName("그룹"+i);
			board.setGroupIdx(i);
			board.setNumOfPerson(10);
			board.setTitle("모임구함"+i);
			board.setCampingWay("차박");
			board.setCreateDate(LocalDateTime.now());
			board.setPlace("산");
			board.setGender("여");
			
			
			// 그룹 만들기
			CampingGroup campingGroup = new CampingGroup(); 
			campingGroup.setMaxMember(board.getNumOfPerson());
			campingGroup.setGroupMaster("user"+i);
			campingGroup.setCurrentMember(1);
			campingGroup.setGroupName(board.getGroupName());
			groupChatService.insertNewGroup(campingGroup);
			
			 // 채팅방 만들기
			ChatRoom chatRoom = new ChatRoom();    
	        Map<String, Object> commandMap = new HashMap<>();
	        chatRoom.setRoomId();
	        commandMap.put("roomId", chatRoom);
	        commandMap.put("groupIdx", groupService.selectNewGampingGroupIdx());
	        groupChatService.insertNewGroupChat(commandMap);
	        
	        // master 그룹에 넣기 
	        Integer groupIdx = groupService.selectNewGampingGroupIdx();
	        GroupMember member = new GroupMember();
	        member.setUserId("user"+i);
	        member.setGroupIdx(groupIdx);
	        member.setRoomId(groupChatService.findRoomIdByGroupIdx(groupIdx));
	        groupService.insertNewMemberToGroup(member);
	        
	        // 게시글 만들기
	    	board.setGroupIdx(groupIdx);
			comeWithMeService.insertBoard(board, files);
			
		}
	}
	
	
	@Test
	public void TestInsertMemberToGroup() {
		
		for (int i = 1; i < 4; i++) {
			Integer groupIdx = comeWithMeService.returnGroupIdxByBdIdx(i);
			
			GroupMember groupMember = new GroupMember();
			groupMember.setGroupIdx(groupIdx);
			groupMember.setUserId("user"+(4+i));
			groupMember.setRoomId(groupChatService.findRoomIdByGroupIdx(groupIdx));
			if(groupService.checkMemberToGroup(groupMember)) {
				CampingGroup campingGroup = groupService.findCampingGroupByGroupIdx(groupIdx);
				if(campingGroup.getCurrentMember() < campingGroup.getMaxMember()) {
					System.out.println("새로운 멤버 그룹에 추가");
					groupService.insertNewMemberToGroup(groupMember);
					Integer currentMember = groupService.updateCurrentGroupMember(groupIdx);
					System.out.println(currentMember + " - "+ campingGroup.getMaxMember());
				}
				else System.out.println("그룹에 사람이 다 찼음");
				
			}
			else{
				System.out.println("같은 멤버가 추가 하려해서 반환함");
			}
			
		}
		
		for (int i = 1; i < 3; i++) {
			Integer groupIdx = comeWithMeService.returnGroupIdxByBdIdx(i);
			
			GroupMember groupMember = new GroupMember();
			groupMember.setGroupIdx(groupIdx);
			groupMember.setUserId("user"+(3+i));
			groupMember.setRoomId(groupChatService.findRoomIdByGroupIdx(groupIdx));
			if(groupService.checkMemberToGroup(groupMember)) {
				CampingGroup campingGroup = groupService.findCampingGroupByGroupIdx(groupIdx);
				if(campingGroup.getCurrentMember() < campingGroup.getMaxMember()) {
					System.out.println("새로운 멤버 그룹에 추가");
					groupService.insertNewMemberToGroup(groupMember);
					Integer currentMember = groupService.updateCurrentGroupMember(groupIdx);
					System.out.println(currentMember + " - "+ campingGroup.getMaxMember());
				}
				else System.out.println("그룹에 사람이 다 찼음");
				
			}
			else{
				System.out.println("같은 멤버가 추가 하려해서 반환함");
			}
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
