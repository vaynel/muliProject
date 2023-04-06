package com.trillon.camp.group.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.trillon.camp.group.dto.CampingGroup;
import com.trillon.camp.group.dto.GroupMember;
import com.trillon.camp.group.dto.TemporaryDate;
import com.trillon.camp.members.dto.Member;
import com.trillon.camp.schedule.dto.Schedule;

public interface GroupSerivce {

	Integer selectNewGampingGroupIdx();

	void insertNewGroupTodo(Schedule schedule, String groupIdx);

	List<Date> weekEndBetweedDate(Map<String, Object> data);

	Map<Date, Integer> recommandWeekEndFromDate(Map<String, Object> data);

	List<TemporaryDate> selectRecommand(Integer groupIdx);

	Integer deleteAllTemp(String groupIdx);

	CampingGroup findCampingGroupByGroupIdx(Integer groupIdx);

	void insertNewMemberToGroup(GroupMember member);

	Integer updateCurrentGroupMember(Integer groupIdx);

	boolean checkMemberToGroup(GroupMember groupMember);

	List<String> selectGroupMemberNameByGroupIdx(Integer groupIdx);

	void withdrawGroup(String groupIdx, String userId);

	Integer deleteAllMember(String groupIdx);

	void deleteGroup(String groupIdx);

	void DisabledGroup(String groupIdx);

	void sendMailToGroupMaster(Integer groupIdx, Member user, Member master);

	String findMasterBygroupIdx(Integer groupIdx);

}
