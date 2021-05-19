package com.bsoft.cost.entity.primary;

import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/3/3 17:35
 * @Description: 费用类别维护左侧树结构
 */
public class CostTypeDeptViewDO {
    private String bmdm;
    private String bmmc;
    private String parentBm;
    private String parentBmmc;
    private Integer isParent;
    private Integer bmlb;
    private Integer zxbz;
    private Double sl;
    private String accountCalibers;
    private List<CostTypeDeptViewDO> children;

    public String getAccountCalibers() {
        return accountCalibers;
    }

    public void setAccountCalibers(String accountCalibers) {
        this.accountCalibers = accountCalibers;
    }

    public String getParentBmmc() {
        return parentBmmc;
    }

    public void setParentBmmc(String parentBmmc) {
        this.parentBmmc = parentBmmc;
    }

    public String getBmdm() {
        return bmdm;
    }

    public void setBmdm(String bmdm) {
        this.bmdm = bmdm;
    }

    public String getBmmc() {
        return bmmc;
    }

    public void setBmmc(String bmmc) {
        this.bmmc = bmmc;
    }

    public String getParentBm() {
        return parentBm;
    }

    public void setParentBm(String parentBm) {
        this.parentBm = parentBm;
    }

    public Integer getIsParent() {
        return isParent;
    }

    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }

    public Integer getBmlb() {
        return bmlb;
    }

    public void setBmlb(Integer bmlb) {
        this.bmlb = bmlb;
    }

    public Double getSl() {
        return sl;
    }

    public void setSl(Double sl) {
        this.sl = sl;
    }

    public Integer getZxbz() {
        return zxbz;
    }

    public void setZxbz(Integer zxbz) {
        this.zxbz = zxbz;
    }

    public List<CostTypeDeptViewDO> getChildren() {
        return children;
    }

    public void setChildren(List<CostTypeDeptViewDO> children) {
        this.children = children;
    }
}
