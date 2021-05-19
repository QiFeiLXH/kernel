package com.bsoft.cost.entity.primary;

/**
 * @Author zhanglf
 * @Date 2020-04-21 9:57
 * @Version 1.0
 * @Description
 */
public class NeedDealCountDO {
    private Integer bankCharges;
    private Integer bond;
    private Integer performanceBond;

    public Integer getBankCharges() {
        return bankCharges;
    }

    public void setBankCharges(Integer bankCharges) {
        this.bankCharges = bankCharges;
    }

    public Integer getBond() {
        return bond;
    }

    public void setBond(Integer bond) {
        this.bond = bond;
    }

    public Integer getPerformanceBond() {
        return performanceBond;
    }

    public void setPerformanceBond(Integer performanceBond) {
        this.performanceBond = performanceBond;
    }
}
