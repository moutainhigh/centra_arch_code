package com.ai.slp.user.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UcUserFavoriteCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public UcUserFavoriteCriteria() {
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

        public Criteria andFavoriteSeqIdIsNull() {
            addCriterion("FAVORITE_SEQ_ID is null");
            return (Criteria) this;
        }

        public Criteria andFavoriteSeqIdIsNotNull() {
            addCriterion("FAVORITE_SEQ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFavoriteSeqIdEqualTo(String value) {
            addCriterion("FAVORITE_SEQ_ID =", value, "favoriteSeqId");
            return (Criteria) this;
        }

        public Criteria andFavoriteSeqIdNotEqualTo(String value) {
            addCriterion("FAVORITE_SEQ_ID <>", value, "favoriteSeqId");
            return (Criteria) this;
        }

        public Criteria andFavoriteSeqIdGreaterThan(String value) {
            addCriterion("FAVORITE_SEQ_ID >", value, "favoriteSeqId");
            return (Criteria) this;
        }

        public Criteria andFavoriteSeqIdGreaterThanOrEqualTo(String value) {
            addCriterion("FAVORITE_SEQ_ID >=", value, "favoriteSeqId");
            return (Criteria) this;
        }

        public Criteria andFavoriteSeqIdLessThan(String value) {
            addCriterion("FAVORITE_SEQ_ID <", value, "favoriteSeqId");
            return (Criteria) this;
        }

        public Criteria andFavoriteSeqIdLessThanOrEqualTo(String value) {
            addCriterion("FAVORITE_SEQ_ID <=", value, "favoriteSeqId");
            return (Criteria) this;
        }

        public Criteria andFavoriteSeqIdLike(String value) {
            addCriterion("FAVORITE_SEQ_ID like", value, "favoriteSeqId");
            return (Criteria) this;
        }

        public Criteria andFavoriteSeqIdNotLike(String value) {
            addCriterion("FAVORITE_SEQ_ID not like", value, "favoriteSeqId");
            return (Criteria) this;
        }

        public Criteria andFavoriteSeqIdIn(List<String> values) {
            addCriterion("FAVORITE_SEQ_ID in", values, "favoriteSeqId");
            return (Criteria) this;
        }

        public Criteria andFavoriteSeqIdNotIn(List<String> values) {
            addCriterion("FAVORITE_SEQ_ID not in", values, "favoriteSeqId");
            return (Criteria) this;
        }

        public Criteria andFavoriteSeqIdBetween(String value1, String value2) {
            addCriterion("FAVORITE_SEQ_ID between", value1, value2, "favoriteSeqId");
            return (Criteria) this;
        }

        public Criteria andFavoriteSeqIdNotBetween(String value1, String value2) {
            addCriterion("FAVORITE_SEQ_ID not between", value1, value2, "favoriteSeqId");
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

        public Criteria andFavoriteTypeIsNull() {
            addCriterion("FAVORITE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFavoriteTypeIsNotNull() {
            addCriterion("FAVORITE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFavoriteTypeEqualTo(String value) {
            addCriterion("FAVORITE_TYPE =", value, "favoriteType");
            return (Criteria) this;
        }

        public Criteria andFavoriteTypeNotEqualTo(String value) {
            addCriterion("FAVORITE_TYPE <>", value, "favoriteType");
            return (Criteria) this;
        }

        public Criteria andFavoriteTypeGreaterThan(String value) {
            addCriterion("FAVORITE_TYPE >", value, "favoriteType");
            return (Criteria) this;
        }

        public Criteria andFavoriteTypeGreaterThanOrEqualTo(String value) {
            addCriterion("FAVORITE_TYPE >=", value, "favoriteType");
            return (Criteria) this;
        }

        public Criteria andFavoriteTypeLessThan(String value) {
            addCriterion("FAVORITE_TYPE <", value, "favoriteType");
            return (Criteria) this;
        }

        public Criteria andFavoriteTypeLessThanOrEqualTo(String value) {
            addCriterion("FAVORITE_TYPE <=", value, "favoriteType");
            return (Criteria) this;
        }

        public Criteria andFavoriteTypeLike(String value) {
            addCriterion("FAVORITE_TYPE like", value, "favoriteType");
            return (Criteria) this;
        }

        public Criteria andFavoriteTypeNotLike(String value) {
            addCriterion("FAVORITE_TYPE not like", value, "favoriteType");
            return (Criteria) this;
        }

        public Criteria andFavoriteTypeIn(List<String> values) {
            addCriterion("FAVORITE_TYPE in", values, "favoriteType");
            return (Criteria) this;
        }

        public Criteria andFavoriteTypeNotIn(List<String> values) {
            addCriterion("FAVORITE_TYPE not in", values, "favoriteType");
            return (Criteria) this;
        }

        public Criteria andFavoriteTypeBetween(String value1, String value2) {
            addCriterion("FAVORITE_TYPE between", value1, value2, "favoriteType");
            return (Criteria) this;
        }

        public Criteria andFavoriteTypeNotBetween(String value1, String value2) {
            addCriterion("FAVORITE_TYPE not between", value1, value2, "favoriteType");
            return (Criteria) this;
        }

        public Criteria andFavoriteRelIdIsNull() {
            addCriterion("FAVORITE_REL_ID is null");
            return (Criteria) this;
        }

        public Criteria andFavoriteRelIdIsNotNull() {
            addCriterion("FAVORITE_REL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFavoriteRelIdEqualTo(String value) {
            addCriterion("FAVORITE_REL_ID =", value, "favoriteRelId");
            return (Criteria) this;
        }

        public Criteria andFavoriteRelIdNotEqualTo(String value) {
            addCriterion("FAVORITE_REL_ID <>", value, "favoriteRelId");
            return (Criteria) this;
        }

        public Criteria andFavoriteRelIdGreaterThan(String value) {
            addCriterion("FAVORITE_REL_ID >", value, "favoriteRelId");
            return (Criteria) this;
        }

        public Criteria andFavoriteRelIdGreaterThanOrEqualTo(String value) {
            addCriterion("FAVORITE_REL_ID >=", value, "favoriteRelId");
            return (Criteria) this;
        }

        public Criteria andFavoriteRelIdLessThan(String value) {
            addCriterion("FAVORITE_REL_ID <", value, "favoriteRelId");
            return (Criteria) this;
        }

        public Criteria andFavoriteRelIdLessThanOrEqualTo(String value) {
            addCriterion("FAVORITE_REL_ID <=", value, "favoriteRelId");
            return (Criteria) this;
        }

        public Criteria andFavoriteRelIdLike(String value) {
            addCriterion("FAVORITE_REL_ID like", value, "favoriteRelId");
            return (Criteria) this;
        }

        public Criteria andFavoriteRelIdNotLike(String value) {
            addCriterion("FAVORITE_REL_ID not like", value, "favoriteRelId");
            return (Criteria) this;
        }

        public Criteria andFavoriteRelIdIn(List<String> values) {
            addCriterion("FAVORITE_REL_ID in", values, "favoriteRelId");
            return (Criteria) this;
        }

        public Criteria andFavoriteRelIdNotIn(List<String> values) {
            addCriterion("FAVORITE_REL_ID not in", values, "favoriteRelId");
            return (Criteria) this;
        }

        public Criteria andFavoriteRelIdBetween(String value1, String value2) {
            addCriterion("FAVORITE_REL_ID between", value1, value2, "favoriteRelId");
            return (Criteria) this;
        }

        public Criteria andFavoriteRelIdNotBetween(String value1, String value2) {
            addCriterion("FAVORITE_REL_ID not between", value1, value2, "favoriteRelId");
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