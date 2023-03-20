package com.trillon.camp.util.chat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.socket.WebSocketSession;

import com.trillon.camp.util.chat.service.ChatRoomService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("chat")
public class RoomController {

		private final ChatRoomService chatRoomservice;
		
		Logger log = LoggerFactory.getLogger(this.getClass());
		
		@GetMapping("/rooms")
		public ModelAndView rooms() {
			log.info("# All Chat Rooms");
	        ModelAndView mv = new ModelAndView("chat/rooms");

	        mv.addObject("list", chatRoomservice.findAllRooms());

	        return mv;
		}
		
		
		//채팅방 개설
	    @PostMapping(value = "/room")
	    public String create(@RequestBody String rname, RedirectAttributes rttr){
	    	
	        log.info("# Create Chat Room , name: " + rname);
	        rttr.addFlashAttribute("roomName", chatRoomservice.createChatRoom(rname));
	        return "redirect:/chat/rooms";
	    }

	    //채팅방 접속
	    @GetMapping("/room")
	    public void getRoom(@RequestParam("roomId") String roomId, Model model){

	        log.info("# get Chat Room, roomID : " + roomId);
	        

	        model.addAttribute("room", chatRoomservice.findRoomById(roomId));
	    }
}
