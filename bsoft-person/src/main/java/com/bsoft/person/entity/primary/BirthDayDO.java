package com.bsoft.person.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 员工生日信息
 */
@Entity
@Table(name = "bsoftmis.PERSON_BIRTHINFO_VIEW")
public class BirthDayDO {
    /**
     * 工号
     */
    private String personId;
    /**
     * 姓名
     */
    private String personName;
    /**
     * 生日
     */
    private String birthDay;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 部门
     */
    private String deptNo;
    /**
     * 岗位
     */
    private String post;
    /**
     * 部门负责人邮箱
     */
    private String DeptHeadEmail;
    /**
     * 大区负责人邮箱
     */
    private String RegionaHeadEmail;
    /**
     * 大区行政主管邮箱
     */
    private String ExecutiveDirectorEmail;
    /**
     * 总助以上抄送
     */
    private String AssistantPresidentEmail;
    /**
     * 部门类别
     */
    private Integer type;
    /**
     * 调后补贴
     */
    private Integer level;

    @Id
    @Column(name = "XUSLGNAME")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Column(name = "XUSNAME")
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Column(name = "CSNY")
    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "XDNO")
    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    @Column(name = "RESTYPE")
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Column(name = "FZR")
    public String getDeptHeadEmail() {
        return DeptHeadEmail;
    }

    public void setDeptHeadEmail(String deptHeadEmail) {
        DeptHeadEmail = deptHeadEmail;
    }

    @Column(name = "QYFZ")
    public String getRegionaHeadEmail() {
        return RegionaHeadEmail;
    }

    public void setRegionaHeadEmail(String regionaHeadEmail) {
        RegionaHeadEmail = regionaHeadEmail;
    }

    @Column(name = "XZZG")
    public String getExecutiveDirectorEmail() {
        return ExecutiveDirectorEmail;
    }

    public void setExecutiveDirectorEmail(String executiveDirectorEmail) {
        ExecutiveDirectorEmail = executiveDirectorEmail;
    }

    @Column(name = "SRCS")
    public String getAssistantPresidentEmail() {
        return AssistantPresidentEmail;
    }

    public void setAssistantPresidentEmail(String assistantPresidentEmail) {
        AssistantPresidentEmail = assistantPresidentEmail;
    }

    @Column(name = "BMLB")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "DHBT")
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
