package com.bsoft.attendance.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author Xuhui Lin
 * @Date 2020/10/9 14:15
 * @Description
 */
@Entity
@Table(name="bsoft_portal.pro_worklog")
public class ProjectLogNextAuditterUpdateDO {
    @Id
    private Integer id;
    private String nextAuditter;//下一步待审人

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNextAuditter() {
        return nextAuditter;
    }

    public void setNextAuditter(String nextAuditter) {
        this.nextAuditter = nextAuditter;
    }
}
