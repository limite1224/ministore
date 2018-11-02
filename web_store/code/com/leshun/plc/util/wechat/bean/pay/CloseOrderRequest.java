package com.leshun.plc.util.wechat.bean.pay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 关闭订单请求参数
 * Created by caiyida on 2017/4/7.
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class CloseOrderRequest {

    @XmlElement(name="appid")
    private String appid;//公众账号ID
    @XmlElement(name="mch_id")
    private String mchId;//商户号
    @XmlElement(name="out_trade_no")
    private String outTradeNo;//商户订单号
    @XmlElement(name="nonce_str")
    private String nonceStr;//随机字符串
    @XmlElement(name="sign")
    private String sign;//签名
    @XmlElement(name="sign_type")
    private String signType;//签名类型

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

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
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

}
