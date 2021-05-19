package com.bsoft.project.dto;

import java.io.Serializable;

/**
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.project.report.entity
 * @Author: Xuhui Lin
 * @CreateTime: 2020-02-06
 * @Description: 项目组成员明细dto
 */
public class ProjectGroupDetailDTO implements Serializable {
    /** 主键  */
    private Integer id;
    /** 项目组ID  */
    private Integer groupId;
    /** 组成员工号  */
    private String personId;
    /** 1、组长 0、组员  */
    private Integer leader;
    /** 维护组长的工号  */
    private String maintainId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getLeader() {
        return leader;
    }

    public void setLeader(Integer leader) {
        this.leader = leader;
    }

    public String getMaintainId() {
        return maintainId;
    }

    public void setMaintainId(String maintainId) {
        this.maintainId = maintainId;
    }
}
