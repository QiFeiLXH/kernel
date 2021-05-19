package com.bsoft.common.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/11/26 10:45
 * @Description:
 */
@Entity
@Table(name = "bsoftmis.wh_gsjg_view")
public class CompanyViewDO {
    private Integer companyId;
    private String companyName;
    private Integer parentCompanyId;
    private String parentcompanyName;
    private Integer sort;
    private String pinyinCode;
    private Integer subsidiary;
    private String taxno;
    private String address;
    private String phone;
    private Integer signOff;
    private String abbreviation;
    private Integer reimbursement;
    private String unitcode;
    private String remarks;
    private Date creationDate;
    private String purpose;
    private String province;
    private String provinceText;
    private String city;
    private String cityText;
    private String county;
    private String countyText;
    private Integer companyType;
    private String meeter;
    private String meeterName;


    @Id
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getParentCompanyId() {
        return parentCompanyId;
    }

    public void setParentCompanyId(Integer parentCompanyId) {
        this.parentCompanyId = parentCompanyId;
    }

    public String getParentcompanyName() {
        return parentcompanyName;
    }

    public void setParentcompanyName(String parentcompanyName) {
        this.parentcompanyName = parentcompanyName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getPinyinCode() {
        return pinyinCode;
    }

    public void setPinyinCode(String pinyinCode) {
        this.pinyinCode = pinyinCode;
    }

    public Integer getSubsidiary() {
        return subsidiary;
    }

    public void setSubsidiary(Integer subsidiary) {
        this.subsidiary = subsidiary;
    }

    public String getTaxno() {
        return taxno;
    }

    public void setTaxno(String taxno) {
        this.taxno = taxno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSignOff() {
        return signOff;
    }

    public void setSignOff(Integer signOff) {
        this.signOff = signOff;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

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

    public String getProvinceText() {
        return provinceText;
    }

    public void setProvinceText(String provinceText) {
        this.provinceText = provinceText;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityText() {
        return cityText;
    }

    public void setCityText(String cityText) {
        this.cityText = cityText;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountyText() {
        return countyText;
    }

    public void setCountyText(String countyText) {
        this.countyText = countyText;
    }

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    public String getMeeter() {
        return meeter;
    }

    public void setMeeter(String meeter) {
        this.meeter = meeter;
    }

    public String getMeeterName() {
        return meeterName;
    }

    public void setMeeterName(String meeterName) {
        this.meeterName = meeterName;
    }
}
