package com.bsoft.dept.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "BSOFTMIS.T_DEP")
public class DeptDO implements Serializable {
    private String deptId;
    private String deptName;
    private Integer logout;
    private String simpleCode;
    private String depManager;
    private String firstManager;
    private String hr;
    private String parentId;
    private String leader;
    private Date estDate;//成立日期
    private Date logoutDate;//注销日期
    private Integer deptType;
    private Integer deptFlag;
    private Integer headQuarters;
    private Integer sortBy;

    @Column(name = "bmlx")
    public Integer getDeptType() {
        return deptType;
    }

    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }

    /**
     * 用于set去重
     * @param arg0
     * @return
     */
    @Override
    public boolean equals(Object arg0) {
        // TODO Auto-generated method stub
        DeptDO p = (DeptDO) arg0;
        return deptId.equals(p.deptId);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        String str = deptId;
        return str.hashCode();
    }

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

    @Column(name = "yfzg")
    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    @Column(name = "clrq")
    public Date getEstDate() {
        return estDate;
    }

    public void setEstDate(Date estDate) {
        this.estDate = estDate;
    }

    @Column(name = "ZXRQ")
    public Date getLogoutDate() {
        return logoutDate;
    }

    public void setLogoutDate(Date logoutDate) {
        this.logoutDate = logoutDate;
    }

    @Column(name = "bmlb")
    public Integer getDeptFlag() {
        return deptFlag;
    }

    public void setDeptFlag(Integer deptFlag) {
        this.deptFlag = deptFlag;
    }

    @Column(name = "gsbb")
    public Integer getHeadQuarters() {
        return headQuarters;
    }

    public void setHeadQuarters(Integer headQuarters) {
        this.headQuarters = headQuarters;
    }

    public Integer getSortBy() {
        return sortBy;
    }

    public void setSortBy(Integer sortBy) {
        this.sortBy = sortBy;
    }
}
