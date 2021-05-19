package com.bsoft.attendance.service.impl;

import com.bsoft.attendance.condition.ProjectLogQueryCnd;
import com.bsoft.attendance.dto.*;
import com.bsoft.attendance.entity.primary.*;
import com.bsoft.attendance.manager.AttendanceManager;
import com.bsoft.attendance.manager.ProjectLogManager;
import com.bsoft.attendance.service.ProjectLogService;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.key.KeyGenerator;
import com.bsoft.common.manager.PublicDicManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.attendance.condition.WorkLogAuditCnd;
import com.bsoft.project.dto.ProjectWorkLogSituationDTO;
import com.bsoft.project.entity.primary.ProjectBaseDO;
import com.bsoft.project.manager.ProjectGroupManager;
import com.bsoft.project.dto.ProjectBaseDTO;
import com.bsoft.attendance.dto.ProjectLogDTO;
import com.bsoft.attendance.dto.ProjectLogBaseDTO;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.sql.Date;
import java.util.Comparator;
import java.util.List;

@Service
public class ProjectLogServiceImpl implements ProjectLogService {
    private final static Logger logger = LoggerFactory.getLogger(ProjectLogServiceImpl.class);
    @Autowired
    private ProjectLogManager projectLogManager;
    @Autowired
    private IGenerator generator;
    @Autowired
    private ProjectGroupManager projectGroupManager;
    @Autowired
    private AttendanceManager attendanceManager;
    @Autowired
    private KeyGenerator keyGenerator;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private PublicDicManager publicDicManager;

    @Override
    public List<ProjectLogDTO> getProjectWorkLogs(String projectId, String personId, Integer milepostId, Date attendanceDate) {
        List<ProjectLogDO> list = projectLogManager.getProjectWorkLogs(projectId,personId, milepostId,attendanceDate);
        return generator.convert(list,ProjectLogDTO.class);
    }

    @Override
    public List<ProjectLogDTO> getProjectWorkLogs(String personId, java.util.Date attendanceDate) {
        List<ProjectLogViewDO> projectWorkLogs = projectLogManager.getProjectWorkLogs(personId, attendanceDate);
        return generator.convert(projectWorkLogs,ProjectLogDTO.class);
    }

    @Override
    public List<ProjectLogDTO> getProjectWorkLogsWithNoTechnum(String projectId, String personId, java.util.Date attendanceDate) {
        List<ProjectLogDO> list = projectLogManager.getProjectWorkLogsWithNoTechnum(projectId,personId,attendanceDate);
        return generator.convert(list,ProjectLogDTO.class);
    }

    @Override
    public List<ProjectLogDTO> getProjectWorkLogsWithNoTechnum(String personId, java.util.Date attendanceDate) {
        List<ProjectLogDO> list = projectLogManager.getProjectWorkLogsWithNoTechnum(null,personId,attendanceDate);
        return generator.convert(list,ProjectLogDTO.class);
    }

    @Override
    public int getProjectWorkLogSituation(String submitter, java.util.Date attendanceDate) {
        return projectLogManager.getProjectLogSituation(submitter,attendanceDate);
    }

    @Override
    public List<ProjectLogDTO> saveProjectLogsAndWorkLogs(String personId, ProjectLogBaseDTO projectLogBaseDTO, List<ProjectLogDTO> list,Integer flag) {
        List<ProjectLogDO> logs = generator.convert(list,ProjectLogDO.class);
        Integer auditType = null;
        if(projectLogBaseDTO.getContractNo() != null){
            auditType = getAuditType(personId,projectLogBaseDTO.getContractNo());
        }
        for(ProjectLogDO log : logs){
            if(log.getWorkLogId() == null){
                Integer id = keyGenerator.increaseWorkLog();
                if(projectLogBaseDTO.getContractNo() == null){
                    auditType = getAuditType(personId,log.getContractNo());
                }
                log.setWorkLogId(id);
                log.setAuditType(auditType);
            }
            log.setNextAuditter(projectLogManager.getLeaderOrProjectManager(log.getSubmitter(),log.getProjectId()));
        }
//        logs = projectLogManager.saveProjectLogsAndWorkLogs(personId, projectLogBaseDTO,logs);
        logs = projectLogManager.saveProjectLogsAndWorkLogs(personId, projectLogBaseDTO,logs,flag);
        return generator.convert(logs,ProjectLogDTO.class);
    }

    private Integer getAuditType(String personId,String contractNo){
        Boolean isLeader = projectGroupManager.isLeader(personId, contractNo);
        Boolean haveLeader = projectGroupManager.haveLeader(personId, contractNo);//判断是否有组长
        int auditType;
        if(isLeader || !haveLeader){
            auditType = 2;
        }else{
            auditType = 1;
        }
        return auditType;
    }

