package com.trillon.camp.campingHome.file;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FileRepository {

    @Insert("insert into test2(origin_file_name, rename_file_name, save_path, gn_idx)"
            + " values(#{originFileName},#{renameFileName},#{savePath}, #{gn_idx})")
    void insertFileInfo(FileInfo fileInfo);

    @Select("select * from test2 where group_name gn_idx = #{gn_idx}")
    List<FileInfo> selectFileWithGroup(Map<String, Object> group);

}
