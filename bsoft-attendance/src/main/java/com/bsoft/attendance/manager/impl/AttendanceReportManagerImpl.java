package com.bsoft.attendance.manager.impl;

import com.bsoft.attendance.entity.primary.DeptSecretaryPersonDO;
import com.bsoft.attendance.manager.AttendanceReportManager;
import com.bsoft.attendance.repository.primary.AttendanceReportRepository;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.email.bean.EmailSenderBean;
import com.bsoft.email.sender.EmailSender;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/8 9:36
 * @Description
 */
@Service
public class AttendanceReportManagerImpl implements AttendanceReportManager {
    @Value("${attendance.mail.cc}")
    private String ATTEND_DEFAULT_CC;

    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private AttendanceReportRepository attendanceReportRepository;

    @Override
    public void sendAttendanceStatisticRemindEmail() {
        // 获取未发送考勤统计的津贴文秘
        List<DeptSecretaryPersonDO> secretaries = this.getDeptSecretaryPerson();
        List<EmailSenderBean> emailBeans = new ArrayList<>();
        if (secretaries.isEmpty()) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(serverDateManager.getServerDate());
        final int date = calendar.get(Calendar.DATE); // 获取当天日期
        calendar.add(Calendar.MONTH,-1);
        int month = calendar.get(Calendar.MONTH) + 1;// 上个月月份
        Map<String, List<DeptSecretaryPersonDO>> secretaryMap = secretaries.stream().collect(Collectors.groupingBy(DeptSecretaryPersonDO::getPersonId));
        secretaryMap.forEach((key,value) -> {
            if (!value.isEmpty()) {
                if (StringUtils.isNotBlank(value.get(0).getEmail())) {
                    StringBuilder contextBuilder = new StringBuilder("您好：<br/>&nbsp;&nbsp;&nbsp;&nbsp;").append(month).append("月份的考勤统计，以下部门未提交，请及时处理：<br/>").append("<table border=\"1\" cellspacing=\"0\" cellpadding=\"10\"height=\"100\"><tr><td style=\"font-weight: bold;width: 100px\">月份</td><td style=\"font-weight: bold;width: 200px\">部门</td></tr>");

                    value.forEach(secretary -> {
                        contextBuilder.append("<tr><td style=\"width: 100px\">").append(month).append("月份</td><td style=\"width: 200px\">").append(secretary.getDeptName());
                    });
                    contextBuilder.append("</td></tr></table>");
                    EmailSenderBean emailSenderBean = new EmailSenderBean();
                    emailSenderBean.setSubject("部门考勤统计未提交提醒");
                    emailSenderBean.addTo(value.get(0).getEmail());
                    if (date >= 6) {
                        emailSenderBean.addCC(ATTEND_DEFAULT_CC);
                    }
                    emailSenderBean.setText(contextBuilder.toString());
                    emailBeans.add(emailSenderBean);
                }
            }
        });

        emailBeans.forEach(emailBean -> {
            EmailSender.getEofficeEmailSender().sendEmail(emailBean);
        });
    }

    public List<DeptSecretaryPersonDO> getDeptSecretaryPerson() {
        return attendanceReportRepository.getDeptSecretaryPerson();
    }
}
