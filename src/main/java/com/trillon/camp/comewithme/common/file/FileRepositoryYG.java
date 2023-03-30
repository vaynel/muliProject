package com.trillon.camp.comewithme.common.file;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepositoryYG {

	@Insert("insert into file_path(origin_file_name, rename_file_name, save_path, group_name)"
			+ " values(#{originFileName},#{renameFileName},#{savePath},#{groupName})")
	void insertFileInfo(FileInfo fileInfo);
}
