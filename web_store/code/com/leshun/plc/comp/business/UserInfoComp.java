package com.leshun.plc.comp.business;

import org.springframework.stereotype.Component;

import com.leshun.plc.bean.UserInfo;
import com.leshun.plc.comp.BaseComp;
import com.leshun.plc.dao.UserInfoDao;
import com.leshun.plc.service.businss.UserInfoService;

@Component("userInfoComp")
public class UserInfoComp
		extends BaseComp<UserInfo, UserInfoDao, UserInfoService> {

}
