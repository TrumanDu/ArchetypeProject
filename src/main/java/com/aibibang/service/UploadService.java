package com.aibibang.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/** 
* @author: Truman.P.Du 
* @since: 2016年6月30日 下午1:21:10 
* @version: v1.0
* @description:
*/
@Service
public class UploadService {
	private final Logger logger = Logger.getLogger(UploadService.class);

	public String uploadFile(MultipartFile file,String directoryName) {
		String uploadPath = "DeployResource"+System.getProperty("file.separator")+"upload"+System.getProperty("file.separator")+directoryName;
		File directory=new File(uploadPath);   
		if(!directory.exists() && !directory.isDirectory()){
			directory.mkdir();
		}
		try {
			uploadFile(uploadPath, file, file.getOriginalFilename());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return uploadPath + System.getProperty("file.separator") + file.getOriginalFilename();
	}

	private boolean uploadFile(String destinationDir, MultipartFile file, String filename)
			throws Exception {
		logger.debug("文件长度: " + file.getSize());
		logger.debug("文件类型: " + file.getContentType());
		logger.debug("文件名称: " + file.getName());
		logger.debug("文件原名: " + file.getOriginalFilename());
		logger.debug("========================================");
		try {
			SaveFileFromInputStream(file.getInputStream(), destinationDir, filename);
		} catch (IOException e) {
			logger.info(e.getMessage());
			return false;
		}
		return true;
	}

	/**保存文件  
	      * @param stream  
	      * @param path  
	      * @param filename  
	      * @throws IOException  
	*/
	private void SaveFileFromInputStream(InputStream stream, String path, String filename)
			throws IOException {
		FileOutputStream outputStream = new FileOutputStream(path + System.getProperty("file.separator") + filename);
		int byteCount = 0;
		byte[] bytes = new byte[1024];
		while ((byteCount = stream.read(bytes)) != -1) {
			outputStream.write(bytes, 0, byteCount);
		}
		outputStream.close();
		stream.close();
	}
}
