package com.trillon.camp.group.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.trillon.camp.group.repository.GroupRepository;
import com.trillon.camp.schedule.dto.Schedule;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupServiceImpi implements GroupSerivce{
	
	private final GroupRepository groupRepository;

	@Override
	public Integer selectNewGampingGroupIdx() {
		return groupRepository.selectNewGampingGroup();
	}

	@Override
	public void insertNewGroupTodo(Schedule schedule,String groupIdx) {
		
		if(schedule.getDateEnd()=="")
			schedule.setDateEnd(schedule.getDate());
		
		if(schedule.getStartTime()=="") {
			schedule.setStartTime("00:00:00");
			schedule.setAllDay(true);
		}
		else
			schedule.setAllDay(false);
		Map<String,Object> command = new HashMap<>();
		command.put("CampingGroup", groupRepository.findCampingGroupByGroupIdx(groupIdx));
		System.out.println(command.get("CampingGroup"));
		
		command.put("schedule", schedule);
		command.put("groupIdx",groupIdx);
		
		groupRepository.inserNewGroupTodo(command);
		
	}

}
