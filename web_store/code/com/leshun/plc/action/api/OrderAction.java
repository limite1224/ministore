package com.leshun.plc.action.api;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.leshun.plc.action.SuperAction;
import com.leshun.plc.bean.OrderInfo;
import com.leshun.plc.comp.business.OrderInfoComp;
import com.leshun.plc.util.CommonUtil;
import com.leshun.plc.util.wechat.bean.pay.PayNotifyResponse;
import com.leshun.plc.util.wechat.bean.pay.PayRequest;
import com.leshun.plc.util.wechat.bean.pay.PayResponse;

public class OrderAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8385525527280528500L;
	private static Gson gson;

	public OrderAction() {
		gson = CommonUtil.gson();
	}

	private String orderId;
	private OrderInfo orderInfo;
	private List<OrderInfo> orderList;

	private PayNotifyResponse payNotifyResponse;
	@Autowired
	private OrderInfoComp orderInfoComp;

	/**
	 * 创建订单
	 */
	public String createOrder() {
		String token = getRequest().getHeader("token");
		HttpSession session = getRequest().getSession();
		String sessionToken = (String) session.getAttribute("token");
		if (StringUtils.isBlank(token) || StringUtils.isBlank(sessionToken)) {
			message = gson.toJson(ajaxResp(0, "login_time_out"));
			return "ajax";
		}
		if (!token.equals(sessionToken)) {
			message = gson.toJson(ajaxResp(0, "login_time_out"));
			return "ajax";
		}
		String openId = (String) session.getAttribute(sessionToken);
		PayRequest request = null;
		try {
			request = orderInfoComp.createOrder(orderInfo, openId);
		} catch (Exception e) {
			log.info("订单创建异常：", e);
			message = gson.toJson(ajaxResp(0, "create_order_fail"));
			return "ajax";
		}
		if (request == null) {
			message = gson.toJson(ajaxResp(0, "create_order_fail"));
			return "ajax";
		}
		message = gson.toJson(ajaxResp(1, request));
		return "ajax";
	}

	/**
	 * 订单列表
	 */
	public String orderList() {
		// 查询最近一周的订单
		try {
			orderList = orderInfoComp.queryList(orderInfo);
		} catch (Exception e) {
			log.info("订单列表查询异常：", e);
			message = gson.toJson(ajaxResp(0, "查询异常"));
			return "ajax";
		}
		message = gson.toJson(orderList);
		return "ajax";
	}

	/**
	 * 单笔订单查询
	 */
	public String getOrder() {
		try {
			orderInfo = orderInfoComp.selectByOrderId(orderId);
		} catch (Exception e) {
			log.info("订单查询异常：", e);
			message = gson.toJson(ajaxResp(0, "查询异常"));
			return "ajax";
		}
		message = ajaxResp(1, gson.toJson(orderInfo));
		return "ajax";
	}

	public String payNotify() {
		log.info("微信支付回调订单：[" + payNotifyResponse.getOutTradeNo()
				+ "],returnCode:" + payNotifyResponse.getReturnCode() + "支付结果："
				+ payNotifyResponse.getResultCode() + "微信订单号："
				+ payNotifyResponse.getTransactionId() + "交易类型："
				+ payNotifyResponse.getTradeType() + "aapId："
				+ payNotifyResponse.getAppid() + "交易结束时间："
				+ payNotifyResponse.getTimeEnd() + "交易额："
				+ payNotifyResponse.getTotalFee());
		PayResponse presp = null;
		if (StringUtils.isBlank(payNotifyResponse.getReturnCode())
				|| "null".equals(payNotifyResponse.getReturnCode())
				|| payNotifyResponse == null) {
			presp = new PayResponse();
			presp.setReturnCode("FAIL");
			presp.setReturnMsg("缺少必要请求参数");
			// 未找到有效信息
			message = gson.toJson(presp);
			return "ajax";
		}
		// 判断通信是否成功
		if ("FAIL".equals(payNotifyResponse.getReturnCode())) {
			presp = new PayResponse();
			presp.setReturnCode("FAIL");
			// 通讯故障
			presp.setReturnMsg("communication_failure："
					+ payNotifyResponse.getReturnMsg());
			message = gson.toJson(presp);
			return "ajax";
		}

		// 查询老订单，判断是否存在此订单
		OrderInfo order_old = null;
		try {
			order_old = orderInfoComp
					.selectByOrderId(payNotifyResponse.getOutTradeNo());
		} catch (Exception e) {
			log.info("更新订单" + order_old.getOrderId() + "失败", e);
			presp = new PayResponse();
			presp.setReturnCode("FAIL");
			presp.setReturnMsg("system_exception");
			message = gson.toJson(presp);
			return "ajax";
		}
		if (order_old == null) {
			presp = new PayResponse();
			presp.setReturnCode("SUCCESS");
			presp.setReturnMsg("system_order_no_exist");
			// 未找到本地订单不做更新，不再接收微信对此的回调
			message = gson.toJson(presp);
			return "ajax";
		}
		// 看此订单时候已更新为终态
		if ("0".equals(order_old.getOrderStatus())) {
			presp = new PayResponse();
			presp.setReturnCode("SUCCESS");
			presp.setReturnMsg("OK");
			// 已支付不再接收微信回调
			message = gson.toJson(presp);
			return "ajax";
		}
		// 判断金额是否一样
		BigDecimal payMoney = order_old.getOrderTotal()
				.multiply(new BigDecimal(100));// 分
		if (payMoney.compareTo(
				(new BigDecimal(payNotifyResponse.getTotalFee()))) != 0) {
			presp = new PayResponse();
			presp.setReturnCode("FAIL");
			presp.setReturnMsg("order_amount_differ");
			// 已支付不再接收微信回调
			message = gson.toJson(presp);
			return "ajax";
		}
		if (!"SUCCESS".equals(payNotifyResponse.getResultCode())
				&& !"FAIL".equals(payNotifyResponse.getResultCode())) {
			presp = new PayResponse();
			presp.setReturnCode("FAIL");
			presp.setReturnMsg("non-final");
			// 已支付不再接收微信回调
			message = gson.toJson(presp);
			return "ajax";
		}
		String orderStatus = "2";// 待发货
		if ("FAIL".equals(payNotifyResponse.getResultCode())) {
			orderStatus = "4";// 订单失败
		}
		OrderInfo order_update = new OrderInfo();
		order_update.setOrderId(payNotifyResponse.getOutTradeNo());
		order_update.setOrderStatus(orderStatus);
		order_update.setOrderSource(payNotifyResponse.getTradeType());
		order_update.setWxPayOrderId(payNotifyResponse.getTransactionId());
		try {
			orderInfoComp.updateByOrderId(order_update);
		} catch (Exception e) {
			log.info("更新订单" + order_update.getOrderId() + "失败", e);
			presp = new PayResponse();
			presp.setReturnCode("FAIL");
			presp.setReturnMsg("system_exception");
			message = gson.toJson(presp);
			return "ajax";
		}
		presp = new PayResponse();
		presp.setReturnCode("SUCCESS");
		presp.setReturnMsg("OK");
		message = gson.toJson(presp);
		return "ajax";
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public OrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	public List<OrderInfo> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderInfo> orderList) {
		this.orderList = orderList;
	}

}
