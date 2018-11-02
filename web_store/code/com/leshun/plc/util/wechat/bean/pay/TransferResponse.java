package com.leshun.plc.util.wechat.bean.pay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by caiyida on 2017/4/11.
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransferResponse {

    @XmlElement(name="return_code")
    private String returnCode;
    @XmlElement(name="return_msg")
    private String returnMsg;
    @XmlElement(name="mch_appid")
    private String mchAppid;//商户appid
    @XmlElement(name="mchid")
    private String mchid;//商户号
    @XmlElement(name="device_info")
    private String deviceInfo;//设备号
    @XmlElement(name="nonce_str")
    private String nonceStr;//随机字符串
    @XmlElement(name="result_code")
    private String resultCode;//业务结果
    @XmlElement(name="err_code")
    private String errCode;//错误代码
    @XmlElement(name="err_code_des")
    private String errCodeDes;//错误代码描述
    @XmlElement(name="partner_trade_no")
    private String partnerTradeNo;//商户订单号
    @XmlElement(name="payment_no")
    private String paymentNo;//商户订单号
    @XmlElement(name="payment_time")
    private String paymentTime;//微信支付成功时间

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

    public String getMchAppid() {
        return mchAppid;
    }

    public void setMchAppid(String mchAppid) {
        this.mchAppid = mchAppid;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
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

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
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

    public String getPartnerTradeNo() {
        return partnerTradeNo;
    }

    public void setPartnerTradeNo(String partnerTradeNo) {
        this.partnerTradeNo = partnerTradeNo;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }
}
