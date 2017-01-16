package com.aibibang.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.aibibang.common.Constant;

public class SocketClient extends Thread{
	 static Socket socket;
     static BufferedReader in ;
     static PrintWriter out;
     static boolean flag=false;
	 static{
		 try {
			socket = new Socket(Constant.ADDRESS,Constant.PORT);
			flag=true;
			//socket.setKeepAlive(true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	 }
	 @Override
	public void run() {
		while(flag){
			try {
				String str = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				flag=false;
			}
		}
		
	}
	
	 
}
