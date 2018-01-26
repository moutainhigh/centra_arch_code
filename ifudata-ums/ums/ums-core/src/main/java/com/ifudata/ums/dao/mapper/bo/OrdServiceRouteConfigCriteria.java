package com.ifudata.ums.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class OrdServiceRouteConfigCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public OrdServiceRouteConfigCriteria() {
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

        public Criteria andRouteIdIsNull() {
            addCriterion("route_id is null");
            return (Criteria) this;
        }

        public Criteria andRouteIdIsNotNull() {
            addCriterion("route_id is not null");
            return (Criteria) this;
        }

        public Criteria andRouteIdEqualTo(Long value) {
            addCriterion("route_id =", value, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdNotEqualTo(Long value) {
            addCriterion("route_id <>", value, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdGreaterThan(Long value) {
            addCriterion("route_id >", value, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdGreaterThanOrEqualTo(Long value) {
            addCriterion("route_id >=", value, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdLessThan(Long value) {
            addCriterion("route_id <", value, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdLessThanOrEqualTo(Long value) {
            addCriterion("route_id <=", value, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdIn(List<Long> values) {
            addCriterion("route_id in", values, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdNotIn(List<Long> values) {
            addCriterion("route_id not in", values, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdBetween(Long value1, Long value2) {
            addCriterion("route_id between", value1, value2, "routeId");
            return (Criteria) this;
        }

        public Criteria andRouteIdNotBetween(Long value1, Long value2) {
            addCriterion("route_id not between", value1, value2, "routeId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNull() {
            addCriterion("service_type is null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNotNull() {
            addCriterion("service_type is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeEqualTo(String value) {
            addCriterion("service_type =", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotEqualTo(String value) {
            addCriterion("service_type <>", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThan(String value) {
            addCriterion("service_type >", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("service_type >=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThan(String value) {
            addCriterion("service_type <", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThanOrEqualTo(String value) {
            addCriterion("service_type <=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLike(String value) {
            addCriterion("service_type like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotLike(String value) {
            addCriterion("service_type not like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIn(List<String> values) {
            addCriterion("service_type in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotIn(List<String> values) {
            addCriterion("service_type not in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeBetween(String value1, String value2) {
            addCriterion("service_type between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotBetween(String value1, String value2) {
            addCriterion("service_type not between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameIsNull() {
            addCriterion("route_param_name is null");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameIsNotNull() {
            addCriterion("route_param_name is not null");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameEqualTo(String value) {
            addCriterion("route_param_name =", value, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameNotEqualTo(String value) {
            addCriterion("route_param_name <>", value, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameGreaterThan(String value) {
            addCriterion("route_param_name >", value, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameGreaterThanOrEqualTo(String value) {
            addCriterion("route_param_name >=", value, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameLessThan(String value) {
            addCriterion("route_param_name <", value, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameLessThanOrEqualTo(String value) {
            addCriterion("route_param_name <=", value, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameLike(String value) {
            addCriterion("route_param_name like", value, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameNotLike(String value) {
            addCriterion("route_param_name not like", value, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameIn(List<String> values) {
            addCriterion("route_param_name in", values, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameNotIn(List<String> values) {
            addCriterion("route_param_name not in", values, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameBetween(String value1, String value2) {
            addCriterion("route_param_name between", value1, value2, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamNameNotBetween(String value1, String value2) {
            addCriterion("route_param_name not between", value1, value2, "routeParamName");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueIsNull() {
            addCriterion("route_param_value is null");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueIsNotNull() {
            addCriterion("route_param_value is not null");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueEqualTo(String value) {
            addCriterion("route_param_value =", value, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueNotEqualTo(String value) {
            addCriterion("route_param_value <>", value, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueGreaterThan(String value) {
            addCriterion("route_param_value >", value, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueGreaterThanOrEqualTo(String value) {
            addCriterion("route_param_value >=", value, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueLessThan(String value) {
            addCriterion("route_param_value <", value, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueLessThanOrEqualTo(String value) {
            addCriterion("route_param_value <=", value, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueLike(String value) {
            addCriterion("route_param_value like", value, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueNotLike(String value) {
            addCriterion("route_param_value not like", value, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueIn(List<String> values) {
            addCriterion("route_param_value in", values, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueNotIn(List<String> values) {
            addCriterion("route_param_value not in", values, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueBetween(String value1, String value2) {
            addCriterion("route_param_value between", value1, value2, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteParamValueNotBetween(String value1, String value2) {
            addCriterion("route_param_value not between", value1, value2, "routeParamValue");
            return (Criteria) this;
        }

        public Criteria andRouteServiceIsNull() {
            addCriterion("route_service is null");
            return (Criteria) this;
        }

        public Criteria andRouteServiceIsNotNull() {
            addCriterion("route_service is not null");
            return (Criteria) this;
        }

        public Criteria andRouteServiceEqualTo(String value) {
            addCriterion("route_service =", value, "routeService");
            return (Criteria) this;
        }

        public Criteria andRouteServiceNotEqualTo(String value) {
            addCriterion("route_service <>", value, "routeService");
            return (Criteria) this;
        }

        public Criteria andRouteServiceGreaterThan(String value) {
            addCriterion("route_service >", value, "routeService");
            return (Criteria) this;
        }

        public Criteria andRouteServiceGreaterThanOrEqualTo(String value) {
            addCriterion("route_service >=", value, "routeService");
            return (Criteria) this;
        }

        public Criteria andRouteServiceLessThan(String value) {
            addCriterion("route_service <", value, "routeService");
            return (Criteria) this;
        }

        public Criteria andRouteServiceLessThanOrEqualTo(String value) {
            addCriterion("route_service <=", value, "routeService");
            return (Criteria) this;
        }

        public Criteria andRouteServiceLike(String value) {
            addCriterion("route_service like", value, "routeService");
            return (Criteria) this;
        }

        public Criteria andRouteServiceNotLike(String value) {
            addCriterion("route_service not like", value, "routeService");
            return (Criteria) this;
        }

        public Criteria andRouteServiceIn(List<String> values) {
            addCriterion("route_service in", values, "routeService");
            return (Criteria) this;
        }

        public Criteria andRouteServiceNotIn(List<String> values) {
            addCriterion("route_service not in", values, "routeService");
            return (Criteria) this;
        }

        public Criteria andRouteServiceBetween(String value1, String value2) {
            addCriterion("route_service between", value1, value2, "routeService");
            return (Criteria) this;
        }

        public Criteria andRouteServiceNotBetween(String value1, String value2) {
            addCriterion("route_service not between", value1, value2, "routeService");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
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