package com.bsoft.email.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.email.bean.EmailSenderBean;
import com.bsoft.email.dto.EmailSenderBeanDTO;
import com.bsoft.email.sender.EmailSender;
import com.bsoft.email.service.EmailSenderService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {
    @Autowired
    private IGenerator generator;
    @Override
    public void sendEmailFromEoffice(EmailSenderBeanDTO emailSenderBeanDTO) {
        EmailSenderBean emailSenderBean = generator.convert(emailSenderBeanDTO, EmailSenderBean.class);
        EmailSender.getEofficeEmailSender().sendEmail(emailSenderBean);
    }

    @Override
    public void sendEmailsFromEoffice(List<EmailSenderBeanDTO> emailSenderBeanDTOS) {
        List<EmailSenderBean> emailSenderBeans = generator.convert(emailSenderBeanDTOS, EmailSenderBean.class);
        emailSenderBeans.forEach(emailSenderBean -> {
            EmailSender.getEofficeEmailSender().sendEmail(emailSenderBean);
        });
    }
}
