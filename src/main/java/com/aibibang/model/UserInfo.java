package com.aibibang.model;

import java.io.Serializable;

/** 
* @author: Truman.P.Du 
* @since: 2016年7月7日 上午11:13:06 
* @version: v1.0
* @description:
*/
public class UserInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String userName;
	private String passwd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
