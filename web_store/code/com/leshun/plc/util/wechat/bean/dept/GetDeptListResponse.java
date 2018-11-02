package com.leshun.plc.util.wechat.bean.dept;

import java.util.List;

/**
 * Created by caiyida on 2017/4/26.
 */
public class GetDeptListResponse {

    private String errcode;
    private String errmsg;
    private List<Dept> department;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public List<Dept> getDepartment() {
        return department;
    }

    public void setDepartment(List<Dept> department) {
        this.department = department;
    }
}
