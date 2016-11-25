package com.aibibang.service;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.aibibang.model.DeviceInfo;

/** 
* @author: Truman.P.Du 
* @since: 2016年6月29日 下午3:33:29 
* @version: v1.0
* @description:
*/
@Mapper
public interface DeviceInfoMapper {
   
	@Select("SELECT * FROM device_info")
	public List<DeviceInfo> getAllInfo();
	

	@Insert("insert into device_info(name, param) values(#{name}, #{param})")
	public boolean add(DeviceInfo deviceInfo);
	

	@Select("select * from device_info where id = #{id}")
	public DeviceInfo getDeviceInfoById(int id);
	
	
	
	@Update("update device_info set name = #{name},param=#{param} where id = #{id}")
	public boolean update(DeviceInfo deviceInfo);
}
