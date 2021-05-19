package com.bsoft.person.entity.primary;


import com.bsoft.dictionary.annotation.dept.DeptAllDic;
import com.bsoft.dictionary.annotation.person.ResTypeDic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HR_PERSON_BACKUP")
public class CloudschoolUserBackupDO {
    private String personId;
    private String personName;
    private String deptId;
    private String restype;
    private Integer userId;
    private String  email;
    private String isValid; //1离职

    @Id
    @Column(name = "xuslgname")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
    @Column(name = "xdno")
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
    @Column(name = "restype")
    public String getRestype() {
        return restype;
    }

    public void setRestype(String restype) {
        this.restype = restype;
    }

    @Column(name = "xusname")
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Column(name = "id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "flag")
    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
