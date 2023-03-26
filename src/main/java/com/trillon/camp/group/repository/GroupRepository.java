package com.trillon.camp.group.repository;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.trillon.camp.group.dto.CampingGroup;
import com.trillon.camp.group.dto.GroupMember;
import com.trillon.camp.group.dto.TemporaryDate;

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

	@Insert("insert into group_todo_manager"
			+ "(group_Idx,group_name,date, date_end)"
			+ " values(#{groupIdx},#{CampingGroup.groupName},"
			+ "#{schedule.date},#{schedule.dateEnd})")
	void inserNewGroupTodo(Map<String,Object> command);

	@Select("select * from camping_group where group_idx =#{groupIdx}")
	CampingGroup findCampingGroupByGroupIdx(String groupIdx);

	@Select("select * from group_member where group_idx = #{groupIdx}")
	List<GroupMember> selectAllGroupMemberByGroupIdx(Integer groupIdx);

	
	@Select("select * from temporary_recommand_date where group_Idx = #{groupIdx}")
	List<TemporaryDate> selectRecommaned(Integer groupIdx);

	@Delete("delete from temporary_recommand_date where group_Idx = #{groupIdx}")
	Integer deleteAllTemp(String groupIdx);



}