package com.trillon.camp.comewithme.common.file;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepositoryYG {

	@Insert("insert into file_info(origin_file_name, rename_file_name, save_path, group_name, gn_idx)"
			+ " values(#{originFileName},#{renameFileName},#{savePath},#{groupName}, #{gnIdx})")
	void insertFileInfo(FileInfo fileInfo);
}
