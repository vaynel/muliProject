package com.trillon.camp.comewithme.controller;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.trillon.camp.comewithme.dto.Answer;
import com.trillon.camp.comewithme.dto.ComeWithMeBoard;
import com.trillon.camp.comewithme.service.ComeWithMeService;
import com.trillon.camp.group.dto.CampingGroup;
import com.trillon.camp.group.dto.GroupMember;
import com.trillon.camp.group.service.GroupSerivce;
import com.trillon.camp.groupChat.dto.ChatRoom;
import com.trillon.camp.groupChat.service.GroupChatService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("comewithme")
public class ComeWithMeController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final ComeWithMeService comeWithMeService;
	private final GroupChatService groupChatService;
	private final GroupSerivce	groupService;
	

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
	public String upload(@RequestParam List<MultipartFile> files, ComeWithMeBoard board, HttpSession session) throws UnsupportedEncodingException {
		System.out.println("upload post : " + board);
		System.out.println("upload post : " + files);
		
		
		
		CampingGroup campingGroup = new CampingGroup(); // 그룹 만들기
		campingGroup.setMaxMember(board.getNumOfPerson());
		campingGroup.setGroupMaster((String)session.getAttribute("loginId"));
		campingGroup.setCurrentMember(1);
		campingGroup.setGroupName(board.getGroupName());
		groupChatService.insertNewGroup(campingGroup);
		
		ChatRoom chatRoom = new ChatRoom();     // 채팅방 만들기
        Map<String, Object> commandMap = new HashMap<>();
        chatRoom.setRoomId();
        commandMap.put("roomId", chatRoom);
        commandMap.put("groupIdx", groupService.selectNewGampingGroupIdx());

        groupChatService.insertNewGroupChat(commandMap);
        
        Integer groupIdx = groupService.selectNewGampingGroupIdx();
        GroupMember member = new GroupMember();
        member.setUserId((String)session.getAttribute("loginId"));
        member.setGroupIdx(groupIdx);
        member.setRoomId(groupChatService.findRoomIdByGroupIdx(groupIdx));
        groupService.insertNewMemberToGroup(member);
		
		comeWithMeService.insertBoard(board, files);// 게시글 만들기
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
	
	
	@ResponseBody
	@GetMapping("/{groupName}/{savePath}/{fileName}")
	public Resource downloadImage(@PathVariable Object fileName,@PathVariable String groupName ,@PathVariable String savePath) throws MalformedURLException {
		System.out.println("여기 오고 있나요?");
        return new UrlResource("file:" + "C:/Program Files/CODE/storage" + "/" + groupName + "/" + savePath + fileName);
	}
	
	
	@PostMapping("memberInsert")
	public String memberInsert(GroupMember groupMember, ComeWithMeBoard board, HttpSession session) {
		System.out.println("멤버 추가하기 들어오나요");
		System.out.println("userId : " + session.getAttribute("loginId"));
		System.out.println("board : " + board.getBdIdx());
		
		return "redirect:/comewithme/detail?bdIdx="+board.getBdIdx();
	}

	
}
