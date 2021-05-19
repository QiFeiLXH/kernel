package com.bsoft.person.key;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/12/31 10:33
 * @Description:
 */
public class PersonCostLimitKey implements Serializable {
    private String personid;
    private Integer costtype;
    private Date execudate;

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public Integer getCosttype() {
        return costtype;
    }

    public void setCosttype(Integer costtype) {
        this.costtype = costtype;
    }

    public Date getExecudate() {
        return execudate;
    }

    public void setExecudate(Date execudate) {
        this.execudate = execudate;
    }
}
