package com.leshun.plc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.leshun.plc.bean.OrderInfo;

@Repository("orderInfoDao")
public class OrderInfoDao extends BaseDao<OrderInfo> {
	public int deleteByOrderId(String id) {
		return this.getSqlSession().delete(getStatement("deleteByOrderId"), id);
	}

	public List<OrderInfo> selectByOrderId(String id) {
		return this.getSqlSession().selectList(getStatement("selectByOrderId"),
				id);
	}

	public int updateByOrderId(OrderInfo record) {
		return this.getSqlSession().update(getStatement("updateByOrderId"),
				record);
	}
}