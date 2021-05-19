package com.bsoft.logs.message;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.logs.dto.UsageLogDTO;
import com.bsoft.logs.entity.primary.UsageLogDO;
import com.bsoft.logs.manager.UsageLogManager;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "usagelog",consumerGroup = "bsoft-kernel")
public class UsageLogMessageProcessor implements RocketMQListener<UsageLogDTO> {
    private static final Logger logger = LoggerFactory.getLogger(UsageLogMessageProcessor.class);

    @Autowired
    private UsageLogManager usageLogManager;

    @Autowired
    private GeneratorUtil generatorUtil;



    @Override
    public void onMessage(UsageLogDTO usageLog) {
        UsageLogDO usageLogDO = generatorUtil.convert(usageLog, UsageLogDO.class);
        usageLogManager.save(usageLogDO);
    }
}
