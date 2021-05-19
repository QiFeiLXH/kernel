package com.bsoft.work.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Huang GH
 * @date 2021/5/11 17:22
 */
public class PolicyDTO implements Serializable {
    /**
     *主键
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 所属管理委员会
     */
    private Integer councilId;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 内容
     */
    private String context;
    /**
     * 发布人
     */
    private String publisher;
    /**
     * 发布日期
     */
    private Date publishDate;
    /**
     * 填写人
     */
    private String writer;
    /**
     * 填写日期
     */
    private Date writeDate;
    /**
     * 关键字
     */
    private String keyWord;
    /**
     * 阅读截止日期
     */
    private Date deadlineDate;
    /**
     * 填写部门、提交部门、登记部门
     */
    private String writeDept;
    /**
     * 封皮id
     */
    private Integer coverId;
    /**
     * 文件id
     */
    private Integer fileId;
    /**
     *
     */
    private String councilName;
    /**
     *
     */
    private Integer readStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCouncilId() {
        return councilId;
    }

    public void setCouncilId(Integer councilId) {
        this.councilId = councilId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public String getWriteDept() {
        return writeDept;
    }

    public void setWriteDept(String writeDept) {
        this.writeDept = writeDept;
    }

    public Integer getCoverId() {
        return coverId;
    }

    public void setCoverId(Integer coverId) {
        this.coverId = coverId;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getCouncilName() {
        return councilName;
    }

    public void setCouncilName(String councilName) {
        this.councilName = councilName;
    }

    public Integer getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Integer readStatus) {
        this.readStatus = readStatus;
    }
}
