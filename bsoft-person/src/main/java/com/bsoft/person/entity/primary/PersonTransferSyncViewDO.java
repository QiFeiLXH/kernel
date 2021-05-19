package com.bsoft.person.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "HR_PERSON_TRANSFER_SCHOOL_VIEW")
public class PersonTransferSyncViewDO {
    //员工工号
    private String personId;
    //员工姓名
    private String personName;
    //邮箱
    private String email;
    //所属部门
    private String deptId;
    //所属岗位
    private String restype;
    //调动日期
    private Date transferDate;

    @Id
    @Column(name = "xuslgname")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Column(name = "xusname")
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Column(name = "dhbm")
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getRestype() {
        return restype;
    }

    public void setRestype(String restype) {
        this.restype = restype;
    }

    @Column(name = "ddrq")
    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

}
