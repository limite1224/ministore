package com.leshun.plc.util.wechat.bean.pay;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.leshun.plc.util.CommonUtil;

/**
 * 统一下单参数 Created by caiyida on 2017/4/7.
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class UnifiedOrderRequest {

	@XmlElement(name = "appid")
	private String appid;// 公众账号ID
	@XmlElement(name = "mch_id")
	private String mchId;// 商户号
	@XmlElement(name = "device_info")
	private String deviceInfo;// 设备号 否
	@XmlElement(name = "nonce_str")
	private String nonceStr;// 随机字符串
	@XmlElement(name = "sign")
	private String sign;// 签名
	@XmlElement(name = "sign_type")
	private String signType;// 默认MD5，支持HMAC-SHA256和MD5。 //否
	@XmlElement(name = "body")
	private String body;// 商品描述
	@XmlElement(name = "detail")
	private String detail;// 商品详情 //否
	@XmlElement(name = "attach")
	private String attach;// 附加数据 //否
	@XmlElement(name = "out_trade_no")
	private String outTradeNo;// 商户订单号,建议根据当前系统时间加随机序列来生成订单号
	@XmlElement(name = "fee_type")
	private String feeType;// 标价币种 CNY //否
	@XmlElement(name = "total_fee")
	private Integer totalFee;// 标价金额,支付金额单位为【分】，参数值不能带小数
	@XmlElement(name = "spbill_create_ip")
	private String spbillCreateIp;// 终端IP
	@XmlElement(name = "time_start")
	private String timeStart;// 交易起始时间,格式为yyyyMMddHHmmss //否
	@XmlElement(name = "time_expire")
	private String timeExpire;// 交易结束时间,格式为yyyyMMddHHmmss //否
	@XmlElement(name = "goods_tag")
	private String goodsTag;// 商品标记,WXG,使用代金券或立减优惠功能时需要的参数,非必须
	@XmlElement(name = "notify_url")
	private String notifyUrl;// 通知地址
	@XmlElement(name = "trade_type")
	private String tradeType;// 交易类型,取值如下：JSAPI，NATIVE，APP等
	@XmlElement(name = "product_id")
	private String productId;// 商品ID,trade_type=NATIVE时（即扫码支付），此参数必传。
	@XmlElement(name = "limit_pay")
	private String limitPay;// 指定支付方式,上传此参数no_credit--可限制用户不能使用信用卡支付
	@XmlElement(name = "openid")
	private String openid;// 用户标识,trade_type=JSAPI时（即公众号支付），此参数必传
	@XmlElement(name = "scene_info")
	private String sceneInfo;
	@XmlElement(name = "sub_mch_id")
	private String subMchId;

	public String getSceneInfo() {
		return sceneInfo;
	}

	public void setSceneInfo(String type, String wapUrl, String wapName) {
		Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();
		Map<String, String> h5Info = new HashMap<String, String>();
		h5Info.put("type", type);// 场景类型
		h5Info.put("wap_url", wapUrl);// wap网站URL地址
		h5Info.put("wap_name", wapName);// wap网站名
		map.put("h5_info"/* h5固定传入 */, (HashMap<String, String>) h5Info);
		this.sceneInfo = CommonUtil.gson().toJson(map);
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

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}

	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeExpire() {
		return timeExpire;
	}

	public void setTimeExpire(String timeExpire) {
		this.timeExpire = timeExpire;
	}

	public String getGoodsTag() {
		return goodsTag;
	}

	public void setGoodsTag(String goodsTag) {
		this.goodsTag = goodsTag;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getLimitPay() {
		return limitPay;
	}

	public void setLimitPay(String limitPay) {
		this.limitPay = limitPay;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getSubMchId() {
		return subMchId;
	}

	public void setSubMchId(String subMchId) {
		this.subMchId = subMchId;
	}

}
