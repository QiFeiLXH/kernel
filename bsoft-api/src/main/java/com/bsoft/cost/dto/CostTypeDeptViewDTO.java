package com.bsoft.cost.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/3/4 9:51
 * @Description:
 */
public class CostTypeDeptViewDTO implements Serializable {
    private String bmdm;
    private String bmmc;
    private String parentBm;
    private String parentBmmc;
    private Integer isParent;
    private Integer bmlb;
    private Integer zxbz;
    private Double sl;
    private String accountCalibers;
    private List<CostTypeDeptViewDTO> children;

    public String getParentBmmc() {
        return parentBmmc;
    }

    public void setParentBmmc(String parentBmmc) {
        this.parentBmmc = parentBmmc;
    }

    public String getAccountCalibers() {
        return accountCalibers;
    }

    public void setAccountCalibers(String accountCalibers) {
        this.accountCalibers = accountCalibers;
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

    public Integer getZxbz() {
        return zxbz;
    }

    public void setZxbz(Integer zxbz) {
        this.zxbz = zxbz;
    }

    public Double getSl() {
        return sl;
    }

    public void setSl(Double sl) {
        this.sl = sl;
    }

    public List<CostTypeDeptViewDTO> getChildren() {
        return children;
    }

    public void setChildren(List<CostTypeDeptViewDTO> children) {
        this.children = children;
    }
}
