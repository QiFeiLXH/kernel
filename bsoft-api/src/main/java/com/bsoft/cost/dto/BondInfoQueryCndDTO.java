package com.bsoft.cost.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/4/21 16:56
 * @Description
 */
public class BondInfoQueryCndDTO implements Serializable {
    private Integer pageNo;
    private Integer pageSize;
    private String userId;
    private Integer overdueFlag;
    private Integer chargeFlag;
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

    public Integer getOverdueFlag() {
        return overdueFlag;
    }

    public void setOverdueFlag(Integer overdueFlag) {
        this.overdueFlag = overdueFlag;
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

    public Integer getChargeFlag() {
        return chargeFlag;
    }

    public void setChargeFlag(Integer chargeFlag) {
        this.chargeFlag = chargeFlag;
    }
}
