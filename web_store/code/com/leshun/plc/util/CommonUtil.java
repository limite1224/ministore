package com.leshun.plc.util;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CommonUtil {
	/**
	 * gson格式转换，日期采用yyyy-MM-dd HH:mm:ss格式转换
	 * 
	 * @return
	 */
	public static Gson gson() {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
				.create();
		return gson;
	}

	/**
	 * 潜复制，对不同对象的相同属性进行赋值，被改变的是des
	 * 
	 * @param source
	 * @param desObject目标对象
	 */
	public static void simpleValueCopy(Object source, Object desObject) {
		if (source == null || desObject == null)
			return;
		Method[] sourceMethods = source.getClass().getMethods();
		Method[] desMethods = desObject.getClass().getMethods();
		for (Method m : sourceMethods) {
			String methodName = m.getName();
			if (methodName.startsWith("get")) {
				String methodTmp = methodName.replaceFirst("get", "set");
				for (Method desMethod : desMethods) {
					try {
						if (methodTmp.equals(desMethod.getName())) {
							desMethod.invoke(desObject,
									m.invoke(source, new Object[] {}));
						}
					} catch (Exception e) {
					}
				}
			} else if (methodName.startsWith("is")) {
				String methodTmp = methodName.replaceFirst("is", "set");
				for (Method desMethod : desMethods) {
					try {
						if (methodTmp.equals(desMethod.getName())) {
							desMethod.invoke(desObject,
									m.invoke(source, new Object[] {}));
						}
					} catch (Exception e) {
					}
				}
			}
		}
	}

	/**
	 * 产生count位随机数
	 * 
	 * @return
	 */
	public static String createRandomNumber(int count) {

		Random random = new Random();
		StringBuffer sb = new StringBuffer(count);
		for (int i = 0; i < count; i++) {
			sb.append((char) '0' + random.nextInt(10));
		}
		return sb.toString();
	}

	private static final BigDecimal THOUSANDS = new BigDecimal("1000");

	/**
	 * 对金额进行除1000操作，默认精确到小数点两位
	 * 
	 * @param money金额
	 * @param scale精度
	 *            小數點的位數
	 * 
	 * @return
	 */
	public static String changeMoney(String money, int scale) {
		try {
			BigDecimal b = new BigDecimal(money).divide(THOUSANDS);
			if (b.toString().indexOf(".") > 0) {
				if (scale <= 0)
					b = b.setScale(2, BigDecimal.ROUND_HALF_UP);
				else
					b = b.setScale(scale, BigDecimal.ROUND_HALF_UP);
			}
			return b.toString();
		} catch (Exception e) {
		}
		return null;
	}
}
