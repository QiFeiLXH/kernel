package com.bsoft.email.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EmailSenderBeanDTO implements Serializable {
    private String subject;//邮件标题
    private List<String> to = new ArrayList<>();//邮件接收人
    private List<String> cc = new ArrayList<>();//邮件抄送人
    private String text;//邮件内容

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
}
