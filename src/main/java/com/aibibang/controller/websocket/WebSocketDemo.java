package com.aibibang.controller.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;


/** 
* @author: Truman.P.Du 
* @since: 2016年7月5日 下午3:56:08 
* @version: v1.0
* @description:
*/
@Controller
public class WebSocketDemo  {
	@MessageMapping("/hello")
    public String greeting() throws Exception {
        Thread.sleep(3000); // simulated delay
        return "Hello";
    }


}
