package com.bsoft.logs.entity.primary;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "KER_SYS_LOGINLOG")
public class LoginLogDO {
    private Integer id;
    @NotNull(message = "工号不能为空")
    private String personId;
    private String passWord;
    private Date useDate;
    private String ip;
    private Integer status;
    private String bz;

    @Id
    @SequenceGenerator(name="SEQ_KER_SYS_LOGINLOG",allocationSize=1,sequenceName="SEQ_KER_SYS_LOGINLOG")
    @GeneratedValue(generator="SEQ_KER_SYS_LOGINLOG",strategy= GenerationType.SEQUENCE)
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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }
}
