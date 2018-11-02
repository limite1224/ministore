package com.leshun.plc.util.wechat.api;

import org.apache.http.entity.ContentType;

import com.leshun.plc.util.wechat.bean.pay.CloseOrderRequest;
import com.leshun.plc.util.wechat.bean.pay.CloseOrderResponse;
import com.leshun.plc.util.wechat.bean.pay.DownbillRequest;
import com.leshun.plc.util.wechat.bean.pay.DownbillResponse;
import com.leshun.plc.util.wechat.bean.pay.OrderQueryRequest;
import com.leshun.plc.util.wechat.bean.pay.OrderQueryResponse;
import com.leshun.plc.util.wechat.bean.pay.SignkeyRequest;
import com.leshun.plc.util.wechat.bean.pay.SignkeyResponse;
import com.leshun.plc.util.wechat.bean.pay.TransferRequest;
import com.leshun.plc.util.wechat.bean.pay.TransferResponse;
import com.leshun.plc.util.wechat.bean.pay.UnifiedOrderRequest;
import com.leshun.plc.util.wechat.bean.pay.UnifiedOrderResponse;
import com.leshun.plc.util.wechat.utils.HttpUtils;
import com.leshun.plc.util.wechat.utils.WxPayUtils;
import com.leshun.plc.util.wechat.utils.XmlUtils;

/**
 * Created by caiyida on 2017/4/7.
 */
public class PayApi {
	private static boolean debug = false;

	private static String pay_unifiedorder_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	private static String order_query_url = "https://api.mch.weixin.qq.com/pay/orderquery";
	private static String close_order_url = "https://api.mch.weixin.qq.com/pay/closeorder";
	private static String downloadbill_url = "https://api.mch.weixin.qq.com/pay/downloadbill";
	private static String transfer_url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";

	private static String sandbox_pay_unifiedorder_url = "https://api.mch.weixin.qq.com/sandboxnew/pay/unifiedorder";
	private static String sandbox_order_query_url = "https://api.mch.weixin.qq.com/sandboxnew/pay/orderquery";
	private static String sandbox_close_order_url = "https://api.mch.weixin.qq.com/sandboxnew/pay/closeorder";
	private static String sandbox_downloadbill_url = "https://api.mch.weixin.qq.com/sandboxnew/pay/downloadbill";
	private static String sandbox_transfer_url = "https://api.mch.weixin.qq.com/sandboxnew/mmpaymkttransfers/promotion/transfers";
	private static String sandbox_get_sign_key_url = "https://api.mch.weixin.qq.com/sandboxnew/pay/getsignkey";

	/**
	 * 统一下单
	 * 
	 * @param request
	 * @return
	 */
	public static UnifiedOrderResponse unifiedOrder(
			UnifiedOrderRequest request) {
		String url = "";
		if (debug) {
			url = sandbox_pay_unifiedorder_url;
		} else {
			url = pay_unifiedorder_url;
		}
		System.out.println(XmlUtils.beanToXml(request));
		String result = HttpUtils.httpsPostRequestString(url,
				XmlUtils.beanToXml(request), ContentType.APPLICATION_XML);
		UnifiedOrderResponse resp = (UnifiedOrderResponse) XmlUtils
				.xmlToBean(result, UnifiedOrderResponse.class);
		return resp;
	}

	/**
	 * 查询订单
	 * 
	 * @param request
	 * @return
	 */
	public static OrderQueryResponse orderQuery(OrderQueryRequest request) {
		String url = "";
		if (debug) {
			url = sandbox_order_query_url;
		} else {
			url = order_query_url;
		}
		String result = HttpUtils.httpsPostRequestString(url,
				XmlUtils.beanToXml(request), ContentType.APPLICATION_XML);
		OrderQueryResponse resp = (OrderQueryResponse) XmlUtils
				.xmlToBean(result, UnifiedOrderResponse.class);
		return resp;
	}

