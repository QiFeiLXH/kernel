package com.bsoft.system.dto;

import java.io.Serializable;

/**
 * @Author zhanglf
 * @Date 2020-06-29 14:34
 * @Version 1.0
 * @Description
 */
public class TimeTaskQueryCndDTO implements Serializable {
    private String context;//任务名称/任务分组名称/任务描述
    private Integer taskType;//任务分组
    private Integer pageNo;
    private Integer pageSize;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }


    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
