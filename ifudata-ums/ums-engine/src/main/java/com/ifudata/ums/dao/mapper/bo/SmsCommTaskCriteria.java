package com.ifudata.ums.dao.mapper.bo;

import java.util.ArrayList;
import java.util.List;

public class SmsCommTaskCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public SmsCommTaskCriteria() {
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

        public Criteria andCommTaskSerialIsNull() {
            addCriterion("comm_task_serial is null");
            return (Criteria) this;
        }

        public Criteria andCommTaskSerialIsNotNull() {
            addCriterion("comm_task_serial is not null");
            return (Criteria) this;
        }

        public Criteria andCommTaskSerialEqualTo(Integer value) {
            addCriterion("comm_task_serial =", value, "commTaskSerial");
            return (Criteria) this;
        }

        public Criteria andCommTaskSerialNotEqualTo(Integer value) {
            addCriterion("comm_task_serial <>", value, "commTaskSerial");
            return (Criteria) this;
        }

        public Criteria andCommTaskSerialGreaterThan(Integer value) {
            addCriterion("comm_task_serial >", value, "commTaskSerial");
            return (Criteria) this;
        }

        public Criteria andCommTaskSerialGreaterThanOrEqualTo(Integer value) {
            addCriterion("comm_task_serial >=", value, "commTaskSerial");
            return (Criteria) this;
        }

        public Criteria andCommTaskSerialLessThan(Integer value) {
            addCriterion("comm_task_serial <", value, "commTaskSerial");
            return (Criteria) this;
        }

        public Criteria andCommTaskSerialLessThanOrEqualTo(Integer value) {
            addCriterion("comm_task_serial <=", value, "commTaskSerial");
            return (Criteria) this;
        }

        public Criteria andCommTaskSerialIn(List<Integer> values) {
            addCriterion("comm_task_serial in", values, "commTaskSerial");
            return (Criteria) this;
        }

        public Criteria andCommTaskSerialNotIn(List<Integer> values) {
            addCriterion("comm_task_serial not in", values, "commTaskSerial");
            return (Criteria) this;
        }

        public Criteria andCommTaskSerialBetween(Integer value1, Integer value2) {
            addCriterion("comm_task_serial between", value1, value2, "commTaskSerial");
            return (Criteria) this;
        }

