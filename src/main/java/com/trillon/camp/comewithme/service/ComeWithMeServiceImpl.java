package com.trillon.camp.comewithme.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.trillon.camp.comewithme.common.file.FileInfo;
import com.trillon.camp.comewithme.common.file.FileRepositoryYG;
import com.trillon.camp.comewithme.common.file.FileUtilYG;
import com.trillon.camp.comewithme.common.page.Paging;
import com.trillon.camp.comewithme.dto.Answer;
import com.trillon.camp.comewithme.dto.ComeWithMeBoard;
import com.trillon.camp.comewithme.repository.ComeWithMeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComeWithMeServiceImpl implements ComeWithMeService{

	Logger logger =  LoggerFactory.getLogger(this.getClass());
	
	private final ComeWithMeRepository comeWithMeRepository;
	private final FileRepositoryYG fileRepository;
	private final FileUtilYG fileUtil;
	
	@Override
	public Map<String, Object> selectBoardList(int page){
		
		int total = comeWithMeRepository.countAllBoard();
		
		Paging paging = Paging.builder()
							  .cntPerPage(6)
							  .currentPage(page)
							  .total(total)
							  .blockCnt(5)
							  .build();
		
		
//		System.out.println(comeWithMeRepository.selectBoardList(paging));
		List<ComeWithMeBoard> boardList = comeWithMeRepository.selectBoardList(paging);
		for (ComeWithMeBoard comeWithMeBoard : boardList) {
			comeWithMeBoard.setCrDate(comeWithMeBoard.getRegDateAsDate());
			System.out.println(comeWithMeBoard.getRenameFileName());
		}
		
//		boardList=reverseList(boardList);
		return Map.of("boardList",boardList, "paging",paging);
	}

	@Override
	public List<ComeWithMeBoard> selectMatchList(Answer answer) {
		
		
		System.out.println("serviceimpl 41" + answer); // 산, 20대, 차박
		List<ComeWithMeBoard> boardList;
		
//		answer.setPlace("산");
//		answer.setCampingWay("차박");
//		answer.setAgeAverage("20대");
		
		boardList = comeWithMeRepository.selectMatchList(answer);
		System.out.println("serviceimpl 49" + comeWithMeRepository.selectMatchList(answer));
		
		return boardList;

	}

	@Override
	public Map<String, Object> selectBoardContentByBdIdx(int bdIdx) {
		ComeWithMeBoard boardList = comeWithMeRepository.selectBoardByBdIdx(bdIdx);
		logger.info("groupIdx :" + boardList.getBdIdx());
		List<FileInfo> files = fileRepository.selectFileWithGroup(bdIdx);
		for (FileInfo fileInfo : files) {
			logger.info("이미지 파일->" + fileInfo);
		}
		return Map.of("boardList", boardList, "files", files);
	}

	@Override
	public int insertBoard(ComeWithMeBoard board, List<MultipartFile> files) {
		
		logger.info("files"+ files);
		// DB에 board넣기
		comeWithMeRepository.insertBoard(board);
		
		int bdIdx = board.getBdIdx();
		System.out.println(bdIdx);
		
		FileInfo fileInfo = new FileInfo();
		fileInfo.setGroupName(board.getGroupName());
		fileInfo.setBdIdx(board.getBdIdx());
		fileInfo.setGroupIdx(board.getBdIdx());
		fileInfo.setBdIdx(bdIdx);
		fileUtil.uploadFile(fileInfo, files);
		System.out.println(files);
		return bdIdx;
	}

	@Override
	public void updateBoard(ComeWithMeBoard board) {
		comeWithMeRepository.updateBoard(board);
	}

	@Override
	public void deleteBoardByBdIdx(int bdIdx) {
		comeWithMeRepository.deleteBoardByBdIdx(bdIdx);
		
	}

	@Override
	public FileInfo selectFileInfo(String flIdx) {
		FileInfo fileInfo = fileRepository.selectFileInfo(flIdx);
		return fileInfo;
	}

	@Override
	public Integer returnGroupIdxByBdIdx(Integer bdIdx) {
		
		return comeWithMeRepository.returnGroupIdxByBdIdx(bdIdx);
	}

	
	public static<T> List<T> reverseList(List<T> list)
    {
        return list.stream()
                    .collect(Collectors.collectingAndThen(
                        Collectors.toCollection(ArrayList::new), lst -> {
                                                Collections.reverse(lst);
                                                return lst.stream();
                                            }
                    )).collect(Collectors.toCollection(ArrayList::new));
    }
	
	
	
	

}
