package com.bsoft.message.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-03-10 9:33
 * @Version 1.0
 * @Description
 */
public class EmailMessageBean {
    private static final String DEFAULT_EMAIL_FROM = "eoffice@bsoft.com.cn";
    private String from;//邮件发送人
    private String subject;//邮件标题
    private List<String> to = new ArrayList<>();//邮件接收人
    private List<String> cc = new ArrayList<>();//邮件抄送人
    private String text;//邮件内容
    private String passWord;//发送人密码
    private boolean hasEnd = true;//是否有末尾备注
    private List<EmailBasePic> pics;
    private boolean needPassWord = true;//需要密码
    private boolean sencBccFlag = false;//密送eoffice标志
    private String path;//定时任务中的beanclass

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static EmailMessageBean defaultEmailMessageBean(){
        EmailMessageBean emailMessageBean = new EmailMessageBean();
        emailMessageBean.setFrom(DEFAULT_EMAIL_FROM);
        return  emailMessageBean;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void addTo(String email){
        to.add(email);
    }

    public void addCC(String email){
        cc.add(email);
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isHasEnd() {
        return hasEnd;
    }

    public void setHasEnd(boolean hasEnd) {
        this.hasEnd = hasEnd;
    }

    public List<EmailBasePic> getPics() {
        return pics;
    }

    public void setPics(List<EmailBasePic> pics) {
        this.pics = pics;
    }

    public boolean isNeedPassWord() {
        return needPassWord;
    }

    public void setNeedPassWord(boolean needPassWord) {
        this.needPassWord = needPassWord;
    }

    public boolean isSencBccFlag() {
        return sencBccFlag;
    }

    public void setSencBccFlag(boolean sencBccFlag) {
        this.sencBccFlag = sencBccFlag;
    }
}