        public Criteria andCommTaskSerialNotBetween(Integer value1, Integer value2) {
            addCriterion("comm_task_serial not between", value1, value2, "commTaskSerial");
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

        public Criteria andRegionIdIsNull() {
            addCriterion("region_id is null");
            return (Criteria) this;
        }

        public Criteria andRegionIdIsNotNull() {
            addCriterion("region_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegionIdEqualTo(String value) {
            addCriterion("region_id =", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotEqualTo(String value) {
            addCriterion("region_id <>", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThan(String value) {
            addCriterion("region_id >", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThanOrEqualTo(String value) {
            addCriterion("region_id >=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThan(String value) {
            addCriterion("region_id <", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThanOrEqualTo(String value) {
            addCriterion("region_id <=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLike(String value) {
            addCriterion("region_id like", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotLike(String value) {
            addCriterion("region_id not like", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdIn(List<String> values) {
            addCriterion("region_id in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotIn(List<String> values) {
            addCriterion("region_id not in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdBetween(String value1, String value2) {
            addCriterion("region_id between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotBetween(String value1, String value2) {
            addCriterion("region_id not between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberIsNull() {
            addCriterion("device_number is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberIsNotNull() {
            addCriterion("device_number is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberEqualTo(String value) {
            addCriterion("device_number =", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotEqualTo(String value) {
            addCriterion("device_number <>", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberGreaterThan(String value) {
            addCriterion("device_number >", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberGreaterThanOrEqualTo(String value) {
            addCriterion("device_number >=", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberLessThan(String value) {
            addCriterion("device_number <", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberLessThanOrEqualTo(String value) {
            addCriterion("device_number <=", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberLike(String value) {
            addCriterion("device_number like", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotLike(String value) {
            addCriterion("device_number not like", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberIn(List<String> values) {
            addCriterion("device_number in", values, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotIn(List<String> values) {
            addCriterion("device_number not in", values, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberBetween(String value1, String value2) {
            addCriterion("device_number between", value1, value2, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotBetween(String value1, String value2) {
            addCriterion("device_number not between", value1, value2, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andRunStatusIsNull() {
            addCriterion("run_status is null");
            return (Criteria) this;
        }

        public Criteria andRunStatusIsNotNull() {
            addCriterion("run_status is not null");
            return (Criteria) this;
        }

        public Criteria andRunStatusEqualTo(String value) {
            addCriterion("run_status =", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusNotEqualTo(String value) {
            addCriterion("run_status <>", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusGreaterThan(String value) {
            addCriterion("run_status >", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusGreaterThanOrEqualTo(String value) {
            addCriterion("run_status >=", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusLessThan(String value) {
            addCriterion("run_status <", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusLessThanOrEqualTo(String value) {
            addCriterion("run_status <=", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusLike(String value) {
            addCriterion("run_status like", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusNotLike(String value) {
            addCriterion("run_status not like", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusIn(List<String> values) {
            addCriterion("run_status in", values, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusNotIn(List<String> values) {
            addCriterion("run_status not in", values, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusBetween(String value1, String value2) {
            addCriterion("run_status between", value1, value2, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusNotBetween(String value1, String value2) {
            addCriterion("run_status not between", value1, value2, "runStatus");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andTryNumIsNull() {
            addCriterion("try_num is null");
            return (Criteria) this;
        }

        public Criteria andTryNumIsNotNull() {
            addCriterion("try_num is not null");
            return (Criteria) this;
        }

        public Criteria andTryNumEqualTo(Integer value) {
            addCriterion("try_num =", value, "tryNum");
            return (Criteria) this;
        }

        public Criteria andTryNumNotEqualTo(Integer value) {
            addCriterion("try_num <>", value, "tryNum");
            return (Criteria) this;
        }

        public Criteria andTryNumGreaterThan(Integer value) {
            addCriterion("try_num >", value, "tryNum");
            return (Criteria) this;
        }

        public Criteria andTryNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("try_num >=", value, "tryNum");
            return (Criteria) this;
        }

        public Criteria andTryNumLessThan(Integer value) {
            addCriterion("try_num <", value, "tryNum");
            return (Criteria) this;
        }

        public Criteria andTryNumLessThanOrEqualTo(Integer value) {
            addCriterion("try_num <=", value, "tryNum");
            return (Criteria) this;
        }

        public Criteria andTryNumIn(List<Integer> values) {
            addCriterion("try_num in", values, "tryNum");
            return (Criteria) this;
        }

        public Criteria andTryNumNotIn(List<Integer> values) {
            addCriterion("try_num not in", values, "tryNum");
            return (Criteria) this;
        }

        public Criteria andTryNumBetween(Integer value1, Integer value2) {
            addCriterion("try_num between", value1, value2, "tryNum");
            return (Criteria) this;
        }

        public Criteria andTryNumNotBetween(Integer value1, Integer value2) {
            addCriterion("try_num not between", value1, value2, "tryNum");
            return (Criteria) this;
        }

        public Criteria andSpNumberIsNull() {
            addCriterion("sp_number is null");
            return (Criteria) this;
        }

        public Criteria andSpNumberIsNotNull() {
            addCriterion("sp_number is not null");
            return (Criteria) this;
        }

        public Criteria andSpNumberEqualTo(String value) {
            addCriterion("sp_number =", value, "spNumber");
            return (Criteria) this;
        }

        public Criteria andSpNumberNotEqualTo(String value) {
            addCriterion("sp_number <>", value, "spNumber");
            return (Criteria) this;
        }

        public Criteria andSpNumberGreaterThan(String value) {
            addCriterion("sp_number >", value, "spNumber");
            return (Criteria) this;
        }

        public Criteria andSpNumberGreaterThanOrEqualTo(String value) {
            addCriterion("sp_number >=", value, "spNumber");
            return (Criteria) this;
        }

        public Criteria andSpNumberLessThan(String value) {
            addCriterion("sp_number <", value, "spNumber");
            return (Criteria) this;
        }

        public Criteria andSpNumberLessThanOrEqualTo(String value) {
            addCriterion("sp_number <=", value, "spNumber");
            return (Criteria) this;
        }

        public Criteria andSpNumberLike(String value) {
            addCriterion("sp_number like", value, "spNumber");
            return (Criteria) this;
        }

        public Criteria andSpNumberNotLike(String value) {
            addCriterion("sp_number not like", value, "spNumber");
            return (Criteria) this;
        }

        public Criteria andSpNumberIn(List<String> values) {
            addCriterion("sp_number in", values, "spNumber");
            return (Criteria) this;
        }

        public Criteria andSpNumberNotIn(List<String> values) {
            addCriterion("sp_number not in", values, "spNumber");
            return (Criteria) this;
        }

        public Criteria andSpNumberBetween(String value1, String value2) {
            addCriterion("sp_number between", value1, value2, "spNumber");
            return (Criteria) this;
        }

        public Criteria andSpNumberNotBetween(String value1, String value2) {
            addCriterion("sp_number not between", value1, value2, "spNumber");
            return (Criteria) this;
        }

        public Criteria andReturnResultIsNull() {
            addCriterion("return_result is null");
            return (Criteria) this;
        }

        public Criteria andReturnResultIsNotNull() {
            addCriterion("return_result is not null");
            return (Criteria) this;
        }

        public Criteria andReturnResultEqualTo(Integer value) {
            addCriterion("return_result =", value, "returnResult");
            return (Criteria) this;
        }

        public Criteria andReturnResultNotEqualTo(Integer value) {
            addCriterion("return_result <>", value, "returnResult");
            return (Criteria) this;
        }

        public Criteria andReturnResultGreaterThan(Integer value) {
            addCriterion("return_result >", value, "returnResult");
            return (Criteria) this;
        }

        public Criteria andReturnResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_result >=", value, "returnResult");
            return (Criteria) this;
        }

        public Criteria andReturnResultLessThan(Integer value) {
            addCriterion("return_result <", value, "returnResult");
            return (Criteria) this;
        }

        public Criteria andReturnResultLessThanOrEqualTo(Integer value) {
            addCriterion("return_result <=", value, "returnResult");
            return (Criteria) this;
        }

        public Criteria andReturnResultIn(List<Integer> values) {
            addCriterion("return_result in", values, "returnResult");
            return (Criteria) this;
        }

        public Criteria andReturnResultNotIn(List<Integer> values) {
            addCriterion("return_result not in", values, "returnResult");
            return (Criteria) this;
        }

        public Criteria andReturnResultBetween(Integer value1, Integer value2) {
            addCriterion("return_result between", value1, value2, "returnResult");
            return (Criteria) this;
        }

        public Criteria andReturnResultNotBetween(Integer value1, Integer value2) {
            addCriterion("return_result not between", value1, value2, "returnResult");
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