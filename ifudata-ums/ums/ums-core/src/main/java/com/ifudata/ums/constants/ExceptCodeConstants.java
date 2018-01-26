package com.ifudata.ums.constants;

public class ExceptCodeConstants {
    public static final class Special{
        private Special(){}
        /**
         * 成功
         */
        public static final String SUCCESS = "000000";

        /**
         * 参数为空
         */
        public static final String PARAM_IS_NULL = "888888";

        /**
         * 查询无记录
         */
        public static final String NO_RESULT = "000001";

        /**
         * 参数类型不正确
         */
        public static final String PARAM_TYPE_NOT_RIGHT = "000002";

        /**
         * 参数取值有误
         */
        public static final String PARAM_IS_WRONG = "000004";

        /**
         * 未配置系统参数或未刷新缓存
         */
        public static final String NO_DATA_OR_CACAE_ERROR = "000003";

        /**
         * 未配置系统参数或未刷新缓存
         */
        public static final String ERROR = "444444";

    }
}
