package com.ifudata.centra.sdk.datasource;

import com.ifudata.centra.sdk.component.ccs.util.ConfigTool;
import com.zaxxer.hikari.HikariDataSource;

public class DvpHikariDataSource extends HikariDataSource {

    public DvpHikariDataSource(String dataSourceName) {
        // 从配置中心获取数据库配置信息，并初始化数据源
//        super(ConfigTool.getDBConf(dataSourceName));
        super(ConfigTool.getDBConfByRest(dataSourceName));
    }

}
