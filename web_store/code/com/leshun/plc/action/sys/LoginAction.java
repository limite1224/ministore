package com.leshun.plc.action.sys;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;

import com.leshun.plc.action.SuperAction;
import com.leshun.plc.bean.sys.UserInfoVO;
import com.leshun.plc.constant.Constant;
import com.leshun.plc.util.ParseUtil;
import com.leshun.plc.util.UserInfoVOThreadLocal;
import com.opensymphony.xwork2.ActionContext;

@InterceptorRefs(value = { @InterceptorRef("chainStack"),
		@InterceptorRef("loginInterceptor") })
public class LoginAction extends SuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2617796169933222153L;
	private UserInfoVO operator;
	public static Map<String, String> userMap = new HashMap<String, String>();

	static {
		List<UserInfoVO> list = ParseUtil.readConfigurateFile();
		for (UserInfoVO vo : list) {
			userMap.put(vo.getAccount(), vo.getPwd());
		}
	}

	/*
	 * 用户登陆
	 */
	public String login() {
		try {
			String account = operator.getAccount();
			String pwd = operator.getPwd();
			if (userMap.containsKey(account)) {
				String value = userMap.get(account);
				if (StringUtils.isNotBlank(value)
						&& StringUtils.isNotBlank(pwd)) {
					if (value.equals(pwd)) {
						String uuid = UUID.randomUUID().toString();
						operator.setId(uuid);
						// 存session
						this.getRequest().getSession()
								.setAttribute(account + uuid, operator);
						ActionContext.getContext().put(
								Constant.COOKIE_NAME_USERINFO, account + uuid);
						return "redirectMain";
					}
				}
			}
			ActionContext.getContext().put("login_error", "密码错误");
		} catch (Exception e) {
			try {
				if (StringUtils.isNotBlank(redirectionUrl))
					this.redirectionUrl = URLEncoder.encode(redirectionUrl,
							"utf-8");
			} catch (Exception es) {
			}
			ActionContext.getContext().put("login_error", e.getMessage());
			log.error("登录失败！");
		}
		return "kickedOut";
	}

	// 后台首页
	public String index() {
		if (StringUtils.isNotBlank(getRequest().getParameter("login_error")))
			ActionContext.getContext().put("login_error",
					getRequest().getParameter("login_error"));
		return "index";
	}

	public String main() {
		ActionContext.getContext().put("operator", UserInfoVOThreadLocal.get());
		return "main";
	}

	public UserInfoVO getOperator() {
		return operator;
	}

	public void setOperator(UserInfoVO operator) {
		this.operator = operator;
	}
}