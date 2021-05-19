package com.bsoft.hr.entity.primary;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/5 10:04
 * @Description
 */
@Entity
@Table(name="BSOFT_PORTAL.HR_VACATION_LACTATION")
public class LactationDO {
    private Integer id;
    /** 工号 */
    @NotNull(message = "工号不能为空")
    private String personId;
    /** 哺乳假时长 */
    @NotNull(message = "哺乳假时长不能为空")
    private Double duration;
    /** 开始日期 */
    @NotNull(message = "开始日期 不能为空")
    private Date startDate;
    /** 结束日期 */
    @NotNull(message = "结束日期不能为空")
    private Date endDate;
    /** 登记人 */
    private String submitter;
    /** 登记日期 */
    private Date submitDate;

    @Id
    @SequenceGenerator(name="SEQ_HR_VACATION_LACTATION",allocationSize=1,sequenceName="SEQ_HR_VACATION_LACTATION")
    @GeneratedValue(generator="SEQ_HR_VACATION_LACTATION",strategy=GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
}
