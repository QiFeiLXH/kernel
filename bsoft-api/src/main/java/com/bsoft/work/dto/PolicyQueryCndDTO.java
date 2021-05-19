package com.bsoft.work.dto;

import java.io.Serializable;

/**
 * @author Huang GH
 * @date 2021/5/10 17:43
 */
public class PolicyQueryCndDTO implements Serializable {
    /**
     * 所属委员会id
     */
    private Integer councilId;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 关键字
     */
    private String inputContent;
    /**
     * 标题
     */
    private String title;
    /**
     * 阅读状态
     */
    private Integer readStatus;
    /**
     * 工号
     */
    private String personId;
    /**
     * 员工查询输入框
     */
    private String searchPerson;


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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Integer readStatus) {
        this.readStatus = readStatus;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getSearchPerson() {
        return searchPerson;
    }

    public void setSearchPerson(String searchPerson) {
        this.searchPerson = searchPerson;
    }
}
