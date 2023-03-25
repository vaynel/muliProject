package com.trillon.camp.group.controller;

import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.trillon.camp.group.service.GroupSerivce;
import com.trillon.camp.schedule.dto.Schedule;
import com.trillon.camp.schedule.service.ScheduleService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("group")
@RequiredArgsConstructor
public class GroupController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	private final GroupSerivce groupService;
	private final ScheduleService scheduleService;
	
	@GetMapping("/newGroupTodo")
	public void MyGroupTodo(Model model,String groupIdx) {
		model.addAttribute("groupIdx", groupIdx);
		log.info("get : newGroupTodo");
		log.info("groupIdx : "+groupIdx);
		
	} 
	
	@PostMapping("/newGroupTodo")
	public void newGroupTodo(@RequestBody Map<String, Object> data,Model model,HttpSession session) {
		log.info("post : newGroupTodo");
		System.out.println(data);
		Map<Date,Integer> recommandWeekEndMap = groupService.recommandWeekEndFromDate(data);
		
		session.setAttribute("recommnadWeekEndMap", recommandWeekEndMap);
		
	}
	
	
	
	@PostMapping("/addGroupTodo")
	public void addMyGroupTodo(@RequestBody Map<String, String> data) {
		log.info("post : addGroupTodo");
		log.info("data : " +data);
		Schedule schedule = new Schedule();
		String groupIdx = data.get("groupIdx");
		
		schedule.setUserId("hi"); 
		schedule.setTitle( data.get("title"));
		schedule.setDate( data.get("date")); 
		schedule.setDateEnd( data.get("dateEnd"));
		schedule.setStartTime( data.get("startTime"));
		

		groupService.insertNewGroupTodo(schedule,groupIdx);
		
	}
	
	@GetMapping("/recommendDate")
	public void recommendDate() {
		log.info("get : recommendDate");
		
	}
	@ResponseBody
	@RequestMapping(value = "/get.do")
	public List ajax() {
		List<Schedule> list=scheduleService.selectTodo();
	
		return list;

	}
	
}
