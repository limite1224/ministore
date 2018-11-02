package com.leshun.plc.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.leshun.plc.bean.DataEntity;
import com.leshun.plc.bean.Pagination;

public class BaseDao<T extends DataEntity<T>> extends SqlSessionDaoSupport {
	protected Class<T> entityClass;

	protected String getStatement(String methodName) {
		return "mybatis.xml." + entityClass.getSimpleName() + "Mapper."
				+ methodName;
	}

	@SuppressWarnings("unchecked")
	public BaseDao() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class<T>) params[0];
	}

	public int deleteByPrimaryKey(String id) {
		return this.getSqlSession().delete("mybatis.xml."
				+ entityClass.getSimpleName() + "Mapper.deleteByPrimaryKey",
				id);
	}

//	public int insert(T entity) {
//		return this.getSqlSession().insert(
//				"mybatis.xml." + entityClass.getSimpleName() + "Mapper.insert",
//				entity);
//	}

	public int insertSelective(T entity) {
		return this.getSqlSession().insert("mybatis.xml."
				+ entityClass.getSimpleName() + "Mapper.insertSelective",
				entity);
	}

	public T selectByPrimaryKey(String id) {
		return this.getSqlSession().selectOne("mybatis.xml."
				+ entityClass.getSimpleName() + "Mapper.selectByPrimaryKey",
				id);
	}

	public int updateByPrimaryKeySelective(T entity) {
		return this.getSqlSession()
				.update("mybatis.xml." + entityClass.getSimpleName()
						+ "Mapper.updateByPrimaryKeySelective", entity);
	}

	public int updateByPrimaryKeyWithBLOBs(T entity) {
		return this.getSqlSession()
				.update("mybatis.xml." + entityClass.getSimpleName()
						+ "Mapper.updateByPrimaryKeyWithBLOBs", entity);
	}

//	public int updateByPrimaryKey(T entity) {
//		return this.getSqlSession().update("mybatis.xml."
//				+ entityClass.getSimpleName() + "Mapper.updateByPrimaryKey",
//				entity);
//	}

	public List<T> queryList(T entity) {
		return this.getSqlSession().selectList("mybatis.xml."
				+ entityClass.getSimpleName() + "Mapper.queryList", entity);
	}

	public int queryRowCount(T entity) {
		return this.getSqlSession().selectOne("mybatis.xml."
				+ entityClass.getSimpleName() + "Mapper.queryRowCount", entity);
	}

	/**
	 * 分页
	 * 
	 * @param entity
	 * @return
	 */
	public Pagination<T> queryPage(T entity) {
		entity.calculate();
		List<T> list = this.queryList(entity);
		Integer curIndex = entity.getCurrentPage();
		Pagination<T> page = new Pagination<T>(curIndex,
				this.queryRowCount(entity), entity.getPageSize(), list);
		return page;
	}
}
