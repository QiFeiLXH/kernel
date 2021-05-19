package com.bsoft.person.entity.primary;


import java.util.List;

/**
 * @Auther: hy
 * @Date: 2020/5/19
 * @Description:
 */
public class EmployAuditDO {

    private EmployViewDO recruitmentInfoView;

    private List<FamilyPersonViewDO> familyList;

    private List<EducationViewDO> educationList;

    private List<WorkDO> workList;

    public EmployViewDO getRecruitmentInfoView() {
        return recruitmentInfoView;
    }

    public void setRecruitmentInfoView(EmployViewDO recruitmentInfoView) {
        this.recruitmentInfoView = recruitmentInfoView;
    }

    public List<FamilyPersonViewDO> getFamilyList() {
        return familyList;
    }

    public void setFamilyList(List<FamilyPersonViewDO> familyList) {
        this.familyList = familyList;
    }

    public List<EducationViewDO> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<EducationViewDO> educationList) {
        this.educationList = educationList;
    }

    public List<WorkDO> getWorkList() {
        return workList;
    }

    public void setWorkList(List<WorkDO> workList) {
        this.workList = workList;
    }
}
