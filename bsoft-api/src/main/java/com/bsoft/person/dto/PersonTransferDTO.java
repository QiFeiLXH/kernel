package com.bsoft.person.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/12/30 11:01
 * @Description:
 */
public class PersonTransferDTO implements Serializable {
    private Integer id;
    private String personId;
    private String personName;
    private String pym;
    private String dept;
    private String deptText;
    private String jobCategory;//岗位大类
    private String jobCategoryText;
    private String post;//岗位职务
    private String postText;
    private Integer personnelGroup;//人员归属群
    private String personnelGroupText;
    private Integer localflag;//本地化
    private String localflagText;
    private String divisionProvince;
    private String divisionProvinceText;
    private String divisionCity;
    private String divisionCityText;
    private String divisionCounty;
    private String divisionCountyText;
    private Integer communicationSubsidy;//补贴
    private String communicationSubsidyText;
    private Integer type;//普通、实习、中层、领导、顾问、其他
    private String typeText;
    private Date graduationDate;//毕业日期
    private Date transferDate;//调动日期
    private String ssx;

    public String getSsx() {
        return ssx;
    }

    public void setSsx(String ssx) {
        this.ssx = ssx;
    }

    public String getDivisionProvinceText() {
        return divisionProvinceText;
    }

    public void setDivisionProvinceText(String divisionProvinceText) {
        this.divisionProvinceText = divisionProvinceText;
    }

    public String getDivisionCityText() {
        return divisionCityText;
    }

    public void setDivisionCityText(String divisionCityText) {
        this.divisionCityText = divisionCityText;
    }

    public String getDivisionCountyText() {
        return divisionCountyText;
    }

    public void setDivisionCountyText(String divisionCountyText) {
        this.divisionCountyText = divisionCountyText;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

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

    public String getPym() {
        return pym;
    }

    public void setPym(String pym) {
        this.pym = pym;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDeptText() {
        return deptText;
    }

    public void setDeptText(String deptText) {
        this.deptText = deptText;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getJobCategoryText() {
        return jobCategoryText;
    }

    public void setJobCategoryText(String jobCategoryText) {
        this.jobCategoryText = jobCategoryText;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public Integer getPersonnelGroup() {
        return personnelGroup;
    }

    public void setPersonnelGroup(Integer personnelGroup) {
        this.personnelGroup = personnelGroup;
    }

    public String getPersonnelGroupText() {
        return personnelGroupText;
    }

    public void setPersonnelGroupText(String personnelGroupText) {
        this.personnelGroupText = personnelGroupText;
    }

    public Integer getLocalflag() {
        return localflag;
    }

    public void setLocalflag(Integer localflag) {
        this.localflag = localflag;
    }

    public String getLocalflagText() {
        return localflagText;
    }

    public void setLocalflagText(String localflagText) {
        this.localflagText = localflagText;
    }

    public String getDivisionProvince() {
        return divisionProvince;
    }

    public void setDivisionProvince(String divisionProvince) {
        this.divisionProvince = divisionProvince;
    }

    public String getDivisionCity() {
        return divisionCity;
    }

    public void setDivisionCity(String divisionCity) {
        this.divisionCity = divisionCity;
    }

    public String getDivisionCounty() {
        return divisionCounty;
    }

    public void setDivisionCounty(String divisionCounty) {
        this.divisionCounty = divisionCounty;
    }

    public Integer getCommunicationSubsidy() {
        return communicationSubsidy;
    }

    public void setCommunicationSubsidy(Integer communicationSubsidy) {
        this.communicationSubsidy = communicationSubsidy;
    }

    public String getCommunicationSubsidyText() {
        return communicationSubsidyText;
    }

    public void setCommunicationSubsidyText(String communicationSubsidyText) {
        this.communicationSubsidyText = communicationSubsidyText;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }
}
