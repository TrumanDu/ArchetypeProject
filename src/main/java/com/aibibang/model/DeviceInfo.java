package com.aibibang.model;

import org.springframework.util.ObjectUtils;

/**
 * @author: Truman.P.Du
 * @since: 2016年11月25日 下午9:08:21
 * @version: v1.0
 * @description:
 */
public class DeviceInfo {
	private String name;
	private int id;
	private String param;

	private String DEV_CODE;
	private String DEV_NAME;
	private String ip_addr;
	private String mac_addr;
	private String port_number;
	private String uid;
	private String firmware_ver;
	private String manufacture_name;
	private String manufacture_date;
	private String authenication_state;
	private String connected_state;
	private String connected_work_state;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getDEV_CODE() {
		return DEV_CODE;
	}

	public void setDEV_CODE(String dEV_CODE) {
		DEV_CODE = dEV_CODE;
	}

	public String getDEV_NAME() {
		return DEV_NAME;
	}

	public void setDEV_NAME(String dEV_NAME) {
		DEV_NAME = dEV_NAME;
	}

	public String getIp_addr() {
		return ip_addr;
	}

	public void setIp_addr(String ip_addr) {
		this.ip_addr = ip_addr;
	}

	public String getMac_addr() {
		return mac_addr;
	}

	public void setMac_addr(String mac_addr) {
		this.mac_addr = mac_addr;
	}

	public String getPort_number() {
		return port_number;
	}

	public void setPort_number(String port_number) {
		this.port_number = port_number;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getFirmware_ver() {
		return firmware_ver;
	}

	public void setFirmware_ver(String firmware_ver) {
		this.firmware_ver = firmware_ver;
	}

	public String getManufacture_name() {
		return manufacture_name;
	}

	public void setManufacture_name(String manufacture_name) {
		this.manufacture_name = manufacture_name;
	}

	public String getManufacture_date() {
		return manufacture_date;
	}

	public void setManufacture_date(String manufacture_date) {
		this.manufacture_date = manufacture_date;
	}

	public String getAuthenication_state() {
		return authenication_state;
	}

	public void setAuthenication_state(String authenication_state) {
		this.authenication_state = authenication_state;
	}

	public String getConnected_state() {
		return connected_state;
	}

	public void setConnected_state(String connected_state) {
		this.connected_state = connected_state;
	}

	public String getConnected_work_state() {
		return connected_work_state;
	}

	public void setConnected_work_state(String connected_work_state) {
		this.connected_work_state = connected_work_state;
	}
}
