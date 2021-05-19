package com.bsoft.hr.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/26 15:56
 * @Description
 */
@Entity
@Table(name="HR_SOCIAL_RECORD")
public class SocialAdjustmentRecordDO {
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
    /** 登记日期 */
    private Date submitDate;
    /** 工号 */
    private String personId;

    @Id
    @SequenceGenerator(name="SEQ_HR_SOCIAL_RECORD",allocationSize=1,sequenceName="SEQ_HR_SOCIAL_RECORD")
    @GeneratedValue(generator="SEQ_HR_SOCIAL_RECORD",strategy=GenerationType.SEQUENCE)
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

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}
