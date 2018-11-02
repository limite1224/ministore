package com.leshun.plc.util.wechat.bean.pay;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by caiyida on 2017/4/10.
 */
public class PayRequest {

	@JsonProperty(value = "appId")
	private String appId;
	@JsonProperty(value = "timeStamp")
	private String timeStamp;
	@JsonProperty(value = "nonceStr")
	private String nonceStr;
	@JsonProperty(value = "package")
	private String package_;
	@JsonProperty(value = "signType")
	private String signType;
	@JsonProperty(value = "paySign")
	private String paySign;
	@JsonProperty(value = "resultCode")
	private String resultCode;
	@JsonProperty(value = "mweb_url")
	private String mwebUrl;

	public String getMwebUrl() {
		return mwebUrl;
	}

	public void setMwebUrl(String mwebUrl) {
		this.mwebUrl = mwebUrl;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getPackage_() {
		return package_;
	}

	public void setPackage_(String package_) {
		this.package_ = package_;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getPaySign() {
		return paySign;
	}

	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}
}
