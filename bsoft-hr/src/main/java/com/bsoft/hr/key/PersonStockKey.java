package com.bsoft.hr.key;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/19 10:40
 * @Description
 */
public class PersonStockKey implements Serializable {
    /** 员工工号 */
    private String personId;
    /** 登记日期 */
    private Date registerDate;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
