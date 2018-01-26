package com.ai.slp.user.dao.mapper.attach;

import org.apache.commons.lang.StringUtils;

import java.util.Map;


public class UcGroupInfoAttachProvider {

    /**
     * 获取查询企业用户信息
     *
     * @param param
     * @return
     */
    public String queryGroupUserInfo(Map<String, Object> param){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select groupInfo.*,userInfo.user_state,userInfo.user_login_name,userInfo.user_mp,userInfo.user_email,userInfo.email_validate_flag");
        stringBuffer.append(" from uc_group_key_info groupInfo,uc_user userInfo ");
        stringBuffer.append(" where groupInfo.user_id = userInfo.user_id");
        stringBuffer.append(" AND groupInfo.user_id = '"+param.get("userId")+"'");
        stringBuffer.append(" AND groupInfo.tenant_id = '"+param.get("tenantId")+"'");
        
        String auditState = param.containsKey("auditState")?(String) param.get("auditState"):null;
        if (StringUtils.isNotBlank(auditState)){
            stringBuffer.append(" AND groupInfo.audit_state = '"+auditState+"'");
        }

        return stringBuffer.toString();
    }

}
