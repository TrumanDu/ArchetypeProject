package com.aibibang.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import com.aibibang.common.Constant;




/** 
* @author: Truman.P.Du 
* @since: 2016年11月24日 下午9:20:14 
* @version: v1.0
* @description:
*/
public class SocketAPIUtil {
     private static Logger log = LoggerFactory.getLogger(SocketAPIUtil.class);
     
	/**
	 * 
	 * 只负责获取设备信息
	 * 
	 * @param host
	 * @param port
	 * @param message
	 * @return
	 */
	public  static String query(String message) {

		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		String result = null;
		try {
			
			socket = new Socket(Constant.ADDRESS, Constant.PORT);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			out.write(message);
			out.flush();
			log.debug("wait.....");
			//System.out.println("wait.....");
			result = in.readLine();
			log.debug(result);
			//result = new String(resultMessage);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			////e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			try {
				if(in!=null){
					in.close();
				}
				if(out!=null){
					out.close();
				}
				if(socket!=null){
					socket.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				log.error(e.getMessage());
			}

		}
		return result;
	}
	
	
	
	/**
	 * 只负责用户操作
	 * @param host
	 * @param port
	 * @param message
	 * @return
	 */
	public  static String set(String message) {
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		String result = null;
		try {
			socket = new Socket(Constant.ADDRESS, Constant.PORT);
			socket.setSoTimeout(1000);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
			out.write(message);
			out.flush();
			log.debug("send message:"+message);
			System.out.println(message);
			
			result = in.readLine();
			System.out.println(result);
			log.debug("recived message:"+result);
			//result = new String(resultMessage);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.error(e.getMessage());
		} finally {
			try {
				if(in!=null){
					in.close();
				}
				if(out!=null){
					out.close();
				}
				if(socket!=null){
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				log.error(e.getMessage());
			}

		}
		return result;
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		
		
		
//		SocketAPIUtil socketAPIUtil =new SocketAPIUtil();
//		//socketAPIUtil.query("192.168.1.244", 6000, "12.5");
//		System.out.println(socketAPIUtil.query("192.168.1.244", 6000, "ack"));
	}
	

}
