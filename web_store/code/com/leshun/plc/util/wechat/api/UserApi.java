package com.leshun.plc.util.wechat.api;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.entity.ContentType;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.leshun.plc.util.wechat.bean.UserInfo;
import com.leshun.plc.util.wechat.bean.message.BaseMessageResponse;
import com.leshun.plc.util.wechat.bean.user.GetUserByDeptResponse;
import com.leshun.plc.util.wechat.bean.user.User;
import com.leshun.plc.util.wechat.bean.user.UserResponse;
import com.leshun.plc.util.wechat.utils.HttpUtils;

/**
 * Created by caiyida on 2017/4/9.
 */
public class UserApi {

	private static Logger logger = Logger.getLogger(UserApi.class);

	private static String convert_to_openid = "https://qyapi.weixin.qq.com/cgi-bin/user/convert_to_openid?access_token=ACCESS_TOKEN";
	private static String convert_to_userid = "https://qyapi.weixin.qq.com/cgi-bin/user/convert_to_userid?access_token=ACCESS_TOKEN";
	private static String user_info_url = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=ACCESS_TOKEN&code=CODE";
	private static String authsucc_url = "https://qyapi.weixin.qq.com/cgi-bin/user/authsucc?access_token=ACCESS_TOKEN&userid=USERID";

	private static String create_user_url = "https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=ACCESS_TOKEN";
	private static String update_user_url = "https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token=ACCESS_TOKEN";
	private static String delete_user_url = "https://qyapi.weixin.qq.com/cgi-bin/user/delete?access_token=ACCESS_TOKEN&userid=USERID";
	private static String delete_batch_user_url = "https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete?access_token=ACCESS_TOKEN";

	private static String get_user_url = "https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&userid=USERID";
	private static String get_department_user_simple_url = "https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token=ACCESS_TOKEN&department_id=DEPARTMENT_ID&fetch_child=FETCH_CHILD&status=STATUS";
	private static String get_department_user_list_url = "https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token=ACCESS_TOKEN&department_id=DEPARTMENT_ID&fetch_child=FETCH_CHILD&status=STATUS";

	/**
	 * 创建成员
	 *
	 * @param accessToken
	 * @param request
	 * @return
	 */
	public static UserResponse createUser(String accessToken, User request) {
		String url = create_user_url.replace("ACCESS_TOKEN", accessToken);
		String result = HttpUtils.httpsPostRequestString(url,
				JSON.toJSONString(request), ContentType.APPLICATION_JSON);
		UserResponse response = JSON.parseObject(result, UserResponse.class);
		return response;
	}

	/**
	 * 更新成员
	 *
	 * @param accessToken
	 * @param request
	 * @return
	 */
	public static UserResponse updateUser(String accessToken, User request) {
		String url = update_user_url.replace("ACCESS_TOKEN", accessToken);
		String result = HttpUtils.httpsPostRequestString(url,
				JSON.toJSONString(request), ContentType.APPLICATION_JSON);
		UserResponse response = JSON.parseObject(result, UserResponse.class);
		return response;
	}

	/**
	 * 删除成员
	 *
	 * @param accessToken
	 * @param userid
	 * @return
	 */
	public static UserResponse deleteUser(String accessToken, String userid) {
		String url = delete_user_url.replace("ACCESS_TOKEN", accessToken)
				.replace("USERID", userid);
		String result = HttpUtils.httpsGetRequest(url);
		UserResponse response = JSON.parseObject(result, UserResponse.class);
		return response;
	}

	/**
	 * 批量删除成员
	 *
	 * @param accessToken
	 * @param useridList
	 * @return
	 */
	public static UserResponse batchDeleteUser(String accessToken,
			List<String> useridList) {
		String url = delete_user_url.replace("ACCESS_TOKEN", accessToken);
		JSONObject request = new JSONObject();
		request.put("useridlist", useridList);
		String result = HttpUtils.httpsPostRequestString(url,
				request.toJSONString(), ContentType.APPLICATION_JSON);
		UserResponse response = JSON.parseObject(result, UserResponse.class);
		return response;
	}

	/**
	 * 获取单个成员
	 *
	 * @param accessToken
	 * @param userid
	 * @return
	 */
	public static User getUser(String accessToken, String userid) {
		String url = get_user_url.replace("ACCESS_TOKEN", accessToken)
				.replace("USERID", userid);
		String result = HttpUtils.httpsGetRequest(url);
		User response = JSON.parseObject(result, User.class);
		return response;
	}

