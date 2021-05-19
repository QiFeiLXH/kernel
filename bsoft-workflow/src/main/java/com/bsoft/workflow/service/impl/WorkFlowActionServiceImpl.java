package com.bsoft.workflow.service.impl;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.workflow.manager.WorkFlowActionManager;
import com.bsoft.workflow.service.WorkFlowActionService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: zy
 * @date: 2020/10/16
 * @description 流程操作
 */
@Service
public class WorkFlowActionServiceImpl implements WorkFlowActionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkFlowActionServiceImpl.class);

    @Autowired
    private WorkFlowActionManager workFlowActionManager;

    @Override
    public void stop(String userId, String processInstanceId, String reason) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        workFlowActionManager.stop(processInstanceId, reason);
        Long time = timeConsumer.end();
        LOGGER.info("工号[{}]终止流程[{}]耗时[{}]", userId, processInstanceId, time);
    }

    @Override
    public void setTaskLocalVar(String taskId, String key, Object value) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        workFlowActionManager.setTaskLocalVar(taskId,key,value);
        Long time = timeConsumer.end();
        LOGGER.info("设置任务id为{}的本地变量key:{},value:{}，耗时[{}]", taskId,key,value, time);
    }

    @Override
    public void setTaskLocalVarWithProId(String processInstanceId, String key, Object value) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        workFlowActionManager.setTaskLocalVarWithProId(processInstanceId,key,value);
        Long time = timeConsumer.end();
        LOGGER.info("设置流程实例ID为{}的所有待办任务本地变量key:{},value:{}，耗时[{}]", processInstanceId,key,value, time);
    }

    @Override
    public void completeNotifyTask(String userId, String taskId) {
        workFlowActionManager.completeNotifyTask(taskId);
        LOGGER.info("[{}]完成知会任务，任务ID[{}]", userId, taskId);
    }


}
