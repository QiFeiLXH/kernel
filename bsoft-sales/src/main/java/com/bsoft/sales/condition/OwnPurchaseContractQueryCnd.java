package com.bsoft.sales.condition;

import java.util.Date;

/**
 * @Author: Xuhui Lin
 * @DateTime: 2020/11/5
 * @Description: 公司自用采购合同查询条件DTO
 */
public class OwnPurchaseContractQueryCnd {
    /** 页码 */
    private Integer pageNo;
    /** 单页条数 */
    private Integer pageSize;
    /** 查找内容 */
    private String inputContent;
    /** 签定年份 */
    private Integer signYear;
    /** 完结标志 */
    private Integer endMark;
    /** 完结标志 */
    private String personId;
    /** 审核状态 */
    private Integer auditStatus;
    /** 开始年份 */
    private Date startDate;
    /** 结束 */
    private Date endDate;
    /** 进度标志 */
    private Integer progressFlag;
    /** 日期范围标志  1 发放日期   2 核算日期 */
    private Integer dateRangeFlag;


    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public Integer getSignYear() {
        return signYear;
    }

    public void setSignYear(Integer signYear) {
        this.signYear = signYear;
    }

    public Integer getEndMark() {
        return endMark;
    }

    public void setEndMark(Integer endMark) {
        this.endMark = endMark;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getProgressFlag() {
        return progressFlag;
    }

    public void setProgressFlag(Integer progressFlag) {
        this.progressFlag = progressFlag;
    }

    public Integer getDateRangeFlag() {
        return dateRangeFlag;
    }

    public void setDateRangeFlag(Integer dateRangeFlag) {
        this.dateRangeFlag = dateRangeFlag;
    }
}
