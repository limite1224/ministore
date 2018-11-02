package com.leshun.plc.util.wechat.bean.pay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by caiyida on 2017/4/11.
 */
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransferRequest {

    @XmlElement(name="mch_appid")
    private String mchAppid;//企业号corpid即为此appId
    @XmlElement(name="mchid")
    private String mchid;//商户号
    @XmlElement(name="device_info")
    private String deviceInfo;//设备号
    @XmlElement(name="nonce_str")
    private String nonceStr;
    @XmlElement(name="sign")
    private String sign;//签名
    @XmlElement(name="partner_trade_no")
    private String partnerTradeNo;//商户订单号
    @XmlElement(name="openid")
    private String openid;//用户openid
    @XmlElement(name="check_name")
    private String checkName;//校验用户姓名选项
    @XmlElement(name="re_user_name")
    private String reUserName;//收款用户姓名
    @XmlElement(name="amount")
    private int amount;//金额
    @XmlElement(name="desc")
    private String desc;//企业付款描述信息
    @XmlElement(name="spbill_create_ip")
    private String spbillCreateIp;//Ip地址

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

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
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

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public String getReUserName() {
        return reUserName;
    }

    public void setReUserName(String reUserName) {
        this.reUserName = reUserName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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


}
