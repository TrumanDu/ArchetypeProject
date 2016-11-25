package com.aibibang.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aibibang.common.Constant;
import com.aibibang.model.FileInfo;

/** 
* @author: Truman.P.Du 
* @since: 2016年11月25日 下午8:05:41 
* @version: v1.0
* @description:
*/
@Controller
@RequestMapping("/filelist")
public class FilelistController {
	@RequestMapping(value = {"","/"})
	public String list(Model model){
		File directory = new File(Constant.FILEPATH);
		File[] files=directory.listFiles();
		List<FileInfo> fileInfos = new ArrayList<FileInfo>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
		if(files.length>0){
			for(File file:files){
				FileInfo fileInfo =new FileInfo();
				fileInfo.setName(file.getName());
				Calendar cal = Calendar.getInstance();    
	            long time = file.lastModified(); 
	            cal.setTimeInMillis(time); 
				fileInfo.setCreateDate(formatter.format(cal.getTime()));
				fileInfo.setFileSize(String.valueOf(file.length()));
				fileInfos.add(fileInfo);
			}
			
		}
		
		model.addAttribute("pageData", fileInfos);
		return "filelist";
	}
}
