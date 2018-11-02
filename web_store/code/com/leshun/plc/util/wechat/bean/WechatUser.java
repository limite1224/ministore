package com.leshun.plc.util.wechat.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by caiyida on 2017/4/25.
 */
public class WechatUser {

	private String openid;
	private String userid;// 必填，成员UserID
	private String name;// 必填，成员名称
	private String department;// 必填，成员所属部门id列表,[1, 2]
	private String position;// 非必填，职位信息
	private String mobile;// 非必填，手机号,mobile/weixinid/email三者不能同时为空
	private String gender;// 非必填，性别，1表示男性，2表示女性
	private String email;// 非必填，邮箱
	private String weixinid;// 非必填,微信号
	private String avatar;// 非必填，成员头像的mediaid
	@JSONField(name = "extattr")
	private String extattr;// 非必填，扩展属性
	private String appid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeixinid() {
		return weixinid;
	}

	public void setWeixinid(String weixinid) {
		this.weixinid = weixinid;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getExtattr() {
		return extattr;
	}

	public void setExtattr(String extattr) {
		this.extattr = extattr;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public static void main(String[] args) {
		String str = "{\"userid\":\"zhangsan\",\"name\":\"张三\",\"department\":[1,2],\"position\":\"产品经理\",\"mobile\":\"15913215421\",\"gender\":\"1\",\"email\":\"zhangsan@gzdev.com\",\"weixinid\":\"zhangsan4dev\",\"avatar_mediaid\":\"2-G6nrLmr5EC3MNb_-zL1dDdzkd0p7cNliYu9V5w7o8K0\"}";
		WechatUser user = JSON.parseObject(str, WechatUser.class);
		System.out.println(JSON.toJSONString(user));
	}

}
