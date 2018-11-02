package com.leshun.plc.bean.sys;

import java.util.List;

import com.leshun.plc.bean.BaseQuery;

public class RolePermission extends BaseQuery {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String roleId;
	private String roleName;
	private List<Permission> permissions;
	private String account;
	private String permissionCode;

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAccount() {
		return account;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

}
