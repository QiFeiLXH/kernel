package com.bsoft.workflow.service;

import com.bsoft.common.result.Result;
import com.bsoft.workflow.dto.*;

import java.util.List;

public interface WorkFlowQueryService {
    /**
     * 根据流程实例ID获取流程流转信息
     * @param processInstanceId
     * @return
     */
    BpmnModelDTO getBpmnModelMessage(String processInstanceId, String personId);

    /**
     * 根据条件获取流程待办任务
     * @param data
     * @return
     */
    Result<TaskDTO> getTaskList(String personId, TaskQueryCndDTO data);

    /**
     * 根据条件获取流程待办任务(包含知会)
     * @param data
     * @return
     */
    Result<TaskDTO> getTaskListWithNotify(String personId, TaskQueryCndDTO data);

    /**
     * 获取流程待办任务数量统计
     * @param personId
     * @return
     */
    List<ProcessTaskCountDTO> getProcessTaskCount(String personId);

    /**
     * 获取自定义节点属性
     * @param taskId 任务ID
     * @return
     */
    List<CustomerParamDTO> getCustomParam(String personId, String taskId);


    /**
     * 根据条件获取知会任务
     */
    Result<TaskDTO> getNotifyTaskList(String personId, TaskQueryCndDTO data);

}
