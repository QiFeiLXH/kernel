package com.bsoft.hr.manager.impl;

import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.email.bean.EmailSenderBean;
import com.bsoft.email.sender.EmailSender;
import com.bsoft.hr.entity.primary.ClockInModeDeptInfoDO;
import com.bsoft.hr.entity.primary.PersonNameDO;
import com.bsoft.hr.manager.ClockInModeManager;
import com.bsoft.hr.manager.PersonFinancialTypeEmailManager;
import com.bsoft.hr.manager.PersonNameManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonFinancialTypeEmailManagerImpl implements PersonFinancialTypeEmailManager {
    private static final String SUBJECT = "部门人员财务类别待维护提醒";
    @Autowired
    private ClockInModeManager clockInModeManager;
    @Autowired
    private PersonNameManager personNameManager;
    @Autowired
    private ServerDateManager serverDateManager;


    @Override
    public void sendRemindEmailToDeptFinancial() {
        Date now = serverDateManager.getServerDate();

        List<ClockInModeDeptInfoDO> all = clockInModeManager.findAll();
        List<String> deptList =  new ArrayList<>();
        all.forEach(clockInModeDeptInfoDO -> {
            if(clockInModeDeptInfoDO.getPersonTypeFlag()==null&&clockInModeDeptInfoDO.getLogout()!=1){
                deptList.add(clockInModeDeptInfoDO.getDeptName());
            }
        });
            if(deptList.size()!=0){
                EmailSenderBean emailSenderBean = new EmailSenderBean();
                emailSenderBean.setSubject(SUBJECT);//设置主题
                List<String> to = new ArrayList<>();
                //定时邮件提醒人员： 陈锦剑、张婷婷
                PersonNameDO personNameDaoById = personNameManager.findById("11060");
                String email = personNameDaoById.getEmail();
                to.add(email);//收件人  部门负责人emailSenderBean.setTo(to);//设置收件人
//                emailSenderBean.setPath(path);
//                StringBuilder strDeptList = new StringBuilder();
//                StringBuilder newStrDeptList = new StringBuilder();
//                if(deptList.size()!=0){
//                   for(String s : deptList){
//                     StringBuilder strDept = new StringBuilder(s);
//                     strDeptList.append(strDept).append(",");
//                   }
//                    strDeptList.toString().substring(1, strDeptList.length() - 3);
//                    newStrDeptList = new StringBuilder(strDeptList);
//                }
//                String context = "<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您好！<br/>" +
//                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "有以下部门的人员财务类别未维护，请及时维护。</br>" + "</br>" +
//                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"部门名称 :" +"</br>"+
//                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+newStrDeptList +"</br>" +
////                        "<div style=\"text-align: right\">"+deptList.get(0)+"</div>" +
//                        "<hr style=\"border:1px double #e8e8e8\"/>" +
//                        "此为企业信息门户系统邮件。请勿回复，谢谢！";

                String html_msg="";
                html_msg = "<html><body><div style=\"overflow: auto;width: 1500px;\">";
                html_msg = "<table border=\"1\" cellspacing=\"0\" style=\"font-family: 宋体;font-size: 17px;color: black;width:270px;border-collapse:collapse;border-color:black\">";
                html_msg = html_msg+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "<p style=\"font-family: 宋体;font-size: 20px;color: black;\"> 有以下部门的人员财务类别未维护，请及时维护。</p></br>" + "</br>";
                html_msg = html_msg+"<div style=\"padding-left:50px;\"><tbody>";
                html_msg = html_msg+"<tr bgcolor='#B6DDE6'>";
                html_msg = html_msg +"<td font-weight:700; width=\"100px\" style=\"min-width: 100px;font-family: 宋体;font-size: 20px;color: black;\"><b>部门名称</b></td>";
                html_msg = html_msg+"</tr>";
                for(String s : deptList){
                    html_msg = html_msg+"<tr >";
                    html_msg = html_msg +"<td style=\"font-family: 宋体;font-size: 17px;color: black;\">"+s+"</td>";
                    html_msg = html_msg+"</tr>";
                }
                html_msg = html_msg + "</body></tbody></div></table></html>";
                html_msg = html_msg+"<div style=\"text-align: right;  font-family: 微软雅黑; font-size: 14px; \">"+now+"</div>";
                html_msg = html_msg + "<hr style=\"border:1px double #e8e8e8\"/>" +
                        "<p style=\"font-family: 微软雅黑; font-size: 14px;\">此为企业信息门户系统邮件。请勿回复，谢谢！</p>";



                emailSenderBean.setText(html_msg);//邮件正文
                emailSenderBean.setHasEnd(false);//不需要正文的尾部内容
                emailSenderBean.setNeedPassWord(false);//不需要密码发送
                EmailSender.getEofficeEmailSender().sendEmail(emailSenderBean);
            }
        }

}
