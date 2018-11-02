package com.leshun.plc.util.wechat.bean.pay;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by caiyida on 2017/4/7.
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderQueryResponse {

    @XmlElement(name="return_code")
    private String returnCode;
    @XmlElement(name="return_msg")
    private String returnMsg;
    @XmlElement(name="appid")
    private String appid;//公众账号ID
    @XmlElement(name="mch_id")
    private String mchId;//商户号
    @XmlElement(name="nonce_str")
    private String nonceStr;//随机字符串
    @XmlElement(name="sign")
    private String sign;//签名
    @XmlElement(name="resultCode")
    private String resultCode;//业务结果
    @XmlElement(name="err_code")
    private String errCode;//错误代码
    @XmlElement(name="err_code_des")
    private String errCodeDes;//错误代码描述
    @XmlElement(name="device_info")
    private String deviceInfo;//设备号
    @XmlElement(name="openid")
    private String openid;//用户标识
    @XmlElement(name="is_subscribe")
    private String isSubscribe;//是否关注公众账号
    @XmlElement(name="trade_type")
    private String tradeType;//交易类型
    @XmlElement(name="trade_state")
    private String tradeState;//交易状态
    @XmlElement(name="bank_type")
    private String bankType;//付款银行
    @XmlElement(name="total_fee")
    private String totalFee;//标价金额
    @XmlElement(name="settlement_total_fee")
    private String settlementTotalFee;//应结订单金额
    @XmlElement(name="fee_type")
    private String feeType;//标价币种
    @XmlElement(name="cash_fee")
    private String cashFee;//现金支付金额
    @XmlElement(name="cash_fee_type")
    private String cashFeeType;//现金支付币种
    @XmlElement(name="coupon_fee")
    private String couponFee;//代金券金额
    @XmlElement(name="coupon_count")
    private String couponCount;//代金券使用数量
    @XmlElement(name="coupon_type_1")
    private String couponType1;//代金券类型
    @XmlElement(name="coupon_id_1")
    private String couponId1;//代金券ID
    @XmlElement(name="coupon_fee_1")
    private String couponFee1;//单个代金券支付金额
    @XmlElement(name="transaction_id")
    private String transactionId;//微信支付订单号
    @XmlElement(name="out_trade_no")
    private String outTradeNo;//商户订单号
    @XmlElement(name="attach")
    private String attach;//附加数据
    @XmlElement(name="time_end")
    private String timeEnd;//支付完成时间
    @XmlElement(name="trade_state_desc")
    private String tradeStateDesc;//交易状态描述


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

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getIsSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(String isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getSettlementTotalFee() {
        return settlementTotalFee;
    }

    public void setSettlementTotalFee(String settlementTotalFee) {
        this.settlementTotalFee = settlementTotalFee;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getCashFee() {
        return cashFee;
    }

    public void setCashFee(String cashFee) {
        this.cashFee = cashFee;
    }

    public String getCashFeeType() {
        return cashFeeType;
    }

    public void setCashFeeType(String cashFeeType) {
        this.cashFeeType = cashFeeType;
    }

    public String getCouponFee() {
        return couponFee;
    }

    public void setCouponFee(String couponFee) {
        this.couponFee = couponFee;
    }

    public String getCouponCount() {
        return couponCount;
    }

    public void setCouponCount(String couponCount) {
        this.couponCount = couponCount;
    }

    public String getCouponType1() {
        return couponType1;
    }

    public void setCouponType1(String couponType1) {
        this.couponType1 = couponType1;
    }

    public String getCouponId1() {
        return couponId1;
    }

    public void setCouponId1(String couponId1) {
        this.couponId1 = couponId1;
    }

    public String getCouponFee1() {
        return couponFee1;
    }

    public void setCouponFee1(String couponFee1) {
        this.couponFee1 = couponFee1;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getTradeStateDesc() {
        return tradeStateDesc;
    }

    public void setTradeStateDesc(String tradeStateDesc) {
        this.tradeStateDesc = tradeStateDesc;
    }
}
