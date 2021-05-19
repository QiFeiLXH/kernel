package com.bsoft.person.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.person.entity
 * @Author: Qi fei
 * @CreateTime: 2020-03-14 15:41
 * @Description: 人员选择
 */
@Entity
@Table(name = "bsoft_portal.ker_person_select")
public class PersonSelectViewDO {
    @Id
    /** 员工工号 */
    private String personId;
    /** 员工姓名 */
    private String personName;
    /** 员工姓名拼音 */
    private String simpleCode;
    /** 部门代码 */
    private String deptCode;
    /** 部门名称 */
    private String deptName;
    /** 一级部门id */
    private Integer largeDeptId;
    /** 一级部门名称 */
    private String largeDeptName;
    /** 员工离职标志 0未离职 1离职 */
    private String isValid;

    private String mobile;

    private String email;

    private Integer company;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getLargeDeptId() {
        return largeDeptId;
    }

    public void setLargeDeptId(Integer largeDeptId) {
        this.largeDeptId = largeDeptId;
    }

    public String getLargeDeptName() {
        return largeDeptName;
    }

    public void setLargeDeptName(String largeDeptName) {
        this.largeDeptName = largeDeptName;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }
}
