package com.trillon.camp.comewithme.common.file;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


@Repository
public interface FileRepositoryYG {

	@Insert("insert into file_info(origin_file_name, rename_file_name, save_path, group, group_idx)"
			+ " values(#{originFileName},#{renameFileName},#{savePath},#{group},#{groupIdx})")
	void insertFileInfo(FileInfo fileInfo);
	
	@Select("select * from file_info where is_del = 0 and fl_idx=#{flIdx}")
	FileInfo selectFileInfo(String flIdx);

	@Select("select * from file_info where is_del = 0 and group = #{group} and group_idx = #{groupIdx}")
	List<FileInfo> selectFileWithGroup(Map<String, Object> group);
	
	@Update("update file_info set is_del = 1 where group = #{group} and group_idx = #{groupIdx} ")
	void deleFileByGroup(Map<String, Object> of);
	
	@Update("update file_info set is_del = 1 where fl_idx = #{flIdx}")
	void delFileByFlIdx(String flIdx);
}
