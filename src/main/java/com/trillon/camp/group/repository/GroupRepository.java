package com.trillon.camp.group.repository;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
	CampingGroup findCampingGroupByGroupIdx(Integer groupIdx);

	@Select("select * from group_member where group_idx = #{groupIdx}")
	List<GroupMember> selectAllGroupMemberByGroupIdx(Integer groupIdx);

	
	@Select("select * from temporary_recommand_date where group_Idx = #{groupIdx}")
	List<TemporaryDate> selectRecommaned(Integer groupIdx);

	@Delete("delete from temporary_recommand_date where group_Idx = #{groupIdx}")
	Integer deleteAllTemp(String groupIdx);

	@Update("update camping_group " + 
			"set current_member = " + 
			"(select count(*) from group_member where group_idx=#{groupIdx}) " + 
			"where group_idx=#{groupIdx}")
	Integer updateCurrentGroupMember(Integer groupIdx);

	@Select("select * from group_member "
			+ "where group_idx = #{groupIdx} and user_Id=#{userId}")
	GroupMember checkMemberToGroup(GroupMember groupMember);

	@Select("select a.name from member a left join group_member b "
			+ "on a.userID=b.user_Id "
			+ "where b.group_idx=#{groupIdx}")
	List<String> selectGroupMemberNameByGroupIdx(Integer groupIdx);

	
	@Delete("delete from group_member where group_Idx = #{groupIdx} and user_id = #{userId}")
	void deleteMemberFromGroupByGroupIdx(Map<String, Object> command);
	
	@Delete("delete from group_member where group_Idx = #{groupIdx}")
	Integer deleteAllMemberFromGroupByGroupIdx(String groupIdx);
	
	@Delete("delete from camping_group where group_Idx = #{groupIdx}")
	void deleteGroup(String groupIdx);
	
	@Update("update camping_group "
			+ "set activate = 0 "
			+ "where group_idx=#{groupIdx} ")
	void DisabledGroup(String groupIdx);



}