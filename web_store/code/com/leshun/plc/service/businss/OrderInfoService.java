package com.leshun.plc.service.businss;

import java.util.List;

import org.springframework.stereotype.Service;

import com.leshun.plc.bean.OrderInfo;
import com.leshun.plc.comp.business.Goods;
import com.leshun.plc.constant.ExceptionCodeDes;
import com.leshun.plc.dao.OrderInfoDao;
import com.leshun.plc.service.BaseService;
import com.sls.core.socket.ServerDisponseException;

@Service("orderInfoService")
public class OrderInfoService extends BaseService<OrderInfo, OrderInfoDao> {

	@Override
	public boolean insertSelective(OrderInfo entity) {
		// 单商品订单，直接插入数据库
		if ("0".equals(entity.getOrderType())) {
			return super.insertSelective(entity);
		} else {
			for (Goods goods : entity.getGoodsList()) {
				entity.setGoodsCount(goods.getGoodsCount());
				entity.setGoodsDiscount(goods.getGoodsDiscount());
				entity.setGoodsName(goods.getGoodsName());
				entity.setGoodsPrice(goods.getGoodsPrice());
				entity.setGoodsRemark(goods.getGoodsRemark());
				boolean result = super.insertSelective(entity);
				if (result) {
					throw new ServerDisponseException("9999", "创建订单失败");
				}
			}
		}
		return true;
	}

	public boolean deleteByOrderId(String orderId) {
		int i = 0;
		try {
			i = dao.deleteByPrimaryKey(orderId);
		} catch (Exception e) {
			log.info("根据订单编号删除发生异常!", e);
			throw new ServerDisponseException(
					ExceptionCodeDes.ACCESS_DATABASE_ERROR.getCode(),
					ExceptionCodeDes.ACCESS_DATABASE_ERROR.getDescription());
		}
		return i > 0 ? true : false;
	}

	public List<OrderInfo> selectByOrderId(String orderId) {
		List<OrderInfo> list = null;
		try {
			list = dao.selectByOrderId(orderId);
		} catch (Exception e) {
			log.info("根据订单编号查询发生异常!", e);
			throw new ServerDisponseException(
					ExceptionCodeDes.ACCESS_DATABASE_ERROR.getCode(),
					ExceptionCodeDes.ACCESS_DATABASE_ERROR.getDescription());
		}
		return list;
	}

	public boolean updateByOrderId(OrderInfo entity) {
		int i = 0;
		try {
			i = dao.updateByOrderId(entity);
		} catch (Exception e) {
			log.info("根据订单编号修改发生异常!", e);
			throw new ServerDisponseException(
					ExceptionCodeDes.ACCESS_DATABASE_ERROR.getCode(),
					ExceptionCodeDes.ACCESS_DATABASE_ERROR.getDescription());
		}
		return i > 0 ? true : false;
	}
}
