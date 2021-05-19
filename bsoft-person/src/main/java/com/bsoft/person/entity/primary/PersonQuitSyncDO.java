package com.bsoft.person.entity.primary;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Bsoftmis.t_dimission")
public class PersonQuitSyncDO {

    //员工工号
    private String yggh;

    //申请日期
    private Date sqrq;

    //离职日期

    private Date lzrq;

    //

    @Id
    @Column(name = "yggh")
    public String getYggh() {
        return yggh;
    }

    public void setYggh(String yggh) {
        this.yggh = yggh;
    }

    @Column(name = "sqrq")
    public Date getSqrq() {
        return sqrq;
    }

    public void setSqrq(Date sqrq) {
        this.sqrq = sqrq;
    }

    @Column(name = "lzrq")
    public Date getLzrq() {
        return lzrq;
    }

    public void setLzrq(Date lzrq) {
        this.lzrq = lzrq;
    }
}
