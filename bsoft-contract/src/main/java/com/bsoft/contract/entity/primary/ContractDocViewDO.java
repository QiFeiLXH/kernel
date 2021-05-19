package com.bsoft.contract.entity.primary;

import com.bsoft.contract.key.ContractDocViewKey;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/12/9 17:29
 * @Description:
 */
@Entity
@Table(name = "con_contractdocmiss_view")
@IdClass(ContractDocViewKey.class)
public class ContractDocViewDO {
    private String khbm;
    private String khmc;
    private Double hte;
    private String htbh;
    private Integer tbid;
    private String htmc;
    private String contractNo;
    private Date khrq;
    private Integer htlx;
    private Integer zbbz;
    private Integer yjyw;
    private Integer withnotice;
    private Integer wdid;
    private Integer wdsl;
    private String gdr;
    private String gdrname;
    private String gdrEmail;
    private String sqr;
    private String sqrname;
    private String sqrEmail;
    private Date sqrq;
    private String shr;
    private String shrEmail;
    private String shrName;
    private String djry;
    private String djrname;
    private String djryEmail;
    private String qdbm;
    private String xqzjl;
    private String xqzjlEmail;
    private String dqzjl;
    private String dqzjlEmail;
    private String xqxsfzr;
    private String xqxsfzrEmail;
    private String dqxsfzr;
    private String dqxsfzrEmail;
    private String xsb;
    private String xsbEmail;
    private String ssqy;
    private String ssqyText;
    private String bm1;
    private String bm1Text;
    private String qydw;
    private String qydwmc;

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

    public Date getSqrq() {
        return sqrq;
    }

    public void setSqrq(Date sqrq) {
        this.sqrq = sqrq;
    }

    public String getSsqy() {
        return ssqy;
    }

    public void setSsqy(String ssqy) {
        this.ssqy = ssqy;
    }

    public String getSsqyText() {
        return ssqyText;
    }

    public void setSsqyText(String ssqyText) {
        this.ssqyText = ssqyText;
    }

    public String getBm1() {
        return bm1;
    }

    public void setBm1(String bm1) {
        this.bm1 = bm1;
    }

    public String getBm1Text() {
        return bm1Text;
    }

    public void setBm1Text(String bm1Text) {
        this.bm1Text = bm1Text;
    }

    public String getQydw() {
        return qydw;
    }

    public void setQydw(String qydw) {
        this.qydw = qydw;
    }

    public String getQydwmc() {
        return qydwmc;
    }

    public void setQydwmc(String qydwmc) {
        this.qydwmc = qydwmc;
    }

    public String getDjrname() {
        return djrname;
    }

    public void setDjrname(String djrname) {
        this.djrname = djrname;
    }

    public String getSqrname() {
        return sqrname;
    }

    public void setSqrname(String sqrname) {
        this.sqrname = sqrname;
    }

    public String getShrName() {
        return shrName;
    }

    public void setShrName(String shrName) {
        this.shrName = shrName;
    }

    public String getKhbm() {
        return khbm;
    }

    public void setKhbm(String khbm) {
        this.khbm = khbm;
    }

    @Id
    public String getHtbh() {
        return htbh;
    }

    public void setHtbh(String htbh) {
        this.htbh = htbh;
    }

    public Integer getTbid() {
        return tbid;
    }

    public void setTbid(Integer tbid) {
        this.tbid = tbid;
    }

    public String getHtmc() {
        return htmc;
    }

