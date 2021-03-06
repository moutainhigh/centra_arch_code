package com.ifudata.ic.smc.api.policymanage.param;

import java.io.Serializable;

public class PolicyItemConditionModifyInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 元素ID
     */
    private Long elementId;

    /**
     * 匹配方式，>：大于 >=：大于等于 <：小于 <=：小于等于 in ：包含 nin：不包含 =：等于 !=：不等于
     */
    private String matchType;

    /**
     * 匹配方式<br>
     * Date: 2016年3月17日 <br>
     * Copyright (c) 2016 asiainfo.com <br>
     * 
     * @author mayt
     */
    public static final class MatchType {
        private MatchType() {
        }

        /**
         * 大于
         */
        public static final String GREATER_THAN = ">";

        /**
         * 大于等于
         */
        public static final String GREATER_THAN_OR_EQUEL_TO = ">=";

        /**
         * 小于
         */
        public static final String LESS_THAN = "<";

        /**
         * 小于等于
         */
        public static final String LESS_THAN_OR_EQUEL_TO = "<=";

        /**
         * 包含
         */
        public static final String IN = "in";

        /**
         * 不包含
         */
        public static final String NIN = "nin";

        public static final String EQUAL = "=";

        public static final String NOT_EQUAL = "!=";
    }

    /**
     * 匹配值
     */
    private String matchValue;

    public Long getElementId() {
        return elementId;
    }

    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getMatchValue() {
        return matchValue;
    }

    public void setMatchValue(String matchValue) {
        this.matchValue = matchValue;
    }
}
