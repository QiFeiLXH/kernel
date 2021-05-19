package com.bsoft.attendance.manager.impl;

import com.bsoft.attendance.condition.ProjectLogQueryCnd;
import com.bsoft.attendance.condition.WorkLogAuditCnd;
import com.bsoft.attendance.dao.primary.*;
import com.bsoft.attendance.dto.ProjectLogBaseDTO;
import com.bsoft.attendance.entity.primary.*;
import com.bsoft.attendance.manager.AttendanceManager;
import com.bsoft.attendance.manager.ProjectLogManager;
import com.bsoft.attendance.manager.WorkLogVerifyManager;
import com.bsoft.attendance.repository.primary.ProjectLogRepository;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.manager.PublicDicManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.utils.BeanCopyUtil;
import com.bsoft.dept.entity.primary.DeptDO;
import com.bsoft.dept.manager.DeptManager;
import com.bsoft.exception.ServiceException;
import com.bsoft.project.entity.primary.ProjectBaseDO;
import com.bsoft.project.entity.primary.ProjectLookDO;
import com.bsoft.project.manager.ProjectGroupManager;
import com.bsoft.project.manager.ProjectManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class ProjectLogManagerImpl implements ProjectLogManager {
    private final static Logger logger = LoggerFactory.getLogger(ProjectLogManagerImpl.class);
    @Autowired
    private ProjectLogDao projectLogDao;
    @Autowired
    private ProjectPlanQueryLogDao projectLogQueryDao;
    @Autowired
    private ProjectLogRepository projectLogRepository;
    @Autowired
    private AttendanceManager attendanceManager;
    @Autowired
    private ServerDateManager  serverDateManager;
    @Autowired
    private ProjectGroupManager projectGroupManager;
    @Autowired
    private ProjectLogAuditDetailDao projectLogAuditDetailDao;
    @Autowired
    private WorkLogVerifyManager workLogVerifyManager;
    @Autowired
    private ProjectLogNeedAuditDao projectLogNeedAuditDao;
    @Autowired
    private ProjectLogNeedModifyDao projectLogNeedModifyDao;
    @Autowired
    ProjectLogQueryDetailDao projectLogQueryDetailDao;
    @Autowired
    private PublicDicManager publicDicManager;
    @Autowired
    private ProjectManager projectManager;
    @Autowired
    private DeptManager deptManager;
    @Autowired
    private ProjectLogViewDao projectLogViewDao;
    @Autowired
    private ProjectLogNextAuditterUpdateDao projectLogNextAuditterUpdateDao;

    @Override
    public ProjectBaseDO getLastestProjectBase(String personId) {
        return projectLogDao.getLastestProjectBase(personId);
    }

    @Override
    @Transactional
    public List<ProjectLogSituationDO> getLastSituation(String personId, Integer days) {
        return projectLogRepository.getProjectWorkLogSituation(personId,days);
    }

    @Override
    @Transactional
    public List<ProjectLogDO> getProjectWorkLogsWithNoTechnum(String projectId, String personId, java.util.Date attendanceDate) {
        List<ProjectLogDO> list = projectLogRepository.getProjectWorkLogsWithNoTechnum(projectId,attendanceDate,personId);
        return list;
    }

    @Override
    public int getProjectLogSituation(String submitter, java.util.Date attendanceDate) {
        return projectLogDao.countBySubmitterAndAttendanceDate(submitter, attendanceDate);
    }

    @Override
    @Transactional
    public List<ProjectLogDO> saveProjectLogsAndWorkLogs(String personId, ProjectLogBaseDTO projectLogBaseDTO, List<ProjectLogDO> logs,Integer flag) {
        AttendanceDO attendance = attendanceManager.getAttendance(personId, projectLogBaseDTO.getAttendanceDate());
        attendance.setRentId(projectLogBaseDTO.getHouseId());
        attendance.setStay(projectLogBaseDTO.getHouseType());
        attendance.setEvection(projectLogBaseDTO.getEvection());
        java.util.Date now = serverDateManager.getServerDateTime();
        for(ProjectLogDO log : logs){
            log.setAttendanceId(attendance.getId());
            log.setAttendanceDate(projectLogBaseDTO.getAttendanceDate());
            if(log.getSubmitDate() == null){
                log.setSubmitDate(now);
            }
            log.setLastestOperate(now); //设置最新操作时间
            if(log.getId() != null){
                Optional<ProjectLogDO> lastOp = projectLogDao.findById(log.getId());
                ProjectLogDO last = lastOp.get();
                try {
                    new BeanCopyUtil().copyProperties(last,log,true);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    throw new ServiceException("转换失败");
                }
                projectLogDao.save(last);
            }else{
                log.setId(projectLogDao.save(log).getId());
            }
            WorkLogDO workLog = newWorkLog(log, log.getProjectName(),flag);
//            attendance.setFlag(5);
            attendance.setFlag(flag);
            attendanceManager.saveWorkLog(attendance,workLog);
        }
        return logs;
    }

    @Override
    public String getLeaderOrProjectManager(String submitter,String projectId){ //若日志提交人为组长 或者 提交人没有组 或者 提交人有组但是没有组长，待审人取项目经理；否则取提交人所属组的组长
        ProjectLookDO projectLookDO = projectManager.getProject(projectId);
        Boolean isLeader = projectGroupManager.isLeader(submitter,projectLookDO.getContractNo());
        Boolean haveLeader = projectGroupManager.haveLeader(submitter,projectLookDO.getContractNo());
        if(isLeader || !haveLeader){
            if(StringUtils.isNotBlank(projectLookDO.getProjectManager())){
                String projectManager = projectGroupManager.getProjectManager(projectLookDO.getProjectManager());
                return projectManager;
            }else{
                return "";
            }
        }else{
            String leader = projectGroupManager.getLeader(submitter,projectLookDO.getContractNo());
            return leader;
        }
    }

    @Override
    public List<ProjectLogDO> saveProjectLogs(List<ProjectLogDO> projectLogs) {
        return projectLogDao.saveAll(projectLogs);
    }

    @Override
    @Transactional
    public List<ProjectLogDO> getProjectWorkLogs(String projectId, String personId, Integer milepostId, java.util.Date attendanceDate) {
        return projectLogRepository.getProjectWorkLogs(projectId,personId,milepostId,attendanceDate);
    }

    @Override
    public List<ProjectLogViewDO> getProjectWorkLogs(String personId, Date attendanceDate) {
        List<ProjectLogViewDO> logs = projectLogViewDao.findBySubmitterAndAttendanceDate(personId, attendanceDate);
        return logs;
    }

    @Override
    @Transactional
    public PageInfo<ProjectBaseDO> searchProjectsWithCommon(String personId, String context, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectBaseDO> result = projectLogRepository.searchProjectsWithCommon(personId,context);
        PageInfo<ProjectBaseDO> pageInfo = new PageInfo<>(result);
        return pageInfo;
    }

    @Override
    public ProjectLogDO getProjectLog(Integer id) {
        Optional<ProjectLogDO> projectLogOp = projectLogDao.findById(id);
        projectLogOp.orElseThrow(()->new ServiceException("没有该ID的项目日志"));
        ProjectLogDO projectLog = projectLogOp.get();
        WorkLogDO workLog = attendanceManager.getWorkLog(projectLog.getWorkLogId());
        projectLog.setProjectDept(workLog.getProjectDept());
        projectLog.setProjectType(workLog.getProjectType());
        return projectLog;
    }

    @Override
    @Transactional
    public void deleteProjectLog(Integer id) {
        ProjectLogDO projectLog = getProjectLog(id);
        attendanceManager.deleteWorkLogWithoutTransactional(projectLog.getWorkLogId());
        projectLogDao.deleteById(id);
    }

    @Override
    public List<ProjectLogDO> getByMilepostId(List<Integer> milePostId) {
        return projectLogDao.getByMilepostIdIn(milePostId);
    }

    @Override
    @Transactional
    public void auditProjectLog(ProjectLogAuditDO projectLogAudit) {
        java.util.Date now = serverDateManager.getServerDateTime();
        if(projectLogAudit.getAuditDate() == null){
            projectLogAudit.setAuditDate(now);
        }
        projectLogAudit.setLastestOperate(now); //设置最新操作时间 包括审核，提交，修改操作
        ProjectLogAuditDetailDO detail = new ProjectLogAuditDetailDO();
        detail.setAuditDate(projectLogAudit.getAuditDate());
        detail.setAuditFlag(projectLogAudit.getAuditFlag());
        detail.setAuditter(projectLogAudit.getAuditter());
        detail.setProWorkLogId(projectLogAudit.getId());
        detail.setRemark(projectLogAudit.getRemark());
        detail.setFlag(projectLogAudit.getFlag());
        projectLogDao.auditProjectLog(projectLogAudit);
        projectLogAuditDetailDao.save(detail);
        if(projectLogAudit.getAuditType().equals(4)){
            WorkLogVerifyDO workLogVerify = new WorkLogVerifyDO();
            workLogVerify.setWorkLogId(projectLogAudit.getWorkLogId());
            if(projectLogAudit.getAuditFlag().equals(1)){
                workLogVerify.setVerifyFlag(1);
                workLogVerify.setVerifyHours(projectLogAudit.getVerifyHours());
            }else{
                workLogVerify.setVerifyFlag(-1);
            }
            workLogVerify.setVerifyRemark(projectLogAudit.getRemark());
            workLogVerify.setVerifier(projectLogAudit.getAuditter());
            workLogVerifyManager.verifyWorkLog(workLogVerify);
        }
    }

    @Override
    public ProjectLogAuditDO processProjectLogType(ProjectLogAuditDO projectLogAudit) {
        if(projectLogAudit.getAuditFlag().equals(1)) return processAgreeAudit(projectLogAudit);
        Boolean isLeader = projectGroupManager.isLeader(projectLogAudit.getSubmitter(),projectLogAudit.getContractNo());
        Boolean haveLeader = projectGroupManager.haveLeader(projectLogAudit.getSubmitter(),projectLogAudit.getContractNo());
        return processNextAudit(projectLogAudit,isLeader || !haveLeader);
    }

    @Override
    public Page<ProjectPlanQueryLogDO> getProjectPlanQueryLogList(Integer pageSize, Integer pageNo, Integer milepostId, String contractNo) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Specification<ProjectPlanQueryLogDO> spec = new Specification<ProjectPlanQueryLogDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectPlanQueryLogDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("milepostId"),milepostId));
                predicates.add(criteriaBuilder.equal(root.get("contractNo"),contractNo));
                criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])));
                return criteriaQuery.getRestriction();
            }
        };
        Page<ProjectPlanQueryLogDO> ProjectLog = projectLogQueryDao.findAll(spec, pageable);

        long times = timeConsumer.end();
        logger.info("获取项目计划查询-项目日志列表用时:{}",times);
        return ProjectLog;
    }

    @Override
    public Page<ProjectLogNeedAuditDO> getProjectLogNeedAudit(String auditter, WorkLogAuditCnd params, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size,Sort.by("remainingDays").descending());
        Page<ProjectLogNeedAuditDO> projectPage = projectLogNeedAuditDao.findAll(new Specification<ProjectLogNeedAuditDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectLogNeedAuditDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if(params.getProjectId() != null){
                    String context = params.getProjectId();
                    predicates.add(criteriaBuilder.equal(root.get("gsxm"),context));
                }
                if(params.getUserName() != null){
                    String context = params.getUserName();
                    Predicate c1 = criteriaBuilder.like(root.get("userName"),"%"+context+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("userPym"),"%"+context+"%");
                    predicates.add(criteriaBuilder.or(c1,c2));
                }
                if(params.getProjectName() != null){
                    String context = params.getProjectName();
                    Predicate c1 = criteriaBuilder.like(root.get("projectName"),"%"+context+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("projectPym"),"%"+context+"%");
                    predicates.add(criteriaBuilder.or(c1,c2));
                }
                if(params.getGroupName() != null){
                    String context =  params.getGroupName();
                    predicates.add(criteriaBuilder.like(root.get("groupName"),"%"+context+"%"));
                }
                if(params.getFlag() != null){
                    Integer context = params.getFlag();
                    predicates.add(criteriaBuilder.equal(root.get("flag"),context));
                }
                if(params.getListFlag() != null){
                    Integer listFlag = params.getListFlag();
                    String loginUser = params.getLoginUser();
                    List<ProjectLogAuditDetailDO> projectLogAuditDetailDOS = projectLogAuditDetailDao.findByAuditter(loginUser);
                    CriteriaBuilder.In<Integer> in = criteriaBuilder.in(root.get("id"));
                    in.value(0);
                    if(projectLogAuditDetailDOS.size() > 0){
                        for (ProjectLogAuditDetailDO projectLogAuditDetailDO : projectLogAuditDetailDOS) {
                            in.value(projectLogAuditDetailDO.getProWorkLogId());
                        }
                    }
                    Predicate c1 = criteriaBuilder.equal(root.get("auditter"),loginUser);
                    if( listFlag == 1){
                        predicates.add(criteriaBuilder.or(in,c1));
                    }else if(listFlag == 2){
                        predicates.add(in);
                    }else if(listFlag == 3){
                        predicates.add(c1);
                    }
                }
                if(params.getStartDate() != null && params.getEndDate() != null){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date startDate = null;
                    java.util.Date endDate = null;
                    try {
                        startDate = sdf.parse(params.getStartDate());
                        endDate = sdf.parse(params.getEndDate());
                        predicates.add(criteriaBuilder.between(root.get("attendanceDate"),startDate,endDate));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return projectPage;
    }

    @Override
    public ProjectLogNeedDealCountDO getWorkLogsCount(String userId) {
        //结构化日志待审
        List<ProjectLogNeedAuditDO> needAuditList = projectLogNeedAuditDao.findAll(new Specification<ProjectLogNeedAuditDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectLogNeedAuditDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("auditter"),userId));
                predicates.add(criteriaBuilder.equal(root.get("flag"),3));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        //结构化日志待修改
        List<ProjectLogNeedAuditDO> needEditList = projectLogNeedAuditDao.findAll(new Specification<ProjectLogNeedAuditDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectLogNeedAuditDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("auditter"),userId));
                predicates.add(criteriaBuilder.equal(root.get("flag"),1));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        //支持结算日志待修改
        List<ProjectLogNeedAuditDO> supportNeedEditList = projectLogNeedAuditDao.findAll(new Specification<ProjectLogNeedAuditDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectLogNeedAuditDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("auditter"),userId));
                predicates.add(criteriaBuilder.equal(root.get("flag"),2));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        ProjectLogNeedDealCountDO countDO = new ProjectLogNeedDealCountDO();
        countDO.setNeedAudit(needAuditList.size());
        countDO.setNeedEdit(needEditList.size());
        countDO.setSupportNeedEdit(supportNeedEditList.size());
        return countDO;
    }

    @Override
    public List<ProjectLogNeedAuditDO> getRegionAuditList(String smallRegion) {
        List<ProjectLogNeedAuditDO> projectWorkLogDOList = projectLogNeedAuditDao.findAll(new Specification<ProjectLogNeedAuditDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectLogNeedAuditDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("auditType"),3));
                predicates.add(criteriaBuilder.equal(root.get("auditFlag"),2));
                predicates.add(criteriaBuilder.equal(root.get("refuse"),1));
                predicates.add(criteriaBuilder.equal(root.get("smallRegion"),smallRegion));
                java.util.Date today = serverDateManager.getServerDateTime();
                Calendar c = Calendar.getInstance();
                c.setTime(today);
                c.add(Calendar.DAY_OF_MONTH, -1);
                java.util.Date yesterday = c.getTime();//这是昨天
                predicates.add(criteriaBuilder.between(root.get("auditDate"),yesterday,today));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });

        return projectWorkLogDOList;
    }

    @Override
    @Transactional
    public List<Map<String, Object>> getRegionAuditCount() {
        return projectLogRepository.getRegionAuditCount();
    }

    @Override
    @Transactional
    public PageInfo<ProjectWithAuditDO> getProjectWithAuditList(String userId,WorkLogAuditCnd workLogAuditCnd,Integer pageNo,Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        Map<String,Object> data = new HashMap<>();
        data.put("userId",userId);
        data.put("pageNo",pageNo);
        data.put("pageSize",pageSize);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(workLogAuditCnd.getStartDate() != null){
            java.util.Date startDate = null;
            try {
                startDate = sdf.parse(workLogAuditCnd.getStartDate());
                data.put("startDate",startDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else{
            data.put("startDate",null);
        }
        if(workLogAuditCnd.getEndDate() != null){
            java.util.Date endDate = null;
            try {
                endDate = sdf.parse(workLogAuditCnd.getEndDate());
                data.put("endDate",endDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else{
            data.put("endDate",null);
        }
        List<ProjectWithAuditDO> result = projectLogRepository.getProjectWithAudit(data);
        PageInfo<ProjectWithAuditDO> pageInfo = new PageInfo<>(result);
        return pageInfo;
    }

    @Override
    @Transactional
    public Integer countProjectWithAuditCount(String userId) {
        return projectLogRepository.getProjectWithAuditCount(userId);
    }

    @Override
    public Integer getProjectLogAuditCount(Integer projectLogId) {
        return projectLogAuditDetailDao.countByProWorkLogId(projectLogId);
    }

    @Override
    public void endProjectLog() {
        projectLogDao.endProjectLog();
    }

    @Override
    public List<ProjectLogDO> getNeedEndProjectLog() {
        return projectLogDao.getNeedEndProjectLog();
    }

    @Override
    @Transactional
    public void endEditProjectLog() {
        logger.info("查询待修改超过2天的日志");
        List<ProjectLogDO> projectLogs = getNeedEndProjectLog();
        List<WorkLogVerifyDO> workLogVerifys = new ArrayList<>();
        for(ProjectLogDO projectLog : projectLogs){
            WorkLogVerifyDO workLogVerify = new WorkLogVerifyDO();
            workLogVerify.setWorkLogId(projectLog.getWorkLogId());
            workLogVerify.setVerifyFlag(-1);
            workLogVerify.setVerifyRemark(projectLog.getRemark());
            workLogVerify.setVerifier(projectLog.getAuditter());
            workLogVerifys.add(workLogVerify);
        }
        endProjectLog();
        workLogVerifyManager.verifyWorkLogs(workLogVerifys);
        logger.info("处理待修改超过2天的日志自动不同意完成！");
    }

    @Override
    @Transactional
    public void endAuditProjectLog() {
        logger.info("查询待审核超过3天的日志");
        List<ProjectLogDO> projectLogs = projectLogDao.getNeedEndAuditProjectLog();
        List<WorkLogVerifyDO> workLogVerifys = new ArrayList<>();
        for(ProjectLogDO projectLog : projectLogs){
            WorkLogVerifyDO workLogVerify = new WorkLogVerifyDO();
            workLogVerify.setWorkLogId(projectLog.getWorkLogId());
            workLogVerify.setVerifyFlag(1);
            workLogVerify.setVerifyRemark("结构化日志待审核超过三天，系统自动审核同意");
            ProjectLogNeedAuditDO projectLogNeedAuditDO = projectLogNeedAuditDao.getOne(projectLog.getId());
            workLogVerify.setVerifier(projectLogNeedAuditDO.getAuditter());
            workLogVerify.setVerifyHours(projectLog.getWorkload());
            workLogVerifys.add(workLogVerify);
        }
        projectLogDao.endAuditProjectLog();
        workLogVerifyManager.verifyWorkLogs(workLogVerifys);
        logger.info("处理待审核超过3天的日志自动同意完成！");
    }

    @Override
    @Transactional
    public void changeProjectLogAudit(String contractno) {
        List<ProjectLogNeedModifyDO> projectLogNeedModifys = projectLogNeedModifyDao.findByContractno(contractno);
        if(projectLogNeedModifys.size()>0){
            for(ProjectLogNeedModifyDO projectLogNeedModify:projectLogNeedModifys){
                if(projectLogNeedModify.getAuditType().equals(1)){
                    ProjectLookDO projectLookDO = projectManager.getProject(projectLogNeedModify.getProjectId());
                    String projectManager = "";
                    if(StringUtils.isNotBlank(projectLookDO.getProjectManager())){
                        projectManager = projectGroupManager.getProjectManager(projectLookDO.getProjectManager());
                    }
                    projectLogDao.setAuditTypeWithProjectManager(projectLogNeedModify.getWorklogId(),projectManager);
                }else{
                    String leader = projectGroupManager.getLeader(projectLogNeedModify.getSubmitter(),projectLogNeedModify.getContractno());
                    projectLogDao.setAuditTypeWithGroupLeader(projectLogNeedModify.getWorklogId(),leader);
                }
            }
        }

    }

    @Override
    @Transactional
    public PageInfo<ProjectLogQueryProjectDO> getProjectLogQueryProjectList(ProjectLogQueryCnd cnd) {
        Integer pageNo = cnd.getPageNo();
        Integer pageSize = cnd.getPageSize();
        String userId = cnd.getUserId();
        String startDate = cnd.getStartDate();
        String endDate = cnd.getEndDate();
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectLogQueryProjectDO> projects = projectLogRepository.getProjectLogQueryProjectList(userId, startDate, endDate);
        PageInfo<ProjectLogQueryProjectDO> pages = new PageInfo<>(projects);
        return pages;
    }

    @Override
    public Page<ProjectLogQueryDetailDO> getProjectLogQueryLogList(ProjectLogQueryCnd cnd, String inputContent, String projectId) {
        Integer pageNo = cnd.getPageNo();
        Integer pageSize = cnd.getPageSize();
        Sort sort = Sort.by("attendanceDate").descending()
                .and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(pageNo-1,pageSize, sort);
        Page<ProjectLogQueryDetailDO> logs = projectLogQueryDetailDao.findAll(new Specification<ProjectLogQueryDetailDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectLogQueryDetailDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                predicates.add(criteriaBuilder.between(root.get("attendanceDate"),cnd.getStartDate(),cnd.getEndDate()));
                if (StringUtils.isNotBlank(inputContent)) {
                    Predicate c1 = criteriaBuilder.like(root.get("personName"),"%"+inputContent+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("deptName"),"%"+inputContent+"%");
                    Predicate c3 = criteriaBuilder.like(root.get("personSimpleCode"),"%"+inputContent.toLowerCase()+"%");
                    Predicate c4 = criteriaBuilder.like(root.get("deptSimpleCode"),"%"+inputContent.toUpperCase()+"%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3,c4));
                }
                if (StringUtils.isNotBlank(projectId)) {
                    predicates.add(criteriaBuilder.equal(root.get("projectId"),projectId));
                }
                Predicate c1 = criteriaBuilder.equal(root.get("personId"), cnd.getUserId());
                Predicate c2 = criteriaBuilder.equal(root.get("projectManager"), cnd.getUserId());
                predicates.add(criteriaBuilder.or(c1,c2));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return logs;
    }

    @Override
    public Integer countProjectLogs(String personId) {
        Integer size = projectLogDao.countBySubmitter(personId);
        return size;
    }

    @Override
    public List<ProjectBaseDO> getCommonProjects(String personId) {
        return projectManager.getProjectLogCommonProjects(personId);
    }

    @Override
    @Transactional
    public void replaceDifferentProjectManager() {
        TimeConsumer timeConsumer = TimeConsumer.start();
        // 查找出审核环节是项目经理审核，且待审人与项目的项目经理不一样的日志，并将结构化日志待审人修改为项目经理
        List<ProjectLogNextAuditterUpdateDO> logs = projectLogRepository.getDifferentProjectManagerFromNextAuditterLogList();
        projectLogNextAuditterUpdateDao.saveAll(logs);
        long times = timeConsumer.end();
        logger.info("同步更新结构化项目经理审核阶段项目经理耗时:{}",times);
    }

    private ProjectLogAuditDO processAgreeAudit(ProjectLogAuditDO projectLogAudit){
        projectLogAudit.setAuditType(4);
        projectLogAudit.setRefuse(0);
        projectLogAudit.setNextAuditter(null);//待审人设置为null
        return projectLogAudit;
    }

    private ProjectLogAuditDO processEditAudit(ProjectLogAuditDO projectLogAudit){
        projectLogAudit.setAuditType(0);
        projectLogAudit.setRefuse(1);
        projectLogAudit.setNextAuditter(projectLogAudit.getSubmitter());//待审人设置为提交人
        return projectLogAudit;
    }

    private ProjectLogAuditDO processNextAudit(ProjectLogAuditDO projectLogAudit,Boolean isLeader){
        Integer auditType = projectLogAudit.getAuditType();
        if(projectLogAudit.getRefuse() == null){
            projectLogAudit.setRefuse(0);
        }
        if(((isLeader && auditType.equals(2)) || auditType.equals(1)) && projectLogAudit.getRefuse().equals(0)){
            return processEditAudit(projectLogAudit);
        }
        if(auditType.equals(3) && projectLogAudit.getRefuse().equals(0)) return processAreaAudit(projectLogAudit);
        if(auditType.equals(4)) return processEndAudit(projectLogAudit);
        auditType ++;
        projectLogAudit.setAuditType(auditType);
        if(auditType.equals(0)){
            projectLogAudit.setNextAuditter(projectLogAudit.getSubmitter());//待审人设置为提交人
        }
        if(auditType.equals(2)){//待审人设置为项目经理
            ProjectLookDO projectLookDO = projectManager.getProject(projectLogAudit.getProjectId());
            String projectManager = "";
            if(StringUtils.isNotBlank(projectLookDO.getProjectManager())){
                projectManager = projectGroupManager.getProjectManager(projectLookDO.getProjectManager());
            }
            projectLogAudit.setNextAuditter(projectManager);
        }
        if(auditType.equals(3)){
            projectLogAudit.setNextAuditter(getAreaLeader(projectLogAudit));//待审人小区负责人
        }
        if(auditType.equals(4)){
            projectLogAudit.setNextAuditter(null); //流程结束 待审人设置为null
        }
        projectLogAudit.setRefuse(0);
        return projectLogAudit;
    }

    private ProjectLogAuditDO processAreaAudit(ProjectLogAuditDO projectLogAudit){
        projectLogAudit.setAuditType(3);
        projectLogAudit.setRefuse(1);
        projectLogAudit.setNextAuditter(getAreaLeader(projectLogAudit));//待审人小区负责人
        return projectLogAudit;
    }

    private String getAreaLeader(ProjectLogAuditDO projectLogAudit){//获取小区负责人
        ProjectLookDO projectLookDO = projectManager.getProject(projectLogAudit.getProjectId());
        DeptDO deptDO = deptManager.getDept(projectLookDO.getArea());
        return deptDO.getDepManager();
    }

    private ProjectLogAuditDO processEndAudit(ProjectLogAuditDO projectLogAudit){
        projectLogAudit.setAuditType(4);
        projectLogAudit.setRefuse(0);
        projectLogAudit.setNextAuditter(null);//待审人小区负责人
        return projectLogAudit;
    }


    private WorkLogDO newWorkLog(ProjectLogDO projectLog,String projectName,Integer flag){
        WorkLogDO worklog = new WorkLogDO();
        worklog.setId(projectLog.getWorkLogId());
        worklog.setAttendanceId(projectLog.getAttendanceId());
        worklog.setWorkLog(concatWorkLog(projectLog));
        worklog.setSubmitDate(projectLog.getSubmitDate());
        worklog.setFlag(flag);
        worklog.setProjectType(projectLog.getProjectType());
        worklog.setProjectDept(projectLog.getProjectDept());
        worklog.setProjectId(projectLog.getProjectId());
        worklog.setWorkLoad(projectLog.getWorkload());
        worklog.setProjectName(projectName);
        worklog.setSourceType(2);
        worklog.setTechnumid(projectLog.getId().toString());
        return worklog;
    }

    private String concatWorkLog(ProjectLogDO projectLogDO){
        StringBuilder log = new StringBuilder();
        log.append("范围：").append(projectLogDO.getRange() == null ?"" :projectLogDO.getRange() == 1 ? "合同内" : "合同外").append("\n").
                append("计划：").append(projectLogDO.getPlan() == 1 ? "计划内" : "计划外").append("\n").
                append("角色：").append(getRoleText(projectLogDO.getRole())).append("\n").
                append("方式：").append(projectLogDO.getModel() == 1 ? "现场" : "远程").append("\n").
                append("类别：").append(getTypeText(projectLogDO.getType())).append("\n").
                append("事件：").append(projectLogDO.getWorkLog()).append("\n").
                append("工时：").append(projectLogDO.getWorkload()).append("h      ").
                append("结果：").append(projectLogDO.getResult() == 0 ? "进行中" : "已完成").append("\n");
        return log.toString();
    }

    private String getRoleText(Integer role){
        List<PublicDicDO> roles = publicDicManager.getPublicDic(2003);
        for (PublicDicDO publicDicDO : roles) {
            if(publicDicDO.getId().equals(role)){
                return publicDicDO.getName();
            }
        }
        return "";
    }

    private String getTypeText(Integer type){
        List<PublicDicDO> types = publicDicManager.getPublicDic(2004);
        for (PublicDicDO publicDicDO : types) {
            if(publicDicDO.getId().equals(type)){
                return publicDicDO.getName();
            }
        }
        return "";
    }
}
