package com.bsoft.workflow.manager;

import com.bsoft.common.result.Result;
import com.bsoft.workflow.condition.TaskQueryCnd;
import com.bsoft.workflow.entity.primary.*;

import java.util.List;

public interface WorkFlowQueryManager {
    /**
     * 根据流程实例ID获取流程流转信息
     * @param processInstanceId
     * @return
     */
    BpmnModelDO getBpmnModelMessage(String processInstanceId);

    /**
     * 根据条件获取流程待办任务
     * @param data
     * @return
     */
    Result<TaskDO> getTaskList(TaskQueryCnd data);

    /**
     * 根据条件获取流程待办任务不分页
     * @param data
     * @return
     */
    List<TaskDO> getTaskListWithoutPage(TaskQueryCnd data);

    /**
     * 根据条件获取流程待办任务（包含知会）
     * @param data
     * @return
     */
    Result<TaskDO> getTaskListWithNotify(TaskQueryCnd data);

    /**
     * 获取流程代办任务数量统计
     * @return
     */
    List<ProcessTaskCountDO> getProcessTaskCount();


    /**
     * 获取自定义节点属性
     * @param taskId 任务ID
     * @return
     */
    List<CustomerParamDO> getCustomParam(String taskId);


    /**
     * 根据条件获取知会任务
     */
    Result<TaskDO> getNotifyTaskList(TaskQueryCnd data);
}
