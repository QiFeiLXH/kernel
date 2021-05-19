package com.bsoft.workflow.dto;

import java.io.Serializable;

/**
 * @Author zhanglf
 * @Date 2020-12-11 17:17
 * @Version 1.0
 */
public class TaskAuditDTO implements Serializable {
    private String taskId;//任务id
    private String opinion;
    private Integer system;


    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public Integer getSystem() {
        return system;
    }

    public void setSystem(Integer system) {
        this.system = system;
    }
}
