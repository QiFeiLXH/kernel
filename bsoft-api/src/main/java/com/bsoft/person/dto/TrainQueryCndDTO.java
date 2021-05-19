package com.bsoft.person.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @BelongsProject: bsoft-office-server
 * @BelongsPackage: com.bsoft.office.administration.condition
 * @Author: Xuhui Lin
 * @CreateTime: 2020-07-21 19:48
 * @Description:
 */
public class TrainQueryCndDTO implements Serializable {
    /** 页码 */
    private Integer pageNo;
    /** 每页条数 */
    private Integer pageSize;
    /** 输入内容 */
    private String inputContent;
    /** 部门id */
    private String deptId;
    /** 登记开始日期 */
    private Date startDate;
    /** 登记结束日期 */
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

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
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
