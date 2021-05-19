package com.bsoft.user.entity.primary;

public class AppBoundProportionDO {
    //公司总人数
    private Integer personCount;
    //app绑定用户数
    private Integer boundCount;
    //app绑定用户数/公司总人数  百分比
    private String  Proportion;

    public Integer getPersonCount() {
        return personCount;
    }

    public void setPersonCount(Integer personCount) {
        this.personCount = personCount;
    }

    public Integer getBoundCount() {
        return boundCount;
    }

    public void setBoundCount(Integer boundCount) {
        this.boundCount = boundCount;
    }

    public String getProportion() {
        return Proportion;
    }

    public void setProportion(String proportion) {
        Proportion = proportion;
    }
}
