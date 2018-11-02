package com.leshun.plc.bean;

import java.util.Date;

public class UserInfo extends DataEntity<UserInfo> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4850942649933208034L;

	private String wxId;

	private String openId;

	private String nikename;

	private Date syncTime;

	private String mobile;

	public String getWxId() {
		return wxId;
	}

	public void setWxId(String wxId) {
		this.wxId = wxId == null ? null : wxId.trim();
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId == null ? null : openId.trim();
	}

	public String getNikename() {
		return nikename;
	}

	public void setNikename(String nikename) {
		this.nikename = nikename == null ? null : nikename.trim();
	}

	public Date getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}
}