    public void setHtmc(String htmc) {
        this.htmc = htmc;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Date getKhrq() {
        return khrq;
    }

    public void setKhrq(Date khrq) {
        this.khrq = khrq;
    }

    public Integer getHtlx() {
        return htlx;
    }

    public void setHtlx(Integer htlx) {
        this.htlx = htlx;
    }

    public Integer getYjyw() {
        return yjyw;
    }

    public void setYjyw(Integer yjyw) {
        this.yjyw = yjyw;
    }

    public Integer getWithnotice() {
        return withnotice;
    }

    public void setWithnotice(Integer withnotice) {
        this.withnotice = withnotice;
    }

    @Id
    public Integer getWdid() {
        return wdid;
    }

    public void setWdid(Integer wdid) {
        this.wdid = wdid;
    }

    public Integer getWdsl() {
        return wdsl;
    }

    public void setWdsl(Integer wdsl) {
        this.wdsl = wdsl;
    }

    public String getGdr() {
        return gdr;
    }

    public void setGdr(String gdr) {
        this.gdr = gdr;
    }

    public String getGdrEmail() {
        return gdrEmail;
    }

    public void setGdrEmail(String gdrEmail) {
        this.gdrEmail = gdrEmail;
    }

    public String getSqr() {
        return sqr;
    }

    public void setSqr(String sqr) {
        this.sqr = sqr;
    }

    public String getSqrEmail() {
        return sqrEmail;
    }

    public void setSqrEmail(String sqrEmail) {
        this.sqrEmail = sqrEmail;
    }

    public String getShr() {
        return shr;
    }

    public void setShr(String shr) {
        this.shr = shr;
    }

    public String getShrEmail() {
        return shrEmail;
    }

    public void setShrEmail(String shrEmail) {
        this.shrEmail = shrEmail;
    }

    public String getDjry() {
        return djry;
    }

    public void setDjry(String djry) {
        this.djry = djry;
    }

    public String getDjryEmail() {
        return djryEmail;
    }

    public void setDjryEmail(String djryEmail) {
        this.djryEmail = djryEmail;
    }

    public String getQdbm() {
        return qdbm;
    }

    public void setQdbm(String qdbm) {
        this.qdbm = qdbm;
    }

    public String getXqzjl() {
        return xqzjl;
    }

    public void setXqzjl(String xqzjl) {
        this.xqzjl = xqzjl;
    }

    public String getXqzjlEmail() {
        return xqzjlEmail;
    }

    public void setXqzjlEmail(String xqzjlEmail) {
        this.xqzjlEmail = xqzjlEmail;
    }

    public String getDqzjl() {
        return dqzjl;
    }

    public void setDqzjl(String dqzjl) {
        this.dqzjl = dqzjl;
    }

    public String getDqzjlEmail() {
        return dqzjlEmail;
    }

    public void setDqzjlEmail(String dqzjlEmail) {
        this.dqzjlEmail = dqzjlEmail;
    }

    public String getXqxsfzr() {
        return xqxsfzr;
    }

    public void setXqxsfzr(String xqxsfzr) {
        this.xqxsfzr = xqxsfzr;
    }

    public String getXqxsfzrEmail() {
        return xqxsfzrEmail;
    }

    public void setXqxsfzrEmail(String xqxsfzrEmail) {
        this.xqxsfzrEmail = xqxsfzrEmail;
    }

    public String getDqxsfzr() {
        return dqxsfzr;
    }

    public void setDqxsfzr(String dqxsfzr) {
        this.dqxsfzr = dqxsfzr;
    }

    public String getDqxsfzrEmail() {
        return dqxsfzrEmail;
    }

    public void setDqxsfzrEmail(String dqxsfzrEmail) {
        this.dqxsfzrEmail = dqxsfzrEmail;
    }

    public String getXsb() {
        return xsb;
    }

    public void setXsb(String xsb) {
        this.xsb = xsb;
    }

    public String getXsbEmail() {
        return xsbEmail;
    }

    public void setXsbEmail(String xsbEmail) {
        this.xsbEmail = xsbEmail;
    }

    public Integer getZbbz() {
        return zbbz;
    }

    public void setZbbz(Integer zbbz) {
        this.zbbz = zbbz;
    }

    public String getGdrname() {
        return gdrname;
    }

    public void setGdrname(String gdrname) {
        this.gdrname = gdrname;
    }
}
