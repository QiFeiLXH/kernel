package com.bsoft.message.manager.impl;

import com.bsoft.common.json.GsonUtils;
import com.bsoft.message.bean.EmailMessageBean;
import com.bsoft.message.manager.MessageSenderManager;
import com.bsoft.project.dto.ProjectGroupDTO;
import com.bsoft.project.dto.ProjectGroupDetailDTO;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author zhanglf
 * @Date 2020-03-10 9:30
 * @Version 1.0
 * @Description
 */
@Component
public class MessageSenderManagerImpl implements MessageSenderManager {
    private final static Logger logger = LoggerFactory.getLogger(MessageSenderManagerImpl.class);
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @Override
    public void sendEmailMessage(EmailMessageBean emailMessageBean) {
        logger.info("发送邮件到消息队列，邮件内容为：{}", GsonUtils.gsonString(emailMessageBean));
        rocketMQTemplate.convertAndSend("emailMessage",emailMessageBean);
    }

    @Override
    public void sendProjectLogUpdate(String contractno) {
        rocketMQTemplate.convertAndSend("updateProjectLog",contractno);
    }

    @Override
    public void senEmailMoreMessage(EmailMessageBean emailMessageBean) {
        logger.info("发送邮件到消息队列，邮件内容为：{}", GsonUtils.gsonString(emailMessageBean));
        rocketMQTemplate.convertAndSend("emailMoreMessage",emailMessageBean);
    }

    @Override
    public void sendHREmailMessage(EmailMessageBean emailMessageBean) {
        logger.info("发送HR邮件到消息队列，邮件内容为：{}", GsonUtils.gsonString(emailMessageBean));
        rocketMQTemplate.convertAndSend("hrEmailMessage",emailMessageBean);
    }
}
