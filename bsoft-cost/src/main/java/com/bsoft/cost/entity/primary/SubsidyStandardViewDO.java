package com.bsoft.cost.entity.primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/11/19 17:23
 * @Description:
 */
@Entity
@Table(name = "FIN_SUBSIDY_STANDARD_VIEW")
public class SubsidyStandardViewDO {
    private Integer id;
    private String personId;
    private String personName;
    private String pycode;
    private String organizCode;
    private String deptName;
    private String projectId;
    private String projectName;
    private String projectPYCode;
    private String contractNo;
    private String area;
    private String areaText;
    private String province;
    private String provinceText;
    private String city;
    private String cityText;
    private String county;
    private String countyText;
    private Double outProvince;
    private Double inProvince;
    private Double inCity;
    private String remarks;
    private Date applydate;
    private String registrant;
    private String registrantName;
    private Integer state;
    private Integer flag;
    private Integer logoff;
    private String voider;
    private String voiderName;
    private Date voiderDate;

    @Id
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

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getOrganizCode() {
        return organizCode;
    }

    public void setOrganizCode(String organizCode) {
        this.organizCode = organizCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaText() {
        return areaText;
    }

    public void setAreaText(String areaText) {
        this.areaText = areaText;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvinceText() {
        return provinceText;
    }

    public void setProvinceText(String provinceText) {
        this.provinceText = provinceText;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityText() {
        return cityText;
    }

    public void setCityText(String cityText) {
        this.cityText = cityText;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountyText() {
        return countyText;
    }

    public void setCountyText(String countyText) {
        this.countyText = countyText;
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

    public String getRegistrantName() {
        return registrantName;
    }

    public void setRegistrantName(String registrantName) {
        this.registrantName = registrantName;
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

    public String getPycode() {
        return pycode;
    }

    public void setPycode(String pycode) {
        this.pycode = pycode;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Integer getLogoff() {
        return logoff;
    }

    public void setLogoff(Integer logoff) {
        this.logoff = logoff;
    }

    public String getProjectPYCode() {
        return projectPYCode;
    }

    public void setProjectPYCode(String projectPYCode) {
        this.projectPYCode = projectPYCode;
    }

    public String getVoider() {
        return voider;
    }

    public void setVoider(String voider) {
        this.voider = voider;
    }

    public String getVoiderName() {
        return voiderName;
    }

    public void setVoiderName(String voiderName) {
        this.voiderName = voiderName;
    }

    public Date getVoiderDate() {
        return voiderDate;
    }

    public void setVoiderDate(Date voiderDate) {
        this.voiderDate = voiderDate;
    }
}
