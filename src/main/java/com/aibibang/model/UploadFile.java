package com.aibibang.model;

import java.io.Serializable;


/** 
* @author: Truman.P.Du 
* @since: 2016年6月29日 上午9:13:09 
* @version: v1.0
* @description:
*/
public class UploadFile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int version;
	private String path;
	private String filePath;
	private String fileName;
	private int pId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}
}
