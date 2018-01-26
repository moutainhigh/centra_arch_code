package com.ai.slp.route.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class DBUtils {

    private DataSource dataSourceTmp;

    private static DataSource dataSource;

    private static Logger logger = LogManager.getLogger(DBUtils.class);


    @PostConstruct
    private void initDataSource() {
        dataSource = dataSourceTmp;
    }


    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            logger.error("Failed to get connection", e);
            throw new RuntimeException("Cannot get connection.");
        }

    }

    public DataSource getDataSourceTmp() {
        return dataSourceTmp;
    }

    public void setDataSourceTmp(DataSource dataSourceTmp) {
        this.dataSourceTmp = dataSourceTmp;
    }
}
