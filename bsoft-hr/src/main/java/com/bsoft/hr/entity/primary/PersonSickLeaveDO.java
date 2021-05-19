package com.bsoft.hr.entity.primary;

/**
 * 病假或长病假超6个月
 */
public class PersonSickLeaveDO {
    private String yggh;
    private String xusname;
    private Integer mornings;
    private Integer afters;
    private Integer oneday;
    private Double sum;

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getYggh() {
        return yggh;
    }

    public void setYggh(String yggh) {
        this.yggh = yggh;
    }

    public String getXusname() {
        return xusname;
    }

    public void setXusname(String xusname) {
        this.xusname = xusname;
    }

    public Integer getMornings() {
        return mornings;
    }

    public void setMornings(Integer mornings) {
        this.mornings = mornings;
    }

    public Integer getAfters() {
        return afters;
    }

    public void setAfters(Integer afters) {
        this.afters = afters;
    }

    public Integer getOneday() {
        return oneday;
    }

    public void setOneday(Integer oneday) {
        this.oneday = oneday;
    }
}
