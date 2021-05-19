package com.bsoft.workflow.service.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.json.FastJsonUtils;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.workflow.dto.ActionRecordDTO;
import com.bsoft.workflow.entity.primary.ActionRecordDO;
import com.bsoft.workflow.manager.ActionRecordManager;
import com.bsoft.workflow.service.ActionRecordService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 操作记录service
 */
@Service
public class ActionRecordServiceImpl implements ActionRecordService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActionRecordServiceImpl.class);
    @Autowired
    private ActionRecordManager actionRecordManager;
    @Override
    public List<ActionRecordDTO> getActionRecords(String personId,String processInstanceId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ActionRecordDO> actionRecordDOS = actionRecordManager.getActionRecords(processInstanceId);
        long times  = timeConsumer.end();
        LOGGER.info("工号：{}获取流程实例ID为{}的流程操作信息成功,耗时：{},数据：{}",new Object[]{personId,processInstanceId,times, FastJsonUtils.getBeanToJson(actionRecordDOS)});
        return GeneratorUtil.instance().convert(actionRecordDOS,ActionRecordDTO.class);
    }

    @Override
    public List<ActionRecordDTO> getActionRecordsWithNext(String personId, String processInstanceId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ActionRecordDO> actionRecordDOS = actionRecordManager.getActionRecordsWithNext(processInstanceId);
        long times  = timeConsumer.end();
        LOGGER.info("工号：{}获取流程实例ID为{}的流程操作信息成功,耗时：{},数据：{}",new Object[]{personId,processInstanceId,times, FastJsonUtils.getBeanToJson(actionRecordDOS)});
        return GeneratorUtil.instance().convert(actionRecordDOS,ActionRecordDTO.class);
    }
}
