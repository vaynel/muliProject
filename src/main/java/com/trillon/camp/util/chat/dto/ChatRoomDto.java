package com.trillon.camp.util.chat.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.web.socket.WebSocketSession;

import lombok.Data;

@Data
public class ChatRoomDto {
	
	private String roomId;
    private String groupName;
    private Set<WebSocketSession> sessions = new HashSet<>();
    //WebSocketSession은 Spring에서 Websocket Connection이 맺어진 세션

    
    
    public static ChatRoomDto create(String groupName){
        ChatRoomDto room = new ChatRoomDto();

        room.roomId = UUID.randomUUID().toString();
        room.groupName = groupName;
        return room;
    }

	public void setRoomId() {
		this.roomId = UUID.randomUUID().toString();
	}
    

}
