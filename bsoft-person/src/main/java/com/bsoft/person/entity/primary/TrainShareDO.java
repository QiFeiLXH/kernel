package com.bsoft.person.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/21 13:10
 * @Description 云学堂培训-知识分享
 */
@Entity
@Table(name="HR_TRAIN_SHARE")
public class TrainShareDO {
    private Integer id;
    /** 员工工号 */
    private String personId;
    /** 所在部门 */
    private String deptId;
    /** 知识名称 */
    private String knowledgeName;
    /** 分享时间 */
    private Date shareDate;
    /** 登记人 */
    private String register;
    /** 登记日期 */
    private Date registrationDate;

    @Id
    @SequenceGenerator(name="SEQ_HR_TRAIN_SHARE",allocationSize=1,sequenceName="SEQ_HR_TRAIN_SHARE")
    @GeneratedValue(generator="SEQ_HR_TRAIN_SHARE",strategy=GenerationType.SEQUENCE)
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

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
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
