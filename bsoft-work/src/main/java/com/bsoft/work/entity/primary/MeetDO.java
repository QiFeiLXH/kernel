package com.bsoft.work.entity.primary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "work_meet")
public class MeetDO {
    private Integer id;
    private String name;
    private String address;
    private Date startDate;
    private Date endDate;
    private Integer flag;
    private String meetDate;
    private String remark;
    private String subName;

    @Id
    @SequenceGenerator(name="seq_work_meet",allocationSize=1,sequenceName="seq_work_meet")
    @GeneratedValue(generator="seq_work_meet",strategy=GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getMeetDate() {
        return meetDate;
    }

    public void setMeetDate(String meetDate) {
        this.meetDate = meetDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }
}
