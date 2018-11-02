package com.leshun.plc.util.wechat.bean;

/**
 * Created by caiyida on 2017/4/8.
 */
public class UserInfo {

    private String userId;
    private String openId;
    private String deviceId;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
