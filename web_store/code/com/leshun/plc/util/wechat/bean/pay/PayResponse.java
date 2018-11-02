package com.leshun.plc.util.wechat.bean.pay;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by caiyida on 2017/4/12.
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class PayResponse {
    @XmlElement(name = "return_code")
    private String returnCode;
    @XmlElement(name = "return_msg")
    private String returnMsg;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }
}
