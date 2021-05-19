package com.bsoft.person.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/21 13:10
 * @Description 云学堂培训-知识分享视图
 */
@Entity
@Table(name="HR_TRAIN_SHARE_VIEW")
public class TrainShareViewDO {
    @Id
    private Integer id;
    /** 员工工号 */
    private String personId;
    /** 员工姓名 */
    private String personName;
    /** 员工姓名拼音码 */
    private String simpleCode;
    /** 所在部门 */
    private String deptId;
    /** 所在部门名称 */
    private String deptName;
    /** 知识名称 */
    private String knowledgeName;
    /** 分享时间 */
    private Date shareDate;
    @Transient
    private String shareDateStr;
    /** 登记人 */
    private String register;
    /** 登记日期 */
    private Date registrationDate;

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

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getSimpleCode() {
        return simpleCode;
    }

    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getKnowledgeName() {
        return knowledgeName;
    }

    public void setKnowledgeName(String knowledgeName) {
        this.knowledgeName = knowledgeName;
    }

    public Date getShareDate() {
        return shareDate;
    }

    public void setShareDate(Date shareDate) {
        this.shareDate = shareDate;
    }

    public String getShareDateStr() {
        return shareDateStr;
    }

    public void setShareDateStr(String shareDateStr) {
        this.shareDateStr = shareDateStr;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
