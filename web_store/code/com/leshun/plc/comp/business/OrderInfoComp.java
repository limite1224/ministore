package com.leshun.plc.comp.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.leshun.plc.bean.OrderInfo;
import com.leshun.plc.comp.BaseComp;
import com.leshun.plc.dao.OrderInfoDao;
import com.leshun.plc.service.businss.OrderInfoService;
import com.leshun.plc.util.CommonUtil;
import com.leshun.plc.util.DateUtils;
import com.leshun.plc.util.PropertiesUtil;
import com.leshun.plc.util.wechat.api.PayApi;
import com.leshun.plc.util.wechat.bean.pay.PayRequest;
import com.leshun.plc.util.wechat.bean.pay.UnifiedOrderRequest;
import com.leshun.plc.util.wechat.bean.pay.UnifiedOrderResponse;
import com.leshun.plc.util.wechat.utils.WxPayUtils;

@Component("orderInfoComp")
public class OrderInfoComp
		extends BaseComp<OrderInfo, OrderInfoDao, OrderInfoService> {
	private static final String WXFILE = "wx.properties";

	public PayRequest createOrder(OrderInfo orderInfo, String openId)
			throws Exception {
		String orderId = DateUtils.formatDate(new Date(), "yyyyMMddHHmmss")
				+ CommonUtil.createRandomNumber(4);
		orderInfo.setOrderId(orderId);
		orderInfo.setOpenId(openId);
		orderInfo.setOrderStatus("1");// 订单状态：1待付款2待发货3待签收0已完成'
		orderInfo.setOrderTime(new Date());// 订购时间
		service.insertSelective(orderInfo);
		// 调起小程序微信支付
		PayRequest request = toWeChatJSAPIPay(orderInfo, "JSAPI");
		return request;
	}

	private PayRequest toWeChatJSAPIPay(OrderInfo order, String payType) {
		UnifiedOrderRequest request = new UnifiedOrderRequest();
		request.setAppid(PropertiesUtil.getValue("wx.appid", WXFILE));
		request.setMchId(PropertiesUtil.getValue("wx.mchid", WXFILE));
		request.setNonceStr(WxPayUtils.getNonceStr(32));
		// 微信浏览器 格式:物联网卡充值-销售商品类目
		request.setBody("订单");
		request.setOutTradeNo(order.getOrderId());
		int totalFee = order.getOrderTotal().multiply(new BigDecimal(100))
				.intValue();
		request.setTotalFee(totalFee);// 微信侧单位为分
		//
		request.setSpbillCreateIp(order.getCreateIP());
		request.setNotifyUrl(PropertiesUtil.getValue("wx.notify", WXFILE));
		request.setTradeType("JSAPI");
		request.setOpenid(order.getOpenId());
		request.setSign(WxPayUtils.getSign(request,
				PropertiesUtil.getValue("wx.paykey", WXFILE)));
		// 调用统一下单接口
		UnifiedOrderResponse response = PayApi.unifiedOrder(request);
		if (!"SUCCESS".equals(response.getResultCode())) {
			System.out.println("orderId:" + order.getOrderId() + "支付异常："
					+ response.getErrCode() + ":" + response.getErrCodeDes()
					+ CommonUtil.gson().toJson(response));
		}
		PayRequest payReq = null;
		if ("FAIL".equals(response.getReturnCode())) {
			payReq = new PayRequest();
			// 下单失败，删除订单
			service.deleteByOrderId(order.getOrderId());
			payReq.setResultCode("FAIL");
			return payReq;
		}
		payReq = new PayRequest();
		payReq.setAppId(PropertiesUtil.getValue("wx.appid", WXFILE));
		String timeStamp = new BigDecimal(new Date().getTime())
				.divide(new BigDecimal(1000), BigDecimal.ROUND_HALF_UP)
				.toString();
		payReq.setTimeStamp(timeStamp);
		payReq.setNonceStr(WxPayUtils.getNonceStr(32));
		payReq.setPackage_("prepay_id=" + response.getPrepayId());
		payReq.setSignType("MD5");
		payReq.setPaySign(WxPayUtils.getSign(payReq,
				PropertiesUtil.getValue("wx.paykey", WXFILE)));

		payReq.setResultCode(response.getResultCode());
		System.out.println(payReq.toString());
		System.out.println(payReq.getPaySign());
		// 将prepayId存入数据库
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setOrderId(order.getOrderId());
		orderInfo.setWxPayOrderId(response.getPrepayId());
		service.updateByOrderId(orderInfo);

		return payReq;
	}

	@Override
	public List<OrderInfo> queryList(OrderInfo entity) throws Exception {
		String beginDate = entity == null ? "" : entity.getBeginDate();
		String endDate = entity == null ? "" : entity.getEndDate();
		// 默认为近七日订单，若未选择范围
		if (StringUtils.isBlank(beginDate)) {
			beginDate = DateUtils.getDayBefore(new Date(), 7);
			endDate = DateUtils.formatDate(new Date());
		}
		if (StringUtils.isBlank(endDate)) {
			endDate = DateUtils.formatDate(new Date());
		}
		if (entity == null) {
			entity = new OrderInfo();
		}
		entity.setBeginDate(beginDate);
		entity.setEndDate(endDate);
		return super.queryList(entity);
	}

	public boolean deleteByOrderId(String id) throws Exception {
		validate(id);
		return service.deleteByOrderId(id);
	}

	public OrderInfo selectByOrderId(String id) throws Exception {
		validate(id);

		List<OrderInfo> list = service.selectByOrderId(id);
		List<Goods> goodsList = new ArrayList<Goods>();
		for (OrderInfo order : list) {
			Goods goods = new Goods();
			goods.setGoodsCount(order.getGoodsCount());
			goods.setGoodsDiscount(order.getGoodsDiscount());
			goods.setGoodsName(order.getGoodsName());
			goods.setGoodsPrice(order.getGoodsPrice());
			goods.setGoodsRemark(order.getGoodsRemark());
			goodsList.add(goods);
		}
		OrderInfo orderInfo = list.get(0);
		orderInfo.setGoodsList(goodsList);
		return orderInfo;
	}

	public boolean updateByOrderId(OrderInfo entity) throws Exception {
		validate(entity);
		return service.updateByOrderId(entity);
	}
}
