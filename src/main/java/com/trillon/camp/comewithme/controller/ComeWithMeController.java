package com.trillon.camp.comewithme.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("comeWithMeMatch") // 동행인 신청
	public void comeWihMeSelect() {
		System.out.println("comeWithMeMatch");
	}
	
	@GetMapping("comeWithMeCreateBoard") // 게시판 생성
	public void comeWithMeBoard() {
		System.out.println("comeWithMeCreateBoard");
	}
	
	
}
