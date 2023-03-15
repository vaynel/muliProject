package com.trillon.camp.schedule.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.trillon.camp.schedule.dto.Schedule;


@Repository
public interface ScheduleRepository {

	
	@Select("select * from todo_manager")
	void seleteTodo(Schedule schedule);
	
	@Insert("insert into todo_manager(user_id, title, date, date_end, start_time) values(#{userId},#{title},#{date},#{dateEnd},#{startTime})")
	void insertNewTodo(Schedule schedule);

	
	@Delete("delete from todo_manager where title = #{title}")
	void deleteTodo(Schedule schedule);
	
	
}
