package com.leshun.plc.util.wechat.bean;

import java.util.Date;

/**
 * Created by caiyida on 2017/4/11.
 */
public class WpayTransfer {

	private String id;
	private String devideInfo;// 设备号
	private String partnerTradeNo;// 商户订单号
	private String openid;// 某用户的openid
	private String customerId;// 客户ID
	private String reUserName;// 收款用户真实姓名
	private Double amount;// 金额
	private String desc;// 企业付款描述信息
	private String spbillCreateIp;// 调用接口的机器Ip地址
	private int status;// 状态 0、失败，1成功，
	private Date createDate;
	private Date updateDate;
	private String appid;// 企业号appid
	private String secret;// 企业号secret
	private String mchId;// 微信支付商户号

	// value object
	private String key;// 微信支付key

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDevideInfo() {
		return devideInfo;
	}

	public void setDevideInfo(String devideInfo) {
		this.devideInfo = devideInfo;
	}

	public String getPartnerTradeNo() {
		return partnerTradeNo;
	}

	public void setPartnerTradeNo(String partnerTradeNo) {
		this.partnerTradeNo = partnerTradeNo;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getReUserName() {
		return reUserName;
	}

	public void setReUserName(String reUserName) {
		this.reUserName = reUserName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}

	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
