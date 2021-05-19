package com.bsoft.logs.message;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.logs.dto.LoginLogDTO;
import com.bsoft.logs.entity.primary.LoginLogDO;
import com.bsoft.logs.manager.LoginLogManager;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "loginlog",consumerGroup = "loginlog")
public class LoginLogMessageProcessor implements RocketMQListener<LoginLogDTO> {

    private static final Logger logger = LoggerFactory.getLogger(LoginLogMessageProcessor.class);

    @Autowired
    private LoginLogManager loginLogManager;

    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public void onMessage(LoginLogDTO loginLogDTO) {
        LoginLogDO loginLogDO = generatorUtil.convert(loginLogDTO,LoginLogDO.class);
        loginLogManager.save(loginLogDO);
        logger.info("保存登录日志成功！");
    }
}
