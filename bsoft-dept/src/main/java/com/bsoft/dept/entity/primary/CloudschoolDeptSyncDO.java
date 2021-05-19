package com.bsoft.dept.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/8/30
 * @description 部门财务维护
 */
@Entity
@Table(name = "BSOFTMIS.t_dep")
public class CloudschoolDeptSyncDO {
    // 一级部门
    @Id
    @Column(name = "bmdm")
    private String dept;

    // 一级部门名称
    @Column(name = "bmmc")
    private String deptName;
    

    // 注销标志
    @Column(name = "zxbz")
    private Integer logout;

    /* 部门类别*/
    @Column(name = "bmlb")
    private Integer deptType;

    // 父部门
    @Column(name = "parentbm")
    private String parentDept;

    // 排序号
    @Column(name = "sortby")
    private Integer sortBy;


    // 创立日期
    @Column(name = "clrq")
    private Date createDate;

    // 创立日期
    @Column(name = "zxrq")
    private Date endDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public Integer getLogout() {
        return logout;
    }

    public void setLogout(Integer logout) {
        this.logout = logout;
    }

    public Integer getDeptType() {
        return deptType;
    }

    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }

    public String getParentDept() {
        return parentDept;
    }

    public void setParentDept(String parentDept) {
        this.parentDept = parentDept;
    }

    public Integer getSortBy() {
        return sortBy;
    }

    public void setSortBy(Integer sortBy) {
        this.sortBy = sortBy;
    }
}
