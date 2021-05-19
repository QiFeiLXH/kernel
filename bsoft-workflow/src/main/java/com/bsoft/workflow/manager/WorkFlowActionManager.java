package com.bsoft.workflow.manager;

import com.bsoft.workflow.entity.primary.TaskAuditDO;

import java.util.HashMap;
import java.util.Map;

public interface WorkFlowActionManager {
    /**
     * 发起流程并完成第一个申请人环节
     * @param personId 发起人工号
     * @param personName 发起人姓名
     * @param dept 发起人部门
     * @param title 发起标题
     * @param processKey 发起流程的key
     * @param id 发起流程的对应业务表id
     * @param map 每个不同的业务流程定制化变量
     * @return
     */
    String startAndComplete(String personId,String personName,String dept,String title,String processKey,Integer id, Map<String, Object> map);

    /**
     * 终止流程
     * @param processInstanceId 流程定义ID
     * @param reason 终止原因
     */
    void stop(String processInstanceId, String reason);

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
     * 完成任务
     * @param map
     */
    void complete(String taskId,Map<String, Object> map);

    /**
     * 获取流程的申请ID（申请ID格式：流程标题英文缩写+年月6位+流水号3位，例如LCR202012001表示2020年12月第1条劳动合同续签申请）
     * @param processKey 流程定义KEY
     * @param size 获取ID的范围
     * @return 最近使用过的ID值（返回值的当前值不可用作申请ID的值）
     */
    Integer getApplyIdCurrentVal(String processKey, Integer size);

    /**
     * 完成知会任务
     * @param taskId 任务ID
     */
    void completeNotifyTask(String taskId);
}
