package com.leshun.plc.util.wechat.bean.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by caiyida on 2017/4/25.
 */
public class User {
    private String errcode;
    private String errmsg;
    @JSONField(name = "userid")
    @JsonProperty(value = "userid")
    private String userid;//必填，成员UserID
    @JSONField(name="name")
    @JsonProperty(value = "name")
    private String name;//必填，成员名称
    @JSONField(name="department")
    @JsonProperty(value = "department")
    private String[] department;//必填，成员所属部门id列表
    @JSONField(name = "position")
    @JsonProperty(value="position")
    private String position;//非必填，职位信息，[1, 2]
    @JSONField(name = "mobile")
    @JsonProperty(value = "mobile")
    private String mobile;//非必填，手机号,mobile/weixinid/email三者不能同时为空
    @JSONField(name="gender")
    @JsonProperty(value = "gender")
    private String gender;//非必填，性别，1表示男性，2表示女性
    @JSONField(name = "email")
    @JsonProperty(value = "email")
    private String email;//非必填，邮箱
    @JSONField(name = "weixinid")
    @JsonProperty(value = "weixinid")
    private String weixinid;//非必填,微信号
    @JSONField(name="avatar")
    @JsonProperty(value = "avatar")
    private String avatar;//非必填，成员头像的mediaid
    @JSONField(name = "extattr")
    @JsonProperty(value = "extattr")
    private String extAttr;//非必填，扩展属性

    @JSONField(name="avatar_mediaid")
    @JsonProperty(value = "avatar_mediaid")
    private String avatarMediaid;//非必填，成员头像的mediaid


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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getDepartment() {
        return department;
    }

    public void setDepartment(String[] department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeixinid() {
        return weixinid;
    }

    public void setWeixinid(String weixinid) {
        this.weixinid = weixinid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getExtAttr() {
        return extAttr;
    }

    public void setExtAttr(String extAttr) {
        this.extAttr = extAttr;
    }

    public String getAvatarMediaid() {
        return avatarMediaid;
    }

    public void setAvatarMediaid(String avatarMediaid) {
        this.avatarMediaid = avatarMediaid;
    }
}
