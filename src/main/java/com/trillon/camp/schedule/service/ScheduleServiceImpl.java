package com.trillon.camp.schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trillon.camp.schedule.dto.Schedule;
import com.trillon.camp.schedule.repository.ScheduleRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{

	private final ScheduleRepository scheduleRepository;
	
	@Override
	public List<Schedule> selectTodo() {
		
		return scheduleRepository.findAll();
		
	}

	/*
	 * @Override public void insertNewTodo(Schedule schedule) {
	 * 
	 * if(schedule.getDateEnd()==""&&schedule.getStartTime()=="")
	 * scheduleRepository.insertNewTodoNull1(schedule);
	 * 
	 * else if(schedule.getDateEnd()=="")
	 * scheduleRepository.insertNewTodoNull3(schedule); else
	 * if(schedule.getStartTime()=="")
	 * scheduleRepository.insertNewTodoNull2(schedule); else
	 * scheduleRepository.insertNewTodo(schedule);
	 * 
	 * }
	 */

	@Override
	public void insertNewTodo(Schedule schedule) {

	
		if(schedule.getDateEnd()=="")
			schedule.setDateEnd(schedule.getDate());
		
		if(schedule.getStartTime()=="") {
			schedule.setStartTime("00:00:00");
			schedule.setAllDay(true);
		}
		else
			schedule.setAllDay(false);
		
		scheduleRepository.insertNewTodo(schedule);
		

		
	}
	
	@Override
	public void deleteTodo(Schedule schedule) {

		scheduleRepository.deleteTodo(schedule);
	}



}
