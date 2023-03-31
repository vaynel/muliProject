package com.trillon.camp.suggest.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.trillon.camp.common.paging.Paging;
import com.trillon.camp.suggest.dto.APIParsing;
import com.trillon.camp.suggest.dto.Answer;
import com.trillon.camp.suggest.dto.Campsite;

@Repository
public interface SuggestRepository {

	
	@Insert("insert into CampingData (addr1, doNm,sigunguNm , facltDivNm, facltNm,featureNm,intro,lctCl,lineIntro,mapX,mapY,resveUrl,tel,firstImageUrl,homepage,induty,tooltip) "
			+ "values(#{addr1}, #{doNm},#{sigunguNm}, #{facltDivNm},#{facltNm},#{featureNm},#{intro} , #{lctCl},#{lineIntro},#{mapX}, #{mapY}, #{resveUrl},#{tel},#{firstImageUrl}, #{homepage}, #{induty},#{tooltip})")
	void insertNewCampingData(APIParsing testData);

	
	
	@Select("select * from campingData where (doNm=#{doNm} and sigunguNm=#{sigunguNm}) and (lctCl like #{lctCl}) and (induty like #{induty})")
	List<Campsite> findCampingByAnswer(Answer answer);


	@Select("select * from campingData where (doNm=#{doNm} and sigunguNm=#{sigunguNm}) and (induty like #{induty})")
	List<Campsite> findCampingByAnswerWithoutInduty(Answer answer);


	@Select("select * from campingData")
	List<Campsite> selectAllCampsite();


	@Select("select count(*) from campingData")
	int countAllCampsite();
	
	@Select("select count(*) from campingData where (doNm=#{doNm} and sigunguNm=#{sigunguNm}) and (induty like #{induty})")
	int countCampsiteByAnswer(Answer answer);


	@Select("select count(*)from campingData where (doNm=#{doNm} and sigunguNm=#{sigunguNm}) and (induty like #{induty})")
	int countCampsiteByAnswerWithoutLctCl(Answer answer);


	@Select("select * from campingdata order by campingIdx limit #{start}, #{cntPerPage}")
	List<Campsite> selectCampsiteByPage(Paging paging);


	@Select("select * from campingData "
			+ "where (doNm=#{answer.doNm} and sigunguNm=#{answer.sigunguNm}) and (lctCl like #{answer.lctCl}) and (induty like #{answer.induty}) "
			+ " order by campingIdx limit #{paging.start}, #{paging.cntPerPage}")
	List<Campsite> selectCampsiteByAnswerWithPage(Map<String, Object> command);


	@Select("select * from campingData "
			+ "where (doNm=#{answer.doNm} and sigunguNm=#{answer.sigunguNm}) and (induty like #{answer.induty}) "
			+ " order by campingIdx limit #{paging.start}, #{paging.cntPerPage}")
	List<Campsite> selectCampsiteByAnswerWithPageWithoutLctCl(Map<String, Object> command);


	

}
