package com.bsoft.work.condition;

/**
 * @Author zhanglf
 * @Date 2020-12-21 15:51
 * @Version 1.0
 */
public class MeetPersonQueryCnd {
    private Integer meetId;
    private String input;
    private Integer pageSize;
    private Integer pageNo;

    public Integer getMeetId() {
        return meetId;
    }

    public void setMeetId(Integer meetId) {
        this.meetId = meetId;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}
