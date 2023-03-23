package com.trillon.camp.group.service;

import com.trillon.camp.schedule.dto.Schedule;

public interface GroupSerivce {

	Integer selectNewGampingGroupIdx();

	void insertNewGroupTodo(Schedule schedule, String groupIdx);

}
