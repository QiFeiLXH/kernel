package com.bsoft.opinion.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OpinionDTO implements Serializable {
    private Integer id;
    private Integer system;
    private String content;
    private String path;
    private String submitter;
    private String submitterDept;
    private Date submitDate;
    private Integer status;
    private String feedbackContent;
    private Date feedbackDate;
    private String feedbacker;
    private String submitterText;
    private String feedbackerText;
    private String statusText;
    private List<byte[]> images;
    private String systemText;
    private String feedbackModule;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSystem() {
        return system;
    }

    public void setSystem(Integer system) {
        this.system = system;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public String getSubmitterDept() {
        return submitterDept;
    }

    public void setSubmitterDept(String submitterDept) {
        this.submitterDept = submitterDept;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public Date getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public String getFeedbacker() {
        return feedbacker;
    }

    public void setFeedbacker(String feedbacker) {
        this.feedbacker = feedbacker;
    }

    public String getSubmitterText() {
        return submitterText;
    }

    public void setSubmitterText(String submitterText) {
        this.submitterText = submitterText;
    }

    public String getFeedbackerText() {
        return feedbackerText;
    }

    public void setFeedbackerText(String feedbackerText) {
        this.feedbackerText = feedbackerText;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public List<byte[]> getImages() {
        return images;
    }

    public void setImages(List<byte[]> images) {
        this.images = images;
    }

    public String getFeedbackModule() {
        return feedbackModule;
    }

    public void setFeedbackModule(String feedbackModule) {
        this.feedbackModule = feedbackModule;
    }

    public String getSystemText() {
        return systemText;
    }

    public void setSystemText(String systemText) {
        this.systemText = systemText;
    }
}