    @Override
    public ProjectLogDTO editProjectLogAndWorkLog(String personId, String contractNo, Date attendanceDate, String projectName, ProjectLogDTO projectLog, Boolean projectChangeFlag,Integer flag) {
        ProjectLogDO log = generator.convert(projectLog,ProjectLogDO.class);
        if (projectChangeFlag) {
            log.setRefuse(0);
        }
        Boolean isLeader = projectGroupManager.isLeader(personId,contractNo);
        Boolean haveLeader = projectGroupManager.haveLeader(personId,contractNo);//判断是否有组长
        int auditType;
        if(isLeader || !haveLeader){
            auditType = 2;
        }else{
            auditType = 1;
        }
        log.setAuditType(auditType);
        log.setNextAuditter(projectLogManager.getLeaderOrProjectManager(log.getSubmitter(),log.getProjectId()));
        java.util.Date now = serverDateManager.getServerDateTime();
        log.setSubmitDate(now);
        log.setProjectName(projectName);
        AttendanceDO attendanceDO = attendanceManager.getAttendance(personId, attendanceDate);
        ProjectLogBaseDTO projectLogBaseDTO = new ProjectLogBaseDTO();
        projectLogBaseDTO.setContractNo(contractNo);
        projectLogBaseDTO.setAttendanceDate(attendanceDate);
        projectLogBaseDTO.setHouseId(attendanceDO.getRentId());
        projectLogBaseDTO.setHouseType(attendanceDO.getStay());
        projectLogBaseDTO.setEvection(attendanceDO.getEvection());
//        List<ProjectLogDO> logs = projectLogManager.saveProjectLogsAndWorkLogs(personId, projectLogBaseDTO, Lists.newArrayList(log));
        List<ProjectLogDO> logs = projectLogManager.saveProjectLogsAndWorkLogs(personId, projectLogBaseDTO, Lists.newArrayList(log),flag);
        return generator.convert(logs.get(0),ProjectLogDTO.class);
    }

    @Override
    public List<ProjectWorkLogSituationDTO> getProjectWorkLogSituation(String personId, Integer days) {
        List<ProjectLogSituationDO> result = projectLogManager.getLastSituation(personId,days);
        return generator.convert(result,ProjectWorkLogSituationDTO.class);
    }

    @Override
    public ProjectBaseDTO getLastestProjectBase(String personId) {
        ProjectBaseDO customerProjectDO = projectLogManager.getLastestProjectBase(personId);
        return generator.convert(customerProjectDO, ProjectBaseDTO.class);
    }

    @Override
    public Result<ProjectBaseDTO> searchProjectsWithCommon(String personId, String context, Integer pageNo, Integer pageSize) {
        PageInfo<ProjectBaseDO> pageInfo = projectLogManager.searchProjectsWithCommon(personId,context,pageNo,pageSize);
        return ResultUtils.parseResult(pageInfo,ProjectBaseDTO.class);
    }

    @Override
    public ProjectLogDTO getProjectLog(Integer id) {
        ProjectLogDO projectLog = projectLogManager.getProjectLog(id);
        return generator.convert(projectLog,ProjectLogDTO.class);
    }

    @Override
    public void deleteProjectLog(Integer id) {
        projectLogManager.deleteProjectLog(id);
    }

    @Override
    public List<ProjectLogDTO> saveProjectLogs(List<ProjectLogDTO> logs) {
        List<ProjectLogDO> projectLogs = generator.convert(logs,ProjectLogDO.class);
        projectLogs = projectLogManager.saveProjectLogs(projectLogs);
        return generator.convert(projectLogs,ProjectLogDTO.class);
    }

    @Override
    public List<ProjectLogDTO> getByMilepostId(List<Integer> milePostId) {
        List<ProjectLogDO> projectLogDO = projectLogManager.getByMilepostId(milePostId);
        return generator.convert(projectLogDO, ProjectLogDTO.class);
    }

    @Override
    public void auditProjectLog(ProjectLogAuditDTO projectLogAuditDTO) {
        ProjectLogAuditDO projectLogAudit = generator.convert(projectLogAuditDTO,ProjectLogAuditDO.class);
        projectLogAudit = projectLogManager.processProjectLogType(projectLogAudit);
        projectLogManager.auditProjectLog(projectLogAudit);
    }

    @Override
    public void auditProjectLogs(List<ProjectLogAuditDTO> projectLogAuditDTO) {
        List<ProjectLogAuditDO> projectLogAudits = generator.convert(projectLogAuditDTO,ProjectLogAuditDO.class);
        projectLogAudits.forEach(log->{
            log = projectLogManager.processProjectLogType(log);
            projectLogManager.auditProjectLog(log);
        });
    }

    @Override
    public Result<ProjectPlanQueryLogDTO> getProjectPlanQueryLogList(Integer pageSize, Integer pageNo, Integer milepostId, String contractNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<ProjectPlanQueryLogDO> logs = projectLogManager.getProjectPlanQueryLogList(pageSize, pageNo, milepostId, contractNo);
        long times = timeConsumer.end();
        logger.info("项目计划查询-日志列表耗时:{},阶段id:{},合同号:{}",new Object[]{times,milepostId,contractNo});
        return ResultUtils.parseResult(logs, ProjectPlanQueryLogDTO.class);
    }

