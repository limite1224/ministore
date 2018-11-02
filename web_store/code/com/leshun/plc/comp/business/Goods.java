package com.leshun.plc.comp.business;

import java.math.BigDecimal;

public class Goods {

	private String goodsName;

	private BigDecimal goodsPrice;

	private BigDecimal goodsDiscount;

	private Long goodsCount;

	private String goodsRemark;

	public String getGoodsRemark() {
		return goodsRemark;
	}

	public void setGoodsRemark(String goodsRemark) {
		this.goodsRemark = goodsRemark;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
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

}
