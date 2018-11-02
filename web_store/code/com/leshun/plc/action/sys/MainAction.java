package com.leshun.plc.action.sys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.leshun.plc.action.SuperAction;
import com.leshun.plc.bean.sys.Permission;

public class MainAction extends SuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1570442984220960806L;
	List<Permission> permissionList;

	// 后台Header
	public String header() {
		if (permissionList == null) {
			permissionList = new ArrayList<Permission>();
			Permission per1 = new Permission();
			per1.setCode("1");
			per1.setUrl("/main!menu.htm");
			per1.setName("系统管理");

			Permission per2 = new Permission();
			per2.setUrl("/main!menu.htm");
			per2.setName("支付管理");
			per2.setCode("2");

			Permission per3 = new Permission();
			per3.setUrl("/main!menu.htm");
			per3.setName("商品管理");
			per3.setCode("3");

			Permission per4 = new Permission();
			per4.setUrl("/main!menu.htm");
			per4.setName("话费管理");
			per4.setCode("4");

			permissionList.add(per1);
			permissionList.add(per2);
			permissionList.add(per3);
			permissionList.add(per4);

		}
		if (permissionList != null && permissionList.size() > 1) {
			Collections.sort(permissionList, new Comparator<Permission>() {
				@Override
				public int compare(Permission o1, Permission o2) {
					if (o1.getSort() != null && o2.getSort() != null) {
						int i = o1.getSort() - o2.getSort();
						if (i != 0) {
							return i;
						}
					}
					return Integer.parseInt(o1.getCode())
							- Integer.parseInt(o2.getCode());
				}
			});
		}
		return "header";
	}

	public String main() {
		return "main";
	}
	public String main1() {
		return "main1";
	}
	// 后台左边菜单
	public String menu() {
		return "menu";
	}

	// 后台首页
	public String index() {
		return "index";
	}

	// 后台中间(显示/隐藏菜单)
	public String middle() {
		return "middle";
	}

	public List<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}

}
