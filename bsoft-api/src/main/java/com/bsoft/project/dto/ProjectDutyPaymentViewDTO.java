package com.bsoft.project.dto;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/19 19:31
 * @Description
 */
public class ProjectDutyPaymentViewDTO implements Serializable {
    private String id;
    /** 合同编号 */
    private String contractNo;
    /** 合同号 */
    private String contractCode;
    /** 付款类型 */
    private Integer paymentType;
    private String paymentTypeText;
    /** 付款科目 */
    private Integer paymentItem;
    private String paymentItemText;
    /** 付款时间 */
    private Date paymentDate;
    /** 付款金额 */
    private Double paymentAmount;
    /** 付款条件 */
    private String paymentCondition;
    /** 计划回款id */
    private Integer planPaymentId;
    /** 责任书id */
    private Integer dutyId;
    /** 计划回款 */
    private Double expected;
    /** 选择标记 1选择 0 未选择 */
    private Integer selectedFlag;
    /** 已回金额 */
    private Double amount;
    private List<ProjectDutyPaymentViewDTO> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentTypeText() {
        return paymentTypeText;
    }

    public void setPaymentTypeText(String paymentTypeText) {
        this.paymentTypeText = paymentTypeText;
    }

    public Integer getPaymentItem() {
        return paymentItem;
    }

    public void setPaymentItem(Integer paymentItem) {
        this.paymentItem = paymentItem;
    }

    public String getPaymentItemText() {
        return paymentItemText;
    }

    public void setPaymentItemText(String paymentItemText) {
        this.paymentItemText = paymentItemText;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentCondition() {
        return paymentCondition;
    }

    public void setPaymentCondition(String paymentCondition) {
        this.paymentCondition = paymentCondition;
    }

    public Integer getPlanPaymentId() {
        return planPaymentId;
    }

    public void setPlanPaymentId(Integer planPaymentId) {
        this.planPaymentId = planPaymentId;
    }

    public Integer getDutyId() {
        return dutyId;
    }

    public void setDutyId(Integer dutyId) {
        this.dutyId = dutyId;
    }

    public Double getExpected() {
        return expected;
    }

    public void setExpected(Double expected) {
        this.expected = expected;
    }

    public Integer getSelectedFlag() {
        return selectedFlag;
    }

    public void setSelectedFlag(Integer selectedFlag) {
        this.selectedFlag = selectedFlag;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public List<ProjectDutyPaymentViewDTO> getChildren() {
        return children;
    }

    public void setChildren(List<ProjectDutyPaymentViewDTO> children) {
        this.children = children;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
