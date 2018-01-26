package com.ifudata.ums.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class SgipTemplateCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public SgipTemplateCriteria() {
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

        public Criteria andTemplateIdIsNull() {
            addCriterion("TEMPLATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNotNull() {
            addCriterion("TEMPLATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdEqualTo(Long value) {
            addCriterion("TEMPLATE_ID =", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotEqualTo(Long value) {
            addCriterion("TEMPLATE_ID <>", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThan(Long value) {
            addCriterion("TEMPLATE_ID >", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("TEMPLATE_ID >=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThan(Long value) {
            addCriterion("TEMPLATE_ID <", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThanOrEqualTo(Long value) {
            addCriterion("TEMPLATE_ID <=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIn(List<Long> values) {
            addCriterion("TEMPLATE_ID in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotIn(List<Long> values) {
            addCriterion("TEMPLATE_ID not in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdBetween(Long value1, Long value2) {
            addCriterion("TEMPLATE_ID between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotBetween(Long value1, Long value2) {
            addCriterion("TEMPLATE_ID not between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateTextIsNull() {
            addCriterion("template_text is null");
            return (Criteria) this;
        }

        public Criteria andTemplateTextIsNotNull() {
            addCriterion("template_text is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateTextEqualTo(String value) {
            addCriterion("template_text =", value, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateTextNotEqualTo(String value) {
            addCriterion("template_text <>", value, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateTextGreaterThan(String value) {
            addCriterion("template_text >", value, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateTextGreaterThanOrEqualTo(String value) {
            addCriterion("template_text >=", value, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateTextLessThan(String value) {
            addCriterion("template_text <", value, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateTextLessThanOrEqualTo(String value) {
            addCriterion("template_text <=", value, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateTextLike(String value) {
            addCriterion("template_text like", value, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateTextNotLike(String value) {
            addCriterion("template_text not like", value, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateTextIn(List<String> values) {
            addCriterion("template_text in", values, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateTextNotIn(List<String> values) {
            addCriterion("template_text not in", values, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateTextBetween(String value1, String value2) {
            addCriterion("template_text between", value1, value2, "templateText");
            return (Criteria) this;
        }

        public Criteria andTemplateTextNotBetween(String value1, String value2) {
            addCriterion("template_text not between", value1, value2, "templateText");
            return (Criteria) this;
        }

        public Criteria andSbeginTimeIsNull() {
            addCriterion("sbegin_time is null");
            return (Criteria) this;
        }

        public Criteria andSbeginTimeIsNotNull() {
            addCriterion("sbegin_time is not null");
            return (Criteria) this;
        }

        public Criteria andSbeginTimeEqualTo(String value) {
            addCriterion("sbegin_time =", value, "sbeginTime");
            return (Criteria) this;
        }

        public Criteria andSbeginTimeNotEqualTo(String value) {
            addCriterion("sbegin_time <>", value, "sbeginTime");
            return (Criteria) this;
        }

        public Criteria andSbeginTimeGreaterThan(String value) {
            addCriterion("sbegin_time >", value, "sbeginTime");
            return (Criteria) this;
        }

        public Criteria andSbeginTimeGreaterThanOrEqualTo(String value) {
            addCriterion("sbegin_time >=", value, "sbeginTime");
            return (Criteria) this;
        }

        public Criteria andSbeginTimeLessThan(String value) {
            addCriterion("sbegin_time <", value, "sbeginTime");
            return (Criteria) this;
        }

        public Criteria andSbeginTimeLessThanOrEqualTo(String value) {
            addCriterion("sbegin_time <=", value, "sbeginTime");
            return (Criteria) this;
        }

        public Criteria andSbeginTimeLike(String value) {
            addCriterion("sbegin_time like", value, "sbeginTime");
            return (Criteria) this;
        }

        public Criteria andSbeginTimeNotLike(String value) {
            addCriterion("sbegin_time not like", value, "sbeginTime");
            return (Criteria) this;
        }

        public Criteria andSbeginTimeIn(List<String> values) {
            addCriterion("sbegin_time in", values, "sbeginTime");
            return (Criteria) this;
        }

        public Criteria andSbeginTimeNotIn(List<String> values) {
            addCriterion("sbegin_time not in", values, "sbeginTime");
            return (Criteria) this;
        }

        public Criteria andSbeginTimeBetween(String value1, String value2) {
            addCriterion("sbegin_time between", value1, value2, "sbeginTime");
            return (Criteria) this;
        }

        public Criteria andSbeginTimeNotBetween(String value1, String value2) {
            addCriterion("sbegin_time not between", value1, value2, "sbeginTime");
            return (Criteria) this;
        }

        public Criteria andScloseTimeIsNull() {
            addCriterion("sclose_time is null");
            return (Criteria) this;
        }

        public Criteria andScloseTimeIsNotNull() {
            addCriterion("sclose_time is not null");
            return (Criteria) this;
        }

        public Criteria andScloseTimeEqualTo(String value) {
            addCriterion("sclose_time =", value, "scloseTime");
            return (Criteria) this;
        }

        public Criteria andScloseTimeNotEqualTo(String value) {
            addCriterion("sclose_time <>", value, "scloseTime");
            return (Criteria) this;
        }

        public Criteria andScloseTimeGreaterThan(String value) {
            addCriterion("sclose_time >", value, "scloseTime");
            return (Criteria) this;
        }

        public Criteria andScloseTimeGreaterThanOrEqualTo(String value) {
            addCriterion("sclose_time >=", value, "scloseTime");
            return (Criteria) this;
        }

        public Criteria andScloseTimeLessThan(String value) {
            addCriterion("sclose_time <", value, "scloseTime");
            return (Criteria) this;
        }

        public Criteria andScloseTimeLessThanOrEqualTo(String value) {
            addCriterion("sclose_time <=", value, "scloseTime");
            return (Criteria) this;
        }

        public Criteria andScloseTimeLike(String value) {
            addCriterion("sclose_time like", value, "scloseTime");
            return (Criteria) this;
        }

        public Criteria andScloseTimeNotLike(String value) {
            addCriterion("sclose_time not like", value, "scloseTime");
            return (Criteria) this;
        }

        public Criteria andScloseTimeIn(List<String> values) {
            addCriterion("sclose_time in", values, "scloseTime");
            return (Criteria) this;
        }

        public Criteria andScloseTimeNotIn(List<String> values) {
            addCriterion("sclose_time not in", values, "scloseTime");
            return (Criteria) this;
        }

        public Criteria andScloseTimeBetween(String value1, String value2) {
            addCriterion("sclose_time between", value1, value2, "scloseTime");
            return (Criteria) this;
        }

        public Criteria andScloseTimeNotBetween(String value1, String value2) {
            addCriterion("sclose_time not between", value1, value2, "scloseTime");
            return (Criteria) this;
        }

        public Criteria andRetryTimesIsNull() {
            addCriterion("Retry_times is null");
            return (Criteria) this;
        }

        public Criteria andRetryTimesIsNotNull() {
            addCriterion("Retry_times is not null");
            return (Criteria) this;
        }

        public Criteria andRetryTimesEqualTo(Integer value) {
            addCriterion("Retry_times =", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesNotEqualTo(Integer value) {
            addCriterion("Retry_times <>", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesGreaterThan(Integer value) {
            addCriterion("Retry_times >", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("Retry_times >=", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesLessThan(Integer value) {
            addCriterion("Retry_times <", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesLessThanOrEqualTo(Integer value) {
            addCriterion("Retry_times <=", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesIn(List<Integer> values) {
            addCriterion("Retry_times in", values, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesNotIn(List<Integer> values) {
            addCriterion("Retry_times not in", values, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesBetween(Integer value1, Integer value2) {
            addCriterion("Retry_times between", value1, value2, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("Retry_times not between", value1, value2, "retryTimes");
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