package com.trillon.camp.group.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trillon.camp.group.service.GroupSerivce;
import com.trillon.camp.schedule.dto.Schedule;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("group")
@RequiredArgsConstructor
public class GroupController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	private final GroupSerivce groupService;

	
	@GetMapping("/addGroupTodo")
	public void MyGroupTodo(Model model,String groupIdx) {
		model.addAttribute("groupIdx", groupIdx);
		log.info("get : addGroupTodo");
		
	}
	
	@PostMapping("/addGroupTodo")
	public void addMyGroupTodo(@RequestBody Map<String, String> data) {
		log.info("post : addGroupTodo");
		
		Schedule schedule = new Schedule();
		
		schedule.setUserId("hi"); 
		schedule.setTitle(data.get("title"));
		schedule.setDate(data.get("date")); 
		schedule.setDateEnd(data.get("dateEnd"));
		schedule.setStartTime(data.get("startTime"));
		

		groupService.insertNewGroupTodo(schedule);
		
	}
}
