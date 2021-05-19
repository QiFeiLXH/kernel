package com.bsoft.cost.entity.primary;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/11/19 17:14
 * @Description: 特殊津贴标准维护
 */
@Entity
@Table(name = "FIN_SUBSIDY_STANDARD")
public class SubsidyStandardDO {
    private Integer id;
    private String personId;
    private String projectId;
    private String province;
    private String city;
    private String county;
    private Double outProvince;
    private Double inProvince;
    private Double inCity;
    @Length(max = 150,message = "备注信息不能超过150个字！")
    private String remarks;
    private Date applydate;
    private String registrant;
    @NotNull
    private Integer state;
    @NotNull
    private Integer flag;
    private String voider;
    private Date voiderDate;

    @Id
    @SequenceGenerator(name="SEQ_FIN_SUBSIDY_STANDARD",allocationSize=1,sequenceName="SEQ_FIN_SUBSIDY_STANDARD")
    @GeneratedValue(generator="SEQ_FIN_SUBSIDY_STANDARD",strategy=GenerationType.SEQUENCE)
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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Double getOutProvince() {
        return outProvince;
    }

    public void setOutProvince(Double outProvince) {
        this.outProvince = outProvince;
    }

    public Double getInProvince() {
        return inProvince;
    }

    public void setInProvince(Double inProvince) {
        this.inProvince = inProvince;
    }

    public Double getInCity() {
        return inCity;
    }

    public void setInCity(Double inCity) {
        this.inCity = inCity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getApplydate() {
        return applydate;
    }

    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getVoider() {
        return voider;
    }

    public void setVoider(String voider) {
        this.voider = voider;
    }

    public Date getVoiderDate() {
        return voiderDate;
    }

    public void setVoiderDate(Date voiderDate) {
        this.voiderDate = voiderDate;
    }
}
