package com.bsoft.person.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/12/30 11:03
 * @Description:
 */
public class PersonTransferQueryCndDTO implements Serializable {
    private Integer pageSize;
    private Integer pageNo;
    private String input;
    private String bmdm;
    private Date transferDate;
    private String xuslgname;
    private String xdno;
    private Integer flag;//1 含新入司，0 不含

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public String getXuslgname() {
        return xuslgname;
    }

    public void setXuslgname(String xuslgname) {
        this.xuslgname = xuslgname;
    }

    public String getXdno() {
        return xdno;
    }

    public void setXdno(String xdno) {
        this.xdno = xdno;
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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
