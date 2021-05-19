package com.bsoft.project.manager;

import com.bsoft.project.condition.ProjectDutyQueryCnd;
import com.bsoft.project.entity.primary.*;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/12 13:23
 * @Description
 */
public interface ProjectDutyManager {
    Page<ProjectDutyViewDO> getProjectDutyMaintainList(ProjectDutyQueryCnd cnd);

    Page<ProjectDutyAuditViewDO> getProjectDutyAuditList(ProjectDutyQueryCnd cnd);

    Integer getProjectDutyAuditCount(ProjectDutyQueryCnd cnd);

    Page<ProjectDutyCustomerAndProjectSelectViewDO> getProjectDutyCustomerSelectList(Integer pageNo, Integer pageSize, String userId);

    List<ProjectDutyRegionViewDO> getProjectDutyRegionList(Integer dutyId);

    Page<ProjectDutyCustomerAndProjectSelectViewDO> getProjectDutyProjectSelectList(String userId, String customerId, Integer pageNo, Integer pageSize);

    String getProjectDutyNameNo(String customerId, String year);

    void deleteProjectDuty(Integer dutyId);

    List<ProjectDutyMilepostDO> getProjectDutyMilepostList(String contractNo);

    List<ProjectDutyMilepostDO> getDutyMilepostWithPlan(String contractNo);

    List<ProjectDutyMilepostDO> getProjectDutyMileposts(String contractNo, Integer dutyId);

    List<ProjectDutyMilepostDO> getProjectDutyMileposts(Integer id);

    Integer saveProjectDutyAndRegion(ProjectDutyDO dutyDO, List<ProjectDutyRegionDO> regionDOs, String userId);

    Integer updateProjectDutyAndRegion(ProjectDutyUpdateDO dutyDO, List<ProjectDutyRegionDO> regionDOs, List<Integer> deleteRegions, List<String> contractNo);

    void auditProjectDutyList(List<ProjectDutyAuditSaveDO> auditSaveDOS,String userId);

    void saveProjectDutyMilepost(List<ProjectDutyMilepostDO> mileposts, List<Integer> deletes);

    Page<ProjectDutyMilepostViewDO> getProjectDutyMilepostList(String contractNo, Integer dutyId, Integer pageNo, Integer pageSize);

    List<ProjectDutyPaymentViewDO> getProjectDutyPayment(Integer dutyId);

    void saveProjectDutyPayment(List<ProjectDutyPaymentDO> payments, List<Integer> deletes);

    List<ProjectDutyAuditViewDO> getAllProjectDutyAuditList(ProjectDutyQueryCnd cnd);

    ProjectDutyViewDO getOneProjectDutyView(Integer dutyId);

}
