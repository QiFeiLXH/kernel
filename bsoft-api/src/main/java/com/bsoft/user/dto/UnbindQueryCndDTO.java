package com.bsoft.user.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/7/20 12:45
 * @Description: 申请解绑查询参数
 */
public class UnbindQueryCndDTO implements Serializable {
    private Integer pageNo;
    private Integer pageSize;
    private String inputContent;
    private Date startDate;
    private Date endDate;
    private Integer auditFlag;

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

    public Integer getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(Integer auditFlag) {
        this.auditFlag = auditFlag;
    }
}
