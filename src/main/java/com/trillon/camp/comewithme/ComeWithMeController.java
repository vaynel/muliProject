package com.trillon.camp.comewithme;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("comewithme")
public class ComeWithMeController {

	@GetMapping("comeWithMeList") // 동행인 구인 게시글 목록
	public void comeWithMeList() {
		System.out.println("comeWithMeList");
	}
	
	@GetMapping("comeWithMeSelect") // 동행인 신청
	public void comeWihMeSelect() {
		System.out.println("comeWihMeSelect");
	}
	
}
