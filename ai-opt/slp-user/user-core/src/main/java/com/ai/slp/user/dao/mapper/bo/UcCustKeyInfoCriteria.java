package com.ai.slp.user.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UcCustKeyInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public UcCustKeyInfoCriteria() {
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

        public Criteria andCustNameIsNull() {
            addCriterion("CUST_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNotNull() {
            addCriterion("CUST_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCustNameEqualTo(String value) {
            addCriterion("CUST_NAME =", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotEqualTo(String value) {
            addCriterion("CUST_NAME <>", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThan(String value) {
            addCriterion("CUST_NAME >", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_NAME >=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThan(String value) {
            addCriterion("CUST_NAME <", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThanOrEqualTo(String value) {
            addCriterion("CUST_NAME <=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLike(String value) {
            addCriterion("CUST_NAME like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotLike(String value) {
            addCriterion("CUST_NAME not like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameIn(List<String> values) {
            addCriterion("CUST_NAME in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotIn(List<String> values) {
            addCriterion("CUST_NAME not in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameBetween(String value1, String value2) {
            addCriterion("CUST_NAME between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotBetween(String value1, String value2) {
            addCriterion("CUST_NAME not between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCertTypeIsNull() {
            addCriterion("CERT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCertTypeIsNotNull() {
            addCriterion("CERT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCertTypeEqualTo(String value) {
            addCriterion("CERT_TYPE =", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotEqualTo(String value) {
            addCriterion("CERT_TYPE <>", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeGreaterThan(String value) {
            addCriterion("CERT_TYPE >", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_TYPE >=", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLessThan(String value) {
            addCriterion("CERT_TYPE <", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLessThanOrEqualTo(String value) {
            addCriterion("CERT_TYPE <=", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLike(String value) {
            addCriterion("CERT_TYPE like", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotLike(String value) {
            addCriterion("CERT_TYPE not like", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeIn(List<String> values) {
            addCriterion("CERT_TYPE in", values, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotIn(List<String> values) {
            addCriterion("CERT_TYPE not in", values, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeBetween(String value1, String value2) {
            addCriterion("CERT_TYPE between", value1, value2, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotBetween(String value1, String value2) {
            addCriterion("CERT_TYPE not between", value1, value2, "certType");
            return (Criteria) this;
        }

        public Criteria andCertNumIsNull() {
            addCriterion("CERT_NUM is null");
            return (Criteria) this;
        }

        public Criteria andCertNumIsNotNull() {
            addCriterion("CERT_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andCertNumEqualTo(String value) {
            addCriterion("CERT_NUM =", value, "certNum");
            return (Criteria) this;
        }

        public Criteria andCertNumNotEqualTo(String value) {
            addCriterion("CERT_NUM <>", value, "certNum");
            return (Criteria) this;
        }

        public Criteria andCertNumGreaterThan(String value) {
            addCriterion("CERT_NUM >", value, "certNum");
            return (Criteria) this;
        }

        public Criteria andCertNumGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_NUM >=", value, "certNum");
            return (Criteria) this;
        }

        public Criteria andCertNumLessThan(String value) {
            addCriterion("CERT_NUM <", value, "certNum");
            return (Criteria) this;
        }

        public Criteria andCertNumLessThanOrEqualTo(String value) {
            addCriterion("CERT_NUM <=", value, "certNum");
            return (Criteria) this;
        }

        public Criteria andCertNumLike(String value) {
            addCriterion("CERT_NUM like", value, "certNum");
            return (Criteria) this;
        }

        public Criteria andCertNumNotLike(String value) {
            addCriterion("CERT_NUM not like", value, "certNum");
            return (Criteria) this;
        }

        public Criteria andCertNumIn(List<String> values) {
            addCriterion("CERT_NUM in", values, "certNum");
            return (Criteria) this;
        }

        public Criteria andCertNumNotIn(List<String> values) {
            addCriterion("CERT_NUM not in", values, "certNum");
            return (Criteria) this;
        }

        public Criteria andCertNumBetween(String value1, String value2) {
            addCriterion("CERT_NUM between", value1, value2, "certNum");
            return (Criteria) this;
        }

        public Criteria andCertNumNotBetween(String value1, String value2) {
            addCriterion("CERT_NUM not between", value1, value2, "certNum");
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

        public Criteria andCountyCodeIsNull() {
            addCriterion("COUNTY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCountyCodeIsNotNull() {
            addCriterion("COUNTY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCountyCodeEqualTo(String value) {
            addCriterion("COUNTY_CODE =", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeNotEqualTo(String value) {
            addCriterion("COUNTY_CODE <>", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeGreaterThan(String value) {
            addCriterion("COUNTY_CODE >", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("COUNTY_CODE >=", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeLessThan(String value) {
            addCriterion("COUNTY_CODE <", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeLessThanOrEqualTo(String value) {
            addCriterion("COUNTY_CODE <=", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeLike(String value) {
            addCriterion("COUNTY_CODE like", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeNotLike(String value) {
            addCriterion("COUNTY_CODE not like", value, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeIn(List<String> values) {
            addCriterion("COUNTY_CODE in", values, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeNotIn(List<String> values) {
            addCriterion("COUNTY_CODE not in", values, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeBetween(String value1, String value2) {
            addCriterion("COUNTY_CODE between", value1, value2, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCountyCodeNotBetween(String value1, String value2) {
            addCriterion("COUNTY_CODE not between", value1, value2, "countyCode");
            return (Criteria) this;
        }

        public Criteria andCertAddrIsNull() {
            addCriterion("CERT_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andCertAddrIsNotNull() {
            addCriterion("CERT_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andCertAddrEqualTo(String value) {
            addCriterion("CERT_ADDR =", value, "certAddr");
            return (Criteria) this;
        }

        public Criteria andCertAddrNotEqualTo(String value) {
            addCriterion("CERT_ADDR <>", value, "certAddr");
            return (Criteria) this;
        }

        public Criteria andCertAddrGreaterThan(String value) {
            addCriterion("CERT_ADDR >", value, "certAddr");
            return (Criteria) this;
        }

        public Criteria andCertAddrGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_ADDR >=", value, "certAddr");
            return (Criteria) this;
        }

        public Criteria andCertAddrLessThan(String value) {
            addCriterion("CERT_ADDR <", value, "certAddr");
            return (Criteria) this;
        }

        public Criteria andCertAddrLessThanOrEqualTo(String value) {
            addCriterion("CERT_ADDR <=", value, "certAddr");
            return (Criteria) this;
        }

        public Criteria andCertAddrLike(String value) {
            addCriterion("CERT_ADDR like", value, "certAddr");
            return (Criteria) this;
        }

        public Criteria andCertAddrNotLike(String value) {
            addCriterion("CERT_ADDR not like", value, "certAddr");
            return (Criteria) this;
        }

        public Criteria andCertAddrIn(List<String> values) {
            addCriterion("CERT_ADDR in", values, "certAddr");
            return (Criteria) this;
        }

        public Criteria andCertAddrNotIn(List<String> values) {
            addCriterion("CERT_ADDR not in", values, "certAddr");
            return (Criteria) this;
        }

        public Criteria andCertAddrBetween(String value1, String value2) {
            addCriterion("CERT_ADDR between", value1, value2, "certAddr");
            return (Criteria) this;
        }

        public Criteria andCertAddrNotBetween(String value1, String value2) {
            addCriterion("CERT_ADDR not between", value1, value2, "certAddr");
            return (Criteria) this;
        }

        public Criteria andCertIssueDateIsNull() {
            addCriterion("CERT_ISSUE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCertIssueDateIsNotNull() {
            addCriterion("CERT_ISSUE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCertIssueDateEqualTo(Timestamp value) {
            addCriterion("CERT_ISSUE_DATE =", value, "certIssueDate");
            return (Criteria) this;
        }

        public Criteria andCertIssueDateNotEqualTo(Timestamp value) {
            addCriterion("CERT_ISSUE_DATE <>", value, "certIssueDate");
            return (Criteria) this;
        }

        public Criteria andCertIssueDateGreaterThan(Timestamp value) {
            addCriterion("CERT_ISSUE_DATE >", value, "certIssueDate");
            return (Criteria) this;
        }

        public Criteria andCertIssueDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("CERT_ISSUE_DATE >=", value, "certIssueDate");
            return (Criteria) this;
        }

        public Criteria andCertIssueDateLessThan(Timestamp value) {
            addCriterion("CERT_ISSUE_DATE <", value, "certIssueDate");
            return (Criteria) this;
        }

        public Criteria andCertIssueDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("CERT_ISSUE_DATE <=", value, "certIssueDate");
            return (Criteria) this;
        }

        public Criteria andCertIssueDateIn(List<Timestamp> values) {
            addCriterion("CERT_ISSUE_DATE in", values, "certIssueDate");
            return (Criteria) this;
        }

        public Criteria andCertIssueDateNotIn(List<Timestamp> values) {
            addCriterion("CERT_ISSUE_DATE not in", values, "certIssueDate");
            return (Criteria) this;
        }

        public Criteria andCertIssueDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CERT_ISSUE_DATE between", value1, value2, "certIssueDate");
            return (Criteria) this;
        }

        public Criteria andCertIssueDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CERT_ISSUE_DATE not between", value1, value2, "certIssueDate");
            return (Criteria) this;
        }

        public Criteria andCertIssueOrgIsNull() {
            addCriterion("CERT_ISSUE_ORG is null");
            return (Criteria) this;
        }

        public Criteria andCertIssueOrgIsNotNull() {
            addCriterion("CERT_ISSUE_ORG is not null");
            return (Criteria) this;
        }

        public Criteria andCertIssueOrgEqualTo(String value) {
            addCriterion("CERT_ISSUE_ORG =", value, "certIssueOrg");
            return (Criteria) this;
        }

        public Criteria andCertIssueOrgNotEqualTo(String value) {
            addCriterion("CERT_ISSUE_ORG <>", value, "certIssueOrg");
            return (Criteria) this;
        }

        public Criteria andCertIssueOrgGreaterThan(String value) {
            addCriterion("CERT_ISSUE_ORG >", value, "certIssueOrg");
            return (Criteria) this;
        }

        public Criteria andCertIssueOrgGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_ISSUE_ORG >=", value, "certIssueOrg");
            return (Criteria) this;
        }

        public Criteria andCertIssueOrgLessThan(String value) {
            addCriterion("CERT_ISSUE_ORG <", value, "certIssueOrg");
            return (Criteria) this;
        }

        public Criteria andCertIssueOrgLessThanOrEqualTo(String value) {
            addCriterion("CERT_ISSUE_ORG <=", value, "certIssueOrg");
            return (Criteria) this;
        }

        public Criteria andCertIssueOrgLike(String value) {
            addCriterion("CERT_ISSUE_ORG like", value, "certIssueOrg");
            return (Criteria) this;
        }

        public Criteria andCertIssueOrgNotLike(String value) {
            addCriterion("CERT_ISSUE_ORG not like", value, "certIssueOrg");
            return (Criteria) this;
        }

        public Criteria andCertIssueOrgIn(List<String> values) {
            addCriterion("CERT_ISSUE_ORG in", values, "certIssueOrg");
            return (Criteria) this;
        }

        public Criteria andCertIssueOrgNotIn(List<String> values) {
            addCriterion("CERT_ISSUE_ORG not in", values, "certIssueOrg");
            return (Criteria) this;
        }

        public Criteria andCertIssueOrgBetween(String value1, String value2) {
            addCriterion("CERT_ISSUE_ORG between", value1, value2, "certIssueOrg");
            return (Criteria) this;
        }

        public Criteria andCertIssueOrgNotBetween(String value1, String value2) {
            addCriterion("CERT_ISSUE_ORG not between", value1, value2, "certIssueOrg");
            return (Criteria) this;
        }

        public Criteria andCertValidDateIsNull() {
            addCriterion("CERT_VALID_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCertValidDateIsNotNull() {
            addCriterion("CERT_VALID_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCertValidDateEqualTo(Timestamp value) {
            addCriterion("CERT_VALID_DATE =", value, "certValidDate");
            return (Criteria) this;
        }

        public Criteria andCertValidDateNotEqualTo(Timestamp value) {
            addCriterion("CERT_VALID_DATE <>", value, "certValidDate");
            return (Criteria) this;
        }

        public Criteria andCertValidDateGreaterThan(Timestamp value) {
            addCriterion("CERT_VALID_DATE >", value, "certValidDate");
            return (Criteria) this;
        }

        public Criteria andCertValidDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("CERT_VALID_DATE >=", value, "certValidDate");
            return (Criteria) this;
        }

        public Criteria andCertValidDateLessThan(Timestamp value) {
            addCriterion("CERT_VALID_DATE <", value, "certValidDate");
            return (Criteria) this;
        }

        public Criteria andCertValidDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("CERT_VALID_DATE <=", value, "certValidDate");
            return (Criteria) this;
        }

        public Criteria andCertValidDateIn(List<Timestamp> values) {
            addCriterion("CERT_VALID_DATE in", values, "certValidDate");
            return (Criteria) this;
        }

        public Criteria andCertValidDateNotIn(List<Timestamp> values) {
            addCriterion("CERT_VALID_DATE not in", values, "certValidDate");
            return (Criteria) this;
        }

        public Criteria andCertValidDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CERT_VALID_DATE between", value1, value2, "certValidDate");
            return (Criteria) this;
        }

        public Criteria andCertValidDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CERT_VALID_DATE not between", value1, value2, "certValidDate");
            return (Criteria) this;
        }

        public Criteria andCertInvalidDateIsNull() {
            addCriterion("CERT_INVALID_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCertInvalidDateIsNotNull() {
            addCriterion("CERT_INVALID_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCertInvalidDateEqualTo(Timestamp value) {
            addCriterion("CERT_INVALID_DATE =", value, "certInvalidDate");
            return (Criteria) this;
        }

        public Criteria andCertInvalidDateNotEqualTo(Timestamp value) {
            addCriterion("CERT_INVALID_DATE <>", value, "certInvalidDate");
            return (Criteria) this;
        }

        public Criteria andCertInvalidDateGreaterThan(Timestamp value) {
            addCriterion("CERT_INVALID_DATE >", value, "certInvalidDate");
            return (Criteria) this;
        }

        public Criteria andCertInvalidDateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("CERT_INVALID_DATE >=", value, "certInvalidDate");
            return (Criteria) this;
        }

        public Criteria andCertInvalidDateLessThan(Timestamp value) {
            addCriterion("CERT_INVALID_DATE <", value, "certInvalidDate");
            return (Criteria) this;
        }

        public Criteria andCertInvalidDateLessThanOrEqualTo(Timestamp value) {
            addCriterion("CERT_INVALID_DATE <=", value, "certInvalidDate");
            return (Criteria) this;
        }

        public Criteria andCertInvalidDateIn(List<Timestamp> values) {
            addCriterion("CERT_INVALID_DATE in", values, "certInvalidDate");
            return (Criteria) this;
        }

        public Criteria andCertInvalidDateNotIn(List<Timestamp> values) {
            addCriterion("CERT_INVALID_DATE not in", values, "certInvalidDate");
            return (Criteria) this;
        }

        public Criteria andCertInvalidDateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CERT_INVALID_DATE between", value1, value2, "certInvalidDate");
            return (Criteria) this;
        }

        public Criteria andCertInvalidDateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CERT_INVALID_DATE not between", value1, value2, "certInvalidDate");
            return (Criteria) this;
        }

        public Criteria andCustSexIsNull() {
            addCriterion("CUST_SEX is null");
            return (Criteria) this;
        }

        public Criteria andCustSexIsNotNull() {
            addCriterion("CUST_SEX is not null");
            return (Criteria) this;
        }

        public Criteria andCustSexEqualTo(String value) {
            addCriterion("CUST_SEX =", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexNotEqualTo(String value) {
            addCriterion("CUST_SEX <>", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexGreaterThan(String value) {
            addCriterion("CUST_SEX >", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_SEX >=", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexLessThan(String value) {
            addCriterion("CUST_SEX <", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexLessThanOrEqualTo(String value) {
            addCriterion("CUST_SEX <=", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexLike(String value) {
            addCriterion("CUST_SEX like", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexNotLike(String value) {
            addCriterion("CUST_SEX not like", value, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexIn(List<String> values) {
            addCriterion("CUST_SEX in", values, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexNotIn(List<String> values) {
            addCriterion("CUST_SEX not in", values, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexBetween(String value1, String value2) {
            addCriterion("CUST_SEX between", value1, value2, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustSexNotBetween(String value1, String value2) {
            addCriterion("CUST_SEX not between", value1, value2, "custSex");
            return (Criteria) this;
        }

        public Criteria andCustBirthdayIsNull() {
            addCriterion("CUST_BIRTHDAY is null");
            return (Criteria) this;
        }

        public Criteria andCustBirthdayIsNotNull() {
            addCriterion("CUST_BIRTHDAY is not null");
            return (Criteria) this;
        }

        public Criteria andCustBirthdayEqualTo(Timestamp value) {
            addCriterion("CUST_BIRTHDAY =", value, "custBirthday");
            return (Criteria) this;
        }

        public Criteria andCustBirthdayNotEqualTo(Timestamp value) {
            addCriterion("CUST_BIRTHDAY <>", value, "custBirthday");
            return (Criteria) this;
        }

        public Criteria andCustBirthdayGreaterThan(Timestamp value) {
            addCriterion("CUST_BIRTHDAY >", value, "custBirthday");
            return (Criteria) this;
        }

        public Criteria andCustBirthdayGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("CUST_BIRTHDAY >=", value, "custBirthday");
            return (Criteria) this;
        }

        public Criteria andCustBirthdayLessThan(Timestamp value) {
            addCriterion("CUST_BIRTHDAY <", value, "custBirthday");
            return (Criteria) this;
        }

        public Criteria andCustBirthdayLessThanOrEqualTo(Timestamp value) {
            addCriterion("CUST_BIRTHDAY <=", value, "custBirthday");
            return (Criteria) this;
        }

        public Criteria andCustBirthdayIn(List<Timestamp> values) {
            addCriterion("CUST_BIRTHDAY in", values, "custBirthday");
            return (Criteria) this;
        }

        public Criteria andCustBirthdayNotIn(List<Timestamp> values) {
            addCriterion("CUST_BIRTHDAY not in", values, "custBirthday");
            return (Criteria) this;
        }

        public Criteria andCustBirthdayBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CUST_BIRTHDAY between", value1, value2, "custBirthday");
            return (Criteria) this;
        }

        public Criteria andCustBirthdayNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CUST_BIRTHDAY not between", value1, value2, "custBirthday");
            return (Criteria) this;
        }

        public Criteria andCustProvinceCodeIsNull() {
            addCriterion("CUST_PROVINCE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCustProvinceCodeIsNotNull() {
            addCriterion("CUST_PROVINCE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCustProvinceCodeEqualTo(String value) {
            addCriterion("CUST_PROVINCE_CODE =", value, "custProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCustProvinceCodeNotEqualTo(String value) {
            addCriterion("CUST_PROVINCE_CODE <>", value, "custProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCustProvinceCodeGreaterThan(String value) {
            addCriterion("CUST_PROVINCE_CODE >", value, "custProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCustProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_PROVINCE_CODE >=", value, "custProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCustProvinceCodeLessThan(String value) {
            addCriterion("CUST_PROVINCE_CODE <", value, "custProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCustProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("CUST_PROVINCE_CODE <=", value, "custProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCustProvinceCodeLike(String value) {
            addCriterion("CUST_PROVINCE_CODE like", value, "custProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCustProvinceCodeNotLike(String value) {
            addCriterion("CUST_PROVINCE_CODE not like", value, "custProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCustProvinceCodeIn(List<String> values) {
            addCriterion("CUST_PROVINCE_CODE in", values, "custProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCustProvinceCodeNotIn(List<String> values) {
            addCriterion("CUST_PROVINCE_CODE not in", values, "custProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCustProvinceCodeBetween(String value1, String value2) {
            addCriterion("CUST_PROVINCE_CODE between", value1, value2, "custProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCustProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("CUST_PROVINCE_CODE not between", value1, value2, "custProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCustCityCodeIsNull() {
            addCriterion("CUST_CITY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCustCityCodeIsNotNull() {
            addCriterion("CUST_CITY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCustCityCodeEqualTo(String value) {
            addCriterion("CUST_CITY_CODE =", value, "custCityCode");
            return (Criteria) this;
        }

        public Criteria andCustCityCodeNotEqualTo(String value) {
            addCriterion("CUST_CITY_CODE <>", value, "custCityCode");
            return (Criteria) this;
        }

        public Criteria andCustCityCodeGreaterThan(String value) {
            addCriterion("CUST_CITY_CODE >", value, "custCityCode");
            return (Criteria) this;
        }

        public Criteria andCustCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_CITY_CODE >=", value, "custCityCode");
            return (Criteria) this;
        }

        public Criteria andCustCityCodeLessThan(String value) {
            addCriterion("CUST_CITY_CODE <", value, "custCityCode");
            return (Criteria) this;
        }

        public Criteria andCustCityCodeLessThanOrEqualTo(String value) {
            addCriterion("CUST_CITY_CODE <=", value, "custCityCode");
            return (Criteria) this;
        }

        public Criteria andCustCityCodeLike(String value) {
            addCriterion("CUST_CITY_CODE like", value, "custCityCode");
            return (Criteria) this;
        }

        public Criteria andCustCityCodeNotLike(String value) {
            addCriterion("CUST_CITY_CODE not like", value, "custCityCode");
            return (Criteria) this;
        }

        public Criteria andCustCityCodeIn(List<String> values) {
            addCriterion("CUST_CITY_CODE in", values, "custCityCode");
            return (Criteria) this;
        }

        public Criteria andCustCityCodeNotIn(List<String> values) {
            addCriterion("CUST_CITY_CODE not in", values, "custCityCode");
            return (Criteria) this;
        }

        public Criteria andCustCityCodeBetween(String value1, String value2) {
            addCriterion("CUST_CITY_CODE between", value1, value2, "custCityCode");
            return (Criteria) this;
        }

        public Criteria andCustCityCodeNotBetween(String value1, String value2) {
            addCriterion("CUST_CITY_CODE not between", value1, value2, "custCityCode");
            return (Criteria) this;
        }

        public Criteria andCustCountyCodeIsNull() {
            addCriterion("CUST_COUNTY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCustCountyCodeIsNotNull() {
            addCriterion("CUST_COUNTY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCustCountyCodeEqualTo(String value) {
            addCriterion("CUST_COUNTY_CODE =", value, "custCountyCode");
            return (Criteria) this;
        }

        public Criteria andCustCountyCodeNotEqualTo(String value) {
            addCriterion("CUST_COUNTY_CODE <>", value, "custCountyCode");
            return (Criteria) this;
        }

        public Criteria andCustCountyCodeGreaterThan(String value) {
            addCriterion("CUST_COUNTY_CODE >", value, "custCountyCode");
            return (Criteria) this;
        }

        public Criteria andCustCountyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_COUNTY_CODE >=", value, "custCountyCode");
            return (Criteria) this;
        }

        public Criteria andCustCountyCodeLessThan(String value) {
            addCriterion("CUST_COUNTY_CODE <", value, "custCountyCode");
            return (Criteria) this;
        }

        public Criteria andCustCountyCodeLessThanOrEqualTo(String value) {
            addCriterion("CUST_COUNTY_CODE <=", value, "custCountyCode");
            return (Criteria) this;
        }

        public Criteria andCustCountyCodeLike(String value) {
            addCriterion("CUST_COUNTY_CODE like", value, "custCountyCode");
            return (Criteria) this;
        }

        public Criteria andCustCountyCodeNotLike(String value) {
            addCriterion("CUST_COUNTY_CODE not like", value, "custCountyCode");
            return (Criteria) this;
        }

        public Criteria andCustCountyCodeIn(List<String> values) {
            addCriterion("CUST_COUNTY_CODE in", values, "custCountyCode");
            return (Criteria) this;
        }

        public Criteria andCustCountyCodeNotIn(List<String> values) {
            addCriterion("CUST_COUNTY_CODE not in", values, "custCountyCode");
            return (Criteria) this;
        }

        public Criteria andCustCountyCodeBetween(String value1, String value2) {
            addCriterion("CUST_COUNTY_CODE between", value1, value2, "custCountyCode");
            return (Criteria) this;
        }

        public Criteria andCustCountyCodeNotBetween(String value1, String value2) {
            addCriterion("CUST_COUNTY_CODE not between", value1, value2, "custCountyCode");
            return (Criteria) this;
        }

        public Criteria andCustAddrIsNull() {
            addCriterion("CUST_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andCustAddrIsNotNull() {
            addCriterion("CUST_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andCustAddrEqualTo(String value) {
            addCriterion("CUST_ADDR =", value, "custAddr");
            return (Criteria) this;
        }

        public Criteria andCustAddrNotEqualTo(String value) {
            addCriterion("CUST_ADDR <>", value, "custAddr");
            return (Criteria) this;
        }

        public Criteria andCustAddrGreaterThan(String value) {
            addCriterion("CUST_ADDR >", value, "custAddr");
            return (Criteria) this;
        }

        public Criteria andCustAddrGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_ADDR >=", value, "custAddr");
            return (Criteria) this;
        }

        public Criteria andCustAddrLessThan(String value) {
            addCriterion("CUST_ADDR <", value, "custAddr");
            return (Criteria) this;
        }

        public Criteria andCustAddrLessThanOrEqualTo(String value) {
            addCriterion("CUST_ADDR <=", value, "custAddr");
            return (Criteria) this;
        }

        public Criteria andCustAddrLike(String value) {
            addCriterion("CUST_ADDR like", value, "custAddr");
            return (Criteria) this;
        }

        public Criteria andCustAddrNotLike(String value) {
            addCriterion("CUST_ADDR not like", value, "custAddr");
            return (Criteria) this;
        }

        public Criteria andCustAddrIn(List<String> values) {
            addCriterion("CUST_ADDR in", values, "custAddr");
            return (Criteria) this;
        }

        public Criteria andCustAddrNotIn(List<String> values) {
            addCriterion("CUST_ADDR not in", values, "custAddr");
            return (Criteria) this;
        }

        public Criteria andCustAddrBetween(String value1, String value2) {
            addCriterion("CUST_ADDR between", value1, value2, "custAddr");
            return (Criteria) this;
        }

        public Criteria andCustAddrNotBetween(String value1, String value2) {
            addCriterion("CUST_ADDR not between", value1, value2, "custAddr");
            return (Criteria) this;
        }

        public Criteria andIncomeLevelIsNull() {
            addCriterion("INCOME_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andIncomeLevelIsNotNull() {
            addCriterion("INCOME_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeLevelEqualTo(String value) {
            addCriterion("INCOME_LEVEL =", value, "incomeLevel");
            return (Criteria) this;
        }

        public Criteria andIncomeLevelNotEqualTo(String value) {
            addCriterion("INCOME_LEVEL <>", value, "incomeLevel");
            return (Criteria) this;
        }

        public Criteria andIncomeLevelGreaterThan(String value) {
            addCriterion("INCOME_LEVEL >", value, "incomeLevel");
            return (Criteria) this;
        }

        public Criteria andIncomeLevelGreaterThanOrEqualTo(String value) {
            addCriterion("INCOME_LEVEL >=", value, "incomeLevel");
            return (Criteria) this;
        }

        public Criteria andIncomeLevelLessThan(String value) {
            addCriterion("INCOME_LEVEL <", value, "incomeLevel");
            return (Criteria) this;
        }

        public Criteria andIncomeLevelLessThanOrEqualTo(String value) {
            addCriterion("INCOME_LEVEL <=", value, "incomeLevel");
            return (Criteria) this;
        }

        public Criteria andIncomeLevelLike(String value) {
            addCriterion("INCOME_LEVEL like", value, "incomeLevel");
            return (Criteria) this;
        }

        public Criteria andIncomeLevelNotLike(String value) {
            addCriterion("INCOME_LEVEL not like", value, "incomeLevel");
            return (Criteria) this;
        }

        public Criteria andIncomeLevelIn(List<String> values) {
            addCriterion("INCOME_LEVEL in", values, "incomeLevel");
            return (Criteria) this;
        }

        public Criteria andIncomeLevelNotIn(List<String> values) {
            addCriterion("INCOME_LEVEL not in", values, "incomeLevel");
            return (Criteria) this;
        }

        public Criteria andIncomeLevelBetween(String value1, String value2) {
            addCriterion("INCOME_LEVEL between", value1, value2, "incomeLevel");
            return (Criteria) this;
        }

        public Criteria andIncomeLevelNotBetween(String value1, String value2) {
            addCriterion("INCOME_LEVEL not between", value1, value2, "incomeLevel");
            return (Criteria) this;
        }

        public Criteria andCustIndustryIsNull() {
            addCriterion("CUST_INDUSTRY is null");
            return (Criteria) this;
        }

        public Criteria andCustIndustryIsNotNull() {
            addCriterion("CUST_INDUSTRY is not null");
            return (Criteria) this;
        }

        public Criteria andCustIndustryEqualTo(String value) {
            addCriterion("CUST_INDUSTRY =", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryNotEqualTo(String value) {
            addCriterion("CUST_INDUSTRY <>", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryGreaterThan(String value) {
            addCriterion("CUST_INDUSTRY >", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_INDUSTRY >=", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryLessThan(String value) {
            addCriterion("CUST_INDUSTRY <", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryLessThanOrEqualTo(String value) {
            addCriterion("CUST_INDUSTRY <=", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryLike(String value) {
            addCriterion("CUST_INDUSTRY like", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryNotLike(String value) {
            addCriterion("CUST_INDUSTRY not like", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryIn(List<String> values) {
            addCriterion("CUST_INDUSTRY in", values, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryNotIn(List<String> values) {
            addCriterion("CUST_INDUSTRY not in", values, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryBetween(String value1, String value2) {
            addCriterion("CUST_INDUSTRY between", value1, value2, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryNotBetween(String value1, String value2) {
            addCriterion("CUST_INDUSTRY not between", value1, value2, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustEducationIsNull() {
            addCriterion("CUST_EDUCATION is null");
            return (Criteria) this;
        }

        public Criteria andCustEducationIsNotNull() {
            addCriterion("CUST_EDUCATION is not null");
            return (Criteria) this;
        }

        public Criteria andCustEducationEqualTo(String value) {
            addCriterion("CUST_EDUCATION =", value, "custEducation");
            return (Criteria) this;
        }

        public Criteria andCustEducationNotEqualTo(String value) {
            addCriterion("CUST_EDUCATION <>", value, "custEducation");
            return (Criteria) this;
        }

        public Criteria andCustEducationGreaterThan(String value) {
            addCriterion("CUST_EDUCATION >", value, "custEducation");
            return (Criteria) this;
        }

        public Criteria andCustEducationGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_EDUCATION >=", value, "custEducation");
            return (Criteria) this;
        }

        public Criteria andCustEducationLessThan(String value) {
            addCriterion("CUST_EDUCATION <", value, "custEducation");
            return (Criteria) this;
        }

        public Criteria andCustEducationLessThanOrEqualTo(String value) {
            addCriterion("CUST_EDUCATION <=", value, "custEducation");
            return (Criteria) this;
        }

        public Criteria andCustEducationLike(String value) {
            addCriterion("CUST_EDUCATION like", value, "custEducation");
            return (Criteria) this;
        }

        public Criteria andCustEducationNotLike(String value) {
            addCriterion("CUST_EDUCATION not like", value, "custEducation");
            return (Criteria) this;
        }

        public Criteria andCustEducationIn(List<String> values) {
            addCriterion("CUST_EDUCATION in", values, "custEducation");
            return (Criteria) this;
        }

        public Criteria andCustEducationNotIn(List<String> values) {
            addCriterion("CUST_EDUCATION not in", values, "custEducation");
            return (Criteria) this;
        }

        public Criteria andCustEducationBetween(String value1, String value2) {
            addCriterion("CUST_EDUCATION between", value1, value2, "custEducation");
            return (Criteria) this;
        }

        public Criteria andCustEducationNotBetween(String value1, String value2) {
            addCriterion("CUST_EDUCATION not between", value1, value2, "custEducation");
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

        public Criteria andPersonalRemarkIsNull() {
            addCriterion("PERSONAL_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andPersonalRemarkIsNotNull() {
            addCriterion("PERSONAL_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalRemarkEqualTo(String value) {
            addCriterion("PERSONAL_REMARK =", value, "personalRemark");
            return (Criteria) this;
        }

        public Criteria andPersonalRemarkNotEqualTo(String value) {
            addCriterion("PERSONAL_REMARK <>", value, "personalRemark");
            return (Criteria) this;
        }

        public Criteria andPersonalRemarkGreaterThan(String value) {
            addCriterion("PERSONAL_REMARK >", value, "personalRemark");
            return (Criteria) this;
        }

        public Criteria andPersonalRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("PERSONAL_REMARK >=", value, "personalRemark");
            return (Criteria) this;
        }

        public Criteria andPersonalRemarkLessThan(String value) {
            addCriterion("PERSONAL_REMARK <", value, "personalRemark");
            return (Criteria) this;
        }

        public Criteria andPersonalRemarkLessThanOrEqualTo(String value) {
            addCriterion("PERSONAL_REMARK <=", value, "personalRemark");
            return (Criteria) this;
        }

        public Criteria andPersonalRemarkLike(String value) {
            addCriterion("PERSONAL_REMARK like", value, "personalRemark");
            return (Criteria) this;
        }

        public Criteria andPersonalRemarkNotLike(String value) {
            addCriterion("PERSONAL_REMARK not like", value, "personalRemark");
            return (Criteria) this;
        }

        public Criteria andPersonalRemarkIn(List<String> values) {
            addCriterion("PERSONAL_REMARK in", values, "personalRemark");
            return (Criteria) this;
        }

        public Criteria andPersonalRemarkNotIn(List<String> values) {
            addCriterion("PERSONAL_REMARK not in", values, "personalRemark");
            return (Criteria) this;
        }

        public Criteria andPersonalRemarkBetween(String value1, String value2) {
            addCriterion("PERSONAL_REMARK between", value1, value2, "personalRemark");
            return (Criteria) this;
        }

        public Criteria andPersonalRemarkNotBetween(String value1, String value2) {
            addCriterion("PERSONAL_REMARK not between", value1, value2, "personalRemark");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagIsNull() {
            addCriterion("VERIFY_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagIsNotNull() {
            addCriterion("VERIFY_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagEqualTo(String value) {
            addCriterion("VERIFY_FLAG =", value, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagNotEqualTo(String value) {
            addCriterion("VERIFY_FLAG <>", value, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagGreaterThan(String value) {
            addCriterion("VERIFY_FLAG >", value, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagGreaterThanOrEqualTo(String value) {
            addCriterion("VERIFY_FLAG >=", value, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagLessThan(String value) {
            addCriterion("VERIFY_FLAG <", value, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagLessThanOrEqualTo(String value) {
            addCriterion("VERIFY_FLAG <=", value, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagLike(String value) {
            addCriterion("VERIFY_FLAG like", value, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagNotLike(String value) {
            addCriterion("VERIFY_FLAG not like", value, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagIn(List<String> values) {
            addCriterion("VERIFY_FLAG in", values, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagNotIn(List<String> values) {
            addCriterion("VERIFY_FLAG not in", values, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagBetween(String value1, String value2) {
            addCriterion("VERIFY_FLAG between", value1, value2, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andVerifyFlagNotBetween(String value1, String value2) {
            addCriterion("VERIFY_FLAG not between", value1, value2, "verifyFlag");
            return (Criteria) this;
        }

        public Criteria andAuditStateIsNull() {
            addCriterion("AUDIT_STATE is null");
            return (Criteria) this;
        }

        public Criteria andAuditStateIsNotNull() {
            addCriterion("AUDIT_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStateEqualTo(String value) {
            addCriterion("AUDIT_STATE =", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateNotEqualTo(String value) {
            addCriterion("AUDIT_STATE <>", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateGreaterThan(String value) {
            addCriterion("AUDIT_STATE >", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateGreaterThanOrEqualTo(String value) {
            addCriterion("AUDIT_STATE >=", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateLessThan(String value) {
            addCriterion("AUDIT_STATE <", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateLessThanOrEqualTo(String value) {
            addCriterion("AUDIT_STATE <=", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateLike(String value) {
            addCriterion("AUDIT_STATE like", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateNotLike(String value) {
            addCriterion("AUDIT_STATE not like", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateIn(List<String> values) {
            addCriterion("AUDIT_STATE in", values, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateNotIn(List<String> values) {
            addCriterion("AUDIT_STATE not in", values, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateBetween(String value1, String value2) {
            addCriterion("AUDIT_STATE between", value1, value2, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateNotBetween(String value1, String value2) {
            addCriterion("AUDIT_STATE not between", value1, value2, "auditState");
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