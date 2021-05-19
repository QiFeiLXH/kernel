package com.bsoft.project.manager;

import com.bsoft.project.condition.ProjectPlanQueryCnd;
import com.bsoft.project.entity.primary.ProjectLogPlanDetailDO;
import com.bsoft.project.entity.primary.ProjectPlanDO;
import com.bsoft.project.entity.primary.ProjectPlanDetailDO;
import com.bsoft.project.entity.primary.ProjectWithPlanDO;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-01-19 16:41
 * @Version 1.0
 * @Description
 */
public interface ProjectPlanManager {
    /**
     * 保存计划
     * @param projectPlanDO
     * @return
     */
    ProjectPlanDO saveProjectPlan(ProjectPlanDO projectPlanDO);

    /**
     * 保存计划明细
     * @param projectPlanDetailDO
     * @return
     */
    ProjectPlanDetailDO saveProjectPlanDetail(ProjectPlanDetailDO projectPlanDetailDO);

    /**
     * 保存计划明细列表
     * @param details
     * @return
     */
    void saveProjectPlanDetails(List<ProjectPlanDetailDO> details);

    /**
     * 删除计划明细
     * @param id
     * @return
     */
    void deleteProjectPlanDetail(Integer id);
    /**
     * 根据ID获取计划
     * @param id 计划id
     * @return
     */
    ProjectPlanDO getProjectPlan(Integer id);

    /**
     * 根据项目经理获取对应项目和计划信息。
     * @param projectManager 项目经理
     * @param page 页号
     * @param size 条数
     * @return
     */
    Page<ProjectWithPlanDO> getProjectWithPlans(String projectManager,String context,Integer page,Integer size);

    /**
     * 根据项目经理获取对应项目和计划信息。
     * @param personId 项目经理
     * @param cnds 查询条件
     * @return
     */
    PageInfo<ProjectWithPlanDO> getProjectWithPlansAndAuth(String personId, ProjectPlanQueryCnd cnds, Integer page, Integer size);

    /**
     * 根据计划ID获取项目计划列表
     * @param planId 计划ID
     * @return
     */
    List<ProjectPlanDetailDO> getProjectPlanDetails(Integer planId);

    /**
     * 根据ID获取项目计划
     * @param id ID
     * @return
     */
    ProjectPlanDetailDO getProjectPlanDetail(Integer id);

    /**
     * 根据计划ID获取项目计划树
     * @param planId 计划ID
     * @return
     */
    List<ProjectPlanDetailDO> getProjectPlanDetailTree(Integer planId);

    /**
     * 根据合同号获取项目计划树
     * @param contractNo 合同编号
     * @return
     */
    List<ProjectLogPlanDetailDO> getProjectLogPlanDetailTree(String contractNo,String personId,Date attendanceDate,Integer part);

    /**
     * 根据合同号获取项目计划树
     * @param contractNo 合同编号
     * @return
     */
    List<ProjectLogPlanDetailDO> getProjectLogPlanDetailQueryTree(String contractNo, Integer part);

    /**
     * 获取模板树
     * @return
     */
    List<ProjectPlanDetailDO> getProjectPlanTemplate();

    /**
     * 保存计划和明细
     * @return
     */
    ProjectPlanDO savePlanAndDetail(ProjectPlanDO plan,List<ProjectPlanDetailDO> details,List<Integer> deletes);

    List<ProjectPlanDetailDO> detailTreeToList(List<ProjectPlanDetailDO> tree);

    /**
     * 里程碑下面的计划是否全部完成
     * @param contractId 合同编号
     * @param dutyId 责任书id
     * @return
     */
    Boolean milepostPlanIsFinished(String contractId,Integer dutyId);

    /**
     * 计划数目
     * @param projectId 项目id
     * @return
     */
    Integer getProjectLogPlanCount(String projectId);
}
