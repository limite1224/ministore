package com.leshun.plc.util.wechat.bean.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by caiyida on 2017/4/10.
 */
public class BaseMessageResponse {

    @JsonProperty(value = "errcode")
    private String errcode;
    @JsonProperty(value = "errmsg")
    private String errmsg;

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

}
