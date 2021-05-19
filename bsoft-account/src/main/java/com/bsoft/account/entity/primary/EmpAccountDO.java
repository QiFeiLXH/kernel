package com.bsoft.account.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author zhanglf
 * @Date 2020-04-24 15:04
 * @Version 1.0
 * @Description
 */
@Entity
@Table(name="bsoftmis.t_ygzh")
public class EmpAccountDO {
    private String userId;
    private Integer accountInfo;
    private Integer frozenNums;

    @Id
    @Column(name = "yggh")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(Integer accountInfo) {
        this.accountInfo = accountInfo;
    }

    public Integer getFrozenNums() {
        return frozenNums;
    }

    public void setFrozenNums(Integer frozenNums) {
        this.frozenNums = frozenNums;
    }
}
