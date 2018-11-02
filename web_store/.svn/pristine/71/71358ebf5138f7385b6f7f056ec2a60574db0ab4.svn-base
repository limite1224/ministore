package com.leshun.plc.util;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 读取properties配置文件
 * 
 * @author cx
 * 
 */
public class PropertiesUtil {

	private static Logger log = Logger.getLogger(PropertiesUtil.class);

	/**
	 * 获取配置文件中key对应的值
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key, String filename) {
		Properties pro = new Properties();
		try {
			pro.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(
					"conf" + File.separator + filename));
		} catch (IOException e) {
			log.error("读取配置文件出现异常", e);
		}
		return pro.getProperty(key);
	}

}
