package com.leshun.plc.bean;

import java.io.Serializable;

/**
 * 
 * @description 分页查询基类
 * @author Wangxuegang
 * @date 2012-9-12
 * 
 */
public class BaseQuery implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5009800739157937111L;
	public final static int NO_ROW_OFFSET = 0;
	public final static int NO_ROW_LIMIT = Integer.MAX_VALUE;
	public final static BaseQuery DEFAULT = new BaseQuery();

	private int offset;
	private int limit;
	private String startTime;
	private String endTime;

	/**
	 * 每页记录数
	 */
	private int pageSize;

	/**
	 * 当前页数
	 */
	private int currentPage;

	public BaseQuery() {
		this.offset = NO_ROW_OFFSET;
		this.limit = NO_ROW_LIMIT;
	}

	public BaseQuery(int offset, int limit) {
		this.offset = offset;
		this.limit = limit;
	}

	public void calculate() {
		if (pageSize > 30) {
			pageSize = 30;
		}
		if (pageSize <= 0) {
			pageSize = 10;
		}
		if (currentPage <= 0) {
			currentPage = 1;
		}
		if (pageSize != 0 && currentPage != 0) {
			this.limit = pageSize;
			this.offset = (currentPage - 1) * pageSize;
		}
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
