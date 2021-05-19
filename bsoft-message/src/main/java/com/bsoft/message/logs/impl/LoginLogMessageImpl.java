package com.bsoft.message.logs.impl;

import com.bsoft.logs.dto.LoginLogDTO;
import com.bsoft.message.logs.LoginLogMessage;
import org.apache.dubbo.config.annotation.Service;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LoginLogMessageImpl implements LoginLogMessage {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void send(LoginLogDTO loginLogDTO) {
        rocketMQTemplate.convertAndSend("loginlog",loginLogDTO);
    }
}
