package com.ifudata.ums.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SmsResultCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public SmsResultCriteria() {
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

        public Criteria andResSeqIsNull() {
            addCriterion("RES_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andResSeqIsNotNull() {
            addCriterion("RES_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andResSeqEqualTo(Long value) {
            addCriterion("RES_SEQ =", value, "resSeq");
            return (Criteria) this;
        }

        public Criteria andResSeqNotEqualTo(Long value) {
            addCriterion("RES_SEQ <>", value, "resSeq");
            return (Criteria) this;
        }

        public Criteria andResSeqGreaterThan(Long value) {
            addCriterion("RES_SEQ >", value, "resSeq");
            return (Criteria) this;
        }

        public Criteria andResSeqGreaterThanOrEqualTo(Long value) {
            addCriterion("RES_SEQ >=", value, "resSeq");
            return (Criteria) this;
        }

        public Criteria andResSeqLessThan(Long value) {
            addCriterion("RES_SEQ <", value, "resSeq");
            return (Criteria) this;
        }

        public Criteria andResSeqLessThanOrEqualTo(Long value) {
            addCriterion("RES_SEQ <=", value, "resSeq");
            return (Criteria) this;
        }

        public Criteria andResSeqIn(List<Long> values) {
            addCriterion("RES_SEQ in", values, "resSeq");
            return (Criteria) this;
        }

        public Criteria andResSeqNotIn(List<Long> values) {
            addCriterion("RES_SEQ not in", values, "resSeq");
            return (Criteria) this;
        }

        public Criteria andResSeqBetween(Long value1, Long value2) {
            addCriterion("RES_SEQ between", value1, value2, "resSeq");
            return (Criteria) this;
        }

        public Criteria andResSeqNotBetween(Long value1, Long value2) {
            addCriterion("RES_SEQ not between", value1, value2, "resSeq");
            return (Criteria) this;
        }

        public Criteria andSrcNameIsNull() {
            addCriterion("SRC_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSrcNameIsNotNull() {
            addCriterion("SRC_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSrcNameEqualTo(String value) {
            addCriterion("SRC_NAME =", value, "srcName");
            return (Criteria) this;
        }

        public Criteria andSrcNameNotEqualTo(String value) {
            addCriterion("SRC_NAME <>", value, "srcName");
            return (Criteria) this;
        }

        public Criteria andSrcNameGreaterThan(String value) {
            addCriterion("SRC_NAME >", value, "srcName");
            return (Criteria) this;
        }

        public Criteria andSrcNameGreaterThanOrEqualTo(String value) {
            addCriterion("SRC_NAME >=", value, "srcName");
            return (Criteria) this;
        }

        public Criteria andSrcNameLessThan(String value) {
            addCriterion("SRC_NAME <", value, "srcName");
            return (Criteria) this;
        }

        public Criteria andSrcNameLessThanOrEqualTo(String value) {
            addCriterion("SRC_NAME <=", value, "srcName");
            return (Criteria) this;
        }

        public Criteria andSrcNameLike(String value) {
            addCriterion("SRC_NAME like", value, "srcName");
            return (Criteria) this;
        }

        public Criteria andSrcNameNotLike(String value) {
            addCriterion("SRC_NAME not like", value, "srcName");
            return (Criteria) this;
        }

        public Criteria andSrcNameIn(List<String> values) {
            addCriterion("SRC_NAME in", values, "srcName");
            return (Criteria) this;
        }

        public Criteria andSrcNameNotIn(List<String> values) {
            addCriterion("SRC_NAME not in", values, "srcName");
            return (Criteria) this;
        }

        public Criteria andSrcNameBetween(String value1, String value2) {
            addCriterion("SRC_NAME between", value1, value2, "srcName");
            return (Criteria) this;
        }

        public Criteria andSrcNameNotBetween(String value1, String value2) {
            addCriterion("SRC_NAME not between", value1, value2, "srcName");
            return (Criteria) this;
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

        public Criteria andServicetypeIsNull() {
            addCriterion("SERVICETYPE is null");
            return (Criteria) this;
        }

        public Criteria andServicetypeIsNotNull() {
            addCriterion("SERVICETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andServicetypeEqualTo(String value) {
            addCriterion("SERVICETYPE =", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeNotEqualTo(String value) {
            addCriterion("SERVICETYPE <>", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeGreaterThan(String value) {
            addCriterion("SERVICETYPE >", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICETYPE >=", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeLessThan(String value) {
            addCriterion("SERVICETYPE <", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeLessThanOrEqualTo(String value) {
            addCriterion("SERVICETYPE <=", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeLike(String value) {
            addCriterion("SERVICETYPE like", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeNotLike(String value) {
            addCriterion("SERVICETYPE not like", value, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeIn(List<String> values) {
            addCriterion("SERVICETYPE in", values, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeNotIn(List<String> values) {
            addCriterion("SERVICETYPE not in", values, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeBetween(String value1, String value2) {
            addCriterion("SERVICETYPE between", value1, value2, "servicetype");
            return (Criteria) this;
        }

        public Criteria andServicetypeNotBetween(String value1, String value2) {
            addCriterion("SERVICETYPE not between", value1, value2, "servicetype");
            return (Criteria) this;
        }

        public Criteria andVerifyidIsNull() {
            addCriterion("VERIFYID is null");
            return (Criteria) this;
        }

        public Criteria andVerifyidIsNotNull() {
            addCriterion("VERIFYID is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyidEqualTo(Long value) {
            addCriterion("VERIFYID =", value, "verifyid");
            return (Criteria) this;
        }

        public Criteria andVerifyidNotEqualTo(Long value) {
            addCriterion("VERIFYID <>", value, "verifyid");
            return (Criteria) this;
        }

        public Criteria andVerifyidGreaterThan(Long value) {
            addCriterion("VERIFYID >", value, "verifyid");
            return (Criteria) this;
        }

        public Criteria andVerifyidGreaterThanOrEqualTo(Long value) {
            addCriterion("VERIFYID >=", value, "verifyid");
            return (Criteria) this;
        }

        public Criteria andVerifyidLessThan(Long value) {
            addCriterion("VERIFYID <", value, "verifyid");
            return (Criteria) this;
        }

        public Criteria andVerifyidLessThanOrEqualTo(Long value) {
            addCriterion("VERIFYID <=", value, "verifyid");
            return (Criteria) this;
        }

        public Criteria andVerifyidIn(List<Long> values) {
            addCriterion("VERIFYID in", values, "verifyid");
            return (Criteria) this;
        }

        public Criteria andVerifyidNotIn(List<Long> values) {
            addCriterion("VERIFYID not in", values, "verifyid");
            return (Criteria) this;
        }

        public Criteria andVerifyidBetween(Long value1, Long value2) {
            addCriterion("VERIFYID between", value1, value2, "verifyid");
            return (Criteria) this;
        }

        public Criteria andVerifyidNotBetween(Long value1, Long value2) {
            addCriterion("VERIFYID not between", value1, value2, "verifyid");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andGsmcontentIsNull() {
            addCriterion("GSMCONTENT is null");
            return (Criteria) this;
        }

        public Criteria andGsmcontentIsNotNull() {
            addCriterion("GSMCONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andGsmcontentEqualTo(String value) {
            addCriterion("GSMCONTENT =", value, "gsmcontent");
            return (Criteria) this;
        }

        public Criteria andGsmcontentNotEqualTo(String value) {
            addCriterion("GSMCONTENT <>", value, "gsmcontent");
            return (Criteria) this;
        }

        public Criteria andGsmcontentGreaterThan(String value) {
            addCriterion("GSMCONTENT >", value, "gsmcontent");
            return (Criteria) this;
        }

        public Criteria andGsmcontentGreaterThanOrEqualTo(String value) {
            addCriterion("GSMCONTENT >=", value, "gsmcontent");
            return (Criteria) this;
        }

        public Criteria andGsmcontentLessThan(String value) {
            addCriterion("GSMCONTENT <", value, "gsmcontent");
            return (Criteria) this;
        }

        public Criteria andGsmcontentLessThanOrEqualTo(String value) {
            addCriterion("GSMCONTENT <=", value, "gsmcontent");
            return (Criteria) this;
        }

        public Criteria andGsmcontentLike(String value) {
            addCriterion("GSMCONTENT like", value, "gsmcontent");
            return (Criteria) this;
        }

        public Criteria andGsmcontentNotLike(String value) {
            addCriterion("GSMCONTENT not like", value, "gsmcontent");
            return (Criteria) this;
        }

        public Criteria andGsmcontentIn(List<String> values) {
            addCriterion("GSMCONTENT in", values, "gsmcontent");
            return (Criteria) this;
        }

        public Criteria andGsmcontentNotIn(List<String> values) {
            addCriterion("GSMCONTENT not in", values, "gsmcontent");
            return (Criteria) this;
        }

        public Criteria andGsmcontentBetween(String value1, String value2) {
            addCriterion("GSMCONTENT between", value1, value2, "gsmcontent");
            return (Criteria) this;
        }

        public Criteria andGsmcontentNotBetween(String value1, String value2) {
            addCriterion("GSMCONTENT not between", value1, value2, "gsmcontent");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("CONTENT =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("CONTENT <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("CONTENT >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("CONTENT <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("CONTENT <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("CONTENT like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("CONTENT not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("CONTENT in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("CONTENT not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("CONTENT between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("CONTENT not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andSendSeqIsNull() {
            addCriterion("SEND_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andSendSeqIsNotNull() {
            addCriterion("SEND_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andSendSeqEqualTo(String value) {
            addCriterion("SEND_SEQ =", value, "sendSeq");
            return (Criteria) this;
        }

        public Criteria andSendSeqNotEqualTo(String value) {
            addCriterion("SEND_SEQ <>", value, "sendSeq");
            return (Criteria) this;
        }

        public Criteria andSendSeqGreaterThan(String value) {
            addCriterion("SEND_SEQ >", value, "sendSeq");
            return (Criteria) this;
        }

        public Criteria andSendSeqGreaterThanOrEqualTo(String value) {
            addCriterion("SEND_SEQ >=", value, "sendSeq");
            return (Criteria) this;
        }

        public Criteria andSendSeqLessThan(String value) {
            addCriterion("SEND_SEQ <", value, "sendSeq");
            return (Criteria) this;
        }

        public Criteria andSendSeqLessThanOrEqualTo(String value) {
            addCriterion("SEND_SEQ <=", value, "sendSeq");
            return (Criteria) this;
        }

        public Criteria andSendSeqLike(String value) {
            addCriterion("SEND_SEQ like", value, "sendSeq");
            return (Criteria) this;
        }

        public Criteria andSendSeqNotLike(String value) {
            addCriterion("SEND_SEQ not like", value, "sendSeq");
            return (Criteria) this;
        }

        public Criteria andSendSeqIn(List<String> values) {
            addCriterion("SEND_SEQ in", values, "sendSeq");
            return (Criteria) this;
        }

        public Criteria andSendSeqNotIn(List<String> values) {
            addCriterion("SEND_SEQ not in", values, "sendSeq");
            return (Criteria) this;
        }

        public Criteria andSendSeqBetween(String value1, String value2) {
            addCriterion("SEND_SEQ between", value1, value2, "sendSeq");
            return (Criteria) this;
        }

        public Criteria andSendSeqNotBetween(String value1, String value2) {
            addCriterion("SEND_SEQ not between", value1, value2, "sendSeq");
            return (Criteria) this;
        }

        public Criteria andSendFlagIsNull() {
            addCriterion("SEND_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andSendFlagIsNotNull() {
            addCriterion("SEND_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andSendFlagEqualTo(Integer value) {
            addCriterion("SEND_FLAG =", value, "sendFlag");
            return (Criteria) this;
        }

        public Criteria andSendFlagNotEqualTo(Integer value) {
            addCriterion("SEND_FLAG <>", value, "sendFlag");
            return (Criteria) this;
        }

        public Criteria andSendFlagGreaterThan(Integer value) {
            addCriterion("SEND_FLAG >", value, "sendFlag");
            return (Criteria) this;
        }

        public Criteria andSendFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEND_FLAG >=", value, "sendFlag");
            return (Criteria) this;
        }

        public Criteria andSendFlagLessThan(Integer value) {
            addCriterion("SEND_FLAG <", value, "sendFlag");
            return (Criteria) this;
        }

        public Criteria andSendFlagLessThanOrEqualTo(Integer value) {
            addCriterion("SEND_FLAG <=", value, "sendFlag");
            return (Criteria) this;
        }

        public Criteria andSendFlagIn(List<Integer> values) {
            addCriterion("SEND_FLAG in", values, "sendFlag");
            return (Criteria) this;
        }

        public Criteria andSendFlagNotIn(List<Integer> values) {
            addCriterion("SEND_FLAG not in", values, "sendFlag");
            return (Criteria) this;
        }

        public Criteria andSendFlagBetween(Integer value1, Integer value2) {
            addCriterion("SEND_FLAG between", value1, value2, "sendFlag");
            return (Criteria) this;
        }

        public Criteria andSendFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("SEND_FLAG not between", value1, value2, "sendFlag");
            return (Criteria) this;
        }

        public Criteria andRecFlagIsNull() {
            addCriterion("REC_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andRecFlagIsNotNull() {
            addCriterion("REC_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andRecFlagEqualTo(Integer value) {
            addCriterion("REC_FLAG =", value, "recFlag");
            return (Criteria) this;
        }

        public Criteria andRecFlagNotEqualTo(Integer value) {
            addCriterion("REC_FLAG <>", value, "recFlag");
            return (Criteria) this;
        }

        public Criteria andRecFlagGreaterThan(Integer value) {
            addCriterion("REC_FLAG >", value, "recFlag");
            return (Criteria) this;
        }

        public Criteria andRecFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("REC_FLAG >=", value, "recFlag");
            return (Criteria) this;
        }

        public Criteria andRecFlagLessThan(Integer value) {
            addCriterion("REC_FLAG <", value, "recFlag");
            return (Criteria) this;
        }

        public Criteria andRecFlagLessThanOrEqualTo(Integer value) {
            addCriterion("REC_FLAG <=", value, "recFlag");
            return (Criteria) this;
        }

        public Criteria andRecFlagIn(List<Integer> values) {
            addCriterion("REC_FLAG in", values, "recFlag");
            return (Criteria) this;
        }

        public Criteria andRecFlagNotIn(List<Integer> values) {
            addCriterion("REC_FLAG not in", values, "recFlag");
            return (Criteria) this;
        }

        public Criteria andRecFlagBetween(Integer value1, Integer value2) {
            addCriterion("REC_FLAG between", value1, value2, "recFlag");
            return (Criteria) this;
        }

        public Criteria andRecFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("REC_FLAG not between", value1, value2, "recFlag");
            return (Criteria) this;
        }

        public Criteria andRecResultIsNull() {
            addCriterion("REC_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andRecResultIsNotNull() {
            addCriterion("REC_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andRecResultEqualTo(String value) {
            addCriterion("REC_RESULT =", value, "recResult");
            return (Criteria) this;
        }

        public Criteria andRecResultNotEqualTo(String value) {
            addCriterion("REC_RESULT <>", value, "recResult");
            return (Criteria) this;
        }

        public Criteria andRecResultGreaterThan(String value) {
            addCriterion("REC_RESULT >", value, "recResult");
            return (Criteria) this;
        }

        public Criteria andRecResultGreaterThanOrEqualTo(String value) {
            addCriterion("REC_RESULT >=", value, "recResult");
            return (Criteria) this;
        }

        public Criteria andRecResultLessThan(String value) {
            addCriterion("REC_RESULT <", value, "recResult");
            return (Criteria) this;
        }

        public Criteria andRecResultLessThanOrEqualTo(String value) {
            addCriterion("REC_RESULT <=", value, "recResult");
            return (Criteria) this;
        }

        public Criteria andRecResultLike(String value) {
            addCriterion("REC_RESULT like", value, "recResult");
            return (Criteria) this;
        }

        public Criteria andRecResultNotLike(String value) {
            addCriterion("REC_RESULT not like", value, "recResult");
            return (Criteria) this;
        }

        public Criteria andRecResultIn(List<String> values) {
            addCriterion("REC_RESULT in", values, "recResult");
            return (Criteria) this;
        }

        public Criteria andRecResultNotIn(List<String> values) {
            addCriterion("REC_RESULT not in", values, "recResult");
            return (Criteria) this;
        }

        public Criteria andRecResultBetween(String value1, String value2) {
            addCriterion("REC_RESULT between", value1, value2, "recResult");
            return (Criteria) this;
        }

        public Criteria andRecResultNotBetween(String value1, String value2) {
            addCriterion("REC_RESULT not between", value1, value2, "recResult");
            return (Criteria) this;
        }

        public Criteria andRetryTimesIsNull() {
            addCriterion("RETRY_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andRetryTimesIsNotNull() {
            addCriterion("RETRY_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andRetryTimesEqualTo(Integer value) {
            addCriterion("RETRY_TIMES =", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesNotEqualTo(Integer value) {
            addCriterion("RETRY_TIMES <>", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesGreaterThan(Integer value) {
            addCriterion("RETRY_TIMES >", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("RETRY_TIMES >=", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesLessThan(Integer value) {
            addCriterion("RETRY_TIMES <", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesLessThanOrEqualTo(Integer value) {
            addCriterion("RETRY_TIMES <=", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesIn(List<Integer> values) {
            addCriterion("RETRY_TIMES in", values, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesNotIn(List<Integer> values) {
            addCriterion("RETRY_TIMES not in", values, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesBetween(Integer value1, Integer value2) {
            addCriterion("RETRY_TIMES between", value1, value2, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("RETRY_TIMES not between", value1, value2, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andMaxTimesIsNull() {
            addCriterion("MAX_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andMaxTimesIsNotNull() {
            addCriterion("MAX_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andMaxTimesEqualTo(Integer value) {
            addCriterion("MAX_TIMES =", value, "maxTimes");
            return (Criteria) this;
        }

        public Criteria andMaxTimesNotEqualTo(Integer value) {
            addCriterion("MAX_TIMES <>", value, "maxTimes");
            return (Criteria) this;
        }

        public Criteria andMaxTimesGreaterThan(Integer value) {
            addCriterion("MAX_TIMES >", value, "maxTimes");
            return (Criteria) this;
        }

        public Criteria andMaxTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("MAX_TIMES >=", value, "maxTimes");
            return (Criteria) this;
        }

        public Criteria andMaxTimesLessThan(Integer value) {
            addCriterion("MAX_TIMES <", value, "maxTimes");
            return (Criteria) this;
        }

        public Criteria andMaxTimesLessThanOrEqualTo(Integer value) {
            addCriterion("MAX_TIMES <=", value, "maxTimes");
            return (Criteria) this;
        }

        public Criteria andMaxTimesIn(List<Integer> values) {
            addCriterion("MAX_TIMES in", values, "maxTimes");
            return (Criteria) this;
        }

        public Criteria andMaxTimesNotIn(List<Integer> values) {
            addCriterion("MAX_TIMES not in", values, "maxTimes");
            return (Criteria) this;
        }

        public Criteria andMaxTimesBetween(Integer value1, Integer value2) {
            addCriterion("MAX_TIMES between", value1, value2, "maxTimes");
            return (Criteria) this;
        }

        public Criteria andMaxTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("MAX_TIMES not between", value1, value2, "maxTimes");
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

        public Criteria andSendTimeIsNull() {
            addCriterion("SEND_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("SEND_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Timestamp value) {
            addCriterion("SEND_TIME =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Timestamp value) {
            addCriterion("SEND_TIME <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Timestamp value) {
            addCriterion("SEND_TIME >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("SEND_TIME >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Timestamp value) {
            addCriterion("SEND_TIME <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("SEND_TIME <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Timestamp> values) {
            addCriterion("SEND_TIME in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Timestamp> values) {
            addCriterion("SEND_TIME not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("SEND_TIME between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("SEND_TIME not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeIsNull() {
            addCriterion("REC_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRecTimeIsNotNull() {
            addCriterion("REC_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRecTimeEqualTo(Timestamp value) {
            addCriterion("REC_TIME =", value, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeNotEqualTo(Timestamp value) {
            addCriterion("REC_TIME <>", value, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeGreaterThan(Timestamp value) {
            addCriterion("REC_TIME >", value, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("REC_TIME >=", value, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeLessThan(Timestamp value) {
            addCriterion("REC_TIME <", value, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("REC_TIME <=", value, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeIn(List<Timestamp> values) {
            addCriterion("REC_TIME in", values, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeNotIn(List<Timestamp> values) {
            addCriterion("REC_TIME not in", values, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("REC_TIME between", value1, value2, "recTime");
            return (Criteria) this;
        }

        public Criteria andRecTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("REC_TIME not between", value1, value2, "recTime");
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