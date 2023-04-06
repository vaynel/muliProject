package com.trillon.camp.comewithme.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.trillon.camp.campingHome.board.service.BoardService;
import com.trillon.camp.comewithme.dto.Answer;
import com.trillon.camp.comewithme.dto.ComeWithMeBoard;
import com.trillon.camp.comewithme.service.ComeWithMeService;
import com.trillon.camp.group.dto.CampingGroup;
import com.trillon.camp.group.dto.GroupMember;
import com.trillon.camp.group.service.GroupSerivce;
import com.trillon.camp.groupChat.dto.ChatRoom;
import com.trillon.camp.groupChat.service.GroupChatService;
import com.trillon.camp.members.dto.Member;
import com.trillon.camp.members.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("comewithme")
public class ComeWithMeController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final ComeWithMeService comeWithMeService; 	
	private final GroupChatService groupChatService;
	private final GroupSerivce	groupService;
	private final MemberService memberService;
	

	@GetMapping("comeWithMeList") // 동행인 구인 게시글 목록
	public String comeWithMeList(Model model, @RequestParam(required = false, defaultValue="1")int page) {
		System.out.println("comeWithMeList1");
		 Map<String, Object> test = comeWithMeService.selectBoardList(page);

		model.addAllAttributes(comeWithMeService.selectBoardList(page));
		// 이미지 파일에 관한 정보를 담아야함
		// 그냥 boardlist에 left join을 3개 시켜서 받아버림
		
		
		
		
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
        
        
		board.setGroupIdx(groupIdx);
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
	
	
	
	
	
	// 그룹에 멤버에 추가
	@PostMapping("memberInsert")
	public String memberInsert(ComeWithMeBoard board, HttpSession session, RedirectAttributes redirectAttr) {
		System.out.println("멤버 추가하기 들어오나요");
		System.out.println("userId : " + session.getAttribute("loginId"));
		System.out.println("board : " + board.getBdIdx());
		System.out.println(board);
		
		// 멤버 생성
		Member user = memberService.idCheckRetrunMember((String)session.getAttribute("loginId"));
		if(user==null) user = memberService.idCheckGoogleReturnMember((String)session.getAttribute("loginId"));
		Integer groupIdx = comeWithMeService.returnGroupIdxByBdIdx(board.getBdIdx());
		// session이 죽어서 다시 로그인 창으로 보냄
		if(user==null) return "redirect:/members/login";
		
		Member master = memberService.idCheckRetrunMember(groupService.findMasterBygroupIdx(groupIdx));
		
		
		GroupMember groupMember = new GroupMember();
		groupMember.setGroupIdx(Integer.valueOf(groupIdx) );
		groupMember.setUserId(user.getUserId());
		groupMember.setRoomId(groupChatService.findRoomIdByGroupIdx(Integer.valueOf(groupIdx) ));
		
		// 멤버 검사 후 메일 보내기 하기 
		if(groupService.checkMemberToGroup(groupMember)) {
			CampingGroup campingGroup = groupService.findCampingGroupByGroupIdx(groupIdx);
			if(campingGroup.getCurrentMember() < campingGroup.getMaxMember()) {
				
				System.out.println("새로운 멤버 그룹에 추가 메일 보냈음");
				redirectAttr.addFlashAttribute("msg", "새로운 멤버 추가 메일을 그룹장에게 보냈습니다.");
				// 그룹장에게 신청 메일 보내기
				groupService.sendMailToGroupMaster(groupIdx,user,master);
			}
			else {
				System.out.println("그룹에 사람이 다 찼음");
				redirectAttr.addFlashAttribute("msg", "그룹에 사람이 다 찼습니다.");
				return "redirect:/comewithme/detail?bdIdx="+board.getBdIdx();
			}
		}
		else{
			System.out.println("같은 멤버가 추가 하려해서 반환함");
			redirectAttr.addFlashAttribute("msg", "이미 그룹에 속해 있습니다.");
			return "redirect:/comewithme/detail?bdIdx="+board.getBdIdx();
		}
	
		return "redirect:/comewithme/detail?bdIdx="+board.getBdIdx();
	}

	
}
