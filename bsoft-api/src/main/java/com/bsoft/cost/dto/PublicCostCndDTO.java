package com.bsoft.cost.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/4/21 16:52
 * @Description
 */
public class PublicCostCndDTO implements Serializable {
    private Integer pageNo;
    private Integer pageSize;
    private String userId;
    private Integer returnFlag;
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

    public Integer getReturnFlag() {
        return returnFlag;
    }

    public void setReturnFlag(Integer returnFlag) {
        this.returnFlag = returnFlag;
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
}
