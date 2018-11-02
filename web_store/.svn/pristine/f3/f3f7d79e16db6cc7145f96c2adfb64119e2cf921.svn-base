package com.leshun.plc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pagination<T> implements Serializable {

	private static final long serialVersionUID = -6579435031214235862L;

	private int rowCount;// 总记录数
	private int pageSize;// 每页记录数
	private int pageCount;// 总页数
	private int currentPage;// 当前页数
	private boolean next;// 是否能下一页
	private boolean previous;// 是否能上一页
	private List<T> list = new ArrayList<T>();

	public Pagination() {

	}

	public Pagination(Integer currentPage, int rowCount, int pageSize) {
		if (currentPage == null) {
			this.currentPage = 1;
		} else {
			this.currentPage = currentPage;
		}
		this.rowCount = rowCount;
		if (pageSize > 0) {
			this.pageSize = pageSize;
		}
		// 计算总页数
		this.pageCount = (int) Math
				.ceil(this.rowCount / (double) this.pageSize);
		// 计算是否能上一页和下一页
		this.next = this.currentPage < this.pageCount;
		this.previous = this.currentPage > 1;

	}

	public Pagination(Integer currentPage, int rowCount, int pageSize,
			List<T> list) {
		this(currentPage, rowCount, pageSize);
		this.list = list;
	}

	public Pagination<T> pagination() {
		if (currentPage == 0) {
			this.currentPage = 1;
		}
		// 计算总页数
		this.pageCount = (int) Math
				.ceil(this.rowCount / (double) this.pageSize);
		// 计算是否能上一页和下一页
		this.next = this.currentPage < this.pageCount;
		this.previous = this.currentPage > 1;
		return this;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isNext() {
		return next;
	}

	public boolean isPrevious() {
		return previous;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
