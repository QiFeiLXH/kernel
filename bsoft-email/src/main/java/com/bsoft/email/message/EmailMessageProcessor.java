package com.bsoft.email.message;

import com.bsoft.email.manager.EmailSenderManager;
import com.bsoft.email.manager.impl.EmailSenderManagerImpl;
import com.bsoft.message.bean.EmailMessageBean;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

/**
 * @Author zhanglf
 * @Date 2020-03-10 9:59
 * @Version 1.0
 * @Description
 */
@Component
@RocketMQMessageListener(topic = "emailMessage",consumerGroup = "emailMessage")
public class EmailMessageProcessor implements RocketMQListener<EmailMessageBean> {
    private static final Logger logger = LoggerFactory.getLogger(EmailMessageProcessor.class);
    @Value("${mail.bcc}")
    private Boolean sendBccFlag;

    @Override
    public void onMessage(EmailMessageBean emailMessageBean) {
        try {
            emailMessageBean.setSencBccFlag(sendBccFlag);
            EmailSenderManager emailSenderManager = new EmailSenderManagerImpl(emailMessageBean);
            emailSenderManager.send();
        } catch (MessagingException e) {
            logger.error("发送邮件失败，原因：{}" + e.getMessage());
        }
    }
}
