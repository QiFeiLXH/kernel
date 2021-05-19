package com.bsoft.workflow.manager;

import com.bsoft.common.result.Result;
import com.bsoft.workflow.common.result.WFResult;
import com.bsoft.workflow.condition.TaskQueryCnd;
import com.bsoft.workflow.dto.WFTaskDTO;
import com.bsoft.workflow.dto.WFTaskQueryCndDTO;
import com.bsoft.workflow.entity.primary.TaskDO;

import java.util.List;

public interface WorkFlowHisQueryManager {
    /**
     * 获取已经完成的历史流程实例
     * @return
     */
    Result<TaskDO> getFinishedProcess(TaskQueryCnd queryCnd);

    /**
     * 获取已经完成的历史任务实例
     * @param queryCnd
     * @return
     */
    Result<TaskDO> getFinishedTask(TaskQueryCnd queryCnd);

    /**
     * 获取已经完成的历史任务实例
     * @param queryCnd
     * @return
     */
    List<TaskDO> getFinishedTaskList(TaskQueryCnd queryCnd);
}
