package com.bsoft.project.service;

import com.bsoft.common.result.Result;
import com.bsoft.project.dto.*;

import java.util.Date;
import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-01-19 10:30
 * @Version 1.0
 * @Description
 */
public interface ProjectPlanService {
    List<ProjectPlanDetailDTO> getProjectPlanDetailTree(Integer planId);

    void saveProjectPlanDetailList(List<ProjectPlanDetailDTO> projectPlanDetailDTOS);

    void deleteProjectPlanDetail(Integer id);

    ProjectPlanDTO saveProjectPlanAndDetail(ProjectPlanDTO plan, List<ProjectPlanDetailDTO> details, List<Integer> deletes);

    Result<ProjectWithPlanDTO> getProjectWithPlans(String projectManager, String context, Integer page, Integer size);

    ProjectPlanDetailDTO getProjectPlanDetail(Integer id);

    /**
     * 获取计划树
     * @param projectId 项目id
     * @param personId 工号
     * @param attendanceDate 考勤日期
     * @param part 1全部  0 部分
     * @return
     */
    List<ProjectLogPlanDetailDTO> getProjectLogPlanDetailTree(String projectId, String personId, Date attendanceDate,Integer part);

    /**
     * 获取计划查询树
     * @param contractNo 项目id
     * @param part 1全部  0 部分
     * @return
     */
    List<ProjectLogPlanDetailDTO> getProjectLogPlanDetailQueryTree(String contractNo, Integer part);

    Result<ProjectWithPlanDTO> getProjectWithPlansAndAuth(String personId, ProjectPlanQueryCndDTO paramsCnd, Integer page, Integer size);

    /**
     * 里程碑下面的计划是否全部完成
     * @param contractId 合同编号
     * @param dutyId 责任书id
     * @return
     */
    Boolean milepostPlanIsFinished(String contractId,Integer dutyId);

    /**
     * 计划数目
     * @param projectId
     * @return
     */
    Integer getProjectLogPlanCount(String projectId);
}
