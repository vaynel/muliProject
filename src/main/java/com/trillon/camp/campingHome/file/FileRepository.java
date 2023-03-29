package com.trillon.camp.campingHome.file;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository {

    @Insert("insert into test2(origin_file_name, rename_file_name, save_path, gn_idx)"
            + " values(#{originFileName},#{renameFileName},#{savePath}, #{gnIdx})")
    @Options(useGeneratedKeys = true, keyProperty = "fileIdx")
    void insertFileInfo(FileInfo fileInfo);

    @Select("select * from test2 where gn_idx = #{bdIdx}")
    List<FileInfo> selectFileWithGroup(int bdIdx);

    //@Select("SELECT * FROM test2 where (gn_idx=) = (select min(file_idx) FROM test2);")
    List<FileInfo> selectFirstFile();

    //@Delete("delete * from test2 where rename_file_name = #{renameFileName}")
}
