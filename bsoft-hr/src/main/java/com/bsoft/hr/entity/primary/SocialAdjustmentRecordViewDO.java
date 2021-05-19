package com.bsoft.hr.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/27 14:40
 * @Description
 */
@Entity
@Table(name="HR_SOCIAL_RECORD_VIEW")
public class SocialAdjustmentRecordViewDO {
    @Id
    private Integer id;
    /** 月份 */
    private Date month;
    /** 社保缴纳地id */
    private Integer place;
    /** 社保对接人工号 */
    private String meeter;
    /** 社保对接人姓名 */
    private String meeterName;
    /** 登记人 */
    private String submitter;
    private String submitterName;
    /** 登记日期 */
    private Date submitDate;
    /** 缴纳地名称 */
    private String placeName;
    /** 缴纳地简称 */
    private String abbreviation;
    /** 缴纳地简称 */
    private String personId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
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

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
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

    public String getSubmitterName() {
        return submitterName;
    }

    public void setSubmitterName(String submitterName) {
        this.submitterName = submitterName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}
