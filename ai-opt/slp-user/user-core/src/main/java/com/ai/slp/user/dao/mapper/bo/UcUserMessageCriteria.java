package com.ai.slp.user.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UcUserMessageCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public UcUserMessageCriteria() {
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

        public Criteria andInfoSeqIdIsNull() {
            addCriterion("INFO_SEQ_ID is null");
            return (Criteria) this;
        }

        public Criteria andInfoSeqIdIsNotNull() {
            addCriterion("INFO_SEQ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInfoSeqIdEqualTo(String value) {
            addCriterion("INFO_SEQ_ID =", value, "infoSeqId");
            return (Criteria) this;
        }

        public Criteria andInfoSeqIdNotEqualTo(String value) {
            addCriterion("INFO_SEQ_ID <>", value, "infoSeqId");
            return (Criteria) this;
        }

        public Criteria andInfoSeqIdGreaterThan(String value) {
            addCriterion("INFO_SEQ_ID >", value, "infoSeqId");
            return (Criteria) this;
        }

        public Criteria andInfoSeqIdGreaterThanOrEqualTo(String value) {
            addCriterion("INFO_SEQ_ID >=", value, "infoSeqId");
            return (Criteria) this;
        }

        public Criteria andInfoSeqIdLessThan(String value) {
            addCriterion("INFO_SEQ_ID <", value, "infoSeqId");
            return (Criteria) this;
        }

        public Criteria andInfoSeqIdLessThanOrEqualTo(String value) {
            addCriterion("INFO_SEQ_ID <=", value, "infoSeqId");
            return (Criteria) this;
        }

        public Criteria andInfoSeqIdLike(String value) {
            addCriterion("INFO_SEQ_ID like", value, "infoSeqId");
            return (Criteria) this;
        }

        public Criteria andInfoSeqIdNotLike(String value) {
            addCriterion("INFO_SEQ_ID not like", value, "infoSeqId");
            return (Criteria) this;
        }

        public Criteria andInfoSeqIdIn(List<String> values) {
            addCriterion("INFO_SEQ_ID in", values, "infoSeqId");
            return (Criteria) this;
        }

        public Criteria andInfoSeqIdNotIn(List<String> values) {
            addCriterion("INFO_SEQ_ID not in", values, "infoSeqId");
            return (Criteria) this;
        }

        public Criteria andInfoSeqIdBetween(String value1, String value2) {
            addCriterion("INFO_SEQ_ID between", value1, value2, "infoSeqId");
            return (Criteria) this;
        }

        public Criteria andInfoSeqIdNotBetween(String value1, String value2) {
            addCriterion("INFO_SEQ_ID not between", value1, value2, "infoSeqId");
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

        public Criteria andInfoTypeIsNull() {
            addCriterion("INFO_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andInfoTypeIsNotNull() {
            addCriterion("INFO_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andInfoTypeEqualTo(String value) {
            addCriterion("INFO_TYPE =", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNotEqualTo(String value) {
            addCriterion("INFO_TYPE <>", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeGreaterThan(String value) {
            addCriterion("INFO_TYPE >", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeGreaterThanOrEqualTo(String value) {
            addCriterion("INFO_TYPE >=", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeLessThan(String value) {
            addCriterion("INFO_TYPE <", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeLessThanOrEqualTo(String value) {
            addCriterion("INFO_TYPE <=", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeLike(String value) {
            addCriterion("INFO_TYPE like", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNotLike(String value) {
            addCriterion("INFO_TYPE not like", value, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeIn(List<String> values) {
            addCriterion("INFO_TYPE in", values, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNotIn(List<String> values) {
            addCriterion("INFO_TYPE not in", values, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeBetween(String value1, String value2) {
            addCriterion("INFO_TYPE between", value1, value2, "infoType");
            return (Criteria) this;
        }

        public Criteria andInfoTypeNotBetween(String value1, String value2) {
            addCriterion("INFO_TYPE not between", value1, value2, "infoType");
            return (Criteria) this;
        }

        public Criteria andReadFlagIsNull() {
            addCriterion("READ_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andReadFlagIsNotNull() {
            addCriterion("READ_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andReadFlagEqualTo(String value) {
            addCriterion("READ_FLAG =", value, "readFlag");
            return (Criteria) this;
        }

        public Criteria andReadFlagNotEqualTo(String value) {
            addCriterion("READ_FLAG <>", value, "readFlag");
            return (Criteria) this;
        }

        public Criteria andReadFlagGreaterThan(String value) {
            addCriterion("READ_FLAG >", value, "readFlag");
            return (Criteria) this;
        }

        public Criteria andReadFlagGreaterThanOrEqualTo(String value) {
            addCriterion("READ_FLAG >=", value, "readFlag");
            return (Criteria) this;
        }

        public Criteria andReadFlagLessThan(String value) {
            addCriterion("READ_FLAG <", value, "readFlag");
            return (Criteria) this;
        }

        public Criteria andReadFlagLessThanOrEqualTo(String value) {
            addCriterion("READ_FLAG <=", value, "readFlag");
            return (Criteria) this;
        }

        public Criteria andReadFlagLike(String value) {
            addCriterion("READ_FLAG like", value, "readFlag");
            return (Criteria) this;
        }

        public Criteria andReadFlagNotLike(String value) {
            addCriterion("READ_FLAG not like", value, "readFlag");
            return (Criteria) this;
        }

        public Criteria andReadFlagIn(List<String> values) {
            addCriterion("READ_FLAG in", values, "readFlag");
            return (Criteria) this;
        }

        public Criteria andReadFlagNotIn(List<String> values) {
            addCriterion("READ_FLAG not in", values, "readFlag");
            return (Criteria) this;
        }

        public Criteria andReadFlagBetween(String value1, String value2) {
            addCriterion("READ_FLAG between", value1, value2, "readFlag");
            return (Criteria) this;
        }

        public Criteria andReadFlagNotBetween(String value1, String value2) {
            addCriterion("READ_FLAG not between", value1, value2, "readFlag");
            return (Criteria) this;
        }

        public Criteria andReadTimeIsNull() {
            addCriterion("READ_TIME is null");
            return (Criteria) this;
        }

        public Criteria andReadTimeIsNotNull() {
            addCriterion("READ_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andReadTimeEqualTo(Timestamp value) {
            addCriterion("READ_TIME =", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeNotEqualTo(Timestamp value) {
            addCriterion("READ_TIME <>", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeGreaterThan(Timestamp value) {
            addCriterion("READ_TIME >", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("READ_TIME >=", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeLessThan(Timestamp value) {
            addCriterion("READ_TIME <", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("READ_TIME <=", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeIn(List<Timestamp> values) {
            addCriterion("READ_TIME in", values, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeNotIn(List<Timestamp> values) {
            addCriterion("READ_TIME not in", values, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("READ_TIME between", value1, value2, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("READ_TIME not between", value1, value2, "readTime");
            return (Criteria) this;
        }

        public Criteria andInfoHeadlineIsNull() {
            addCriterion("INFO_HEADLINE is null");
            return (Criteria) this;
        }

        public Criteria andInfoHeadlineIsNotNull() {
            addCriterion("INFO_HEADLINE is not null");
            return (Criteria) this;
        }

        public Criteria andInfoHeadlineEqualTo(String value) {
            addCriterion("INFO_HEADLINE =", value, "infoHeadline");
            return (Criteria) this;
        }

        public Criteria andInfoHeadlineNotEqualTo(String value) {
            addCriterion("INFO_HEADLINE <>", value, "infoHeadline");
            return (Criteria) this;
        }

        public Criteria andInfoHeadlineGreaterThan(String value) {
            addCriterion("INFO_HEADLINE >", value, "infoHeadline");
            return (Criteria) this;
        }

        public Criteria andInfoHeadlineGreaterThanOrEqualTo(String value) {
            addCriterion("INFO_HEADLINE >=", value, "infoHeadline");
            return (Criteria) this;
        }

        public Criteria andInfoHeadlineLessThan(String value) {
            addCriterion("INFO_HEADLINE <", value, "infoHeadline");
            return (Criteria) this;
        }

        public Criteria andInfoHeadlineLessThanOrEqualTo(String value) {
            addCriterion("INFO_HEADLINE <=", value, "infoHeadline");
            return (Criteria) this;
        }

        public Criteria andInfoHeadlineLike(String value) {
            addCriterion("INFO_HEADLINE like", value, "infoHeadline");
            return (Criteria) this;
        }

        public Criteria andInfoHeadlineNotLike(String value) {
            addCriterion("INFO_HEADLINE not like", value, "infoHeadline");
            return (Criteria) this;
        }

        public Criteria andInfoHeadlineIn(List<String> values) {
            addCriterion("INFO_HEADLINE in", values, "infoHeadline");
            return (Criteria) this;
        }

        public Criteria andInfoHeadlineNotIn(List<String> values) {
            addCriterion("INFO_HEADLINE not in", values, "infoHeadline");
            return (Criteria) this;
        }

        public Criteria andInfoHeadlineBetween(String value1, String value2) {
            addCriterion("INFO_HEADLINE between", value1, value2, "infoHeadline");
            return (Criteria) this;
        }

        public Criteria andInfoHeadlineNotBetween(String value1, String value2) {
            addCriterion("INFO_HEADLINE not between", value1, value2, "infoHeadline");
            return (Criteria) this;
        }

        public Criteria andInfoMessageIsNull() {
            addCriterion("INFO_MESSAGE is null");
            return (Criteria) this;
        }

        public Criteria andInfoMessageIsNotNull() {
            addCriterion("INFO_MESSAGE is not null");
            return (Criteria) this;
        }

        public Criteria andInfoMessageEqualTo(String value) {
            addCriterion("INFO_MESSAGE =", value, "infoMessage");
            return (Criteria) this;
        }

        public Criteria andInfoMessageNotEqualTo(String value) {
            addCriterion("INFO_MESSAGE <>", value, "infoMessage");
            return (Criteria) this;
        }

        public Criteria andInfoMessageGreaterThan(String value) {
            addCriterion("INFO_MESSAGE >", value, "infoMessage");
            return (Criteria) this;
        }

        public Criteria andInfoMessageGreaterThanOrEqualTo(String value) {
            addCriterion("INFO_MESSAGE >=", value, "infoMessage");
            return (Criteria) this;
        }

        public Criteria andInfoMessageLessThan(String value) {
            addCriterion("INFO_MESSAGE <", value, "infoMessage");
            return (Criteria) this;
        }

        public Criteria andInfoMessageLessThanOrEqualTo(String value) {
            addCriterion("INFO_MESSAGE <=", value, "infoMessage");
            return (Criteria) this;
        }

        public Criteria andInfoMessageLike(String value) {
            addCriterion("INFO_MESSAGE like", value, "infoMessage");
            return (Criteria) this;
        }

        public Criteria andInfoMessageNotLike(String value) {
            addCriterion("INFO_MESSAGE not like", value, "infoMessage");
            return (Criteria) this;
        }

        public Criteria andInfoMessageIn(List<String> values) {
            addCriterion("INFO_MESSAGE in", values, "infoMessage");
            return (Criteria) this;
        }

        public Criteria andInfoMessageNotIn(List<String> values) {
            addCriterion("INFO_MESSAGE not in", values, "infoMessage");
            return (Criteria) this;
        }

        public Criteria andInfoMessageBetween(String value1, String value2) {
            addCriterion("INFO_MESSAGE between", value1, value2, "infoMessage");
            return (Criteria) this;
        }

        public Criteria andInfoMessageNotBetween(String value1, String value2) {
            addCriterion("INFO_MESSAGE not between", value1, value2, "infoMessage");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIsNull() {
            addCriterion("ACTIVE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIsNotNull() {
            addCriterion("ACTIVE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andActiveTimeEqualTo(Timestamp value) {
            addCriterion("ACTIVE_TIME =", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotEqualTo(Timestamp value) {
            addCriterion("ACTIVE_TIME <>", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeGreaterThan(Timestamp value) {
            addCriterion("ACTIVE_TIME >", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("ACTIVE_TIME >=", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeLessThan(Timestamp value) {
            addCriterion("ACTIVE_TIME <", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("ACTIVE_TIME <=", value, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIn(List<Timestamp> values) {
            addCriterion("ACTIVE_TIME in", values, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotIn(List<Timestamp> values) {
            addCriterion("ACTIVE_TIME not in", values, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("ACTIVE_TIME between", value1, value2, "activeTime");
            return (Criteria) this;
        }

        public Criteria andActiveTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("ACTIVE_TIME not between", value1, value2, "activeTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeIsNull() {
            addCriterion("INACTIVE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeIsNotNull() {
            addCriterion("INACTIVE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeEqualTo(Timestamp value) {
            addCriterion("INACTIVE_TIME =", value, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeNotEqualTo(Timestamp value) {
            addCriterion("INACTIVE_TIME <>", value, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeGreaterThan(Timestamp value) {
            addCriterion("INACTIVE_TIME >", value, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("INACTIVE_TIME >=", value, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeLessThan(Timestamp value) {
            addCriterion("INACTIVE_TIME <", value, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("INACTIVE_TIME <=", value, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeIn(List<Timestamp> values) {
            addCriterion("INACTIVE_TIME in", values, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeNotIn(List<Timestamp> values) {
            addCriterion("INACTIVE_TIME not in", values, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("INACTIVE_TIME between", value1, value2, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andInactiveTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("INACTIVE_TIME not between", value1, value2, "inactiveTime");
            return (Criteria) this;
        }

        public Criteria andStateUpdateTimeIsNull() {
            addCriterion("STATE_UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStateUpdateTimeIsNotNull() {
            addCriterion("STATE_UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStateUpdateTimeEqualTo(Timestamp value) {
            addCriterion("STATE_UPDATE_TIME =", value, "stateUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStateUpdateTimeNotEqualTo(Timestamp value) {
            addCriterion("STATE_UPDATE_TIME <>", value, "stateUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStateUpdateTimeGreaterThan(Timestamp value) {
            addCriterion("STATE_UPDATE_TIME >", value, "stateUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStateUpdateTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("STATE_UPDATE_TIME >=", value, "stateUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStateUpdateTimeLessThan(Timestamp value) {
            addCriterion("STATE_UPDATE_TIME <", value, "stateUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStateUpdateTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("STATE_UPDATE_TIME <=", value, "stateUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStateUpdateTimeIn(List<Timestamp> values) {
            addCriterion("STATE_UPDATE_TIME in", values, "stateUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStateUpdateTimeNotIn(List<Timestamp> values) {
            addCriterion("STATE_UPDATE_TIME not in", values, "stateUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStateUpdateTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("STATE_UPDATE_TIME between", value1, value2, "stateUpdateTime");
            return (Criteria) this;
        }

        public Criteria andStateUpdateTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("STATE_UPDATE_TIME not between", value1, value2, "stateUpdateTime");
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