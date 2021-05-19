package com.bsoft.common.entity.primary;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "bsoftmis.WH_GSJG")
public class CompanyDO {
    private Integer companyId;
    private String companyName;
    private Integer parentCompanyId;
    private Integer sort;
    private String pinyinCode;
    private Integer subsidiary;
    private String taxno;
    @Length(max = 100,message = "地址超过100位")
    private String address;
    private String phone;
    private Integer signOff;
    @Length(max = 30,message = "单位简称超过30位")
    private String abbreviation;
    private Integer reimbursement;
    @Length(max = 50,message = "单位编码超过50位")
    private String unitcode;
    @Length(max = 150,message = "备注信息超过150位")
    private String remarks;
    private Date creationDate;
    private String purpose;
    private String province;
    private String city;
    private String county;

    @Id
    @Column(name = "JGID")
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Column(name = "JGMC")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Column(name = "SSJG")
    public Integer getParentCompanyId() {
        return parentCompanyId;
    }

    public void setParentCompanyId(Integer parentCompanyId) {
        this.parentCompanyId = parentCompanyId;
    }

    @Column(name = "PLXH")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Column(name = "PYDM")
    public String getPinyinCode() {
        return pinyinCode;
    }

    public void setPinyinCode(String pinyinCode) {
        this.pinyinCode = pinyinCode;
    }

    @Column(name = "ZGS")
    public Integer getSubsidiary() {
        return subsidiary;
    }

    public void setSubsidiary(Integer subsidiary) {
        this.subsidiary = subsidiary;
    }

    @Column(name = "TAXNO")
    public String getTaxno() {
        return taxno;
    }

    public void setTaxno(String taxno) {
        this.taxno = taxno;
    }

    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "FLAG")
    public Integer getSignOff() {
        return signOff;
    }

    public void setSignOff(Integer signOff) {
        this.signOff = signOff;
    }

    @Column(name = "ABBREVIATION")
    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Column(name = "BXBZ")
    public Integer getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(Integer reimbursement) {
        this.reimbursement = reimbursement;
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
}
