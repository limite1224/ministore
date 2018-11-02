package com.leshun.plc.util.wechat.api;

import org.apache.http.entity.ContentType;

import com.alibaba.fastjson.JSON;
import com.leshun.plc.util.wechat.bean.message.Message;
import com.leshun.plc.util.wechat.bean.message.MessageResponse;
import com.leshun.plc.util.wechat.bean.message.TextMessage;
import com.leshun.plc.util.wechat.utils.HttpUtils;

/**
 * Created by caiyida on 2017/4/10.
 */
public class MessageAPI {

    private static String send_message_url = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=ACCESS_TOKEN";

    public static MessageResponse sendMessage(String accessToken, Message message){
        String url = send_message_url.replace("ACCESS_TOKEN",accessToken);
        MessageResponse response = JSON.parseObject(HttpUtils.httpsPostRequestString(url,JSON.toJSONString(message), ContentType.TEXT_PLAIN),MessageResponse.class);
        return response;
    }

	// public static void main(String[] args) {
	// Message message = new
	// TextMessage(Global.getWechatCorpId(),"15257376906","test");
	// String str = JSON.toJSONString(message);
	// MessageResponse response =
	// MessageAPI.sendMessage("nSt-lRFz2l8FqD9QWi473gObzAft4RDp-NQyj0n3Wozh5Kxc9jOgvH-20UogjKiL",message);
	// System.out.println(response.getErrcode());
	// }
}
