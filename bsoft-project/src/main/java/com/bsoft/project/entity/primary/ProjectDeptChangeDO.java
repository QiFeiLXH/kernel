package com.bsoft.project.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/9/29 11:16
 * @Description: 项目部门变更DO
 */
@Entity
@Table(name = "bsoftmis.PROJECT_CHANGEDEPT")
public class ProjectDeptChangeDO {
    private Integer recordId;
    private Integer projectId;
    private String preDept;
    private Date preStart;
    private Date preEnd;
    private String newDept;
    private Date changeDate;
    private String userId;
    private String project;
    private Integer cancelFlag;

    @Id
    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getPreDept() {
        return preDept;
    }

    public void setPreDept(String preDept) {
        this.preDept = preDept;
    }

    public Date getPreStart() {
        return preStart;
    }

    public void setPreStart(Date preStart) {
        this.preStart = preStart;
    }

    public Date getPreEnd() {
        return preEnd;
    }

    public void setPreEnd(Date preEnd) {
        this.preEnd = preEnd;
    }

    public String getNewDept() {
        return newDept;
    }

    public void setNewDept(String newDept) {
        this.newDept = newDept;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Integer getCancelFlag() {
        return cancelFlag;
    }

    public void setCancelFlag(Integer cancelFlag) {
        this.cancelFlag = cancelFlag;
    }
}