    @Override
    public Result<ProjectLogNeedAuditDTO> getProjectLogNeedAudit(String auditter, WorkLogAuditCndDTO params, Integer page, Integer size) {
        WorkLogAuditCnd workLogAuditCnd = generator.convert(params,WorkLogAuditCnd.class);
        Page<ProjectLogNeedAuditDO> result = projectLogManager.getProjectLogNeedAudit(auditter,workLogAuditCnd,page,size);
        return ResultUtils.parseResult(result,ProjectLogNeedAuditDTO.class);
    }

    @Override
    public ProjectLogNeedDealCountDTO getWorkLogsCount(String userId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ProjectLogNeedDealCountDO count = projectLogManager.getWorkLogsCount(userId);
        long times = timeConsumer.end();
        logger.info("获取所有待办耗时:{}",new Object[]{count,times});
        return generator.convert(count,ProjectLogNeedDealCountDTO.class);
    }

    @Override
    public Integer getProjectLogAuditCount(Integer projectLogId) {
        Integer count = projectLogManager.getProjectLogAuditCount(projectLogId);
        return count;
    }

    @Override
    public List<PublicDicDTO> getProjectLogRoles() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PublicDicDO> roles = publicDicManager.getPublicDic(2003);
        roles.sort(Comparator.comparing(PublicDicDO::getSort));
        long times = timeConsumer.end();
        logger.info("获取结构化日志角色耗时:{}",times);
        return generator.convert(roles, PublicDicDTO.class);
    }

    @Override
    public List<PublicDicDTO> getProjectLogTypes() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<PublicDicDO> types = publicDicManager.getPublicDic(2004);
        types.sort(Comparator.comparing(PublicDicDO::getSort));
        long times = timeConsumer.end();
        logger.info("获取结构化日志类别耗时:{}",times);
        return generator.convert(types, PublicDicDTO.class);
    }

    @Override
    public Boolean haveProjectLogs(String personId) {
        Integer size = projectLogManager.countProjectLogs(personId);
        return size > 0;
    }


    @Override
    public Result<ProjectWithAuditDTO> getProjectWithAuditList(String userId,WorkLogAuditCndDTO params, Integer pageNo, Integer pageSize) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        WorkLogAuditCnd workLogAuditCnd = generator.convert(params,WorkLogAuditCnd.class);
        PageInfo<ProjectWithAuditDO> pageInfo = projectLogManager.getProjectWithAuditList(userId,workLogAuditCnd,pageNo,pageSize);
//        List<ProjectWithAuditDTO> projectWithAuditDTOS = generator.convert(projectWithAuditDOS, ProjectWithAuditDTO.class);
//        Integer count = projectLogManager.countProjectWithAuditCount(userId);
        Result<ProjectWithAuditDTO> result = ResultUtils.parseResult(pageInfo,ProjectWithAuditDTO.class);
        long times = timeConsumer.end();
        logger.info("获取登录人所属的所有项目耗时:{}",new Object[]{times});
        return result;
    }

    @Override
    public Result<ProjectLogQueryProjectDTO> getProjectLogQueryProjectList(ProjectLogQueryCndDTO params) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ProjectLogQueryCnd cnd = generator.convert(params, ProjectLogQueryCnd.class);
        PageInfo<ProjectLogQueryProjectDO> projects = projectLogManager.getProjectLogQueryProjectList(cnd);
        long times = timeConsumer.end();
        logger.info("获取登录人填写日志或登录人为项目经理的项目列表耗时:{},工号:{}",new Object[]{times,params.getUserId()});
        return ResultUtils.parseResult(projects, ProjectLogQueryProjectDTO.class);
    }

    @Override
    public Result<ProjectLogQueryDetailDTO> getProjectLogQueryLogList(ProjectLogQueryCndDTO params, String inputContent, String projectId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        ProjectLogQueryCnd cnd = generator.convert(params, ProjectLogQueryCnd.class);
        Page<ProjectLogQueryDetailDO> logs = projectLogManager.getProjectLogQueryLogList(cnd, inputContent, projectId);
        long times = timeConsumer.end();
        logger.info("获取登录人填写日志或登录人为项目经理的项目日志列表耗时:{},工号:{},姓名或部门:{},项目id:{}",new Object[]{times,params.getUserId(),inputContent,projectId});
        return ResultUtils.parseResult(logs, ProjectLogQueryDetailDTO.class);
    }

    @Override
    public List<ProjectBaseDTO> getCommonProjects(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectBaseDO> projects = projectLogManager.getCommonProjects(personId);
        long times = timeConsumer.end();
        logger.info("获取登录人结构化日志常用项目列表耗时:{},工号:{}",new Object[]{times,personId});
        return generator.convert(projects,ProjectBaseDTO.class);
    }
}
