package com.bsoft.person.entity.primary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hr_person_continuelearn")
public class ContinueLearnDO {
    private Integer id;
    private String personId;
    private Date startDate;
    private Date endDate;
    private String course;
    private String content;
    private String organ;
    private Integer enclosure;

    @Id
    @SequenceGenerator(name="seq_hr_person_continuelearn",allocationSize=1,sequenceName="seq_hr_person_continuelearn")
    @GeneratedValue(generator="seq_hr_person_continuelearn",strategy=GenerationType.SEQUENCE)
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public Integer getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Integer enclosure) {
        this.enclosure = enclosure;
    }
}
