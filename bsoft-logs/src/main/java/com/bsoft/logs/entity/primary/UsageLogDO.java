package com.bsoft.logs.entity.primary;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "KER_SYS_USAGELOG")
public class UsageLogDO {
    private Integer id;
    private Integer menuId;
    private String personId;
    private Date useDate;
    private String ip;

    @Id
    @SequenceGenerator(name="SEQ_KER_SYS_USAGELOG",allocationSize=1,sequenceName="SEQ_KER_SYS_USAGELOG")
    @GeneratedValue(generator="SEQ_KER_SYS_USAGELOG",strategy=GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Date getUseDate() {
        return useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
