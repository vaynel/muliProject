package com.trillon.camp.schedule.service;

import com.trillon.camp.schedule.dto.Schedule;

public interface ScheduleService {

	void selectTodo(Schedule schedule);
	
	void insertNewTodo(Schedule schedule);

	void deleteTodo(Schedule schedule);
	
}
