package com.ai.slp.user.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UcApiInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public UcApiInfoCriteria() {
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

        public Criteria andApiSeqIdIsNull() {
            addCriterion("API_SEQ_ID is null");
            return (Criteria) this;
        }

        public Criteria andApiSeqIdIsNotNull() {
            addCriterion("API_SEQ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andApiSeqIdEqualTo(String value) {
            addCriterion("API_SEQ_ID =", value, "apiSeqId");
            return (Criteria) this;
        }

        public Criteria andApiSeqIdNotEqualTo(String value) {
            addCriterion("API_SEQ_ID <>", value, "apiSeqId");
            return (Criteria) this;
        }

        public Criteria andApiSeqIdGreaterThan(String value) {
            addCriterion("API_SEQ_ID >", value, "apiSeqId");
            return (Criteria) this;
        }

        public Criteria andApiSeqIdGreaterThanOrEqualTo(String value) {
            addCriterion("API_SEQ_ID >=", value, "apiSeqId");
            return (Criteria) this;
        }

        public Criteria andApiSeqIdLessThan(String value) {
            addCriterion("API_SEQ_ID <", value, "apiSeqId");
            return (Criteria) this;
        }

        public Criteria andApiSeqIdLessThanOrEqualTo(String value) {
            addCriterion("API_SEQ_ID <=", value, "apiSeqId");
            return (Criteria) this;
        }

        public Criteria andApiSeqIdLike(String value) {
            addCriterion("API_SEQ_ID like", value, "apiSeqId");
            return (Criteria) this;
        }

        public Criteria andApiSeqIdNotLike(String value) {
            addCriterion("API_SEQ_ID not like", value, "apiSeqId");
            return (Criteria) this;
        }

        public Criteria andApiSeqIdIn(List<String> values) {
            addCriterion("API_SEQ_ID in", values, "apiSeqId");
            return (Criteria) this;
        }

        public Criteria andApiSeqIdNotIn(List<String> values) {
            addCriterion("API_SEQ_ID not in", values, "apiSeqId");
            return (Criteria) this;
        }

        public Criteria andApiSeqIdBetween(String value1, String value2) {
            addCriterion("API_SEQ_ID between", value1, value2, "apiSeqId");
            return (Criteria) this;
        }

        public Criteria andApiSeqIdNotBetween(String value1, String value2) {
            addCriterion("API_SEQ_ID not between", value1, value2, "apiSeqId");
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

        public Criteria andApiNameIsNull() {
            addCriterion("API_NAME is null");
            return (Criteria) this;
        }

        public Criteria andApiNameIsNotNull() {
            addCriterion("API_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andApiNameEqualTo(String value) {
            addCriterion("API_NAME =", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotEqualTo(String value) {
            addCriterion("API_NAME <>", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameGreaterThan(String value) {
            addCriterion("API_NAME >", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameGreaterThanOrEqualTo(String value) {
            addCriterion("API_NAME >=", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLessThan(String value) {
            addCriterion("API_NAME <", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLessThanOrEqualTo(String value) {
            addCriterion("API_NAME <=", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameLike(String value) {
            addCriterion("API_NAME like", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotLike(String value) {
            addCriterion("API_NAME not like", value, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameIn(List<String> values) {
            addCriterion("API_NAME in", values, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotIn(List<String> values) {
            addCriterion("API_NAME not in", values, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameBetween(String value1, String value2) {
            addCriterion("API_NAME between", value1, value2, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiNameNotBetween(String value1, String value2) {
            addCriterion("API_NAME not between", value1, value2, "apiName");
            return (Criteria) this;
        }

        public Criteria andApiTypeIsNull() {
            addCriterion("API_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andApiTypeIsNotNull() {
            addCriterion("API_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andApiTypeEqualTo(String value) {
            addCriterion("API_TYPE =", value, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeNotEqualTo(String value) {
            addCriterion("API_TYPE <>", value, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeGreaterThan(String value) {
            addCriterion("API_TYPE >", value, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeGreaterThanOrEqualTo(String value) {
            addCriterion("API_TYPE >=", value, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeLessThan(String value) {
            addCriterion("API_TYPE <", value, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeLessThanOrEqualTo(String value) {
            addCriterion("API_TYPE <=", value, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeLike(String value) {
            addCriterion("API_TYPE like", value, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeNotLike(String value) {
            addCriterion("API_TYPE not like", value, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeIn(List<String> values) {
            addCriterion("API_TYPE in", values, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeNotIn(List<String> values) {
            addCriterion("API_TYPE not in", values, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeBetween(String value1, String value2) {
            addCriterion("API_TYPE between", value1, value2, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiTypeNotBetween(String value1, String value2) {
            addCriterion("API_TYPE not between", value1, value2, "apiType");
            return (Criteria) this;
        }

        public Criteria andApiInfoIsNull() {
            addCriterion("API_INFO is null");
            return (Criteria) this;
        }

        public Criteria andApiInfoIsNotNull() {
            addCriterion("API_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andApiInfoEqualTo(String value) {
            addCriterion("API_INFO =", value, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andApiInfoNotEqualTo(String value) {
            addCriterion("API_INFO <>", value, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andApiInfoGreaterThan(String value) {
            addCriterion("API_INFO >", value, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andApiInfoGreaterThanOrEqualTo(String value) {
            addCriterion("API_INFO >=", value, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andApiInfoLessThan(String value) {
            addCriterion("API_INFO <", value, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andApiInfoLessThanOrEqualTo(String value) {
            addCriterion("API_INFO <=", value, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andApiInfoLike(String value) {
            addCriterion("API_INFO like", value, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andApiInfoNotLike(String value) {
            addCriterion("API_INFO not like", value, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andApiInfoIn(List<String> values) {
            addCriterion("API_INFO in", values, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andApiInfoNotIn(List<String> values) {
            addCriterion("API_INFO not in", values, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andApiInfoBetween(String value1, String value2) {
            addCriterion("API_INFO between", value1, value2, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andApiInfoNotBetween(String value1, String value2) {
            addCriterion("API_INFO not between", value1, value2, "apiInfo");
            return (Criteria) this;
        }

        public Criteria andWebAddrIsNull() {
            addCriterion("WEB_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andWebAddrIsNotNull() {
            addCriterion("WEB_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andWebAddrEqualTo(String value) {
            addCriterion("WEB_ADDR =", value, "webAddr");
            return (Criteria) this;
        }

        public Criteria andWebAddrNotEqualTo(String value) {
            addCriterion("WEB_ADDR <>", value, "webAddr");
            return (Criteria) this;
        }

        public Criteria andWebAddrGreaterThan(String value) {
            addCriterion("WEB_ADDR >", value, "webAddr");
            return (Criteria) this;
        }

        public Criteria andWebAddrGreaterThanOrEqualTo(String value) {
            addCriterion("WEB_ADDR >=", value, "webAddr");
            return (Criteria) this;
        }

        public Criteria andWebAddrLessThan(String value) {
            addCriterion("WEB_ADDR <", value, "webAddr");
            return (Criteria) this;
        }

        public Criteria andWebAddrLessThanOrEqualTo(String value) {
            addCriterion("WEB_ADDR <=", value, "webAddr");
            return (Criteria) this;
        }

        public Criteria andWebAddrLike(String value) {
            addCriterion("WEB_ADDR like", value, "webAddr");
            return (Criteria) this;
        }

        public Criteria andWebAddrNotLike(String value) {
            addCriterion("WEB_ADDR not like", value, "webAddr");
            return (Criteria) this;
        }

        public Criteria andWebAddrIn(List<String> values) {
            addCriterion("WEB_ADDR in", values, "webAddr");
            return (Criteria) this;
        }

        public Criteria andWebAddrNotIn(List<String> values) {
            addCriterion("WEB_ADDR not in", values, "webAddr");
            return (Criteria) this;
        }

        public Criteria andWebAddrBetween(String value1, String value2) {
            addCriterion("WEB_ADDR between", value1, value2, "webAddr");
            return (Criteria) this;
        }

        public Criteria andWebAddrNotBetween(String value1, String value2) {
            addCriterion("WEB_ADDR not between", value1, value2, "webAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrIsNull() {
            addCriterion("IP_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andIpAddrIsNotNull() {
            addCriterion("IP_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andIpAddrEqualTo(String value) {
            addCriterion("IP_ADDR =", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrNotEqualTo(String value) {
            addCriterion("IP_ADDR <>", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrGreaterThan(String value) {
            addCriterion("IP_ADDR >", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrGreaterThanOrEqualTo(String value) {
            addCriterion("IP_ADDR >=", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrLessThan(String value) {
            addCriterion("IP_ADDR <", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrLessThanOrEqualTo(String value) {
            addCriterion("IP_ADDR <=", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrLike(String value) {
            addCriterion("IP_ADDR like", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrNotLike(String value) {
            addCriterion("IP_ADDR not like", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrIn(List<String> values) {
            addCriterion("IP_ADDR in", values, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrNotIn(List<String> values) {
            addCriterion("IP_ADDR not in", values, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrBetween(String value1, String value2) {
            addCriterion("IP_ADDR between", value1, value2, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrNotBetween(String value1, String value2) {
            addCriterion("IP_ADDR not between", value1, value2, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andOperServiceIsNull() {
            addCriterion("OPER_SERVICE is null");
            return (Criteria) this;
        }

        public Criteria andOperServiceIsNotNull() {
            addCriterion("OPER_SERVICE is not null");
            return (Criteria) this;
        }

        public Criteria andOperServiceEqualTo(String value) {
            addCriterion("OPER_SERVICE =", value, "operService");
            return (Criteria) this;
        }

        public Criteria andOperServiceNotEqualTo(String value) {
            addCriterion("OPER_SERVICE <>", value, "operService");
            return (Criteria) this;
        }

        public Criteria andOperServiceGreaterThan(String value) {
            addCriterion("OPER_SERVICE >", value, "operService");
            return (Criteria) this;
        }

        public Criteria andOperServiceGreaterThanOrEqualTo(String value) {
            addCriterion("OPER_SERVICE >=", value, "operService");
            return (Criteria) this;
        }

        public Criteria andOperServiceLessThan(String value) {
            addCriterion("OPER_SERVICE <", value, "operService");
            return (Criteria) this;
        }

        public Criteria andOperServiceLessThanOrEqualTo(String value) {
            addCriterion("OPER_SERVICE <=", value, "operService");
            return (Criteria) this;
        }

        public Criteria andOperServiceLike(String value) {
            addCriterion("OPER_SERVICE like", value, "operService");
            return (Criteria) this;
        }

        public Criteria andOperServiceNotLike(String value) {
            addCriterion("OPER_SERVICE not like", value, "operService");
            return (Criteria) this;
        }

        public Criteria andOperServiceIn(List<String> values) {
            addCriterion("OPER_SERVICE in", values, "operService");
            return (Criteria) this;
        }

        public Criteria andOperServiceNotIn(List<String> values) {
            addCriterion("OPER_SERVICE not in", values, "operService");
            return (Criteria) this;
        }

        public Criteria andOperServiceBetween(String value1, String value2) {
            addCriterion("OPER_SERVICE between", value1, value2, "operService");
            return (Criteria) this;
        }

        public Criteria andOperServiceNotBetween(String value1, String value2) {
            addCriterion("OPER_SERVICE not between", value1, value2, "operService");
            return (Criteria) this;
        }

        public Criteria andSecretKeyIsNull() {
            addCriterion("SECRET_KEY is null");
            return (Criteria) this;
        }

        public Criteria andSecretKeyIsNotNull() {
            addCriterion("SECRET_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andSecretKeyEqualTo(String value) {
            addCriterion("SECRET_KEY =", value, "secretKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyNotEqualTo(String value) {
            addCriterion("SECRET_KEY <>", value, "secretKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyGreaterThan(String value) {
            addCriterion("SECRET_KEY >", value, "secretKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyGreaterThanOrEqualTo(String value) {
            addCriterion("SECRET_KEY >=", value, "secretKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyLessThan(String value) {
            addCriterion("SECRET_KEY <", value, "secretKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyLessThanOrEqualTo(String value) {
            addCriterion("SECRET_KEY <=", value, "secretKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyLike(String value) {
            addCriterion("SECRET_KEY like", value, "secretKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyNotLike(String value) {
            addCriterion("SECRET_KEY not like", value, "secretKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyIn(List<String> values) {
            addCriterion("SECRET_KEY in", values, "secretKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyNotIn(List<String> values) {
            addCriterion("SECRET_KEY not in", values, "secretKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyBetween(String value1, String value2) {
            addCriterion("SECRET_KEY between", value1, value2, "secretKey");
            return (Criteria) this;
        }

        public Criteria andSecretKeyNotBetween(String value1, String value2) {
            addCriterion("SECRET_KEY not between", value1, value2, "secretKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyIsNull() {
            addCriterion("API_KEY is null");
            return (Criteria) this;
        }

        public Criteria andApiKeyIsNotNull() {
            addCriterion("API_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andApiKeyEqualTo(String value) {
            addCriterion("API_KEY =", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyNotEqualTo(String value) {
            addCriterion("API_KEY <>", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyGreaterThan(String value) {
            addCriterion("API_KEY >", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyGreaterThanOrEqualTo(String value) {
            addCriterion("API_KEY >=", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyLessThan(String value) {
            addCriterion("API_KEY <", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyLessThanOrEqualTo(String value) {
            addCriterion("API_KEY <=", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyLike(String value) {
            addCriterion("API_KEY like", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyNotLike(String value) {
            addCriterion("API_KEY not like", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyIn(List<String> values) {
            addCriterion("API_KEY in", values, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyNotIn(List<String> values) {
            addCriterion("API_KEY not in", values, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyBetween(String value1, String value2) {
            addCriterion("API_KEY between", value1, value2, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyNotBetween(String value1, String value2) {
            addCriterion("API_KEY not between", value1, value2, "apiKey");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNull() {
            addCriterion("CONTACT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNotNull() {
            addCriterion("CONTACT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andContactNameEqualTo(String value) {
            addCriterion("CONTACT_NAME =", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotEqualTo(String value) {
            addCriterion("CONTACT_NAME <>", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThan(String value) {
            addCriterion("CONTACT_NAME >", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_NAME >=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThan(String value) {
            addCriterion("CONTACT_NAME <", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_NAME <=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLike(String value) {
            addCriterion("CONTACT_NAME like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotLike(String value) {
            addCriterion("CONTACT_NAME not like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameIn(List<String> values) {
            addCriterion("CONTACT_NAME in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotIn(List<String> values) {
            addCriterion("CONTACT_NAME not in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameBetween(String value1, String value2) {
            addCriterion("CONTACT_NAME between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotBetween(String value1, String value2) {
            addCriterion("CONTACT_NAME not between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeIsNull() {
            addCriterion("CONTACT_CERT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeIsNotNull() {
            addCriterion("CONTACT_CERT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeEqualTo(String value) {
            addCriterion("CONTACT_CERT_TYPE =", value, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeNotEqualTo(String value) {
            addCriterion("CONTACT_CERT_TYPE <>", value, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeGreaterThan(String value) {
            addCriterion("CONTACT_CERT_TYPE >", value, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_CERT_TYPE >=", value, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeLessThan(String value) {
            addCriterion("CONTACT_CERT_TYPE <", value, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_CERT_TYPE <=", value, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeLike(String value) {
            addCriterion("CONTACT_CERT_TYPE like", value, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeNotLike(String value) {
            addCriterion("CONTACT_CERT_TYPE not like", value, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeIn(List<String> values) {
            addCriterion("CONTACT_CERT_TYPE in", values, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeNotIn(List<String> values) {
            addCriterion("CONTACT_CERT_TYPE not in", values, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeBetween(String value1, String value2) {
            addCriterion("CONTACT_CERT_TYPE between", value1, value2, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeNotBetween(String value1, String value2) {
            addCriterion("CONTACT_CERT_TYPE not between", value1, value2, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertNumIsNull() {
            addCriterion("CONTACT_CERT_NUM is null");
            return (Criteria) this;
        }

        public Criteria andContactCertNumIsNotNull() {
            addCriterion("CONTACT_CERT_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andContactCertNumEqualTo(String value) {
            addCriterion("CONTACT_CERT_NUM =", value, "contactCertNum");
            return (Criteria) this;
        }

        public Criteria andContactCertNumNotEqualTo(String value) {
            addCriterion("CONTACT_CERT_NUM <>", value, "contactCertNum");
            return (Criteria) this;
        }

        public Criteria andContactCertNumGreaterThan(String value) {
            addCriterion("CONTACT_CERT_NUM >", value, "contactCertNum");
            return (Criteria) this;
        }

        public Criteria andContactCertNumGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_CERT_NUM >=", value, "contactCertNum");
            return (Criteria) this;
        }

        public Criteria andContactCertNumLessThan(String value) {
            addCriterion("CONTACT_CERT_NUM <", value, "contactCertNum");
            return (Criteria) this;
        }

        public Criteria andContactCertNumLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_CERT_NUM <=", value, "contactCertNum");
            return (Criteria) this;
        }

        public Criteria andContactCertNumLike(String value) {
            addCriterion("CONTACT_CERT_NUM like", value, "contactCertNum");
            return (Criteria) this;
        }

        public Criteria andContactCertNumNotLike(String value) {
            addCriterion("CONTACT_CERT_NUM not like", value, "contactCertNum");
            return (Criteria) this;
        }

        public Criteria andContactCertNumIn(List<String> values) {
            addCriterion("CONTACT_CERT_NUM in", values, "contactCertNum");
            return (Criteria) this;
        }

        public Criteria andContactCertNumNotIn(List<String> values) {
            addCriterion("CONTACT_CERT_NUM not in", values, "contactCertNum");
            return (Criteria) this;
        }

        public Criteria andContactCertNumBetween(String value1, String value2) {
            addCriterion("CONTACT_CERT_NUM between", value1, value2, "contactCertNum");
            return (Criteria) this;
        }

        public Criteria andContactCertNumNotBetween(String value1, String value2) {
            addCriterion("CONTACT_CERT_NUM not between", value1, value2, "contactCertNum");
            return (Criteria) this;
        }

        public Criteria andContactWxIdIsNull() {
            addCriterion("CONTACT_WX_ID is null");
            return (Criteria) this;
        }

        public Criteria andContactWxIdIsNotNull() {
            addCriterion("CONTACT_WX_ID is not null");
            return (Criteria) this;
        }

        public Criteria andContactWxIdEqualTo(String value) {
            addCriterion("CONTACT_WX_ID =", value, "contactWxId");
            return (Criteria) this;
        }

        public Criteria andContactWxIdNotEqualTo(String value) {
            addCriterion("CONTACT_WX_ID <>", value, "contactWxId");
            return (Criteria) this;
        }

        public Criteria andContactWxIdGreaterThan(String value) {
            addCriterion("CONTACT_WX_ID >", value, "contactWxId");
            return (Criteria) this;
        }

        public Criteria andContactWxIdGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_WX_ID >=", value, "contactWxId");
            return (Criteria) this;
        }

        public Criteria andContactWxIdLessThan(String value) {
            addCriterion("CONTACT_WX_ID <", value, "contactWxId");
            return (Criteria) this;
        }

        public Criteria andContactWxIdLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_WX_ID <=", value, "contactWxId");
            return (Criteria) this;
        }

        public Criteria andContactWxIdLike(String value) {
            addCriterion("CONTACT_WX_ID like", value, "contactWxId");
            return (Criteria) this;
        }

        public Criteria andContactWxIdNotLike(String value) {
            addCriterion("CONTACT_WX_ID not like", value, "contactWxId");
            return (Criteria) this;
        }

        public Criteria andContactWxIdIn(List<String> values) {
            addCriterion("CONTACT_WX_ID in", values, "contactWxId");
            return (Criteria) this;
        }

        public Criteria andContactWxIdNotIn(List<String> values) {
            addCriterion("CONTACT_WX_ID not in", values, "contactWxId");
            return (Criteria) this;
        }

        public Criteria andContactWxIdBetween(String value1, String value2) {
            addCriterion("CONTACT_WX_ID between", value1, value2, "contactWxId");
            return (Criteria) this;
        }

        public Criteria andContactWxIdNotBetween(String value1, String value2) {
            addCriterion("CONTACT_WX_ID not between", value1, value2, "contactWxId");
            return (Criteria) this;
        }

        public Criteria andContactMpIsNull() {
            addCriterion("CONTACT_MP is null");
            return (Criteria) this;
        }

        public Criteria andContactMpIsNotNull() {
            addCriterion("CONTACT_MP is not null");
            return (Criteria) this;
        }

        public Criteria andContactMpEqualTo(String value) {
            addCriterion("CONTACT_MP =", value, "contactMp");
            return (Criteria) this;
        }

        public Criteria andContactMpNotEqualTo(String value) {
            addCriterion("CONTACT_MP <>", value, "contactMp");
            return (Criteria) this;
        }

        public Criteria andContactMpGreaterThan(String value) {
            addCriterion("CONTACT_MP >", value, "contactMp");
            return (Criteria) this;
        }

        public Criteria andContactMpGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_MP >=", value, "contactMp");
            return (Criteria) this;
        }

        public Criteria andContactMpLessThan(String value) {
            addCriterion("CONTACT_MP <", value, "contactMp");
            return (Criteria) this;
        }

        public Criteria andContactMpLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_MP <=", value, "contactMp");
            return (Criteria) this;
        }

        public Criteria andContactMpLike(String value) {
            addCriterion("CONTACT_MP like", value, "contactMp");
            return (Criteria) this;
        }

        public Criteria andContactMpNotLike(String value) {
            addCriterion("CONTACT_MP not like", value, "contactMp");
            return (Criteria) this;
        }

        public Criteria andContactMpIn(List<String> values) {
            addCriterion("CONTACT_MP in", values, "contactMp");
            return (Criteria) this;
        }

        public Criteria andContactMpNotIn(List<String> values) {
            addCriterion("CONTACT_MP not in", values, "contactMp");
            return (Criteria) this;
        }

        public Criteria andContactMpBetween(String value1, String value2) {
            addCriterion("CONTACT_MP between", value1, value2, "contactMp");
            return (Criteria) this;
        }

        public Criteria andContactMpNotBetween(String value1, String value2) {
            addCriterion("CONTACT_MP not between", value1, value2, "contactMp");
            return (Criteria) this;
        }

        public Criteria andContactEmailIsNull() {
            addCriterion("CONTACT_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andContactEmailIsNotNull() {
            addCriterion("CONTACT_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andContactEmailEqualTo(String value) {
            addCriterion("CONTACT_EMAIL =", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailNotEqualTo(String value) {
            addCriterion("CONTACT_EMAIL <>", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailGreaterThan(String value) {
            addCriterion("CONTACT_EMAIL >", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_EMAIL >=", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailLessThan(String value) {
            addCriterion("CONTACT_EMAIL <", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_EMAIL <=", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailLike(String value) {
            addCriterion("CONTACT_EMAIL like", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailNotLike(String value) {
            addCriterion("CONTACT_EMAIL not like", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailIn(List<String> values) {
            addCriterion("CONTACT_EMAIL in", values, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailNotIn(List<String> values) {
            addCriterion("CONTACT_EMAIL not in", values, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailBetween(String value1, String value2) {
            addCriterion("CONTACT_EMAIL between", value1, value2, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailNotBetween(String value1, String value2) {
            addCriterion("CONTACT_EMAIL not between", value1, value2, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactAddressIsNull() {
            addCriterion("CONTACT_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andContactAddressIsNotNull() {
            addCriterion("CONTACT_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andContactAddressEqualTo(String value) {
            addCriterion("CONTACT_ADDRESS =", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressNotEqualTo(String value) {
            addCriterion("CONTACT_ADDRESS <>", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressGreaterThan(String value) {
            addCriterion("CONTACT_ADDRESS >", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_ADDRESS >=", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressLessThan(String value) {
            addCriterion("CONTACT_ADDRESS <", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_ADDRESS <=", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressLike(String value) {
            addCriterion("CONTACT_ADDRESS like", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressNotLike(String value) {
            addCriterion("CONTACT_ADDRESS not like", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressIn(List<String> values) {
            addCriterion("CONTACT_ADDRESS in", values, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressNotIn(List<String> values) {
            addCriterion("CONTACT_ADDRESS not in", values, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressBetween(String value1, String value2) {
            addCriterion("CONTACT_ADDRESS between", value1, value2, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressNotBetween(String value1, String value2) {
            addCriterion("CONTACT_ADDRESS not between", value1, value2, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andGroupZipIsNull() {
            addCriterion("GROUP_ZIP is null");
            return (Criteria) this;
        }

        public Criteria andGroupZipIsNotNull() {
            addCriterion("GROUP_ZIP is not null");
            return (Criteria) this;
        }

        public Criteria andGroupZipEqualTo(String value) {
            addCriterion("GROUP_ZIP =", value, "groupZip");
            return (Criteria) this;
        }

        public Criteria andGroupZipNotEqualTo(String value) {
            addCriterion("GROUP_ZIP <>", value, "groupZip");
            return (Criteria) this;
        }

        public Criteria andGroupZipGreaterThan(String value) {
            addCriterion("GROUP_ZIP >", value, "groupZip");
            return (Criteria) this;
        }

        public Criteria andGroupZipGreaterThanOrEqualTo(String value) {
            addCriterion("GROUP_ZIP >=", value, "groupZip");
            return (Criteria) this;
        }

        public Criteria andGroupZipLessThan(String value) {
            addCriterion("GROUP_ZIP <", value, "groupZip");
            return (Criteria) this;
        }

        public Criteria andGroupZipLessThanOrEqualTo(String value) {
            addCriterion("GROUP_ZIP <=", value, "groupZip");
            return (Criteria) this;
        }

        public Criteria andGroupZipLike(String value) {
            addCriterion("GROUP_ZIP like", value, "groupZip");
            return (Criteria) this;
        }

        public Criteria andGroupZipNotLike(String value) {
            addCriterion("GROUP_ZIP not like", value, "groupZip");
            return (Criteria) this;
        }

        public Criteria andGroupZipIn(List<String> values) {
            addCriterion("GROUP_ZIP in", values, "groupZip");
            return (Criteria) this;
        }

        public Criteria andGroupZipNotIn(List<String> values) {
            addCriterion("GROUP_ZIP not in", values, "groupZip");
            return (Criteria) this;
        }

        public Criteria andGroupZipBetween(String value1, String value2) {
            addCriterion("GROUP_ZIP between", value1, value2, "groupZip");
            return (Criteria) this;
        }

        public Criteria andGroupZipNotBetween(String value1, String value2) {
            addCriterion("GROUP_ZIP not between", value1, value2, "groupZip");
            return (Criteria) this;
        }

        public Criteria andContactDeptIsNull() {
            addCriterion("CONTACT_DEPT is null");
            return (Criteria) this;
        }

        public Criteria andContactDeptIsNotNull() {
            addCriterion("CONTACT_DEPT is not null");
            return (Criteria) this;
        }

        public Criteria andContactDeptEqualTo(String value) {
            addCriterion("CONTACT_DEPT =", value, "contactDept");
            return (Criteria) this;
        }

        public Criteria andContactDeptNotEqualTo(String value) {
            addCriterion("CONTACT_DEPT <>", value, "contactDept");
            return (Criteria) this;
        }

        public Criteria andContactDeptGreaterThan(String value) {
            addCriterion("CONTACT_DEPT >", value, "contactDept");
            return (Criteria) this;
        }

        public Criteria andContactDeptGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_DEPT >=", value, "contactDept");
            return (Criteria) this;
        }

        public Criteria andContactDeptLessThan(String value) {
            addCriterion("CONTACT_DEPT <", value, "contactDept");
            return (Criteria) this;
        }

        public Criteria andContactDeptLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_DEPT <=", value, "contactDept");
            return (Criteria) this;
        }

        public Criteria andContactDeptLike(String value) {
            addCriterion("CONTACT_DEPT like", value, "contactDept");
            return (Criteria) this;
        }

        public Criteria andContactDeptNotLike(String value) {
            addCriterion("CONTACT_DEPT not like", value, "contactDept");
            return (Criteria) this;
        }

        public Criteria andContactDeptIn(List<String> values) {
            addCriterion("CONTACT_DEPT in", values, "contactDept");
            return (Criteria) this;
        }

        public Criteria andContactDeptNotIn(List<String> values) {
            addCriterion("CONTACT_DEPT not in", values, "contactDept");
            return (Criteria) this;
        }

        public Criteria andContactDeptBetween(String value1, String value2) {
            addCriterion("CONTACT_DEPT between", value1, value2, "contactDept");
            return (Criteria) this;
        }

        public Criteria andContactDeptNotBetween(String value1, String value2) {
            addCriterion("CONTACT_DEPT not between", value1, value2, "contactDept");
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