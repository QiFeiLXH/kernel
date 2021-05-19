package com.bsoft.attendance.manager.impl;

import com.bsoft.attendance.dao.primary.AttendanceDao;
import com.bsoft.attendance.dao.primary.AttendanceViewDao;
import com.bsoft.attendance.dao.primary.WorkLogDao;
import com.bsoft.attendance.dao.primary.WorkLogViewDao;
import com.bsoft.attendance.entity.primary.*;
import com.bsoft.attendance.manager.AttendanceManager;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.key.KeyGenerator;
import com.bsoft.common.lock.RedisLocker;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.utils.BeanCopyUtil;
import com.bsoft.exception.ServiceException;
import com.bsoft.house.entity.primary.HouseDO;
import com.bsoft.house.manager.HouseManager;
import com.bsoft.project.entity.primary.ProjectDO;
import com.bsoft.project.manager.ProjectManager;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AttendanceManagerImpl implements AttendanceManager {
    private static final Logger logger = LoggerFactory.getLogger(AttendanceManagerImpl.class);
    private static final String DEFAULT_LOCKKEY = "attendance:";

    private static final String[] serial = new String[]{"一.","二.","三.","四.","五.","六.","七.","八.","九.","十.","十一.","十二.","十三.","十四.","十五.","十六.","十七.","十八.","十九.","二十."};

    @Autowired
    private AttendanceDao attendanceDao;
    @Autowired
    private WorkLogDao workLogDao;
    @Autowired
    private ProjectManager projectManager;
    @Autowired
    private HouseManager houseManager;
    @Autowired
    private KeyGenerator keyGenerator;
    @Autowired
    private WorkLogViewDao workLogViewDao;
    @Autowired
    private AttendanceViewDao attendanceViewDao;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private IGenerator generator;
    @Autowired
    private RedisLocker redisLocker;
    @Autowired
    private PlatformTransactionManager platformTransactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;

    @Override
    public AttendanceDO getAttendance(String personId) {
        java.sql.Date today = serverDateManager.getServerDate();
        return getAttendance(personId,today);
    }


    @Override
    public AttendanceDO getAttendance(String personId, java.sql.Date attendanceDate){
        String requestId = redisLocker.getRequestId();
        redisLocker.lock(DEFAULT_LOCKKEY + personId,requestId);
        AttendanceDO attendanceDO = null;
        try{
            attendanceDO = attendanceDao.getAttendance(attendanceDate,personId);
            if(attendanceDO == null){
                attendanceDO = getAttendanceWithPersonIdAndAttendanceDate(personId, attendanceDate);
            }
        }finally {
            redisLocker.releaseLock(DEFAULT_LOCKKEY + personId,requestId);
        }
        return attendanceDO;
    }

    @Override
    public AttendanceViewDO getAttendanceView(String personId, java.sql.Date attendanceDate){
        String requestId = redisLocker.getRequestId();
        redisLocker.lock(DEFAULT_LOCKKEY + personId,requestId);
        AttendanceViewDO attendanceViewDO = null;
        try{
            attendanceViewDO = attendanceViewDao.getAttendance(attendanceDate,personId);
            if(attendanceViewDO == null){
                AttendanceDO attendanceDO = getAttendanceWithPersonIdAndAttendanceDate(personId, attendanceDate);
                attendanceViewDO = generator.convert(attendanceDO,AttendanceViewDO.class);
            }
        }finally {
            redisLocker.releaseLock(DEFAULT_LOCKKEY + personId,requestId);
        }


        return attendanceViewDO;
    }
    @Override
    public List<WorkLogViewDO> getWorkLogViewList(Integer attendanceId) {
        return workLogViewDao.findByAttendanceId(attendanceId);
    }

    @Override
    public List<WorkLogViewDO> getWorkLogViewListWithout(Integer attendanceId,Integer workLogId) {
        return workLogViewDao.findByAttendanceIdAndIdNotIn(attendanceId, Lists.newArrayList(workLogId));
    }

    @Override
    public List<WorkLogDO> getWorkLogList(Integer attendanceId){
        return workLogDao.findByAttendanceId(attendanceId);
    }

    @Override
    public AttendanceDO saveAttendance(AttendanceDO attendance) {
        return attendanceDao.save(attendance);
    }

    @Override
    public WorkLogDO saveWorkLog(WorkLogDO workLog) {
        return workLogDao.save(workLog);
    }

    @Override
    public List<WorkLogDO> saveWorkLog(List<WorkLogDO> workLogs) {
        List<WorkLogDO> list = new ArrayList<>();
        for( WorkLogDO workLog : workLogs ){
            WorkLogDO workLogDO = workLogDao.saveAndFlush(workLog);
            list.add(workLogDO);
        }
        return list;
    }

    @Override
    @Transactional
    public void deleteWorkLog(Integer id) {
        deleteWorkLogWithoutTransactional(id);
    }

    @Override
    public void deleteWorkLogWithoutTransactional(Integer id) {
        Optional<WorkLogDO> workLogDO = workLogDao.findById(id);
        WorkLogDO workLog = workLogDO.orElseThrow(()-> new ServiceException("无该日志"));
        Integer attendanceId = workLog.getAttendanceId();
        AttendanceDO attendanceDO = attendanceDao.findById(attendanceId).get();
        workLogDao.deleteById(id);

        List<WorkLogViewDO> workLogViews = getWorkLogViewListWithout(attendanceId,id);
        List<WorkLogDO> workLogs = generator.convert(workLogViews,WorkLogDO.class);
        attendanceDO.setWorkLog(totalWorkLog(workLogs));
        if(workLogs.isEmpty()){
            attendanceDO.setSubmitDate(null);
        }
        saveAttendance(attendanceDO);

        List<WorkLogDO> list = processWorkLog(workLogs,attendanceDO);
        saveWorkLog(list);
    }

    @Override
    public List<ProjectDO> getUsefulProject(String personId) {
        List<String> projectidList = workLogDao.getUserfulProject(personId);
        List<ProjectDO> list = projectManager.getProjects(projectidList);
        return list;
    }

    @Override
    public List<HouseDO> getUsefulHouse(String personId) {
        List<Integer> zentIds = attendanceDao.getUsefulHouse(personId);
        return houseManager.getHouses(zentIds);
    }

    @Override
    @Transactional
    public AttendanceWholeDO saveAttendanceWhole(AttendanceDO attendance, List<WorkLogDO> workLogs) {
        AttendanceDO oldAttendance = attendanceDao.getAttendance(attendance.getAttendanceDate(), attendance.getPersonId());
        attendance.setRank(oldAttendance.getRank());
        attendance.setWages(oldAttendance.getWages());
        AttendanceDO attendanceDO = attendanceDao.save(attendance);
        for(WorkLogDO workLog : workLogs){
            workLogDao.save(workLog);
        }
        List<WorkLogDO> list = processWorkLog(workLogs,attendance);
        list = saveWorkLog(list);
        return new AttendanceWholeDO(attendanceDO,list);
    }

    @Override
    public AttendanceViewDO getAttendanceView(String personId) {
        java.sql.Date today = serverDateManager.getServerDate();
        return getAttendanceView(personId,today);
    }

    @Override
    public WorkLogDO saveWorkLog(String personid, WorkLogDO workLog, Date attendanceDate) {
        AttendanceDO attendance = getAttendance(personid,attendanceDate);
        if(workLog.getVerifyFlag() == null){
            workLog.setVerifyFlag(0);
        }
        if(workLog.getCheckFlag() == null){
            workLog.setCheckFlag(0);
        }
        Integer id = attendance.getId();
        List<WorkLogDO> workLogs = getWorkLogList(id);
        workLogs.add(workLog);
        if(workLog.getAttendanceId() == null){
            workLog.setAttendanceId(id);
        }
        List<WorkLogDO> list = processWorkLog(workLogs,attendance);
        saveWorkLog(list);
        return workLog;
    }

    @Override
    public WorkLogDO saveWorkLog(String personid,WorkLogDO workLog){
        java.sql.Date today = serverDateManager.getServerDate();
        return saveWorkLog(personid,workLog,today);
    }

    @Override
    public WorkLogDO saveWorkLog(AttendanceDO attendance, WorkLogDO workLog) {
        Integer id = attendance.getId();
        if(workLog.getVerifyFlag() == null){
            workLog.setVerifyFlag(0);
        }
        if(workLog.getCheckFlag() == null){
            workLog.setCheckFlag(0);
        }
        Integer workLogId = workLog.getId();
        List<WorkLogViewDO> workLogViews = getWorkLogViewListWithout(id,workLogId);
        List<WorkLogDO> workLogs = generator.convert(workLogViews,WorkLogDO.class);
        if(workLog.getAttendanceId() == null){
            workLog.setAttendanceId(id);
        }
        workLogs.add(workLog);

        if(attendance.getSubmitDate() == null){
            java.util.Date now = serverDateManager.getServerDateTime();
            attendance.setSubmitDate(now);
        }
        attendance.setWorkLog(totalWorkLog(workLogs));
        AttendanceDO old = attendanceDao.getOne(attendance.getId());
        try {
            new BeanCopyUtil().copyProperties(old,attendance,true);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new ServiceException("保存日志失败");
        }
        saveAttendance(old);
        List<WorkLogDO> list = processWorkLog(workLogs,old);
        saveWorkLog(list);
        return workLog;
    }

    @Override
    @Transactional
    public WorkLogDO saveWorkLogWithTransactional(AttendanceDO attendance, WorkLogDO workLog) {
        return saveWorkLog(attendance,workLog);
    }

    @Override
    public List<AttendanceDO> getAttendanceList(String personId, Integer days) {
        return attendanceDao.getAttendanceList(personId,days);
    }

    @Override
    public Page<AttendanceViewDO> getAttendanceList(String personId, java.util.Date start, java.util.Date end,Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<AttendanceViewDO> result = attendanceViewDao.findAll(new Specification<AttendanceViewDO>() {
            @Override
            public Predicate toPredicate(Root<AttendanceViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate1 = criteriaBuilder.equal(root.get("personId"),personId);
                Predicate predicate2 = criteriaBuilder.between(root.get("attendanceDate"),start,end);
                return criteriaBuilder.and(predicate1,predicate2);
            }
        },pageable);
        return result;
    }

    @Override
    public WorkLogDO getWorkLog(Integer id) {
        Optional<WorkLogDO> workLog = workLogDao.findById(id);
        workLog.orElseThrow(()->new ServiceException("找不到日志信息"));
        return workLog.get();
    }

    /** 定时生成在职人员考勤数据 */
    @Override
    @Transactional
    public void generateAttendance() {
        // 获取服务器当前日期
        java.sql.Date today = serverDateManager.getServerDate();
        // 获取未离职的所有用户
//        List<PersonDO> persons = personManager.getVaildPerson();
        TimeConsumer timeConsumer = TimeConsumer.start();
        logger.info("定时功能——自动生成考勤日期：{}的未离职人员考勤数据",today);
        /*persons.forEach(person -> {
            logger.info("即将生成工号：{}的考勤数据", person.getPersonId());
            getAttendance(person.getPersonId(), today);
        });*/
        attendanceDao.generateAttendance();
        long times1 = timeConsumer.end();
        logger.info("在职人员考勤数据生成结束，共耗时：{}", times1);
    }

    @Override
    public List<AttendanceViewDO> getMonthAttendance(String personId) {
        // 获取服务器当前日期
        java.sql.Date today = serverDateManager.getServerDate();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        String dateString = formatter.format(today);
        List<AttendanceViewDO> list = attendanceViewDao.getMonthAttendance(dateString,personId);
        return list;
    }

    @Override
    public void updateAttendance(AttendanceViewDO attendanceViewDO) {
        AttendanceDO attendanceDO = attendanceDao.getOne(attendanceViewDO.getId());
        //下班打卡
        if (attendanceViewDO.getOffWorkPlace() != null){
            attendanceDO.setOffWorkTime(serverDateManager.getServerDateTime());
            attendanceDO.setOffWorkPlace(attendanceViewDO.getOffWorkPlace());
            attendanceDO.setOffWorkPlaceLon(attendanceViewDO.getOffWorkPlaceLon());
            attendanceDO.setOffWorkPlaceLat(attendanceViewDO.getOffWorkPlaceLat());
            attendanceDao.save(attendanceDO);
        } else if (attendanceViewDO.getGoWorkPlace() != null && attendanceViewDO.getOffWorkPlace() == null){
            //上班打卡
            if (attendanceViewDO.getGoWorkTime() == null){
                attendanceDO.setGoWorkTime(serverDateManager.getServerDateTime());
                attendanceDO.setGoWorkPlace(attendanceViewDO.getGoWorkPlace());
                attendanceDO.setGoWorkPlaceLon(attendanceViewDO.getGoWorkPlaceLon());
                attendanceDO.setGoWorkPlaceLat(attendanceViewDO.getGoWorkPlaceLat());
                attendanceDao.save(attendanceDO);
            }
        }

    }

    @Override
    public List<AttendanceViewDO> getAttendanceByDays(String personId, Integer days) {
        return attendanceViewDao.getAttendanceList(personId,days);
    }

    @Override
    @Transactional
    public void saveAll(List<AttendanceDO> attendanceDOS) {
        attendanceDao.saveAll(attendanceDOS);
    }

    @Override
    public void updateDept(String bmdm, String yggh, java.util.Date kqrq) {
        attendanceDao.updateDept(bmdm,yggh,kqrq);
    }

    private Double totalWorkLoad(List<WorkLogDO> workLogs){
        if(workLogs.size() == 0) return 0D;
        return workLogs.stream().map(WorkLogDO::getWorkLoad).reduce(Double::sum).get();
    }

    private List<WorkLogDO> processWorkLog(List<WorkLogDO> workLogs,AttendanceDO attendanceDO){
        Double total = totalWorkLoad(workLogs);
        if(total > 24){
            throw new ServiceException("总工时已超过24小时");
        }
        if(total < 8){
            total = 8D;
        }
        for(WorkLogDO workLog : workLogs ){
            Double workLoad = workLog.getWorkLoad();
            Double scale = new BigDecimal(workLoad / total).setScale(2, RoundingMode.HALF_UP).doubleValue();
            workLog.setProjectScale(scale);
            if(attendanceDO.getWages() != null){
                Double money = new BigDecimal(attendanceDO.getWages()*scale).setScale(2, RoundingMode.HALF_UP).doubleValue();
                workLog.setWages(money);
            }
            workLog.setPersonId(attendanceDO.getPersonId());
            workLog.setRank(attendanceDO.getRank());
            workLog.setAttendanceDate(attendanceDO.getAttendanceDate());
        }
        processWorkLoad(workLogs,attendanceDO.getWages()); //处理项目比例，防止四舍五入之后合计不为1
        return workLogs;
    }

    private String totalWorkLog(List<WorkLogDO> workLogs){
        try {
            StringBuilder workLogTotal = new StringBuilder();
            int i = 0;
            for(WorkLogDO workLogDO : workLogs){
                workLogTotal.append(serial[i]).append(workLogDO.getProjectName());
                if(workLogDO.getTechnumid() != null && workLogDO.getSourceType() == 1){
                    workLogTotal.append("(支持单号：").append(workLogDO.getTechnumid()).append(")");
                }
                workLogTotal.append("(工时：").append(workLogDO.getWorkLoad()).append(")\n").append(workLogDO.getWorkLog()).append("\n");
                i++;
            }
            return workLogTotal.toString();
        }catch (Exception e){
            throw new ServiceException("超过日志填写次数最大限制");
        }
    }

    private void processWorkLoad(List<WorkLogDO> workLogs,Double wages){
        Double totalWorkLoad = totalWorkLoad(workLogs);
        if(totalWorkLoad < 8) return;
        Double projectScale = 0D;
        for(int i=0;i<workLogs.size();i++){
            if(i == workLogs.size() - 1){
                WorkLogDO worklog = workLogs.get(i);
                Double lastProjectScale = 1 - projectScale;
                worklog.setProjectScale(lastProjectScale);
                if(wages != null){
                    Double money = new BigDecimal(wages*lastProjectScale).setScale(2, RoundingMode.HALF_UP).doubleValue();
                    worklog.setWages(money);
                }
            }else{
                projectScale += workLogs.get(i).getProjectScale();
            }
        }
    }

    private AttendanceDO getAttendanceWithPersonIdAndAttendanceDate(String personId, java.sql.Date attendanceDate) {
        Integer id = keyGenerator.increaseAttendance();
        AttendanceDO attendanceDO = new AttendanceDO();
        attendanceDO.setAttendanceDate(attendanceDate);
        attendanceDO.setPersonId(personId);
        attendanceDO.setId(id);
        attendanceDO.setEvection(0);
        attendanceDO.setStay(1);//非住宿
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        attendanceDO = saveAttendance(attendanceDO);
        platformTransactionManager.commit(transactionStatus);//提交
        return attendanceDO;
    }

    public List<AttendanceDO> getNeedUpdateAttendanceRecord(List<String> personIdList, Date attenanceDate) {
        List<AttendanceDO> list = attendanceDao.findAll(new Specification<AttendanceDO>() {
            @Override
            public Predicate toPredicate(Root<AttendanceDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("attendanceDate"), attenanceDate));
                predicates.add(criteriaBuilder.or(root.get("personId").as(String.class).in(personIdList)));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        return list;
    }

    public List<AttendanceDO> getNeedUpdateLactationAttendanceRecord(List<String> personIdList, Date attenanceDate) {
        List<AttendanceDO> list = attendanceDao.findAll(new Specification<AttendanceDO>() {
            @Override
            public Predicate toPredicate(Root<AttendanceDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("attendanceDate"), attenanceDate));
                predicates.add(criteriaBuilder.or(root.get("personId").as(String.class).in(personIdList)));
                // 迟到或早退
                Predicate c1 = criteriaBuilder.equal(root.get("goWorkStatus"),"3");
                Predicate c2 = criteriaBuilder.equal(root.get("offWorkStatus"),"4");
                predicates.add(criteriaBuilder.or(c1,c2));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        return list;
    }
}
