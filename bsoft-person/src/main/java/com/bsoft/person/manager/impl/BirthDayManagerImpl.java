package com.bsoft.person.manager.impl;

import com.bsoft.email.bean.EmailSenderBean;
import com.bsoft.email.sender.EmailSender;
import com.bsoft.person.dao.primary.BirthDayDao;
import com.bsoft.person.dao.primary.BirthEmailDao;
import com.bsoft.person.entity.primary.BirthDayDO;
import com.bsoft.person.entity.primary.BirthEmailDO;
import com.bsoft.person.manager.BirthDayManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BirthDayManagerImpl implements BirthDayManager {

    @Autowired
    private BirthDayDao birthDayDao;
    @Autowired
    private BirthEmailDao birthEmailDao;

    private static final String CONTEXT = "<img src=\"https://www.bsoft.com.cn/hr/birthdayCard1.jpg\">";

    @Override
    public void sendBirthEmail(){
        //获取当日生日员工
        List<BirthDayDO> birthDayDOList = birthDayDao.findAll();
        //获取生日邮件维护收件人员
        List<BirthEmailDO> birthEmailDOS = birthEmailDao.findAll();
        //发送邮件
        for (BirthDayDO birthDayDO : birthDayDOList){
            if (birthDayDO.getEmail() != null && !birthDayDO.getEmail().trim().equals("")){
                EmailSenderBean emailSenderBean = new EmailSenderBean();
                String subject = getSubject(birthDayDO);//主题
                emailSenderBean.setSubject(subject);//设置主题
                List<String> to = getBirthEmailTo(birthDayDO,birthEmailDOS);//收件人
                emailSenderBean.setTo(to);//设置收件人
                List<String> cc = getBirthEmailCC(birthDayDO);//抄送人
                emailSenderBean.setCc(cc);//设置抄送人
                emailSenderBean.setText(CONTEXT);//邮件正文
                emailSenderBean.setHasEnd(false);//不需要正文的尾部内容
                emailSenderBean.setNeedPassWord(false);//不需要密码发送
                EmailSender.getEofficeEmailSender().sendEmail(emailSenderBean);
            }
        }
    }

    //获取主题
    private String getSubject(BirthDayDO birthDayDO){
        Integer level = birthDayDO.getLevel() != null? birthDayDO.getLevel():0;//调后补贴
        if (level == 11 || level == 13){//高管（总助）,体系外高管（总助）
            return "★" + birthDayDO.getPersonName() + "：祝您生日快乐!";
        }else if(level == 1 || level == 2 || level == 12){//高管,体系外高管  （副总裁及以上）
            return "★★" + birthDayDO.getPersonName() + "：祝您生日快乐!";
        }else{
            return birthDayDO.getPersonName() + "：祝您生日快乐!";
        }
    }

    //获取收件人
    private List<String> getBirthEmailTo(BirthDayDO birthDayDO,List<BirthEmailDO> birthEmailDOS){
        List<String> to = new ArrayList<>();
        if(StringUtils.isNotBlank(birthDayDO.getEmail())){
            to.add(birthDayDO.getEmail());
        }
        //生日邮件维护的收件人
        if (birthEmailDOS.size()>0){
            for (BirthEmailDO birthEmailDO:birthEmailDOS){
                if (StringUtils.isNotBlank(birthEmailDO.getEmail())){
                    to.add(birthEmailDO.getEmail());
                }
            }
        }
        return to;
    }

    //获取抄送人
    private List<String> getBirthEmailCC(BirthDayDO birthDayDO){
        List<String> cc = new ArrayList<>();
        Integer level = birthDayDO.getLevel() != null? birthDayDO.getLevel():0;//调后补贴
        if(StringUtils.isNotBlank(birthDayDO.getDeptHeadEmail())){
            cc.add(birthDayDO.getDeptHeadEmail());//部门负责人
        }
        if(StringUtils.isNotBlank(birthDayDO.getRegionaHeadEmail())){
            cc.add(birthDayDO.getRegionaHeadEmail());//大区负责人
        }
        if (birthDayDO.getType() == 2 && StringUtils.isNotBlank(birthDayDO.getExecutiveDirectorEmail())){
            cc.add(birthDayDO.getExecutiveDirectorEmail());//大区行政主管
        }
        //高管抄送（于瑶、盛小华）
        if (level == 1 || level == 2 || level == 11 || level == 12 || level == 13){
            cc.add("shengxh@bsoft.com.cn");
        }
        return cc;
    }

}
