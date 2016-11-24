package com.aibibang.service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.aibibang.model.SoftInfo;
import com.aibibang.model.UploadFile;

/** 
* @author: Truman.P.Du 
* @since: 2016年6月29日 下午3:33:29 
* @version: v1.0
* @description:
*/
@Mapper
public interface SoftMapper {
   
	@Select("SELECT * FROM soft")
	public List<SoftInfo> getAllSoftInfo(@Param("user") String user);
	
	@Select("SELECT * FROM soft_file where pId = #{pId}")
	public List<UploadFile> getAllUploadFile(@Param("pId") int pId);
	
	@Select("SELECT * FROM soft_file where pId = #{pId} and version in(SELECT max(version) FROM soft_file where pId = #{pId})")
	public List<UploadFile> getNewVersionUploadFile(@Param("pId") int pId);
	
	@Insert("insert into soft(name, hostUserName,hostPassword,startScript,stopScript,hostIPs) values(#{name}, #{hostUserName}, #{hostPassword}, #{startScript}, #{stopScript},  #{hostIPs})")
	public boolean add(SoftInfo softInfo);
	
	@Insert("insert into soft_file(version,pId,fileName,path,filePath) values(#{version}, #{pId}, #{fileName}, #{path}, #{filePath})")
	public boolean addUploadFile(UploadFile uploadFile);
	
	@Select("select * from soft where id = #{id}")
	public SoftInfo getSoftInfoById(int id);
	
	@Delete("delete from soft where id = #{id}")
	public boolean deleteById(int id);
	
	@Delete("delete from soft_file where id = #{id}")
	public boolean deleteSoftFileById(int id);
	
	@Update("update soft set name = #{name},  hostUserName=#{hostUserName},hostPassword=#{hostPassword},startScript=#{startScript},stopScript=#{stopScript},hostIPs=#{hostIPs} where id = #{id}")
	public boolean update(SoftInfo softInfo);
}
