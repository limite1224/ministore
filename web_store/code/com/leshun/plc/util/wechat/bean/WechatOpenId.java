package com.leshun.plc.util.wechat.bean;

import java.io.Serializable;

public class WechatOpenId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8046397370927705624L;
	/**
	 * { "access_token":"ACCESS_TOKEN",
	 * 
	 * "expires_in":7200,
	 * 
	 * "refresh_token":"REFRESH_TOKEN",
	 * 
	 * "openid":"OPENID",
	 * 
	 * "scope":"SCOPE" }
	 */
	private String access_token;
	private String expires_in;
	private String refresh_token;
	private String openid;
	private String scope;
	private String errcode;
	private String errmsg;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

}
