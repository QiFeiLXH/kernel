package com.bsoft.email.manager.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.spring.SpringContextUtil;
import com.bsoft.email.bean.EmailSenderBean;
import com.bsoft.email.entity.primary.TimeTaskEmailDO;
import com.bsoft.email.manager.BaseEmailSenderManager;
import com.bsoft.email.manager.EmailSenderManager;
import com.bsoft.email.repository.primary.EmailSenderRepository;
import com.bsoft.email.util.LocalThreadScopeDataUtil;
import com.bsoft.message.bean.EmailMessageBean;
import com.bsoft.message.manager.EmailMessageSenderManager;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseEmailSenderManagerImpl implements BaseEmailSenderManager {
    private String username;
    private String password;
    private IGenerator generator = SpringContextUtil.getBean(IGenerator.class);
    private EmailMessageSenderManager emailMessageSenderManager = SpringContextUtil.getBean(EmailMessageSenderManager.class);
    private EmailSenderRepository emailSenderRepository = SpringContextUtil.getBean(EmailSenderRepository.class);

    public BaseEmailSenderManagerImpl(String username,String password){
        this.username = username;
        this.password = password;
    }
    @Override
    public void sendEmail(EmailSenderBean emailSenderBean){
        EmailMessageBean emailMessageBean = generator.convert(emailSenderBean,EmailMessageBean.class);
        emailMessageBean.setPassWord(password);
        emailMessageBean.setFrom(username);
        //获取监听器里的接收人，查询出抄送人邮箱
        LocalThreadScopeDataUtil localThreadScopeDataUtil = LocalThreadScopeDataUtil.getInstance();
        JobDataMap jobDataMap = localThreadScopeDataUtil.getJobDataMap();
        String ccString = null;
        String toString = null;
        if(jobDataMap!=null){
             ccString = jobDataMap.getString("cc");
             toString = jobDataMap.getString("to");
        }
        List<String> cc = new ArrayList<>();
        if(ccString!=null&&ccString.length()>0){
            String[] split = ccString.split(",");
            for (String s : split) {
                String emailSenderRepositoryById = emailSenderRepository.findById(s);
                if(emailSenderRepositoryById!=null){
                    cc.add(emailSenderRepositoryById);
                }
            }
        }
        cc.removeAll(Collections.singleton(null)); //去除null元素
        emailMessageBean.getCc().addAll(cc);

        //获取监听器里的接收人，查询出接收人邮箱
        List<String> to = new ArrayList<>();
        if(toString!=null&&toString.length()>0){
            String[] split = toString.split(",");
            for (String s : split) {
                String emailSenderRepositoryById = emailSenderRepository.findById(s);
                if(emailSenderRepositoryById!=null){
                    to.add(emailSenderRepositoryById);
                }
            }
        }
        to.removeAll(Collections.singleton(null)); //去除null元素
        emailMessageBean.getTo().addAll(to);

        emailMessageSenderManager.sendEmailMessage(emailMessageBean);
    }

}
