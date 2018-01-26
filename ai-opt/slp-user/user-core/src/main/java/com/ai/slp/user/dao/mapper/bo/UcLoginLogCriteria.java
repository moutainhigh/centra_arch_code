package com.ai.slp.user.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UcLoginLogCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public UcLoginLogCriteria() {
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

        public Criteria andLoginSeqIdIsNull() {
            addCriterion("LOGIN_SEQ_ID is null");
            return (Criteria) this;
        }

        public Criteria andLoginSeqIdIsNotNull() {
            addCriterion("LOGIN_SEQ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLoginSeqIdEqualTo(String value) {
            addCriterion("LOGIN_SEQ_ID =", value, "loginSeqId");
            return (Criteria) this;
        }

        public Criteria andLoginSeqIdNotEqualTo(String value) {
            addCriterion("LOGIN_SEQ_ID <>", value, "loginSeqId");
            return (Criteria) this;
        }

        public Criteria andLoginSeqIdGreaterThan(String value) {
            addCriterion("LOGIN_SEQ_ID >", value, "loginSeqId");
            return (Criteria) this;
        }

        public Criteria andLoginSeqIdGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_SEQ_ID >=", value, "loginSeqId");
            return (Criteria) this;
        }

        public Criteria andLoginSeqIdLessThan(String value) {
            addCriterion("LOGIN_SEQ_ID <", value, "loginSeqId");
            return (Criteria) this;
        }

        public Criteria andLoginSeqIdLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_SEQ_ID <=", value, "loginSeqId");
            return (Criteria) this;
        }

        public Criteria andLoginSeqIdLike(String value) {
            addCriterion("LOGIN_SEQ_ID like", value, "loginSeqId");
            return (Criteria) this;
        }

        public Criteria andLoginSeqIdNotLike(String value) {
            addCriterion("LOGIN_SEQ_ID not like", value, "loginSeqId");
            return (Criteria) this;
        }

        public Criteria andLoginSeqIdIn(List<String> values) {
            addCriterion("LOGIN_SEQ_ID in", values, "loginSeqId");
            return (Criteria) this;
        }

        public Criteria andLoginSeqIdNotIn(List<String> values) {
            addCriterion("LOGIN_SEQ_ID not in", values, "loginSeqId");
            return (Criteria) this;
        }

        public Criteria andLoginSeqIdBetween(String value1, String value2) {
            addCriterion("LOGIN_SEQ_ID between", value1, value2, "loginSeqId");
            return (Criteria) this;
        }

        public Criteria andLoginSeqIdNotBetween(String value1, String value2) {
            addCriterion("LOGIN_SEQ_ID not between", value1, value2, "loginSeqId");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNull() {
            addCriterion("LOGIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNotNull() {
            addCriterion("LOGIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeEqualTo(Timestamp value) {
            addCriterion("LOGIN_TIME =", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotEqualTo(Timestamp value) {
            addCriterion("LOGIN_TIME <>", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThan(Timestamp value) {
            addCriterion("LOGIN_TIME >", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("LOGIN_TIME >=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThan(Timestamp value) {
            addCriterion("LOGIN_TIME <", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("LOGIN_TIME <=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIn(List<Timestamp> values) {
            addCriterion("LOGIN_TIME in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotIn(List<Timestamp> values) {
            addCriterion("LOGIN_TIME not in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("LOGIN_TIME between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("LOGIN_TIME not between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginProvineIsNull() {
            addCriterion("LOGIN_PROVINE is null");
            return (Criteria) this;
        }

        public Criteria andLoginProvineIsNotNull() {
            addCriterion("LOGIN_PROVINE is not null");
            return (Criteria) this;
        }

        public Criteria andLoginProvineEqualTo(String value) {
            addCriterion("LOGIN_PROVINE =", value, "loginProvine");
            return (Criteria) this;
        }

        public Criteria andLoginProvineNotEqualTo(String value) {
            addCriterion("LOGIN_PROVINE <>", value, "loginProvine");
            return (Criteria) this;
        }

        public Criteria andLoginProvineGreaterThan(String value) {
            addCriterion("LOGIN_PROVINE >", value, "loginProvine");
            return (Criteria) this;
        }

        public Criteria andLoginProvineGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_PROVINE >=", value, "loginProvine");
            return (Criteria) this;
        }

        public Criteria andLoginProvineLessThan(String value) {
            addCriterion("LOGIN_PROVINE <", value, "loginProvine");
            return (Criteria) this;
        }

        public Criteria andLoginProvineLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_PROVINE <=", value, "loginProvine");
            return (Criteria) this;
        }

        public Criteria andLoginProvineLike(String value) {
            addCriterion("LOGIN_PROVINE like", value, "loginProvine");
            return (Criteria) this;
        }

        public Criteria andLoginProvineNotLike(String value) {
            addCriterion("LOGIN_PROVINE not like", value, "loginProvine");
            return (Criteria) this;
        }

        public Criteria andLoginProvineIn(List<String> values) {
            addCriterion("LOGIN_PROVINE in", values, "loginProvine");
            return (Criteria) this;
        }

        public Criteria andLoginProvineNotIn(List<String> values) {
            addCriterion("LOGIN_PROVINE not in", values, "loginProvine");
            return (Criteria) this;
        }

        public Criteria andLoginProvineBetween(String value1, String value2) {
            addCriterion("LOGIN_PROVINE between", value1, value2, "loginProvine");
            return (Criteria) this;
        }

        public Criteria andLoginProvineNotBetween(String value1, String value2) {
            addCriterion("LOGIN_PROVINE not between", value1, value2, "loginProvine");
            return (Criteria) this;
        }

        public Criteria andLoginCityIsNull() {
            addCriterion("LOGIN_CITY is null");
            return (Criteria) this;
        }

        public Criteria andLoginCityIsNotNull() {
            addCriterion("LOGIN_CITY is not null");
            return (Criteria) this;
        }

        public Criteria andLoginCityEqualTo(String value) {
            addCriterion("LOGIN_CITY =", value, "loginCity");
            return (Criteria) this;
        }

        public Criteria andLoginCityNotEqualTo(String value) {
            addCriterion("LOGIN_CITY <>", value, "loginCity");
            return (Criteria) this;
        }

        public Criteria andLoginCityGreaterThan(String value) {
            addCriterion("LOGIN_CITY >", value, "loginCity");
            return (Criteria) this;
        }

        public Criteria andLoginCityGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_CITY >=", value, "loginCity");
            return (Criteria) this;
        }

        public Criteria andLoginCityLessThan(String value) {
            addCriterion("LOGIN_CITY <", value, "loginCity");
            return (Criteria) this;
        }

        public Criteria andLoginCityLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_CITY <=", value, "loginCity");
            return (Criteria) this;
        }

        public Criteria andLoginCityLike(String value) {
            addCriterion("LOGIN_CITY like", value, "loginCity");
            return (Criteria) this;
        }

        public Criteria andLoginCityNotLike(String value) {
            addCriterion("LOGIN_CITY not like", value, "loginCity");
            return (Criteria) this;
        }

        public Criteria andLoginCityIn(List<String> values) {
            addCriterion("LOGIN_CITY in", values, "loginCity");
            return (Criteria) this;
        }

        public Criteria andLoginCityNotIn(List<String> values) {
            addCriterion("LOGIN_CITY not in", values, "loginCity");
            return (Criteria) this;
        }

        public Criteria andLoginCityBetween(String value1, String value2) {
            addCriterion("LOGIN_CITY between", value1, value2, "loginCity");
            return (Criteria) this;
        }

        public Criteria andLoginCityNotBetween(String value1, String value2) {
            addCriterion("LOGIN_CITY not between", value1, value2, "loginCity");
            return (Criteria) this;
        }

        public Criteria andLoginIpAddrIsNull() {
            addCriterion("LOGIN_IP_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andLoginIpAddrIsNotNull() {
            addCriterion("LOGIN_IP_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andLoginIpAddrEqualTo(String value) {
            addCriterion("LOGIN_IP_ADDR =", value, "loginIpAddr");
            return (Criteria) this;
        }

        public Criteria andLoginIpAddrNotEqualTo(String value) {
            addCriterion("LOGIN_IP_ADDR <>", value, "loginIpAddr");
            return (Criteria) this;
        }

        public Criteria andLoginIpAddrGreaterThan(String value) {
            addCriterion("LOGIN_IP_ADDR >", value, "loginIpAddr");
            return (Criteria) this;
        }

        public Criteria andLoginIpAddrGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_IP_ADDR >=", value, "loginIpAddr");
            return (Criteria) this;
        }

        public Criteria andLoginIpAddrLessThan(String value) {
            addCriterion("LOGIN_IP_ADDR <", value, "loginIpAddr");
            return (Criteria) this;
        }

        public Criteria andLoginIpAddrLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_IP_ADDR <=", value, "loginIpAddr");
            return (Criteria) this;
        }

        public Criteria andLoginIpAddrLike(String value) {
            addCriterion("LOGIN_IP_ADDR like", value, "loginIpAddr");
            return (Criteria) this;
        }

        public Criteria andLoginIpAddrNotLike(String value) {
            addCriterion("LOGIN_IP_ADDR not like", value, "loginIpAddr");
            return (Criteria) this;
        }

        public Criteria andLoginIpAddrIn(List<String> values) {
            addCriterion("LOGIN_IP_ADDR in", values, "loginIpAddr");
            return (Criteria) this;
        }

        public Criteria andLoginIpAddrNotIn(List<String> values) {
            addCriterion("LOGIN_IP_ADDR not in", values, "loginIpAddr");
            return (Criteria) this;
        }

        public Criteria andLoginIpAddrBetween(String value1, String value2) {
            addCriterion("LOGIN_IP_ADDR between", value1, value2, "loginIpAddr");
            return (Criteria) this;
        }

        public Criteria andLoginIpAddrNotBetween(String value1, String value2) {
            addCriterion("LOGIN_IP_ADDR not between", value1, value2, "loginIpAddr");
            return (Criteria) this;
        }

        public Criteria andPhoneProvineIsNull() {
            addCriterion("PHONE_PROVINE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneProvineIsNotNull() {
            addCriterion("PHONE_PROVINE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneProvineEqualTo(String value) {
            addCriterion("PHONE_PROVINE =", value, "phoneProvine");
            return (Criteria) this;
        }

        public Criteria andPhoneProvineNotEqualTo(String value) {
            addCriterion("PHONE_PROVINE <>", value, "phoneProvine");
            return (Criteria) this;
        }

        public Criteria andPhoneProvineGreaterThan(String value) {
            addCriterion("PHONE_PROVINE >", value, "phoneProvine");
            return (Criteria) this;
        }

        public Criteria andPhoneProvineGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE_PROVINE >=", value, "phoneProvine");
            return (Criteria) this;
        }

        public Criteria andPhoneProvineLessThan(String value) {
            addCriterion("PHONE_PROVINE <", value, "phoneProvine");
            return (Criteria) this;
        }

        public Criteria andPhoneProvineLessThanOrEqualTo(String value) {
            addCriterion("PHONE_PROVINE <=", value, "phoneProvine");
            return (Criteria) this;
        }

        public Criteria andPhoneProvineLike(String value) {
            addCriterion("PHONE_PROVINE like", value, "phoneProvine");
            return (Criteria) this;
        }

        public Criteria andPhoneProvineNotLike(String value) {
            addCriterion("PHONE_PROVINE not like", value, "phoneProvine");
            return (Criteria) this;
        }

        public Criteria andPhoneProvineIn(List<String> values) {
            addCriterion("PHONE_PROVINE in", values, "phoneProvine");
            return (Criteria) this;
        }

        public Criteria andPhoneProvineNotIn(List<String> values) {
            addCriterion("PHONE_PROVINE not in", values, "phoneProvine");
            return (Criteria) this;
        }

        public Criteria andPhoneProvineBetween(String value1, String value2) {
            addCriterion("PHONE_PROVINE between", value1, value2, "phoneProvine");
            return (Criteria) this;
        }

        public Criteria andPhoneProvineNotBetween(String value1, String value2) {
            addCriterion("PHONE_PROVINE not between", value1, value2, "phoneProvine");
            return (Criteria) this;
        }

        public Criteria andPhoneCityIsNull() {
            addCriterion("PHONE_CITY is null");
            return (Criteria) this;
        }

        public Criteria andPhoneCityIsNotNull() {
            addCriterion("PHONE_CITY is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneCityEqualTo(String value) {
            addCriterion("PHONE_CITY =", value, "phoneCity");
            return (Criteria) this;
        }

        public Criteria andPhoneCityNotEqualTo(String value) {
            addCriterion("PHONE_CITY <>", value, "phoneCity");
            return (Criteria) this;
        }

        public Criteria andPhoneCityGreaterThan(String value) {
            addCriterion("PHONE_CITY >", value, "phoneCity");
            return (Criteria) this;
        }

        public Criteria andPhoneCityGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE_CITY >=", value, "phoneCity");
            return (Criteria) this;
        }

        public Criteria andPhoneCityLessThan(String value) {
            addCriterion("PHONE_CITY <", value, "phoneCity");
            return (Criteria) this;
        }

        public Criteria andPhoneCityLessThanOrEqualTo(String value) {
            addCriterion("PHONE_CITY <=", value, "phoneCity");
            return (Criteria) this;
        }

        public Criteria andPhoneCityLike(String value) {
            addCriterion("PHONE_CITY like", value, "phoneCity");
            return (Criteria) this;
        }

        public Criteria andPhoneCityNotLike(String value) {
            addCriterion("PHONE_CITY not like", value, "phoneCity");
            return (Criteria) this;
        }

        public Criteria andPhoneCityIn(List<String> values) {
            addCriterion("PHONE_CITY in", values, "phoneCity");
            return (Criteria) this;
        }

        public Criteria andPhoneCityNotIn(List<String> values) {
            addCriterion("PHONE_CITY not in", values, "phoneCity");
            return (Criteria) this;
        }

        public Criteria andPhoneCityBetween(String value1, String value2) {
            addCriterion("PHONE_CITY between", value1, value2, "phoneCity");
            return (Criteria) this;
        }

        public Criteria andPhoneCityNotBetween(String value1, String value2) {
            addCriterion("PHONE_CITY not between", value1, value2, "phoneCity");
            return (Criteria) this;
        }

        public Criteria andLoginMpIsNull() {
            addCriterion("LOGIN_MP is null");
            return (Criteria) this;
        }

        public Criteria andLoginMpIsNotNull() {
            addCriterion("LOGIN_MP is not null");
            return (Criteria) this;
        }

        public Criteria andLoginMpEqualTo(String value) {
            addCriterion("LOGIN_MP =", value, "loginMp");
            return (Criteria) this;
        }

        public Criteria andLoginMpNotEqualTo(String value) {
            addCriterion("LOGIN_MP <>", value, "loginMp");
            return (Criteria) this;
        }

        public Criteria andLoginMpGreaterThan(String value) {
            addCriterion("LOGIN_MP >", value, "loginMp");
            return (Criteria) this;
        }

        public Criteria andLoginMpGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_MP >=", value, "loginMp");
            return (Criteria) this;
        }

        public Criteria andLoginMpLessThan(String value) {
            addCriterion("LOGIN_MP <", value, "loginMp");
            return (Criteria) this;
        }

        public Criteria andLoginMpLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_MP <=", value, "loginMp");
            return (Criteria) this;
        }

        public Criteria andLoginMpLike(String value) {
            addCriterion("LOGIN_MP like", value, "loginMp");
            return (Criteria) this;
        }

        public Criteria andLoginMpNotLike(String value) {
            addCriterion("LOGIN_MP not like", value, "loginMp");
            return (Criteria) this;
        }

        public Criteria andLoginMpIn(List<String> values) {
            addCriterion("LOGIN_MP in", values, "loginMp");
            return (Criteria) this;
        }

        public Criteria andLoginMpNotIn(List<String> values) {
            addCriterion("LOGIN_MP not in", values, "loginMp");
            return (Criteria) this;
        }

        public Criteria andLoginMpBetween(String value1, String value2) {
            addCriterion("LOGIN_MP between", value1, value2, "loginMp");
            return (Criteria) this;
        }

        public Criteria andLoginMpNotBetween(String value1, String value2) {
            addCriterion("LOGIN_MP not between", value1, value2, "loginMp");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("USER_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("USER_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("USER_PHONE =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("USER_PHONE <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("USER_PHONE >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PHONE >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("USER_PHONE <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("USER_PHONE <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("USER_PHONE like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("USER_PHONE not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("USER_PHONE in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("USER_PHONE not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("USER_PHONE between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("USER_PHONE not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneTypeIsNull() {
            addCriterion("USER_PHONE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneTypeIsNotNull() {
            addCriterion("USER_PHONE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneTypeEqualTo(String value) {
            addCriterion("USER_PHONE_TYPE =", value, "userPhoneType");
            return (Criteria) this;
        }

        public Criteria andUserPhoneTypeNotEqualTo(String value) {
            addCriterion("USER_PHONE_TYPE <>", value, "userPhoneType");
            return (Criteria) this;
        }

        public Criteria andUserPhoneTypeGreaterThan(String value) {
            addCriterion("USER_PHONE_TYPE >", value, "userPhoneType");
            return (Criteria) this;
        }

        public Criteria andUserPhoneTypeGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PHONE_TYPE >=", value, "userPhoneType");
            return (Criteria) this;
        }

        public Criteria andUserPhoneTypeLessThan(String value) {
            addCriterion("USER_PHONE_TYPE <", value, "userPhoneType");
            return (Criteria) this;
        }

        public Criteria andUserPhoneTypeLessThanOrEqualTo(String value) {
            addCriterion("USER_PHONE_TYPE <=", value, "userPhoneType");
            return (Criteria) this;
        }

        public Criteria andUserPhoneTypeLike(String value) {
            addCriterion("USER_PHONE_TYPE like", value, "userPhoneType");
            return (Criteria) this;
        }

        public Criteria andUserPhoneTypeNotLike(String value) {
            addCriterion("USER_PHONE_TYPE not like", value, "userPhoneType");
            return (Criteria) this;
        }

        public Criteria andUserPhoneTypeIn(List<String> values) {
            addCriterion("USER_PHONE_TYPE in", values, "userPhoneType");
            return (Criteria) this;
        }

        public Criteria andUserPhoneTypeNotIn(List<String> values) {
            addCriterion("USER_PHONE_TYPE not in", values, "userPhoneType");
            return (Criteria) this;
        }

        public Criteria andUserPhoneTypeBetween(String value1, String value2) {
            addCriterion("USER_PHONE_TYPE between", value1, value2, "userPhoneType");
            return (Criteria) this;
        }

        public Criteria andUserPhoneTypeNotBetween(String value1, String value2) {
            addCriterion("USER_PHONE_TYPE not between", value1, value2, "userPhoneType");
            return (Criteria) this;
        }

        public Criteria andUserPhoneImeiIsNull() {
            addCriterion("USER_PHONE_IMEI is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneImeiIsNotNull() {
            addCriterion("USER_PHONE_IMEI is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneImeiEqualTo(String value) {
            addCriterion("USER_PHONE_IMEI =", value, "userPhoneImei");
            return (Criteria) this;
        }

        public Criteria andUserPhoneImeiNotEqualTo(String value) {
            addCriterion("USER_PHONE_IMEI <>", value, "userPhoneImei");
            return (Criteria) this;
        }

        public Criteria andUserPhoneImeiGreaterThan(String value) {
            addCriterion("USER_PHONE_IMEI >", value, "userPhoneImei");
            return (Criteria) this;
        }

        public Criteria andUserPhoneImeiGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PHONE_IMEI >=", value, "userPhoneImei");
            return (Criteria) this;
        }

        public Criteria andUserPhoneImeiLessThan(String value) {
            addCriterion("USER_PHONE_IMEI <", value, "userPhoneImei");
            return (Criteria) this;
        }

        public Criteria andUserPhoneImeiLessThanOrEqualTo(String value) {
            addCriterion("USER_PHONE_IMEI <=", value, "userPhoneImei");
            return (Criteria) this;
        }

        public Criteria andUserPhoneImeiLike(String value) {
            addCriterion("USER_PHONE_IMEI like", value, "userPhoneImei");
            return (Criteria) this;
        }

        public Criteria andUserPhoneImeiNotLike(String value) {
            addCriterion("USER_PHONE_IMEI not like", value, "userPhoneImei");
            return (Criteria) this;
        }

        public Criteria andUserPhoneImeiIn(List<String> values) {
            addCriterion("USER_PHONE_IMEI in", values, "userPhoneImei");
            return (Criteria) this;
        }

        public Criteria andUserPhoneImeiNotIn(List<String> values) {
            addCriterion("USER_PHONE_IMEI not in", values, "userPhoneImei");
            return (Criteria) this;
        }

        public Criteria andUserPhoneImeiBetween(String value1, String value2) {
            addCriterion("USER_PHONE_IMEI between", value1, value2, "userPhoneImei");
            return (Criteria) this;
        }

        public Criteria andUserPhoneImeiNotBetween(String value1, String value2) {
            addCriterion("USER_PHONE_IMEI not between", value1, value2, "userPhoneImei");
            return (Criteria) this;
        }

        public Criteria andProvineIsNull() {
            addCriterion("PROVINE is null");
            return (Criteria) this;
        }

        public Criteria andProvineIsNotNull() {
            addCriterion("PROVINE is not null");
            return (Criteria) this;
        }

        public Criteria andProvineEqualTo(String value) {
            addCriterion("PROVINE =", value, "provine");
            return (Criteria) this;
        }

        public Criteria andProvineNotEqualTo(String value) {
            addCriterion("PROVINE <>", value, "provine");
            return (Criteria) this;
        }

        public Criteria andProvineGreaterThan(String value) {
            addCriterion("PROVINE >", value, "provine");
            return (Criteria) this;
        }

        public Criteria andProvineGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINE >=", value, "provine");
            return (Criteria) this;
        }

        public Criteria andProvineLessThan(String value) {
            addCriterion("PROVINE <", value, "provine");
            return (Criteria) this;
        }

        public Criteria andProvineLessThanOrEqualTo(String value) {
            addCriterion("PROVINE <=", value, "provine");
            return (Criteria) this;
        }

        public Criteria andProvineLike(String value) {
            addCriterion("PROVINE like", value, "provine");
            return (Criteria) this;
        }

        public Criteria andProvineNotLike(String value) {
            addCriterion("PROVINE not like", value, "provine");
            return (Criteria) this;
        }

        public Criteria andProvineIn(List<String> values) {
            addCriterion("PROVINE in", values, "provine");
            return (Criteria) this;
        }

        public Criteria andProvineNotIn(List<String> values) {
            addCriterion("PROVINE not in", values, "provine");
            return (Criteria) this;
        }

        public Criteria andProvineBetween(String value1, String value2) {
            addCriterion("PROVINE between", value1, value2, "provine");
            return (Criteria) this;
        }

        public Criteria andProvineNotBetween(String value1, String value2) {
            addCriterion("PROVINE not between", value1, value2, "provine");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("CITY is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("CITY is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("CITY =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("CITY <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("CITY >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("CITY >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("CITY <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("CITY <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("CITY like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("CITY not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("CITY in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("CITY not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("CITY between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("CITY not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andLoginChlIsNull() {
            addCriterion("LOGIN_CHL is null");
            return (Criteria) this;
        }

        public Criteria andLoginChlIsNotNull() {
            addCriterion("LOGIN_CHL is not null");
            return (Criteria) this;
        }

        public Criteria andLoginChlEqualTo(String value) {
            addCriterion("LOGIN_CHL =", value, "loginChl");
            return (Criteria) this;
        }

        public Criteria andLoginChlNotEqualTo(String value) {
            addCriterion("LOGIN_CHL <>", value, "loginChl");
            return (Criteria) this;
        }

        public Criteria andLoginChlGreaterThan(String value) {
            addCriterion("LOGIN_CHL >", value, "loginChl");
            return (Criteria) this;
        }

        public Criteria andLoginChlGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_CHL >=", value, "loginChl");
            return (Criteria) this;
        }

        public Criteria andLoginChlLessThan(String value) {
            addCriterion("LOGIN_CHL <", value, "loginChl");
            return (Criteria) this;
        }

        public Criteria andLoginChlLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_CHL <=", value, "loginChl");
            return (Criteria) this;
        }

        public Criteria andLoginChlLike(String value) {
            addCriterion("LOGIN_CHL like", value, "loginChl");
            return (Criteria) this;
        }

        public Criteria andLoginChlNotLike(String value) {
            addCriterion("LOGIN_CHL not like", value, "loginChl");
            return (Criteria) this;
        }

        public Criteria andLoginChlIn(List<String> values) {
            addCriterion("LOGIN_CHL in", values, "loginChl");
            return (Criteria) this;
        }

        public Criteria andLoginChlNotIn(List<String> values) {
            addCriterion("LOGIN_CHL not in", values, "loginChl");
            return (Criteria) this;
        }

        public Criteria andLoginChlBetween(String value1, String value2) {
            addCriterion("LOGIN_CHL between", value1, value2, "loginChl");
            return (Criteria) this;
        }

        public Criteria andLoginChlNotBetween(String value1, String value2) {
            addCriterion("LOGIN_CHL not between", value1, value2, "loginChl");
            return (Criteria) this;
        }

        public Criteria andLoginWayIsNull() {
            addCriterion("LOGIN_WAY is null");
            return (Criteria) this;
        }

        public Criteria andLoginWayIsNotNull() {
            addCriterion("LOGIN_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andLoginWayEqualTo(String value) {
            addCriterion("LOGIN_WAY =", value, "loginWay");
            return (Criteria) this;
        }

        public Criteria andLoginWayNotEqualTo(String value) {
            addCriterion("LOGIN_WAY <>", value, "loginWay");
            return (Criteria) this;
        }

        public Criteria andLoginWayGreaterThan(String value) {
            addCriterion("LOGIN_WAY >", value, "loginWay");
            return (Criteria) this;
        }

        public Criteria andLoginWayGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_WAY >=", value, "loginWay");
            return (Criteria) this;
        }

        public Criteria andLoginWayLessThan(String value) {
            addCriterion("LOGIN_WAY <", value, "loginWay");
            return (Criteria) this;
        }

        public Criteria andLoginWayLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_WAY <=", value, "loginWay");
            return (Criteria) this;
        }

        public Criteria andLoginWayLike(String value) {
            addCriterion("LOGIN_WAY like", value, "loginWay");
            return (Criteria) this;
        }

        public Criteria andLoginWayNotLike(String value) {
            addCriterion("LOGIN_WAY not like", value, "loginWay");
            return (Criteria) this;
        }

        public Criteria andLoginWayIn(List<String> values) {
            addCriterion("LOGIN_WAY in", values, "loginWay");
            return (Criteria) this;
        }

        public Criteria andLoginWayNotIn(List<String> values) {
            addCriterion("LOGIN_WAY not in", values, "loginWay");
            return (Criteria) this;
        }

        public Criteria andLoginWayBetween(String value1, String value2) {
            addCriterion("LOGIN_WAY between", value1, value2, "loginWay");
            return (Criteria) this;
        }

        public Criteria andLoginWayNotBetween(String value1, String value2) {
            addCriterion("LOGIN_WAY not between", value1, value2, "loginWay");
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