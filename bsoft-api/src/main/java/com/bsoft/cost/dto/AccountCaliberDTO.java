package com.bsoft.cost.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/4 10:59
 * @Description
 */
public class AccountCaliberDTO implements Serializable {
    private Integer id;
    /** 部门id */
    private String deptId;
    /** 部门名称*/
    private String deptName;
    /** 一级部门id */
    private String parentDeptId;
    /** 一级部门名称 */
    private String parentDeptName;
    /** 部门类别 */
    private Integer deptType;
    private String deptTypeText;
    /** 年份 */
    private Integer year;
    /** 核算口径归属 */
    private String accountCalibers;
    private String accountCaliberNames;
    private String costTypes;
    private String costTypeNames;
    /** 登记日期 */
    private Date registrationDate;
    private Integer  costType;
    private String  costTypeName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getParentDeptId() {
        return parentDeptId;
    }

    public void setParentDeptId(String parentDeptId) {
        this.parentDeptId = parentDeptId;
    }

    public String getParentDeptName() {
        return parentDeptName;
    }

    public void setParentDeptName(String parentDeptName) {
        this.parentDeptName = parentDeptName;
    }

    public Integer getDeptType() {
        return deptType;
    }

    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }

    public String getDeptTypeText() {
        return deptTypeText;
    }

    public void setDeptTypeText(String deptTypeText) {
        this.deptTypeText = deptTypeText;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getAccountCalibers() {
        return accountCalibers;
    }

    public void setAccountCalibers(String accountCalibers) {
        this.accountCalibers = accountCalibers;
    }

    public String getAccountCaliberNames() {
        return accountCaliberNames;
    }

    public void setAccountCaliberNames(String accountCaliberNames) {
        this.accountCaliberNames = accountCaliberNames;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getCostTypes() {
        return costTypes;
    }

    public void setCostTypes(String costTypes) {
        this.costTypes = costTypes;
    }

    public String getCostTypeNames() {
        return costTypeNames;
    }

    public void setCostTypeNames(String costTypeNames) {
        this.costTypeNames = costTypeNames;
    }

    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }

    public String getCostTypeName() {
        return costTypeName;
    }

    public void setCostTypeName(String costTypeName) {
        this.costTypeName = costTypeName;
    }
}
