package com.trillon.camp.comewithme.common.file;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.trillon.camp.comewithme.common.code.Code;
import com.trillon.camp.comewithme.common.code.ErrorCode;
import com.trillon.camp.comewithme.common.exception.HandlableException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FileUtilYG {
	
	private final FileRepositoryYG fileRepository;
	
	public void uploadFile(FileInfo fileInfo, List<MultipartFile> files) {
		
		List<FileInfo> fileInfos = new ArrayList<FileInfo>();
		
		// 2. 파일 업로드
		for (MultipartFile multipartFile : files) {
			if(multipartFile.isEmpty()) continue;
			
			FileInfo file = new FileInfo();
			
			String uploadPath = createUploadPath(fileInfo);
			String originFileName = multipartFile.getOriginalFilename();
			String renameFileName = createRenameFileName(originFileName);
			
			file.setGroupName(fileInfo.getGroupName());
			file.setOriginFileName(originFileName);
			file.setRenameFileName(renameFileName);
			file.setSavePath(uploadPath);
			
			fileInfos.add(file);
			
			transferFile(multipartFile, file);
			
		}
		
		// 3. 파일메타데이터를 file-info 테이블에 insert
		for (FileInfo file : fileInfos) {
			fileRepository.insertFileInfo(file);
		}
	}
	
	private File transferFile(MultipartFile multipartFile, FileInfo fileInfo) {
		
		File dest = new File(fileInfo.getFullPath());
		 
		 try {
			multipartFile.transferTo(dest);
		} catch (IllegalStateException | IOException e) {
			throw new HandlableException(ErrorCode.FAILED_UPLOAD_FILE, e);
		}
		 
		return dest;
	}
	
	private String createUploadPath(FileInfo fileInfo) {
		// 폴더를 기능, 일자별로 생성, 지나치게 많은 파일이 저장된 폴더는 열리지 않음
		LocalDate now =  LocalDate.now();
		String uploadPath = now.getYear() + "/" + now.getMonthValue() + "/" + now.getDayOfMonth() + "/";
		new File(Code.STORAGE_PATH + fileInfo.getGroupName()  + "/" + uploadPath).mkdirs();
		
		return uploadPath;
	}
	
	private String createRenameFileName(String originFileName) {
		// 파일이름을 유니크하게 변경, 만약 다른 사용자가 같은 이름의 파일을 업로드하면 덮어써지거나, 에러가 나기 때문
		String subfix = "";
		
		if(originFileName.contains(".")){
			subfix = originFileName.substring(originFileName.lastIndexOf("."));
		}

		return UUID.randomUUID().toString().substring(0, 8) + subfix; 
	}

	
	

}
