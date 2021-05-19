package com.bsoft.cost.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/4 9:51
 * @Description 部门核算口径管理
 */
@Entity
@Table(name="BSOFT_PORTAL.FIN_COST_ACCOUNTBORE")
public class AccountCaliberDO {
    private Integer id;
    /** 年份 */
    private Integer year;
    /** 部门id */
    private String deptId;
    /** 核算口径归属 */
    private Integer accountCaliber;
    /** 登记日期 */
    private Date registrationDate;

    @Id
//    @SequenceGenerator(name="SEQ_FIN_COST_ACCOUNTBORE",allocationSize=1,sequenceName="SEQ_FIN_COST_ACCOUNTBORE")
//    @GeneratedValue(generator="SEQ_FIN_COST_ACCOUNTBORE",strategy=GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public Integer getAccountCaliber() {
        return accountCaliber;
    }

    public void setAccountCaliber(Integer accountCaliber) {
        this.accountCaliber = accountCaliber;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
