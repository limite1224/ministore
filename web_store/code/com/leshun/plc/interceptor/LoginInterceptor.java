package com.leshun.plc.interceptor;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.leshun.plc.bean.sys.UserInfoVO;
import com.leshun.plc.constant.Constant;
import com.leshun.plc.freemarker.CustomFreemarkerManager;
import com.leshun.plc.util.UserInfoVOThreadLocal;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.PreResultListener;
import com.sls.core.common.KeyUtil;
import com.sls.core.socket.ServerDisponseException;

public class LoginInterceptor implements Interceptor {
	private static final long serialVersionUID = 8109886567899928146L;
	private static final Logger log = Logger.getLogger(LoginInterceptor.class);

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
		String actionName = invocation.getProxy().getActionName();
		String namespace = invocation.getProxy().getNamespace();
		String methodName = invocation.getProxy().getMethod();
		// 判断是否需要拦截
		// LoginAction -> index login不拦截
		if (!(actionName.equals("login") && methodName.equals("index")
				|| methodName.equals("login"))
				// api 下的所有都不拦截
				&& !namespace.startsWith("/api")) {
			// 验证登录
			Cookie[] cookies = ServletActionContext.getRequest().getCookies();
			UserInfoVO op = null;
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (CustomFreemarkerManager
							.getCookieName(Constant.COOKIE_NAME_USERINFO)
							.equals(cookie.getName())) {
						Object cookieInfo = cookie.getValue();
						String key = null;
						if (cookieInfo instanceof String) {
							key = KeyUtil.cookieDencrypt(cookieInfo.toString());
						}
						HttpSession session = ServletActionContext.getRequest()
								.getSession();
						Object obj = session.getAttribute(key);
						if (obj instanceof UserInfoVO) {
							op = (UserInfoVO) obj;
						}
					}
				}
			}
			op.setCurrentIp(getIpAddr(ServletActionContext.getRequest()));

			// 没有登录先登录
			if (op == null) {
				log.info("请先登录");
				invocation.getInvocationContext().put("login_error", "请先登录");
				return "kickedOut";
			}
			if (!"admin".equals(op.getAccount()) && "/business"
					.equals(invocation.getProxy().getNamespace())) {
				throw new ServerDisponseException("9999", "此用户未获得此页面权限");
			}
			if (op != null) {
				log.info("请先登录");
				invocation.getInvocationContext().put("login_error", "请先登录");
				return "kickedOut";
			}
			UserInfoVOThreadLocal.set(op);
			// 验证是否有权限
			// try {
			// String cUrl = ServletActionContext.getRequest()
			// .getServletPath();
			// if (StringUtils.trim(cUrl) == null
			// || StringUtils.trim(cUrl).length() == 0)
			// cUrl = ServletActionContext.getRequest().getRequestURI()
			// .replace(ServletActionContext.getRequest()
			// .getContextPath(), "");
			// String url = CustomFreemarkerMethod.dispose(cUrl);
			// boolean flag = this.checkPermission(url, op);
			// if (!flag) {
			// log.info("没有权限");
			// return "nopermission";
			// }
			// } catch (Exception e) {
			// throw e;
			// }
			final UserInfoVO currentOperator = op;
			invocation.addPreResultListener(new PreResultListener() {
				@Override
				public void beforeResult(ActionInvocation invocation,
						String resultCode) {

					if (UserInfoVOThreadLocal.get() == null) {
						ActionContext.getContext().put("account",
								currentOperator.getAccount());
					} else {
						ActionContext.getContext().put("account",
								UserInfoVOThreadLocal.get().getAccount());
					}
				}
			});
		} else if (invocation.getProxy().getActionName().equals("login")
				&& invocation.getProxy().getMethod().equals("login")) {
			// 如果是登录，则登录cookie写入
			invocation.addPreResultListener(new PreResultListener() {
				@Override
				public void beforeResult(ActionInvocation invocation,
						String resultCode) {
					String userInfo = null;
					Object tmp = invocation.getInvocationContext()
							.get(Constant.COOKIE_NAME_USERINFO);
					if (tmp instanceof String)
						userInfo = (String) tmp;
					String web_cookie_path = CustomFreemarkerManager
							.getCookiePath();
					Cookie cookie = new Cookie(
							CustomFreemarkerManager.getCookieName(
									Constant.COOKIE_NAME_USERINFO),
							KeyUtil.cookieEncrypt(userInfo));
					// 半小时
					cookie.setMaxAge(30 * 60 * 1000);
					cookie.setPath(web_cookie_path);
					ServletActionContext.getResponse().addCookie(cookie);
					Cookie cs = new Cookie(
							CustomFreemarkerManager
									.getCookieName(Constant.SESSION_ID),
							UUID.randomUUID().toString());
					// 半小时
					cs.setMaxAge(30 * 60 * 1000);
					cs.setPath(web_cookie_path);
					ServletActionContext.getResponse().addCookie(cs);
					log.debug("登录信息写入cookie");
				}
			});
		}

		String result = null;
		try {
			result = invocation.invoke();
		} catch (Exception e) {
			log.error(invocation.getAction() + "执行出错", e);
			throw e;
		} finally {
			UserInfoVOThreadLocal.clean();
		}
		return result;
	}

	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	// private boolean checkPermission(String url, UserInfoVO vo)
	// throws Exception {
	// if (StringUtils.isBlank(url)) {
	// return false;
	// }
	//
	// if (vo.getRoot() && "root".equals(vo.getServiceCode())) {
	// // 超级用户
	// return true;
	// }
	//
	// String code = permissionInfoComp.selectCodeByUrl(url);
	// String codes = vo.getServiceCode();
	// if (StringUtils.isBlank(code) || StringUtils.isBlank(codes)) {
	// return false;
	// }
	// // 拥有权限
	// if (codes.indexOf("," + code + ",") != -1)
	// return true;
	//
	// return false;
	// }
}
