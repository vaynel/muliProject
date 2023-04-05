package com.trillon.camp.comewithme.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.trillon.camp.comewithme.common.page.Paging;
import com.trillon.camp.comewithme.dto.Answer;
import com.trillon.camp.comewithme.dto.ComeWithMeBoard;

@Repository
public interface ComeWithMeRepository {
	
	@Insert("insert into comewithme_board(title, content, num_of_person, place, camping_way, age_average, gender,group_idx) "
			+ "values(#{title}, #{content}, #{numOfPerson}, #{place}, #{campingWay}, #{ageAverage}, #{gender},#{groupIdx})")
	@Options(useGeneratedKeys = true, keyProperty = "bdIdx")
	public void insertBoard(ComeWithMeBoard board);

	@Select("select count(*) from comewithme_board where is_del = 0")
	public int countAllBoard();
	
	@Select("select a.* , b.* "
			+ "from comewithme_board a left join camping_group b "
			+ " on a.group_idx = b.group_idx"
			+ " where a.is_del = 0 and b.activate = 1 "
			+ " order by ${sortColumn} ${sortDirection} limit #{start}, #{cntPerPage}")
	List<ComeWithMeBoard> selectBoardList(Paging paging);


	@Select("select * from comewithme_board where place = #{place} and camping_way = #{campingWay} and age_average = #{ageAverage} ")
	List<ComeWithMeBoard> selectMatchList(Answer answer);
	
	@Select("select * from comewithme_board where is_del = 0 and bd_idx = #{bdIdx}")
	ComeWithMeBoard selectBoardByBdIdx(int bdIdx);

	@Update("update comewithme_board set title = #{title}, content = #{content}, num_of_person=#{numOfPerson}, place=#{place}, camping_way=#{campingWay}, age_average=#{ageAverage}, gender=#{gender}"
			+ "where is_del = 0 and bd_idx = #{bdIdx}")
	int updateBoard(ComeWithMeBoard board);

	@Update("update comewithme_board set is_del = 1 where bd_idx = #{bdIdx}")
	int deleteBoardByBdIdx(int bdIdx);

	
	@Select("select group_idx from comewithme_board where bd_idx=#{bdIdx}")
	public Integer returnGroupIdxByBdIdx(Integer bdIdx);
	


}


























