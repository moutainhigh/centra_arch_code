package com.ifudata.ums.constant;


/**
 * 存放系统所需常量
 * @author guofei
 */
public interface Constant {
    public static final String SEQUENCE_NUM = "SEQUENCE_NUM";
    public static final String RESULT_CODE = "RESULT_CODE";
    public static final String RESULT_CONTENT = "RESULT_CONTENT";
    public static final String REPORT_TIME = "REPORT_TIME";
    public static final String FAIL_DESC = "FAIL_DESC";
    public static final String SUB_SEQ = "SUB_SEQ";
    
    public static final Integer SERVICE_TYPE_UNICOM = 0;
    public static final Integer SERVICE_TYPE_TELICOM = 1;
    public static final Integer SERVICE_TYPE_MOBILE = 2;

    public static final Integer SEND_FLAG_TOSEND = 0;
    public static final Integer SEND_FLAG_SUCCESS = 1;
    public static final Integer SEND_FLAG_FAIL = 2;
    public static final Integer SEND_FLAG_TORESEND = 3;
    //使用socket特有的异步状态 发送submit后等待响应
    public static final Integer SEND_FLAG_SUCCESSANDWAITRESP = 4;
    //考虑锁表或者程序挂掉之后 的处理  每次取 SEND_FLAG_TOSEND SEND_FLAG_TORESEND SEND_FLAG_FAIL状态的记录之后
    //将状态置为等待发送
    public static final Integer SEND_FLAG_WAITSEND = 5;
    
    public static final Integer REC_FLAG_TOREC = 0;
    public static final Integer REC_FLAG_SUCCESS = 1;
    public static final Integer REC_FLAG_FAIL = 2;
    public static final Integer REC_FLAG_TIMEOUT = 3;

    public static final String DATA_BASE_MYSQL = "MySQL";
    public static final String DATA_BASE_ORACLE = "ORACLE";
}
