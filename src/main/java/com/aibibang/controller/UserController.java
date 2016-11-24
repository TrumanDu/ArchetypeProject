package com.aibibang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aibibang.model.UserInfo;
import com.aibibang.service.UserMapper;
import com.alibaba.fastjson.JSON;

/** 
* @author: Truman.P.Du 
* @since: 2016年6月28日 下午1:48:23 
* @version: v1.0
* @description:
*/
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value = {"","/"})
	public String list(Model model){
		List<UserInfo> softs = userMapper.getAllUserInfo();
		model.addAttribute("pageData", softs);
		return "user";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST )
	public String add(UserInfo userInfo,Model model){
		
		boolean result = userMapper.add(userInfo);
		if(result){
			model.addAttribute("message", "add successed!");
		}else{
			model.addAttribute("message", "add fail!");
		}
		return this.list(model);
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET )
	public String delete(@RequestParam(value="id") int id,Model model){
		boolean result = userMapper.deleteById(id);
		if(result){
			model.addAttribute("message", "delete successed!");
		}else{
			model.addAttribute("message", "delete fail!");
		}
		
		return this.list(model);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET )
	public @ResponseBody String update(@RequestParam(value="id") int id){
		UserInfo userInfo = userMapper.getUserInfoById(id);
		return JSON.toJSONString(userInfo);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST )
	public String update(UserInfo userInfo,Model model){
		boolean result = userMapper.update(userInfo);
		if(result){
			model.addAttribute("message", "update successed!");
		}else{
			model.addAttribute("message", "update fail!");
		}
		return this.list(model);
	}
}
