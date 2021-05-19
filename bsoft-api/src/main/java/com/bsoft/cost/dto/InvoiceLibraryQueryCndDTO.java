package com.bsoft.cost.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class InvoiceLibraryQueryCndDTO  implements Serializable {
    private Integer pageNo;
    private Integer pageSize;
    private String userId;
    private List<Integer> type;
    private Integer companyId;
    private Boolean allPermission;
    private String inputContent;
    private Date startDate;
    private Date endDate;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Integer> getType() {
        return type;
    }

    public void setType(List<Integer> type) {
        this.type = type;
    }

    public Boolean getAllPermission() {
        return allPermission;
    }

    public void setAllPermission(Boolean allPermission) {
        this.allPermission = allPermission;
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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
