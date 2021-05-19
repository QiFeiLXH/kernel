package com.bsoft.attendance.service;

import com.bsoft.attendance.dto.*;
import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.result.Result;
import com.bsoft.project.dto.ProjectWorkLogSituationDTO;
import com.bsoft.project.dto.ProjectBaseDTO;
import com.bsoft.attendance.dto.ProjectLogDTO;
import com.bsoft.attendance.dto.ProjectLogBaseDTO;

import java.sql.Date;
import java.util.List;

public interface ProjectLogService {

    //个人工程项目日志
    List<ProjectLogDTO> getProjectWorkLogs(String projectId, String personId, Integer milepostId, Date attendanceDate);

    List<ProjectLogDTO> getProjectWorkLogs(String personId,java.util.Date attendanceDate);

    /**
     * 根据项目ID获取非支持单结构化日志
     * @param projectId 项目id
     * @param personId 工号
     * @param attendanceDate 考勤日期
     * @return
     */
    List<ProjectLogDTO> getProjectWorkLogsWithNoTechnum(String projectId, String personId, java.util.Date attendanceDate);

    /**
     * 获取非支持单结构化日志
     * @param personId 工号
     * @param attendanceDate 考勤日期
     * @return
     */
    List<ProjectLogDTO> getProjectWorkLogsWithNoTechnum( String personId, java.util.Date attendanceDate);

    int getProjectWorkLogSituation(String submitter, java.util.Date attendanceDate);

    /**
     * 保存项目日志
     * @param personId
     * @param projectLogBaseDTO
     * @param list
     * @param flag APP端录入12  门户录入5
     * @return
     */
    List<ProjectLogDTO> saveProjectLogsAndWorkLogs(String personId, ProjectLogBaseDTO projectLogBaseDTO, List<ProjectLogDTO> list,Integer flag);

    /**
     * 修改项目日志
     * @param personId
     * @param flag APP端录入12  门户录入5
     * @return
     */
    ProjectLogDTO editProjectLogAndWorkLog(String personId, String contractNo, Date attendanceDate, String projectName, ProjectLogDTO projectLog, Boolean projectChangeFlag,Integer flag);

    //最近几天日志填写情况
    List<ProjectWorkLogSituationDTO> getProjectWorkLogSituation(String personId, Integer days);

    ProjectBaseDTO getLastestProjectBase(String personId);

    Result<ProjectBaseDTO> searchProjectsWithCommon(String personId, String context, Integer pageNo, Integer pageSize);

    ProjectLogDTO getProjectLog(Integer id);

    void deleteProjectLog(Integer id);

    List<ProjectLogDTO> saveProjectLogs(List<ProjectLogDTO> logs);

    List<ProjectLogDTO> getByMilepostId(List<Integer> milePostId);

    void auditProjectLog(ProjectLogAuditDTO projectLogAuditDTO);

    void auditProjectLogs(List<ProjectLogAuditDTO> projectLogAuditDTO);

    Result<ProjectPlanQueryLogDTO> getProjectPlanQueryLogList(Integer pageSize, Integer pageNo, Integer milepostId, String contractNo);

    public Result<ProjectLogNeedAuditDTO> getProjectLogNeedAudit(String auditter, WorkLogAuditCndDTO params, Integer page, Integer size);

    ProjectLogNeedDealCountDTO getWorkLogsCount(String userId);

    Integer getProjectLogAuditCount(Integer projectLogId);

    /**
     * @Description: 获取项目日志角色
     */
    List<PublicDicDTO> getProjectLogRoles();

    /**
     * @Description: 获取项目日志类别
     */
    List<PublicDicDTO> getProjectLogTypes();

    /**
     * @Description: 根据工号获取是否拥有结构化日志
     * @param personId 工号
     */
    Boolean haveProjectLogs(String personId);

    /**
     * @Description: 根据工号获取本人所属的所有项目
     * @param userId 条件参数
     * @return List<ProjectWithAuditDTO> 待审核日志 本人所属所有项目列表
     */
    Result<ProjectWithAuditDTO> getProjectWithAuditList(String userId, WorkLogAuditCndDTO params,Integer pageNo, Integer pageSize);

    /**
     * 功能描述 根据登录人员查询日志本人填写的项目或者项目经理为登录人员的项目列表
     * params 请求参数（pageSize, PageNo, startDate, endDate, UserId）
     * @return Result<ProjectLogQueryProjectDTO>
     */
    Result<ProjectLogQueryProjectDTO> getProjectLogQueryProjectList(ProjectLogQueryCndDTO params);

    /**
     * 功能描述 根据登录人员查询日志本人填写的项目或者项目经理为登录人员的项目列表
     * @param params 请求参数（pageSize, PageNo, startDate, endDate, UserId）
     * @param inputContent 姓名或部门
     * @param projectId 项目id
     * @return Result<ProjectLogQueryProjectDTO>
     */
    Result<ProjectLogQueryDetailDTO> getProjectLogQueryLogList(ProjectLogQueryCndDTO params, String inputContent, String projectId);

    /**
     * 功能描述 获取结构化日志常用项目
     * @param personId
     * @return
     */
    List<ProjectBaseDTO> getCommonProjects(String personId);
}
