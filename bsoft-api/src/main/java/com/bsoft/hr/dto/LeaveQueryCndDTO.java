package com.bsoft.hr.dto;


import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/19 11:52
 * @Description
 */
public class LeaveQueryCndDTO implements Serializable {
    /** 年份 */
    private String year;
    /** 页码 */
    private Integer pageNo;
    /** 页量 */
    private Integer pageSize;
    /** 部门id */
    private String deptId;
    /** 输入内容 */
    private String inputContent;
    /** 全部权限 */
    private Integer allPermission;
    /** 工号 */
    private String personId;
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

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public Integer getAllPermission() {
        return allPermission;
    }

    public void setAllPermission(Integer allPermission) {
        this.allPermission = allPermission;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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
