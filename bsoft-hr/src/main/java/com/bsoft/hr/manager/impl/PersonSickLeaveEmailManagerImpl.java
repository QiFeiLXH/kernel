package com.bsoft.hr.manager.impl;

import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.dept.entity.primary.DeptDO;
import com.bsoft.dept.manager.DeptManager;
import com.bsoft.email.bean.EmailSenderBean;
import com.bsoft.email.sender.EmailSender;
import com.bsoft.hr.entity.primary.ClockInModeDeptInfoDO;
import com.bsoft.hr.entity.primary.PersonNameDO;
import com.bsoft.hr.entity.primary.PersonSickLeaveDO;
import com.bsoft.hr.entity.primary.WorkLeaveVacationDO;
import com.bsoft.hr.manager.ClockInModeManager;
import com.bsoft.hr.manager.PersonFinancialTypeEmailManager;
import com.bsoft.hr.manager.PersonNameManager;
import com.bsoft.hr.manager.PersonSickLeaveEmailManager;
import com.bsoft.hr.repository.primary.SickLeaveEmailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonSickLeaveEmailManagerImpl implements PersonSickLeaveEmailManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonSickLeaveEmailManagerImpl.class);

    private static final String SUBJECT = "请病假累积超过6个月的员工";
    @Autowired
    private SickLeaveEmailRepository sickLeaveEmailRepository;
    @Autowired
    private PersonNameManager personNameManager;
    @Autowired
    private DeptManager deptManager;

    @Autowired
    private ServerDateManager serverDateManager;


    @Override
    public void PersonSickLeaveEmail() {
        Date now = serverDateManager.getServerDate();
        List<PersonSickLeaveDO> sickLeave = sickLeaveEmailRepository.getSickLeave();
        //筛选出请假天数大于6.00月的集合
        Map<String,PersonSickLeaveDO> map  = new HashMap<>();
        sickLeave.forEach(personSickLeaveDO->{
            Double monthkey = this.getSumDay(personSickLeaveDO);
            personSickLeaveDO.setSum(monthkey);
                    if(map.containsKey(personSickLeaveDO.getYggh())){
                        PersonSickLeaveDO oldPersonSickLeaveDO = map.get(personSickLeaveDO.getYggh());
                        oldPersonSickLeaveDO.setSum(oldPersonSickLeaveDO.getSum()+monthkey);
                        map.put(personSickLeaveDO.getYggh(),oldPersonSickLeaveDO);
                    }else{
                        map.put(personSickLeaveDO.getYggh(),personSickLeaveDO);
                    }
            });
        List<PersonSickLeaveDO> list = new ArrayList<>();
        for(Map.Entry<String,PersonSickLeaveDO> s : map.entrySet()){
            Double x=s.getValue().getSum()/21.75;
            Double monthkey = (double)Math.round(x*100)/100;
            s.getValue().setSum(monthkey);
            if(s.getValue().getSum()>6.00){
                list.add(s.getValue());
            }
        }

        if(list.size()>0){
                EmailSenderBean emailSenderBean = new EmailSenderBean();
                emailSenderBean.setSubject(SUBJECT);//设置主题
                //抄送 人力资源部负责人
                DeptDO dept = deptManager.getDept("0603");
                PersonNameDO cc = personNameManager.findById(dept.getDepManager());
                String ccEmail = cc.getEmail();
                List<String> ccList = new ArrayList<>();
                ccList.add(ccEmail);
                emailSenderBean.setCc(ccList);
//              //定时邮件提醒人员： 薪资人员（李金洺）。
//              PersonNameDO personNameDaoById = personNameManager.findById("11060");
//              String email = "zhanglf@bsoft.com.cn";
//              List<String> to = new ArrayList<>();
//              to.add(email);//收件人  部门负责人emailSenderBean.setTo(to);//设置收件人
//              emailSenderBean.setTo(to);
                String html_msg="";
                html_msg = "<html><body><div style=\"overflow: auto;width: 1500px;\">";
                 html_msg = html_msg+"<p style=\"font-family: 微软雅黑;font-size: 15px;color: black;\"> 人力资源部：</p>" ;
                html_msg = html_msg+"<p style=\"font-family: 微软雅黑;font-size: 15px;color: black;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;近一年期内，出现请病假累积超过6个月的员工，该员工信息为：</p>";

                for(PersonSickLeaveDO s : list){
                    html_msg = html_msg+"<table>";
                    html_msg = html_msg +"<td style=\"font-family: 微软雅黑;font-size: 15px;color: black;\">"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;工号： <td style=\"border-bottom: 1px solid black;\n" +
                            "    width: 150px;\n" +
                            "    text-align: center;\">"+s.getYggh()+"</td></td>";

                    html_msg = html_msg +"<td style=\"font-family: 微软雅黑;font-size: 15px;color: black;\">"+"&nbsp;&nbsp;&nbsp;姓名：<td style=\"border-bottom: 1px solid black;\n" +
                            "    width: 150px;\n" +
                            "    text-align: center;\">"+s.getXusname()+"</td></td>";
                    html_msg = html_msg +"<td style=\"font-family: 微软雅黑;font-size: 15px;color: black;\">"+"&nbsp;&nbsp;&nbsp;累积请病假：<td style=\"border-bottom: 1px solid black;\n" +
                            "    width: 150px;\n" +
                            "    text-align: center;\">"+s.getSum()+"</td><td>个月</td></td>";
                    html_msg = html_msg+"</table>";
                }


                html_msg = html_msg + "</div></body></html>";
                html_msg = html_msg+ "<p style=\"font-family: 微软雅黑;font-size: 15px;color: black;\"> \n" + "特此预警，请及时关注。</p></br>" + "</br></tr>";
                html_msg = html_msg+"<div style=\"text-align: right;  font-family: 微软雅黑; font-size: 14px; \">"+now+"</div>";
                html_msg = html_msg + "<hr style=\"border:1px double #e8e8e8\"/>" +
                                "<p style=\"font-family: 微软雅黑; font-size: 14px;\">此为企业信息门户系统邮件。请勿回复，谢谢！</p>";

                emailSenderBean.setText(html_msg);//邮件正文
                emailSenderBean.setHasEnd(false);//不需要正文的尾部内容
                emailSenderBean.setNeedPassWord(false);//不需要密码发送
                LOGGER.info("请病假累积超过6个月的员工定时邮件发送开始：",emailSenderBean);
                EmailSender.getEofficeEmailSender().sendEmail(emailSenderBean);
                LOGGER.info("请病假累积超过6个月的员工定时邮件发送成功。");

        }
        }



        public Double getSumDay(PersonSickLeaveDO personSickLeaveDO){
            int oneday = 0;
            int afters = 0;
            int mornings =0;
            if(personSickLeaveDO.getOneday()!=null){
                 oneday = personSickLeaveDO.getOneday();
            }
            if(personSickLeaveDO.getAfters()!=null){
                 afters = personSickLeaveDO.getAfters();
            }
            if(personSickLeaveDO.getMornings()!=null){
                 mornings = personSickLeaveDO.getMornings();
            }
            double  x= oneday+(afters+mornings)*0.5;

        return x;
        }

}
