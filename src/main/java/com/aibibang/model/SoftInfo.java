package com.aibibang.model;

import java.io.Serializable;


/** 
* @author: Truman.P.Du 
* @since: 2016年6月29日 上午9:13:09 
* @version: v1.0
* @description:
*/
public class SoftInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String hostUserName;
	private String hostPassword;

	private String startScript;
	private String stopScript;

	private String hostIPs;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHostUserName() {
		return hostUserName;
	}

	public void setHostUserName(String hostUserName) {
		this.hostUserName = hostUserName;
	}

	public String getHostPassword() {
		return hostPassword;
	}

	public void setHostPassword(String hostPassword) {
		this.hostPassword = hostPassword;
	}

	

	public String getStartScript() {
		return startScript;
	}

	public void setStartScript(String startScript) {
		this.startScript = startScript;
	}

	public String getStopScript() {
		return stopScript;
	}

	public void setStopScript(String stopScript) {
		this.stopScript = stopScript;
	}



	public String getHostIPs() {
		return hostIPs;
	}

	public void setHostIPs(String hostIPs) {
		this.hostIPs = hostIPs;
	}
    
	@Override
	public String toString() {
		return "SoftInfo [id=" + id + ", name=" + name + ", hostUserName=" + hostUserName + ", hostPassword="
				+ hostPassword + ",  startScript=" + startScript + ", stopScript=" + stopScript
				+ ",  hostIPs=" + hostIPs + "]";
	}

}
