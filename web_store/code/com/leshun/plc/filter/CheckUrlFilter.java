package com.leshun.plc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class CheckUrlFilter implements Filter {
	public void destroy() {

	}

	private static Logger log = Logger.getLogger(CheckUrlFilter.class);

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if (StringUtils.isNotBlank(req.getRequestURI())
				&& req.getRequestURI().indexOf(".jsp") == -1) {
			chain.doFilter(request, response);
			return;
		}
		log.info("JSP请求" + req.getRequestURI());
		res.sendRedirect(req.getContextPath());
		return;
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
