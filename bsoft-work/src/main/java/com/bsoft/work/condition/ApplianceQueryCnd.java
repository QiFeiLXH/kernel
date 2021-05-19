package com.bsoft.work.condition;

import org.hibernate.id.IntegralDataTypeHolder;

import java.util.Date;
import java.util.List;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description
 */
public class ApplianceQueryCnd {
    private Integer stockId;
    private Integer type;
    private Integer name;
    private String inputContent;
    private String userId;
    private String useDept;
    private List<Integer> statusList;
    private String startDateStr;
    private String endDateStr;
    private Integer pageNo;
    private Integer pageSize;
    /**提交标记*/
    private Integer submitFlag;

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUseDept() {
        return useDept;
    }

    public void setUseDept(String useDept) {
        this.useDept = useDept;
    }

    public List<Integer> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Integer> statusList) {
        this.statusList = statusList;
    }

    public String getStartDateStr() {
        return startDateStr;
    }

    public void setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }

    public String getEndDateStr() {
        return endDateStr;
    }

    public void setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
    }

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

    public Integer getSubmitFlag() {
        return submitFlag;
    }

    public void setSubmitFlag(Integer submitFlag) {
        this.submitFlag = submitFlag;
    }
}
