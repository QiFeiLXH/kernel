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
@Table(name="HR_PERSON_SOCIAL_VIEW")
public class PersonSocialPlaceViewDO {
    @Id
    /** 工号 */
    private String personId;
    private String personName;
    /** 拼音简码 */
    private String simpleCode;
    /** 部门id */
    private String deptId;
    private String deptName;
    /** 部门类别 */
    private Integer deptType;
    /** 是否离职 */
    private String valid;
    /** 社保缴纳地id */
    private Integer nowPlace;
    private Integer place;
    /** 社保缴纳地名称 */
    private String nowPlaceName;
    private String placeName;
    /** 社保缴纳地简称 */
    private String abbreviation;
    /** 现社保缴纳地对接人id */
    private String nowMeeter;
    private String nowMeeterName;
    /** 社保缴纳地对接人id */
    private String meeter;
    private String meeterName;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public Integer getNowPlace() {
        return nowPlace;
    }

    public void setNowPlace(Integer nowPlace) {
        this.nowPlace = nowPlace;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public String getNowPlaceName() {
        return nowPlaceName;
    }

    public void setNowPlaceName(String nowPlaceName) {
        this.nowPlaceName = nowPlaceName;
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

    public String getNowMeeter() {
        return nowMeeter;
    }

    public void setNowMeeter(String nowMeeter) {
        this.nowMeeter = nowMeeter;
    }

    public String getNowMeeterName() {
        return nowMeeterName;
    }

    public void setNowMeeterName(String nowMeeterName) {
        this.nowMeeterName = nowMeeterName;
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

    public Integer getDeptType() {
        return deptType;
    }

    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }
}
