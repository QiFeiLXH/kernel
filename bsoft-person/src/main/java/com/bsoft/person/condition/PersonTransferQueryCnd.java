package com.bsoft.person.condition;

/**
 * @Author: xucl
 * @DateTime: 2020/12/30 10:45
 * @Description:
 */
public class PersonTransferQueryCnd {
    private Integer pageSize;
    private Integer pageNo;
    private String input;
    private String bmdm;

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

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getBmdm() {
        return bmdm;
    }

    public void setBmdm(String bmdm) {
        this.bmdm = bmdm;
    }
}
