package com.bsoft.clue.condition;

import java.util.Date;
import java.util.List;

public class SalesPlanQueryCnd {
    private Integer pageNo;
    private Integer pageSize;
    private Integer status;
    private String estimateMonth;
    private Date reportDate;
    private Date planDate;
    private String trackPerson;
    private String trackDept;
    private String processInstanceId;
    private List<Integer> statusList;
    private String inputContent;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEstimateMonth() {
        return estimateMonth;
    }

    public void setEstimateMonth(String estimateMonth) {
        this.estimateMonth = estimateMonth;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getTrackPerson() {
        return trackPerson;
    }

    public void setTrackPerson(String trackPerson) {
        this.trackPerson = trackPerson;
    }

    public String getTrackDept() {
        return trackDept;
    }

    public void setTrackDept(String trackDept) {
        this.trackDept = trackDept;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public List<Integer> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Integer> statusList) {
        this.statusList = statusList;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }
}
