package com.trillon.camp.campingHome.file;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository {

    @Insert("insert into test2(origin_file_name, rename_file_name, save_path, gn_idx)"
            + " values(#{originFileName},#{renameFileName},#{savePath}, #{gnIdx})")
    void insertFileInfo(FileInfo fileInfo);

    @Select("select * from test2 where gn_idx = #{bdIdx}")
    List<FileInfo> selectFileWithGroup(int bdIdx);

    //@Delete("delete * from test2 where rename_file_name = #{renameFileName}")

}
