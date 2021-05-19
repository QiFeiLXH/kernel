package com.bsoft.email.bean;

import com.bsoft.message.bean.EmailBasePic;

import java.util.ArrayList;
import java.util.List;

public class EmailSenderBean {
    private String subject;//邮件标题
    private List<String> to = new ArrayList<>();//邮件接收人
    private List<String> cc = new ArrayList<>();//邮件抄送人
    private String text;//邮件内容
    private boolean hasEnd = true;//显示底部信息
    private List<EmailBasePic> pics;
    private boolean needPassWord = true;//需要密码
    private String path;//通过类路径访问定时任务列表获取维护的收件人和抄送人

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
}
