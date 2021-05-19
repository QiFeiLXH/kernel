package com.bsoft.hr.entity.primary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="HR_VACATION_REDUCE")
public class VacationReduceDO {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 使用年份
     */
    private String year;
    /**
     * 使用年假天数
     */
    private Integer days;
    /**
     * 备注
     */
    private String remark;
    /**
     * 登记人
     */
    private String registrant;
    /**
     * 登记时间
     */
    private Date registDate;

    /**
     * 执行标志 0.未执行  1.已执行
     */
    private Integer flag;

    @Id
    @SequenceGenerator(name="SEQ_HR_VACATION_REDUCE",allocationSize=1,sequenceName="SEQ_HR_VACATION_REDUCE")
    @GeneratedValue(generator="SEQ_HR_VACATION_REDUCE",strategy=GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
