package com.bsoft.person.key;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/12/31 14:29
 * @Description:
 */
public class MonthPersonInfoKey implements Serializable {
    private Date month;
    private String personId;

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}
