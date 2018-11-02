package com.leshun.plc.bean.sys;

import java.io.Serializable;

/**
 * 
 * 
 * @author root
 * 
 */
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
