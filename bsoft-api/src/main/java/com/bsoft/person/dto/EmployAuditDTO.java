package com.bsoft.person.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: hy
 * @Date: 2020/5/19
 * @Description:
 */
public class EmployAuditDTO implements Serializable {

    private EmployDTO recruitmentInfoView;

    private List<FamilyPersonDTO> familyList;

    private List<EducationDTO> educationList;

    private List<WorkDTO> workList;

    public EmployDTO getRecruitmentInfoView() {
        return recruitmentInfoView;
    }

    public void setRecruitmentInfoView(EmployDTO recruitmentInfoView) {
        this.recruitmentInfoView = recruitmentInfoView;
    }

    public List<FamilyPersonDTO> getFamilyList() {
        return familyList;
    }

    public void setFamilyList(List<FamilyPersonDTO> familyList) {
        this.familyList = familyList;
    }

    public List<EducationDTO> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<EducationDTO> educationList) {
        this.educationList = educationList;
    }

    public List<WorkDTO> getWorkList() {
        return workList;
    }

    public void setWorkList(List<WorkDTO> workList) {
        this.workList = workList;
    }
}
