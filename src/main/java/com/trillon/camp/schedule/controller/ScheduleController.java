package com.trillon.camp.schedule.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trillon.camp.schedule.dto.Schedule;
import com.trillon.camp.schedule.repository.ScheduleRepository;
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
	public List ajax() {

		// 테스트 데이터
//		HashMap<String, String> data = new HashMap<String, String>();
//		List<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
//
//		data.put("reservationTitle","study");
//		data.put("reservationDate","2023-03-23");
//		data.put("reservationDateEnd","2023-03-24");
//		data.put("reservationTime","13:30:00");
//		data.put("reservationIdx","1");
//		data.put("reservationDetail","test");
//		
//		list.add(data);
		
		
//		Map data;
//
//		List<Object> list = new ArrayList<Object>();
//
//		data = new HashMap();
//		data.put("title", "camping");
//		data.put("date", "2023-03-23");
//		data.put("dateEnd", "2023-03-24");
//		data.put("startTime", "13:30:00");
//		list.add(data);
//
//		data = new HashMap();
//		data.put("title", "study");
//		data.put("date", "2023-03-27");
//		data.put("dateEnd", "2023-03-28");
//		data.put("startTime", "13:30:00");
//		list.add(data);

		List<Object> list=scheduleService.selectTodo();
		
		
	
		return list;

	}

	@ResponseBody
	@PostMapping("/addTodo")
	public String addTodo(@RequestBody Map<String, String> data) {
		System.out.println("addTodo page");
		
		Schedule schedule = new Schedule();
		
		schedule.setUserId("hi"); 
		schedule.setTitle(data.get("title"));
		schedule.setDate(data.get("date")); 
		schedule.setDateEnd(data.get("dateEnd"));
		schedule.setStartTime(data.get("startTime"));
		

		scheduleService.insertNewTodo(schedule);

		
		return "ha";
		
	}
	
	
	@GetMapping("/deleteTodo")
	public void deleteTodo(String title, String date) {
		Schedule schedule = new Schedule();
		schedule.setTitle(title);
		schedule.setDate(date.substring(0,10));
		System.out.println(schedule);
		
		
		System.out.println("삭제");
		scheduleService.deleteTodo(schedule);
	}


	  @RequestMapping("/testPage") public void testPage() {
	  System.out.println("test");
	  
	 
	  List<Object> list=scheduleService.selectTodo();
	  System.out.println(list);
	  
	  }
	

}
