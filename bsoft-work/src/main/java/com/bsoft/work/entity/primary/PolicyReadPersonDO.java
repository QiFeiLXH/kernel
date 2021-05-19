package com.bsoft.work.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Huang GH
 * @date 2021/5/11 16:19
 */
@Entity
@Table(name = "pol_policy_read")
public class PolicyReadPersonDO {
    /**
     *主键
     */
    @Id
    @SequenceGenerator(name="seq_pol_policy_read",allocationSize=1,sequenceName="seq_pol_policy_read")
    @GeneratedValue(generator="seq_seq_pol_policy_read",strategy=GenerationType.SEQUENCE)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Date getReadDate() {
        return readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Date getDeadLineDate() {
        return deadLineDate;
    }

    public void setDeadLineDate(Date deadLineDate) {
        this.deadLineDate = deadLineDate;
    }

    /**
     * 提案Id
     */
    private Integer policyId;
    /**
     * 工号
     */
    private String personId;
    /**
     * 阅读时间
     */
    private Date readDate;
    /**
     * 状态 0未读1已读
     */
    private Integer status;
    /**
     * 部门
     */
    private String dept;
    /**
     * 员工姓名
     */
    private String personName;
    /**
     * 阅读截止日期
     */
    @Transient
    private Date deadLineDate;
}
