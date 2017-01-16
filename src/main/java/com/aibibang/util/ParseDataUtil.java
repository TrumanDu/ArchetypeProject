package com.aibibang.util;

import java.util.ArrayList;
import java.util.List;

import com.aibibang.common.Constant;
import com.aibibang.model.DeviceInfo;

public class ParseDataUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
	}
	public static List<DeviceInfo> ParseDevice(String message){
		//System.out.println(message);
		List<DeviceInfo> deviceInfos = new ArrayList<DeviceInfo>();
		if(message==null){
			return deviceInfos;
		}
		if(message.indexOf(Constant.DEV_INFO)<0){
			return deviceInfos;
		}
		if(message.indexOf("empty")>0){
			return deviceInfos;
		}
		message.replaceFirst(Constant.DEV_INFO, "");
		
		String[] devArray = message.split(";");
		int i  = 1;
		for(String devstr:devArray){
			
			DeviceInfo dev =new DeviceInfo();
			dev.setParam(devstr);
			
			String[] values  =  devstr.split(",");
			String key  = values[1];
			dev.setDEV_CODE(key);
			//改名字
			if(Constant.FIX_READER.equalsIgnoreCase(key)) {
				dev.setDEV_NAME("读写器" + i);
				i++;
			} 
			if(Constant.MOBILE_DEV.equalsIgnoreCase(key)) {
				dev.setDEV_NAME("手持设备");
			} 
			if(Constant.BEIDOU_DEV.equalsIgnoreCase(key)) {
				dev.setDEV_NAME("北斗设备");
			} 
			if(Constant.VIDEO_DEV.equalsIgnoreCase(key)) {
				dev.setDEV_NAME("视频设备");
			} 
			/**
			 * 开始设置其他属性
			 */
			
			dev.setIp_addr(values[2]);
			dev.setMac_addr(values[3]);
			dev.setPort_number(values[4]);
			dev.setUid(values[5]);
			dev.setFirmware_ver(values[6]);
			dev.setManufacture_name(values[7]);
			dev.setManufacture_date(values[8]);
			dev.setAuthenication_state(values[9]);
			dev.setConnected_state(values[10]);
			dev.setConnected_work_state(values[11]);
			deviceInfos.add(dev);
		}
		return deviceInfos;
	}

}
