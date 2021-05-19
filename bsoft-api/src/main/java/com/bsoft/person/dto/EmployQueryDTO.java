package com.bsoft.person.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Auther: hy
 * @Date: 2020/5/20
 * @Description:
 */
public class EmployQueryDTO implements Serializable {

    private Integer pageNumber;
    private Integer pageSize;
    private String userId;
    private Integer days;
    private List<Integer> status;
    private Boolean checkAll;
    private String content;
    private Boolean queryAll;
    private Date startTime;
    private Date checkTime;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public List<Integer> getStatus() {
        return status;
    }

    public void setStatus(List<Integer> status) {
        this.status = status;
    }

    public Boolean getCheckAll() {
        return checkAll;
    }

    public void setCheckAll(Boolean checkAll) {
        this.checkAll = checkAll;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getQueryAll() {
        return queryAll;
    }

    public void setQueryAll(Boolean queryAll) {
        this.queryAll = queryAll;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }
}
