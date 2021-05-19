package com.bsoft.person.entity.primary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hr_person_certificate")
public class WorkCertificateDO {
    private Integer id;
    private String personId;
    private Date getDate;
    private String cerName;
    private String cerNum;
    private String organ;
    private Integer enclosure;

    @Id
    @SequenceGenerator(name="seq_hr_person_certificate",allocationSize=1,sequenceName="seq_hr_person_certificate")
    @GeneratedValue(generator="seq_hr_person_certificate",strategy=GenerationType.SEQUENCE)
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

    public String getCerName() {
        return cerName;
    }

    public void setCerName(String cerName) {
        this.cerName = cerName;
    }

    public String getCerNum() {
        return cerNum;
    }

    public void setCerNum(String cerNum) {
        this.cerNum = cerNum;
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
