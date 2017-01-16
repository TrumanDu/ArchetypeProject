package com.aibibang.controller.websocket;

import java.io.IOException;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

/** 
* @author: Truman.P.Du 
* @since: 2016年7月5日 下午7:56:50 
* @version: v1.0
* @description:
*/
public class WebSocketMessageSend {
	public static void sendMessage(WebSocketSession session, String message) {
		if (session != null && session.isOpen()) {
			try {
				session.sendMessage(new TextMessage(message + "\n"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
}
