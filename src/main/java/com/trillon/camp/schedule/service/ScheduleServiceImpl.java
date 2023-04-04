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

	@Override
	public void insertNewTodoMadyByGroup(Schedule schedule) {
		if(schedule.getDateEnd()=="")
			schedule.setDateEnd(schedule.getDate());
		
		if(schedule.getStartTime()=="") {
			schedule.setStartTime("00:00:00");
			schedule.setAllDay(true);
		}
		else
			schedule.setAllDay(false);
		
		scheduleRepository.insertNewTodoMadeByGroup(schedule);
		
	}





	@Override
	public List<Schedule> selectUserTodo(String userId) {
		
		return scheduleRepository.selectScheduleByUserId(userId);
	}




}
