package com.ai.slp.user.api.ucUserSecurity.param;

import com.ai.opt.base.vo.BaseInfo;

public class UcUserPhoneRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 账号ID（必填）
     */
    private String accountId;

    /**
     * 手机号码（必填）
     */
    private String phone;

    /**
     * 更新人ID
     */
    private Long updateAccountId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getUpdateAccountId() {
        return updateAccountId;
    }

    public void setUpdateAccountId(Long updateAccountId) {
        this.updateAccountId = updateAccountId;
    }

}
