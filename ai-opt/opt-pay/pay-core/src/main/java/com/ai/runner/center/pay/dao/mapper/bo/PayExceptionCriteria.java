package com.ai.runner.center.pay.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PayExceptionCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public PayExceptionCriteria() {
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

        public Criteria andPayIdIsNull() {
            addCriterion("pay_id is null");
            return (Criteria) this;
        }

        public Criteria andPayIdIsNotNull() {
            addCriterion("pay_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayIdEqualTo(Long value) {
            addCriterion("pay_id =", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotEqualTo(Long value) {
            addCriterion("pay_id <>", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdGreaterThan(Long value) {
            addCriterion("pay_id >", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_id >=", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLessThan(Long value) {
            addCriterion("pay_id <", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLessThanOrEqualTo(Long value) {
            addCriterion("pay_id <=", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdIn(List<Long> values) {
            addCriterion("pay_id in", values, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotIn(List<Long> values) {
            addCriterion("pay_id not in", values, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdBetween(Long value1, Long value2) {
            addCriterion("pay_id between", value1, value2, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotBetween(Long value1, Long value2) {
            addCriterion("pay_id not between", value1, value2, "payId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("tenant_id like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("tenant_id not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andTradeOrderIdIsNull() {
            addCriterion("trade_order_id is null");
            return (Criteria) this;
        }

        public Criteria andTradeOrderIdIsNotNull() {
            addCriterion("trade_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andTradeOrderIdEqualTo(String value) {
            addCriterion("trade_order_id =", value, "tradeOrderId");
            return (Criteria) this;
        }

        public Criteria andTradeOrderIdNotEqualTo(String value) {
            addCriterion("trade_order_id <>", value, "tradeOrderId");
            return (Criteria) this;
        }

        public Criteria andTradeOrderIdGreaterThan(String value) {
            addCriterion("trade_order_id >", value, "tradeOrderId");
            return (Criteria) this;
        }

        public Criteria andTradeOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("trade_order_id >=", value, "tradeOrderId");
            return (Criteria) this;
        }

        public Criteria andTradeOrderIdLessThan(String value) {
            addCriterion("trade_order_id <", value, "tradeOrderId");
            return (Criteria) this;
        }

        public Criteria andTradeOrderIdLessThanOrEqualTo(String value) {
            addCriterion("trade_order_id <=", value, "tradeOrderId");
            return (Criteria) this;
        }

        public Criteria andTradeOrderIdLike(String value) {
            addCriterion("trade_order_id like", value, "tradeOrderId");
            return (Criteria) this;
        }

        public Criteria andTradeOrderIdNotLike(String value) {
            addCriterion("trade_order_id not like", value, "tradeOrderId");
            return (Criteria) this;
        }

        public Criteria andTradeOrderIdIn(List<String> values) {
            addCriterion("trade_order_id in", values, "tradeOrderId");
            return (Criteria) this;
        }

        public Criteria andTradeOrderIdNotIn(List<String> values) {
            addCriterion("trade_order_id not in", values, "tradeOrderId");
            return (Criteria) this;
        }

        public Criteria andTradeOrderIdBetween(String value1, String value2) {
            addCriterion("trade_order_id between", value1, value2, "tradeOrderId");
            return (Criteria) this;
        }

        public Criteria andTradeOrderIdNotBetween(String value1, String value2) {
            addCriterion("trade_order_id not between", value1, value2, "tradeOrderId");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andRequestSourceIsNull() {
            addCriterion("request_source is null");
            return (Criteria) this;
        }

        public Criteria andRequestSourceIsNotNull() {
            addCriterion("request_source is not null");
            return (Criteria) this;
        }

        public Criteria andRequestSourceEqualTo(String value) {
            addCriterion("request_source =", value, "requestSource");
            return (Criteria) this;
        }

        public Criteria andRequestSourceNotEqualTo(String value) {
            addCriterion("request_source <>", value, "requestSource");
            return (Criteria) this;
        }

        public Criteria andRequestSourceGreaterThan(String value) {
            addCriterion("request_source >", value, "requestSource");
            return (Criteria) this;
        }

        public Criteria andRequestSourceGreaterThanOrEqualTo(String value) {
            addCriterion("request_source >=", value, "requestSource");
            return (Criteria) this;
        }

        public Criteria andRequestSourceLessThan(String value) {
            addCriterion("request_source <", value, "requestSource");
            return (Criteria) this;
        }

        public Criteria andRequestSourceLessThanOrEqualTo(String value) {
            addCriterion("request_source <=", value, "requestSource");
            return (Criteria) this;
        }

        public Criteria andRequestSourceLike(String value) {
            addCriterion("request_source like", value, "requestSource");
            return (Criteria) this;
        }

        public Criteria andRequestSourceNotLike(String value) {
            addCriterion("request_source not like", value, "requestSource");
            return (Criteria) this;
        }

        public Criteria andRequestSourceIn(List<String> values) {
            addCriterion("request_source in", values, "requestSource");
            return (Criteria) this;
        }

        public Criteria andRequestSourceNotIn(List<String> values) {
            addCriterion("request_source not in", values, "requestSource");
            return (Criteria) this;
        }

        public Criteria andRequestSourceBetween(String value1, String value2) {
            addCriterion("request_source between", value1, value2, "requestSource");
            return (Criteria) this;
        }

        public Criteria andRequestSourceNotBetween(String value1, String value2) {
            addCriterion("request_source not between", value1, value2, "requestSource");
            return (Criteria) this;
        }

        public Criteria andPayRequestTypeIsNull() {
            addCriterion("pay_request_type is null");
            return (Criteria) this;
        }

        public Criteria andPayRequestTypeIsNotNull() {
            addCriterion("pay_request_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayRequestTypeEqualTo(Integer value) {
            addCriterion("pay_request_type =", value, "payRequestType");
            return (Criteria) this;
        }

        public Criteria andPayRequestTypeNotEqualTo(Integer value) {
            addCriterion("pay_request_type <>", value, "payRequestType");
            return (Criteria) this;
        }

        public Criteria andPayRequestTypeGreaterThan(Integer value) {
            addCriterion("pay_request_type >", value, "payRequestType");
            return (Criteria) this;
        }

        public Criteria andPayRequestTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_request_type >=", value, "payRequestType");
            return (Criteria) this;
        }

        public Criteria andPayRequestTypeLessThan(Integer value) {
            addCriterion("pay_request_type <", value, "payRequestType");
            return (Criteria) this;
        }

        public Criteria andPayRequestTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_request_type <=", value, "payRequestType");
            return (Criteria) this;
        }

        public Criteria andPayRequestTypeIn(List<Integer> values) {
            addCriterion("pay_request_type in", values, "payRequestType");
            return (Criteria) this;
        }

        public Criteria andPayRequestTypeNotIn(List<Integer> values) {
            addCriterion("pay_request_type not in", values, "payRequestType");
            return (Criteria) this;
        }

        public Criteria andPayRequestTypeBetween(Integer value1, Integer value2) {
            addCriterion("pay_request_type between", value1, value2, "payRequestType");
            return (Criteria) this;
        }

        public Criteria andPayRequestTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_request_type not between", value1, value2, "payRequestType");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNull() {
            addCriterion("pay_amount is null");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNotNull() {
            addCriterion("pay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPayAmountEqualTo(Long value) {
            addCriterion("pay_amount =", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotEqualTo(Long value) {
            addCriterion("pay_amount <>", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThan(Long value) {
            addCriterion("pay_amount >", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_amount >=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThan(Long value) {
            addCriterion("pay_amount <", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThanOrEqualTo(Long value) {
            addCriterion("pay_amount <=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountIn(List<Long> values) {
            addCriterion("pay_amount in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotIn(List<Long> values) {
            addCriterion("pay_amount not in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountBetween(Long value1, Long value2) {
            addCriterion("pay_amount between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotBetween(Long value1, Long value2) {
            addCriterion("pay_amount not between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitIsNull() {
            addCriterion("CURRENCY_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitIsNotNull() {
            addCriterion("CURRENCY_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitEqualTo(String value) {
            addCriterion("CURRENCY_UNIT =", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitNotEqualTo(String value) {
            addCriterion("CURRENCY_UNIT <>", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitGreaterThan(String value) {
            addCriterion("CURRENCY_UNIT >", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitGreaterThanOrEqualTo(String value) {
            addCriterion("CURRENCY_UNIT >=", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitLessThan(String value) {
            addCriterion("CURRENCY_UNIT <", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitLessThanOrEqualTo(String value) {
            addCriterion("CURRENCY_UNIT <=", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitLike(String value) {
            addCriterion("CURRENCY_UNIT like", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitNotLike(String value) {
            addCriterion("CURRENCY_UNIT not like", value, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitIn(List<String> values) {
            addCriterion("CURRENCY_UNIT in", values, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitNotIn(List<String> values) {
            addCriterion("CURRENCY_UNIT not in", values, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitBetween(String value1, String value2) {
            addCriterion("CURRENCY_UNIT between", value1, value2, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andCurrencyUnitNotBetween(String value1, String value2) {
            addCriterion("CURRENCY_UNIT not between", value1, value2, "currencyUnit");
            return (Criteria) this;
        }

        public Criteria andPayOrgIdIsNull() {
            addCriterion("pay_org_id is null");
            return (Criteria) this;
        }

        public Criteria andPayOrgIdIsNotNull() {
            addCriterion("pay_org_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayOrgIdEqualTo(String value) {
            addCriterion("pay_org_id =", value, "payOrgId");
            return (Criteria) this;
        }

        public Criteria andPayOrgIdNotEqualTo(String value) {
            addCriterion("pay_org_id <>", value, "payOrgId");
            return (Criteria) this;
        }

        public Criteria andPayOrgIdGreaterThan(String value) {
            addCriterion("pay_org_id >", value, "payOrgId");
            return (Criteria) this;
        }

        public Criteria andPayOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("pay_org_id >=", value, "payOrgId");
            return (Criteria) this;
        }

        public Criteria andPayOrgIdLessThan(String value) {
            addCriterion("pay_org_id <", value, "payOrgId");
            return (Criteria) this;
        }

        public Criteria andPayOrgIdLessThanOrEqualTo(String value) {
            addCriterion("pay_org_id <=", value, "payOrgId");
            return (Criteria) this;
        }

        public Criteria andPayOrgIdLike(String value) {
            addCriterion("pay_org_id like", value, "payOrgId");
            return (Criteria) this;
        }

        public Criteria andPayOrgIdNotLike(String value) {
            addCriterion("pay_org_id not like", value, "payOrgId");
            return (Criteria) this;
        }

        public Criteria andPayOrgIdIn(List<String> values) {
            addCriterion("pay_org_id in", values, "payOrgId");
            return (Criteria) this;
        }

        public Criteria andPayOrgIdNotIn(List<String> values) {
            addCriterion("pay_org_id not in", values, "payOrgId");
            return (Criteria) this;
        }

        public Criteria andPayOrgIdBetween(String value1, String value2) {
            addCriterion("pay_org_id between", value1, value2, "payOrgId");
            return (Criteria) this;
        }

        public Criteria andPayOrgIdNotBetween(String value1, String value2) {
            addCriterion("pay_org_id not between", value1, value2, "payOrgId");
            return (Criteria) this;
        }

        public Criteria andPayOrgSerialIsNull() {
            addCriterion("pay_org_serial is null");
            return (Criteria) this;
        }

        public Criteria andPayOrgSerialIsNotNull() {
            addCriterion("pay_org_serial is not null");
            return (Criteria) this;
        }

        public Criteria andPayOrgSerialEqualTo(String value) {
            addCriterion("pay_org_serial =", value, "payOrgSerial");
            return (Criteria) this;
        }

        public Criteria andPayOrgSerialNotEqualTo(String value) {
            addCriterion("pay_org_serial <>", value, "payOrgSerial");
            return (Criteria) this;
        }

        public Criteria andPayOrgSerialGreaterThan(String value) {
            addCriterion("pay_org_serial >", value, "payOrgSerial");
            return (Criteria) this;
        }

        public Criteria andPayOrgSerialGreaterThanOrEqualTo(String value) {
            addCriterion("pay_org_serial >=", value, "payOrgSerial");
            return (Criteria) this;
        }

        public Criteria andPayOrgSerialLessThan(String value) {
            addCriterion("pay_org_serial <", value, "payOrgSerial");
            return (Criteria) this;
        }

        public Criteria andPayOrgSerialLessThanOrEqualTo(String value) {
            addCriterion("pay_org_serial <=", value, "payOrgSerial");
            return (Criteria) this;
        }

        public Criteria andPayOrgSerialLike(String value) {
            addCriterion("pay_org_serial like", value, "payOrgSerial");
            return (Criteria) this;
        }

        public Criteria andPayOrgSerialNotLike(String value) {
            addCriterion("pay_org_serial not like", value, "payOrgSerial");
            return (Criteria) this;
        }

        public Criteria andPayOrgSerialIn(List<String> values) {
            addCriterion("pay_org_serial in", values, "payOrgSerial");
            return (Criteria) this;
        }

        public Criteria andPayOrgSerialNotIn(List<String> values) {
            addCriterion("pay_org_serial not in", values, "payOrgSerial");
            return (Criteria) this;
        }

        public Criteria andPayOrgSerialBetween(String value1, String value2) {
            addCriterion("pay_org_serial between", value1, value2, "payOrgSerial");
            return (Criteria) this;
        }

        public Criteria andPayOrgSerialNotBetween(String value1, String value2) {
            addCriterion("pay_org_serial not between", value1, value2, "payOrgSerial");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNull() {
            addCriterion("notify_url is null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNotNull() {
            addCriterion("notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlEqualTo(String value) {
            addCriterion("notify_url =", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotEqualTo(String value) {
            addCriterion("notify_url <>", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThan(String value) {
            addCriterion("notify_url >", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("notify_url >=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThan(String value) {
            addCriterion("notify_url <", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("notify_url <=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLike(String value) {
            addCriterion("notify_url like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotLike(String value) {
            addCriterion("notify_url not like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIn(List<String> values) {
            addCriterion("notify_url in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotIn(List<String> values) {
            addCriterion("notify_url not in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlBetween(String value1, String value2) {
            addCriterion("notify_url between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("notify_url not between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIsNull() {
            addCriterion("return_url is null");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIsNotNull() {
            addCriterion("return_url is not null");
            return (Criteria) this;
        }

        public Criteria andReturnUrlEqualTo(String value) {
            addCriterion("return_url =", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotEqualTo(String value) {
            addCriterion("return_url <>", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlGreaterThan(String value) {
            addCriterion("return_url >", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlGreaterThanOrEqualTo(String value) {
            addCriterion("return_url >=", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLessThan(String value) {
            addCriterion("return_url <", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLessThanOrEqualTo(String value) {
            addCriterion("return_url <=", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLike(String value) {
            addCriterion("return_url like", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotLike(String value) {
            addCriterion("return_url not like", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIn(List<String> values) {
            addCriterion("return_url in", values, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotIn(List<String> values) {
            addCriterion("return_url not in", values, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlBetween(String value1, String value2) {
            addCriterion("return_url between", value1, value2, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotBetween(String value1, String value2) {
            addCriterion("return_url not between", value1, value2, "returnUrl");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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