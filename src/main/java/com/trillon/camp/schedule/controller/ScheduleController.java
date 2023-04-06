package com.trillon.camp.schedule.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trillon.camp.schedule.dto.Schedule;
import com.trillon.camp.schedule.service.ScheduleService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/schedule")
public class ScheduleController {

	 private final ScheduleService scheduleService;

	@RequestMapping("/calendar")
	public void calendarPage() {
		System.out.println("calendar.jsp");
	}

	@GetMapping("/schedulePopUp")
	public void schedulePopUp() {
		System.out.println("schedulePopUp.jsp");
	}

	@ResponseBody
	@RequestMapping(value = "/get.do")
	public List<Schedule> ajax(HttpSession session) {

		
		
		String userId=(String) session.getAttribute("loginId");
		List<Schedule> list=scheduleService.selectUserTodo(userId);
		System.out.println(list);
		
	
		return list;

	}

	
	@PostMapping("/addTodo")
	public String addTodo(@RequestBody Map<String, String> data, HttpSession session) {
		System.out.println("addTodo page");
		
		Schedule schedule = new Schedule();
		
		schedule.setUserId((String) session.getAttribute("loginId")); 
		schedule.setTitle(data.get("title"));
		schedule.setDate(data.get("date")); 
		schedule.setDateEnd(data.get("dateEnd"));
		schedule.setStartTime(data.get("startTime"));
		

		scheduleService.insertNewTodo(schedule);

		
		return "ha";
		
	}
	
	
	@GetMapping("/deleteTodo")
	public void deleteTodo(String title, String date, HttpSession session) {
		Schedule schedule = new Schedule();
		schedule.setTitle(title);
		schedule.setDate(date.substring(0,10));
		schedule.setUserId((String) session.getAttribute("loginId")); 
		System.out.println(schedule);

		System.out.println("삭제");
		scheduleService.deleteTodo(schedule);
	}

	

}
