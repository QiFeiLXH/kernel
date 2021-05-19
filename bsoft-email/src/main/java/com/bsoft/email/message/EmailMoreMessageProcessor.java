package com.bsoft.email.message;

import com.bsoft.email.manager.impl.EmailSenderMoreManagerImpl;
import com.bsoft.message.bean.EmailMessageBean;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
@RocketMQMessageListener(topic = "emailMoreMessage",consumerGroup = "emailMoreMessage")
public class EmailMoreMessageProcessor  implements RocketMQListener<EmailMessageBean> {
    private static final Logger logger = LoggerFactory.getLogger(EmailMoreMessageProcessor.class);
    @Override
    public void onMessage(EmailMessageBean emailMessageBean) {
        EmailSenderMoreManagerImpl emailSenderMoreManager = new EmailSenderMoreManagerImpl(emailMessageBean);
        if(emailMessageBean.getPassWord().equals("")) return;
        try {
            emailSenderMoreManager.sendEmail(emailMessageBean);
        } catch (MessagingException e) {
            logger.error("发送邮件失败，原因：{}" + e.getMessage());
        }
    }
}
