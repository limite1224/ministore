package com.leshun.plc.util.wechat.bean.dept;

/**
 * Created by caiyida on 2017/4/26.
 */
public class Dept {

    private String id;
    private String name;
    private String parentid;
    private String order;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
