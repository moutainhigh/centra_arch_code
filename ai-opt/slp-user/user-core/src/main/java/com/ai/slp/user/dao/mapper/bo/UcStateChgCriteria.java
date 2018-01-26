package com.ai.slp.user.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UcStateChgCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public UcStateChgCriteria() {
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

        public Criteria andStateChgIdIsNull() {
            addCriterion("STATE_CHG_ID is null");
            return (Criteria) this;
        }

        public Criteria andStateChgIdIsNotNull() {
            addCriterion("STATE_CHG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStateChgIdEqualTo(String value) {
            addCriterion("STATE_CHG_ID =", value, "stateChgId");
            return (Criteria) this;
        }

        public Criteria andStateChgIdNotEqualTo(String value) {
            addCriterion("STATE_CHG_ID <>", value, "stateChgId");
            return (Criteria) this;
        }

        public Criteria andStateChgIdGreaterThan(String value) {
            addCriterion("STATE_CHG_ID >", value, "stateChgId");
            return (Criteria) this;
        }

        public Criteria andStateChgIdGreaterThanOrEqualTo(String value) {
            addCriterion("STATE_CHG_ID >=", value, "stateChgId");
            return (Criteria) this;
        }

        public Criteria andStateChgIdLessThan(String value) {
            addCriterion("STATE_CHG_ID <", value, "stateChgId");
            return (Criteria) this;
        }

        public Criteria andStateChgIdLessThanOrEqualTo(String value) {
            addCriterion("STATE_CHG_ID <=", value, "stateChgId");
            return (Criteria) this;
        }

        public Criteria andStateChgIdLike(String value) {
            addCriterion("STATE_CHG_ID like", value, "stateChgId");
            return (Criteria) this;
        }

        public Criteria andStateChgIdNotLike(String value) {
            addCriterion("STATE_CHG_ID not like", value, "stateChgId");
            return (Criteria) this;
        }

        public Criteria andStateChgIdIn(List<String> values) {
            addCriterion("STATE_CHG_ID in", values, "stateChgId");
            return (Criteria) this;
        }

        public Criteria andStateChgIdNotIn(List<String> values) {
            addCriterion("STATE_CHG_ID not in", values, "stateChgId");
            return (Criteria) this;
        }

        public Criteria andStateChgIdBetween(String value1, String value2) {
            addCriterion("STATE_CHG_ID between", value1, value2, "stateChgId");
            return (Criteria) this;
        }

        public Criteria andStateChgIdNotBetween(String value1, String value2) {
            addCriterion("STATE_CHG_ID not between", value1, value2, "stateChgId");
            return (Criteria) this;
        }

        public Criteria andOperTypeIsNull() {
            addCriterion("OPER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOperTypeIsNotNull() {
            addCriterion("OPER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOperTypeEqualTo(String value) {
            addCriterion("OPER_TYPE =", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotEqualTo(String value) {
            addCriterion("OPER_TYPE <>", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeGreaterThan(String value) {
            addCriterion("OPER_TYPE >", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeGreaterThanOrEqualTo(String value) {
            addCriterion("OPER_TYPE >=", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLessThan(String value) {
            addCriterion("OPER_TYPE <", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLessThanOrEqualTo(String value) {
            addCriterion("OPER_TYPE <=", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLike(String value) {
            addCriterion("OPER_TYPE like", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotLike(String value) {
            addCriterion("OPER_TYPE not like", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeIn(List<String> values) {
            addCriterion("OPER_TYPE in", values, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotIn(List<String> values) {
            addCriterion("OPER_TYPE not in", values, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeBetween(String value1, String value2) {
            addCriterion("OPER_TYPE between", value1, value2, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotBetween(String value1, String value2) {
            addCriterion("OPER_TYPE not between", value1, value2, "operType");
            return (Criteria) this;
        }

        public Criteria andOldStateIsNull() {
            addCriterion("OLD_STATE is null");
            return (Criteria) this;
        }

        public Criteria andOldStateIsNotNull() {
            addCriterion("OLD_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andOldStateEqualTo(String value) {
            addCriterion("OLD_STATE =", value, "oldState");
            return (Criteria) this;
        }

        public Criteria andOldStateNotEqualTo(String value) {
            addCriterion("OLD_STATE <>", value, "oldState");
            return (Criteria) this;
        }

        public Criteria andOldStateGreaterThan(String value) {
            addCriterion("OLD_STATE >", value, "oldState");
            return (Criteria) this;
        }

        public Criteria andOldStateGreaterThanOrEqualTo(String value) {
            addCriterion("OLD_STATE >=", value, "oldState");
            return (Criteria) this;
        }

        public Criteria andOldStateLessThan(String value) {
            addCriterion("OLD_STATE <", value, "oldState");
            return (Criteria) this;
        }

        public Criteria andOldStateLessThanOrEqualTo(String value) {
            addCriterion("OLD_STATE <=", value, "oldState");
            return (Criteria) this;
        }

        public Criteria andOldStateLike(String value) {
            addCriterion("OLD_STATE like", value, "oldState");
            return (Criteria) this;
        }

        public Criteria andOldStateNotLike(String value) {
            addCriterion("OLD_STATE not like", value, "oldState");
            return (Criteria) this;
        }

        public Criteria andOldStateIn(List<String> values) {
            addCriterion("OLD_STATE in", values, "oldState");
            return (Criteria) this;
        }

        public Criteria andOldStateNotIn(List<String> values) {
            addCriterion("OLD_STATE not in", values, "oldState");
            return (Criteria) this;
        }

        public Criteria andOldStateBetween(String value1, String value2) {
            addCriterion("OLD_STATE between", value1, value2, "oldState");
            return (Criteria) this;
        }

        public Criteria andOldStateNotBetween(String value1, String value2) {
            addCriterion("OLD_STATE not between", value1, value2, "oldState");
            return (Criteria) this;
        }

        public Criteria andNewStateIsNull() {
            addCriterion("NEW_STATE is null");
            return (Criteria) this;
        }

        public Criteria andNewStateIsNotNull() {
            addCriterion("NEW_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andNewStateEqualTo(String value) {
            addCriterion("NEW_STATE =", value, "newState");
            return (Criteria) this;
        }

        public Criteria andNewStateNotEqualTo(String value) {
            addCriterion("NEW_STATE <>", value, "newState");
            return (Criteria) this;
        }

        public Criteria andNewStateGreaterThan(String value) {
            addCriterion("NEW_STATE >", value, "newState");
            return (Criteria) this;
        }

        public Criteria andNewStateGreaterThanOrEqualTo(String value) {
            addCriterion("NEW_STATE >=", value, "newState");
            return (Criteria) this;
        }

        public Criteria andNewStateLessThan(String value) {
            addCriterion("NEW_STATE <", value, "newState");
            return (Criteria) this;
        }

        public Criteria andNewStateLessThanOrEqualTo(String value) {
            addCriterion("NEW_STATE <=", value, "newState");
            return (Criteria) this;
        }

        public Criteria andNewStateLike(String value) {
            addCriterion("NEW_STATE like", value, "newState");
            return (Criteria) this;
        }

        public Criteria andNewStateNotLike(String value) {
            addCriterion("NEW_STATE not like", value, "newState");
            return (Criteria) this;
        }

        public Criteria andNewStateIn(List<String> values) {
            addCriterion("NEW_STATE in", values, "newState");
            return (Criteria) this;
        }

        public Criteria andNewStateNotIn(List<String> values) {
            addCriterion("NEW_STATE not in", values, "newState");
            return (Criteria) this;
        }

        public Criteria andNewStateBetween(String value1, String value2) {
            addCriterion("NEW_STATE between", value1, value2, "newState");
            return (Criteria) this;
        }

        public Criteria andNewStateNotBetween(String value1, String value2) {
            addCriterion("NEW_STATE not between", value1, value2, "newState");
            return (Criteria) this;
        }

        public Criteria andChgDescIsNull() {
            addCriterion("CHG_DESC is null");
            return (Criteria) this;
        }

        public Criteria andChgDescIsNotNull() {
            addCriterion("CHG_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andChgDescEqualTo(String value) {
            addCriterion("CHG_DESC =", value, "chgDesc");
            return (Criteria) this;
        }

        public Criteria andChgDescNotEqualTo(String value) {
            addCriterion("CHG_DESC <>", value, "chgDesc");
            return (Criteria) this;
        }

        public Criteria andChgDescGreaterThan(String value) {
            addCriterion("CHG_DESC >", value, "chgDesc");
            return (Criteria) this;
        }

        public Criteria andChgDescGreaterThanOrEqualTo(String value) {
            addCriterion("CHG_DESC >=", value, "chgDesc");
            return (Criteria) this;
        }

        public Criteria andChgDescLessThan(String value) {
            addCriterion("CHG_DESC <", value, "chgDesc");
            return (Criteria) this;
        }

        public Criteria andChgDescLessThanOrEqualTo(String value) {
            addCriterion("CHG_DESC <=", value, "chgDesc");
            return (Criteria) this;
        }

        public Criteria andChgDescLike(String value) {
            addCriterion("CHG_DESC like", value, "chgDesc");
            return (Criteria) this;
        }

        public Criteria andChgDescNotLike(String value) {
            addCriterion("CHG_DESC not like", value, "chgDesc");
            return (Criteria) this;
        }

        public Criteria andChgDescIn(List<String> values) {
            addCriterion("CHG_DESC in", values, "chgDesc");
            return (Criteria) this;
        }

        public Criteria andChgDescNotIn(List<String> values) {
            addCriterion("CHG_DESC not in", values, "chgDesc");
            return (Criteria) this;
        }

        public Criteria andChgDescBetween(String value1, String value2) {
            addCriterion("CHG_DESC between", value1, value2, "chgDesc");
            return (Criteria) this;
        }

        public Criteria andChgDescNotBetween(String value1, String value2) {
            addCriterion("CHG_DESC not between", value1, value2, "chgDesc");
            return (Criteria) this;
        }

        public Criteria andChgTimeIsNull() {
            addCriterion("CHG_TIME is null");
            return (Criteria) this;
        }

        public Criteria andChgTimeIsNotNull() {
            addCriterion("CHG_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andChgTimeEqualTo(Timestamp value) {
            addCriterion("CHG_TIME =", value, "chgTime");
            return (Criteria) this;
        }

        public Criteria andChgTimeNotEqualTo(Timestamp value) {
            addCriterion("CHG_TIME <>", value, "chgTime");
            return (Criteria) this;
        }

        public Criteria andChgTimeGreaterThan(Timestamp value) {
            addCriterion("CHG_TIME >", value, "chgTime");
            return (Criteria) this;
        }

        public Criteria andChgTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("CHG_TIME >=", value, "chgTime");
            return (Criteria) this;
        }

        public Criteria andChgTimeLessThan(Timestamp value) {
            addCriterion("CHG_TIME <", value, "chgTime");
            return (Criteria) this;
        }

        public Criteria andChgTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("CHG_TIME <=", value, "chgTime");
            return (Criteria) this;
        }

        public Criteria andChgTimeIn(List<Timestamp> values) {
            addCriterion("CHG_TIME in", values, "chgTime");
            return (Criteria) this;
        }

        public Criteria andChgTimeNotIn(List<Timestamp> values) {
            addCriterion("CHG_TIME not in", values, "chgTime");
            return (Criteria) this;
        }

        public Criteria andChgTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CHG_TIME between", value1, value2, "chgTime");
            return (Criteria) this;
        }

        public Criteria andChgTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("CHG_TIME not between", value1, value2, "chgTime");
            return (Criteria) this;
        }

        public Criteria andChlIdIsNull() {
            addCriterion("CHL_ID is null");
            return (Criteria) this;
        }

        public Criteria andChlIdIsNotNull() {
            addCriterion("CHL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andChlIdEqualTo(String value) {
            addCriterion("CHL_ID =", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdNotEqualTo(String value) {
            addCriterion("CHL_ID <>", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdGreaterThan(String value) {
            addCriterion("CHL_ID >", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdGreaterThanOrEqualTo(String value) {
            addCriterion("CHL_ID >=", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdLessThan(String value) {
            addCriterion("CHL_ID <", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdLessThanOrEqualTo(String value) {
            addCriterion("CHL_ID <=", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdLike(String value) {
            addCriterion("CHL_ID like", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdNotLike(String value) {
            addCriterion("CHL_ID not like", value, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdIn(List<String> values) {
            addCriterion("CHL_ID in", values, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdNotIn(List<String> values) {
            addCriterion("CHL_ID not in", values, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdBetween(String value1, String value2) {
            addCriterion("CHL_ID between", value1, value2, "chlId");
            return (Criteria) this;
        }

        public Criteria andChlIdNotBetween(String value1, String value2) {
            addCriterion("CHL_ID not between", value1, value2, "chlId");
            return (Criteria) this;
        }

        public Criteria andOperIdIsNull() {
            addCriterion("OPER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOperIdIsNotNull() {
            addCriterion("OPER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOperIdEqualTo(Long value) {
            addCriterion("OPER_ID =", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotEqualTo(Long value) {
            addCriterion("OPER_ID <>", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdGreaterThan(Long value) {
            addCriterion("OPER_ID >", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdGreaterThanOrEqualTo(Long value) {
            addCriterion("OPER_ID >=", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdLessThan(Long value) {
            addCriterion("OPER_ID <", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdLessThanOrEqualTo(Long value) {
            addCriterion("OPER_ID <=", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdIn(List<Long> values) {
            addCriterion("OPER_ID in", values, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotIn(List<Long> values) {
            addCriterion("OPER_ID not in", values, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdBetween(Long value1, Long value2) {
            addCriterion("OPER_ID between", value1, value2, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotBetween(Long value1, Long value2) {
            addCriterion("OPER_ID not between", value1, value2, "operId");
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