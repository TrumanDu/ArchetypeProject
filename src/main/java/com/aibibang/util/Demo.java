package com.aibibang.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Demo {
	static Socket server;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			server = new Socket("192.168.1.244",6000);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			PrintWriter out = new PrintWriter(server.getOutputStream());
			
			
			while(true){
				System.out.println("等待。。。。");
				String str = in.readLine();
				/*char[] cbuf = new char[74];
				int int_rec=in.read(cbuf);
				System.out.println(int_rec);
				String str = String.valueOf(cbuf);*/
				
				System.out.println("收到："+str);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

}
