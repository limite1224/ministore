package com.leshun.plc.bean;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.leshun.plc.util.UserInfoVOThreadLocal;

/**
 * 数据Entity类
 * 
 * 
 */
public class DataEntity<T> extends BaseQuery {

	private static final long serialVersionUID = 1L;

	public String id;
	public String remarks; // 备注
	public String createBy; // 创建者
	public Date createTime; // 创建日期
	public String updateBy; // 更新者
	public Date updateTime; // 修改更新日期
	public String delFlag; // 删除标记（0：正常；1：删除；2：审核）
	public String beginDate;
	public String endDate;
	/**
	 * 设置动态字段
	 */
	public Map<Object, Object> dynamicFields = new HashMap<Object, Object>();
	/**
	 * 删除标记（0：正常；1：删除；2：审核；）
	 */
	public static final String DEL_FLAG_NORMAL = "0";
	public static final String DEL_FLAG_DELETE = "1";
	public static final String DEL_FLAG_AUDIT = "2";

	public DataEntity() {
		super();
		this.delFlag = DEL_FLAG_NORMAL;
	}

	/**
	 * 插入之前执行方法，需要手动调用
	 */
	public void preInsert() {
		Date now = new Date();
		String voName = UserInfoVOThreadLocal.get() == null ? "unknown"
				: UserInfoVOThreadLocal.get().getAccount();
		if (StringUtils.isBlank(id))
			this.id = UUID.randomUUID().toString();
		this.createBy = voName;
		this.createTime = now;
		this.updateBy = voName;
		this.updateTime = now;
	}

	/**
	 * 插入之前执行方法，需要手动调用
	 */
	public void preInsertWarn() {
		// TODO
	}

	/**
	 * 更新之前执行方法，需要手动调用
	 */
	public void preUpdate() {
		this.updateBy = UserInfoVOThreadLocal.get() == null ? "unknown"
				: UserInfoVOThreadLocal.get().getAccount();
		this.updateTime = new Date();
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public static String getDelFlagNormal() {
		return DEL_FLAG_NORMAL;
	}

	public static String getDelFlagDelete() {
		return DEL_FLAG_DELETE;
	}

	public static String getDelFlagAudit() {
		return DEL_FLAG_AUDIT;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * 设置动态字段值.
	 *
	 * @param fieldName
	 *            字段名称
	 * @param value
	 *            字段值
	 */
	public void setField(String fieldName, Object value) {
		dynamicFields.put(fieldName, value);
	}

	/**
	 * 返回动态字段值.
	 *
	 * @param fieldName
	 *            字段名称
	 * @return 对象
	 */
	public Object getField(String fieldName) {
		if (dynamicFields == null) {
			return null;
		}
		return getDynamicFields().get(fieldName);
	}

	/*
	 * @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") public Date getBeginDate() {
	 * return beginDate; }
	 * 
	 * public void setBeginDate(Date beginDate) { this.beginDate = beginDate; }
	 * 
	 * @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") public Date getEndDate() {
	 * return endDate; }
	 * 
	 * public void setEndDate(Date endDate) { this.endDate = endDate; }
	 */
	public Map<Object, Object> getDynamicFields() {
		if (dynamicFields != null && dynamicFields.size() > 0) {
			Set<Object> set = dynamicFields.keySet();
			for (Iterator<Object> iterator = set.iterator(); iterator
					.hasNext();) {
				String key = (String) iterator.next();
				if (dynamicFields.get(key) != null
						&& dynamicFields.get(key).getClass().isArray()) {
					Object[] objArr = (Object[]) dynamicFields.get(key);
					if (objArr.length == 1) {
						dynamicFields.put(key,
								((Object[]) dynamicFields.get(key))[0]);
					}
				}
			}
		}
		return dynamicFields;
	}

	public void setDynamicFields(Map<Object, Object> dynamicFields) {
		this.dynamicFields = dynamicFields;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
