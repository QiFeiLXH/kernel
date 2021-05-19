package com.bsoft.opinion.entity.primary;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "ker_opinion_info")
public class OpinionDO {
    private Integer id;
    @NotNull(message = "系统不能为空")
    private Integer system;
    @Length(max = 4000,message = "意见内容不长度能超过4000个字符")
    private String content;
    @Length(max = 200,message = "图片路径长度不能超过200个字符")
    private String path;
    @NotBlank(message = "提交人不能为空")
    @Length(message = "提交人工号长度不能超过20位")
    private String submitter;
    @NotNull(message = "提交日期不能为空")
    private Date submitDate;
    @NotNull(message = "状态不能为空")
    private Integer status;
    @Length(max = 4000,message = "反馈内容不能超过4000个字符")
    private String feedbackContent;
    private Date feedbackDate;
    @Length(max = 20,message = "反馈人员工号长度不能超过20位")
    private String feedbacker;
    @Length(max = 50,message = "反馈功能模块不能超过50个字符")
    private String feedbackModule;

    @Id
    @SequenceGenerator(name="seq_ker_opinion_info",allocationSize=1,sequenceName="seq_ker_opinion_info")
    @GeneratedValue(generator="seq_ker_opinion_info",strategy=GenerationType.SEQUENCE)
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

    public String getFeedbackModule() {
        return feedbackModule;
    }

    public void setFeedbackModule(String feedbackModule) {
        this.feedbackModule = feedbackModule;
    }
}
