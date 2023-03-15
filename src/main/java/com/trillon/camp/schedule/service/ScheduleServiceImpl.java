package com.trillon.camp.schedule.service;

import org.springframework.stereotype.Service;

import com.trillon.camp.schedule.dto.Schedule;
import com.trillon.camp.schedule.repository.ScheduleRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{

	private final ScheduleRepository scheduleRepository;
	
	@Override
	public void selectTodo(Schedule schedule) {
		scheduleRepository.seleteTodo(schedule);
		
	}

	@Override
	public void insertNewTodo(Schedule schedule) {

		scheduleRepository.insertNewTodo(schedule);
		
	}

	@Override
	public void deleteTodo(Schedule schedule) {

		scheduleRepository.deleteTodo(schedule);
	}

}
