package com.leshun.plc.util.wechat.bean.pay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by caiyida on 2017/4/13.
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class SignkeyResponse {
    @XmlElement(name="return_code")
    private String returnCode;
    @XmlElement(name="return_msg")
    private String returnMsg;
    @XmlElement(name="mch_id")
    private String mchId;
    @XmlElement(name="sandbox_signkey")
    private String sandboxSignkey;

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

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getSandboxSignkey() {
        return sandboxSignkey;
    }

    public void setSandboxSignkey(String sandboxSignkey) {
        this.sandboxSignkey = sandboxSignkey;
    }
}
