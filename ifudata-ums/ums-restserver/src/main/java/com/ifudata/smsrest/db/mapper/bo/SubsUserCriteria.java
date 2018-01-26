package com.ifudata.smsrest.db.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SubsUserCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public SubsUserCriteria() {
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

        public Criteria andSubsUniqueIdIsNull() {
            addCriterion("subs_unique_id is null");
            return (Criteria) this;
        }

        public Criteria andSubsUniqueIdIsNotNull() {
            addCriterion("subs_unique_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubsUniqueIdEqualTo(Long value) {
            addCriterion("subs_unique_id =", value, "subsUniqueId");
            return (Criteria) this;
        }

        public Criteria andSubsUniqueIdNotEqualTo(Long value) {
            addCriterion("subs_unique_id <>", value, "subsUniqueId");
            return (Criteria) this;
        }

        public Criteria andSubsUniqueIdGreaterThan(Long value) {
            addCriterion("subs_unique_id >", value, "subsUniqueId");
            return (Criteria) this;
        }

        public Criteria andSubsUniqueIdGreaterThanOrEqualTo(Long value) {
            addCriterion("subs_unique_id >=", value, "subsUniqueId");
            return (Criteria) this;
        }

        public Criteria andSubsUniqueIdLessThan(Long value) {
            addCriterion("subs_unique_id <", value, "subsUniqueId");
            return (Criteria) this;
        }

        public Criteria andSubsUniqueIdLessThanOrEqualTo(Long value) {
            addCriterion("subs_unique_id <=", value, "subsUniqueId");
            return (Criteria) this;
        }

        public Criteria andSubsUniqueIdIn(List<Long> values) {
            addCriterion("subs_unique_id in", values, "subsUniqueId");
            return (Criteria) this;
        }

        public Criteria andSubsUniqueIdNotIn(List<Long> values) {
            addCriterion("subs_unique_id not in", values, "subsUniqueId");
            return (Criteria) this;
        }

        public Criteria andSubsUniqueIdBetween(Long value1, Long value2) {
            addCriterion("subs_unique_id between", value1, value2, "subsUniqueId");
            return (Criteria) this;
        }

        public Criteria andSubsUniqueIdNotBetween(Long value1, Long value2) {
            addCriterion("subs_unique_id not between", value1, value2, "subsUniqueId");
            return (Criteria) this;
        }

        public Criteria andSubsIdIsNull() {
            addCriterion("subs_id is null");
            return (Criteria) this;
        }

        public Criteria andSubsIdIsNotNull() {
            addCriterion("subs_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubsIdEqualTo(Long value) {
            addCriterion("subs_id =", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdNotEqualTo(Long value) {
            addCriterion("subs_id <>", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdGreaterThan(Long value) {
            addCriterion("subs_id >", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("subs_id >=", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdLessThan(Long value) {
            addCriterion("subs_id <", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdLessThanOrEqualTo(Long value) {
            addCriterion("subs_id <=", value, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdIn(List<Long> values) {
            addCriterion("subs_id in", values, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdNotIn(List<Long> values) {
            addCriterion("subs_id not in", values, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdBetween(Long value1, Long value2) {
            addCriterion("subs_id between", value1, value2, "subsId");
            return (Criteria) this;
        }

        public Criteria andSubsIdNotBetween(Long value1, Long value2) {
            addCriterion("subs_id not between", value1, value2, "subsId");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNull() {
            addCriterion("cust_id is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("cust_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(Long value) {
            addCriterion("cust_id =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(Long value) {
            addCriterion("cust_id <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(Long value) {
            addCriterion("cust_id >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cust_id >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(Long value) {
            addCriterion("cust_id <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(Long value) {
            addCriterion("cust_id <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<Long> values) {
            addCriterion("cust_id in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<Long> values) {
            addCriterion("cust_id not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(Long value1, Long value2) {
            addCriterion("cust_id between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(Long value1, Long value2) {
            addCriterion("cust_id not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andAcctIdIsNull() {
            addCriterion("acct_id is null");
            return (Criteria) this;
        }

        public Criteria andAcctIdIsNotNull() {
            addCriterion("acct_id is not null");
            return (Criteria) this;
        }

        public Criteria andAcctIdEqualTo(Long value) {
            addCriterion("acct_id =", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotEqualTo(Long value) {
            addCriterion("acct_id <>", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdGreaterThan(Long value) {
            addCriterion("acct_id >", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdGreaterThanOrEqualTo(Long value) {
            addCriterion("acct_id >=", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdLessThan(Long value) {
            addCriterion("acct_id <", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdLessThanOrEqualTo(Long value) {
            addCriterion("acct_id <=", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdIn(List<Long> values) {
            addCriterion("acct_id in", values, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotIn(List<Long> values) {
            addCriterion("acct_id not in", values, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdBetween(Long value1, Long value2) {
            addCriterion("acct_id between", value1, value2, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotBetween(Long value1, Long value2) {
            addCriterion("acct_id not between", value1, value2, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctTypeIsNull() {
            addCriterion("acct_type is null");
            return (Criteria) this;
        }

        public Criteria andAcctTypeIsNotNull() {
            addCriterion("acct_type is not null");
            return (Criteria) this;
        }

        public Criteria andAcctTypeEqualTo(String value) {
            addCriterion("acct_type =", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeNotEqualTo(String value) {
            addCriterion("acct_type <>", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeGreaterThan(String value) {
            addCriterion("acct_type >", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeGreaterThanOrEqualTo(String value) {
            addCriterion("acct_type >=", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeLessThan(String value) {
            addCriterion("acct_type <", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeLessThanOrEqualTo(String value) {
            addCriterion("acct_type <=", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeLike(String value) {
            addCriterion("acct_type like", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeNotLike(String value) {
            addCriterion("acct_type not like", value, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeIn(List<String> values) {
            addCriterion("acct_type in", values, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeNotIn(List<String> values) {
            addCriterion("acct_type not in", values, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeBetween(String value1, String value2) {
            addCriterion("acct_type between", value1, value2, "acctType");
            return (Criteria) this;
        }

        public Criteria andAcctTypeNotBetween(String value1, String value2) {
            addCriterion("acct_type not between", value1, value2, "acctType");
            return (Criteria) this;
        }

        public Criteria andUserCustIdIsNull() {
            addCriterion("user_cust_id is null");
            return (Criteria) this;
        }

        public Criteria andUserCustIdIsNotNull() {
            addCriterion("user_cust_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserCustIdEqualTo(Long value) {
            addCriterion("user_cust_id =", value, "userCustId");
            return (Criteria) this;
        }

        public Criteria andUserCustIdNotEqualTo(Long value) {
            addCriterion("user_cust_id <>", value, "userCustId");
            return (Criteria) this;
        }

        public Criteria andUserCustIdGreaterThan(Long value) {
            addCriterion("user_cust_id >", value, "userCustId");
            return (Criteria) this;
        }

        public Criteria andUserCustIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_cust_id >=", value, "userCustId");
            return (Criteria) this;
        }

        public Criteria andUserCustIdLessThan(Long value) {
            addCriterion("user_cust_id <", value, "userCustId");
            return (Criteria) this;
        }

        public Criteria andUserCustIdLessThanOrEqualTo(Long value) {
            addCriterion("user_cust_id <=", value, "userCustId");
            return (Criteria) this;
        }

        public Criteria andUserCustIdIn(List<Long> values) {
            addCriterion("user_cust_id in", values, "userCustId");
            return (Criteria) this;
        }

        public Criteria andUserCustIdNotIn(List<Long> values) {
            addCriterion("user_cust_id not in", values, "userCustId");
            return (Criteria) this;
        }

        public Criteria andUserCustIdBetween(Long value1, Long value2) {
            addCriterion("user_cust_id between", value1, value2, "userCustId");
            return (Criteria) this;
        }

        public Criteria andUserCustIdNotBetween(Long value1, Long value2) {
            addCriterion("user_cust_id not between", value1, value2, "userCustId");
            return (Criteria) this;
        }

        public Criteria andServiceNumIsNull() {
            addCriterion("service_num is null");
            return (Criteria) this;
        }

        public Criteria andServiceNumIsNotNull() {
            addCriterion("service_num is not null");
            return (Criteria) this;
        }

        public Criteria andServiceNumEqualTo(String value) {
            addCriterion("service_num =", value, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumNotEqualTo(String value) {
            addCriterion("service_num <>", value, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumGreaterThan(String value) {
            addCriterion("service_num >", value, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumGreaterThanOrEqualTo(String value) {
            addCriterion("service_num >=", value, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumLessThan(String value) {
            addCriterion("service_num <", value, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumLessThanOrEqualTo(String value) {
            addCriterion("service_num <=", value, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumLike(String value) {
            addCriterion("service_num like", value, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumNotLike(String value) {
            addCriterion("service_num not like", value, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumIn(List<String> values) {
            addCriterion("service_num in", values, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumNotIn(List<String> values) {
            addCriterion("service_num not in", values, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumBetween(String value1, String value2) {
            addCriterion("service_num between", value1, value2, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andServiceNumNotBetween(String value1, String value2) {
            addCriterion("service_num not between", value1, value2, "serviceNum");
            return (Criteria) this;
        }

        public Criteria andImsiIsNull() {
            addCriterion("imsi is null");
            return (Criteria) this;
        }

        public Criteria andImsiIsNotNull() {
            addCriterion("imsi is not null");
            return (Criteria) this;
        }

        public Criteria andImsiEqualTo(String value) {
            addCriterion("imsi =", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotEqualTo(String value) {
            addCriterion("imsi <>", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiGreaterThan(String value) {
            addCriterion("imsi >", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiGreaterThanOrEqualTo(String value) {
            addCriterion("imsi >=", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiLessThan(String value) {
            addCriterion("imsi <", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiLessThanOrEqualTo(String value) {
            addCriterion("imsi <=", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiLike(String value) {
            addCriterion("imsi like", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotLike(String value) {
            addCriterion("imsi not like", value, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiIn(List<String> values) {
            addCriterion("imsi in", values, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotIn(List<String> values) {
            addCriterion("imsi not in", values, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiBetween(String value1, String value2) {
            addCriterion("imsi between", value1, value2, "imsi");
            return (Criteria) this;
        }

        public Criteria andImsiNotBetween(String value1, String value2) {
            addCriterion("imsi not between", value1, value2, "imsi");
            return (Criteria) this;
        }

        public Criteria andSimTypeIsNull() {
            addCriterion("sim_type is null");
            return (Criteria) this;
        }

        public Criteria andSimTypeIsNotNull() {
            addCriterion("sim_type is not null");
            return (Criteria) this;
        }

        public Criteria andSimTypeEqualTo(String value) {
            addCriterion("sim_type =", value, "simType");
            return (Criteria) this;
        }

        public Criteria andSimTypeNotEqualTo(String value) {
            addCriterion("sim_type <>", value, "simType");
            return (Criteria) this;
        }

        public Criteria andSimTypeGreaterThan(String value) {
            addCriterion("sim_type >", value, "simType");
            return (Criteria) this;
        }

        public Criteria andSimTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sim_type >=", value, "simType");
            return (Criteria) this;
        }

        public Criteria andSimTypeLessThan(String value) {
            addCriterion("sim_type <", value, "simType");
            return (Criteria) this;
        }

        public Criteria andSimTypeLessThanOrEqualTo(String value) {
            addCriterion("sim_type <=", value, "simType");
            return (Criteria) this;
        }

        public Criteria andSimTypeLike(String value) {
            addCriterion("sim_type like", value, "simType");
            return (Criteria) this;
        }

        public Criteria andSimTypeNotLike(String value) {
            addCriterion("sim_type not like", value, "simType");
            return (Criteria) this;
        }

        public Criteria andSimTypeIn(List<String> values) {
            addCriterion("sim_type in", values, "simType");
            return (Criteria) this;
        }

        public Criteria andSimTypeNotIn(List<String> values) {
            addCriterion("sim_type not in", values, "simType");
            return (Criteria) this;
        }

        public Criteria andSimTypeBetween(String value1, String value2) {
            addCriterion("sim_type between", value1, value2, "simType");
            return (Criteria) this;
        }

        public Criteria andSimTypeNotBetween(String value1, String value2) {
            addCriterion("sim_type not between", value1, value2, "simType");
            return (Criteria) this;
        }

        public Criteria andSimIsNull() {
            addCriterion("sim is null");
            return (Criteria) this;
        }

        public Criteria andSimIsNotNull() {
            addCriterion("sim is not null");
            return (Criteria) this;
        }

        public Criteria andSimEqualTo(String value) {
            addCriterion("sim =", value, "sim");
            return (Criteria) this;
        }

        public Criteria andSimNotEqualTo(String value) {
            addCriterion("sim <>", value, "sim");
            return (Criteria) this;
        }

        public Criteria andSimGreaterThan(String value) {
            addCriterion("sim >", value, "sim");
            return (Criteria) this;
        }

        public Criteria andSimGreaterThanOrEqualTo(String value) {
            addCriterion("sim >=", value, "sim");
            return (Criteria) this;
        }

        public Criteria andSimLessThan(String value) {
            addCriterion("sim <", value, "sim");
            return (Criteria) this;
        }

        public Criteria andSimLessThanOrEqualTo(String value) {
            addCriterion("sim <=", value, "sim");
            return (Criteria) this;
        }

        public Criteria andSimLike(String value) {
            addCriterion("sim like", value, "sim");
            return (Criteria) this;
        }

        public Criteria andSimNotLike(String value) {
            addCriterion("sim not like", value, "sim");
            return (Criteria) this;
        }

        public Criteria andSimIn(List<String> values) {
            addCriterion("sim in", values, "sim");
            return (Criteria) this;
        }

        public Criteria andSimNotIn(List<String> values) {
            addCriterion("sim not in", values, "sim");
            return (Criteria) this;
        }

        public Criteria andSimBetween(String value1, String value2) {
            addCriterion("sim between", value1, value2, "sim");
            return (Criteria) this;
        }

        public Criteria andSimNotBetween(String value1, String value2) {
            addCriterion("sim not between", value1, value2, "sim");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdIsNull() {
            addCriterion("basic_org_id is null");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdIsNotNull() {
            addCriterion("basic_org_id is not null");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdEqualTo(String value) {
            addCriterion("basic_org_id =", value, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdNotEqualTo(String value) {
            addCriterion("basic_org_id <>", value, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdGreaterThan(String value) {
            addCriterion("basic_org_id >", value, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("basic_org_id >=", value, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdLessThan(String value) {
            addCriterion("basic_org_id <", value, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdLessThanOrEqualTo(String value) {
            addCriterion("basic_org_id <=", value, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdLike(String value) {
            addCriterion("basic_org_id like", value, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdNotLike(String value) {
            addCriterion("basic_org_id not like", value, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdIn(List<String> values) {
            addCriterion("basic_org_id in", values, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdNotIn(List<String> values) {
            addCriterion("basic_org_id not in", values, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdBetween(String value1, String value2) {
            addCriterion("basic_org_id between", value1, value2, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andBasicOrgIdNotBetween(String value1, String value2) {
            addCriterion("basic_org_id not between", value1, value2, "basicOrgId");
            return (Criteria) this;
        }

        public Criteria andSvcPwdIsNull() {
            addCriterion("svc_pwd is null");
            return (Criteria) this;
        }

        public Criteria andSvcPwdIsNotNull() {
            addCriterion("svc_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andSvcPwdEqualTo(String value) {
            addCriterion("svc_pwd =", value, "svcPwd");
            return (Criteria) this;
        }

        public Criteria andSvcPwdNotEqualTo(String value) {
            addCriterion("svc_pwd <>", value, "svcPwd");
            return (Criteria) this;
        }

        public Criteria andSvcPwdGreaterThan(String value) {
            addCriterion("svc_pwd >", value, "svcPwd");
            return (Criteria) this;
        }

        public Criteria andSvcPwdGreaterThanOrEqualTo(String value) {
            addCriterion("svc_pwd >=", value, "svcPwd");
            return (Criteria) this;
        }

        public Criteria andSvcPwdLessThan(String value) {
            addCriterion("svc_pwd <", value, "svcPwd");
            return (Criteria) this;
        }

        public Criteria andSvcPwdLessThanOrEqualTo(String value) {
            addCriterion("svc_pwd <=", value, "svcPwd");
            return (Criteria) this;
        }

        public Criteria andSvcPwdLike(String value) {
            addCriterion("svc_pwd like", value, "svcPwd");
            return (Criteria) this;
        }

        public Criteria andSvcPwdNotLike(String value) {
            addCriterion("svc_pwd not like", value, "svcPwd");
            return (Criteria) this;
        }

        public Criteria andSvcPwdIn(List<String> values) {
            addCriterion("svc_pwd in", values, "svcPwd");
            return (Criteria) this;
        }

        public Criteria andSvcPwdNotIn(List<String> values) {
            addCriterion("svc_pwd not in", values, "svcPwd");
            return (Criteria) this;
        }

        public Criteria andSvcPwdBetween(String value1, String value2) {
            addCriterion("svc_pwd between", value1, value2, "svcPwd");
            return (Criteria) this;
        }

        public Criteria andSvcPwdNotBetween(String value1, String value2) {
            addCriterion("svc_pwd not between", value1, value2, "svcPwd");
            return (Criteria) this;
        }

        public Criteria andSvcTypeIsNull() {
            addCriterion("svc_type is null");
            return (Criteria) this;
        }

        public Criteria andSvcTypeIsNotNull() {
            addCriterion("svc_type is not null");
            return (Criteria) this;
        }

        public Criteria andSvcTypeEqualTo(String value) {
            addCriterion("svc_type =", value, "svcType");
            return (Criteria) this;
        }

        public Criteria andSvcTypeNotEqualTo(String value) {
            addCriterion("svc_type <>", value, "svcType");
            return (Criteria) this;
        }

        public Criteria andSvcTypeGreaterThan(String value) {
            addCriterion("svc_type >", value, "svcType");
            return (Criteria) this;
        }

        public Criteria andSvcTypeGreaterThanOrEqualTo(String value) {
            addCriterion("svc_type >=", value, "svcType");
            return (Criteria) this;
        }

        public Criteria andSvcTypeLessThan(String value) {
            addCriterion("svc_type <", value, "svcType");
            return (Criteria) this;
        }

        public Criteria andSvcTypeLessThanOrEqualTo(String value) {
            addCriterion("svc_type <=", value, "svcType");
            return (Criteria) this;
        }

        public Criteria andSvcTypeLike(String value) {
            addCriterion("svc_type like", value, "svcType");
            return (Criteria) this;
        }

        public Criteria andSvcTypeNotLike(String value) {
            addCriterion("svc_type not like", value, "svcType");
            return (Criteria) this;
        }

        public Criteria andSvcTypeIn(List<String> values) {
            addCriterion("svc_type in", values, "svcType");
            return (Criteria) this;
        }

        public Criteria andSvcTypeNotIn(List<String> values) {
            addCriterion("svc_type not in", values, "svcType");
            return (Criteria) this;
        }

        public Criteria andSvcTypeBetween(String value1, String value2) {
            addCriterion("svc_type between", value1, value2, "svcType");
            return (Criteria) this;
        }

        public Criteria andSvcTypeNotBetween(String value1, String value2) {
            addCriterion("svc_type not between", value1, value2, "svcType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("user_type like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("user_type not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andSubsStatusIsNull() {
            addCriterion("subs_status is null");
            return (Criteria) this;
        }

        public Criteria andSubsStatusIsNotNull() {
            addCriterion("subs_status is not null");
            return (Criteria) this;
        }

        public Criteria andSubsStatusEqualTo(String value) {
            addCriterion("subs_status =", value, "subsStatus");
            return (Criteria) this;
        }

        public Criteria andSubsStatusNotEqualTo(String value) {
            addCriterion("subs_status <>", value, "subsStatus");
            return (Criteria) this;
        }

        public Criteria andSubsStatusGreaterThan(String value) {
            addCriterion("subs_status >", value, "subsStatus");
            return (Criteria) this;
        }

        public Criteria andSubsStatusGreaterThanOrEqualTo(String value) {
            addCriterion("subs_status >=", value, "subsStatus");
            return (Criteria) this;
        }

        public Criteria andSubsStatusLessThan(String value) {
            addCriterion("subs_status <", value, "subsStatus");
            return (Criteria) this;
        }

        public Criteria andSubsStatusLessThanOrEqualTo(String value) {
            addCriterion("subs_status <=", value, "subsStatus");
            return (Criteria) this;
        }

        public Criteria andSubsStatusLike(String value) {
            addCriterion("subs_status like", value, "subsStatus");
            return (Criteria) this;
        }

        public Criteria andSubsStatusNotLike(String value) {
            addCriterion("subs_status not like", value, "subsStatus");
            return (Criteria) this;
        }

        public Criteria andSubsStatusIn(List<String> values) {
            addCriterion("subs_status in", values, "subsStatus");
            return (Criteria) this;
        }

        public Criteria andSubsStatusNotIn(List<String> values) {
            addCriterion("subs_status not in", values, "subsStatus");
            return (Criteria) this;
        }

        public Criteria andSubsStatusBetween(String value1, String value2) {
            addCriterion("subs_status between", value1, value2, "subsStatus");
            return (Criteria) this;
        }

        public Criteria andSubsStatusNotBetween(String value1, String value2) {
            addCriterion("subs_status not between", value1, value2, "subsStatus");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIsNull() {
            addCriterion("join_time is null");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIsNotNull() {
            addCriterion("join_time is not null");
            return (Criteria) this;
        }

        public Criteria andJoinTimeEqualTo(Timestamp value) {
            addCriterion("join_time =", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotEqualTo(Timestamp value) {
            addCriterion("join_time <>", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeGreaterThan(Timestamp value) {
            addCriterion("join_time >", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("join_time >=", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeLessThan(Timestamp value) {
            addCriterion("join_time <", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("join_time <=", value, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeIn(List<Timestamp> values) {
            addCriterion("join_time in", values, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotIn(List<Timestamp> values) {
            addCriterion("join_time not in", values, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("join_time between", value1, value2, "joinTime");
            return (Criteria) this;
        }

        public Criteria andJoinTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("join_time not between", value1, value2, "joinTime");
            return (Criteria) this;
        }

        public Criteria andNormalizeTimeIsNull() {
            addCriterion("normalize_time is null");
            return (Criteria) this;
        }

        public Criteria andNormalizeTimeIsNotNull() {
            addCriterion("normalize_time is not null");
            return (Criteria) this;
        }

        public Criteria andNormalizeTimeEqualTo(Timestamp value) {
            addCriterion("normalize_time =", value, "normalizeTime");
            return (Criteria) this;
        }

        public Criteria andNormalizeTimeNotEqualTo(Timestamp value) {
            addCriterion("normalize_time <>", value, "normalizeTime");
            return (Criteria) this;
        }

        public Criteria andNormalizeTimeGreaterThan(Timestamp value) {
            addCriterion("normalize_time >", value, "normalizeTime");
            return (Criteria) this;
        }

        public Criteria andNormalizeTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("normalize_time >=", value, "normalizeTime");
            return (Criteria) this;
        }

        public Criteria andNormalizeTimeLessThan(Timestamp value) {
            addCriterion("normalize_time <", value, "normalizeTime");
            return (Criteria) this;
        }

        public Criteria andNormalizeTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("normalize_time <=", value, "normalizeTime");
            return (Criteria) this;
        }

        public Criteria andNormalizeTimeIn(List<Timestamp> values) {
            addCriterion("normalize_time in", values, "normalizeTime");
            return (Criteria) this;
        }

        public Criteria andNormalizeTimeNotIn(List<Timestamp> values) {
            addCriterion("normalize_time not in", values, "normalizeTime");
            return (Criteria) this;
        }

        public Criteria andNormalizeTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("normalize_time between", value1, value2, "normalizeTime");
            return (Criteria) this;
        }

        public Criteria andNormalizeTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("normalize_time not between", value1, value2, "normalizeTime");
            return (Criteria) this;
        }

        public Criteria andServiceStatusIsNull() {
            addCriterion("service_status is null");
            return (Criteria) this;
        }

        public Criteria andServiceStatusIsNotNull() {
            addCriterion("service_status is not null");
            return (Criteria) this;
        }

        public Criteria andServiceStatusEqualTo(String value) {
            addCriterion("service_status =", value, "serviceStatus");
            return (Criteria) this;
        }

        public Criteria andServiceStatusNotEqualTo(String value) {
            addCriterion("service_status <>", value, "serviceStatus");
            return (Criteria) this;
        }

        public Criteria andServiceStatusGreaterThan(String value) {
            addCriterion("service_status >", value, "serviceStatus");
            return (Criteria) this;
        }

        public Criteria andServiceStatusGreaterThanOrEqualTo(String value) {
            addCriterion("service_status >=", value, "serviceStatus");
            return (Criteria) this;
        }

        public Criteria andServiceStatusLessThan(String value) {
            addCriterion("service_status <", value, "serviceStatus");
            return (Criteria) this;
        }

        public Criteria andServiceStatusLessThanOrEqualTo(String value) {
            addCriterion("service_status <=", value, "serviceStatus");
            return (Criteria) this;
        }

        public Criteria andServiceStatusLike(String value) {
            addCriterion("service_status like", value, "serviceStatus");
            return (Criteria) this;
        }

        public Criteria andServiceStatusNotLike(String value) {
            addCriterion("service_status not like", value, "serviceStatus");
            return (Criteria) this;
        }

        public Criteria andServiceStatusIn(List<String> values) {
            addCriterion("service_status in", values, "serviceStatus");
            return (Criteria) this;
        }

        public Criteria andServiceStatusNotIn(List<String> values) {
            addCriterion("service_status not in", values, "serviceStatus");
            return (Criteria) this;
        }

        public Criteria andServiceStatusBetween(String value1, String value2) {
            addCriterion("service_status between", value1, value2, "serviceStatus");
            return (Criteria) this;
        }

        public Criteria andServiceStatusNotBetween(String value1, String value2) {
            addCriterion("service_status not between", value1, value2, "serviceStatus");
            return (Criteria) this;
        }

        public Criteria andStatusChgTypeIsNull() {
            addCriterion("status_chg_type is null");
            return (Criteria) this;
        }

        public Criteria andStatusChgTypeIsNotNull() {
            addCriterion("status_chg_type is not null");
            return (Criteria) this;
        }

        public Criteria andStatusChgTypeEqualTo(String value) {
            addCriterion("status_chg_type =", value, "statusChgType");
            return (Criteria) this;
        }

        public Criteria andStatusChgTypeNotEqualTo(String value) {
            addCriterion("status_chg_type <>", value, "statusChgType");
            return (Criteria) this;
        }

        public Criteria andStatusChgTypeGreaterThan(String value) {
            addCriterion("status_chg_type >", value, "statusChgType");
            return (Criteria) this;
        }

        public Criteria andStatusChgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("status_chg_type >=", value, "statusChgType");
            return (Criteria) this;
        }

        public Criteria andStatusChgTypeLessThan(String value) {
            addCriterion("status_chg_type <", value, "statusChgType");
            return (Criteria) this;
        }

        public Criteria andStatusChgTypeLessThanOrEqualTo(String value) {
            addCriterion("status_chg_type <=", value, "statusChgType");
            return (Criteria) this;
        }

        public Criteria andStatusChgTypeLike(String value) {
            addCriterion("status_chg_type like", value, "statusChgType");
            return (Criteria) this;
        }

        public Criteria andStatusChgTypeNotLike(String value) {
            addCriterion("status_chg_type not like", value, "statusChgType");
            return (Criteria) this;
        }

        public Criteria andStatusChgTypeIn(List<String> values) {
            addCriterion("status_chg_type in", values, "statusChgType");
            return (Criteria) this;
        }

        public Criteria andStatusChgTypeNotIn(List<String> values) {
            addCriterion("status_chg_type not in", values, "statusChgType");
            return (Criteria) this;
        }

        public Criteria andStatusChgTypeBetween(String value1, String value2) {
            addCriterion("status_chg_type between", value1, value2, "statusChgType");
            return (Criteria) this;
        }

        public Criteria andStatusChgTypeNotBetween(String value1, String value2) {
            addCriterion("status_chg_type not between", value1, value2, "statusChgType");
            return (Criteria) this;
        }

        public Criteria andStatusChgTimeIsNull() {
            addCriterion("status_chg_time is null");
            return (Criteria) this;
        }

        public Criteria andStatusChgTimeIsNotNull() {
            addCriterion("status_chg_time is not null");
            return (Criteria) this;
        }

        public Criteria andStatusChgTimeEqualTo(Timestamp value) {
            addCriterion("status_chg_time =", value, "statusChgTime");
            return (Criteria) this;
        }

        public Criteria andStatusChgTimeNotEqualTo(Timestamp value) {
            addCriterion("status_chg_time <>", value, "statusChgTime");
            return (Criteria) this;
        }

        public Criteria andStatusChgTimeGreaterThan(Timestamp value) {
            addCriterion("status_chg_time >", value, "statusChgTime");
            return (Criteria) this;
        }

        public Criteria andStatusChgTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("status_chg_time >=", value, "statusChgTime");
            return (Criteria) this;
        }

        public Criteria andStatusChgTimeLessThan(Timestamp value) {
            addCriterion("status_chg_time <", value, "statusChgTime");
            return (Criteria) this;
        }

        public Criteria andStatusChgTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("status_chg_time <=", value, "statusChgTime");
            return (Criteria) this;
        }

        public Criteria andStatusChgTimeIn(List<Timestamp> values) {
            addCriterion("status_chg_time in", values, "statusChgTime");
            return (Criteria) this;
        }

        public Criteria andStatusChgTimeNotIn(List<Timestamp> values) {
            addCriterion("status_chg_time not in", values, "statusChgTime");
            return (Criteria) this;
        }

        public Criteria andStatusChgTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("status_chg_time between", value1, value2, "statusChgTime");
            return (Criteria) this;
        }

        public Criteria andStatusChgTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("status_chg_time not between", value1, value2, "statusChgTime");
            return (Criteria) this;
        }

        public Criteria andLastServiceStatusIsNull() {
            addCriterion("last_service_status is null");
            return (Criteria) this;
        }

        public Criteria andLastServiceStatusIsNotNull() {
            addCriterion("last_service_status is not null");
            return (Criteria) this;
        }

        public Criteria andLastServiceStatusEqualTo(String value) {
            addCriterion("last_service_status =", value, "lastServiceStatus");
            return (Criteria) this;
        }

        public Criteria andLastServiceStatusNotEqualTo(String value) {
            addCriterion("last_service_status <>", value, "lastServiceStatus");
            return (Criteria) this;
        }

        public Criteria andLastServiceStatusGreaterThan(String value) {
            addCriterion("last_service_status >", value, "lastServiceStatus");
            return (Criteria) this;
        }

        public Criteria andLastServiceStatusGreaterThanOrEqualTo(String value) {
            addCriterion("last_service_status >=", value, "lastServiceStatus");
            return (Criteria) this;
        }

        public Criteria andLastServiceStatusLessThan(String value) {
            addCriterion("last_service_status <", value, "lastServiceStatus");
            return (Criteria) this;
        }

        public Criteria andLastServiceStatusLessThanOrEqualTo(String value) {
            addCriterion("last_service_status <=", value, "lastServiceStatus");
            return (Criteria) this;
        }

        public Criteria andLastServiceStatusLike(String value) {
            addCriterion("last_service_status like", value, "lastServiceStatus");
            return (Criteria) this;
        }

        public Criteria andLastServiceStatusNotLike(String value) {
            addCriterion("last_service_status not like", value, "lastServiceStatus");
            return (Criteria) this;
        }

        public Criteria andLastServiceStatusIn(List<String> values) {
            addCriterion("last_service_status in", values, "lastServiceStatus");
            return (Criteria) this;
        }

        public Criteria andLastServiceStatusNotIn(List<String> values) {
            addCriterion("last_service_status not in", values, "lastServiceStatus");
            return (Criteria) this;
        }

        public Criteria andLastServiceStatusBetween(String value1, String value2) {
            addCriterion("last_service_status between", value1, value2, "lastServiceStatus");
            return (Criteria) this;
        }

        public Criteria andLastServiceStatusNotBetween(String value1, String value2) {
            addCriterion("last_service_status not between", value1, value2, "lastServiceStatus");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTimeIsNull() {
            addCriterion("last_status_chg_time is null");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTimeIsNotNull() {
            addCriterion("last_status_chg_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTimeEqualTo(Timestamp value) {
            addCriterion("last_status_chg_time =", value, "lastStatusChgTime");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTimeNotEqualTo(Timestamp value) {
            addCriterion("last_status_chg_time <>", value, "lastStatusChgTime");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTimeGreaterThan(Timestamp value) {
            addCriterion("last_status_chg_time >", value, "lastStatusChgTime");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("last_status_chg_time >=", value, "lastStatusChgTime");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTimeLessThan(Timestamp value) {
            addCriterion("last_status_chg_time <", value, "lastStatusChgTime");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("last_status_chg_time <=", value, "lastStatusChgTime");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTimeIn(List<Timestamp> values) {
            addCriterion("last_status_chg_time in", values, "lastStatusChgTime");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTimeNotIn(List<Timestamp> values) {
            addCriterion("last_status_chg_time not in", values, "lastStatusChgTime");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("last_status_chg_time between", value1, value2, "lastStatusChgTime");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("last_status_chg_time not between", value1, value2, "lastStatusChgTime");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTypeIsNull() {
            addCriterion("last_status_chg_type is null");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTypeIsNotNull() {
            addCriterion("last_status_chg_type is not null");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTypeEqualTo(String value) {
            addCriterion("last_status_chg_type =", value, "lastStatusChgType");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTypeNotEqualTo(String value) {
            addCriterion("last_status_chg_type <>", value, "lastStatusChgType");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTypeGreaterThan(String value) {
            addCriterion("last_status_chg_type >", value, "lastStatusChgType");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("last_status_chg_type >=", value, "lastStatusChgType");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTypeLessThan(String value) {
            addCriterion("last_status_chg_type <", value, "lastStatusChgType");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTypeLessThanOrEqualTo(String value) {
            addCriterion("last_status_chg_type <=", value, "lastStatusChgType");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTypeLike(String value) {
            addCriterion("last_status_chg_type like", value, "lastStatusChgType");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTypeNotLike(String value) {
            addCriterion("last_status_chg_type not like", value, "lastStatusChgType");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTypeIn(List<String> values) {
            addCriterion("last_status_chg_type in", values, "lastStatusChgType");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTypeNotIn(List<String> values) {
            addCriterion("last_status_chg_type not in", values, "lastStatusChgType");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTypeBetween(String value1, String value2) {
            addCriterion("last_status_chg_type between", value1, value2, "lastStatusChgType");
            return (Criteria) this;
        }

        public Criteria andLastStatusChgTypeNotBetween(String value1, String value2) {
            addCriterion("last_status_chg_type not between", value1, value2, "lastStatusChgType");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNull() {
            addCriterion("province_code is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("province_code is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeEqualTo(String value) {
            addCriterion("province_code =", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotEqualTo(String value) {
            addCriterion("province_code <>", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThan(String value) {
            addCriterion("province_code >", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("province_code >=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThan(String value) {
            addCriterion("province_code <", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("province_code <=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLike(String value) {
            addCriterion("province_code like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotLike(String value) {
            addCriterion("province_code not like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIn(List<String> values) {
            addCriterion("province_code in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotIn(List<String> values) {
            addCriterion("province_code not in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeBetween(String value1, String value2) {
            addCriterion("province_code between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("province_code not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNull() {
            addCriterion("city_code is null");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNotNull() {
            addCriterion("city_code is not null");
            return (Criteria) this;
        }

        public Criteria andCityCodeEqualTo(String value) {
            addCriterion("city_code =", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotEqualTo(String value) {
            addCriterion("city_code <>", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThan(String value) {
            addCriterion("city_code >", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("city_code >=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThan(String value) {
            addCriterion("city_code <", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThanOrEqualTo(String value) {
            addCriterion("city_code <=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLike(String value) {
            addCriterion("city_code like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotLike(String value) {
            addCriterion("city_code not like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIn(List<String> values) {
            addCriterion("city_code in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotIn(List<String> values) {
            addCriterion("city_code not in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeBetween(String value1, String value2) {
            addCriterion("city_code between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotBetween(String value1, String value2) {
            addCriterion("city_code not between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Timestamp value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Timestamp value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Timestamp value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Timestamp value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Timestamp> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Timestamp> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andOptChlIdIsNull() {
            addCriterion("opt_chl_id is null");
            return (Criteria) this;
        }

        public Criteria andOptChlIdIsNotNull() {
            addCriterion("opt_chl_id is not null");
            return (Criteria) this;
        }

        public Criteria andOptChlIdEqualTo(String value) {
            addCriterion("opt_chl_id =", value, "optChlId");
            return (Criteria) this;
        }

        public Criteria andOptChlIdNotEqualTo(String value) {
            addCriterion("opt_chl_id <>", value, "optChlId");
            return (Criteria) this;
        }

        public Criteria andOptChlIdGreaterThan(String value) {
            addCriterion("opt_chl_id >", value, "optChlId");
            return (Criteria) this;
        }

        public Criteria andOptChlIdGreaterThanOrEqualTo(String value) {
            addCriterion("opt_chl_id >=", value, "optChlId");
            return (Criteria) this;
        }

        public Criteria andOptChlIdLessThan(String value) {
            addCriterion("opt_chl_id <", value, "optChlId");
            return (Criteria) this;
        }

        public Criteria andOptChlIdLessThanOrEqualTo(String value) {
            addCriterion("opt_chl_id <=", value, "optChlId");
            return (Criteria) this;
        }

        public Criteria andOptChlIdLike(String value) {
            addCriterion("opt_chl_id like", value, "optChlId");
            return (Criteria) this;
        }

        public Criteria andOptChlIdNotLike(String value) {
            addCriterion("opt_chl_id not like", value, "optChlId");
            return (Criteria) this;
        }

        public Criteria andOptChlIdIn(List<String> values) {
            addCriterion("opt_chl_id in", values, "optChlId");
            return (Criteria) this;
        }

        public Criteria andOptChlIdNotIn(List<String> values) {
            addCriterion("opt_chl_id not in", values, "optChlId");
            return (Criteria) this;
        }

        public Criteria andOptChlIdBetween(String value1, String value2) {
            addCriterion("opt_chl_id between", value1, value2, "optChlId");
            return (Criteria) this;
        }

        public Criteria andOptChlIdNotBetween(String value1, String value2) {
            addCriterion("opt_chl_id not between", value1, value2, "optChlId");
            return (Criteria) this;
        }

        public Criteria andOptOperIdIsNull() {
            addCriterion("opt_oper_id is null");
            return (Criteria) this;
        }

        public Criteria andOptOperIdIsNotNull() {
            addCriterion("opt_oper_id is not null");
            return (Criteria) this;
        }

        public Criteria andOptOperIdEqualTo(Long value) {
            addCriterion("opt_oper_id =", value, "optOperId");
            return (Criteria) this;
        }

        public Criteria andOptOperIdNotEqualTo(Long value) {
            addCriterion("opt_oper_id <>", value, "optOperId");
            return (Criteria) this;
        }

        public Criteria andOptOperIdGreaterThan(Long value) {
            addCriterion("opt_oper_id >", value, "optOperId");
            return (Criteria) this;
        }

        public Criteria andOptOperIdGreaterThanOrEqualTo(Long value) {
            addCriterion("opt_oper_id >=", value, "optOperId");
            return (Criteria) this;
        }

        public Criteria andOptOperIdLessThan(Long value) {
            addCriterion("opt_oper_id <", value, "optOperId");
            return (Criteria) this;
        }

        public Criteria andOptOperIdLessThanOrEqualTo(Long value) {
            addCriterion("opt_oper_id <=", value, "optOperId");
            return (Criteria) this;
        }

        public Criteria andOptOperIdIn(List<Long> values) {
            addCriterion("opt_oper_id in", values, "optOperId");
            return (Criteria) this;
        }

        public Criteria andOptOperIdNotIn(List<Long> values) {
            addCriterion("opt_oper_id not in", values, "optOperId");
            return (Criteria) this;
        }

        public Criteria andOptOperIdBetween(Long value1, Long value2) {
            addCriterion("opt_oper_id between", value1, value2, "optOperId");
            return (Criteria) this;
        }

        public Criteria andOptOperIdNotBetween(Long value1, Long value2) {
            addCriterion("opt_oper_id not between", value1, value2, "optOperId");
            return (Criteria) this;
        }

        public Criteria andChlIdIsNull() {
            addCriterion("chl_id is null");
            return (Criteria) this;
        }

        public Criteria andChlIdIsNotNull() {
            addCriterion("chl_id is not null");
            return (Criteria) this;
        }

        public Criteria andChlIdEqualTo(String value) {
            addCriterion("chl_id =", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdNotEqualTo(String value) {
            addCriterion("chl_id <>", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdGreaterThan(String value) {
            addCriterion("chl_id >", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdGreaterThanOrEqualTo(String value) {
            addCriterion("chl_id >=", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdLessThan(String value) {
            addCriterion("chl_id <", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdLessThanOrEqualTo(String value) {
            addCriterion("chl_id <=", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdLike(String value) {
            addCriterion("chl_id like", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdNotLike(String value) {
            addCriterion("chl_id not like", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdIn(List<String> values) {
            addCriterion("chl_id in", values, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdNotIn(List<String> values) {
            addCriterion("chl_id not in", values, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdBetween(String value1, String value2) {
            addCriterion("chl_id between", value1, value2, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdNotBetween(String value1, String value2) {
            addCriterion("chl_id not between", value1, value2, "chlId");
            return (Criteria) this;
        }

        public Criteria andDevIdIsNull() {
            addCriterion("dev_id is null");
            return (Criteria) this;
        }

        public Criteria andDevIdIsNotNull() {
            addCriterion("dev_id is not null");
            return (Criteria) this;
        }

        public Criteria andDevIdEqualTo(Long value) {
            addCriterion("dev_id =", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotEqualTo(Long value) {
            addCriterion("dev_id <>", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdGreaterThan(Long value) {
            addCriterion("dev_id >", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dev_id >=", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdLessThan(Long value) {
            addCriterion("dev_id <", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdLessThanOrEqualTo(Long value) {
            addCriterion("dev_id <=", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdIn(List<Long> values) {
            addCriterion("dev_id in", values, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotIn(List<Long> values) {
            addCriterion("dev_id not in", values, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdBetween(Long value1, Long value2) {
            addCriterion("dev_id between", value1, value2, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotBetween(Long value1, Long value2) {
            addCriterion("dev_id not between", value1, value2, "devId");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIsNull() {
            addCriterion("active_time is null");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIsNotNull() {
            addCriterion("active_time is not null");
            return (Criteria) this;
        }

        public Criteria andActiveTimeEqualTo(Timestamp value) {
            addCriterion("active_time =", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotEqualTo(Timestamp value) {
            addCriterion("active_time <>", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeGreaterThan(Timestamp value) {
            addCriterion("active_time >", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("active_time >=", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeLessThan(Timestamp value) {
            addCriterion("active_time <", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("active_time <=", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIn(List<Timestamp> values) {
            addCriterion("active_time in", values, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotIn(List<Timestamp> values) {
            addCriterion("active_time not in", values, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("active_time between", value1, value2, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("active_time not between", value1, value2, "activeTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeIsNull() {
            addCriterion("inactive_time is null");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeIsNotNull() {
            addCriterion("inactive_time is not null");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeEqualTo(Timestamp value) {
            addCriterion("inactive_time =", value, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeNotEqualTo(Timestamp value) {
            addCriterion("inactive_time <>", value, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeGreaterThan(Timestamp value) {
            addCriterion("inactive_time >", value, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("inactive_time >=", value, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeLessThan(Timestamp value) {
            addCriterion("inactive_time <", value, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("inactive_time <=", value, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeIn(List<Timestamp> values) {
            addCriterion("inactive_time in", values, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeNotIn(List<Timestamp> values) {
            addCriterion("inactive_time not in", values, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("inactive_time between", value1, value2, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("inactive_time not between", value1, value2, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andAcctNameIsNull() {
            addCriterion("acct_name is null");
            return (Criteria) this;
        }

        public Criteria andAcctNameIsNotNull() {
            addCriterion("acct_name is not null");
            return (Criteria) this;
        }

        public Criteria andAcctNameEqualTo(String value) {
            addCriterion("acct_name =", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameNotEqualTo(String value) {
            addCriterion("acct_name <>", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameGreaterThan(String value) {
            addCriterion("acct_name >", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameGreaterThanOrEqualTo(String value) {
            addCriterion("acct_name >=", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameLessThan(String value) {
            addCriterion("acct_name <", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameLessThanOrEqualTo(String value) {
            addCriterion("acct_name <=", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameLike(String value) {
            addCriterion("acct_name like", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameNotLike(String value) {
            addCriterion("acct_name not like", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameIn(List<String> values) {
            addCriterion("acct_name in", values, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameNotIn(List<String> values) {
            addCriterion("acct_name not in", values, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameBetween(String value1, String value2) {
            addCriterion("acct_name between", value1, value2, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameNotBetween(String value1, String value2) {
            addCriterion("acct_name not between", value1, value2, "acctName");
            return (Criteria) this;
        }

        public Criteria andSvcProductTypeIsNull() {
            addCriterion("SVC_PRODUCT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSvcProductTypeIsNotNull() {
            addCriterion("SVC_PRODUCT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSvcProductTypeEqualTo(String value) {
            addCriterion("SVC_PRODUCT_TYPE =", value, "svcProductType");
            return (Criteria) this;
        }

        public Criteria andSvcProductTypeNotEqualTo(String value) {
            addCriterion("SVC_PRODUCT_TYPE <>", value, "svcProductType");
            return (Criteria) this;
        }

        public Criteria andSvcProductTypeGreaterThan(String value) {
            addCriterion("SVC_PRODUCT_TYPE >", value, "svcProductType");
            return (Criteria) this;
        }

        public Criteria andSvcProductTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SVC_PRODUCT_TYPE >=", value, "svcProductType");
            return (Criteria) this;
        }

        public Criteria andSvcProductTypeLessThan(String value) {
            addCriterion("SVC_PRODUCT_TYPE <", value, "svcProductType");
            return (Criteria) this;
        }

        public Criteria andSvcProductTypeLessThanOrEqualTo(String value) {
            addCriterion("SVC_PRODUCT_TYPE <=", value, "svcProductType");
            return (Criteria) this;
        }

        public Criteria andSvcProductTypeLike(String value) {
            addCriterion("SVC_PRODUCT_TYPE like", value, "svcProductType");
            return (Criteria) this;
        }

        public Criteria andSvcProductTypeNotLike(String value) {
            addCriterion("SVC_PRODUCT_TYPE not like", value, "svcProductType");
            return (Criteria) this;
        }

        public Criteria andSvcProductTypeIn(List<String> values) {
            addCriterion("SVC_PRODUCT_TYPE in", values, "svcProductType");
            return (Criteria) this;
        }

        public Criteria andSvcProductTypeNotIn(List<String> values) {
            addCriterion("SVC_PRODUCT_TYPE not in", values, "svcProductType");
            return (Criteria) this;
        }

        public Criteria andSvcProductTypeBetween(String value1, String value2) {
            addCriterion("SVC_PRODUCT_TYPE between", value1, value2, "svcProductType");
            return (Criteria) this;
        }

        public Criteria andSvcProductTypeNotBetween(String value1, String value2) {
            addCriterion("SVC_PRODUCT_TYPE not between", value1, value2, "svcProductType");
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