	public static GetUserByDeptResponse getSimpleUserByDept(String accessToken,
			String deptId, String fetchChild, String status) {
		String url = get_department_user_simple_url
				.replace("ACCESS_TOKEN", accessToken)
				.replace("DEPARTMENT_ID", deptId)
				.replace("FETCH_CHILD", fetchChild).replace("STATUS", status);
		String result = HttpUtils.httpsGetRequest(url);
		GetUserByDeptResponse response = JSON.parseObject(result,
				GetUserByDeptResponse.class);
		return response;
	}

	public static GetUserByDeptResponse getUserByDept(String accessToken,
			String deptId, String fetchChild, String status) {
		String url = get_department_user_list_url
				.replace("ACCESS_TOKEN", accessToken)
				.replace("DEPARTMENT_ID", deptId)
				.replace("FETCH_CHILD", fetchChild).replace("STATUS", status);
		String result = HttpUtils.httpsGetRequest(url);
		GetUserByDeptResponse response = JSON.parseObject(result,
				GetUserByDeptResponse.class);
		return response;
	}

	/**
	 * accessToken userId
	 *
	 * @return
	 */
	public static boolean authSucc(String acceccToken, String userId) {
		String url = authsucc_url.replace("ACCESS_TOKEN", acceccToken)
				.replace("USERID", userId);
		BaseMessageResponse response = JSONObject.parseObject(
				HttpUtils.httpsGetRequest(url), BaseMessageResponse.class);
		if ("0".equals(response.getErrcode())) {
			return true;
		}
		return false;
	}

	/**
	 * @author CYD 鉴权方法
	 */
	public static UserInfo getUserInfo(String accessToken, String code) {
		String url = user_info_url.replace("ACCESS_TOKEN", accessToken)
				.replace("CODE", code);
		String result = HttpUtils.httpsGetRequest(url);
		JSONObject jsonObject = JSON.parseObject(result);
		// 如果请求成功
		try {
			if ("0".equals(jsonObject.getString("errcode"))
					|| StringUtils.isNotEmpty(jsonObject.getString("UserId"))
					|| StringUtils.isNotEmpty(jsonObject.getString("OpenId"))) {
				UserInfo userInfo = new UserInfo();
				userInfo.setUserId(jsonObject.getString("UserId"));
				userInfo.setOpenId(jsonObject.getString("OpenId"));
				userInfo.setDeviceId(jsonObject.getString("DeviceId"));
				return userInfo;
			} else {
				throw new RuntimeException(
						"获取用户信息出错：" + jsonObject.getString("errcode"));
			}

		} catch (Exception e) {
			// 获取token失败
			logger.error("获取token失败 errcode:{} errmsg:{}" + e.getMessage());
		}
		return null;
	}

	/**
	 * @param accessToken
	 * @param userId
	 *            用户id
	 * @param agentId
	 *            企业号内的成员id,需要发送红包的应用ID，若只是使用微信支付和企业转账，则无需该参数
	 */
	public static String convertToOpenId(String accessToken, String userId,
			String agentId) {
		String url = convert_to_openid.replace("ACCESS_TOKEN", accessToken);
		JSONObject j = new JSONObject();
		j.put("userid", userId);
		if (StringUtils.isNotEmpty(agentId)) {
			j.put("agentid", agentId);
		}

		JSONObject jso = JSON.parseObject(HttpUtils.httpsPostRequestString(url,
				j.toJSONString(), ContentType.APPLICATION_JSON));
		if ("0".equals(jso.getString("errcode"))
				|| StringUtils.isNotEmpty(jso.getString("openid"))) {
			return jso.getString("openid");
		}
		return null;
	}

	public static String convertToUserId(String accessToken, String openId) {
		String url = convert_to_userid.replace("ACCESS_TOKEN", accessToken);
		JSONObject j = new JSONObject();
		j.put("openid", openId);
		JSONObject jso = JSON.parseObject(HttpUtils.httpsPostRequestString(url,
				j.toJSONString(), ContentType.APPLICATION_JSON));
		if ("0".equals(jso.getString("errcode"))
				|| StringUtils.isNotEmpty(jso.getString("userid"))) {
			return jso.getString("userid");
		}
		return null;
	}
}
