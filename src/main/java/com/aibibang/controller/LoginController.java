package com.aibibang.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aibibang.common.Constant;
import com.aibibang.model.UserInfo;
import com.aibibang.service.UserMapper;

/** 
* @author: Truman.P.Du 
* @since: 2016年6月25日 下午5:06:09 
* @version: v1.0
* @description:
*/
@Controller
@RequestMapping("/")
public class LoginController {
	
	@Value("${application.message:Hello World}")
	private String message = "Hello World";
	
	@Autowired
	private UserMapper userMapper;
	@RequestMapping(value = {"","/"})
	public String index(@RequestParam(value="account", required=true, defaultValue="admin") String name, Model model){
		model.addAttribute("name", message);
    	return "login";
	}
	
	@RequestMapping("/login")
	public String login(UserInfo userInfo, Model model,HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		boolean flag =false;
		if(userInfo == null || "".equals(userInfo.getPasswd()) || userInfo.getPasswd() == null){
			userInfo = (UserInfo) session.getAttribute("userInfo");
			flag=true;
		}
		if(userInfo==null){
			model.addAttribute("message", "please login again!");
			return "login";
		}
		if("123456".equals(userInfo.getPasswd())&&"iTHOR".equals(userInfo.getUserName())){
		if(!flag){
			session.setAttribute("userInfo", userInfo);
		}
		return "index";
	}   
		UserInfo sessionUser = (UserInfo) session.getAttribute("userInfo");
		if(sessionUser!=null&&sessionUser.getUserName()!=null){
			return "index";
	    }else{
	    	/*List<UserInfo> results = userMapper.getUserInfoByLogin(userInfo);
			if(results!=null&&results.size()>0){
				if(!flag){
					session.setAttribute("userInfo", userInfo);
				}
				return "index";
			}*/
	    	UserInfo user =Constant.users.get(userInfo.getUserName());
	    	
	    	if(user!=null){
	    		if(user.getPasswd().equals(userInfo.getPasswd())){
					session.setAttribute("userInfo", userInfo);
					return "index";
				}
	    	}
	    }

		model.addAttribute("message", "Accout or Passwd is not correct!");
    	return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession();
		session.invalidate();
		return "login";
	}
}
