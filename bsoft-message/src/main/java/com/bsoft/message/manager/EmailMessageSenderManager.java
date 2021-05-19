package com.bsoft.message.manager;

import com.bsoft.message.bean.EmailMessageBean;

public interface EmailMessageSenderManager {
    void sendEmailMessage(EmailMessageBean emailMessageBean);
}
