package com.leshun.plc.freemarker;

import java.util.List;
import java.util.regex.Pattern;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

public class CustomFreemarkerMethod implements TemplateMethodModel {
	@Override
	public Object exec(@SuppressWarnings("rawtypes") List arguments)
			throws TemplateModelException {
		if (arguments == null || arguments.size() <= 0)
			throw new TemplateModelException("参数不能为空");
		String http = CustomFreemarkerManager.getWebBase();
		String url = null;
		if (arguments.get(0) != null)
			url = arguments.get(0).toString();
		String httpTip = null;
		if (arguments.size() >= 2)
			httpTip = arguments.get(1).toString();
		if (url != null) {
			url = dispose(url);
			if (url != null && !url.startsWith("http://")
					&& !url.startsWith("https://")) {
				if (httpTip != null && httpTip.trim().length() > 0) {
					url = httpTip + url;
				} else
					url = http + url;
			}
		}
		return url;
	}

	/**
	 * 过滤提交的url参数
	 * 
	 * @param url
	 * @return
	 */
	public static String dispose(String url) {
		String contextPath = CustomFreemarkerManager.getContextPath();
		String http = CustomFreemarkerManager.getWebBase();
		if (url != null && url.trim().length() > 0) {
			// 过滤当前系统的url，其他的全部忽略过滤
			if (http != null && url.startsWith(http)) {
				url = url.replace(http, "");
			}
			if (contextPath != null && url.startsWith(contextPath)) {
				url = url.replace(contextPath, "");
			}
			if (!url.startsWith("http") && url.trim().length() > 0
					&& !url.startsWith("/")) {
				// 不是/开头的url加上/
				url = "/" + url;
			}
			String tip = null;
			if (url.startsWith("http://")) {
				tip = "http://";
				url = url.replace(tip, "");
			} else if (url.startsWith("https://")) {
				tip = "https://";
				url = url.replace(tip, "");
			}
			url = Pattern.compile("[/]+").matcher(url).replaceAll("/");
			if (tip != null)
				url = tip + url;
		}
		return url;
	}

	public static void main(String[] args) {
		System.err
				.println(dispose("http://192.168.1.110:8090/web_shop/admin/index.htm"));
	}
}