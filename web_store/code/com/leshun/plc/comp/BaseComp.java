package com.leshun.plc.comp;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.leshun.plc.bean.DataEntity;
import com.leshun.plc.bean.Pagination;
import com.leshun.plc.constant.ExceptionCodeDes;
import com.leshun.plc.dao.BaseDao;
import com.leshun.plc.service.BaseService;
import com.sls.core.socket.ServerDisponseException;

public class BaseComp<T extends DataEntity<T>, D extends BaseDao<T>, S extends BaseService<T, D>> {
	protected Logger log = Logger.getLogger(getClass());
	@Autowired
	protected S service;

	public boolean deleteByPrimaryKey(String id) throws Exception {
		validate(id);
		return service.deleteByPrimaryKey(id);
	}

	//
	// public boolean insert(T entity) throws Exception {
	// validate(entity);
	// return service.insert(entity);
	// }

	public boolean insertSelective(T entity) throws Exception {
		validate(entity);
		return service.insertSelective(entity);
	}

	public T selectByPrimaryKey(String entity) throws Exception {
		validate(entity);
		return service.selectByPrimaryKey(entity);
	}

	public Pagination<T> queryPage(T entity) throws Exception {
		validate(entity);
		return service.queryPage(entity);
	}

	public int queryRowCount(T entity) throws Exception {
		validate(entity);
		return service.queryRowCount(entity);
	}

	public List<T> queryList(T entity) throws Exception {
		validate(entity);
		return service.queryList(entity);
	}

	public boolean updateByPrimaryKeySelective(T entity) throws Exception {
		validate(entity);
		if (StringUtils.isBlank(entity.getId())) {
			throw new ServerDisponseException(
					ExceptionCodeDes.PRIMARY_KEY_LOSE.getCode(),
					ExceptionCodeDes.PRIMARY_KEY_LOSE.getDescription());
		}
		return service.updateByPrimaryKeySelective(entity);
	}

	//
	// public boolean updateByPrimaryKey(T entity) throws Exception {
	// validate(entity);
	// if (StringUtils.isBlank(entity.getId())) {
	// throw new ServerDisponseException(
	// ExceptionCodeDes.PRIMARY_KEY_LOSE.getCode(),
	// ExceptionCodeDes.PRIMARY_KEY_LOSE.getDescription());
	// }
	// return service.updateByPrimaryKey(entity);
	// }

	/** 校验是否为null */
	protected void validate(Object obj) throws Exception {
		if (obj == null) {
			throw new ServerDisponseException(
					ExceptionCodeDes.PARAM_LOSE.getCode(),
					ExceptionCodeDes.PARAM_LOSE.getDescription());
		}
	}

}
