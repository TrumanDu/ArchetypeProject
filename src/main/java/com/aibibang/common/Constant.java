package com.aibibang.common;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.aibibang.model.DeviceInfo;
import com.aibibang.model.UserInfo;

/** 
* @author: Truman.P.Du 
* @since: 2016年4月5日 下午2:14:46 
* @version: v1.0
* @description:常量
*/
public class Constant {
	//public static String FILEPATH="D:\\hadoop";
	public static String FILEPATH=File.separator+"mnt"+File.separator+"nfs"+File.separator+"temp";
	//public static String ADDRESS="192.168.1.244";
	
	public static String ADDRESS="127.0.0.1";

	public static int PORT=6000;
	
	public static final String DEV_INFO_ITHOR = "dev_info@iTHOR";
	public static final String DEV_SET_ITHOR_AUTHENICATION = "dev_set@iTHOR,dev_authenication";
	public static final String DEV_SET_ITHOR_DEV_REBOOT = "dev_set@iTHOR,dev_reboot";
	public static final String DEV_SET_ITHOR_DEV_RESET = "dev_set@iTHOR,dev_reset";
	public static final String DEV_SET_ITHOR_UPDATE_FIRMWARE = "dev_set@iTHOR,update_firmware";
	public static final String DEV_SET_ITHOR_DEV_PARAM = "dev_set@iTHOR,dev_param";
	
	public static final String DEV_SET_ITHOR_SUCCESS = "dev_set@iTHOR,1";
	public static final String DEV_SET_ITHOR_FAILL = "dev_set@iTHOR,0";
	
	public static final String DEV_INFO = "dev_info@";
	
	public static List<DeviceInfo>deviceInfos;
	
	public static  final  String  FIX_READER =   "fix_reader";
	public static  final  String  MOBILE_DEV =   "mobile_dev";
	public static  final  String  BEIDOU_DEV =   "beidou_dev";
	public static  final  String  VIDEO_DEV  =    "video_dev";
	
	public static Map<String,UserInfo>users;
	
	
	public static Map<String, UserInfo> getUsers() {
		return users;
	}



	public static void setUsers(Map<String, UserInfo> users) {
		Constant.users = users;
	}



	public static List<DeviceInfo> getDeviceInfos() {
		return deviceInfos;
	}



	public synchronized static void setDeviceInfos(List<DeviceInfo> deviceInfos) {
		Constant.deviceInfos = deviceInfos;
	}
	
}
