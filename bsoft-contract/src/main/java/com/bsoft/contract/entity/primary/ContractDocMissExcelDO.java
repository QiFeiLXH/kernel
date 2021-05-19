package com.bsoft.contract.entity.primary;

import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/12/22 11:07
 * @Description:
 */
public class ContractDocMissExcelDO {
    private String sqrname;
    private Date sqrq;
    private String contractNo;
    private String bm1Text;
    private String xsqyText;
    private String khmc;
    private Double hte;
    private String qydwmc;
    private Date khrq;
    private String shrname;
    private String htyj;
    private String zbtzs;
    private String htpsb;
    private String htwb;
    private List<String> sjrEmail;
    private List<String> csrEmail;
    private String sjrName;

    public List<String> getSjrEmail() {
        return sjrEmail;
    }

    public void setSjrEmail(List<String> sjrEmail) {
        this.sjrEmail = sjrEmail;
    }

    public List<String> getCsrEmail() {
        return csrEmail;
    }

    public void setCsrEmail(List<String> csrEmail) {
        this.csrEmail = csrEmail;
    }

    public String getSjrName() {
        return sjrName;
    }

    public void setSjrName(String sjrName) {
        this.sjrName = sjrName;
    }

    public String getSqrname() {
        return sqrname;
    }

    public void setSqrname(String sqrname) {
        this.sqrname = sqrname;
    }

    public Date getSqrq() {
        return sqrq;
    }

    public void setSqrq(Date sqrq) {
        this.sqrq = sqrq;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getBm1Text() {
        return bm1Text;
    }

    public void setBm1Text(String bm1Text) {
        this.bm1Text = bm1Text;
    }

    public String getXsqyText() {
        return xsqyText;
    }

    public void setXsqyText(String xsqyText) {
        this.xsqyText = xsqyText;
    }

    public String getKhmc() {
        return khmc;
    }

    public void setKhmc(String khmc) {
        this.khmc = khmc;
    }

    public Double getHte() {
        return hte;
    }

    public void setHte(Double hte) {
        this.hte = hte;
    }

    public String getQydwmc() {
        return qydwmc;
    }

    public void setQydwmc(String qydwmc) {
        this.qydwmc = qydwmc;
    }

    public Date getKhrq() {
        return khrq;
    }

    public void setKhrq(Date khrq) {
        this.khrq = khrq;
    }

    public String getShrname() {
        return shrname;
    }

    public void setShrname(String shrname) {
        this.shrname = shrname;
    }

    public String getHtyj() {
        return htyj;
    }

    public void setHtyj(String htyj) {
        this.htyj = htyj;
    }

    public String getZbtzs() {
        return zbtzs;
    }

    public void setZbtzs(String zbtzs) {
        this.zbtzs = zbtzs;
    }

    public String getHtpsb() {
        return htpsb;
    }

    public void setHtpsb(String htpsb) {
        this.htpsb = htpsb;
    }

    public String getHtwb() {
        return htwb;
    }

    public void setHtwb(String htwb) {
        this.htwb = htwb;
    }
}
