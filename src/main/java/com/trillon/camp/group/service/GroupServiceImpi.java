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
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.trillon.camp.group.dto.CampingGroup;
import com.trillon.camp.group.dto.GroupMember;
import com.trillon.camp.group.dto.TemporaryDate;
import com.trillon.camp.group.repository.GroupRepository;
import com.trillon.camp.schedule.dto.Schedule;
import com.trillon.camp.schedule.repository.ScheduleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupServiceImpi implements GroupSerivce {

	Logger log = LoggerFactory.getLogger(this.getClass());

	private final GroupRepository groupRepository;

	private final ScheduleRepository scheduleRepository;

	@Override
	public Integer selectNewGampingGroupIdx() {
		return groupRepository.selectNewGampingGroup();
	}

	@Override
	public void insertNewGroupTodo(Schedule schedule, String groupIdx) {

		if (schedule.getDateEnd() == "")
			schedule.setDateEnd(schedule.getDate());

		if (schedule.getStartTime() == "") {
			schedule.setStartTime("00:00:00");
			schedule.setAllDay(true);
		} else
			schedule.setAllDay(false);
		Map<String, Object> command = new HashMap<>();
		command.put("CampingGroup", groupRepository.findCampingGroupByGroupIdx(Integer.valueOf(groupIdx)));
		System.out.println(command.get("CampingGroup"));

		command.put("schedule", schedule);
		command.put("groupIdx", groupIdx);

		groupRepository.inserNewGroupTodo(command);

	}

	@Override
	public List<Date> weekEndBetweedDate(Map<String, Object> data) throws RuntimeException {
		log.info("service : findGroupMeetingDate");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateStart = (String) data.get("date");
		String dateEnd = (String) data.get("dateEnd");
		List<Date> weekEnd = new ArrayList<>();

		try {
			Date start = df.parse(dateStart);
			Date end = df.parse(dateEnd);

			Calendar ds = Calendar.getInstance();
			Calendar de = Calendar.getInstance();

			ds.setTime(start);
			de.setTime(end);

			while (ds.compareTo(de) != 1) {
				if (ds.get(Calendar.DAY_OF_WEEK) == 1 || ds.get(Calendar.DAY_OF_WEEK) == 7) {
					weekEnd.add(ds.getTime());
				}
				// System.out.println(simpleDateFormat.format(ds.getTime()));
				ds.add(Calendar.DATE, 1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return weekEnd;
	}

	@Override
	public Map<Date, Integer> recommandWeekEndFromDate(Map<String, Object> data) {
		Map<Date, Integer> recommandWeekEndMap = new TreeMap<Date, Integer>();		
	
		Integer groupIdx = Integer.valueOf(String.valueOf(data.get("groupIdx")));
		List<GroupMember> groupMembers = groupRepository.selectAllGroupMemberByGroupIdx(groupIdx);
		List<Schedule> schedules = new ArrayList<Schedule>();

		List<Date> weekEnds = weekEndBetweedDate(data);

		for (GroupMember groupMember : groupMembers) {
			schedules = scheduleRepository.selectScheduleByUserId(groupMember.getUserId());
//			System.out.println(n + ". " + groupMember.getUserId());
//			System.out.println(schedules);
			int count = 0;
			for (Date weekEnd : weekEnds) {

				if (checkHowManyMemberCan(weekEnd, schedules)) {

					if(recommandWeekEndMap.get(weekEnd)!=null) count=recommandWeekEndMap.get(weekEnd);
					else count=0;
					count++;
					//System.out.println("지금들어감" + count);
					recommandWeekEndMap.put(weekEnd, count);

				}
			}
		}
		System.out.println("그룹 주말 날짜 : 가능한 인원");
		
		for (Date date : recommandWeekEndMap.keySet()) {
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(simpleDateFormat.format(date)+" : "+ recommandWeekEndMap.get(date));
		}
		
		return recommandWeekEndMap;
	}
	
	


	public boolean checkHowManyMemberCan(Date weekEnd, List<Schedule> schedules) {

		if (schedules.size() == 0) {
			//System.out.println("해당 인원은 모든 날짜에 참석 가능");
			return true;
		}

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		for (Schedule schedule : schedules) {

			String dateStart = schedule.getDate();
			String dateEnd = schedule.getDateEnd();
			Date dateweek = new Date();

			Map<String, Object> data = new HashMap<>();
			data.put("date", dateStart);
			data.put("dateEnd", dateEnd);
			List<Date> userTodoWeekEnds = weekEndBetweedDate(data);

			//System.out.println("검사하고 싶은 날짜 : " + simpleDateFormat.format(weekEnd) + "============================");
			for (Date userWeekEnd : userTodoWeekEnds) {
				System.out.println(simpleDateFormat.format(userWeekEnd));
				dateweek = userWeekEnd;
				// user의 todo가 group의 weekend보다 이후일 경우
				if (userWeekEnd.before(weekEnd)) {
					//System.out.println("userWeekEnd.before(weekEnd)");
					continue;
				}
				if (userWeekEnd.equals(weekEnd)) {
					//System.out.println(simpleDateFormat.format(weekEnd) + " -> " + simpleDateFormat.format(userWeekEnd));
					//System.out.println("일정이 겹쳐서 해당 인원은 이날 안됨");
					return false;
				}
			}

			if (dateweek.before(weekEnd)) {
				//System.out.println("검사하기 전날의 날짜입니다");
				continue;
			}

		}

		//System.out.println(simpleDateFormat.format(weekEnd) + "에 해당 인원은 가능합니다.");
		return true;
	}

	@Override
	public List<TemporaryDate> selectRecommand(Integer groupIdx) {
		return groupRepository.selectRecommaned(groupIdx);
	}

	@Override
	public Integer deleteAllTemp(String groupIdx) {
		
		return groupRepository.deleteAllTemp(groupIdx);
	}

	@Override
	public CampingGroup findCampingGroupByGroupIdx(Integer groupIdx) {
		return groupRepository.findCampingGroupByGroupIdx(groupIdx);
	}

	@Override
	public void insertNewMemberToGroup(GroupMember member) {
		groupRepository.insertNewMemberToGroup(member);
		
	}

	@Override
	public Integer updateCurrentGroupMember(Integer groupIdx) {
		return groupRepository.updateCurrentGroupMember(groupIdx);
	}

	@Override
	public boolean checkMemberToGroup(GroupMember groupMember) {
		if(groupRepository.checkMemberToGroup(groupMember) != null) return false;
		return true;
	}

	@Override
	public List<String> selectGroupMemberNameByGroupIdx(Integer groupIdx) {
		return groupRepository.selectGroupMemberNameByGroupIdx(groupIdx);
	}

}
