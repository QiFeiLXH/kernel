package com.bsoft.workflow.dto;


import java.io.Serializable;
import java.util.Date;

public class ActionRecordDTO implements Serializable {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 流程ID
     */
    private String processInstanceId;
    /**
     * 操作人
     */
    private String auditor;
    /**
     * 审核意见
     */
    private String auditOpinion;
    /**
     * 审核时间
     */
    private Date auditDate;
    /**
     * 操作名称备注
     */
    private String action;
    /**
     * 任务环节
     */
    private String taskName;
    /**
     *操作系统 1.手机客户端  5.web门户
     * @return
     */
    private Integer system;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getAuditOpinion() {
        return auditOpinion;
    }

    public void setAuditOpinion(String auditOpinion) {
        this.auditOpinion = auditOpinion;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getSystem() {
        return system;
    }

    public void setSystem(Integer system) {
        this.system = system;
    }
}
