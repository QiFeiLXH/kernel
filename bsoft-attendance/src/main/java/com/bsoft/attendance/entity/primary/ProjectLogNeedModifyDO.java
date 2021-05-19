package com.bsoft.attendance.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author zhanglf
 * @Date 2020-04-08 15:32
 * @Version 1.0
 * @Description
 */
@Entity
@Table(name = "PRO_WORKLOG_NEEDMODIFY_VIEW")
public class ProjectLogNeedModifyDO {
    private Integer worklogId;
    private String contractno;
    private Integer auditType;
    private String submitter;
    private String projectId;


    @Id
    public Integer getWorklogId() {
        return worklogId;
    }

    public void setWorklogId(Integer worklogId) {
        this.worklogId = worklogId;
    }

    public String getContractno() {
        return contractno;
    }

    public void setContractno(String contractno) {
        this.contractno = contractno;
    }

    public Integer getAuditType() {
        return auditType;
    }

    public void setAuditType(Integer auditType) {
        this.auditType = auditType;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
