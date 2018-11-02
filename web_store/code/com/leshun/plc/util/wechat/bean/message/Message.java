package com.leshun.plc.util.wechat.bean.message;

/**
 * Created by caiyida on 2017/4/10.
 */
public class Message {

    protected String touser;//成员ID列表,openid,多个接收者用‘|’分隔,指定为@all，向关注该企业应用的全部成员发送
    protected String toparty;//部门ID列表,touser为@all时忽略本参数
    protected String totag;//标签ID列表,touser为@all时忽略本参数
    protected String msgtype;//消息类型，此时固定为：text
    protected String agentid;//企业应用的id，整型
    protected String safe = "0";//是否是保密消息，0表示否，1表示是，默认0

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getToparty() {
        return toparty;
    }

    public void setToparty(String toparty) {
        this.toparty = toparty;
    }

    public String getTotag() {
        return totag;
    }

    public void setTotag(String totag) {
        this.totag = totag;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public String getSafe() {
        return safe;
    }

    public void setSafe(String safe) {
        this.safe = safe;
    }
}
