package com.bsoft.sales.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/16 9:17
 * @Description
 */
public class SalesContractQueryCndDTO implements Serializable {
    /** 页码 */
    private Integer pageNo;
    /** 页量 */
    private Integer pageSize;
    /** 开始日期 */
    private Date startDate;
    /** 截止日期 */
    private Date endDate;
    /** 输入内容 */
    private String inputContent;
    /** 关联标志 */
    private List<Integer> relationFlag;
    /** 工号 */
    private String personId;
    /** 合同编号 */
    private String contractId;
    /** 全部 */
    private Boolean allPermission;

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

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public List<Integer> getRelationFlag() {
        return relationFlag;
    }

    public void setRelationFlag(List<Integer> relationFlag) {
        this.relationFlag = relationFlag;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public Boolean getAllPermission() {
        return allPermission;
    }

    public void setAllPermission(Boolean allPermission) {
        this.allPermission = allPermission;
    }
}
