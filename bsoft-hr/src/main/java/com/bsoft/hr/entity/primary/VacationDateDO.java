package com.bsoft.hr.entity.primary;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author: zy
 * @date: 2020/9/11
 * @description 节假日
 */
@Entity
@Table(name = "bsoftmis.rs_fgzr")
public class VacationDateDO {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "kqrq")
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
