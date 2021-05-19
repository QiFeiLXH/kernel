package com.bsoft.user.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: zy
 * @date: 2020/10/19
 * @description APP用户部门分布情况
 */
@Entity
@Table(name = "bsoft_portal.app_dept_count_view")
public class AppDeptCountViewDO {
    // 部门编号
    @Id
    private String dept;
    // 部门名称
    private String deptName;
    // 部门类别
    private Integer deptType;
    // 部门排序号
    private Integer sortBy;
    // 部门员工数
    private Integer personCount;
    // 部门APP用户数
    private Integer userCount;

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

    public Integer getDeptType() {
        return deptType;
    }

    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }

    public Integer getSortBy() {
        return sortBy;
    }

    public void setSortBy(Integer sortBy) {
        this.sortBy = sortBy;
    }

    public Integer getPersonCount() {
        return personCount;
    }

    public void setPersonCount(Integer personCount) {
        this.personCount = personCount;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }
}
