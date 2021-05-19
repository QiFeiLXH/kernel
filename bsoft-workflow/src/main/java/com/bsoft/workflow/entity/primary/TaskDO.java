package com.bsoft.workflow.entity.primary;

import java.util.Date;

public class TaskDO {
    /**
     * 任务ID
     */
    private String taskId;
    /**
     *任务定义ID
     */
    private String taskDefineKey;
    /**
     * 任务名称
     */
    private String taskName;
    /**
     *任务创建时间
     */
    private Date createTime;
    /**
     *任务待办人或者候选人
     */
    private String assignee;
    /**
     *任务待办人或者候选人姓名
     */
    private String assigneeName;
    /**
     *流程实例ID
     */
    private String processInstanceId;
    /**
     *流程businessKey
     */
    private String businessKey;
    /**
     *流程发起时间
     */
    private Date processCreateTime;
    /**
     *流程定义名称
     */
    private String processName;
    /**
     *流程定义的key
     */
    private String processKey;

    /* 流程发起人ID */
    private String applyUserId;

    /* 流程发起人姓名 */
    private String applyUserName;

    /* 流程申请ID */
    private String applyId;

    /**
     * 待办任务是否已读
     */
    private Boolean readFlag;
    /**
     * 发起部门（跟单部门）
     * @return
     */
    private String dept;
    /**
     * 是否是知会
     * @return
     */
    private Integer notifyFlag;// 0.正常任务  1.知会任务

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskDefineKey() {
        return taskDefineKey;
    }

    public void setTaskDefineKey(String taskDefineKey) {
        this.taskDefineKey = taskDefineKey;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public Date getProcessCreateTime() {
        return processCreateTime;
    }

    public void setProcessCreateTime(Date processCreateTime) {
        this.processCreateTime = processCreateTime;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getProcessKey() {
        return processKey;
    }

    public void setProcessKey(String processKey) {
        this.processKey = processKey;
    }

    public String getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(String applyUserId) {
        this.applyUserId = applyUserId;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public Boolean getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(Boolean readFlag) {
        this.readFlag = readFlag;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getNotifyFlag() {
        return notifyFlag;
    }

    public void setNotifyFlag(Integer notifyFlag) {
        this.notifyFlag = notifyFlag;
    }
}
