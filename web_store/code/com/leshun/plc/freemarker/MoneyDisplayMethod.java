package com.leshun.plc.freemarker;

import java.util.List;

import com.sls.core.common.CommonUtil;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

public class MoneyDisplayMethod implements TemplateMethodModel {

	@Override
	public Object exec(@SuppressWarnings("rawtypes") List arguments)
			throws TemplateModelException {
		try {
			String div = null;
			int scale = 0;
			if (arguments != null && arguments.size() >= 2
					&& arguments.get(1) != null) {
				try {
					scale = Integer.parseInt(arguments.get(1).toString());
				} catch (Exception e) {
				}
			}
			if (arguments != null && arguments.get(0) != null) {
				div = arguments.get(0).toString();
				String money = CommonUtil.changeMoney(div, scale);
				if (money != null)
					return money;
			}
		} catch (Exception e) {
		}
		return "";
	}
}