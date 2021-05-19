package com.bsoft.email.service;

import com.bsoft.email.dto.EmailSenderBeanDTO;

import java.util.List;

public interface EmailSenderService {
    void sendEmailFromEoffice(EmailSenderBeanDTO emailSenderBeanDTO);

    void sendEmailsFromEoffice(List<EmailSenderBeanDTO> emailSenderBeanDTO);

}
