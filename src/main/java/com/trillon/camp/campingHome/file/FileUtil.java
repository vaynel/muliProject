package com.trillon.camp.campingHome.file;

import com.trillon.camp.common.code.ErrorCode;
import com.trillon.camp.common.exception.HandlableException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FileUtil {

    private final FileRepository fileRepository;

    public void uploadFile(FileInfo fileInfo, List<MultipartFile> files){

        List<FileInfo> fileInfos = new ArrayList<FileInfo>();

        for(MultipartFile multipartFile : files){
            if(multipartFile.isEmpty()) continue;

            FileInfo file = new FileInfo();

            String uploadPath = createUploadPath(fileInfo);
            String originFileName = multipartFile.getOriginalFilename();
            String renameFileName = createRenameFileName(originFileName);

            file.setGnIdx(fileInfo.getGnIdx());
            file.setOriginFileName(originFileName);
            file.setRenameFileName(renameFileName);
            file.setSavePath(uploadPath);

            fileInfos.add(file);

            transferFile(multipartFile, file);
        }

        for (FileInfo file : fileInfos) {
                fileRepository.insertFileInfo(file);
        }
    }

    private File transferFile(MultipartFile multipartFile, FileInfo fileInfo) {

        File dest = new File(fileInfo.getFullPath());

        try{
            multipartFile.transferTo(dest);
        }catch (IllegalStateException | IOException e) {
                throw new HandlableException(ErrorCode.FAILED_UPLOAD_FILE, e);
        }
        return dest;
    }

    private String createRenameFileName(String originFileName) {
        // 파일이름을 uuid를 활용해 unique하게 변경 + 확장자 추가
        String uuid = UUID.randomUUID().toString();
        int pos = originFileName.lastIndexOf(".");
        String ext = originFileName.substring(pos + 1);

        return uuid + "." + ext;
    }

    private String createUploadPath(FileInfo fileInfo){
        new File(fileInfo.STORAGE_PATH + fileInfo.getGnIdx() +"/").mkdirs();
        String uploadPath = fileInfo.STORAGE_PATH + fileInfo.getGnIdx() + "/" ;
        return uploadPath;
    }



}
