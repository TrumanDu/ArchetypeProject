package com.aibibang.controller.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.aibibang.model.SoftInfo;
import com.aibibang.service.SoftMapper;

/** 
* @author: Truman.P.Du 
* @since: 2016年7月5日 下午7:38:48 
* @version: v1.0
* @description:
*/
@Component
public class SocketHandler implements WebSocketHandler {
	private static final Logger logger = LoggerFactory.getLogger(SocketHandler.class);
	@Autowired
	private SoftMapper softMapper;
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub 
		logger.debug("onOpen");
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> webSocketMessage) throws Exception {
		// TODO Auto-generated method stub
		 String message = (String) webSocketMessage.getPayload();
		 logger.debug(message);
		 String[] array = message.split(":");
		 SoftInfo softInfo = softMapper.getSoftInfoById(Integer.parseInt(array[1]));
		 
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		logger.debug("onError");
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("onClose");
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
