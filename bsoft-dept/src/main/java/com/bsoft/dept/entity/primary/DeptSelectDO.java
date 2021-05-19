package com.bsoft.dept.entity.primary;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.dept.entity
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-21
 * @Description: 部门选择
 */
@Entity
@Table(name="BSOFTMIS.T_DEP")
public class DeptSelectDO implements Serializable {
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
    /** 是否是一级部门*/
    @Column(name="isparent")
    private Integer parentFlag;
    @Transient
    private List<DeptSelectDO> children;

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

    public List<DeptSelectDO> getChildren() {
        return children;
    }

    public void setChildren(List<DeptSelectDO> children) {
        this.children = children;
    }

    public Integer getSortBy() {
        return sortBy;
    }

    public void setSortBy(Integer sortBy) {
        this.sortBy = sortBy;
    }

    public Integer getParentFlag() {
        return parentFlag;
    }

    public void setParentFlag(Integer parentFlag) {
        this.parentFlag = parentFlag;
    }
}
