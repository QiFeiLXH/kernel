package com.bsoft.hr.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: zy
 * @date: 2020/8/30
 * @description 个人打卡方式
 */
@Entity
@Table(name = "bsoftmis.sys_person_info")
public class ClockInModePersonalSaveDO {
    // 工号
    @Id
    @Column(name = "personid")
    private String personId;
    // 考勤方式
    @Column(name = "attendflag")
    private Integer attendFlagPersonal;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getAttendFlagPersonal() {
        return attendFlagPersonal;
    }

    public void setAttendFlagPersonal(Integer attendFlagPersonal) {
        this.attendFlagPersonal = attendFlagPersonal;
    }
}
