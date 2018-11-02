package com.leshun.plc.bean.sys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Permission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 408103571990666852L;
	
	private String code;

    private String parentCode;

    private String name;

    private Boolean isMenu;

    private Integer level;
	private Boolean openNewWindow;
    private Integer sort;

    private String url;

    private String updateAccount;

    private Date updateDate;

    private Boolean deleted;
    
	private List<Permission> list;
	/**
	 * 是否当前角色拥有的权限
	 */
	private Boolean opt;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(Boolean isMenu) {
		this.isMenu = isMenu;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUpdateAccount() {
		return updateAccount;
	}

	public Boolean getOpenNewWindow() {
		return openNewWindow;
	}

	public void setOpenNewWindow(Boolean openNewWindow) {
		this.openNewWindow = openNewWindow;
	}

	public void setUpdateAccount(String updateAccount) {
		this.updateAccount = updateAccount;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public List<Permission> getList() {
		return list;
	}

	public void setList(List<Permission> list) {
		this.list = list;
	}

	public Boolean getOpt() {
		return opt;
	}

	public void setOpt(Boolean opt) {
		this.opt = opt;
	}
	
}
