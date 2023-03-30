package com.trillon.camp.comewithme.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.trillon.camp.comewithme.dto.Answer;
import com.trillon.camp.comewithme.dto.ComeWithMeBoard;
import com.trillon.camp.comewithme.service.ComeWithMeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("comewithme")
public class ComeWithMeController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final ComeWithMeService comeWithMeService;

	@GetMapping("comeWithMeList") // 동행인 구인 게시글 목록
	public String comeWithMeList(Model model, @RequestParam(required = false, defaultValue="1")int page) {
		System.out.println("comeWithMeList1");
		model.addAllAttributes(comeWithMeService.selectBoardList(page));
		return "/comewithme/comeWithMeList";
	}
	
	@GetMapping("detail") // 상세보기
	public String boardContent(int bdIdx, Model model) {
		System.out.println("detail get mapping : " + bdIdx);
		Map<String, Object> commandMap = comeWithMeService.selectBoardContentByBdIdx(bdIdx);
		model.addAllAttributes(commandMap);
		System.out.println("detail get mapping: " + commandMap);
		return "comewithme/detail";
	}
	
	@GetMapping("comeWithMeCreateBoard") // 같이갈래 게시판 생성 1-1
	public void comeWithMeBoard() {
		System.out.println("comeWithMeCreateBoard Get");
	}
	
	@PostMapping("upload") // 게시판 생성 1-2
	public String upload(@RequestParam List<MultipartFile> files, ComeWithMeBoard board) throws UnsupportedEncodingException {
		
		board.setTitle(new String(board.getTitle().getBytes("8859_1"),"utf-8"));
		board.setContent(new String(board.getContent().getBytes("8859_1"),"utf-8"));
		board.setPlace(new String(board.getPlace().getBytes("8859_1"),"utf-8"));
		board.setCampingWay(new String(board.getCampingWay().getBytes("8859_1"),"utf-8"));
		board.setAgeAverage(new String(board.getAgeAverage().getBytes("8859_1"),"utf-8"));
		board.setGender(new String(board.getGender().getBytes("8859_1"),"utf-8"));
		
		System.out.println("upload post : " + board);
		comeWithMeService.insertBoard(board, files);
		return "redirect:/comewithme/comeWithMeList";
	}
	
	
	
	@GetMapping("comeWithMeMatch") // 매칭 시작 1-1
	public void comeWihMeSelect() {
		System.out.println("Get comeWithMeMatch");
	}
	
	@PostMapping("comeWithMeMatch") // 매칭 시작 1-2
	@ResponseBody // 비동기 응답
	public void matchFinish(@RequestBody Answer answer,HttpSession session) {
		List<ComeWithMeBoard> boardList;
		boardList = comeWithMeService.selectMatchList(answer);
		if(boardList != null) {
			//System.out.println("success");
			session.setAttribute("comeWithMeBoard", boardList);
		}else {
			System.out.println("fail");
		}
		//System.out.println("Post : Match");
	}
	
	@GetMapping("matchFinish") // 매칭 결과
	public void matchFinish(Model model, HttpSession session, Answer answer) {
		System.out.println("matchFinish");
		List<ComeWithMeBoard> boardList = (List<ComeWithMeBoard>) session.getAttribute("comeWithMeBoard");
		model.addAttribute("boardList", boardList);
		
		System.out.println("get matchFinish: " + boardList);
		System.out.println("get matchFinish: " + session.getAttribute("boardList"));
	}
	
	@GetMapping("modify") // 게시판 수정 1-1
	public String modify(int bdIdx, Model model) {
		System.out.println("get modify: " + bdIdx);
		Map<String, Object> commandMap = comeWithMeService.selectBoardContentByBdIdx(bdIdx);
		model.addAllAttributes(commandMap);
		return "/comewithme/comeWithMe-Modify";
	}
	
	@PostMapping("modify") // 게시판수정 1-2
	public String modify(@RequestBody ComeWithMeBoard board) {
		System.out.println("modify post : " + board);
		//System.out.println(board.getBdIdx());
		comeWithMeService.updateBoard(board);
		return "redirect:/comewithme/detail?bdIdx="+board.getBdIdx();
	}
	
	@GetMapping("remove") // 게시판 삭제
	public String remove(int bdIdx) {
		System.out.println("remove : " + bdIdx);
		comeWithMeService.deleteBoardByBdIdx(bdIdx);
		return "redirect:/comewithme/comeWithMeList";
	}
	
	

	
}
