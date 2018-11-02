package com.leshun.plc.action.api;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.leshun.plc.action.SuperAction;
import com.leshun.plc.util.CommonUtil;
import com.leshun.plc.util.PropertiesUtil;
import com.leshun.plc.util.wechat.bean.WechatOpenId;
import com.leshun.plc.util.wechat.utils.HttpUtils;
import com.leshun.plc.util.wechat.utils.MD5Utils;
import com.sls.core.socket.ServerDisponseException;

public class TokenAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8196636821021318968L;
	private static final String CONFIG_FILE = "wx.properties";
	private String code;

	public String loginCheck() {
		// 1、判断code是否存在
		if (StringUtils.isBlank(code)) {
			// 授权失败
			message = ajaxResp(0, "Authorization_Failure");
			return "ajax";
		}
		// 2、根据code获取openid
		WechatOpenId info = null;
		try {
			info = this.getOpenId(code);
		} catch (Exception e) {
			log.info("获取openid接口发生异常：", e);
			message = ajaxResp(0, "Authorization_Failure");
			return "ajax";
		}
		if (info == null) {
			log.info("获取openid失败");
			message = ajaxResp(0, "Authorization_Failure");
			return "ajax";
		}
		// 3、自定义登录状态
		String token = MD5Utils.MD5Encode(info.getAccess_token(), "utf-8");
		HttpSession session = getRequest().getSession();
		session.setAttribute("token", token);
		session.setAttribute(token, info.getOpenid());
		session.setMaxInactiveInterval(60 * 60);// 1小时超时
		// 头部设置token
		getResponse().setHeader("token", token);
		message = ajaxResp(1, "Authorization_Success");
		return "ajax";
	}

	/**
	 * 获取openId
	 */
	private WechatOpenId getOpenId(String code) {
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
				+ PropertiesUtil.getValue("wx.appid", CONFIG_FILE) + "&secret="
				+ PropertiesUtil.getValue("wx.secret", CONFIG_FILE) + "&code="
				+ code + "&grant_type=authorization_code";
		System.out.println("url:" + url);
		try {
			String xmlStr = HttpUtils.httpsGetRequest(url);
			if (StringUtils.isNotBlank(xmlStr)) {
				WechatOpenId info = CommonUtil.gson().fromJson(xmlStr,
						WechatOpenId.class);
				if (info != null && "7200".equals(info.getExpires_in())) {
					return info;
				}
			}
		} catch (Exception e) {
			throw new ServerDisponseException("9999",
					"获取OpenId失败：" + e.getMessage());
		}
		return null;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
