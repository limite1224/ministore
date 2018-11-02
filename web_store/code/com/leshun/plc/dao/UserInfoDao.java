package com.leshun.plc.dao;

import org.springframework.stereotype.Repository;

import com.leshun.plc.bean.UserInfo;

@Repository("userInfoDao")
public class UserInfoDao extends BaseDao<UserInfo> {

}