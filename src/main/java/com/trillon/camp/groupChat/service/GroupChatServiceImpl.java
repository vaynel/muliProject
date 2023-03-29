package com.trillon.camp.groupChat.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.trillon.camp.group.dto.CampingGroup;
import com.trillon.camp.group.dto.GroupMember;
import com.trillon.camp.groupChat.dto.ChatRoom;
import com.trillon.camp.groupChat.repository.GroupChatRepository;
import com.trillon.camp.util.chat.dto.ChatMessage;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupChatServiceImpl implements GroupChatService{
	
	private final GroupChatRepository groupChatRepository;
	private final SimpMessagingTemplate template;


	@Override
	public List<CampingGroup> selectAllMygroupChatList(String userId) {
		return  groupChatRepository.myGroupChatList(userId);
	}


	@Override
	public void createNewChatRoom(ChatRoom newChatRoom) {
		groupChatRepository.insertNewChatRoom(newChatRoom);
		groupChatRepository.insertUserToChatRoomByChatRoom(newChatRoom);
		System.out.println("serviceImpi : creratNewChatRoom");
		
	}


	@Override
	public List<ChatRoom> findRoomById(String roomId) {
		return groupChatRepository.findRoomById(roomId);
	}


	@Override
	public List<GroupMember> selectAllChatRoomList(String userId) {
		
		return groupChatRepository.selectAllChatRoomList(userId);
	}


	@Override
	public void insertNewGroup(CampingGroup campingGroup) {
		groupChatRepository.insertNewGroup(campingGroup);
		
	}


	@Override
	public void insertNewGroupChat(Map<String, Object> commandMap) {
		groupChatRepository.insertNewGroupChat(commandMap);
		
	}


	@Override
	public String findRoomIdByGroupIdx(Integer groupIdx) {
		
		return groupChatRepository.selectChatRoomIdByGroupIdx(groupIdx);
	}


	@Override
	public void sendMassageRecommandWeekEnd(Map<Date, Integer> recommandWeekEndMap,
			String roomId,
			String groupIdx,
			String title) {
		// 그룹에 추천 날짜 메시지 보내기
		ChatMessage message = new ChatMessage();
		message.setRoomId(roomId);
		message.setWriter("추천 날짜");
		message.setMessage("가능한 인원");
		template.convertAndSend("/sub/chat/room/RoomId : "+message.getRoomId(), message);
		for (Date date : recommandWeekEndMap.keySet()) {
			System.out.println("추천중...");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String weekEndDate = simpleDateFormat.format(date);
			// DB에 저장하기
			Map<String,Object> tempMap = new HashMap<String, Object>();
			tempMap.put("groupIdx", groupIdx);
			tempMap.put("weekEndDate", weekEndDate);
			tempMap.put("howMany", recommandWeekEndMap.get(date));
			tempMap.put("title",title);
			groupChatRepository.insertTemporaryDate(tempMap);
			
			// chatRoom에 메세지 보내기 
			message.setWriter(weekEndDate);
			message.setMessage(String.valueOf(recommandWeekEndMap.get(date)));
			System.out.println("/sub/chat/room/"+message.getRoomId());
			template.convertAndSend("/sub/chat/room/RoomId : "+message.getRoomId(), message);
		}
		System.out.println("추천끝!");
		
	}

}
