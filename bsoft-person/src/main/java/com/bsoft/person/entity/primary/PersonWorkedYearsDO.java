package com.bsoft.person.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: xucl
 * @DateTime: 2021/1/6 17:23
 * @Description:
 */
@Entity
@Table(name = "hr_person_workedyears_view")
public class PersonWorkedYearsDO {
    private Integer zpid;
    private Double workedYears;

    @Id
    public Integer getZpid() {
        return zpid;
    }

    public void setZpid(Integer zpid) {
        this.zpid = zpid;
    }

    @Column(name = "gsqgl")
    public Double getWorkedYears() {
        return workedYears;
    }

    public void setWorkedYears(Double workedYears) {
        this.workedYears = workedYears;
    }
}
