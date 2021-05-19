package com.bsoft.hr.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/26 13:05
 * @Description
 */
@Entity
@Table(name="HR_COMPANY_SOCIAL_VIEW")
public class CompanySocialMeeterViewDO {
    @Id
    /** 社保缴纳地id */
    private Integer id;
    /** 社保缴纳地编码 */
    private String code;
    /** 社保缴纳地名称 */
    private String placeName;
    /** 社保缴纳地简称 */
    private String abbreviation;
    /** 社保缴纳地简拼 */
    private String simpleCode;
    /** 子公司*/
    private Integer subsidiary;
    /** 是否社保缴纳地公司*/
    private Integer socialCompanyFlag;
    /** 社保对接人工号 */
    private String meeter;
    /** 社保对接人姓名 */
    private String meeterName;
    /** 注销标志 */
    private Integer signOff;
    /** 排列序号 */
    private Integer sortNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public Integer getSubsidiary() {
        return subsidiary;
    }

    public void setSubsidiary(Integer subsidiary) {
        this.subsidiary = subsidiary;
    }

    public Integer getSocialCompanyFlag() {
        return socialCompanyFlag;
    }

    public void setSocialCompanyFlag(Integer socialCompanyFlag) {
        this.socialCompanyFlag = socialCompanyFlag;
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

    public Integer getSignOff() {
        return signOff;
    }

    public void setSignOff(Integer signOff) {
        this.signOff = signOff;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }
}
