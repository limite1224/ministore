package com.leshun.plc.util.wechat.api;

import com.alibaba.fastjson.JSON;
import com.leshun.plc.util.wechat.bean.dept.GetDeptListResponse;
import com.leshun.plc.util.wechat.utils.HttpUtils;

/**
 * Created by caiyida on 2017/4/26.
 */
public class DeptAPI {
    private static String get_dept_list = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=ACCESS_TOKEN&id=ID";

    public static GetDeptListResponse getDeptList(String accessToken, String id){
        String url = get_dept_list.replace("ACCESS_TOKEN", accessToken).replace("ID",id);
        String result = HttpUtils.httpsGetRequest(url);
        GetDeptListResponse response = JSON.parseObject(result, GetDeptListResponse.class);
        return response;

    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(DeptAPI.getDeptList("aNs4RBMI3TR7PbR0Nh7H48VoIkQOMUlkZCHoXB3RNUN6w7PHT-7n_MjHZebbCR46","")));
    }
}
