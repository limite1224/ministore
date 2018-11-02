package com.leshun.plc.util.wechat.bean.message;

/**
 * Created by caiyida on 2017/4/10.
 */
public class TextMessage extends Message {

    private Text text = new Text();

    {
        super.msgtype = "text";
    }

    public TextMessage() {
        super.msgtype = "text";
    }

    public TextMessage(String agentId, String toUser, String content) {
        this.touser = toUser;
        this.agentid = agentId;
        this.text = new Text(content);
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public class Text {
        private String content;//内容

        public Text() {
        }

        public Text(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

}


