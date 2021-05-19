package com.bsoft.hr.entity.primary;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/14 9:43
 * @Description 员工股份
 */
@Entity
@Table(name="BSOFTMIS.PERSON_STOCK")
public class PersonStockDO {
    private Integer id;
    /** 工号 */
    private String personId;
    /** 备注 */
    private String remark;
    /** 登记人 */
    private String register;
    /** 登记日期 */
    private Date registerDate;
    /** 注销 */
    private Integer logout;

    @Id
    @SequenceGenerator(name="BSOFTMIS.SEQ_PERSON_STOCK",allocationSize=1,sequenceName="BSOFTMIS.SEQ_PERSON_STOCK")
    @GeneratedValue(generator="BSOFTMIS.SEQ_PERSON_STOCK",strategy=GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="yggh")
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Column(name="bz")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(name="djry")
    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    @Column(name="djrq")
    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getLogout() {
        return logout;
    }

    public void setLogout(Integer logout) {
        this.logout = logout;
    }
}
