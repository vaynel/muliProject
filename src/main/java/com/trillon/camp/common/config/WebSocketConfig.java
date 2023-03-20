//package com.trillon.camp.common.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//
//import com.trillon.camp.util.chat.ChatHandler;
//
//import lombok.RequiredArgsConstructor;
//
//@Configuration
//@RequiredArgsConstructor
//@EnableWebSocket
//public class WebSocketConfig  implements  WebSocketConfigurer{
//	
//	private final ChatHandler chatHandler;
//	
//	@Override
//	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//		registry.addHandler(chatHandler, "ws/chat")
//		.setAllowedOriginPatterns("http://*:8081", "http://*.*.*.*:8081")
//		.withSockJS()
//		.setClientLibraryUrl("http://localhost:8081/myapp/js/sock-client.js");
//		
//	}
//
//	
//
//}
