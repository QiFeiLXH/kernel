package com.bsoft.message.manager.impl;

import com.bsoft.common.json.GsonUtils;
import com.bsoft.message.bean.EmailMessageBean;
import com.bsoft.message.manager.EmailMessageSenderManager;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailMessageSenderManagerImpl implements EmailMessageSenderManager {
    private final static Logger logger = LoggerFactory.getLogger(MessageSenderManagerImpl.class);
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @Override
    public void sendEmailMessage(EmailMessageBean emailMessageBean) {
        logger.info("发送邮件到消息队列，邮件内容为：{}", GsonUtils.gsonString(emailMessageBean));
        rocketMQTemplate.convertAndSend("emailMessage",emailMessageBean);
    }
}
