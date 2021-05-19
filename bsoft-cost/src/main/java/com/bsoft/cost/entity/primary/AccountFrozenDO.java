package com.bsoft.cost.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author zhanglf
 * @Date 2020-04-24 13:16
 * @Version 1.0
 * @Description
 */
@Entity
@Table(name="ker_Account_FrozenInfo")
public class AccountFrozenDO {
    private Integer id; //主键id
    private Integer dataSource; //数据来源
    private String reason; //记录原因
    private String originalNo; //原始单号
    private Double money; //金额
    private String belonger; //归属人
    private Integer accountInfo; //账户情况信息
    private Date frozenTime; //冻结时间
    private String operator; //操作人
    private String remarks; //备注

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDataSource() {
        return dataSource;
    }

    public void setDataSource(Integer dataSource) {
        this.dataSource = dataSource;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOriginalNo() {
        return originalNo;
    }

    public void setOriginalNo(String originalNo) {
        this.originalNo = originalNo;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getBelonger() {
        return belonger;
    }

    public void setBelonger(String belonger) {
        this.belonger = belonger;
    }

    public Integer getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(Integer accountInfo) {
        this.accountInfo = accountInfo;
    }

    public Date getFrozenTime() {
        return frozenTime;
    }

    public void setFrozenTime(Date frozenTime) {
        this.frozenTime = frozenTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
