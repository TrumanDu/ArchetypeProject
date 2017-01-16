package com.aibibang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aibibang.common.Constant;
import com.aibibang.model.DeviceInfo;
import com.aibibang.service.DeviceInfoMapper;
import com.aibibang.util.SocketAPIUtil;
import com.alibaba.fastjson.JSON;

/** 
* @author: Truman.P.Du 
* @since: 2016年6月28日 下午1:48:23 
* @version: v1.0
* @description:
*/
@Controller
@RequestMapping("/device")
public class DeviceController {
	
	@Autowired
	private DeviceInfoMapper deviceInfoMapper;

	@RequestMapping(value = {"","/"})
	public String list(Model model){
		/*List<DeviceInfo> deviceInfos = deviceInfoMapper.getAllInfo();
		model.addAttribute("pageData", deviceInfos);*/
		return "device";
	}
	

	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public  @ResponseBody String listJson(){
		//List<DeviceInfo> deviceInfos = deviceInfoMapper.getAllInfo();
		
		List<DeviceInfo> deviceInfos = Constant.getDeviceInfos();
		return "{\"data\":"+JSON.toJSONString(deviceInfos)+"}";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET )
	public @ResponseBody String update(@RequestParam(value="id") int id){
		DeviceInfo deviceInfo = deviceInfoMapper.getDeviceInfoById(id);
		return JSON.toJSONString(deviceInfo);
	}
	
	/*@RequestMapping(value="/update",method=RequestMethod.POST )
	public String update(DeviceInfo deviceInfo,Model model){
		boolean result = deviceInfoMapper.update(deviceInfo);
		if(result){
			model.addAttribute("message", "设置成功!");
		}else{
			model.addAttribute("message", "设置失败!");
		}
		return this.list(model);
	}*/
	@RequestMapping(value="/update",method=RequestMethod.POST )
	public @ResponseBody String update(@RequestParam(value="param") String param,Model model){
		String message = Constant.DEV_SET_ITHOR_DEV_PARAM+","+param;
		String result = SocketAPIUtil.set(message);
		if(result!=null&&result.equals(Constant.DEV_SET_ITHOR_SUCCESS)){
			return String.valueOf(true);
		}else{
			return String.valueOf(false);
		}
		
	}
	@RequestMapping(value="/authenication",method=RequestMethod.POST )
	public @ResponseBody String authenication(@RequestParam(value="mac") String mac,Model model){
		String message = Constant.DEV_SET_ITHOR_AUTHENICATION+","+mac;
		String result = SocketAPIUtil.set(message);
		if(result!=null&&result.equals(Constant.DEV_SET_ITHOR_SUCCESS)){
			return String.valueOf(true);
		}else{
			return String.valueOf(false);
		}
		
	}
	@RequestMapping(value="/reboot",method=RequestMethod.POST )
	public @ResponseBody String reboot(@RequestParam(value="mac") String mac,Model model){
		String message = Constant.DEV_SET_ITHOR_DEV_REBOOT+","+mac;
		String result = SocketAPIUtil.set(message);
		if(result!=null&&result.equals(Constant.DEV_SET_ITHOR_SUCCESS)){
			return String.valueOf(true);
		}else{
			return String.valueOf(false);
		}
	}
	@RequestMapping(value="/reset",method=RequestMethod.POST )
	public @ResponseBody String reset(@RequestParam(value="mac") String mac,Model model){
		String message = Constant.DEV_SET_ITHOR_DEV_RESET+","+mac;
		String result = SocketAPIUtil.set(message);
		if(result!=null&&result.equals(Constant.DEV_SET_ITHOR_SUCCESS)){
			return String.valueOf(true);
		}else{
			return String.valueOf(false);
		}
	}
	@RequestMapping(value="/updateFirmware",method=RequestMethod.POST )
	public @ResponseBody String updateFirmware(@RequestParam(value="mac") String mac,Model model){
		String message = Constant.DEV_SET_ITHOR_UPDATE_FIRMWARE+","+mac;
		String result = SocketAPIUtil.set(message);
		
		if(result!=null&&result.equals(Constant.DEV_SET_ITHOR_SUCCESS)){
			return String.valueOf(true);
		}else{
			return String.valueOf(false);
		}
	}
	
}
