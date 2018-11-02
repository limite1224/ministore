package com.leshun.plc.util.wechat.api;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.leshun.plc.util.wechat.bean.AccessToken;
import com.leshun.plc.util.wechat.utils.HttpUtils;

/**
 * Created by caiyida on 2017/4/6.
 */
public class AccessTokenAPI {
	private static Logger logger = Logger.getLogger(AccessTokenAPI.class);

	private static String access_token_url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=APPID&corpsecret=SECRET";

	/**
	 *
	 * @Description: 返回Token方法 @return AccessToken @param appid @param
	 *               secret @Author：cyd @throws
	 */
	public static AccessToken getAccessToken(String appid, String secret) {
		AccessToken accessToken = null;
		String url = access_token_url.replace("APPID", appid).replace("SECRET",
				secret);
		System.out.println(url);
		JSONObject jsonObject = JSON
				.parseObject(HttpUtils.httpsGetRequest(url));
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				if ("0".equals(jsonObject.getString("errcode")) || (StringUtils
						.isNotEmpty(jsonObject.getString("access_token")))) {
					accessToken.setToken(jsonObject.getString("access_token"));
					accessToken
							.setExpiresIn(jsonObject.getInteger("expires_in"));
				} else {
					throw new RuntimeException("获取appid为:" + appid
							+ "的客户token失败请检查appid/secret是否设置正确");
				}

			} catch (Exception e) {
				// 获取token失败
				logger.error("获取token失败 errcode:{} errmsg:{}" + e.getMessage());
			}
		}
		return accessToken;
	}

	// public static void main(String[] args) {
	// System.out
	// .println(AccessTokenAPI.getAccessToken(Global.getWechatCorpId(),
	// Global.getWechatSecret()).getToken());
	// }

}
