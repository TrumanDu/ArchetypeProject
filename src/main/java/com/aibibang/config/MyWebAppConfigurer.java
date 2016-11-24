package com.aibibang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.aibibang.inteceptor.LoginInteceptor;

/** 
* @author: Truman.P.Du 
* @since: 2016年7月7日 下午7:08:46 
* @version: v1.0
* @description:
*/
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
 
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		// 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new LoginInteceptor()).addPathPatterns("/**").excludePathPatterns("/").excludePathPatterns("/login");
		super.addInterceptors(registry);
	}
}
