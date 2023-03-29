package com.trillon.camp.group.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trillon.camp.group.dto.TemporaryDate;
import com.trillon.camp.group.service.GroupSerivce;
import com.trillon.camp.groupChat.dto.ChatRoom;
import com.trillon.camp.groupChat.service.GroupChatService;
import com.trillon.camp.schedule.dto.Schedule;
import com.trillon.camp.schedule.service.ScheduleService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("group")
@RequiredArgsConstructor
public class GroupController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	private final GroupChatService groupChatService;
	private final GroupSerivce groupService;
	private final ScheduleService scheduleService;

	
	@GetMapping("/newGroupTodo")
	public void MyGroupTodo(Model model,String groupIdx,ChatRoom room) {
		
		log.info("get : newGroupTodo");
		log.info("groupIdx : "+groupIdx);
		String roomId = groupChatService.findRoomIdByGroupIdx(Integer.valueOf(groupIdx));
		log.info("roomID : "+roomId);
		
		model.addAttribute("groupIdx", groupIdx);
		model.addAttribute("roomId",roomId);
		
		
	} 
	
	@PostMapping("/newGroupTodo")
	//@MessageMapping(value = "/chat/message")
	public void newGroupTodo(@RequestBody Map<String, Object> data,Model model,HttpSession session) {
		log.info("post : newGroupTodo");
		System.out.println(data);
		String groupIdx = String.valueOf(data.get("groupIdx"));
		Map<Date,Integer> recommandWeekEndMap = groupService.recommandWeekEndFromDate(data);
		
		String roomId = groupChatService.findRoomIdByGroupIdx(Integer.valueOf(String.valueOf(data.get("groupIdx"))) );
		String title = (String) data.get("title");
		groupChatService.sendMassageRecommandWeekEnd(recommandWeekEndMap,roomId,groupIdx,title);
		
		
		//return "redirect:/groupChat/chatRoom?roomId="+roomId+"&groupIdx="+data.get("groupIdx");
	}
	
	
	
	
	@PostMapping("/addGroupTodo")
	public void addMyGroupTodo(String groupIdx,String title, String date) {
		log.info("post : addGroupTodo");
		System.out.println(title);
		Schedule schedule = new Schedule();
		schedule.setTitle(title);
		schedule.setDate(date);
		schedule.setUserId("user1");
		schedule.setDateEnd("");
		schedule.setStartTime("");
		schedule.setMadeByGroup(true);
		
		scheduleService.insertNewTodoMadyByGroup(schedule);
		Integer n = groupService.deleteAllTemp(groupIdx);
		System.out.println(n);
		
//		log.info("data : " +data);
//		Schedule schedule = new Schedule();
//		String groupIdx = data.get("groupIdx");
//		
//		schedule.setUserId("hi"); 
//		schedule.setTitle( data.get("title"));
//		schedule.setDate( data.get("date")); 
//		schedule.setDateEnd( data.get("dateEnd"));
//		schedule.setStartTime( data.get("startTime"));
		

//		groupService.insertNewGroupTodo(schedule,groupIdx);
		
	}
	
	@GetMapping("/recommendDate")
	public void recommendDate(Model model,String groupIdx) {
		log.info("get : recommendDate");
		System.out.println(groupIdx);
		model.addAttribute("groupIdx", groupIdx);
	}
	
	@ResponseBody
	@RequestMapping(value = "/get.do")
	public List<Schedule> ajax(@RequestParam String groupIdx) {
		log.info("그룹 날짜 추천 달력");
		System.out.println(groupIdx);
		List<TemporaryDate> listTemp= groupService.selectRecommand(Integer.valueOf(groupIdx));
		
		List<Schedule> list= new ArrayList<Schedule>();
		for (TemporaryDate temp : listTemp) {
			Schedule schedule = new Schedule();
			schedule.setDate(temp.getRecommandDate());
			schedule.setDateEnd(temp.getRecommandDate());
			schedule.setTitle(temp.getTitle()+" : " +String.valueOf(temp.getHowManyMemberCan())+"명 가능");
			schedule.setStartTime("00:00:00");
			list.add(schedule);			
		}
	
		return list;

	}
	
}
