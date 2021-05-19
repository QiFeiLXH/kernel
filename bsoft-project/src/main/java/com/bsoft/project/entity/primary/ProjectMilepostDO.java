package com.bsoft.project.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author zhanglf
 * @Date 2020-01-19 15:11
 * @Version 1.0
 * @Description
 */
@Entity
@Table(name = "bsoftmis.pro_milepost")
public class ProjectMilepostDO {
    private Integer id;
    private Integer batchFlag;
    private String name;
    private Integer stage;
    private Integer logoff;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBatchFlag() {
        return batchFlag;
    }

    public void setBatchFlag(Integer batchFlag) {
        this.batchFlag = batchFlag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLogoff() {
        return logoff;
    }

    public void setLogoff(Integer logoff) {
        this.logoff = logoff;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }
}
