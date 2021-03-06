package com.leshun.plc.freemarker;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.views.freemarker.FreemarkerManager;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

public class CustomFreemarkerManager extends FreemarkerManager {
	private static final Map<String, String> web_map = new HashMap<String, String>();
	public static final Map<String, String> WEB_PROPERTIES_MAP = Collections
			.unmodifiableMap(web_map);

	protected Configuration createConfiguration(ServletContext servletContext)
			throws TemplateException {
		Configuration cfg = super.createConfiguration(servletContext);
		Iterator<Entry<String, String>> sst = web_map.entrySet().iterator();
		while (sst.hasNext()) {
			Entry<String, String> entry = sst.next();
			cfg.setSharedVariable(entry.getKey().toString(), entry.getValue());
		}
		cfg.setSharedVariable("urlCompletion", new CustomFreemarkerMethod());
		return cfg;
	}

	/**
	 * 返回名称，添加web_contextPath
	 * 
	 * @return
	 */
	public static String getCookieName(String tmp) {
		if (tmp != null)
			return getContextPath().replace("/", "") + tmp;
		else
			return null;
	}

	/**
	 * 返回web_contextPath
	 * 
	 * @return
	 */
	public static String getContextPath() {
		return StringUtils.trim(CustomFreemarkerManager.WEB_PROPERTIES_MAP
				.get("web_contextPath"));
	}

	/**
	 * 返回web_domain
	 * 
	 * @return
	 */
	public static String getDomain() {
		return StringUtils.trim(
				CustomFreemarkerManager.WEB_PROPERTIES_MAP.get("web_domain"));
	}

	/**
	 * 返回web_base
	 * 
	 * @return
	 */
	public static String getWebBase() {
		return StringUtils.trim(
				CustomFreemarkerManager.WEB_PROPERTIES_MAP.get("web_base"));
	}

	/**
	 * 返回web_cookie_path
	 * 
	 * @return
	 */
	public static String getCookiePath() {
		String web_cookie_path = CustomFreemarkerManager.WEB_PROPERTIES_MAP
				.get("web_cookie_path");
		if (StringUtils.isBlank(web_cookie_path)) {
			web_cookie_path = "/";
		}
		web_cookie_path = StringUtils.trim(web_cookie_path);
		return web_cookie_path;
	}

	static {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Properties p = readFiles();
			Iterator<Entry<Object, Object>> st = p.entrySet().iterator();
			while (st.hasNext()) {
				Entry<Object, Object> entry = st.next();
				String value = entry.getValue().toString();
				if (value.indexOf("${") < 0) {
					map.put(entry.getKey().toString(),
							entry.getValue().toString());
				}
			}
			Iterator<Entry<Object, Object>> sst = p.entrySet().iterator();
			Pattern pattern = Pattern.compile("[$]\\{\\w*\\_*\\w*\\}",
					Pattern.CASE_INSENSITIVE);
			Pattern sp = Pattern.compile("\\w*\\_*\\w*",
					Pattern.CASE_INSENSITIVE);
			while (sst.hasNext()) {
				Entry<Object, Object> entry = sst.next();
				String value = entry.getValue().toString();
				Matcher matcher = pattern.matcher(value);
				while (matcher.find()) {
					String fst = matcher.group();
					Matcher sm = sp.matcher(fst);
					while (sm.find()) {
						String ts = sm.group();
						if (ts.trim().length() > 0) {
							if (map.get(ts) != null) {
								String replaceString = map.get(ts).toString();
								value = value.replace(fst, replaceString);
							}
						}
					}
				}
				map.put(entry.getKey().toString(), value);
				web_map.putAll(map);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Properties readFiles() throws IOException {
		Properties p = new Properties();
		p.load(CustomFreemarkerManager.class.getClassLoader()
				.getResourceAsStream("web.properties"));
		return p;
	}

}