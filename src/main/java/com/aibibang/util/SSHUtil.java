package com.aibibang.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.WebSocketSession;

import com.aibibang.controller.websocket.WebSocketMessageSend;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;

/**
 * ssh工具类
 * @author td20
 *
 */
public class SSHUtil {

	private static final Logger logger = LoggerFactory.getLogger(SSHUtil.class);

	static protected String charset = "UTF-8"; // 设置编码格式  

	static protected int jschPort =22;//主机端口  

	static protected int jschTimeOut =3000;//设置连接超时时间  
	
	static long interval = 1000L; 



	/** 
	 * 连接到指定的linux服务器 
	 * 
	 * @throws com.jcraft.jsch.JSchException 
	 */
	public static Session getConnect(String jschUserName,String jschHost,String jschPassWord) throws JSchException {
		JSch jsch = new JSch();// 创建JSch对象  
		Session session = jsch.getSession(jschUserName, jschHost, jschPort);// // 根据用户名，主机ip，端口获取一个Session对象  
		logger.debug("Session created.");
		if (jschPassWord != null) {
			session.setPassword(jschPassWord); // 设置密码  
		}
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);// 为Session对象设置properties  
		session.setTimeout(jschTimeOut);//设置连接超时时间  
		session.connect();
		logger.debug("Session connected.");
		logger.debug("Connected successfully to jschHost = " + jschHost + ",as jschUserName = " + jschUserName
				+ ",as jschPort =  " + jschPort);
		return session;
	}

	/** 
	 * 执行相关的命令 
	 * @return 
	 */
	public static String execCmd(String jschUserName,String jschHost,String jschPassWord,String cmd) {
		BufferedReader reader = null;
		Channel channel = null;
		Session session = null;
		StringBuilder result = new StringBuilder();
		try {
			session = getConnect(jschUserName,jschHost,jschPassWord);//建立服务器连接  
				channel = session.openChannel("exec");
				((ChannelExec) channel).setCommand(cmd);
				channel.setInputStream(null);
				((ChannelExec) channel).setErrStream(System.err);

				channel.connect();
				InputStream in = channel.getInputStream();
				reader = new BufferedReader(new InputStreamReader(in,
						Charset.forName(charset)));
				String buf = null;
				while ((buf = reader.readLine()) != null) {
					result.append(buf);
				}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSchException e) {
			e.printStackTrace();
		} finally {
			/*try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			channel.disconnect();
			session.disconnect();*/
		}
		return result.toString();
	}
	
	
	/** 
	 * 执行相关的命令 
	 * @return 
	 */
	public static String shellCmd(String jschUserName,String jschHost,String jschPassWord,String cmd) {
		Session session = null;
		ChannelShell channelShell = null;
		String context = "";
		try {
			session = getConnect(jschUserName,jschHost,jschPassWord);//建立服务器连接 
			channelShell = (ChannelShell) session.openChannel("shell");
			
			OutputStream output=channelShell.getOutputStream();
			channelShell.connect();
			output.write(cmd.getBytes());
			output.flush();
			//channelShell.setOutputStream(System.out);
			
			InputStream in = channelShell.getInputStream();

			int time = 5 * 5;
			byte[] contents = new byte[1024];
			while(time > 0){
				time--;
				while(in.available() > 0) {
					int i = in.read(contents, 0, 1024);
					if(i > 0){
						context += new String(contents, 0, i);
					}
				}
				Thread.sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			channelShell.disconnect();
			session.disconnect();
		}
		logger.debug("shellCmd. result:"+context);
		return context.trim();
	}

	/** 
	 * 上传文件 
	 * 
	 * @param directory 上传的目录,有两种写法１、如/opt，拿到则是默认文件名２、/opt/文件名，则是另起一个名字 
	 * @param uploadFile 要上传的文件 如/opt/xxx.txt 
	 */
	public static boolean upload(WebSocketSession webSocketSession,String directory, String uploadFile,String jschUserName,String jschHost,String jschPassWord) {
		Channel channel = null;
		Session session = null;
		ChannelSftp chSftp = null;
		boolean flag =false ;
		try {
			session = getConnect(jschUserName,jschHost,jschPassWord);//建立服务器连接  
			logger.debug("Opening Channel.");
			channel = session.openChannel("sftp"); // 打开SFTP通道  
			channel.connect(); // 建立SFTP通道的连接  
			chSftp = (ChannelSftp) channel;
			File file = new File(uploadFile);
			long fileSize = file.length();
			chSftp.put(uploadFile, directory, new FileProgressMonitor(fileSize,webSocketSession), ChannelSftp.OVERWRITE); //方法二  
			WebSocketMessageSend.sendMessage(webSocketSession,"======》file upload success.");
			logger.debug("成功上传文件至" + directory);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			chSftp.quit();

			if (channel != null) {
				channel.disconnect();
				logger.debug("channel disconnect");
			}
			if (session != null) {
				session.disconnect();
				logger.debug("channel disconnect");
			}
		}
		return flag;
	}

	/** 
	 * 下载文件 
	 * 
	 * @param directory 下载的目录,有两种写法１、如/opt，拿到则是默认文件名２、/opt/文件名，则是另起一个名字 
	 * @param downloadFile 要下载的文件 如/opt/xxx.txt 
	 * 
	 */
	public static void download(WebSocketSession webSocketSession,String directory, String downloadFile,String jschUserName,String jschHost,String jschPassWord) {
		Channel channel = null;
		Session session = null;
		ChannelSftp chSftp = null;
		try {
			session = getConnect(jschUserName,jschHost,jschPassWord);//建立服务器连接  
			logger.debug("Opening Channel.");
			channel = session.openChannel("sftp"); // 打开SFTP通道  
			channel.connect(); // 建立SFTP通道的连接  
			chSftp = (ChannelSftp) channel;
			SftpATTRS attr = chSftp.stat(downloadFile);
			long fileSize = attr.getSize();
			chSftp.get(downloadFile, directory, new FileProgressMonitor(fileSize,webSocketSession)); // 代码段1  
			logger.debug("成功下载文件至" + directory);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			chSftp.quit();
			if (channel != null) {
				channel.disconnect();
				logger.debug("channel disconnect");
			}
			if (session != null) {
				session.disconnect();
				logger.debug("channel disconnect");
			}
		}
	}

	/** 
	 * 删除文件 
	 * @param deleteFile 要删除的文件 
	 */
	public static void delete(String deleteFile,String jschUserName,String jschHost,String jschPassWord) {
		Channel channel = null;
		Session session = null;
		ChannelSftp chSftp = null;
		try {
			session = getConnect(jschUserName,jschHost,jschPassWord);//建立服务器连接  
			logger.debug("Opening Channel.");
			channel = session.openChannel("sftp"); // 打开SFTP通道  
			channel.connect(); // 建立SFTP通道的连接  
			chSftp = (ChannelSftp) channel;
			chSftp.rm(deleteFile);
			logger.debug("成功删除文件" + deleteFile);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			chSftp.quit();
			if (channel != null) {
				channel.disconnect();
				logger.debug("channel disconnect");
			}
			if (session != null) {
				session.disconnect();
				logger.debug("channel disconnect");
			}
		}

	}
	
	public static void main(String[] args) {
		String result =SSHUtil.shellCmd("root", "10.16.238.93", "12345678", "ll \n");
		System.out.println(result);
	}

}