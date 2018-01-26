package com.ifudata.dvp.pay.api.terminalorgrelquery.param;

import com.ifudata.dvp.base.vo.BaseInfo;

/**
 * 终端与支付机构关系查询请求参数.<br>
 * Date: 2015年8月20日 <br>
 */
public class TerminalOrgRelQryParam extends BaseInfo {

    private static final long serialVersionUID = 3581445779855006862L;

    /**
     * 终端来源:<br>
     * 1:web<br>
     * 2:wap<br>
     * 3:app<br>
     * 4:微信<br>
     */
    private String requestSource;
    
    public String getRequestSource() {
        return requestSource;
    }

    public void setRequestSource(String requestSource) {
        this.requestSource = requestSource;
    }
    
}
