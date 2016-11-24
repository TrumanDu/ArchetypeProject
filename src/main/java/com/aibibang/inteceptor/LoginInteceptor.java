package com.aibibang.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.aibibang.model.UserInfo;
import com.aibibang.service.UserMapper;

/** 
* @author: Truman.P.Du 
* @since: 2016年7月7日 下午7:07:01 
* @version: v1.0
* @description:
*/
public class LoginInteceptor implements HandlerInterceptor {
	@Autowired
	private UserMapper userMapper;
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
		if(userInfo == null){
			 response.sendRedirect(request.getContextPath());  
			return false;
		}
		
		return true;
	}

}
