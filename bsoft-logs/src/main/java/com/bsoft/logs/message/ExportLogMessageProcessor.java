package com.bsoft.logs.message;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.logs.dto.ExportLogDTO;
import com.bsoft.logs.entity.primary.ExportLogDO;
import com.bsoft.logs.manager.ExportLogManager;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/15 11:22
 * @Description
 */
@Component
@RocketMQMessageListener(topic = "exportLog", consumerGroup = "exportLog")
public class ExportLogMessageProcessor implements RocketMQListener<ExportLogDTO> {
    private static final Logger logger = LoggerFactory.getLogger(ExportLogMessageProcessor.class);
    @Autowired
    private ExportLogManager exportLogManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public void onMessage(ExportLogDTO exportLogDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ExportLogDO exportLogDO = iGenerator.convert(exportLogDTO, ExportLogDO.class);
        exportLogManager.saveExportLog(exportLogDO);
        long times = timeConsumer.end();
        logger.info("系统:{}，工号:{},菜单id:{},保存系统导出日志耗时:{}",exportLogDTO.getSystem(),exportLogDTO.getPersonId(),exportLogDTO.getMenuId(),times);
    }
}
