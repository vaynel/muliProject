package com.trillon.camp.comewithme.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trillon.camp.comewithme.dto.Answer;
import com.trillon.camp.comewithme.dto.ComeWithMeBoard;
import com.trillon.camp.comewithme.service.ComeWithMeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("comewithme")
public class ComeWithMeController {
	
	private final ComeWithMeService comeWithMeService;

	@GetMapping("comeWithMeList") // 동행인 구인 게시글 목록
	public String comeWithMeList(Model model, @RequestParam(required = false, defaultValue="1")int page) {
		System.out.println("comeWithMeList1");
		model.addAllAttributes(comeWithMeService.selectBoardList(page));
		return "/comewithme/comeWithMeList";
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
	public void matchFinish(@RequestBody Answer answer, Model model, @RequestParam(required = false, defaultValue="1")int page) {
		Map<String, Object> comeWithMeBoard;
		comeWithMeBoard = comeWithMeService.selectMatchList(answer);
		model.addAllAttributes(comeWithMeService.selectMatchList(answer));
		System.out.println("Post : Match");
	}
	
	@GetMapping("matchFinish")
	public void matchFinish(Model model, @RequestParam(required = false, defaultValue="1")int page, Answer answer) {
		System.out.println("matchFinish");
		model.addAllAttributes(comeWithMeService.selectMatchList(answer));
	}
	

	
}
