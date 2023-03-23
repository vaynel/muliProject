package com.trillon.camp.group.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.trillon.camp.group.dto.CampingGroup;
import com.trillon.camp.group.dto.GroupMember;
import com.trillon.camp.schedule.dto.Schedule;

@Repository
public interface GroupRepository {

	@Insert("insert into camping_group(group_name, group_master, current_member, max_member)" 
			 +" values(#{groupName},#{groupMaster},#{currentMember},#{maxMember})")
	void insertNewCampingGroup(CampingGroup campingGroup);

	@Select("select LAST_INSERT_ID() as group_idx")
	Integer selectNewGampingGroup();


	@Insert("insert into group_member(group_idx,room_id,user_id) "
			+ "values(#{groupIdx},#{roomId},#{userId})")
	void insertNewMemberToGroup(GroupMember groupMember);

	@Insert("insert into group_todo_manager(user_id, title, date, date_end, allday, start_time) values(#{userId},#{title},#{date},#{dateEnd},#{allDay},#{startTime})")
	void inserNewGroupTodo(Schedule schedule);



}