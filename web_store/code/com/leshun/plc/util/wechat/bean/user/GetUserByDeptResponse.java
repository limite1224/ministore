package com.leshun.plc.util.wechat.bean.user;


import java.util.List;

/**
 * Created by caiyida on 2017/4/25.
 */
public class GetUserByDeptResponse {

    private String errcode;
    private String errmsg;
    private List<User> userlist;



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

    public List<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<User> userlist) {
        this.userlist = userlist;
    }
}
