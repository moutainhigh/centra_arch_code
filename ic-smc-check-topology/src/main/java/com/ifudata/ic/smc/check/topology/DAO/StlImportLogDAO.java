package com.ifudata.ic.smc.check.topology.DAO;

import java.sql.Connection;

import org.apache.commons.lang.StringUtils;

import com.ifudata.dvp.storm.jdbc.JdbcTemplate;
import com.ifudata.ic.smc.check.topology.vo.StlImportLog;

public class StlImportLogDAO {
    public int update(Connection conn, StlImportLog importLog) {
        StringBuilder builder = new StringBuilder();
        builder.append(" update stl_import_log set tenant_id = '").append(importLog.getTenantId())
                .append("'");
        if (importLog.getImportRecords() != null && importLog.getImportRecords() != 0) {
            builder.append(" , import_records = '").append(importLog.getImportRecords())
                    .append("'");
        }
        if (!StringUtils.isBlank(importLog.getRstFileName())) {
            builder.append(" , rst_file_name = '").append(importLog.getRstFileName()).append("'");
        }
        if (!StringUtils.isBlank(importLog.getRstFileUrl())) {
            builder.append(" , rst_file_url = '").append(importLog.getRstFileUrl()).append("'");
        }
        if (!StringUtils.isBlank(importLog.getState())) {
            builder.append(" , state = '").append(importLog.getState()).append("'");
        }
        if (!StringUtils.isBlank(importLog.getStateDesc())) {
            builder.append(" , state_desc = '").append(importLog.getStateDesc()).append("'");
        }
        builder.append(" where tenant_id = '").append(importLog.getTenantId()).append("'");
        if (importLog.getLogId() != null && importLog.getLogId() != 0) {
            builder.append(" and log_id = ").append(importLog.getLogId());
        }

        return JdbcTemplate.update(builder.toString(), conn);
    }
}
