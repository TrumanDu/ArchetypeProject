package com.aibibang.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/** 
* @author: Truman.P.Du 
* @since: 2016年11月24日 下午9:20:14 
* @version: v1.0
* @description:
*/
public class SocketAPIUtil {

	public String query(String host, int port, String message) {

		Socket socket = null;
		DataInputStream is = null;
		DataOutputStream os = null;
		String result = null;
		byte[] resultMessage = new byte[2000];
		try {
			socket = new Socket(host, port);
			is = new DataInputStream(socket.getInputStream());
			os = new DataOutputStream(socket.getOutputStream());

			os.write(message.getBytes());
			os.flush();

			is.read(resultMessage);
			result = new String(resultMessage);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
				os.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	}

}
