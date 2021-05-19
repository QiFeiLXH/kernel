package com.bsoft.work.entity.primary;

import javax.persistence.*;

/**
 * @author ding cj
 * @date 2021/5/13 20:12
 */
@Entity
@Table(name = "POL_Manager")
public class ManagerDO {
    /**
     * 主键
     */
    @Id
    @SequenceGenerator(name = "seq_pol_manager", allocationSize = 1, sequenceName = "seq_pol_manager")
    @GeneratedValue(generator = "seq_pol_manager", strategy = GenerationType.SEQUENCE)
    private Integer id;

    /**
     * 委员会id
     */
    private Integer councilId;

    /**
     * 工号
     */
    private Integer personId;

    /**
     * 姓名
     */
    @Transient
    private String personName;

    /**
     * 部门
     */
    @Transient
    private String dept;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCouncilId() {
        return councilId;
    }

    public void setCouncilId(Integer councilId) {
        this.councilId = councilId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
