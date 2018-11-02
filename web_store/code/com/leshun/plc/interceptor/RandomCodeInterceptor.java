package com.leshun.plc.interceptor;

import java.io.OutputStream;
import java.util.Random;

import javax.servlet.http.Cookie;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.leshun.plc.constant.Constant;
import com.leshun.plc.freemarker.CustomFreemarkerManager;
import com.leshun.plc.util.ImageUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.sls.core.common.KeyUtil;

public class RandomCodeInterceptor implements Interceptor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8109886567899928146L;
	private static final Logger logger = Logger
			.getLogger(RandomCodeInterceptor.class);

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
		String mss = "QWERTYUIOPASDFGHJKLZXCVBNM";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= 4; i++) {
			sb.append(mss.charAt(random.nextInt(mss.length())));
		}
		String web_cookie_path = CustomFreemarkerManager.getCookiePath();
		Cookie cookie = new Cookie(
				CustomFreemarkerManager
						.getCookieName(Constant.COOKIE_NAME_RANDOMCODE),
				KeyUtil.cookieCommonEncrypt(sb.toString()));
		cookie.setPath(web_cookie_path);
		ServletActionContext.getResponse().addCookie(cookie);
		OutputStream os = ServletActionContext.getResponse().getOutputStream();
		ImageUtil.createImage(sb.toString(), os);
		logger.info("验证码" + sb.toString());
		return invocation.invoke();
	}
}
