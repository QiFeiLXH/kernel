package com.bsoft.message.logs.impl;

import com.bsoft.logs.dto.UsageLogDTO;
import com.bsoft.message.logs.UsageLogsMessage;
import org.apache.dubbo.config.annotation.Service;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UsageLogsMessageImpl implements UsageLogsMessage {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @Override
    public void send(UsageLogDTO usageLogs) {
        rocketMQTemplate.convertAndSend("usagelog",usageLogs);
    }
}
