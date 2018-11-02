package com.leshun.plc.util.wechat.bean.pay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 下载对账单请求
 * Created by caiyida on 2017/4/7.
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class DownbillRequest {
    @XmlElement(name="appid")
    private String appid;//公众账号ID
    @XmlElement(name="mch_id")
    private String mchId;//商户号
    @XmlElement(name="device_info")
    private String deviceInfo;//商户号
    @XmlElement(name="nonce_str")
    private String nonceStr;//随机字符串
    @XmlElement(name="sign")
    private String sign;//签名
    @XmlElement(name="sign_type")
    private String signType;//签名类型,目前支持HMAC-SHA256和MD5，默认为MD5
    @XmlElement(name="bill_date")
    private String billDate;//对账单日期,格式：20140603
    @XmlElement(name="bill_type")
    private String billType;//ALL，返回当日所有订单信息，默认值;SUCCESS，返回当日成功支付的订单;REFUND，返回当日退款订单;RECHARGE_REFUND，返回当日充值退款订单（相比其他对账单多一栏“返还手续费”）
    @XmlElement(name="tar_type")
    private String tarType;//压缩账单,非必传参数，固定值：GZIP，

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

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getTarType() {
        return tarType;
    }

    public void setTarType(String tarType) {
        this.tarType = tarType;
    }

}
