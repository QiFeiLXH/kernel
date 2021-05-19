package com.bsoft.sales.dto;


import java.io.Serializable;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/3/29 17:01
 * @Description
 */
public class SalesContractAreaDTO implements Serializable {
    /** 部门id */
    private String deptId;
    /** 部门名称 */
    private String deptName;
    /** 上级部门id */
    private String parentDeptId;
    /** 未审数量 */
    private Integer unreviewedCount;
    /** 未关联数量 */
    private Integer notassociatedCount;
    private List<SalesContractAreaDTO> children;

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

    public Integer getUnreviewedCount() {
        return unreviewedCount;
    }

    public void setUnreviewedCount(Integer unreviewedCount) {
        this.unreviewedCount = unreviewedCount;
    }

    public Integer getNotassociatedCount() {
        return notassociatedCount;
    }

    public void setNotassociatedCount(Integer notassociatedCount) {
        this.notassociatedCount = notassociatedCount;
    }

    public List<SalesContractAreaDTO> getChildren() {
        return children;
    }

    public void setChildren(List<SalesContractAreaDTO> children) {
        this.children = children;
    }
}
