package com.aibibang;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.core.env.Environment;

import com.aibibang.common.Constant;
import com.aibibang.model.DeviceInfo;
import com.aibibang.model.UserInfo;
import com.aibibang.service.UserMapper;
import com.aibibang.util.ParseDataUtil;
import com.aibibang.util.SocketAPIUtil;

/**
 * @author: Truman.P.Du
 * @since: 2016年6月25日 下午5:06:35
 * @version: v1.0
 * @description: 程序启动入口
 */
@SpringBootApplication
public class RunServer extends SpringBootServletInitializer {
	private static Logger log = LoggerFactory.getLogger(RunServer.class);
	
	@Autowired
	private  UserMapper userMapper;
	@PostConstruct
	public  void init() {
		Constant.users = new HashMap<String,UserInfo>();
		List<UserInfo> softs = userMapper.getAllUserInfo();
		for(UserInfo user:softs){
			Constant.users.put(user.getUserName(), user);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(RunServer.class, args);
		log.info("server Started");
		System.out.println("server Started");
		
		Timer timer = new Timer();
		new DataReadTask().run();
		timer.schedule(new DataReadTask(), new Date(), 2000);
	}

	static class DataReadTask extends TimerTask {
		@Override
		public void run() {

			try {
				String result = SocketAPIUtil.query(Constant.DEV_INFO_ITHOR + "\n");
				List<DeviceInfo> resultList = ParseDataUtil.ParseDevice(result);
				// System.out.println(resultList.size());
				Constant.setDeviceInfos(resultList);
			} catch (Exception e) {
				// e.printStackTrace();
				log.error(e.getMessage());
			}
		}

	}
}
