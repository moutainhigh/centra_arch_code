package com.ai.slp.user.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UcTelGroupCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public UcTelGroupCriteria() {
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

        public Criteria andTelGroupIdIsNull() {
            addCriterion("TEL_GROUP_ID is null");
            return (Criteria) this;
        }

        public Criteria andTelGroupIdIsNotNull() {
            addCriterion("TEL_GROUP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTelGroupIdEqualTo(String value) {
            addCriterion("TEL_GROUP_ID =", value, "telGroupId");
            return (Criteria) this;
        }

        public Criteria andTelGroupIdNotEqualTo(String value) {
            addCriterion("TEL_GROUP_ID <>", value, "telGroupId");
            return (Criteria) this;
        }

        public Criteria andTelGroupIdGreaterThan(String value) {
            addCriterion("TEL_GROUP_ID >", value, "telGroupId");
            return (Criteria) this;
        }

        public Criteria andTelGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("TEL_GROUP_ID >=", value, "telGroupId");
            return (Criteria) this;
        }

        public Criteria andTelGroupIdLessThan(String value) {
            addCriterion("TEL_GROUP_ID <", value, "telGroupId");
            return (Criteria) this;
        }

        public Criteria andTelGroupIdLessThanOrEqualTo(String value) {
            addCriterion("TEL_GROUP_ID <=", value, "telGroupId");
            return (Criteria) this;
        }

        public Criteria andTelGroupIdLike(String value) {
            addCriterion("TEL_GROUP_ID like", value, "telGroupId");
            return (Criteria) this;
        }

        public Criteria andTelGroupIdNotLike(String value) {
            addCriterion("TEL_GROUP_ID not like", value, "telGroupId");
            return (Criteria) this;
        }

        public Criteria andTelGroupIdIn(List<String> values) {
            addCriterion("TEL_GROUP_ID in", values, "telGroupId");
            return (Criteria) this;
        }

        public Criteria andTelGroupIdNotIn(List<String> values) {
            addCriterion("TEL_GROUP_ID not in", values, "telGroupId");
            return (Criteria) this;
        }

        public Criteria andTelGroupIdBetween(String value1, String value2) {
            addCriterion("TEL_GROUP_ID between", value1, value2, "telGroupId");
            return (Criteria) this;
        }

        public Criteria andTelGroupIdNotBetween(String value1, String value2) {
            addCriterion("TEL_GROUP_ID not between", value1, value2, "telGroupId");
            return (Criteria) this;
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

        public Criteria andTelNoIsNull() {
            addCriterion("TEL_NO is null");
            return (Criteria) this;
        }

        public Criteria andTelNoIsNotNull() {
            addCriterion("TEL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andTelNoEqualTo(String value) {
            addCriterion("TEL_NO =", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoNotEqualTo(String value) {
            addCriterion("TEL_NO <>", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoGreaterThan(String value) {
            addCriterion("TEL_NO >", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoGreaterThanOrEqualTo(String value) {
            addCriterion("TEL_NO >=", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoLessThan(String value) {
            addCriterion("TEL_NO <", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoLessThanOrEqualTo(String value) {
            addCriterion("TEL_NO <=", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoLike(String value) {
            addCriterion("TEL_NO like", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoNotLike(String value) {
            addCriterion("TEL_NO not like", value, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoIn(List<String> values) {
            addCriterion("TEL_NO in", values, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoNotIn(List<String> values) {
            addCriterion("TEL_NO not in", values, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoBetween(String value1, String value2) {
            addCriterion("TEL_NO between", value1, value2, "telNo");
            return (Criteria) this;
        }

        public Criteria andTelNoNotBetween(String value1, String value2) {
            addCriterion("TEL_NO not between", value1, value2, "telNo");
            return (Criteria) this;
        }

        public Criteria andSeqIsNull() {
            addCriterion("SEQ is null");
            return (Criteria) this;
        }

        public Criteria andSeqIsNotNull() {
            addCriterion("SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andSeqEqualTo(long value) {
            addCriterion("SEQ =", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotEqualTo(long value) {
            addCriterion("SEQ <>", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThan(long value) {
            addCriterion("SEQ >", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThanOrEqualTo(long value) {
            addCriterion("SEQ >=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThan(long value) {
            addCriterion("SEQ <", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThanOrEqualTo(long value) {
            addCriterion("SEQ <=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqIn(List<Long> values) {
            addCriterion("SEQ in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotIn(List<Long> values) {
            addCriterion("SEQ not in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqBetween(long value1, long value2) {
            addCriterion("SEQ between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotBetween(long value1, long value2) {
            addCriterion("SEQ not between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andTelGroupNameIsNull() {
            addCriterion("TEL_GROUP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTelGroupNameIsNotNull() {
            addCriterion("TEL_GROUP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTelGroupNameEqualTo(String value) {
            addCriterion("TEL_GROUP_NAME =", value, "telGroupName");
            return (Criteria) this;
        }

        public Criteria andTelGroupNameNotEqualTo(String value) {
            addCriterion("TEL_GROUP_NAME <>", value, "telGroupName");
            return (Criteria) this;
        }

        public Criteria andTelGroupNameGreaterThan(String value) {
            addCriterion("TEL_GROUP_NAME >", value, "telGroupName");
            return (Criteria) this;
        }

        public Criteria andTelGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("TEL_GROUP_NAME >=", value, "telGroupName");
            return (Criteria) this;
        }

        public Criteria andTelGroupNameLessThan(String value) {
            addCriterion("TEL_GROUP_NAME <", value, "telGroupName");
            return (Criteria) this;
        }

        public Criteria andTelGroupNameLessThanOrEqualTo(String value) {
            addCriterion("TEL_GROUP_NAME <=", value, "telGroupName");
            return (Criteria) this;
        }

        public Criteria andTelGroupNameLike(String value) {
            addCriterion("TEL_GROUP_NAME like", value, "telGroupName");
            return (Criteria) this;
        }

        public Criteria andTelGroupNameNotLike(String value) {
            addCriterion("TEL_GROUP_NAME not like", value, "telGroupName");
            return (Criteria) this;
        }

        public Criteria andTelGroupNameIn(List<String> values) {
            addCriterion("TEL_GROUP_NAME in", values, "telGroupName");
            return (Criteria) this;
        }

        public Criteria andTelGroupNameNotIn(List<String> values) {
            addCriterion("TEL_GROUP_NAME not in", values, "telGroupName");
            return (Criteria) this;
        }

        public Criteria andTelGroupNameBetween(String value1, String value2) {
            addCriterion("TEL_GROUP_NAME between", value1, value2, "telGroupName");
            return (Criteria) this;
        }

        public Criteria andTelGroupNameNotBetween(String value1, String value2) {
            addCriterion("TEL_GROUP_NAME not between", value1, value2, "telGroupName");
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

        public Criteria andCreateOperIdEqualTo(String value) {
            addCriterion("CREATE_OPER_ID =", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdNotEqualTo(String value) {
            addCriterion("CREATE_OPER_ID <>", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdGreaterThan(String value) {
            addCriterion("CREATE_OPER_ID >", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_OPER_ID >=", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdLessThan(String value) {
            addCriterion("CREATE_OPER_ID <", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdLessThanOrEqualTo(String value) {
            addCriterion("CREATE_OPER_ID <=", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdLike(String value) {
            addCriterion("CREATE_OPER_ID like", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdNotLike(String value) {
            addCriterion("CREATE_OPER_ID not like", value, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdIn(List<String> values) {
            addCriterion("CREATE_OPER_ID in", values, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdNotIn(List<String> values) {
            addCriterion("CREATE_OPER_ID not in", values, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdBetween(String value1, String value2) {
            addCriterion("CREATE_OPER_ID between", value1, value2, "createOperId");
            return (Criteria) this;
        }

        public Criteria andCreateOperIdNotBetween(String value1, String value2) {
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

        public Criteria andUpdateOperIdEqualTo(String value) {
            addCriterion("UPDATE_OPER_ID =", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotEqualTo(String value) {
            addCriterion("UPDATE_OPER_ID <>", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdGreaterThan(String value) {
            addCriterion("UPDATE_OPER_ID >", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_OPER_ID >=", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdLessThan(String value) {
            addCriterion("UPDATE_OPER_ID <", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_OPER_ID <=", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdLike(String value) {
            addCriterion("UPDATE_OPER_ID like", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotLike(String value) {
            addCriterion("UPDATE_OPER_ID not like", value, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdIn(List<String> values) {
            addCriterion("UPDATE_OPER_ID in", values, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotIn(List<String> values) {
            addCriterion("UPDATE_OPER_ID not in", values, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdBetween(String value1, String value2) {
            addCriterion("UPDATE_OPER_ID between", value1, value2, "updateOperId");
            return (Criteria) this;
        }

        public Criteria andUpdateOperIdNotBetween(String value1, String value2) {
            addCriterion("UPDATE_OPER_ID not between", value1, value2, "updateOperId");
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