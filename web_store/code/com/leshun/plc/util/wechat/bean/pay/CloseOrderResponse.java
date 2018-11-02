package com.leshun.plc.util.wechat.bean.pay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 关闭订单响应
 * Created by caiyida on 2017/4/7.
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class CloseOrderResponse {

    @XmlElement(name="return_code")
    private String returnCode;
    @XmlElement(name="return_msg")
    private String returnMsg;
    @XmlElement(name="appid")
    private String appid;//微信分配的公众账号ID
    @XmlElement(name="mch_id")
    private String mchId;//微信支付分配的商户号
    @XmlElement(name="nonce_str")
    private String nonceStr;//随机字符串，不长于32位。
    @XmlElement(name="sign")
    private String sign;//签名
    @XmlElement(name="result_code")
    private String resultCode;//业务结果 SUCCESS/FAIL
    @XmlElement(name="result_msg")
    private String resultMsg;//业务结果描述
    @XmlElement(name="err_code")
    private String errCode;//错误代码
    @XmlElement(name="err_code_des")
    private String errCodeDes;//错误代码描述

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

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
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
}
