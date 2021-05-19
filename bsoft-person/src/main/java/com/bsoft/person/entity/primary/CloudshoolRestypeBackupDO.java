package com.bsoft.person.entity.primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HR_PERSON_RESTYPE_BACKUP")
public class CloudshoolRestypeBackupDO {
    private Integer  restype;
    private String   restypeName;
    private Integer  zxbz;

    @Id
    @Column(name = "dmsb")
    public Integer getRestype() {
        return restype;
    }

    public void setRestype(Integer restype) {
        this.restype = restype;
    }

    @Column(name = "dmmc")
    public String getRestypeName() {
        return restypeName;
    }

    public void setRestypeName(String restypeName) {
        this.restypeName = restypeName;
    }

    @Column(name = "zxbz")
    public Integer getZxbz() {
        return zxbz;
    }

    public void setZxbz(Integer zxbz) {
        this.zxbz = zxbz;
    }
}
