package com.trillon.camp.comewithme.controller;

<<<<<<< Updated upstream
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trillon.camp.comewithme.dto.Answer;
import com.trillon.camp.comewithme.dto.ComeWithMeBoard;
import com.trillon.camp.comewithme.service.ComeWithMeService;
=======
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> Stashed changes

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("comewithme")
public class ComeWithMeController {
<<<<<<< Updated upstream
	
	private final ComeWithMeService comeWithMeService;

	@GetMapping("comeWithMeList") // 동행인 구인 게시글 목록
	public String comeWithMeList(Model model, @RequestParam(required = false, defaultValue="1")int page) {
		System.out.println("comeWithMeList1");
		model.addAllAttributes(comeWithMeService.selectBoardList(page));
		return "/comewithme/comeWithMeList";
	}
	
	@GetMapping("detail") // 상세보기
	public String boardContent(int bdIdx, Model model) {
		System.out.println("detail get mapping");
		Map<String, Object> commandMap = comeWithMeService.selectBoardContentByBdIdx(bdIdx);
		model.addAllAttributes(commandMap);
		return "comewithme/detail";
	}
	
	@GetMapping("comeWithMeCreateBoard") // 같이갈래 게시판 생성
	public void comeWithMeBoard() {
		System.out.println("comeWithMeCreateBoard");
	}
	
	@GetMapping("comeWithMeMatch") // 매칭 시작
	public void comeWihMeSelect() {
		System.out.println("Get : comeWithMeMatch");
	}
	
	@PostMapping("comeWithMeMatch")
	@ResponseBody // 비동기 응답
	public void matchFinish(@RequestBody Answer answer,HttpSession session) {
		List<ComeWithMeBoard> boardList;
		boardList = comeWithMeService.selectMatchList(answer);
		if(boardList != null) {
			System.out.println("success");
			session.setAttribute("comeWithMeBoard", boardList);
		}else {
			System.out.println("fail");
		}
		System.out.println("Post : Match");
	}
	
	@GetMapping("matchFinish") // 매칭 결과
	public void matchFinish(Model model, HttpSession session, Answer answer) {
		System.out.println("matchFinish");
		List<ComeWithMeBoard> boardList = (List<ComeWithMeBoard>) session.getAttribute("comeWithMeBoard");
		model.addAttribute("boardList", boardList);
		
		System.out.println("matchFinish: " + boardList);
		System.out.println("matchFinish: " + session.getAttribute("boardList"));
	}
	

=======

	@GetMapping("comeWithMeList") // 동행인 구인 게시글 목록
	public void comeWithMeList() {
		System.out.println("comeWithMeList");
	}
	
	@GetMapping("comeWithMeSelect") // 동행인 신청
	public void comeWihMeSelect() {
		System.out.println("comeWihMeSelect");
	}
	
	@GetMapping("comeWithMeBoard") // 게시판 생성
	public void comeWithMeBoard() {
		System.out.println("comeWithMeBoard");
	}
	
>>>>>>> Stashed changes
	
}
