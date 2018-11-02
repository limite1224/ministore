package com.leshun.plc.util.wechat.utils;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import javax.xml.bind.annotation.XmlElement;

import com.leshun.plc.util.wechat.bean.pay.UnifiedOrderRequest;

/**
 * Created by caiyida on 2017/4/7.
 */
public class WxPayUtils {

    /**
     * 产生随机字符串，不长于32位
     *
     * @param length
     * @return 产生的随机字符串
     */
    public static String getNonceStr(int length) {
        Random random = new Random();
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    /**
     * 签名算法
     *
     * @param obj 加密对象
     * @param key 微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置
     * @return 产生的随机字符串
     * @parma key, 设置路径：微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置
     */
    public static String getSign(Object obj, String key) {
        StringBuffer sb = new StringBuffer();

        Map<String, Object> parameters = new TreeMap<String, Object>();

        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (null != field.get(obj)) {
                    //有别名则获取别名
                    if(field.isAnnotationPresent(XmlElement.class)){
                        XmlElement alias = field.getAnnotation(XmlElement.class);
                        parameters.put(alias.name(), field.get(obj));
                    }else{
                        parameters.put(field.getName().replace("_",""), field.get(obj));
                    }

                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Iterator<String> itor = parameters.keySet().iterator();
        while(itor.hasNext()){
            String k = itor.next();
            Object v = parameters.get(k);
            if(null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)){
                sb.append(k + "=" + v + "&");
            }
        }

        sb.append("key=" + key);
        String sign = MD5Utils.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
        return sign;
    }

    public static void main(String[] args) {
        UnifiedOrderRequest request = new UnifiedOrderRequest();
        //微信api提供的参数
        String appid = "wxd930ea5d5a258f4f";
        String mch_id = "10000100";
        String device_info = "1000";
        String body = "test";
        String nonce_str = "ibuaiVcKdpRxkhJA";

        request.setAppid(appid);
        request.setMchId(mch_id);
        request.setDeviceInfo(device_info);
        request.setBody(body);
        request.setNonceStr(nonce_str);

        System.out.println(WxPayUtils.getSign(request,"192006250b4c09247ec02edce69f6a2d"));
    }


}
