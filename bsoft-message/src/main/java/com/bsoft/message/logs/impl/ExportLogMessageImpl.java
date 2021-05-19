package com.bsoft.message.logs.impl;

import com.bsoft.logs.dto.ExportLogDTO;
import com.bsoft.message.logs.ExportLogMessage;
import org.apache.dubbo.config.annotation.Service;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/15 11:20
 * @Description
 */
@Service
public class ExportLogMessageImpl implements ExportLogMessage {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void send(ExportLogDTO exportLog) {
        rocketMQTemplate.convertAndSend("exportLog",exportLog);
    }
}
