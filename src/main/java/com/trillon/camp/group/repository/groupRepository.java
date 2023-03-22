package com.trillon.camp.group.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.trillon.camp.group.dto.CampingGroup;
import com.trillon.camp.group.dto.GroupMember;

@Repository
public interface groupRepository {

	@Insert("insert into camping_group(group_name, group_master, current_member, max_member)" 
			 +" values(#{groupName},#{groupMaster},#{currentMember},#{maxMember})")
	void insertNewCampingGroup(CampingGroup campingGroup);

	@Select("select LAST_INSERT_ID() as group_idx")
	Object selectNewGampingGroup();

	
	@Insert("insert into group_member(group_idx,room_id,user_id) "
			+ "values(#{groupIdx},#{roomId},#{userId})")
	void insertNewMemberToGroup(GroupMember groupMember);
	
	

}
