package com.bsoft.email.manager.impl;

import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.spring.SpringContextUtil;
import com.bsoft.email.manager.EmailSenderMoreManager;
import com.bsoft.message.bean.EmailMessageBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class EmailSenderMoreManagerImpl implements EmailSenderMoreManager {

    private static Logger logger = LoggerFactory.getLogger(EmailSenderMoreManagerImpl.class);
    private static final String DEFAULT_EMAIL_FROM = "eoffice@bsoft.com.cn";
//    private static final String DEFAULT_EMAIL_BCC = "eoffice@bsoft.com.cn";

    private JavaMailSenderImpl javaMailSender;
    private MimeMessage mimeMessage;
    private MimeMessageHelper mimeMessageHelper;
    private ServerDateManager serverDateManager;

    public EmailSenderMoreManagerImpl(EmailMessageBean emailMessageBean){
        javaMailSender = getJavaMailSender(emailMessageBean);
        serverDateManager = SpringContextUtil.getBean(ServerDateManager.class);
        mimeMessage = javaMailSender.createMimeMessage();
        mimeMessageHelper = new MimeMessageHelper(mimeMessage);
    }

    private synchronized JavaMailSenderImpl getJavaMailSender(EmailMessageBean emailMessageBean){
          String host = "mail.bsoft.com.cn";
          String userName = emailMessageBean.getFrom();
          String passWord = emailMessageBean.getPassWord();
          Integer port = 587;
          JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
          javaMailSenderImpl.setHost(host);
          javaMailSenderImpl.setPort(port);
          javaMailSenderImpl.setUsername(userName);
          javaMailSenderImpl.setPassword(passWord);
          javaMailSenderImpl.setDefaultEncoding("UTF-8");
          Properties properties = new Properties();
          properties.setProperty("mail.debug", "false");
          properties.setProperty("mail.smtp.auth", "false");
          properties.setProperty("mail.smtp.starttls.enable", "false");
          properties.setProperty("mail.smtp.starttls.required", "false");
          properties.setProperty("mail.smtp.socketFactoryClass", "javax.net.ssl.SSLSocketFactory");
          javaMailSenderImpl.setJavaMailProperties(properties);
          return javaMailSenderImpl;
    }

    @Override
    public void sendEmail(EmailMessageBean emailMessageBean) throws MessagingException{
        logger.info("简单邮件开始发送");
//            JavaMailSenderImpl javaMailSender = getJavaMailSender(emailMessageBean);
        String userName = javaMailSender.getUsername();
        if(StringUtils.isBlank(userName)){
            mimeMessageHelper.setFrom(DEFAULT_EMAIL_FROM);
        }else{
            mimeMessageHelper.setFrom(userName);
        }
        logger.info("当前发送邮箱:" + userName);

        List<String> to = emailMessageBean.getTo();
        to.removeAll(Collections.singleton(null)); //去除null元素
        if(to.isEmpty()) throw new MessagingException("无收件人，无法发送");
        mimeMessageHelper.setTo(to.stream().toArray(String[]::new));

        List<String> cc = emailMessageBean.getCc();
        cc.removeAll(Collections.singleton(null)); //去除null元素
        if(!cc.isEmpty()){
            mimeMessageHelper.setCc(cc.stream().toArray(String[]::new));
        }

        mimeMessageHelper.setSubject(emailMessageBean.getSubject());

        logger.info("发送时间：{}",serverDateManager.getServerDateTime());
        String now = DateFormatUtils.format(serverDateManager.getServerDateTime(), "yyyy/MM/dd HH:mm:ss");
        String endText = "</br>" +
                "</br>" +
                "<div style=\"text-align: right\">"+now+"</div>" +
                "<hr style=\"border:1px double #e8e8e8\"/>" +
                "此为企业信息门户系统邮件。请勿回复，谢谢！";
        mimeMessageHelper.setText(emailMessageBean.getText()+endText,true);

        javaMailSender.send(mimeMessage);
    }
}
