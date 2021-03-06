package com.leshun.plc.interceptor;

import javax.servlet.http.Cookie;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.leshun.plc.freemarker.CustomFreemarkerManager;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LogoutInterceptor implements Interceptor {
	private static final long serialVersionUID = 8109886567899928146L;
	private static final Logger log = Logger.getLogger(LogoutInterceptor.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		try {
			String web_cookie_path = CustomFreemarkerManager.getCookiePath();
			if (cookies != null)
				for (Cookie cookie : cookies) {
					cookie = new Cookie(cookie.getName(), null);
					cookie.setPath(web_cookie_path);
					cookie.setMaxAge(0);
					ServletActionContext.getResponse().addCookie(cookie);
				}
		} catch (Exception ex) {
			log.error("清空Cookies发生异常！");
		}
		return invocation.invoke();
	}

}
