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
		Map data;

		List<Object> list = new ArrayList<Object>();

		data = new HashMap();
		data.put("reservationTitle", "camping");
		data.put("reservationDate", "2023-03-23");
		data.put("reservationDateEnd", "2023-03-24");
		data.put("reservationTime", "13:30:00");
		data.put("reservationIdx", "1");
		data.put("reservationDetail", "test");
		list.add(data);

		data = new HashMap();
		data.put("reservationTitle", "study");
		data.put("reservationDate", "2023-03-27");
		data.put("reservationDateEnd", "2023-03-28");
		data.put("reservationTime", "13:30:00");
		data.put("reservationIdx", "2");
		data.put("reservationDetail", "test2");
		list.add(data);

		data = new HashMap();
		data.put("reservationTitle", "안뇽");
		data.put("reservationDate", "2023-03-15");
		data.put("reservationDateEnd", "2023-03-15");
		data.put("reservationTime", "18:00:00");
		data.put("reservationIdx", "3");
		data.put("reservationDetail", "test3");
		list.add(data);

		System.out.println("실행되나요");
		return list;

	}

	@ResponseBody
	@PostMapping("/addTodo")
	public String addTodo(@RequestBody String title) {
		System.out.println("dhosdfihjosdfjkh");
		System.out.println(title);

		/*
		 * @RequestParam("title") String title,@RequestParam("dateStart") String
		 * dateStart,
		 * 
		 * @RequestParam("dateEnd") String dateEnd,
		 * 
		 * @RequestParam("timeStart") String timeStart
		 */
		return "redirect:/schedule/calendar";
	}


	  @RequestMapping("/testPage") public void testPage() {
	  System.out.println("test");
	  
	  Schedule schedule = new Schedule();
	  
	  schedule.setUserId("hi"); schedule.setTitle("hello");
	  schedule.setDate("2023-03-28"); schedule.setDateEnd("2023-03-29");
	  schedule.setStartTime("12:00:00");
	  
	  
	  scheduleService.insertNewTodo(schedule);
	  
	  
	  }
	

}
