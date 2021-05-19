package com.bsoft.dept.dto;

import java.io.Serializable;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.dept.dto
 * @Author: Xuhui Lin
 * @CreateTime: 2020-03-05
 * @Description:
 */
public class DeptDTO implements Serializable {
    private String deptId;
    private String deptName;
    private Integer logout;
    private String simpleCode;
    private String depManager;

    private String parentId;
    private Integer personNum;
    private Integer sortBy;
    private Integer deptFlag;

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

    public Integer getLogout() {
        return logout;
    }

    public void setLogout(Integer logout) {
        this.logout = logout;
    }

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum;
    }

    public Integer getSortBy() {
        return sortBy;
    }

    public void setSortBy(Integer sortBy) {
        this.sortBy = sortBy;
    }

    public Integer getDeptFlag() {
        return deptFlag;
    }

    public void setDeptFlag(Integer deptFlag) {
        this.deptFlag = deptFlag;
    }

    public String getDepManager() {
        return depManager;
    }

    public void setDepManager(String depManager) {
        this.depManager = depManager;
    }
}
