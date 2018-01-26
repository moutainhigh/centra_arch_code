package com.ai.opt.data.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class LoginLogCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public LoginLogCriteria() {
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

        public Criteria andIdIsNull() {
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("Id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("Id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andLoginDateIsNull() {
            addCriterion("login_date is null");
            return (Criteria) this;
        }

        public Criteria andLoginDateIsNotNull() {
            addCriterion("login_date is not null");
            return (Criteria) this;
        }

        public Criteria andLoginDateEqualTo(Integer value) {
            addCriterion("login_date =", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateNotEqualTo(Integer value) {
            addCriterion("login_date <>", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateGreaterThan(Integer value) {
            addCriterion("login_date >", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_date >=", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateLessThan(Integer value) {
            addCriterion("login_date <", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateLessThanOrEqualTo(Integer value) {
            addCriterion("login_date <=", value, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateIn(List<Integer> values) {
            addCriterion("login_date in", values, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateNotIn(List<Integer> values) {
            addCriterion("login_date not in", values, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateBetween(Integer value1, Integer value2) {
            addCriterion("login_date between", value1, value2, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDateNotBetween(Integer value1, Integer value2) {
            addCriterion("login_date not between", value1, value2, "loginDate");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeIsNull() {
            addCriterion("login_dateTime is null");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeIsNotNull() {
            addCriterion("login_dateTime is not null");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeEqualTo(Timestamp value) {
            addCriterion("login_dateTime =", value, "loginDatetime");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeNotEqualTo(Timestamp value) {
            addCriterion("login_dateTime <>", value, "loginDatetime");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeGreaterThan(Timestamp value) {
            addCriterion("login_dateTime >", value, "loginDatetime");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("login_dateTime >=", value, "loginDatetime");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeLessThan(Timestamp value) {
            addCriterion("login_dateTime <", value, "loginDatetime");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("login_dateTime <=", value, "loginDatetime");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeIn(List<Timestamp> values) {
            addCriterion("login_dateTime in", values, "loginDatetime");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeNotIn(List<Timestamp> values) {
            addCriterion("login_dateTime not in", values, "loginDatetime");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("login_dateTime between", value1, value2, "loginDatetime");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("login_dateTime not between", value1, value2, "loginDatetime");
            return (Criteria) this;
        }

        public Criteria andSystemSourceIsNull() {
            addCriterion("system_source is null");
            return (Criteria) this;
        }

        public Criteria andSystemSourceIsNotNull() {
            addCriterion("system_source is not null");
            return (Criteria) this;
        }

        public Criteria andSystemSourceEqualTo(String value) {
            addCriterion("system_source =", value, "systemSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceNotEqualTo(String value) {
            addCriterion("system_source <>", value, "systemSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceGreaterThan(String value) {
            addCriterion("system_source >", value, "systemSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceGreaterThanOrEqualTo(String value) {
            addCriterion("system_source >=", value, "systemSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceLessThan(String value) {
            addCriterion("system_source <", value, "systemSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceLessThanOrEqualTo(String value) {
            addCriterion("system_source <=", value, "systemSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceLike(String value) {
            addCriterion("system_source like", value, "systemSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceNotLike(String value) {
            addCriterion("system_source not like", value, "systemSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceIn(List<String> values) {
            addCriterion("system_source in", values, "systemSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceNotIn(List<String> values) {
            addCriterion("system_source not in", values, "systemSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceBetween(String value1, String value2) {
            addCriterion("system_source between", value1, value2, "systemSource");
            return (Criteria) this;
        }

        public Criteria andSystemSourceNotBetween(String value1, String value2) {
            addCriterion("system_source not between", value1, value2, "systemSource");
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