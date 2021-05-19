package com.bsoft.dept.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.dept.entity
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-21
 * @Description: 部门选择
 */
public class DeptSelectDTO implements Serializable {
    /** 部门代码 */
    private String value;
    /** 部门名称 */
    private String title;
    /** 上级部门代码*/
    private String parentId;
    /** 注销标志 0未注销 1已注销 */
    private Integer logout;
    /** 拼音简码 */
    private String simpleCode;
    private List<DeptSelectDTO> children;
    private Integer sortBy;

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

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public List<DeptSelectDTO> getChildren() {
        return children;
    }

    public void setChildren(List<DeptSelectDTO> children) {
        this.children = children;
    }

    public Integer getSortBy() {
        return sortBy;
    }

    public void setSortBy(Integer sortBy) {
        this.sortBy = sortBy;
    }
}
