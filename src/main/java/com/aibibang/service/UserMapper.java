package com.aibibang.service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.aibibang.model.UserInfo;

/** 
* @author: Truman.P.Du 
* @since: 2016年6月29日 下午3:33:29 
* @version: v1.0
* @description:
*/
@Mapper
public interface UserMapper {
   
	@Select("SELECT * FROM user")
	public List<UserInfo> getAllUserInfo();
	
	@Select("SELECT * FROM user where userName = #{userName} and passwd = #{passwd}")
	public List<UserInfo> getUserInfoByLogin(UserInfo userInfo);
	
	@Insert("insert into user(userName,passwd) values(#{userName}, #{passwd})")
	public boolean add(UserInfo softInfo);
	
	@Select("select * from user where id = #{id}")
	public UserInfo getUserInfoById(int id);
	
	@Delete("delete from user where id = #{id}")
	public boolean deleteById(int id);
	
	@Update("update user set userName = #{userName},  passwd=#{passwd} where id = #{id}")
	public boolean update(UserInfo userInfo);
}
