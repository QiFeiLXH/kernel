package com.bsoft.workflow.service;

/**
 * @author: zy
 * @date: 2020/10/14
 * @description 流程操作
 */
public interface WorkFlowActionService {
    /**
     * 终止流程
     * @param userId 操作用户
     * @param processInstanceId 流程实例ID
     * @param reason 终止理由
     */
    void stop(String userId, String processInstanceId, String reason);

    /**
     * 设置流程任务专属本地变量
     * @param key
     * @param value
     */
    void setTaskLocalVar(String taskId, String key, Object value);

    /**
     * 设置对应流程所有待办任务的本地变量
     * @param key
     * @param value
     */
    void setTaskLocalVarWithProId(String processInstanceId, String key, Object value);

    /**
     * 完成知会任务
     * @param userId 操作员工
     * @param taskId 任务ID
     */
    void completeNotifyTask(String userId, String taskId);
}
