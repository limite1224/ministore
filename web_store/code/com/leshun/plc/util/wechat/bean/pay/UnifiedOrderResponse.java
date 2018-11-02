package com.leshun.plc.util.wechat.bean.pay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 统一下单结果 Created by caiyida on 2017/4/7.
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class UnifiedOrderResponse {

	@XmlElement(name = "return_code")
	private String returnCode;
	@XmlElement(name = "return_msg")
	private String returnMsg;
	@XmlElement(name = "appid")
	private String appid;// 公众账号ID
	@XmlElement(name = "openid")
	private String openid;
	@XmlElement(name = "mch_id")
	private String mchId;// 商户号
	@XmlElement(name = "device_info")
	private String deviceInfo;// 设备号
	@XmlElement(name = "nonce_str")
	private String nonceStr;// 随机字符串
	@XmlElement(name = "sign")
	private String sign;// 签名
	@XmlElement(name = "result_code")
	private String resultCode;
	@XmlElement(name = "err_code")
	private String errCode;// 错误代码
	@XmlElement(name = "err_code_des")
	private String errCodeDes;// 错误代码描述
	@XmlElement(name = "trade_type")
	private String tradeType;// 交易类型,JSAPI
	@XmlElement(name = "prepay_id")
	private String prepayId;// 预支付交易会话标识
	@XmlElement(name = "code_url")
	private String codeUrl;// 二维码链接,trade_type为NATIVE时有返回
	@XmlElement(name = "mweb_url")
	private String mwebUrl;

	public String getMwebUrl() {
		return mwebUrl;
	}

	public void setMwebUrl(String mwebUrl) {
		this.mwebUrl = mwebUrl;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrCodeDes() {
		return errCodeDes;
	}

	public void setErrCodeDes(String errCodeDes) {
		this.errCodeDes = errCodeDes;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getPrepayId() {
		return prepayId;
	}

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}

	public String getCodeUrl() {
		return codeUrl;
	}

	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

}
