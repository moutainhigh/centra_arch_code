package com.ifudata.ums.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UmsSendStatusCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public UmsSendStatusCriteria() {
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

        public Criteria andDetailIdIsNull() {
            addCriterion("detail_id is null");
            return (Criteria) this;
        }

        public Criteria andDetailIdIsNotNull() {
            addCriterion("detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andDetailIdEqualTo(Long value) {
            addCriterion("detail_id =", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotEqualTo(Long value) {
            addCriterion("detail_id <>", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThan(Long value) {
            addCriterion("detail_id >", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThanOrEqualTo(Long value) {
            addCriterion("detail_id >=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThan(Long value) {
            addCriterion("detail_id <", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThanOrEqualTo(Long value) {
            addCriterion("detail_id <=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdIn(List<Long> values) {
            addCriterion("detail_id in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotIn(List<Long> values) {
            addCriterion("detail_id not in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdBetween(Long value1, Long value2) {
            addCriterion("detail_id between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotBetween(Long value1, Long value2) {
            addCriterion("detail_id not between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andBatchIdIsNull() {
            addCriterion("batch_id is null");
            return (Criteria) this;
        }

        public Criteria andBatchIdIsNotNull() {
            addCriterion("batch_id is not null");
            return (Criteria) this;
        }

        public Criteria andBatchIdEqualTo(String value) {
            addCriterion("batch_id =", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotEqualTo(String value) {
            addCriterion("batch_id <>", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdGreaterThan(String value) {
            addCriterion("batch_id >", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdGreaterThanOrEqualTo(String value) {
            addCriterion("batch_id >=", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLessThan(String value) {
            addCriterion("batch_id <", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLessThanOrEqualTo(String value) {
            addCriterion("batch_id <=", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLike(String value) {
            addCriterion("batch_id like", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotLike(String value) {
            addCriterion("batch_id not like", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdIn(List<String> values) {
            addCriterion("batch_id in", values, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotIn(List<String> values) {
            addCriterion("batch_id not in", values, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdBetween(String value1, String value2) {
            addCriterion("batch_id between", value1, value2, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotBetween(String value1, String value2) {
            addCriterion("batch_id not between", value1, value2, "batchId");
            return (Criteria) this;
        }

        public Criteria andCorpIdIsNull() {
            addCriterion("corp_id is null");
            return (Criteria) this;
        }

        public Criteria andCorpIdIsNotNull() {
            addCriterion("corp_id is not null");
            return (Criteria) this;
        }

        public Criteria andCorpIdEqualTo(String value) {
            addCriterion("corp_id =", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotEqualTo(String value) {
            addCriterion("corp_id <>", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdGreaterThan(String value) {
            addCriterion("corp_id >", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdGreaterThanOrEqualTo(String value) {
            addCriterion("corp_id >=", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdLessThan(String value) {
            addCriterion("corp_id <", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdLessThanOrEqualTo(String value) {
            addCriterion("corp_id <=", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdLike(String value) {
            addCriterion("corp_id like", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotLike(String value) {
            addCriterion("corp_id not like", value, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdIn(List<String> values) {
            addCriterion("corp_id in", values, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotIn(List<String> values) {
            addCriterion("corp_id not in", values, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdBetween(String value1, String value2) {
            addCriterion("corp_id between", value1, value2, "corpId");
            return (Criteria) this;
        }

        public Criteria andCorpIdNotBetween(String value1, String value2) {
            addCriterion("corp_id not between", value1, value2, "corpId");
            return (Criteria) this;
        }

        public Criteria andSrcNameIsNull() {
            addCriterion("src_name is null");
            return (Criteria) this;
        }

        public Criteria andSrcNameIsNotNull() {
            addCriterion("src_name is not null");
            return (Criteria) this;
        }

        public Criteria andSrcNameEqualTo(String value) {
            addCriterion("src_name =", value, "srcName");
            return (Criteria) this;
        }

        public Criteria andSrcNameNotEqualTo(String value) {
            addCriterion("src_name <>", value, "srcName");
            return (Criteria) this;
        }

        public Criteria andSrcNameGreaterThan(String value) {
            addCriterion("src_name >", value, "srcName");
            return (Criteria) this;
        }

        public Criteria andSrcNameGreaterThanOrEqualTo(String value) {
            addCriterion("src_name >=", value, "srcName");
            return (Criteria) this;
        }

        public Criteria andSrcNameLessThan(String value) {
            addCriterion("src_name <", value, "srcName");
            return (Criteria) this;
        }

        public Criteria andSrcNameLessThanOrEqualTo(String value) {
            addCriterion("src_name <=", value, "srcName");
            return (Criteria) this;
        }

        public Criteria andSrcNameLike(String value) {
            addCriterion("src_name like", value, "srcName");
            return (Criteria) this;
        }

        public Criteria andSrcNameNotLike(String value) {
            addCriterion("src_name not like", value, "srcName");
            return (Criteria) this;
        }

        public Criteria andSrcNameIn(List<String> values) {
            addCriterion("src_name in", values, "srcName");
            return (Criteria) this;
        }

        public Criteria andSrcNameNotIn(List<String> values) {
            addCriterion("src_name not in", values, "srcName");
            return (Criteria) this;
        }

        public Criteria andSrcNameBetween(String value1, String value2) {
            addCriterion("src_name between", value1, value2, "srcName");
            return (Criteria) this;
        }

        public Criteria andSrcNameNotBetween(String value1, String value2) {
            addCriterion("src_name not between", value1, value2, "srcName");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNull() {
            addCriterion("template_id is null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNotNull() {
            addCriterion("template_id is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdEqualTo(Long value) {
            addCriterion("template_id =", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotEqualTo(Long value) {
            addCriterion("template_id <>", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThan(Long value) {
            addCriterion("template_id >", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("template_id >=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThan(Long value) {
            addCriterion("template_id <", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThanOrEqualTo(Long value) {
            addCriterion("template_id <=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIn(List<Long> values) {
            addCriterion("template_id in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotIn(List<Long> values) {
            addCriterion("template_id not in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdBetween(Long value1, Long value2) {
            addCriterion("template_id between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotBetween(Long value1, Long value2) {
            addCriterion("template_id not between", value1, value2, "templateId");
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

        public Criteria andVerifyIdIsNull() {
            addCriterion("verify_id is null");
            return (Criteria) this;
        }

        public Criteria andVerifyIdIsNotNull() {
            addCriterion("verify_id is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyIdEqualTo(Long value) {
            addCriterion("verify_id =", value, "verifyId");
            return (Criteria) this;
        }

        public Criteria andVerifyIdNotEqualTo(Long value) {
            addCriterion("verify_id <>", value, "verifyId");
            return (Criteria) this;
        }

        public Criteria andVerifyIdGreaterThan(Long value) {
            addCriterion("verify_id >", value, "verifyId");
            return (Criteria) this;
        }

        public Criteria andVerifyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("verify_id >=", value, "verifyId");
            return (Criteria) this;
        }

        public Criteria andVerifyIdLessThan(Long value) {
            addCriterion("verify_id <", value, "verifyId");
            return (Criteria) this;
        }

        public Criteria andVerifyIdLessThanOrEqualTo(Long value) {
            addCriterion("verify_id <=", value, "verifyId");
            return (Criteria) this;
        }

        public Criteria andVerifyIdIn(List<Long> values) {
            addCriterion("verify_id in", values, "verifyId");
            return (Criteria) this;
        }

        public Criteria andVerifyIdNotIn(List<Long> values) {
            addCriterion("verify_id not in", values, "verifyId");
            return (Criteria) this;
        }

        public Criteria andVerifyIdBetween(Long value1, Long value2) {
            addCriterion("verify_id between", value1, value2, "verifyId");
            return (Criteria) this;
        }

        public Criteria andVerifyIdNotBetween(Long value1, Long value2) {
            addCriterion("verify_id not between", value1, value2, "verifyId");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNull() {
            addCriterion("phone_num is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNotNull() {
            addCriterion("phone_num is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumEqualTo(String value) {
            addCriterion("phone_num =", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotEqualTo(String value) {
            addCriterion("phone_num <>", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThan(String value) {
            addCriterion("phone_num >", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThanOrEqualTo(String value) {
            addCriterion("phone_num >=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThan(String value) {
            addCriterion("phone_num <", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThanOrEqualTo(String value) {
            addCriterion("phone_num <=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLike(String value) {
            addCriterion("phone_num like", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotLike(String value) {
            addCriterion("phone_num not like", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIn(List<String> values) {
            addCriterion("phone_num in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotIn(List<String> values) {
            addCriterion("phone_num not in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumBetween(String value1, String value2) {
            addCriterion("phone_num between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotBetween(String value1, String value2) {
            addCriterion("phone_num not between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andParaContentIsNull() {
            addCriterion("para_content is null");
            return (Criteria) this;
        }

        public Criteria andParaContentIsNotNull() {
            addCriterion("para_content is not null");
            return (Criteria) this;
        }

        public Criteria andParaContentEqualTo(String value) {
            addCriterion("para_content =", value, "paraContent");
            return (Criteria) this;
        }

        public Criteria andParaContentNotEqualTo(String value) {
            addCriterion("para_content <>", value, "paraContent");
            return (Criteria) this;
        }

        public Criteria andParaContentGreaterThan(String value) {
            addCriterion("para_content >", value, "paraContent");
            return (Criteria) this;
        }

        public Criteria andParaContentGreaterThanOrEqualTo(String value) {
            addCriterion("para_content >=", value, "paraContent");
            return (Criteria) this;
        }

        public Criteria andParaContentLessThan(String value) {
            addCriterion("para_content <", value, "paraContent");
            return (Criteria) this;
        }

        public Criteria andParaContentLessThanOrEqualTo(String value) {
            addCriterion("para_content <=", value, "paraContent");
            return (Criteria) this;
        }

        public Criteria andParaContentLike(String value) {
            addCriterion("para_content like", value, "paraContent");
            return (Criteria) this;
        }

        public Criteria andParaContentNotLike(String value) {
            addCriterion("para_content not like", value, "paraContent");
            return (Criteria) this;
        }

        public Criteria andParaContentIn(List<String> values) {
            addCriterion("para_content in", values, "paraContent");
            return (Criteria) this;
        }

        public Criteria andParaContentNotIn(List<String> values) {
            addCriterion("para_content not in", values, "paraContent");
            return (Criteria) this;
        }

        public Criteria andParaContentBetween(String value1, String value2) {
            addCriterion("para_content between", value1, value2, "paraContent");
            return (Criteria) this;
        }

        public Criteria andParaContentNotBetween(String value1, String value2) {
            addCriterion("para_content not between", value1, value2, "paraContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentIsNull() {
            addCriterion("sms_content is null");
            return (Criteria) this;
        }

        public Criteria andSmsContentIsNotNull() {
            addCriterion("sms_content is not null");
            return (Criteria) this;
        }

        public Criteria andSmsContentEqualTo(String value) {
            addCriterion("sms_content =", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentNotEqualTo(String value) {
            addCriterion("sms_content <>", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentGreaterThan(String value) {
            addCriterion("sms_content >", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentGreaterThanOrEqualTo(String value) {
            addCriterion("sms_content >=", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentLessThan(String value) {
            addCriterion("sms_content <", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentLessThanOrEqualTo(String value) {
            addCriterion("sms_content <=", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentLike(String value) {
            addCriterion("sms_content like", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentNotLike(String value) {
            addCriterion("sms_content not like", value, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentIn(List<String> values) {
            addCriterion("sms_content in", values, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentNotIn(List<String> values) {
            addCriterion("sms_content not in", values, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentBetween(String value1, String value2) {
            addCriterion("sms_content between", value1, value2, "smsContent");
            return (Criteria) this;
        }

        public Criteria andSmsContentNotBetween(String value1, String value2) {
            addCriterion("sms_content not between", value1, value2, "smsContent");
            return (Criteria) this;
        }

        public Criteria andTransformStatusIsNull() {
            addCriterion("transform_status is null");
            return (Criteria) this;
        }

        public Criteria andTransformStatusIsNotNull() {
            addCriterion("transform_status is not null");
            return (Criteria) this;
        }

        public Criteria andTransformStatusEqualTo(Integer value) {
            addCriterion("transform_status =", value, "transformStatus");
            return (Criteria) this;
        }

        public Criteria andTransformStatusNotEqualTo(Integer value) {
            addCriterion("transform_status <>", value, "transformStatus");
            return (Criteria) this;
        }

        public Criteria andTransformStatusGreaterThan(Integer value) {
            addCriterion("transform_status >", value, "transformStatus");
            return (Criteria) this;
        }

        public Criteria andTransformStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("transform_status >=", value, "transformStatus");
            return (Criteria) this;
        }

        public Criteria andTransformStatusLessThan(Integer value) {
            addCriterion("transform_status <", value, "transformStatus");
            return (Criteria) this;
        }

        public Criteria andTransformStatusLessThanOrEqualTo(Integer value) {
            addCriterion("transform_status <=", value, "transformStatus");
            return (Criteria) this;
        }

        public Criteria andTransformStatusIn(List<Integer> values) {
            addCriterion("transform_status in", values, "transformStatus");
            return (Criteria) this;
        }

        public Criteria andTransformStatusNotIn(List<Integer> values) {
            addCriterion("transform_status not in", values, "transformStatus");
            return (Criteria) this;
        }

        public Criteria andTransformStatusBetween(Integer value1, Integer value2) {
            addCriterion("transform_status between", value1, value2, "transformStatus");
            return (Criteria) this;
        }

        public Criteria andTransformStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("transform_status not between", value1, value2, "transformStatus");
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

        public Criteria andReportFlagIsNull() {
            addCriterion("report_flag is null");
            return (Criteria) this;
        }

        public Criteria andReportFlagIsNotNull() {
            addCriterion("report_flag is not null");
            return (Criteria) this;
        }

        public Criteria andReportFlagEqualTo(Integer value) {
            addCriterion("report_flag =", value, "reportFlag");
            return (Criteria) this;
        }

        public Criteria andReportFlagNotEqualTo(Integer value) {
            addCriterion("report_flag <>", value, "reportFlag");
            return (Criteria) this;
        }

        public Criteria andReportFlagGreaterThan(Integer value) {
            addCriterion("report_flag >", value, "reportFlag");
            return (Criteria) this;
        }

        public Criteria andReportFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_flag >=", value, "reportFlag");
            return (Criteria) this;
        }

        public Criteria andReportFlagLessThan(Integer value) {
            addCriterion("report_flag <", value, "reportFlag");
            return (Criteria) this;
        }

        public Criteria andReportFlagLessThanOrEqualTo(Integer value) {
            addCriterion("report_flag <=", value, "reportFlag");
            return (Criteria) this;
        }

        public Criteria andReportFlagIn(List<Integer> values) {
            addCriterion("report_flag in", values, "reportFlag");
            return (Criteria) this;
        }

        public Criteria andReportFlagNotIn(List<Integer> values) {
            addCriterion("report_flag not in", values, "reportFlag");
            return (Criteria) this;
        }

        public Criteria andReportFlagBetween(Integer value1, Integer value2) {
            addCriterion("report_flag between", value1, value2, "reportFlag");
            return (Criteria) this;
        }

        public Criteria andReportFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("report_flag not between", value1, value2, "reportFlag");
            return (Criteria) this;
        }

        public Criteria andReportRecFlagIsNull() {
            addCriterion("report_Rec_flag is null");
            return (Criteria) this;
        }

        public Criteria andReportRecFlagIsNotNull() {
            addCriterion("report_Rec_flag is not null");
            return (Criteria) this;
        }

        public Criteria andReportRecFlagEqualTo(Integer value) {
            addCriterion("report_Rec_flag =", value, "reportRecFlag");
            return (Criteria) this;
        }

        public Criteria andReportRecFlagNotEqualTo(Integer value) {
            addCriterion("report_Rec_flag <>", value, "reportRecFlag");
            return (Criteria) this;
        }

        public Criteria andReportRecFlagGreaterThan(Integer value) {
            addCriterion("report_Rec_flag >", value, "reportRecFlag");
            return (Criteria) this;
        }

        public Criteria andReportRecFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_Rec_flag >=", value, "reportRecFlag");
            return (Criteria) this;
        }

        public Criteria andReportRecFlagLessThan(Integer value) {
            addCriterion("report_Rec_flag <", value, "reportRecFlag");
            return (Criteria) this;
        }

        public Criteria andReportRecFlagLessThanOrEqualTo(Integer value) {
            addCriterion("report_Rec_flag <=", value, "reportRecFlag");
            return (Criteria) this;
        }

        public Criteria andReportRecFlagIn(List<Integer> values) {
            addCriterion("report_Rec_flag in", values, "reportRecFlag");
            return (Criteria) this;
        }

        public Criteria andReportRecFlagNotIn(List<Integer> values) {
            addCriterion("report_Rec_flag not in", values, "reportRecFlag");
            return (Criteria) this;
        }

        public Criteria andReportRecFlagBetween(Integer value1, Integer value2) {
            addCriterion("report_Rec_flag between", value1, value2, "reportRecFlag");
            return (Criteria) this;
        }

        public Criteria andReportRecFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("report_Rec_flag not between", value1, value2, "reportRecFlag");
            return (Criteria) this;
        }

        public Criteria andReportRecResultIsNull() {
            addCriterion("report_Rec_result is null");
            return (Criteria) this;
        }

        public Criteria andReportRecResultIsNotNull() {
            addCriterion("report_Rec_result is not null");
            return (Criteria) this;
        }

        public Criteria andReportRecResultEqualTo(String value) {
            addCriterion("report_Rec_result =", value, "reportRecResult");
            return (Criteria) this;
        }

        public Criteria andReportRecResultNotEqualTo(String value) {
            addCriterion("report_Rec_result <>", value, "reportRecResult");
            return (Criteria) this;
        }

        public Criteria andReportRecResultGreaterThan(String value) {
            addCriterion("report_Rec_result >", value, "reportRecResult");
            return (Criteria) this;
        }

        public Criteria andReportRecResultGreaterThanOrEqualTo(String value) {
            addCriterion("report_Rec_result >=", value, "reportRecResult");
            return (Criteria) this;
        }

        public Criteria andReportRecResultLessThan(String value) {
            addCriterion("report_Rec_result <", value, "reportRecResult");
            return (Criteria) this;
        }

        public Criteria andReportRecResultLessThanOrEqualTo(String value) {
            addCriterion("report_Rec_result <=", value, "reportRecResult");
            return (Criteria) this;
        }

        public Criteria andReportRecResultLike(String value) {
            addCriterion("report_Rec_result like", value, "reportRecResult");
            return (Criteria) this;
        }

        public Criteria andReportRecResultNotLike(String value) {
            addCriterion("report_Rec_result not like", value, "reportRecResult");
            return (Criteria) this;
        }

        public Criteria andReportRecResultIn(List<String> values) {
            addCriterion("report_Rec_result in", values, "reportRecResult");
            return (Criteria) this;
        }

        public Criteria andReportRecResultNotIn(List<String> values) {
            addCriterion("report_Rec_result not in", values, "reportRecResult");
            return (Criteria) this;
        }

        public Criteria andReportRecResultBetween(String value1, String value2) {
            addCriterion("report_Rec_result between", value1, value2, "reportRecResult");
            return (Criteria) this;
        }

        public Criteria andReportRecResultNotBetween(String value1, String value2) {
            addCriterion("report_Rec_result not between", value1, value2, "reportRecResult");
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

        public Criteria andMaxTimesIsNull() {
            addCriterion("Max_times is null");
            return (Criteria) this;
        }

        public Criteria andMaxTimesIsNotNull() {
            addCriterion("Max_times is not null");
            return (Criteria) this;
        }

        public Criteria andMaxTimesEqualTo(Integer value) {
            addCriterion("Max_times =", value, "maxTimes");
            return (Criteria) this;
        }

        public Criteria andMaxTimesNotEqualTo(Integer value) {
            addCriterion("Max_times <>", value, "maxTimes");
            return (Criteria) this;
        }

        public Criteria andMaxTimesGreaterThan(Integer value) {
            addCriterion("Max_times >", value, "maxTimes");
            return (Criteria) this;
        }

        public Criteria andMaxTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("Max_times >=", value, "maxTimes");
            return (Criteria) this;
        }

        public Criteria andMaxTimesLessThan(Integer value) {
            addCriterion("Max_times <", value, "maxTimes");
            return (Criteria) this;
        }

        public Criteria andMaxTimesLessThanOrEqualTo(Integer value) {
            addCriterion("Max_times <=", value, "maxTimes");
            return (Criteria) this;
        }

        public Criteria andMaxTimesIn(List<Integer> values) {
            addCriterion("Max_times in", values, "maxTimes");
            return (Criteria) this;
        }

        public Criteria andMaxTimesNotIn(List<Integer> values) {
            addCriterion("Max_times not in", values, "maxTimes");
            return (Criteria) this;
        }

        public Criteria andMaxTimesBetween(Integer value1, Integer value2) {
            addCriterion("Max_times between", value1, value2, "maxTimes");
            return (Criteria) this;
        }

        public Criteria andMaxTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("Max_times not between", value1, value2, "maxTimes");
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

        public Criteria andReportTimeIsNull() {
            addCriterion("report_time is null");
            return (Criteria) this;
        }

        public Criteria andReportTimeIsNotNull() {
            addCriterion("report_time is not null");
            return (Criteria) this;
        }

        public Criteria andReportTimeEqualTo(Timestamp value) {
            addCriterion("report_time =", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotEqualTo(Timestamp value) {
            addCriterion("report_time <>", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeGreaterThan(Timestamp value) {
            addCriterion("report_time >", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("report_time >=", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeLessThan(Timestamp value) {
            addCriterion("report_time <", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("report_time <=", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeIn(List<Timestamp> values) {
            addCriterion("report_time in", values, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotIn(List<Timestamp> values) {
            addCriterion("report_time not in", values, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("report_time between", value1, value2, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("report_time not between", value1, value2, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReservedIsNull() {
            addCriterion("reserved is null");
            return (Criteria) this;
        }

        public Criteria andReservedIsNotNull() {
            addCriterion("reserved is not null");
            return (Criteria) this;
        }

        public Criteria andReservedEqualTo(String value) {
            addCriterion("reserved =", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotEqualTo(String value) {
            addCriterion("reserved <>", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedGreaterThan(String value) {
            addCriterion("reserved >", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedGreaterThanOrEqualTo(String value) {
            addCriterion("reserved >=", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedLessThan(String value) {
            addCriterion("reserved <", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedLessThanOrEqualTo(String value) {
            addCriterion("reserved <=", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedLike(String value) {
            addCriterion("reserved like", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotLike(String value) {
            addCriterion("reserved not like", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedIn(List<String> values) {
            addCriterion("reserved in", values, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotIn(List<String> values) {
            addCriterion("reserved not in", values, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedBetween(String value1, String value2) {
            addCriterion("reserved between", value1, value2, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotBetween(String value1, String value2) {
            addCriterion("reserved not between", value1, value2, "reserved");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("Remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("Remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("Remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("Remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("Remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("Remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("Remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("Remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("Remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("Remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("Remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("Remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("Remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("Remark not between", value1, value2, "remark");
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