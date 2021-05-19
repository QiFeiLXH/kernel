package com.bsoft.cost.entity.primary;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/3/4 9:30
 * @Description:
 */
public class DeptCostTypeViewDO {
    private Integer year;
    private String dept;
    private String deptName;
    private String registrant;
    private Date registrantDate;
    private String costTypes;
    private Integer costType;
    private Integer deptType;
    private String accountcalibers;
    private String parentDept;
    private String parentDeptName;
    private String deptTypeName;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public Date getRegistrantDate() {
        return registrantDate;
    }

    public void setRegistrantDate(Date registrantDate) {
        this.registrantDate = registrantDate;
    }

    public String getCostTypes() {
        return costTypes;
    }

    public void setCostTypes(String costTypes) {
        this.costTypes = costTypes;
    }

    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }

    public Integer getDeptType() {
        return deptType;
    }

    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }

    public String getAccountcalibers() {
        return accountcalibers;
    }

    public void setAccountcalibers(String accountcalibers) {
        this.accountcalibers = accountcalibers;
    }

    public String getParentDept() {
        return parentDept;
    }

    public void setParentDept(String parentDept) {
        this.parentDept = parentDept;
    }

    public String getParentDeptName() {
        return parentDeptName;
    }

    public void setParentDeptName(String parentDeptName) {
        this.parentDeptName = parentDeptName;
    }

    public String getDeptTypeName() {
        return deptTypeName;
    }

    public void setDeptTypeName(String deptTypeName) {
        this.deptTypeName = deptTypeName;
    }
}
