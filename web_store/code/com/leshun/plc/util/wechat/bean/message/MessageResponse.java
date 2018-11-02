package com.leshun.plc.util.wechat.bean.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by caiyida on 2017/4/10.
 */
public class MessageResponse extends BaseMessageResponse {
    @JsonProperty(value = "invaliduser")
    private String invalidUser;
    @JsonProperty(value="invalidparty")
    private String invalidParty;
    @JsonProperty(value = "invalidtag")
    private String invalidTag;

    public String getInvalidUser() {
        return invalidUser;
    }

    public void setInvalidUser(String invalidUser) {
        this.invalidUser = invalidUser;
    }

    public String getInvalidParty() {
        return invalidParty;
    }

    public void setInvalidParty(String invalidParty) {
        this.invalidParty = invalidParty;
    }

    public String getInvalidTag() {
        return invalidTag;
    }

    public void setInvalidTag(String invalidTag) {
        this.invalidTag = invalidTag;
    }
}
