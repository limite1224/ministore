package com.leshun.plc.service.businss;

import org.springframework.stereotype.Service;

import com.leshun.plc.bean.UserInfo;
import com.leshun.plc.dao.UserInfoDao;
import com.leshun.plc.service.BaseService;

@Service("userInfoService")
public class UserInfoService extends BaseService<UserInfo, UserInfoDao> {

}
