package com.ai.slp.balance.constants;

/**
 * Balance异常编码定义 Date: 2015年7月22日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public final class ExceptCodeConstants {
    private ExceptCodeConstants() {
    }

    public static final class Special {
        private Special() {

        }
        /**
         * 成功
         */
        public static final String SYSTEM_SUCCESS = "000000";
        /**
         * 系统级异常
         */
        public static final String SYSTEM_ERROR = "999999";

        /**
         * 请求参数为空
         */
        public static final String PARAM_IS_NULL = "888888";

        /**
         * 查找记录不存在
         */
        public static final String NO_RESULT = "000001";

        /**
         * 参数类型不正确
         */
        public static final String PARAM_TYPE_NOT_RIGHT = "000002";
        
        /**
         * 参数不合法
         */
        public static final String PARAM_NOT_VALID = "000003";

        /**
         * 
         */
        public static final String NO_DATA_OR_CACAE_ERROR = "000003";
    }

    public static final class Account {
        private Account() {
        }
        
        // 账户设置资料验证失败
        public static final String ACCOUNT_NOT_FOUND = "100001";

        // 账户设置资料验证失败
        public static final String ACCOUNT_SET_INFO_CHECK_FAILED = "100001";

    }
    
    public static final class Subject{
        private Subject(){
        }
        public static final String SUBJECT_NOT_FOUND = "200001";
        public static final String SUBJECT_NOT_VALID = "200002";
    }
    
    public static final class FunBook{
        private FunBook(){
        }
        public static final String BOOK_NOT_FOUND = "300001";
        public static final String BALANCE_NOT_ENOUGH = "300002";
        public static final String VERSION_EXPORE = "300003";
    }

}
