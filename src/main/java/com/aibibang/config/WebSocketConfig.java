package com.aibibang.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.aibibang.controller.websocket.SocketHandler;

/** 
* @author: Truman.P.Du 
* @since: 2016年7月5日 下午1:33:55 
* @version: v1.0
* @description:
*/
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
	@Autowired
	private SocketHandler webSocketHandler;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    	registry.addHandler(webSocketHandler, "/console");
    }
}
