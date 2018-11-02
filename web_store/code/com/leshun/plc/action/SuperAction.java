package com.leshun.plc.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.leshun.plc.util.CommonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class SuperAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8878655577619989047L;
	protected Logger log = Logger.getLogger(getClass());
	public static final String LIST = "list";
	protected String redirectionUrl;
	protected boolean flag = true;
	protected String message;

	protected HttpServletResponse response;

	protected HttpServletRequest request;

	public SuperAction() {
		super();
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
	}

	/**
	 * 
	 * @param code
	 *            0失败1成功
	 * @param msg
	 * @return
	 */
	protected String ajaxResp(int code, Object msg) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", code + "");
		map.put("msg", msg);
		return CommonUtil.gson().toJson(map);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRedirectionUrl() {
		return redirectionUrl;
	}

	public void setRedirectionUrl(String redirectionUrl) {
		this.redirectionUrl = redirectionUrl;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}
