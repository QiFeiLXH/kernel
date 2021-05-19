package com.bsoft.dept.entity.primary;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/1/19 10:57
 * @Description:
 */

@Entity
@Table(name = "ker_sys_dept_personnum_view")
public class DeptSelectViewDO {
    /** 部门代码 */
    @Id
    @Column(name="bmdm")
    private String value;
    /** 部门名称 */
    @Column(name="bmmc")
    private String title;
    /** 上级部门代码*/
    @Column(name="parentbm")
    private String parentId;
    /** 注销标志 0未注销 1已注销 */
    @Column(name="zxbz")
    private Integer logout;
    /*部门类别*/
    @Column(name="bmlb")
    private Integer deptType;
    /** 拼音简码 */
    @Column(name="srdm")
    private String simpleCode;
    /** 排序号*/
    private Integer sortBy;
    private Integer personNum;
    @Transient
    private List<DeptSelectViewDO> children;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public Integer getSortBy() {
        return sortBy;
    }

    public void setSortBy(Integer sortBy) {
        this.sortBy = sortBy;
    }

    public List<DeptSelectViewDO> getChildren() {
        return children;
    }

    public void setChildren(List<DeptSelectViewDO> children) {
        this.children = children;
    }

    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum;
    }
}
