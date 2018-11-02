package com.leshun.plc.action.sys;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;

import com.leshun.plc.action.SuperAction;

@InterceptorRefs(value = { @InterceptorRef("chainStack"),
		@InterceptorRef("logoutInterceptor") })
public class LogoutAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3939116397462608647L;

	// 退出登录
	@Override
	public String execute() throws Exception {
		return "logout";
	}
}
