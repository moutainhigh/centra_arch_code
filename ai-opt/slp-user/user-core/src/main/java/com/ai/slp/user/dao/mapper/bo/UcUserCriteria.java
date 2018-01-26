package com.ai.slp.user.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UcUserCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public UcUserCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("TENANT_ID is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("TENANT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("TENANT_ID =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("TENANT_ID <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("TENANT_ID >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("TENANT_ID >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("TENANT_ID <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("TENANT_ID <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("TENANT_ID like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("TENANT_ID not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("TENANT_ID in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("TENANT_ID not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("TENANT_ID between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("TENANT_ID not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("USER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("USER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("USER_TYPE =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("USER_TYPE <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("USER_TYPE >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("USER_TYPE >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("USER_TYPE <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("USER_TYPE <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("USER_TYPE like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("USER_TYPE not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("USER_TYPE in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("USER_TYPE not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("USER_TYPE between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("USER_TYPE not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserFlagIsNull() {
            addCriterion("USER_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andUserFlagIsNotNull() {
            addCriterion("USER_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andUserFlagEqualTo(String value) {
            addCriterion("USER_FLAG =", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagNotEqualTo(String value) {
            addCriterion("USER_FLAG <>", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagGreaterThan(String value) {
            addCriterion("USER_FLAG >", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagGreaterThanOrEqualTo(String value) {
            addCriterion("USER_FLAG >=", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagLessThan(String value) {
            addCriterion("USER_FLAG <", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagLessThanOrEqualTo(String value) {
            addCriterion("USER_FLAG <=", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagLike(String value) {
            addCriterion("USER_FLAG like", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagNotLike(String value) {
            addCriterion("USER_FLAG not like", value, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagIn(List<String> values) {
            addCriterion("USER_FLAG in", values, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagNotIn(List<String> values) {
            addCriterion("USER_FLAG not in", values, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagBetween(String value1, String value2) {
            addCriterion("USER_FLAG between", value1, value2, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserFlagNotBetween(String value1, String value2) {
            addCriterion("USER_FLAG not between", value1, value2, "userFlag");
            return (Criteria) this;
        }

        public Criteria andUserStateIsNull() {
            addCriterion("USER_STATE is null");
            return (Criteria) this;
        }

        public Criteria andUserStateIsNotNull() {
            addCriterion("USER_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andUserStateEqualTo(String value) {
            addCriterion("USER_STATE =", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotEqualTo(String value) {
            addCriterion("USER_STATE <>", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateGreaterThan(String value) {
            addCriterion("USER_STATE >", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateGreaterThanOrEqualTo(String value) {
            addCriterion("USER_STATE >=", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateLessThan(String value) {
            addCriterion("USER_STATE <", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateLessThanOrEqualTo(String value) {
            addCriterion("USER_STATE <=", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateLike(String value) {
            addCriterion("USER_STATE like", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotLike(String value) {
            addCriterion("USER_STATE not like", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateIn(List<String> values) {
            addCriterion("USER_STATE in", values, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotIn(List<String> values) {
            addCriterion("USER_STATE not in", values, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateBetween(String value1, String value2) {
            addCriterion("USER_STATE between", value1, value2, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotBetween(String value1, String value2) {
            addCriterion("USER_STATE not between", value1, value2, "userState");
            return (Criteria) this;
        }

        public Criteria andVipLevelIsNull() {
            addCriterion("VIP_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andVipLevelIsNotNull() {
            addCriterion("VIP_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andVipLevelEqualTo(String value) {
            addCriterion("VIP_LEVEL =", value, "vipLevel");
            return (Criteria) this;
        }

        public Criteria andVipLevelNotEqualTo(String value) {
            addCriterion("VIP_LEVEL <>", value, "vipLevel");
            return (Criteria) this;
        }

        public Criteria andVipLevelGreaterThan(String value) {
            addCriterion("VIP_LEVEL >", value, "vipLevel");
            return (Criteria) this;
        }

        public Criteria andVipLevelGreaterThanOrEqualTo(String value) {
            addCriterion("VIP_LEVEL >=", value, "vipLevel");
            return (Criteria) this;
        }

        public Criteria andVipLevelLessThan(String value) {
            addCriterion("VIP_LEVEL <", value, "vipLevel");
            return (Criteria) this;
        }

        public Criteria andVipLevelLessThanOrEqualTo(String value) {
            addCriterion("VIP_LEVEL <=", value, "vipLevel");
            return (Criteria) this;
        }

        public Criteria andVipLevelLike(String value) {
            addCriterion("VIP_LEVEL like", value, "vipLevel");
            return (Criteria) this;
        }

        public Criteria andVipLevelNotLike(String value) {
            addCriterion("VIP_LEVEL not like", value, "vipLevel");
            return (Criteria) this;
        }

        public Criteria andVipLevelIn(List<String> values) {
            addCriterion("VIP_LEVEL in", values, "vipLevel");
            return (Criteria) this;
        }

        public Criteria andVipLevelNotIn(List<String> values) {
            addCriterion("VIP_LEVEL not in", values, "vipLevel");
            return (Criteria) this;
        }

        public Criteria andVipLevelBetween(String value1, String value2) {
            addCriterion("VIP_LEVEL between", value1, value2, "vipLevel");
            return (Criteria) this;
        }

        public Criteria andVipLevelNotBetween(String value1, String value2) {
            addCriterion("VIP_LEVEL not between", value1, value2, "vipLevel");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelIsNull() {
            addCriterion("SAFETY_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelIsNotNull() {
            addCriterion("SAFETY_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelEqualTo(String value) {
            addCriterion("SAFETY_LEVEL =", value, "safetyLevel");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelNotEqualTo(String value) {
            addCriterion("SAFETY_LEVEL <>", value, "safetyLevel");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelGreaterThan(String value) {
            addCriterion("SAFETY_LEVEL >", value, "safetyLevel");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelGreaterThanOrEqualTo(String value) {
            addCriterion("SAFETY_LEVEL >=", value, "safetyLevel");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelLessThan(String value) {
            addCriterion("SAFETY_LEVEL <", value, "safetyLevel");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelLessThanOrEqualTo(String value) {
            addCriterion("SAFETY_LEVEL <=", value, "safetyLevel");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelLike(String value) {
            addCriterion("SAFETY_LEVEL like", value, "safetyLevel");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelNotLike(String value) {
            addCriterion("SAFETY_LEVEL not like", value, "safetyLevel");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelIn(List<String> values) {
            addCriterion("SAFETY_LEVEL in", values, "safetyLevel");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelNotIn(List<String> values) {
            addCriterion("SAFETY_LEVEL not in", values, "safetyLevel");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelBetween(String value1, String value2) {
            addCriterion("SAFETY_LEVEL between", value1, value2, "safetyLevel");
            return (Criteria) this;
        }

        public Criteria andSafetyLevelNotBetween(String value1, String value2) {
            addCriterion("SAFETY_LEVEL not between", value1, value2, "safetyLevel");
            return (Criteria) this;
        }

        public Criteria andUserLoginNameIsNull() {
            addCriterion("USER_LOGIN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserLoginNameIsNotNull() {
            addCriterion("USER_LOGIN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserLoginNameEqualTo(String value) {
            addCriterion("USER_LOGIN_NAME =", value, "userLoginName");
            return (Criteria) this;
        }

        public Criteria andUserLoginNameNotEqualTo(String value) {
            addCriterion("USER_LOGIN_NAME <>", value, "userLoginName");
            return (Criteria) this;
        }

        public Criteria andUserLoginNameGreaterThan(String value) {
            addCriterion("USER_LOGIN_NAME >", value, "userLoginName");
            return (Criteria) this;
        }

        public Criteria andUserLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_LOGIN_NAME >=", value, "userLoginName");
            return (Criteria) this;
        }

        public Criteria andUserLoginNameLessThan(String value) {
            addCriterion("USER_LOGIN_NAME <", value, "userLoginName");
            return (Criteria) this;
        }

        public Criteria andUserLoginNameLessThanOrEqualTo(String value) {
            addCriterion("USER_LOGIN_NAME <=", value, "userLoginName");
            return (Criteria) this;
        }

        public Criteria andUserLoginNameLike(String value) {
            addCriterion("USER_LOGIN_NAME like", value, "userLoginName");
            return (Criteria) this;
        }

        public Criteria andUserLoginNameNotLike(String value) {
            addCriterion("USER_LOGIN_NAME not like", value, "userLoginName");
            return (Criteria) this;
        }

        public Criteria andUserLoginNameIn(List<String> values) {
            addCriterion("USER_LOGIN_NAME in", values, "userLoginName");
            return (Criteria) this;
        }

        public Criteria andUserLoginNameNotIn(List<String> values) {
            addCriterion("USER_LOGIN_NAME not in", values, "userLoginName");
            return (Criteria) this;
        }

        public Criteria andUserLoginNameBetween(String value1, String value2) {
            addCriterion("USER_LOGIN_NAME between", value1, value2, "userLoginName");
            return (Criteria) this;
        }

        public Criteria andUserLoginNameNotBetween(String value1, String value2) {
            addCriterion("USER_LOGIN_NAME not between", value1, value2, "userLoginName");
            return (Criteria) this;
        }

        public Criteria andUserLoginPwdIsNull() {
            addCriterion("USER_LOGIN_PWD is null");
            return (Criteria) this;
        }

        public Criteria andUserLoginPwdIsNotNull() {
            addCriterion("USER_LOGIN_PWD is not null");
            return (Criteria) this;
        }

        public Criteria andUserLoginPwdEqualTo(String value) {
            addCriterion("USER_LOGIN_PWD =", value, "userLoginPwd");
            return (Criteria) this;
        }

        public Criteria andUserLoginPwdNotEqualTo(String value) {
            addCriterion("USER_LOGIN_PWD <>", value, "userLoginPwd");
            return (Criteria) this;
        }

        public Criteria andUserLoginPwdGreaterThan(String value) {
            addCriterion("USER_LOGIN_PWD >", value, "userLoginPwd");
            return (Criteria) this;
        }

        public Criteria andUserLoginPwdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_LOGIN_PWD >=", value, "userLoginPwd");
            return (Criteria) this;
        }

        public Criteria andUserLoginPwdLessThan(String value) {
            addCriterion("USER_LOGIN_PWD <", value, "userLoginPwd");
            return (Criteria) this;
        }

        public Criteria andUserLoginPwdLessThanOrEqualTo(String value) {
            addCriterion("USER_LOGIN_PWD <=", value, "userLoginPwd");
            return (Criteria) this;
        }

        public Criteria andUserLoginPwdLike(String value) {
            addCriterion("USER_LOGIN_PWD like", value, "userLoginPwd");
            return (Criteria) this;
        }

        public Criteria andUserLoginPwdNotLike(String value) {
            addCriterion("USER_LOGIN_PWD not like", value, "userLoginPwd");
            return (Criteria) this;
        }

        public Criteria andUserLoginPwdIn(List<String> values) {
            addCriterion("USER_LOGIN_PWD in", values, "userLoginPwd");
            return (Criteria) this;
        }

        public Criteria andUserLoginPwdNotIn(List<String> values) {
            addCriterion("USER_LOGIN_PWD not in", values, "userLoginPwd");
            return (Criteria) this;
        }

        public Criteria andUserLoginPwdBetween(String value1, String value2) {
            addCriterion("USER_LOGIN_PWD between", value1, value2, "userLoginPwd");
            return (Criteria) this;
        }

        public Criteria andUserLoginPwdNotBetween(String value1, String value2) {
            addCriterion("USER_LOGIN_PWD not between", value1, value2, "userLoginPwd");
            return (Criteria) this;
        }

        public Criteria andPwdSafetyLevelIsNull() {
            addCriterion("PWD_SAFETY_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andPwdSafetyLevelIsNotNull() {
            addCriterion("PWD_SAFETY_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andPwdSafetyLevelEqualTo(String value) {
            addCriterion("PWD_SAFETY_LEVEL =", value, "pwdSafetyLevel");
            return (Criteria) this;
        }

        public Criteria andPwdSafetyLevelNotEqualTo(String value) {
            addCriterion("PWD_SAFETY_LEVEL <>", value, "pwdSafetyLevel");
            return (Criteria) this;
        }

        public Criteria andPwdSafetyLevelGreaterThan(String value) {
            addCriterion("PWD_SAFETY_LEVEL >", value, "pwdSafetyLevel");
            return (Criteria) this;
        }

        public Criteria andPwdSafetyLevelGreaterThanOrEqualTo(String value) {
            addCriterion("PWD_SAFETY_LEVEL >=", value, "pwdSafetyLevel");
            return (Criteria) this;
        }

        public Criteria andPwdSafetyLevelLessThan(String value) {
            addCriterion("PWD_SAFETY_LEVEL <", value, "pwdSafetyLevel");
            return (Criteria) this;
        }

        public Criteria andPwdSafetyLevelLessThanOrEqualTo(String value) {
            addCriterion("PWD_SAFETY_LEVEL <=", value, "pwdSafetyLevel");
            return (Criteria) this;
        }

        public Criteria andPwdSafetyLevelLike(String value) {
            addCriterion("PWD_SAFETY_LEVEL like", value, "pwdSafetyLevel");
            return (Criteria) this;
        }

        public Criteria andPwdSafetyLevelNotLike(String value) {
            addCriterion("PWD_SAFETY_LEVEL not like", value, "pwdSafetyLevel");
            return (Criteria) this;
        }

        public Criteria andPwdSafetyLevelIn(List<String> values) {
            addCriterion("PWD_SAFETY_LEVEL in", values, "pwdSafetyLevel");
            return (Criteria) this;
        }

        public Criteria andPwdSafetyLevelNotIn(List<String> values) {
            addCriterion("PWD_SAFETY_LEVEL not in", values, "pwdSafetyLevel");
            return (Criteria) this;
        }

        public Criteria andPwdSafetyLevelBetween(String value1, String value2) {
            addCriterion("PWD_SAFETY_LEVEL between", value1, value2, "pwdSafetyLevel");
            return (Criteria) this;
        }

        public Criteria andPwdSafetyLevelNotBetween(String value1, String value2) {
            addCriterion("PWD_SAFETY_LEVEL not between", value1, value2, "pwdSafetyLevel");
            return (Criteria) this;
        }

        public Criteria andUserMpIsNull() {
            addCriterion("USER_MP is null");
            return (Criteria) this;
        }

        public Criteria andUserMpIsNotNull() {
            addCriterion("USER_MP is not null");
            return (Criteria) this;
        }

        public Criteria andUserMpEqualTo(String value) {
            addCriterion("USER_MP =", value, "userMp");
            return (Criteria) this;
        }

        public Criteria andUserMpNotEqualTo(String value) {
            addCriterion("USER_MP <>", value, "userMp");
            return (Criteria) this;
        }

        public Criteria andUserMpGreaterThan(String value) {
            addCriterion("USER_MP >", value, "userMp");
            return (Criteria) this;
        }

        public Criteria andUserMpGreaterThanOrEqualTo(String value) {
            addCriterion("USER_MP >=", value, "userMp");
            return (Criteria) this;
        }

        public Criteria andUserMpLessThan(String value) {
            addCriterion("USER_MP <", value, "userMp");
            return (Criteria) this;
        }

        public Criteria andUserMpLessThanOrEqualTo(String value) {
            addCriterion("USER_MP <=", value, "userMp");
            return (Criteria) this;
        }

        public Criteria andUserMpLike(String value) {
            addCriterion("USER_MP like", value, "userMp");
            return (Criteria) this;
        }

        public Criteria andUserMpNotLike(String value) {
            addCriterion("USER_MP not like", value, "userMp");
            return (Criteria) this;
        }

        public Criteria andUserMpIn(List<String> values) {
            addCriterion("USER_MP in", values, "userMp");
            return (Criteria) this;
        }

        public Criteria andUserMpNotIn(List<String> values) {
            addCriterion("USER_MP not in", values, "userMp");
            return (Criteria) this;
        }

        public Criteria andUserMpBetween(String value1, String value2) {
            addCriterion("USER_MP between", value1, value2, "userMp");
            return (Criteria) this;
        }

        public Criteria andUserMpNotBetween(String value1, String value2) {
            addCriterion("USER_MP not between", value1, value2, "userMp");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("USER_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("USER_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("USER_EMAIL =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("USER_EMAIL <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("USER_EMAIL >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("USER_EMAIL >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("USER_EMAIL <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("USER_EMAIL <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("USER_EMAIL like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("USER_EMAIL not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("USER_EMAIL in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("USER_EMAIL not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("USER_EMAIL between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("USER_EMAIL not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andEmailValidateFlagIsNull() {
            addCriterion("EMAIL_VALIDATE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andEmailValidateFlagIsNotNull() {
            addCriterion("EMAIL_VALIDATE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andEmailValidateFlagEqualTo(String value) {
            addCriterion("EMAIL_VALIDATE_FLAG =", value, "emailValidateFlag");
            return (Criteria) this;
        }

        public Criteria andEmailValidateFlagNotEqualTo(String value) {
            addCriterion("EMAIL_VALIDATE_FLAG <>", value, "emailValidateFlag");
            return (Criteria) this;
        }

        public Criteria andEmailValidateFlagGreaterThan(String value) {
            addCriterion("EMAIL_VALIDATE_FLAG >", value, "emailValidateFlag");
            return (Criteria) this;
        }

        public Criteria andEmailValidateFlagGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL_VALIDATE_FLAG >=", value, "emailValidateFlag");
            return (Criteria) this;
        }

        public Criteria andEmailValidateFlagLessThan(String value) {
            addCriterion("EMAIL_VALIDATE_FLAG <", value, "emailValidateFlag");
            return (Criteria) this;
        }

        public Criteria andEmailValidateFlagLessThanOrEqualTo(String value) {
            addCriterion("EMAIL_VALIDATE_FLAG <=", value, "emailValidateFlag");
            return (Criteria) this;
        }

        public Criteria andEmailValidateFlagLike(String value) {
            addCriterion("EMAIL_VALIDATE_FLAG like", value, "emailValidateFlag");
            return (Criteria) this;
        }

        public Criteria andEmailValidateFlagNotLike(String value) {
            addCriterion("EMAIL_VALIDATE_FLAG not like", value, "emailValidateFlag");
            return (Criteria) this;
        }

        public Criteria andEmailValidateFlagIn(List<String> values) {
            addCriterion("EMAIL_VALIDATE_FLAG in", values, "emailValidateFlag");
            return (Criteria) this;
        }

        public Criteria andEmailValidateFlagNotIn(List<String> values) {
            addCriterion("EMAIL_VALIDATE_FLAG not in", values, "emailValidateFlag");
            return (Criteria) this;
        }

        public Criteria andEmailValidateFlagBetween(String value1, String value2) {
            addCriterion("EMAIL_VALIDATE_FLAG between", value1, value2, "emailValidateFlag");
            return (Criteria) this;
        }

        public Criteria andEmailValidateFlagNotBetween(String value1, String value2) {
            addCriterion("EMAIL_VALIDATE_FLAG not between", value1, value2, "emailValidateFlag");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIsNull() {
            addCriterion("USER_NICKNAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIsNotNull() {
            addCriterion("USER_NICKNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNicknameEqualTo(String value) {
            addCriterion("USER_NICKNAME =", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotEqualTo(String value) {
            addCriterion("USER_NICKNAME <>", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameGreaterThan(String value) {
            addCriterion("USER_NICKNAME >", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NICKNAME >=", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLessThan(String value) {
            addCriterion("USER_NICKNAME <", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLessThanOrEqualTo(String value) {
            addCriterion("USER_NICKNAME <=", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameLike(String value) {
            addCriterion("USER_NICKNAME like", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotLike(String value) {
            addCriterion("USER_NICKNAME not like", value, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameIn(List<String> values) {
            addCriterion("USER_NICKNAME in", values, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotIn(List<String> values) {
            addCriterion("USER_NICKNAME not in", values, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameBetween(String value1, String value2) {
            addCriterion("USER_NICKNAME between", value1, value2, "userNickname");
            return (Criteria) this;
        }

        public Criteria andUserNicknameNotBetween(String value1, String value2) {
            addCriterion("USER_NICKNAME not between", value1, value2, "userNickname");
            return (Criteria) this;
        }

        public Criteria andOrtraitFileIdIsNull() {
            addCriterion("ORTRAIT_FILE_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrtraitFileIdIsNotNull() {
            addCriterion("ORTRAIT_FILE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrtraitFileIdEqualTo(String value) {
            addCriterion("ORTRAIT_FILE_ID =", value, "ortraitFileId");
            return (Criteria) this;
        }

        public Criteria andOrtraitFileIdNotEqualTo(String value) {
            addCriterion("ORTRAIT_FILE_ID <>", value, "ortraitFileId");
            return (Criteria) this;
        }

        public Criteria andOrtraitFileIdGreaterThan(String value) {
            addCriterion("ORTRAIT_FILE_ID >", value, "ortraitFileId");
            return (Criteria) this;
        }

        public Criteria andOrtraitFileIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORTRAIT_FILE_ID >=", value, "ortraitFileId");
            return (Criteria) this;
        }

        public Criteria andOrtraitFileIdLessThan(String value) {
            addCriterion("ORTRAIT_FILE_ID <", value, "ortraitFileId");
            return (Criteria) this;
        }

        public Criteria andOrtraitFileIdLessThanOrEqualTo(String value) {
            addCriterion("ORTRAIT_FILE_ID <=", value, "ortraitFileId");
            return (Criteria) this;
        }

        public Criteria andOrtraitFileIdLike(String value) {
            addCriterion("ORTRAIT_FILE_ID like", value, "ortraitFileId");
            return (Criteria) this;
        }

        public Criteria andOrtraitFileIdNotLike(String value) {
            addCriterion("ORTRAIT_FILE_ID not like", value, "ortraitFileId");
            return (Criteria) this;
        }

        public Criteria andOrtraitFileIdIn(List<String> values) {
            addCriterion("ORTRAIT_FILE_ID in", values, "ortraitFileId");
            return (Criteria) this;
        }

        public Criteria andOrtraitFileIdNotIn(List<String> values) {
            addCriterion("ORTRAIT_FILE_ID not in", values, "ortraitFileId");
            return (Criteria) this;
        }

        public Criteria andOrtraitFileIdBetween(String value1, String value2) {
            addCriterion("ORTRAIT_FILE_ID between", value1, value2, "ortraitFileId");
            return (Criteria) this;
        }

        public Criteria andOrtraitFileIdNotBetween(String value1, String value2) {
            addCriterion("ORTRAIT_FILE_ID not between", value1, value2, "ortraitFileId");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNull() {
            addCriterion("PROVINCE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("PROVINCE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeEqualTo(String value) {
            addCriterion("PROVINCE_CODE =", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotEqualTo(String value) {
            addCriterion("PROVINCE_CODE <>", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThan(String value) {
            addCriterion("PROVINCE_CODE >", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE_CODE >=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThan(String value) {
            addCriterion("PROVINCE_CODE <", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE_CODE <=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLike(String value) {
            addCriterion("PROVINCE_CODE like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotLike(String value) {
            addCriterion("PROVINCE_CODE not like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIn(List<String> values) {
            addCriterion("PROVINCE_CODE in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotIn(List<String> values) {
            addCriterion("PROVINCE_CODE not in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeBetween(String value1, String value2) {
            addCriterion("PROVINCE_CODE between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("PROVINCE_CODE not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNull() {
            addCriterion("CITY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNotNull() {
            addCriterion("CITY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCityCodeEqualTo(String value) {
            addCriterion("CITY_CODE =", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotEqualTo(String value) {
            addCriterion("CITY_CODE <>", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThan(String value) {
            addCriterion("CITY_CODE >", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CITY_CODE >=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThan(String value) {
            addCriterion("CITY_CODE <", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThanOrEqualTo(String value) {
            addCriterion("CITY_CODE <=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLike(String value) {
            addCriterion("CITY_CODE like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotLike(String value) {
            addCriterion("CITY_CODE not like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIn(List<String> values) {
            addCriterion("CITY_CODE in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotIn(List<String> values) {
            addCriterion("CITY_CODE not in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeBetween(String value1, String value2) {
            addCriterion("CITY_CODE between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotBetween(String value1, String value2) {
            addCriterion("CITY_CODE not between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andRegisterWayIsNull() {
            addCriterion("REGISTER_WAY is null");
            return (Criteria) this;
        }

        public Criteria andRegisterWayIsNotNull() {
            addCriterion("REGISTER_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterWayEqualTo(String value) {
            addCriterion("REGISTER_WAY =", value, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterWayNotEqualTo(String value) {
            addCriterion("REGISTER_WAY <>", value, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterWayGreaterThan(String value) {
            addCriterion("REGISTER_WAY >", value, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterWayGreaterThanOrEqualTo(String value) {
            addCriterion("REGISTER_WAY >=", value, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterWayLessThan(String value) {
            addCriterion("REGISTER_WAY <", value, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterWayLessThanOrEqualTo(String value) {
            addCriterion("REGISTER_WAY <=", value, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterWayLike(String value) {
            addCriterion("REGISTER_WAY like", value, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterWayNotLike(String value) {
            addCriterion("REGISTER_WAY not like", value, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterWayIn(List<String> values) {
            addCriterion("REGISTER_WAY in", values, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterWayNotIn(List<String> values) {
            addCriterion("REGISTER_WAY not in", values, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterWayBetween(String value1, String value2) {
            addCriterion("REGISTER_WAY between", value1, value2, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterWayNotBetween(String value1, String value2) {
            addCriterion("REGISTER_WAY not between", value1, value2, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceIsNull() {
            addCriterion("REGISTER_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceIsNotNull() {
            addCriterion("REGISTER_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceEqualTo(String value) {
            addCriterion("REGISTER_SOURCE =", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceNotEqualTo(String value) {
            addCriterion("REGISTER_SOURCE <>", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceGreaterThan(String value) {
            addCriterion("REGISTER_SOURCE >", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceGreaterThanOrEqualTo(String value) {
            addCriterion("REGISTER_SOURCE >=", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceLessThan(String value) {
            addCriterion("REGISTER_SOURCE <", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceLessThanOrEqualTo(String value) {
            addCriterion("REGISTER_SOURCE <=", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceLike(String value) {
            addCriterion("REGISTER_SOURCE like", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceNotLike(String value) {
            addCriterion("REGISTER_SOURCE not like", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceIn(List<String> values) {
            addCriterion("REGISTER_SOURCE in", values, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceNotIn(List<String> values) {
            addCriterion("REGISTER_SOURCE not in", values, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceBetween(String value1, String value2) {
            addCriterion("REGISTER_SOURCE between", value1, value2, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceNotBetween(String value1, String value2) {
            addCriterion("REGISTER_SOURCE not between", value1, value2, "registerSource");
            return (Criteria) this;
        }

        public Criteria andCreditFlagIsNull() {
            addCriterion("CREDIT_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andCreditFlagIsNotNull() {
            addCriterion("CREDIT_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCreditFlagEqualTo(String value) {
            addCriterion("CREDIT_FLAG =", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagNotEqualTo(String value) {
            addCriterion("CREDIT_FLAG <>", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagGreaterThan(String value) {
            addCriterion("CREDIT_FLAG >", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagGreaterThanOrEqualTo(String value) {
            addCriterion("CREDIT_FLAG >=", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagLessThan(String value) {
            addCriterion("CREDIT_FLAG <", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagLessThanOrEqualTo(String value) {
            addCriterion("CREDIT_FLAG <=", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagLike(String value) {
            addCriterion("CREDIT_FLAG like", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagNotLike(String value) {
            addCriterion("CREDIT_FLAG not like", value, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagIn(List<String> values) {
            addCriterion("CREDIT_FLAG in", values, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagNotIn(List<String> values) {
            addCriterion("CREDIT_FLAG not in", values, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagBetween(String value1, String value2) {
            addCriterion("CREDIT_FLAG between", value1, value2, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andCreditFlagNotBetween(String value1, String value2) {
            addCriterion("CREDIT_FLAG not between", value1, value2, "creditFlag");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeIsNull() {
            addCriterion("STATE_CHG_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeIsNotNull() {
            addCriterion("STATE_CHG_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeEqualTo(Timestamp value) {
            addCriterion("STATE_CHG_TIME =", value, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeNotEqualTo(Timestamp value) {
            addCriterion("STATE_CHG_TIME <>", value, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeGreaterThan(Timestamp value) {
            addCriterion("STATE_CHG_TIME >", value, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("STATE_CHG_TIME >=", value, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeLessThan(Timestamp value) {
            addCriterion("STATE_CHG_TIME <", value, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("STATE_CHG_TIME <=", value, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeIn(List<Timestamp> values) {
            addCriterion("STATE_CHG_TIME in", values, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeNotIn(List<Timestamp> values) {
            addCriterion("STATE_CHG_TIME not in", values, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("STATE_CHG_TIME between", value1, value2, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andStateChgTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("STATE_CHG_TIME not between", value1, value2, "stateChgTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Timestamp value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Timestamp value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Timestamp> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Timestamp> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateChlIdIsNull() {
            addCriterion("CREATE_CHL_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreateChlIdIsNotNull() {
            addCriterion("CREATE_CHL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateChlIdEqualTo(String value) {
            addCriterion("CREATE_CHL_ID =", value, "createChlId");
            return (Criteria) this;
        }

        public Criteria andCreateChlIdNotEqualTo(String value) {
            addCriterion("CREATE_CHL_ID <>", value, "createChlId");
            return (Criteria) this;
        }

        public Criteria andCreateChlIdGreaterThan(String value) {
            addCriterion("CREATE_CHL_ID >", value, "createChlId");
            return (Criteria) this;
        }

        public Criteria andCreateChlIdGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_CHL_ID >=", value, "createChlId");
            return (Criteria) this;
        }

        public Criteria andCreateChlIdLessThan(String value) {
            addCriterion("CREATE_CHL_ID <", value, "createChlId");
            return (Criteria) this;
        }

        public Criteria andCreateChlIdLessThanOrEqualTo(String value) {
            addCriterion("CREATE_CHL_ID <=", value, "createChlId");
            return (Criteria) this;
        }

        public Criteria andCreateChlIdLike(String value) {
            addCriterion("CREATE_CHL_ID like", value, "createChlId");
            return (Criteria) this;
        }

        public Criteria andCreateChlIdNotLike(String value) {
            addCriterion("CREATE_CHL_ID not like", value, "createChlId");
            return (Criteria) this;
        }

        public Criteria andCreateChlIdIn(List<String> values) {
            addCriterion("CREATE_CHL_ID in", values, "createChlId");
            return (Criteria) this;
        }

        public Criteria andCreateChlIdNotIn(List<String> values) {
            addCriterion("CREATE_CHL_ID not in", values, "createChlId");
            return (Criteria) this;
        }

        public Criteria andCreateChlIdBetween(String value1, String value2) {
            addCriterion("CREATE_CHL_ID between", value1, value2, "createChlId");
            return (Criteria) this;
        }

        public Criteria andCreateChlIdNotBetween(String value1, String value2) {
            addCriterion("CREATE_CHL_ID not between", value1, value2, "createChlId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdIsNull() {
            addCriterion("CREATE_OPER_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdIsNotNull() {
            addCriterion("CREATE_OPER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdEqualTo(Long value) {
            addCriterion("CREATE_OPER_ID =", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdNotEqualTo(Long value) {
            addCriterion("CREATE_OPER_ID <>", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdGreaterThan(Long value) {
            addCriterion("CREATE_OPER_ID >", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CREATE_OPER_ID >=", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdLessThan(Long value) {
            addCriterion("CREATE_OPER_ID <", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdLessThanOrEqualTo(Long value) {
            addCriterion("CREATE_OPER_ID <=", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdIn(List<Long> values) {
            addCriterion("CREATE_OPER_ID in", values, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdNotIn(List<Long> values) {
            addCriterion("CREATE_OPER_ID not in", values, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdBetween(Long value1, Long value2) {
            addCriterion("CREATE_OPER_ID between", value1, value2, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdNotBetween(Long value1, Long value2) {
            addCriterion("CREATE_OPER_ID not between", value1, value2, "createOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Timestamp value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Timestamp value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Timestamp> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Timestamp> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdIsNull() {
            addCriterion("UPDATE_CHL_ID is null");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdIsNotNull() {
            addCriterion("UPDATE_CHL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdEqualTo(String value) {
            addCriterion("UPDATE_CHL_ID =", value, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdNotEqualTo(String value) {
            addCriterion("UPDATE_CHL_ID <>", value, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdGreaterThan(String value) {
            addCriterion("UPDATE_CHL_ID >", value, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_CHL_ID >=", value, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdLessThan(String value) {
            addCriterion("UPDATE_CHL_ID <", value, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_CHL_ID <=", value, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdLike(String value) {
            addCriterion("UPDATE_CHL_ID like", value, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdNotLike(String value) {
            addCriterion("UPDATE_CHL_ID not like", value, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdIn(List<String> values) {
            addCriterion("UPDATE_CHL_ID in", values, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdNotIn(List<String> values) {
            addCriterion("UPDATE_CHL_ID not in", values, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdBetween(String value1, String value2) {
            addCriterion("UPDATE_CHL_ID between", value1, value2, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateChlIdNotBetween(String value1, String value2) {
            addCriterion("UPDATE_CHL_ID not between", value1, value2, "updateChlId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdIsNull() {
            addCriterion("UPDATE_OPER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdIsNotNull() {
            addCriterion("UPDATE_OPER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdEqualTo(Long value) {
            addCriterion("UPDATE_OPER_ID =", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotEqualTo(Long value) {
            addCriterion("UPDATE_OPER_ID <>", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdGreaterThan(Long value) {
            addCriterion("UPDATE_OPER_ID >", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdGreaterThanOrEqualTo(Long value) {
            addCriterion("UPDATE_OPER_ID >=", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdLessThan(Long value) {
            addCriterion("UPDATE_OPER_ID <", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdLessThanOrEqualTo(Long value) {
            addCriterion("UPDATE_OPER_ID <=", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdIn(List<Long> values) {
            addCriterion("UPDATE_OPER_ID in", values, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotIn(List<Long> values) {
            addCriterion("UPDATE_OPER_ID not in", values, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdBetween(Long value1, Long value2) {
            addCriterion("UPDATE_OPER_ID between", value1, value2, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotBetween(Long value1, Long value2) {
            addCriterion("UPDATE_OPER_ID not between", value1, value2, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andUserEmailTokenIsNull() {
            addCriterion("USER_EMAIL_TOKEN is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailTokenIsNotNull() {
            addCriterion("USER_EMAIL_TOKEN is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailTokenEqualTo(String value) {
            addCriterion("USER_EMAIL_TOKEN =", value, "userEmailToken");
            return (Criteria) this;
        }

        public Criteria andUserEmailTokenNotEqualTo(String value) {
            addCriterion("USER_EMAIL_TOKEN <>", value, "userEmailToken");
            return (Criteria) this;
        }

        public Criteria andUserEmailTokenGreaterThan(String value) {
            addCriterion("USER_EMAIL_TOKEN >", value, "userEmailToken");
            return (Criteria) this;
        }

        public Criteria andUserEmailTokenGreaterThanOrEqualTo(String value) {
            addCriterion("USER_EMAIL_TOKEN >=", value, "userEmailToken");
            return (Criteria) this;
        }

        public Criteria andUserEmailTokenLessThan(String value) {
            addCriterion("USER_EMAIL_TOKEN <", value, "userEmailToken");
            return (Criteria) this;
        }

        public Criteria andUserEmailTokenLessThanOrEqualTo(String value) {
            addCriterion("USER_EMAIL_TOKEN <=", value, "userEmailToken");
            return (Criteria) this;
        }

        public Criteria andUserEmailTokenLike(String value) {
            addCriterion("USER_EMAIL_TOKEN like", value, "userEmailToken");
            return (Criteria) this;
        }

        public Criteria andUserEmailTokenNotLike(String value) {
            addCriterion("USER_EMAIL_TOKEN not like", value, "userEmailToken");
            return (Criteria) this;
        }

        public Criteria andUserEmailTokenIn(List<String> values) {
            addCriterion("USER_EMAIL_TOKEN in", values, "userEmailToken");
            return (Criteria) this;
        }

        public Criteria andUserEmailTokenNotIn(List<String> values) {
            addCriterion("USER_EMAIL_TOKEN not in", values, "userEmailToken");
            return (Criteria) this;
        }

        public Criteria andUserEmailTokenBetween(String value1, String value2) {
            addCriterion("USER_EMAIL_TOKEN between", value1, value2, "userEmailToken");
            return (Criteria) this;
        }

        public Criteria andUserEmailTokenNotBetween(String value1, String value2) {
            addCriterion("USER_EMAIL_TOKEN not between", value1, value2, "userEmailToken");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}