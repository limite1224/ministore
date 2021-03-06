package com.leshun.plc.constant;

/**
 * 异常码定义
 * 
 * @author cx
 * 
 */
/**
 * @author Administrator
 * 
 */
public enum ExceptionCodeDes {
	/**
	 * 数据已存在
	 */
	DATA_IS_EXISTS("4013", "数据已存在!"),
	/**
	 * 报文解析出错
	 */
	PARSE_REQUEST_ERROR("4010", "报文解析出错!"),

	/**
	 * 转码异常
	 */
	TRANS_CODE_FAILURE("4011", "转码异常!"),

	/**
	 * 访问数据库失败！
	 */
	ACCESS_DATABASE_ERROR("4012", "访问数据库失败!"),
	/**
	 * 参数缺少
	 */
	PARAM_LOSE("40001", "参数缺少"),
	/**
	 * 主键缺失
	 */
	PRIMARY_KEY_LOSE("40002", "主键ID缺失");

	private String code;
	private String description;

	private ExceptionCodeDes(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
