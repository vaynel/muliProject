package com.trillon.camp.schedule.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.trillon.camp.schedule.dto.Schedule;


@Repository
public interface ScheduleRepository {

	
	@Select("select user_id, title, date, date_end, start_time from todo_manager")
	List<Schedule> findAll();
	
	@Insert("insert into todo_manager(user_id, title, date, date_end, allday, start_time) values(#{userId},#{title},#{date},#{dateEnd},#{allDay},#{startTime})")
	void insertNewTodo(Schedule schedule);
	
	@Insert("insert into todo_manager(user_id, title, date) values(#{userId},#{title},#{date})")
	void insertNewTodoNull1(Schedule schedule);
	
	@Insert("insert into todo_manager(user_id, title, date, date_end) values(#{userId},#{title},#{date},#{dateEnd})")
	void insertNewTodoNull2(Schedule schedule);
	
	@Insert("insert into todo_manager(user_id, title, date, start_time) values(#{userId},#{title},#{date},#{startTime})")
	void insertNewTodoNull3(Schedule schedule);
	

	@Delete("delete from todo_manager where title = #{title} AND date=#{date}")
	void deleteTodo(Schedule schedule);
	
	
}
