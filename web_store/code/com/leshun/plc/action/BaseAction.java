package com.leshun.plc.action;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.CaseFormat;
import com.leshun.plc.bean.DataEntity;
import com.leshun.plc.bean.Pagination;
import com.leshun.plc.bean.sys.UserInfoVO;
import com.leshun.plc.comp.BaseComp;
import com.leshun.plc.constant.Constant;
import com.leshun.plc.dao.BaseDao;
import com.leshun.plc.service.BaseService;
import com.leshun.plc.util.CommonUtil;
import com.leshun.plc.util.UserInfoVOThreadLocal;
import com.opensymphony.xwork2.ActionSupport;
import com.sls.core.socket.ServerDisponseException;

public abstract class BaseAction<T extends DataEntity<T>, D extends BaseDao<T>, S extends BaseService<T, D>, C extends BaseComp<T, D, S>>
		extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8878655577619989047L;
	protected Logger log = Logger.getLogger(getClass());
	public static final String LIST = "list";
	public static final String ERROR_404 = "404";
	public static final String AJAX = "ajax";
	public static final String NOPERMISSION = "nopermission";
	public static final String FORM = "form";
	public static final String DETAIL = "detail";
	protected String redirectionUrl;
	protected boolean flag = true;
	protected String message;
	protected String id;
	protected T entity;
	protected Pagination<T> page;
	protected Type[] params;
	@Autowired
	protected C comp;

	/**
	 * 构造器
	 */
	public BaseAction() {
		super();
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		// 获取泛型通用类
		Type genType = getClass().getGenericSuperclass();
		params = ((ParameterizedType) genType).getActualTypeArguments();
	}

	@SuppressWarnings("unchecked")
	public String list() {
		if (entity == null) {
			try {
				entity = ((Class<T>) params[0]).newInstance();
			} catch (InstantiationException e) {
				log.info("分页查询实例化异常" + e.getMessage());
				addActionError(e.getMessage());
				throw new ServerDisponseException("查询异常",
						"异常信息：" + e.getMessage());
			} catch (IllegalAccessException e) {
				log.info("分页查询异常" + e.getMessage());
				addActionError(e.getMessage());
				throw new ServerDisponseException("查询异常",
						"异常信息：" + e.getMessage());
			}
			entity.setPageSize(Constant.INIT_PAGESIZE);
			entity.setCurrentPage(Constant.INIT_CURRENTPAGE);
		}

		try {
			page = comp.queryPage(entity);
		} catch (Exception e) {
			log.info("" + e.getMessage());
			addActionError(e.getMessage());
			throw new ServerDisponseException("查询异常", "异常信息：" + e.getMessage());
		}
		return LIST;
	}

	public String form() {
		try {
			if (StringUtils.isNotBlank(id)) {
				entity = comp.selectByPrimaryKey(id);
			}
		} catch (Exception e) {
			log.info("查询失败：" + e.getMessage());
			addActionError(e.getMessage());
			throw new ServerDisponseException("查询失败", e.getMessage());
		}
		return FORM;
	}

	@SuppressWarnings("unchecked")
	public String save() {
		boolean result = false;
		try {
			if (entity != null && StringUtils.isBlank(entity.getId())) {
				result = comp.insertSelective(entity);
			} else {
				result = comp.updateByPrimaryKeySelective(entity);
			}
		} catch (Exception e) {
			log.info("保存异常", e);
			result = false;
		}
		if (!result) {
			flag = false;
			addActionError("保存失败");
		}
		String name = ((Class<T>) params[0]).getSimpleName();
		redirectionUrl = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,
				name) + "!list.htm";
		return SUCCESS;
	}

	public String delete() {
		boolean result = false;
		message = "操作失败";
		if (StringUtils.isNotBlank(id)) {
			try {
				result = comp.deleteByPrimaryKey(id);
			} catch (Exception e) {
				log.info("删除异常", e);
				message = message + ":" + e.getMessage();
			}
		}
		if (!result) {
			message = ajaxResp(0, message);
		} else {
			message = ajaxResp(1, "操作成功");
		}
		return AJAX;
	}

	public String detail() {
		try {
			entity = comp.selectByPrimaryKey(id);
		} catch (Exception e) {
			log.info("查询异常", e);
			throw new ServerDisponseException("4101:查询异常", e.getMessage());
		}
		return DETAIL;
	}

	protected HttpServletResponse response;

	protected HttpServletRequest request;

	public UserInfoVO getCurrentUser() {
		return UserInfoVOThreadLocal.get();
	}

	/**
	 * 
	 * @param code
	 *            0失败1成功
	 * @param msg
	 * @return
	 */
	protected String ajaxResp(int code, String msg) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", code + "");
		map.put("msg", msg);
		return CommonUtil.gson().toJson(map);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRedirectionUrl() {
		return redirectionUrl;
	}

	public void setRedirectionUrl(String redirectionUrl) {
		this.redirectionUrl = redirectionUrl;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public Pagination<T> getPage() {
		return page;
	}

	public void setPage(Pagination<T> page) {
		this.page = page;
	}

}
