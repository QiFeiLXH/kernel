package com.bsoft.email.manager.impl;

import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.spring.SpringContextUtil;
import com.bsoft.email.entity.primary.TimeTaskEmailDO;
import com.bsoft.email.manager.EmailSenderManager;
import com.bsoft.email.repository.primary.EmailSenderRepository;
import com.bsoft.email.util.LocalThreadScopeDataUtil;
import com.bsoft.message.bean.EmailBasePic;
import com.bsoft.message.bean.EmailMessageBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.quartz.JobDataMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class EmailSenderManagerImpl implements EmailSenderManager {
    private static final Logger logger = LoggerFactory.getLogger(EmailSenderManagerImpl.class);
    private static final String DEFAULT_EMAIL_FROM = "eoffice@bsoft.com.cn";
    private static final String DEFAULT_EMAIL_BCC = "eoffice@bsoft.com.cn";
    private JavaMailSender javaMailSender;
    private MimeMessage mimeMessage;
    private MimeMessageHelper mimeMessageHelper;
    private ServerDateManager serverDateManager;
    @Autowired
    private EmailSenderRepository emailSenderRepository;

    public EmailSenderManagerImpl(EmailMessageBean emailMessageBean) throws MessagingException{
        javaMailSender = getJavaMailSender(emailMessageBean);
        serverDateManager = SpringContextUtil.getBean(ServerDateManager.class);
        mimeMessage = javaMailSender.createMimeMessage();
        mimeMessageHelper = new MimeMessageHelper(mimeMessage,true,"utf-8");
        setSubject(emailMessageBean); //设置主题
        setFrom(emailMessageBean); //设置发送人
        setTo(emailMessageBean); //设置接收人
        setCc(emailMessageBean); //设置抄送人
        setText(emailMessageBean); //设置邮件内容
        if(emailMessageBean.isSencBccFlag()){
          setDefaultBcc(); //设置默认密送人
        }
    }


    @Override
    public void send() {
        javaMailSender.send(mimeMessage);
    }

    private void setSubject(EmailMessageBean emailMessageBean) throws MessagingException {
        mimeMessageHelper.setSubject(emailMessageBean.getSubject());
    }

    private void setFrom(EmailMessageBean emailMessageBean) throws MessagingException {
        String from = emailMessageBean.getFrom();
        if(StringUtils.isBlank(from)){
            mimeMessageHelper.setFrom(DEFAULT_EMAIL_FROM);
        }else{
            mimeMessageHelper.setFrom(from);
        }
    }

    private void setTo(EmailMessageBean emailMessageBean) throws MessagingException {
        List<String> to = emailMessageBean.getTo();
        to.removeAll(Collections.singleton(null)); //去除null元素
        if(to.isEmpty()) throw new MessagingException("无收件人，无法发送");
        mimeMessageHelper.setTo(to.stream().toArray(String[]::new));
    }

    private void setCc(EmailMessageBean emailMessageBean) throws MessagingException {
        List<String> cc = emailMessageBean.getCc();
        cc.removeAll(Collections.singleton(null)); //去除null元素
        if(!cc.isEmpty()){
            mimeMessageHelper.setCc(cc.stream().toArray(String[]::new));
        }
    }

    private void setText(EmailMessageBean emailMessageBean) throws MessagingException {
        logger.info("发送时间：{}",serverDateManager.getServerDateTime());
        String now = DateFormatUtils.format(serverDateManager.getServerDateTime(), "yyyy/MM/dd HH:mm:ss");
        String text = emailMessageBean.getText();
        if (emailMessageBean.isHasEnd()){
            text = text + "</br>" +
                    "</br>" +
                    "<div style=\"text-align: right\">"+now+"</div>" +
                    "<hr style=\"border:1px double #e8e8e8\"/>" +
                    "此为企业信息门户系统邮件。请勿回复，谢谢！";
        }
        mimeMessageHelper.setText(text,true);
        if(emailMessageBean.getPics() != null){
            for (EmailBasePic emailBasePic : emailMessageBean.getPics()) {
                mimeMessageHelper.addInline(emailBasePic.getContentId(), new ByteArrayResource(emailBasePic.getByteArray()),emailBasePic.getContentType());
            }
        }

    }

    private void setDefaultBcc() throws MessagingException {
        mimeMessageHelper.setBcc(DEFAULT_EMAIL_BCC);
    }

    private synchronized JavaMailSenderImpl getJavaMailSender(EmailMessageBean emailMessageBean){
        String host = "mail.bsoft.com.cn";
        String userName = emailMessageBean.getFrom();
        String passWord = emailMessageBean.getPassWord();
        Integer port = 25;
        if (emailMessageBean.isNeedPassWord()){
            port = 587;
        }
        JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
        javaMailSenderImpl.setHost(host);
        javaMailSenderImpl.setPort(port);
        javaMailSenderImpl.setUsername(userName);
        if (emailMessageBean.isNeedPassWord()){
            javaMailSenderImpl.setPassword(passWord);
        }
        javaMailSenderImpl.setDefaultEncoding("UTF-8");
        Properties properties = new Properties();
        if (emailMessageBean.isNeedPassWord()){
            properties.setProperty("mail.debug", "false");
            properties.setProperty("mail.smtp.auth", "false");
            properties.setProperty("mail.smtp.starttls.enable", "false");
            properties.setProperty("mail.smtp.starttls.required", "false");
            properties.setProperty("mail.smtp.socketFactoryClass", "javax.net.ssl.SSLSocketFactory");
        }
        javaMailSenderImpl.setJavaMailProperties(properties);
        return javaMailSenderImpl;
    }
}
