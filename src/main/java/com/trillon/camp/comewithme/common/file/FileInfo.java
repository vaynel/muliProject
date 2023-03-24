package com.trillon.camp.comewithme.common.file;

import java.time.LocalDateTime;

import com.trillon.camp.comewithme.common.code.Code;

import lombok.Data;

@Data
public class FileInfo {
	
	private int flIdx;
	private String originFileName;
	private String renameFileName;
	private String savePath;
	private LocalDateTime regDate;
	private boolean isDel;
	private String groupName;
	private int gnIdx;
	
	public String getFullPath() {
		return Code.STORAGE_PATH + groupName + "/" + savePath + renameFileName;
	}

}
