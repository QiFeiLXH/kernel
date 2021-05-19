package com.bsoft.email.manager;

import com.bsoft.message.bean.EmailMessageBean;

import javax.mail.MessagingException;

public interface EmailSenderBaseManager {
    void sendEmail(EmailMessageBean emailMessageBean) throws MessagingException;
}
