package com.leshun.plc.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.leshun.plc.comp.business.Goods;

public class OrderInfo extends DataEntity<OrderInfo> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4775823297503186356L;

	private String orderId;

	private String goodsName;
	private String goodsNames;

	private BigDecimal goodsPrice;
	private String goodsPrices;

	private BigDecimal goodsDiscount;
	private String goodsDiscounts;

	private Long goodsCount;
	private String goodsCounts;

	private String goodsRemark;
	private String goodsRemarks;

	private BigDecimal orderTotal;

	private String orderSource;

	private String orderType;// 0:单商品订单，非0：多商品订单

	private String province;

	private String city;

	private String district;

	private String address;

	private String recipients;

	private String mobile;

	private String openId;

	private Date orderTime;

	private Date deliveryTime;

	private String expressCompany;

	private String waybillNumber;

	private String deliveryMethod;

	private String orderStatus;

	private String sendSms;

	private Date sendTime;

	private Date orderFinishTime;

	private String orderKefu;

	private String wxPayOrderId;
	private String createIP;

	private List<Goods> goodsList;

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId == null ? null : orderId.trim();
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName == null ? null : goodsName.trim();
	}

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public BigDecimal getGoodsDiscount() {
		return goodsDiscount;
	}

	public void setGoodsDiscount(BigDecimal goodsDiscount) {
		this.goodsDiscount = goodsDiscount;
	}

	public Long getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(Long goodsCount) {
		this.goodsCount = goodsCount;
	}

	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource == null ? null : orderSource.trim();
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType == null ? null : orderType.trim();
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province == null ? null : province.trim();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district == null ? null : district.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getRecipients() {
		return recipients;
	}

	public void setRecipients(String recipients) {
		this.recipients = recipients == null ? null : recipients.trim();
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId == null ? null : openId.trim();
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getExpressCompany() {
		return expressCompany;
	}

	public void setExpressCompany(String expressCompany) {
		this.expressCompany = expressCompany == null ? null
				: expressCompany.trim();
	}

	public String getWaybillNumber() {
		return waybillNumber;
	}

	public void setWaybillNumber(String waybillNumber) {
		this.waybillNumber = waybillNumber == null ? null
				: waybillNumber.trim();
	}

	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod == null ? null
				: deliveryMethod.trim();
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus == null ? null : orderStatus.trim();
	}

	public String getSendSms() {
		return sendSms;
	}

	public void setSendSms(String sendSms) {
		this.sendSms = sendSms == null ? null : sendSms.trim();
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getOrderFinishTime() {
		return orderFinishTime;
	}

	public void setOrderFinishTime(Date orderFinishTime) {
		this.orderFinishTime = orderFinishTime;
	}

	public String getOrderKefu() {
		return orderKefu;
	}

	public void setOrderKefu(String orderKefu) {
		this.orderKefu = orderKefu == null ? null : orderKefu.trim();
	}

	public String getWxPayOrderId() {
		return wxPayOrderId;
	}

	public void setWxPayOrderId(String wxPayOrderId) {
		this.wxPayOrderId = wxPayOrderId == null ? null : wxPayOrderId.trim();
	}

	public String getGoodsRemark() {
		return goodsRemark;
	}

	public void setGoodsRemark(String goodsRemark) {
		this.goodsRemark = goodsRemark == null ? null : goodsRemark.trim();
	}

	public String getGoodsNames() {
		return goodsNames;
	}

	public void setGoodsNames(String goodsNames) {
		this.goodsNames = goodsNames;
	}

	public String getGoodsPrices() {
		return goodsPrices;
	}

	public void setGoodsPrices(String goodsPrices) {
		this.goodsPrices = goodsPrices;
	}

	public String getGoodsDiscounts() {
		return goodsDiscounts;
	}

	public void setGoodsDiscounts(String goodsDiscounts) {
		this.goodsDiscounts = goodsDiscounts;
	}

	public String getGoodsCounts() {
		return goodsCounts;
	}

	public void setGoodsCounts(String goodsCounts) {
		this.goodsCounts = goodsCounts;
	}

	public String getGoodsRemarks() {
		return goodsRemarks;
	}

	public void setGoodsRemarks(String goodsRemarks) {
		this.goodsRemarks = goodsRemarks;
	}

	public BigDecimal getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}

	public String getCreateIP() {
		return createIP;
	}

	public void setCreateIP(String createIP) {
		this.createIP = createIP;
	}

}