package com.bsoft.sales.entity.primary;

import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2021/4/19 10:52
 * @Description
 */
public class SalesContractCheckViewDO {
    /** 合同号 */
    private String contractNo;
    /** 客户名称 */
    private String customerName;
    /** 评审人 */
    private String reviewerName;
    /** 排序 */
    private Integer sortby;
    /** 标志 */
    private Integer completeFlag;
    private String completeFlagText;
    /** 核对人 */
    private String checkPerson;
    /** 核对人名字 */
    private String checkPersonName;
    /** 核对日期 */
    private Date checkDate;
    /** 核对标志 */
    private Integer checkedFlag;
    /** 合同编号 */
    private String contractId;

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public Integer getSortby() {
        return sortby;
    }

    public void setSortby(Integer sortby) {
        this.sortby = sortby;
    }

    public Integer getCompleteFlag() {
        return completeFlag;
    }

    public void setCompleteFlag(Integer completeFlag) {
        this.completeFlag = completeFlag;
    }

    public String getCompleteFlagText() {
        return completeFlagText;
    }

    public void setCompleteFlagText(String completeFlagText) {
        this.completeFlagText = completeFlagText;
    }

    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }

    public String getCheckPersonName() {
        return checkPersonName;
    }

    public void setCheckPersonName(String checkPersonName) {
        this.checkPersonName = checkPersonName;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public Integer getCheckedFlag() {
        return checkedFlag;
    }

    public void setCheckedFlag(Integer checkedFlag) {
        this.checkedFlag = checkedFlag;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }
}
