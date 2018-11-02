package com.leshun.plc.constant;

public class Constant {
	// GoodsOrder 常量
	public static class GoodsOrder {
		public final static String STATUS_FAILED = "0";
		public final static String STATUS_SUCCESS = "1";
		public final static String STATUS_UNDERWAY = "2";

		public final static String NOTIFY_SUCCESS = "SUCCESS";
		public final static String NOTIFY_FAIL = "FAIL";

	}

	// GoodsOrderMession常量
	public static class GoodsOrderMession {
		public final static String STATUS_HANG_UP = "0";
		public final static String STATUS_UNDERWAY = "1";
		public final static String STATUS_PREPAID = "2";
		public final static String STATUS_ACQUIRING = "3";
		public final static String STATUS_WAIT_RECHARGE = "4";// 待补充
	}

	// GoodsRechargeOreder常量
	public static class RechargeOrder {
		public final static String STATUS_FAILED = "0";
		public final static String STATUS_SUCCESS = "1";
		public final static String STATUS_UNDERWAY = "2";
		public final static String ORDER_NOT_EXSIT = "5";
	}

	// TmOrderNotify常量
	public static class TmOrderNotify {
		public final static String NO_NEED_HANDLE = "0";
		public final static String ORIGINAL_ORDER_SUCCESS = "1";
		public final static String OPRDER_PENDING = "2";
		public final static String SYSTEM_OPERATOR = "system";
	}

	public static class SupplementOrderInfo {
		public final static String SUPP_STATUS_0 = "0";// 失败
		public final static String SUPP_STATUS_1 = "1";// 成功
		public final static String SUPP_STATUS_2 = "2";// 补充中
		public final static String SUPP_STATUS_3 = "3";// 待补充
		public final static String SUPP_STATUS_4 = "4";// 挂起
		public final static String SUPP_STATUS_5 = "5";// 第三地方补充

	}

	public static final String MENU1 = "menuLv1";
	public static final String MENU2 = "menuLv2";
	public static final String MENU3 = "menuLv3";

	public static final String COOKIE_NAME_RANDOMCODE = "COOKIE_NAME.fdasfdsafdsafdafdf";
	public static final String COOKIE_NAME_USERINFO = "COOKIE_NAME.COOKIE_NAMEffffffffffffffff";
	public static final int INIT_PAGESIZE = 10;
	public static final int INIT_CURRENTPAGE = 1;
	// cookie的用戶登錄編號SESSION_ID
	public static final String SESSION_ID = "SESSIONID";
	/**
	 * 退款
	 */
	public static String LOCAL_ORDER_STAUS_FAULT = "0";
	public static String LOCAL_ORDER_ISPAY_FAULT = "0";
	public static String LOCAL_ORDER_ISPAY_SUCCESS = "1";
	public static String LOCAL_ORDER_ISPAY_UNDERWAY = "2";
	public static String LOCAL_ORDER_ISPAY_REFUND = "9";

	public static final String MEM_KEY = "web_tmapp";
	public static final String COOKIE_KEY = "login.cookie.key";

	// 天猫工号=tbc
	public static final String USER_NO_TBC = "745804994";
	// 天猫工号==太初
	public static final String USER_NO_TAICHU = "755363296";

	public static final String USER_NO_Flow = "2231782854";

	public final static String SUCCESS = "success";

	public final static String FAIL = "fail";

}
