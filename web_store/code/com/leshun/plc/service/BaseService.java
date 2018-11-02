package com.leshun.plc.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.leshun.plc.bean.DataEntity;
import com.leshun.plc.bean.Pagination;
import com.leshun.plc.constant.ExceptionCodeDes;
import com.leshun.plc.dao.BaseDao;
import com.sls.core.socket.ServerDisponseException;

public abstract class BaseService<T extends DataEntity<T>, D extends BaseDao<T>> {
	protected Logger log = Logger.getLogger(getClass());
	@Autowired
	protected D dao;

	public List<T> queryList(T entity) {
		List<T> list = null;
		try {
			list = dao.queryList(entity);
		} catch (Exception e) {
			log.info("查询列表发生异常!", e);
			throw new ServerDisponseException(
					ExceptionCodeDes.ACCESS_DATABASE_ERROR.getCode(),
					ExceptionCodeDes.ACCESS_DATABASE_ERROR.getDescription());
		}
		return list;
	}

	public Pagination<T> queryPage(T entity) {
		Pagination<T> page = null;
		try {
			page = dao.queryPage(entity);
		} catch (Exception e) {
			log.info("分页查询发生异常!", e);
			throw new ServerDisponseException(
					ExceptionCodeDes.ACCESS_DATABASE_ERROR.getCode(),
					ExceptionCodeDes.ACCESS_DATABASE_ERROR.getDescription());
		}
		return page;
	}

	public int queryRowCount(T entity) {
		int count = 0;
		try {
			count = dao.queryRowCount(entity);
		} catch (Exception e) {
			log.info("分页查询发生异常!", e);
			throw new ServerDisponseException(
					ExceptionCodeDes.ACCESS_DATABASE_ERROR.getCode(),
					ExceptionCodeDes.ACCESS_DATABASE_ERROR.getDescription());
		}
		return count;
	}

	public boolean deleteByPrimaryKey(String id) {
		int i = 0;
		try {
			i = dao.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.info("根据主键单条删除发生异常!", e);
			throw new ServerDisponseException(
					ExceptionCodeDes.ACCESS_DATABASE_ERROR.getCode(),
					ExceptionCodeDes.ACCESS_DATABASE_ERROR.getDescription());
		}
		return i > 0 ? true : false;
	}

	// public boolean insert(T entity) {
	// int i = 0;
	// try {
	// entity.preInsert();
	// i = dao.insert(entity);
	// } catch (Exception e) {
	// log.info("单条插入发生异常!", e);
	// throw new ServerDisponseException(
	// ExceptionCodeDes.ACCESS_DATABASE_ERROR.getCode(),
	// ExceptionCodeDes.ACCESS_DATABASE_ERROR.getDescription());
	// }
	// return i > 0 ? true : false;
	// }

	public boolean insertSelective(T entity) {
		int i = 0;
		try {
			entity.preInsert();
			i = dao.insertSelective(entity);
		} catch (Exception e) {
			log.info("筛选单条插入发生异常!", e);
			throw new ServerDisponseException(
					ExceptionCodeDes.ACCESS_DATABASE_ERROR.getCode(),
					ExceptionCodeDes.ACCESS_DATABASE_ERROR.getDescription());
		}
		return i > 0 ? true : false;
	}

	public T selectByPrimaryKey(String id) {
		T entity = null;
		try {
			entity = dao.selectByPrimaryKey(id);
		} catch (Exception e) {
			log.info("主键查询发生异常!", e);
			throw new ServerDisponseException(
					ExceptionCodeDes.ACCESS_DATABASE_ERROR.getCode(),
					ExceptionCodeDes.ACCESS_DATABASE_ERROR.getDescription());
		}
		return entity;
	}

	public boolean updateByPrimaryKeySelective(T entity) {
		int i = 0;
		try {
			entity.preUpdate();
			i = dao.updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			log.info("筛选单条更新发生异常!", e);
			throw new ServerDisponseException(
					ExceptionCodeDes.ACCESS_DATABASE_ERROR.getCode(),
					ExceptionCodeDes.ACCESS_DATABASE_ERROR.getDescription());
		}
		return i > 0 ? true : false;
	}

	// public boolean updateByPrimaryKey(T entity) {
	// int i = 0;
	// try {
	// entity.preUpdate();
	// i = dao.updateByPrimaryKey(entity);
	// } catch (Exception e) {
	// log.info("单条更新发生异常!", e);
	// throw new ServerDisponseException(
	// ExceptionCodeDes.ACCESS_DATABASE_ERROR.getCode(),
	// ExceptionCodeDes.ACCESS_DATABASE_ERROR.getDescription());
	// }
	// return i > 0 ? true : false;
	// }
}
