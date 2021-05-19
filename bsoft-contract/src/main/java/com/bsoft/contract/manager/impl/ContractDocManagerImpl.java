package com.bsoft.contract.manager.impl;

import com.bsoft.common.json.GsonUtils;
import com.bsoft.common.utils.DateUtils;
import com.bsoft.contract.dao.primary.ContractDocViewDao;
import com.bsoft.contract.entity.primary.ContractDocMissExcelDO;
import com.bsoft.contract.entity.primary.ContractDocViewDO;
import com.bsoft.contract.manager.ContractDocManager;
import com.bsoft.email.bean.EmailSenderBean;
import com.bsoft.email.sender.EmailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: xucl
 * @DateTime: 2020/12/9 10:33
 * @Description:
 */
@Component
public class ContractDocManagerImpl implements ContractDocManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContractDocManagerImpl.class);

    private static final String SUBJECT = "合同资料缺少邮件提醒!";
    @Autowired
    ContractDocViewDao contractDocViewDao;

    private static void sendEmail(List<ContractDocMissExcelDO> emailData,Integer type){
        EmailSenderBean emailSenderBean = new EmailSenderBean();
        List<String> to = new ArrayList<>();
        List<String> cc = new ArrayList<>();
        String toName = emailData.get(0).getSjrName();
        String html = "";
        html = createHTML(html,null,true,false,type);
        for (ContractDocMissExcelDO contractDocMissExcelDO:emailData){
            html = createHTML(html,contractDocMissExcelDO,false,false,type);
            if (contractDocMissExcelDO.getSjrEmail() != null){
                to.addAll(contractDocMissExcelDO.getSjrEmail());
            }
            if (contractDocMissExcelDO.getCsrEmail() != null){
                cc.addAll(contractDocMissExcelDO.getCsrEmail());
            }
        }
        html = createHTML(html,null,false,true,type);
        List<String> newto = getUniqueString(to);
        List<String> newcc = getUniqueString(cc);
        String context = "";
        if (type.equals(1)){
            context = "<html><body><div style=\"overflow: auto;width: 1500px;\"><div style=\"font-family: 宋体; font-size: 20px;color: black;\">" + toName+"：你好，<br/>"
                    +"&nbsp;&nbsp;&nbsp;&nbsp;你跟进的合同，原件未回。请尽快将合同原件寄给合同评审接口人。感谢工作配合！ </br></div>"
                    +"</br></br>"
                    +html;
        }
        if (type.equals(2)){
            context = "<html><body><div style=\"overflow: auto;width: 1500px;\"><div style=\"font-family: 宋体; font-size: 20px;color: black;\">" + toName+"：你好，<br/>"
                    +"&nbsp;&nbsp;&nbsp;&nbsp;你跟进的合同，中标通知书原件系统未维护。</br>请尽快将中标通知书原件寄给合同评审接口人，如果已经寄回公司，请联系合同评审员维护进系统。感谢工作配合！</br></div>"
                    +"</br></br>"
                    +html;
        }
        if (type.equals(3)){
            context = "<html><body><div style=\"overflow: auto;width: 1500px;\"><div style=\"font-family: 宋体; font-size: 20px;color: black;\">" + toName+"：你好，<br/>"
                    +"&nbsp;&nbsp;&nbsp;&nbsp;你负责的合同，合同评审表与合同扫描件未维护进系统，请尽快维护。谢谢。<br/></div>"
                    +"</br></br>"
                    +html;
        }
        emailSenderBean.setTo(newto);
        emailSenderBean.setCc(newcc);
        emailSenderBean.setHasEnd(true);
        emailSenderBean.setNeedPassWord(false);
        emailSenderBean.setText(context);
        emailSenderBean.setSubject(SUBJECT);
        LOGGER.info("需要发送的邮件为：[{}]", GsonUtils.gsonString(emailSenderBean));
        EmailSender.getEofficeEmailSender().sendEmail(emailSenderBean);
    }


    private static List<ContractDocMissExcelDO> getEmailData(Map<String,Object> map,Integer type){
        List<ContractDocViewDO> list = (List<ContractDocViewDO>) map.get("result");
        List<ContractDocMissExcelDO> docMissExcelDOS = new ArrayList<>();
        if (type.equals(1)){
            for (ContractDocViewDO docViewDO:list){
                ContractDocMissExcelDO contractDocMissExcelDO = new ContractDocMissExcelDO();
                List<String> sjrEmail = new ArrayList<>();
                List<String> csrEmail = new ArrayList<>();
                contractDocMissExcelDO.setSjrName(docViewDO.getGdrname());
                contractDocMissExcelDO.setSqrname(docViewDO.getSqrname());
                contractDocMissExcelDO.setSqrq(docViewDO.getSqrq());
                contractDocMissExcelDO.setContractNo(docViewDO.getContractNo());
                contractDocMissExcelDO.setBm1Text(docViewDO.getBm1Text());
                contractDocMissExcelDO.setXsqyText(docViewDO.getSsqyText());
                contractDocMissExcelDO.setKhmc(docViewDO.getKhmc());
                contractDocMissExcelDO.setHte(docViewDO.getHte());
                contractDocMissExcelDO.setQydwmc(docViewDO.getQydwmc());
                contractDocMissExcelDO.setKhrq(docViewDO.getKhrq());
                contractDocMissExcelDO.setShrname(docViewDO.getShrName());
                contractDocMissExcelDO.setHtyj("缺");
                sjrEmail.add(docViewDO.getGdrEmail());
                csrEmail.add(docViewDO.getXsbEmail());
                contractDocMissExcelDO.setSjrEmail(sjrEmail);
                contractDocMissExcelDO.setCsrEmail(csrEmail);
                docMissExcelDOS.add(contractDocMissExcelDO);
            }
        }

        if (type.equals(2)){
            for (ContractDocViewDO docViewDO:list) {
                ContractDocMissExcelDO contractDocMissExcelDO = new ContractDocMissExcelDO();
                List<String> sjrEmail = new ArrayList<>();
                List<String> csrEmail = new ArrayList<>();
                contractDocMissExcelDO.setSjrName(docViewDO.getGdrname());
                contractDocMissExcelDO.setSqrname(docViewDO.getSqrname());
                contractDocMissExcelDO.setSqrq(docViewDO.getSqrq());
                contractDocMissExcelDO.setContractNo(docViewDO.getContractNo());
                contractDocMissExcelDO.setBm1Text(docViewDO.getBm1Text());
                contractDocMissExcelDO.setXsqyText(docViewDO.getSsqyText());
                contractDocMissExcelDO.setKhmc(docViewDO.getKhmc());
                contractDocMissExcelDO.setHte(docViewDO.getHte());
                contractDocMissExcelDO.setQydwmc(docViewDO.getQydwmc());
                contractDocMissExcelDO.setKhrq(docViewDO.getKhrq());
                contractDocMissExcelDO.setShrname(docViewDO.getShrName());
                contractDocMissExcelDO.setZbtzs("缺");
                sjrEmail.add(docViewDO.getGdrEmail());
                sjrEmail.add(docViewDO.getSqrEmail());
                csrEmail.addAll(getBidWinningNoticeCC(docViewDO));
                contractDocMissExcelDO.setSjrEmail(sjrEmail);
                contractDocMissExcelDO.setCsrEmail(csrEmail);
                docMissExcelDOS.add(contractDocMissExcelDO);
            }
        }

        if (type.equals(3)){
            for (ContractDocViewDO docViewDO:list) {
                List<ContractDocMissExcelDO>  list1 = docMissExcelDOS.stream()
                        .filter((ContractDocMissExcelDO s) -> docViewDO.getContractNo().contains(s.getContractNo()))
                        .collect(Collectors.toList());
                if (list1.size() > 0){
                    if (docViewDO.getWdid().equals(4)){
                        list1.get(0).setHtwb("缺");
                    }
                    if (docViewDO.getWdid().equals(43)){
                        list1.get(0).setHtpsb("缺");
                    }
                }else{
                    ContractDocMissExcelDO contractDocMissExcelDO = new ContractDocMissExcelDO();
                    List<String> sjrEmail = new ArrayList<>();
                    List<String> csrEmail = new ArrayList<>();
                    contractDocMissExcelDO.setSjrName(docViewDO.getShrName());
                    contractDocMissExcelDO.setSqrname(docViewDO.getSqrname());
                    contractDocMissExcelDO.setSqrq(docViewDO.getSqrq());
                    contractDocMissExcelDO.setContractNo(docViewDO.getContractNo());
                    contractDocMissExcelDO.setBm1Text(docViewDO.getBm1Text());
                    contractDocMissExcelDO.setXsqyText(docViewDO.getSsqyText());
                    contractDocMissExcelDO.setKhmc(docViewDO.getKhmc());
                    contractDocMissExcelDO.setHte(docViewDO.getHte());
                    contractDocMissExcelDO.setQydwmc(docViewDO.getQydwmc());
                    contractDocMissExcelDO.setKhrq(docViewDO.getKhrq());
                    contractDocMissExcelDO.setShrname(docViewDO.getShrName());
                    if (docViewDO.getWdid().equals(4)){
                        contractDocMissExcelDO.setHtwb("缺");
                    }
                    if (docViewDO.getWdid().equals(43)){
                        contractDocMissExcelDO.setHtpsb("缺");
                    }
                    sjrEmail.add(docViewDO.getShrEmail());
                    sjrEmail.add(docViewDO.getDjryEmail());
                    csrEmail.add(docViewDO.getXsbEmail());
                    contractDocMissExcelDO.setSjrEmail(sjrEmail);
                    contractDocMissExcelDO.setCsrEmail(csrEmail);
                    docMissExcelDOS.add(contractDocMissExcelDO);
                }
            }
        }
        return docMissExcelDOS;
    }

    @Override
    public void sendContractOriginalEmail() {
        List<ContractDocViewDO> list = contractDocViewDao.findNoContractnoOrg();
        List<String> allUniqueToList = getAllTo(list,1);//获取所有不重复的收件人
        for (String to:allUniqueToList){
            Map<String,Object> map = getEmail(to,list,1);//收件人为'to'的所有邮件信息
            List<ContractDocMissExcelDO> emailData = getEmailData(map,1);
            sendEmail(emailData,1);
        }
    }

    @Override
    public void sendBidWinningNoticeEmail() {
        List<ContractDocViewDO> list = contractDocViewDao.findNoBidWin();
        List<String> allUniqueToList = getAllTo(list,2);//获取所有不重复的收件人
        for (String to:allUniqueToList){
            Map<String,Object> map = getEmail(to,list,2);//收件人为'to'的所有邮件信息
            List<ContractDocMissExcelDO> emailData = getEmailData(map,2);
            sendEmail(emailData,2);
        }
    }

    @Override
    public void sendContractNotMaintainEmail() {
        List<ContractDocViewDO> list = contractDocViewDao.findNoContractOrgAndYjyw();
        List<String> allUniqueToList = getAllTo(list,3);//获取所有不重复的收件人
        for (String to:allUniqueToList){
            Map<String,Object> map = getEmail(to,list,3);//收件人为'to'的所有邮件信息
            List<ContractDocMissExcelDO> emailData = getEmailData(map,3);
            sendEmail(emailData,3);
        }
    }

    private static String createHTML(String originHtml, ContractDocMissExcelDO data,boolean headFlage,boolean endFlage,Integer type) {
        String html_msg="";
        if(headFlage){
            html_msg = "<table border=\"1\" cellspacing=\"0\" style=\"font-family: 宋体;font-size: 17px;color: black;width:1000px;border-collapse:collapse;border-color:black\">";
            html_msg = html_msg+"<tbody>";
            html_msg = html_msg+"<tr bgcolor='#B6DDE6'>";
            html_msg = html_msg +"<td width=\"100px\" style=\"min-width: 100px;font-family: 宋体;font-size: 17px;color: black;\">申请人</td>";
            html_msg = html_msg +"<td width=\"150px\" style=\"min-width: 150px;font-family: 宋体;font-size: 17px;color: black;\">合同号</td>";
            html_msg = html_msg +"<td width=\"100px\" style=\"min-width: 100px;font-family: 宋体;font-size: 17px;color: black;\">一级区域</td>";
            html_msg = html_msg +"<td width=\"100px\" style=\"min-width: 100px;font-family: 宋体;font-size: 17px;color: black;\">销售区域</td>";
            html_msg = html_msg +"<td width=\"500px\" style=\"min-width: 500px;font-family: 宋体;font-size: 17px;color: black;\">客户名称</td>";
            html_msg = html_msg +"<td width=\"100px\" style=\"min-width: 100px;font-family: 宋体;font-size: 17px;color: black;\">合同金额</td>";
            html_msg = html_msg +"<td width=\"100px\" style=\"min-width: 100px;font-family: 宋体;font-size: 17px;color: black;\">考核日期</td>";
            html_msg = html_msg +"<td width=\"100px\" style=\"min-width: 100px;font-family: 宋体;font-size: 17px;color: black;\">合同评审员</td>";
            if (type.equals(1)){
                html_msg = html_msg +"<td width=\"100px\" style=\"min-width: 100px;font-family: 宋体;font-size: 17px;color: black;\">合同原件</td>";
            }
            if (type.equals(2)){
                html_msg = html_msg +"<td width=\"100px\" style=\"min-width: 100px;font-family: 宋体;font-size: 17px;color: black;\">中标通知书</td>";
            }
            if (type.equals(3)){
                html_msg = html_msg +"<td width=\"100px\" style=\"min-width: 100px;font-family: 宋体;font-size: 17px;color: black;\">合同评审表</td>";
                html_msg = html_msg +"<td width=\"100px\" style=\"min-width: 100px;font-family: 宋体;font-size: 17px;color: black;\">合同文本</td>";
            }
            html_msg = html_msg+"</tr>";
        }else{
            if (data != null){
                html_msg = html_msg+"<tr>";
                String Sqrname = data.getSqrname() != null?data.getSqrname():"";
                html_msg = html_msg +"<td style=\"font-family: 宋体;font-size: 17px;color: black;\">"+Sqrname+"</td>";
                String ContractNo = data.getContractNo() != null?data.getContractNo():"";
                html_msg = html_msg +"<td style=\"font-family: 宋体;font-size: 17px;color: black;\">"+ContractNo+"</td>";
                String Bm1Text = data.getBm1Text()!= null?data.getBm1Text():"";
                html_msg = html_msg +"<td style=\"font-family: 宋体;font-size: 17px;color: black;\">"+Bm1Text+"</td>";
                String XsqyText = data.getXsqyText() != null?data.getXsqyText():"";
                html_msg = html_msg +"<td style=\"font-family: 宋体;font-size: 17px;color: black;\">"+XsqyText+"</td>";
                String Khmc = data.getKhmc() != null?data.getKhmc():"";
                html_msg = html_msg +"<td style=\"font-family: 宋体;font-size: 17px;color: black;\">"+ Khmc +"</td>";
                String Hte = data.getHte()!= null? String.valueOf(data.getHte()) :"";
                html_msg = html_msg +"<td style=\"font-family: 宋体;font-size: 17px;color: black;\">"+Hte+"</td>";
                String khrq = data.getKhrq()!=null?DateUtils.dateToString(data.getKhrq(),"yyyy-MM-dd"):"";
                html_msg = html_msg +"<td style=\"font-family: 宋体;font-size: 17px;color: black;\">"+khrq+"</td>";
                String Shrname = data.getShrname() != null?data.getShrname():"";
                html_msg = html_msg +"<td style=\"font-family: 宋体;font-size: 17px;color: black;\">"+Shrname+"</td>";
                if (type.equals(1)){
                    html_msg = html_msg +"<td style=\"font-family: 宋体;font-size: 17px;color: black;\">"+data.getHtyj()+"</td>";
                }
                if (type.equals(2)){
                    html_msg = html_msg +"<td style=\"font-family: 宋体;font-size: 17px;color: black;\">"+data.getZbtzs()+"</td>";
                }
                if (type.equals(3)){
                    if (data.getHtpsb() == null){
                        html_msg = html_msg +"<td style=\"font-family: 宋体;font-size: 17px;color: black;\">已维护</td>";
                    }else{
                        html_msg = html_msg +"<td style=\"font-family: 宋体;font-size: 17px;color: black;\">"+data.getHtpsb()+"</td>";
                    }

                    if (data.getHtwb() == null){
                        html_msg = html_msg +"<td style=\"font-family: 宋体;font-size: 17px;color: black;\">已维护</td>";
                    }else{
                        html_msg = html_msg +"<td style=\"font-family: 宋体;font-size: 17px;color: black;\">"+data.getHtwb()+"</td>";
                    }
                }
                html_msg = html_msg+"</tr>";
            }
        }
        if(endFlage){
            html_msg = html_msg + "</tbody></table></div></body></html>";
        }
        return originHtml+html_msg;
    }

    //去重
    private static List<String> getUniqueString(List<String> strings){
        List<String> uniqueList = strings.stream()
                .distinct()
                .collect(Collectors.toList());
        return uniqueList;
    }

    //获取同一收件人需要接受的邮件数据
    private Map<String,Object> getEmail(String personId,List<ContractDocViewDO> list,Integer type){
        Map<String,Object> map = new HashMap<>();
        List<ContractDocViewDO> result = null;
        List<String> contractnos = new ArrayList<>();

        if (type.equals(1)){
            result = list.stream()
                    .filter((ContractDocViewDO s) -> personId.contains(s.getGdr()))
                    .collect(Collectors.toList());
        }
        if (type.equals(2)){
            result = list.stream()
                    .filter((ContractDocViewDO s) -> personId.contains(s.getGdr() + "," + s.getSqr()))
                    .collect(Collectors.toList());
        }
        if (type.equals(3)){
            result = list.stream()
                    .filter((ContractDocViewDO s) -> personId.contains(s.getShr() + "," + s.getDjry() ))
                    .collect(Collectors.toList());
        }
        for (ContractDocViewDO docViewDO:result){
            contractnos.add(docViewDO.getContractNo());
        }
        List<String> newContractNos = getUniqueString(contractnos);//所有的唯一的合同号
        map.put("result",result);
        map.put("contractNo",newContractNos);
        return map;
    }

    private List<String> getAllTo(List<ContractDocViewDO> list,Integer type){
        List<String> allTo = new ArrayList<>();
        if (type == 1){
            for(ContractDocViewDO docViewDO:list){
                allTo.add(docViewDO.getGdr());
            }
        }
        if (type == 2){
            for(ContractDocViewDO docViewDO:list){
                allTo.add(docViewDO.getGdr() + "," + docViewDO.getSqr());
            }
        }
        if (type == 3){
            for (ContractDocViewDO docViewDO:list){
                allTo.add(docViewDO.getShr() + "," + docViewDO.getDjry());
            }
        }
        return getUniqueString(allTo);
    }

    //获取抄送人
    private static List<String> getBidWinningNoticeCC(ContractDocViewDO docViewDO){
        List<String> cc = new ArrayList<>();
        if (docViewDO.getDqzjlEmail() != null && docViewDO.getDqzjlEmail() != ""){
            cc.add(docViewDO.getDqzjlEmail());
        }
        if (docViewDO.getDqxsfzrEmail() != null && docViewDO.getDqxsfzrEmail() != ""){
            cc.add(docViewDO.getDqxsfzrEmail());
        }
        if (docViewDO.getXqzjlEmail() != null && docViewDO.getXqzjlEmail() != ""){
            cc.add(docViewDO.getXqxsfzrEmail());
        }
        if (docViewDO.getXqxsfzrEmail() != null && docViewDO.getXqxsfzrEmail() != ""){
            cc.add(docViewDO.getXqxsfzrEmail());
        }
        if (docViewDO.getXsbEmail() != null && docViewDO.getXsbEmail() != ""){
            cc.add(docViewDO.getXsbEmail());
        }
        if (docViewDO.getShrEmail() != null && docViewDO.getShrEmail() != ""){
            cc.add(docViewDO.getShrEmail());
        }
        return cc;
    }
}
