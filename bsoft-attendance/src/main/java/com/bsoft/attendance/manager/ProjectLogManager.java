package com.bsoft.attendance.manager;

import com.bsoft.attendance.condition.ProjectLogQueryCnd;
import com.bsoft.attendance.entity.primary.*;
import com.bsoft.attendance.condition.WorkLogAuditCnd;
import com.bsoft.project.entity.primary.ProjectBaseDO;
import com.bsoft.attendance.dto.ProjectLogBaseDTO;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ProjectLogManager {
    ProjectBaseDO getLastestProjectBase(String personId);

    //查找最近几天日志填写情况
    List<ProjectLogSituationDO> getLastSituation(String personId, Integer days);

    List<ProjectLogDO> getProjectWorkLogsWithNoTechnum(String projectId, String personId, java.util.Date attendanceDate);

    int getProjectLogSituation(String submitter, java.util.Date attendanceDate);

    List<ProjectLogDO> saveProjectLogsAndWorkLogs(String personId, ProjectLogBaseDTO projectLogBaseDTO, List<ProjectLogDO> logs,Integer flag);

    String getLeaderOrProjectManager(String submitter,String projectId);

    List<ProjectLogDO> saveProjectLogs(List<ProjectLogDO> projectLogs);

    List<ProjectLogDO> getProjectWorkLogs(String projectId, String personId, Integer milepostId, java.util.Date attendanceDate);

    List<ProjectLogViewDO> getProjectWorkLogs(String personId,Date attendance);

    PageInfo<ProjectBaseDO> searchProjectsWithCommon(String personId,String context,Integer pageNo, Integer pageSize);

    ProjectLogDO getProjectLog(Integer id);

    void deleteProjectLog(Integer id);

    List<ProjectLogDO> getByMilepostId(List<Integer> milePostId);

    void auditProjectLog(ProjectLogAuditDO projectLogAudit);

    ProjectLogAuditDO processProjectLogType(ProjectLogAuditDO projectLogAudit);

    Page<ProjectPlanQueryLogDO> getProjectPlanQueryLogList(Integer pageSize, Integer pageNo, Integer milepostId, String contractNo);

    Page<ProjectLogNeedAuditDO> getProjectLogNeedAudit(String auditter, WorkLogAuditCnd params, Integer page, Integer size);

    ProjectLogNeedDealCountDO getWorkLogsCount(String userId);

    List<ProjectLogNeedAuditDO> getRegionAuditList(String smallRegion);

    List<Map<String, Object>> getRegionAuditCount();

    PageInfo<ProjectWithAuditDO> getProjectWithAuditList(String userId,WorkLogAuditCnd workLogAuditCnd,Integer pageNo,Integer pageSize);

    Integer countProjectWithAuditCount(String userId);

    Integer getProjectLogAuditCount(Integer projectLogId);

    void endProjectLog();

    List<ProjectLogDO> getNeedEndProjectLog();

    void endEditProjectLog();

    void endAuditProjectLog();

    void changeProjectLogAudit(String contractno);

    PageInfo<ProjectLogQueryProjectDO> getProjectLogQueryProjectList(ProjectLogQueryCnd cnd);

    Page<ProjectLogQueryDetailDO> getProjectLogQueryLogList(ProjectLogQueryCnd cnd, String inputContent, String projectId);

    Integer countProjectLogs(String personId);

    List<ProjectBaseDO> getCommonProjects(String personId);

    void replaceDifferentProjectManager();
}
