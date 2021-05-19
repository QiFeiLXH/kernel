package com.bsoft.hr.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bsoftmis.xtuser")
public class PersonNameDO {
    @Id
    @Column(name = "xuslgname")
    private String  XUSLGNAME ;

    /** 姓名*/
    @Column(name = "xusname")
    private String   XUSNAME;

    /** 邮箱*/
    @Column(name = "email")
    private String   email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getXUSLGNAME() {
        return XUSLGNAME;
    }

    public void setXUSLGNAME(String XUSLGNAME) {
        this.XUSLGNAME = XUSLGNAME;
    }

    public String getXUSNAME() {
        return XUSNAME;
    }

    public void setXUSNAME(String XUSNAME) {
        this.XUSNAME = XUSNAME;
    }


}
