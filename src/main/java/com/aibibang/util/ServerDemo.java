package com.aibibang.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.aibibang.common.Constant;

public class ServerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     try {
		ServerSocket server = new ServerSocket(6000);
		while(true){
			Socket socket = server.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			String message = in.readLine();
			System.out.println(message);
			if(message.equals(Constant.DEV_INFO_ITHOR)){
				String result = Constant.DEV_INFO_ITHOR+",fix_reader,192.168.0.2,fe80::ec28:8b54:ab4a:5cff%6,你好1,你好1,6,7,8,9,10,11;iTHOR,fix_reader,192.168.0.1,fe80::ec28:8b53:ab4a:5cff%6,你好,你好,6,7,8,9,10,11\n";
				System.out.println("send....");
				out.write(result);
				out.flush();
			}
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	}
	}

}
