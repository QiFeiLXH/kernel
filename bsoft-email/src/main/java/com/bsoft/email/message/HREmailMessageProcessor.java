package com.bsoft.email.message;

import com.bsoft.email.manager.impl.EmailSenderBaseManagerImpl;
import com.bsoft.message.bean.EmailMessageBean;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
@RocketMQMessageListener(topic = "hrEmailMessage",consumerGroup = "hrEmailMessage")
public class HREmailMessageProcessor implements RocketMQListener<EmailMessageBean> {

    private static Logger logger = LoggerFactory.getLogger(HREmailMessageProcessor.class);

    private static final String FROMEMAIL = "hr@bsoft.com.cn";
    private static final String PASSWORD = "wpro7G1";

    @Override
    public void onMessage(EmailMessageBean emailMessageBean) {
        EmailSenderBaseManagerImpl emailSenderBaseManager = new EmailSenderBaseManagerImpl(FROMEMAIL,PASSWORD);
        try {
            emailSenderBaseManager.sendEmail(emailMessageBean);
        } catch (MessagingException e) {
            logger.error("HR邮件发送失败，原因：{}" + e.getMessage());
        }
    }
}
