package com.bsoft.project.dto;

import java.io.Serializable;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.entity
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-06
 * @Description: 项目组
 */
public class ProjectGroupDTO implements Serializable {
    /** 主键  */
    private Integer id;
    /** 上级ID  */
    private Integer parentId;
    /** 合同编号 */
    private String contractNo;
    /** 组名称  */
    private String groupName;
    /** 排序号 */
    private Integer sortNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }
}
