package com.bsoft.email.manager;

import com.bsoft.email.bean.EmailSenderBean;

import javax.mail.MessagingException;

public interface BaseEmailSenderManager {
    void sendEmail(EmailSenderBean emailSenderBean);
}
