package com.bsoft.person.entity.primary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hr_person_award")
public class AwardDO {
    private Integer id;
    private String personId;
    private Date getDate;
    private String awardName;
    private String outline;
    private String remark;
    private Integer enclosure;

    @Id
    @SequenceGenerator(name="seq_hr_person_award",allocationSize=1,sequenceName="seq_hr_person_award")
    @GeneratedValue(generator="seq_hr_person_award",strategy=GenerationType.SEQUENCE)
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

    public Date getGetDate() {
        return getDate;
    }

    public void setGetDate(Date getDate) {
        this.getDate = getDate;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Integer enclosure) {
        this.enclosure = enclosure;
    }
}
