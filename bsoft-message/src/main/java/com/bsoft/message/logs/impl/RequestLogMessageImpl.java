package com.bsoft.message.logs.impl;

import com.bsoft.logs.dto.RequestLogDTO;
import com.bsoft.message.logs.RequestLogMessage;
import org.apache.dubbo.config.annotation.Service;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: zy
 * @date: 2020/10/26
 * @description
 */
@Service
public class RequestLogMessageImpl implements RequestLogMessage {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void send(RequestLogDTO requestLogDTO) {
        rocketMQTemplate.convertAndSend("requestLog", requestLogDTO);
    }
}
