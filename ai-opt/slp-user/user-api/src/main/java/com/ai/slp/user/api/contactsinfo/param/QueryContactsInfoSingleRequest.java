package com.ai.slp.user.api.contactsinfo.param;

import com.ai.opt.base.vo.BaseInfo;

public class QueryContactsInfoSingleRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String userId;
    
    /**
     * 联系人手机号
     */
    private String contactMp;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContactMp() {
        return contactMp;
    }

    public void setContactMp(String contactMp) {
        this.contactMp = contactMp;
    }
    
    

}
