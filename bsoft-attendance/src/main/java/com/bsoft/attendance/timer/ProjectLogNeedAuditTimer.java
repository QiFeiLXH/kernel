package com.bsoft.attendance.timer;

import com.bsoft.attendance.entity.primary.ProjectLogNeedAuditDO;
import com.bsoft.attendance.manager.ProjectLogManager;
import com.bsoft.attendance.repository.primary.PersonEmailRepository;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.email.bean.EmailSenderBean;
import com.bsoft.email.sender.EmailSender;
import com.bsoft.message.manager.MessageSenderManager;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zhanglf
 * @Date 2020-03-12 9:29
 * @Version 1.0
 * @Description
 */
@Component
public class ProjectLogNeedAuditTimer implements Runnable{
    private static final Logger logger = LoggerFactory.getLogger(ProjectLogNeedAuditTimer.class);
    @Autowired
    private PersonEmailRepository personEmailRepository;
    @Autowired
    private ProjectLogManager projectLogManager;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private MessageSenderManager messageSenderManager;

    @Override
    public void run(){
        logger.info("开始统计待审核列表发送相关邮件");
        List<Map<String, Object>> countList = projectLogManager.getRegionAuditCount();
        for(Map<String, Object> countMap : countList){
            String smallRegion = (String) countMap.get("smallRegion");
            Integer count = Integer.parseInt(countMap.get("countNum").toString());
            List<ProjectLogNeedAuditDO> projectWorkLogDOList = projectLogManager.getRegionAuditList(smallRegion);
            if(projectWorkLogDOList.size()>0){
                try {
                    String titleDate = DateFormatUtils.format(serverDateManager.getServerDate(), "yyyy/MM/dd");
                    String regionalLeader = projectWorkLogDOList.get(0).getRegionalLeader();
                    String smallRegionLeader = projectWorkLogDOList.get(0).getFzr();
                    String smallRegionText = projectWorkLogDOList.get(0).getSmallRegionText();
                    String projectManager = projectWorkLogDOList.get(0).getProjectManager();
                    String subject = titleDate+smallRegionText+"有"+count+"条日志小区审核未通过";
//                    PersonDO regional = personManager.getPerson(regionalLeader);
//                    PersonDO smallRegional = personManager.getPerson(smallRegionLeader);
//                    PersonDO manager = personManager.getPerson(projectManager);
                    String toEmail = personEmailRepository.getPersonEmail(regionalLeader);
                    String ccEmail1 = personEmailRepository.getPersonEmail(smallRegionLeader);
//                    String ccEmail1 = smallRegional.getEmail();
                    String ccEmail2 = personEmailRepository.getPersonEmail(projectManager);
//                    String ccEmail2 = manager.getEmail();
                    Map<String,List<ProjectLogNeedAuditDO>> listMap = rebuildList(projectWorkLogDOList);
                    String context = buildContent(listMap,count,smallRegionText);
                    EmailSenderBean emailSenderBean = new EmailSenderBean();
                    emailSenderBean.setSubject(subject);
                    if(StringUtils.isNotBlank(toEmail)){
                        emailSenderBean.setTo(Lists.newArrayList(toEmail));
                    }
                    List<String> cc = new ArrayList<>();
                    if(StringUtils.isNotBlank(ccEmail1)){
                        cc.add(ccEmail1);
                    }
                    if(StringUtils.isNotBlank(ccEmail2)){
                        cc.add(ccEmail2);
                    }
                    emailSenderBean.setCc(cc);
                    emailSenderBean.setText(context);
                    EmailSender.getEofficeEmailSender().sendEmail(emailSenderBean);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Map<String,List<ProjectLogNeedAuditDO>> rebuildList(List<ProjectLogNeedAuditDO> projectWorkLogDOList){
        Map<String,List<ProjectLogNeedAuditDO>> map = new HashMap<>();
        for(ProjectLogNeedAuditDO projectWorkLogDO : projectWorkLogDOList){
            String key = projectWorkLogDO.getGsxm();
            if(map.containsKey(key)){
                List<ProjectLogNeedAuditDO> logDOS = map.get(key);
                logDOS.add(projectWorkLogDO);
            }else{
                List<ProjectLogNeedAuditDO> logDOS = new ArrayList<>();
                logDOS.add(projectWorkLogDO);
                map.put(key,logDOS);
            }
        }
        return map  ;
    }

    public String buildContent(Map<String,List<ProjectLogNeedAuditDO>> listLMap, Integer count,String smallRegionText) throws IOException {
        StringBuffer buffer = new StringBuffer("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body style=\"color: #666; font-size: 14px; font-family: 'Open Sans',Helvetica,Arial,sans-serif;\">\n" +
                "    <div class=\"info-wrap\" style=\"border-bottom-left-radius: 10px;\n" +
                "                                  border-bottom-right-radius: 10px;\n" +
                "                                  border:0px solid #ddd;\n" +
                "                                  overflow: hidden;\n" +
                "                                  padding: 15px 15px 20px;\">\n" +
                "        <div class=\"tips\" style=\"padding:15px;\">\n" +
                "            <p style=\" list-style: 160%; margin: 10px 0;\">{1}</p>\n" +
                "        </div>\n" +
                "        <br>\n" +
                "        <table class=\"list\" style=\"width: 100%; border-collapse: collapse; border-top:1px solid #eee; font-size:12px; table-layout: fixed;\">\n" +
                "            {2}\n" +
                "        </table>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>");

        String titleDate = DateFormatUtils.format(serverDateManager.getServerDate(), "yyyy/MM/dd");
        String contentText = "截止"+titleDate+smallRegionText+"有"+count+"条日志小区审核未通过，详见下表，请在一周内完成本归属确认，谢谢。<br>";
//        邮件表格header
        StringBuilder linesBuffer = new StringBuilder();
        for(Map.Entry<String, List<ProjectLogNeedAuditDO>> a : listLMap.entrySet()){
            List<ProjectLogNeedAuditDO> projectWorkLogDOList = a.getValue();
            linesBuffer.append("<thead>"+
                    "<tr style = 'background: #fafafa; color: #333; border-bottom: 1px solid #eee;'>"+
                    "<td style='font-weight:bold;height:30px;padding:6px 10px; line-height: 150%;border: 1px solid #eee; word-wrap: break-word;' colspan='4'>"+projectWorkLogDOList.get(0).getProjectName()+"</td>"+
                    "</tr >"+
                    "</thead >");
            if(projectWorkLogDOList!=null&&projectWorkLogDOList.size()>0) {
                projectWorkLogDOList.forEach(projectWorkLogDO -> {
                    linesBuffer.append("<tbody><tr><td style='padding:6px 10px; line-height: 150%;border: 1px solid #eee; word-wrap: break-word;'  colspan='2'>" + DateFormatUtils.format(projectWorkLogDO.getAttendanceDate(),"yyyy年MM月dd日") +
                            "</td><td style='padding:6px 10px; line-height: 150%;border: 1px solid #eee; word-wrap: break-word;' colspan='2'>" + projectWorkLogDO.getUserName() +"</td></tr>" +
                            "<tr>" +
                            "<td style='font-weight:bold;padding:6px 10px;height:150px; line-height: 150%;border: 1px solid #eee; word-wrap: break-word;' rowspan='2' width= '10%'>日志内容</td>" +
                            "<td style='padding:6px 10px;height:150px;  line-height: 150%;border: 1px solid #eee; word-wrap: break-word;' width= '75%' rowspan='2' colspan='3'>"+ projectWorkLogDO.getWorkLog().replace("\r\n", "<br/>").replace("\n", "<br/>")+ "</td></tr>" +
                            "<tr></tr>"+
                            "<tr>" +
                            "<td style='font-weight:bold;padding:6px 10px;height:150px; line-height: 150%;border: 1px solid #eee; word-wrap: break-word;' rowspan='2' width= '10%'>意见</td>" +
                            "<td style='padding:6px 10px;height:150px; line-height: 150%;border: 1px solid #eee; word-wrap: break-word;' width= '75%' rowspan='2' colspan='3'>"+ projectWorkLogDO.getRemark().replace("\r\n", "<br/>").replace("\n", "<br/>")+ "</td></tr>" +
                            "<tr></tr>"+
                            "<tr><td ></td><td></td><td></td><td></td></tr>" +
                            "<tbody>"
                    );
                });
            }
        }
        //颜色
        String emailHeadColor = "#fa5834";
        //填充html模板中的2个参数
        String htmlText = MessageFormat.format(buffer.toString(), emailHeadColor, contentText, linesBuffer.toString());

        return htmlText;
    }
}
