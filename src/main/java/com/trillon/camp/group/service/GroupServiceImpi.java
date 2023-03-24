package com.trillon.camp.group.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.trillon.camp.group.repository.GroupRepository;
import com.trillon.camp.schedule.dto.Schedule;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupServiceImpi implements GroupSerivce{
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
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

	@Override
	public List<Date> findGroupMeetingDate(Map<String, Object> data) throws RuntimeException {
		log.info("service : findGroupMeetingDate");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateStart  = (String) data.get("date");
		String dateEnd  = (String) data.get("dateEnd");
		List<Date> weekEnd = new ArrayList<>();
		List<Date> recommandDate = new ArrayList<>();
		
		try {
			Date start = df.parse(dateStart);
			Date end=df.parse(dateEnd);
			
			Calendar ds = Calendar.getInstance();
			Calendar de = Calendar.getInstance();
			
			ds.setTime(start);
			de.setTime(end);
			
			while(ds.compareTo(de)!=1) {
				if(ds.get(Calendar.DAY_OF_WEEK)==1 || ds.get(Calendar.DAY_OF_WEEK)==7) {
					weekEnd.add(ds.getTime());
				}
				//System.out.println(simpleDateFormat.format(ds.getTime()));
				ds.add(Calendar.DATE, 1);
			}
			
			for (Date date : weekEnd) {
				System.out.println(simpleDateFormat.format(date));
			}
			
			
			
			
			
			
			return recommandDate;
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
		
		return recommandDate;
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
