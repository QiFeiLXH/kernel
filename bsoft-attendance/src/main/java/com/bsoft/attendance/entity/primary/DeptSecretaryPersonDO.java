package com.bsoft.attendance.entity.primary;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/8 9:47
 * @Description 部门文秘
 */
public class DeptSecretaryPersonDO {
    /** 员工工号 */
    private String personId;
    /** 员工姓名 */
    private String personName;
    /** 部门代码 */
    private String deptCode;
    /** 部门名称 */
    private String deptName;
    /** 邮件地址 */
    private String email;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
