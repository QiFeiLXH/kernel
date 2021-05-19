package com.bsoft.workflow.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.workflow.condition.TaskQueryCnd;
import com.bsoft.workflow.dto.*;
import com.bsoft.workflow.entity.primary.BpmnModelDO;
import com.bsoft.workflow.entity.primary.CustomerParamDO;
import com.bsoft.workflow.entity.primary.ProcessTaskCountDO;
import com.bsoft.workflow.entity.primary.TaskDO;
import com.bsoft.workflow.manager.WorkFlowHisQueryManager;
import com.bsoft.workflow.manager.WorkFlowQueryManager;
import com.bsoft.workflow.service.WorkFlowQueryService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class WorkFlowQueryServiceImpl implements WorkFlowQueryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkFlowQueryServiceImpl.class);
    @Autowired
    private WorkFlowQueryManager workFlowQueryManager;
    @Autowired
    private WorkFlowHisQueryManager workFlowHisQueryManager;
    @Override
    public BpmnModelDTO getBpmnModelMessage(String processInstanceId, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        BpmnModelDO bpmnModelDO = workFlowQueryManager.getBpmnModelMessage(processInstanceId);
        long times = timeConsumer.end();
        LOGGER.info("工号：{}，获取流程实例ID为{}的流程图信息成功，耗时：{}",new Object[]{personId,processInstanceId,times});
        return GeneratorUtil.instance().convert(bpmnModelDO,BpmnModelDTO.class);
    }

    @Override
    public Result<TaskDTO> getTaskList(String personId, TaskQueryCndDTO data) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        TaskQueryCnd queryCnd = GeneratorUtil.instance().convert(data, TaskQueryCnd.class);
        Result<TaskDO> result;
        if(data.getFinished() != null && data.getFinished()){
            result = workFlowHisQueryManager.getFinishedProcess(queryCnd);
        }else{
            result = workFlowQueryManager.getTaskList(queryCnd);
        }
        long times = timeConsumer.end();
        LOGGER.info("工号：{}，获取流程待办信息(不含知会)，耗时：{}",new Object[]{personId,times});
        return GeneratorUtil.instance().convert(result, TaskDTO.class);
    }

    @Override
    public Result<TaskDTO> getTaskListWithNotify(String personId, TaskQueryCndDTO data) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        TaskQueryCnd queryCnd = GeneratorUtil.instance().convert(data, TaskQueryCnd.class);
        Result<TaskDO> result;
        if(data.getFinished() != null && data.getFinished()){
            result = workFlowHisQueryManager.getFinishedProcess(queryCnd);
        }else{
            result = workFlowQueryManager.getTaskListWithNotify(queryCnd);
        }
        long times = timeConsumer.end();
        LOGGER.info("工号：{}，获取流程待办信息(含知会)，耗时：{}",new Object[]{personId,times});
        return GeneratorUtil.instance().convert(result, TaskDTO.class);
    }

    @Override
    public List<ProcessTaskCountDTO> getProcessTaskCount(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProcessTaskCountDO> resultDO = workFlowQueryManager.getProcessTaskCount();
        long times = timeConsumer.end();
        LOGGER.info("工号：{}，获取流程待办任务数量统计，耗时：{}", new Object[]{personId, times});
        return GeneratorUtil.instance().convert(resultDO, ProcessTaskCountDTO.class);
    }

    @Override
    public List<CustomerParamDTO> getCustomParam(String personId, String taskId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<CustomerParamDO> paramDOS = workFlowQueryManager.getCustomParam(taskId);
        long times = timeConsumer.end();
        LOGGER.info("工号：{}，获取任务ID为{}的表单权限，耗时：{}", new Object[]{personId,taskId, times});
        return GeneratorUtil.instance().convert(paramDOS,CustomerParamDTO.class);
    }

    @Override
    public Result<TaskDTO> getNotifyTaskList(String personId, TaskQueryCndDTO data) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        TaskQueryCnd queryCnd = GeneratorUtil.instance().convert(data, TaskQueryCnd.class);
        Result<TaskDO> result = workFlowQueryManager.getNotifyTaskList(queryCnd);
        long times = timeConsumer.end();
        LOGGER.info("工号：{}，获取流程知会任务，耗时：{}", new Object[]{personId, times});
        return GeneratorUtil.instance().convert(result,TaskDTO.class);
    }


}
