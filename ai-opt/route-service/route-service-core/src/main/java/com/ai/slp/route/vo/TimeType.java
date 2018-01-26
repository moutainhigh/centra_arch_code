package com.ai.slp.route.vo;

/**
 * 路由规则时间类型
 * Created by xin on 16-4-27.
 */
public enum TimeType {
    //周期性,自定义
    CYCLE, SELF_DEFINED;


    public static TimeType convert(String time_type) {
        char value = time_type.charAt(0);
        switch (value) {
            case 'C':
                return CYCLE;
            case 'U':
                return SELF_DEFINED;
            default: {
                throw new RuntimeException("Can not find timeType[" + time_type + "]");
            }
        }
    }
}
