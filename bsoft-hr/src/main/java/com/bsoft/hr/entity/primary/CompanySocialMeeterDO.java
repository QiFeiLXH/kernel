package com.bsoft.hr.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/26 13:05
 * @Description
 */
@Entity
@Table(name="HR_COMPANY_SOCIAL")
public class CompanySocialMeeterDO {
    @Id
    /** 社保缴纳地id */
    private Integer id;
    /** 社保缴纳地编码 */
    private String code;
    /** 社保对接人工号 */
    private String meeter;
    /** 社保对接人姓名 */
    private String meeterName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMeeter() {
        return meeter;
    }

    public void setMeeter(String meeter) {
        this.meeter = meeter;
    }

    public String getMeeterName() {
        return meeterName;
    }

    public void setMeeterName(String meeterName) {
        this.meeterName = meeterName;
    }
}
