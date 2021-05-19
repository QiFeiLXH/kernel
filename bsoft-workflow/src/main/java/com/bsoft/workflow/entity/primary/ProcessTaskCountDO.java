package com.bsoft.workflow.entity.primary;

import java.util.Date;

/**
 * @author: zy
 * @date: 2020/9/25
 * @description 流程待办任务统计
 */
public class ProcessTaskCountDO {
    /* 主键 */
    private Integer id;
    /* 流程定义KEY */
    private String key;
    /* 流程定义名称 */
    private String name;
    /* 待办任务数 */
    private Integer taskCount;
    /* 流程类别 */
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(Integer taskCount) {
        this.taskCount = taskCount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
