package com.bsoft.logs.message;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.logs.dto.RequestLogDTO;
import com.bsoft.logs.entity.primary.RequestLogDO;
import com.bsoft.logs.manager.RequestLogManager;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: zy
 * @date: 2020/10/26
 * @description
 */
@Component
@RocketMQMessageListener(topic = "requestLog", consumerGroup = "requestLog")
public class RequestLogMessageProcessor implements RocketMQListener<RequestLogDTO> {
    @Autowired
    private RequestLogManager requestLogManager;

    @Override
    public void onMessage(RequestLogDTO requestLogDTO) {
        RequestLogDO requestLogDO = GeneratorUtil.instance().convert(requestLogDTO, RequestLogDO.class);
        requestLogManager.save(requestLogDO);
    }

}
