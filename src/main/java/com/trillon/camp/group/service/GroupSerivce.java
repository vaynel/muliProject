package com.trillon.camp.group.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.trillon.camp.schedule.dto.Schedule;

public interface GroupSerivce {

	Integer selectNewGampingGroupIdx();

	void insertNewGroupTodo(Schedule schedule, String groupIdx);

	List<Date> weekEndBetweedDate(Map<String, Object> data);

}
