package com.bsoft.cost.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2020-04-10 9:39
 * @Version 1.0
 * @Description （待挂账）银行费用：对公费用申请，中标服务费邮件do
 */
@Entity
@Table(name="KER_PUBLIC_EXPENSE_VIEW")
public class BankChargesDO {
    private Integer id;//主键
    private String userId;//申请人工号
    private String userEmail;//申请人邮箱
    private String registrant;//登记人工号
    private String registrantEmail;//登记人邮箱
    private String dept;//申请部门
    private String unitName;//收款单位名称
    private Double money;//申请金额
    private String leaderEmail;//部门负责人邮箱
    private String officerEmail;//大区行政总监邮箱
    private String accountNo;//流水号ID  申请单号
    private Integer costType;//数据来源 1.对公费用 2.中标服务费
    private Integer remindDay;//将于remindDay影响个人账户




    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public String getRegistrantEmail() {
        return registrantEmail;
    }

    public void setRegistrantEmail(String registrantEmail) {
        this.registrantEmail = registrantEmail;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getLeaderEmail() {
        return leaderEmail;
    }

    public void setLeaderEmail(String leaderEmail) {
        this.leaderEmail = leaderEmail;
    }

    public String getOfficerEmail() {
        return officerEmail;
    }

    public void setOfficerEmail(String officerEmail) {
        this.officerEmail = officerEmail;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }

    public Integer getRemindDay() {
        return remindDay;
    }

    public void setRemindDay(Integer remindDay) {
        this.remindDay = remindDay;
    }
}
