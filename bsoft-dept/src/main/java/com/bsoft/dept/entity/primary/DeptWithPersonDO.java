package com.bsoft.dept.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ker_sys_dept_personnum_view")
public class DeptWithPersonDO implements Serializable {
    private String deptId;
    private String deptName;
    private Integer logout;
    private String simpleCode;
    private String depManager;
    private String firstManager;
    private String hr;
    private String parentId;
    private Integer personNum;

    @Id
    @Column(name = "bmdm")
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
    @Column(name = "bmmc")
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    @Column(name = "zxbz")
    public Integer getLogout() {
        return logout;
    }

    public void setLogout(Integer logout) {
        this.logout = logout;
    }

    @Column(name = "srdm")
    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public String getDepManager() {
        return depManager;
    }

    public void setDepManager(String depManager) {
        this.depManager = depManager;
    }

    @Column(name = "qyfz")
    public String getFirstManager() {
        return firstManager;
    }

    public void setFirstManager(String firstManager) {
        this.firstManager = firstManager;
    }

    @Column(name = "xzzg")
    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    @Column(name = "parentBm")
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
}
