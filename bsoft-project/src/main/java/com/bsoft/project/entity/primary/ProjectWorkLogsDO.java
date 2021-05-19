package com.bsoft.project.entity.primary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BSOFTMIS.KQ_GZRZ")
public class ProjectWorkLogsDO {
    private Integer id; //主键

    private String projectId; //归属项目

    private Date submitDate; //提交时间

    private Date attendanceDate;//考勤日期


    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name = "gsxm")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }


    @Column(name = "attendancedate")
    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    @Column(name = "tjsj")
    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }
}