	/**
	 * 关闭订单
	 * 
	 * @param request
	 * @return
	 */
	public static CloseOrderResponse closeOrder(CloseOrderRequest request) {
		String url = "";
		if (debug) {
			url = sandbox_close_order_url;
		} else {
			url = close_order_url;
		}
		String result = HttpUtils.httpsPostRequestString(url,
				XmlUtils.beanToXml(request), ContentType.APPLICATION_XML);
		CloseOrderResponse resp = (CloseOrderResponse) XmlUtils
				.xmlToBean(result, UnifiedOrderResponse.class);
		return resp;
	}

	/**
	 * 下载对账单
	 * 
	 * @param request
	 * @return
	 */
	public static DownbillResponse downbill(DownbillRequest request) {
		String url = "";
		if (debug) {
			url = sandbox_downloadbill_url;
		} else {
			url = downloadbill_url;
		}
		String result = HttpUtils.httpsPostRequestString(url,
				XmlUtils.beanToXml(request), ContentType.APPLICATION_XML);
		DownbillResponse resp = (DownbillResponse) XmlUtils.xmlToBean(result,
				UnifiedOrderResponse.class);
		return resp;
	}

	/**
	 * 转账
	 * 
	 * @param request
	 * @return
	 */
	public static TransferResponse transfer(TransferRequest request) {
		String url = "";
		if (debug) {
			url = sandbox_transfer_url;
		} else {
			url = transfer_url;
		}
		String result = HttpUtils.httpsPostWithCert(url,
				XmlUtils.beanToXml(request), ContentType.APPLICATION_XML, "",
				"");
		TransferResponse resp = (TransferResponse) XmlUtils.xmlToBean(result,
				TransferResponse.class);
		return resp;
	}

	// TODO
	public static String getSignKey() {
		if (false) {
			SignkeyRequest request = new SignkeyRequest();

			request.setMchId(null);
			request.setNonceStr(WxPayUtils.getNonceStr(20));
			request.setSign(WxPayUtils.getSign(request, ""));

			SignkeyResponse response = PayApi.getSignKey(request);
			return response.getSandboxSignkey();
		} else {
			return "";
		}
	}

	public static SignkeyResponse getSignKey(SignkeyRequest request) {
		String result = HttpUtils.httpsPostRequestString(
				sandbox_get_sign_key_url, XmlUtils.beanToXml(request),
				ContentType.APPLICATION_XML);
		SignkeyResponse resp = (SignkeyResponse) XmlUtils.xmlToBean(result,
				SignkeyResponse.class);
		return resp;
	}

	public static void main(String[] args) {
		String xml = "<xml>\n"
				+ "  <appid><![CDATA[wx2421b1c4370ec43b]]></appid>\n"
				+ "  <attach><![CDATA[支付测试]]></attach>\n"
				+ "  <bank_type><![CDATA[CFT]]></bank_type>\n"
				+ "  <fee_type><![CDATA[CNY]]></fee_type>\n"
				+ "  <is_subscribe><![CDATA[Y]]></is_subscribe>\n"
				+ "  <mch_id><![CDATA[10000100]]></mch_id>\n"
				+ "  <nonce_str><![CDATA[5d2b6c2a8db53831f7eda20af46e531c]]></nonce_str>\n"
				+ "  <openid><![CDATA[oUpF8uMEb4qRXf22hE3X68TekukE]]></openid>\n"
				+ "  <out_trade_no><![CDATA[1409811653]]></out_trade_no>\n"
				+ "  <result_code><![CDATA[SUCCESS]]></result_code>\n"
				+ "  <return_code><![CDATA[SUCCESS]]></return_code>\n"
				+ "  <sign><![CDATA[B552ED6B279343CB493C5DD0D78AB241]]></sign>\n"
				+ "  <sub_mch_id><![CDATA[10000100]]></sub_mch_id>\n"
				+ "  <time_end><![CDATA[20140903131540]]></time_end>\n"
				+ "  <total_fee>1</total_fee>\n"
				+ "  <trade_type><![CDATA[JSAPI]]></trade_type>\n"
				+ "  <transaction_id><![CDATA[1004400740201409030005092168]]></transaction_id>\n"
				+ "</xml>";
		String str = HttpUtils.httpPostRequestString(
				"http://caiyida.natapp1.cc/a/mobile/card/card/pay_notify", xml,
				ContentType.APPLICATION_XML);
		System.out.println(str);
	}

}
