package com.ai.slp.user.dao.mapper.attach;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.ai.slp.user.api.keyinfo.param.SearchGroupUserInfoResponse;
import com.ai.slp.user.api.keyinfo.param.UcGroupKeyInfoVo;


/**
 * 企业信息扩展
 * 
 * 
 */
public interface UcGroupKeyInfoAttrAttachMapper {
    /**
     * 获取企业和用户信息
     *
     * @param tenantId 租户id
     * @param userId 用户id
     * @param auditState 审核状态
     * @return
     */
    @SelectProvider(type=UcGroupInfoAttachProvider.class,method="queryGroupUserInfo")
    @Results({@Result(id = true,property = "userId",column = "user_id",javaType = String.class),
            @Result(property="tenantId",column="tenant_id",javaType=String.class,jdbcType= JdbcType.VARCHAR),
            @Result(property ="userType",column = "user_type",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="certNum",column = "cert_num",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="custName",column = "cust_name",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="provinceCode",column = "province_code",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="cityCode",column = "city_code",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="countyCode",column = "county_code",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="certAddr",column = "cert_addr",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="certIssueDate",column = "cert_issue_date",javaType = Timestamp.class,jdbcType = JdbcType.TIMESTAMP),
            @Result(property ="registeredCapitals",column = "registered_capitals",javaType = Long.class,jdbcType = JdbcType.NUMERIC),
            @Result(property ="certValidDate",column = "cert_valid_Date",javaType = Timestamp.class,jdbcType = JdbcType.TIMESTAMP),
            @Result(property ="certInvalidDate",column = "cert_invalid_date",javaType = Timestamp.class,jdbcType = JdbcType.TIMESTAMP),
            @Result(property ="webFlag",column = "web_flag",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="groupWebsite",column = "group_website",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="groupMemberScale",column = "group_member_scale",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="groupType",column = "group_type",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="groupIndustry",column = "group_industry",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="groupBusinessScope",column = "group_business_scope",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="groupProduct",column = "group_product",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="legalPerson",column = "legal_person",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="legalCertNum",column = "legal_cert_num",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="orgCode",column = "org_code",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="taxpayerCode",column = "taxpayer_code",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="taxpayerType",column = "taxpayer_type",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="taxpayerTypeCode",column = "taxpayer_type_code",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="groupInfo",column = "group_info",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="createTime",column = "create_time",javaType = Timestamp.class,jdbcType = JdbcType.TIMESTAMP),
            @Result(property ="createChlId",column = "create_chl_id",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="createOperId",column = "create_oper_id",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="updateTime",column = "update_time",javaType = Timestamp.class,jdbcType = JdbcType.TIMESTAMP),
            @Result(property ="updateChlId",column = "update_chl_id",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="updateOperId",column = "update_oper_id",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="contractCustId",column = "contract_cust_id",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="auditState",column = "audit_state",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="userLoginName",column = "user_login_name",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="userState",column = "user_state",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="userMp",column = "user_mp",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="userEmail",column = "user_email",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="emailValidateFlag",column = "email_validate_flag",javaType = String.class,jdbcType = JdbcType.VARCHAR)
    })
    SearchGroupUserInfoResponse selectGroupUserInfo(@Param("tenantId")String tenantId,@Param("userId")String userId,@Param("auditState")String auditState);


    
    /**
     * 获取企业和用户信息分页显示
     *
     * @param tenantId 租户id
     * @param userId 用户id
     * @param auditState 审核状态
     * @return
     */
    @Results({@Result(id = true,property = "userId",column = "user_id",javaType = String.class),
            @Result(property="tenantId",column="tenant_id",javaType=String.class,jdbcType= JdbcType.VARCHAR),
            @Result(property ="userType",column = "user_type",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="certNum",column = "cert_num",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="custName",column = "cust_name",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="provinceCode",column = "province_code",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="cityCode",column = "city_code",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="countyCode",column = "county_code",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="certAddr",column = "cert_addr",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="certIssueDate",column = "cert_issue_date",javaType = Timestamp.class,jdbcType = JdbcType.TIMESTAMP),
            @Result(property ="registeredCapitals",column = "registered_capitals",javaType = Long.class,jdbcType = JdbcType.NUMERIC),
            @Result(property ="certValidDate",column = "cert_valid_Date",javaType = Timestamp.class,jdbcType = JdbcType.TIMESTAMP),
            @Result(property ="certInvalidDate",column = "cert_invalid_date",javaType = Timestamp.class,jdbcType = JdbcType.TIMESTAMP),
            @Result(property ="webFlag",column = "web_flag",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="groupWebsite",column = "group_website",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="groupMemberScale",column = "group_member_scale",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="groupType",column = "group_type",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="groupIndustry",column = "group_industry",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="groupBusinessScope",column = "group_business_scope",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="groupProduct",column = "group_product",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="legalPerson",column = "legal_person",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="legalCertNum",column = "legal_cert_num",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="orgCode",column = "org_code",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="taxpayerCode",column = "taxpayer_code",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="taxpayerType",column = "taxpayer_type",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="taxpayerTypeCode",column = "taxpayer_type_code",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="groupInfo",column = "group_info",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="createTime",column = "create_time",javaType = Timestamp.class,jdbcType = JdbcType.TIMESTAMP),
            @Result(property ="createChlId",column = "create_chl_id",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="createOperId",column = "create_oper_id",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="updateTime",column = "update_time",javaType = Timestamp.class,jdbcType = JdbcType.TIMESTAMP),
            @Result(property ="updateChlId",column = "update_chl_id",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="updateOperId",column = "update_oper_id",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="contractCustId",column = "contract_cust_id",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="auditState",column = "audit_state",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="userLoginName",column = "user_login_name",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="userState",column = "user_state",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="userMp",column = "user_mp",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="userEmail",column = "user_email",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(property ="emailValidateFlag",column = "email_validate_flag",javaType = String.class,jdbcType = JdbcType.VARCHAR)
    })
    
    @Select("select groupInfo.*,userInfo.user_state,userInfo.user_login_name,userInfo.user_mp,userInfo.user_email,userInfo.email_validate_flag " +
            "from uc_group_key_info groupInfo,uc_user userInfo where groupInfo.user_id = userInfo.user_id and groupInfo.cust_name like #{custName} and  groupInfo.tenant_id=#{tenantId} and groupInfo.user_type=#{userType} and groupInfo.audit_state=11  limit #{startPage},#{endPage}")
    List<UcGroupKeyInfoVo> selectGroupKeyInfo(@Param("tenantId")String tenantId,@Param("custName")String custName,@Param("userType")String userType,@Param("auditState")String auditState,@Param("startPage")int startPage,@Param("endPage")int endPage);
    
    @Select("select count(groupInfo.user_id) from uc_group_key_info groupInfo,uc_user userInfo  " +
            " where groupInfo.user_id = userInfo.user_id and groupInfo.cust_name like #{custName} and  groupInfo.tenant_id=#{tenantId} and groupInfo.user_type=#{userType} and groupInfo.audit_state=11")
    int selectCountGroupKeyInfo(@Param("tenantId")String tenantId,@Param("custName")String custName,@Param("userType")String userType,@Param("auditState")String auditState);
}
