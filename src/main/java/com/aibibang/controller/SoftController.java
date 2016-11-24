package com.aibibang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.aibibang.model.SoftInfo;
import com.aibibang.model.UploadFile;
import com.aibibang.service.SoftMapper;
import com.aibibang.service.UploadService;
import com.alibaba.fastjson.JSON;

/** 
* @author: Truman.P.Du 
* @since: 2016年6月28日 下午1:48:23 
* @version: v1.0
* @description:
*/
@Controller
@RequestMapping("/soft")
public class SoftController {
	
	@Autowired
	private SoftMapper softMapper;
	@Autowired
	private UploadService uploadService;
	
	@RequestMapping(value = {"","/"})
	public String list(Model model){
		List<SoftInfo> softs = softMapper.getAllSoftInfo("");
		model.addAttribute("pageData", softs);
		return "soft";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST )
	public String add(SoftInfo softInfo,Model model){
		
		boolean result = softMapper.add(softInfo);
		if(result){
			model.addAttribute("message", "add successed!");
		}else{
			model.addAttribute("message", "add fail!");
		}
		return this.list(model);
	}
	
	
	@RequestMapping(value="/delete",method=RequestMethod.GET )
	public String delete(@RequestParam(value="id") int id,Model model){
		boolean result = softMapper.deleteById(id);
		if(result){
			model.addAttribute("message", "delete successed!");
		}else{
			model.addAttribute("message", "delete fail!");
		}
		
		return this.list(model);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET )
	public @ResponseBody String update(@RequestParam(value="id") int id){
		SoftInfo softInfo = softMapper.getSoftInfoById(id);
		return JSON.toJSONString(softInfo);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST )
	public String update(SoftInfo softInfo,Model model){
		boolean result = softMapper.update(softInfo);
		if(result){
			model.addAttribute("message", "update successed!");
		}else{
			model.addAttribute("message", "update fail!");
		}
		return this.list(model);
	}
	
	@RequestMapping(value="/getSoftFiles",method=RequestMethod.GET )
	public String getSoftFiles(@RequestParam(value="id") int id,Model model){
		List<UploadFile> softs = softMapper.getAllUploadFile(id);
		model.addAttribute("pageData", softs);
		model.addAttribute("softInfo", softMapper.getSoftInfoById(id));
		return "softFile";
	}
	
	@RequestMapping(value="/deleteSoftFile",method=RequestMethod.GET )
	public String deleteSoftFile(@RequestParam(value="id") int id,@RequestParam(value="pId") int pId,Model model){
		boolean result = softMapper.deleteSoftFileById(id);
		if(result){
			model.addAttribute("message", "delete successed!");
		}else{
			model.addAttribute("message", "delete fail!");
		}
		List<UploadFile> softs = softMapper.getAllUploadFile(pId);
		model.addAttribute("pageData", softs);
		model.addAttribute("softInfo", softMapper.getSoftInfoById(pId));
		return "softFile";
	}
	
	@RequestMapping(value="/addSoftFile",method=RequestMethod.POST )
	public String addSoftFile(UploadFile uploadFile,@RequestParam("file") MultipartFile file,Model model){
		if(file!=null){
			String directoryName = uploadFile.getpId()+"_"+uploadFile.getVersion();
			String filePath = uploadService.uploadFile(file,directoryName);
			uploadFile.setFilePath(filePath);
		}
		boolean result = softMapper.addUploadFile(uploadFile);
		if(result){
			model.addAttribute("message", "add successed!");
		}else{
			model.addAttribute("message", "add fail!");
		}
		List<UploadFile> softs = softMapper.getAllUploadFile(uploadFile.getpId());
		model.addAttribute("pageData", softs);
		model.addAttribute("softInfo", softMapper.getSoftInfoById(uploadFile.getpId()));
		return "softFile";
	}
}
