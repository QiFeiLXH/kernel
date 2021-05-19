package com.bsoft.cost.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2020-04-09 15:44
 * @Version 1.0
 * @Description 保证金，履约保证金未冲账 邮件do
 */
@Entity
@Table(name="KER_BOND_ACCOUNT_VIEW")
public class BondAccountDO {
    private String id;//主键 借款凭证号
    private String accountNo;//流水号ID  申请单号
    private String dept;//申请部门
    private String userId;//领款人
    private String userEmail;//领款人邮箱
    private String unitName;//收款单位名称
    private Double money;//申请金额
    private Date drawBackTime;//预计退款时间
    private String leaderEmail;//部门负责人邮箱
    private Integer costType;//数据来源 1.保证金 2.履约保证金

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
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

    public Date getDrawBackTime() {
        return drawBackTime;
    }

    public void setDrawBackTime(Date drawBackTime) {
        this.drawBackTime = drawBackTime;
    }

    public String getLeaderEmail() {
        return leaderEmail;
    }

    public void setLeaderEmail(String leaderEmail) {
        this.leaderEmail = leaderEmail;
    }

    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }
}
