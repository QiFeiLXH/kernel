package com.bsoft.expense.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2021/1/7 16:42
 * @Description:
 */
@Entity
@Table(name = "bsoftmis.t_bxpz")
public class PersonReimburDO {
    private String pzh;
    private String dept;
    private Date accountDate;
    private String ReimburPerson;

    @Id
    public String getPzh() {
        return pzh;
    }

    public void setPzh(String pzh) {
        this.pzh = pzh;
    }

    @Column(name = "bm")
    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Column(name = "hsrq")
    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }

    @Column(name = "bxr")
    public String getReimburPerson() {
        return ReimburPerson;
    }

    public void setReimburPerson(String reimburPerson) {
        ReimburPerson = reimburPerson;
    }
}
