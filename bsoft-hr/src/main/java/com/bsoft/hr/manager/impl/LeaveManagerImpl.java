package com.bsoft.hr.manager.impl;

import com.bsoft.attendance.entity.primary.AttendanceDO;
import com.bsoft.attendance.manager.AttendanceManager;
import com.bsoft.attendance.manager.NonWorkDayManager;
import com.bsoft.common.entity.primary.ModifyRecordDO;
import com.bsoft.common.manager.HumanDicManager;
import com.bsoft.common.manager.ModifyRecordManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.hr.condition.LeaveQueryCnd;
import com.bsoft.hr.dao.primary.LeaveDao;
import com.bsoft.hr.dao.primary.LeaveInfoDao;
import com.bsoft.hr.entity.primary.*;
import com.bsoft.hr.manager.LeaveManager;
import com.bsoft.hr.repository.primary.LeaveRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/20 8:54
 * @Description
 */
@Service
public class LeaveManagerImpl implements LeaveManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(LeaveManagerImpl.class);
    @Autowired
    private LeaveRepository leaveRepository;
    @Autowired
    private LeaveDao leaveDao;
    @Autowired
    private LeaveInfoDao leaveInfoDao;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private HumanDicManager humanDicManager;
    @Autowired
    private NonWorkDayManager nonWorkDayManager;
    @Autowired
    private AttendanceManager attendanceManager;
    @Autowired
    private ModifyRecordManager modifyRecordManager;

    @Override
    public PageInfo<WorkLeaveVacationDO> getWorkLeaveVacationList(LeaveQueryCnd cnd) {
        PageHelper.startPage(cnd.getPageNo(), cnd.getPageSize());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(serverDateManager.getServerDateTime());
        int currentYear = calendar.get(Calendar.YEAR);
        Integer queryYear = Integer.valueOf(cnd.getYear());
        calendar.setTime(cnd.getStartDate());
        calendar.add(Calendar.YEAR, -1);
        cnd.setPreStartDate(calendar.getTime());
        calendar.setTime(cnd.getEndDate());
        calendar.add(Calendar.YEAR, -1);
        cnd.setPreEndDate(calendar.getTime());
        List<WorkLeaveVacationDO> list = null;
        if (queryYear > currentYear) {
            list = new ArrayList<>();
        } else {
            list = leaveRepository.getWorkLeaveVacationList(cnd);
        }
        PageInfo<WorkLeaveVacationDO> pageInfos = new PageInfo<>(list);
        return pageInfos;
    }

    @Override
    public Page<LeaveInfoDO> getLeaveList(Integer pageNo, Integer pageSize, String personId, Integer type, String year) {
        Sort sort = Sort.by("applyDate").descending()
                .and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,sort);
        Page<LeaveInfoDO> pages = leaveInfoDao.findAll(new Specification<LeaveInfoDO>() {
            @Override
            public Predicate toPredicate(Root<LeaveInfoDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("year"), year));
                predicates.add(criteriaBuilder.equal(root.get("personId"), personId));
                predicates.add(criteriaBuilder.equal(root.get("type"), type));

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    public PageInfo<WorkVacationTotalDO> getWorkVacationTotalList(Integer pageNo, Integer pageSize, String personId, Integer type, String year) {
        PageHelper.startPage(pageNo, pageSize);
        List<WorkVacationTotalDO> list = leaveRepository.getTotalVacationList(personId, year, type);
        PageInfo<WorkVacationTotalDO> pageInfos = new PageInfo<>(list);
        return pageInfos;
    }

    @Override
    public PageInfo<PersonalWorkLeaveVacationDO> getPersonalVacationList(Integer pageNo, Integer pageSize, String personId, String year) {
        PageHelper.startPage(pageNo, pageSize);
        List<PersonalWorkLeaveVacationDO> list = null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(serverDateManager.getServerDateTime());
        int currentYear = calendar.get(Calendar.YEAR);
        Integer queryYear = Integer.valueOf(year);
        if (queryYear > currentYear) {
            list = new ArrayList<>();
        } else {
           list = leaveRepository.getPersonalVacationList(personId, year);
        }

        PageInfo<PersonalWorkLeaveVacationDO> pageInfos = new PageInfo<>(list);
        return pageInfos;
    }

    @Override
    public Page<LeaveInfoDO> getPersonalVacationUsedList(Integer pageNo, Integer pageSize, String personId, String year,Integer type) {
        Sort sort = Sort.by("applyDate").descending()
                .and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,sort);
        Page<LeaveInfoDO> pages = leaveInfoDao.findAll(new Specification<LeaveInfoDO>() {
            @Override
            public Predicate toPredicate(Root<LeaveInfoDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("year"), year));
                predicates.add(criteriaBuilder.equal(root.get("personId"), personId));
                predicates.add(criteriaBuilder.equal(root.get("type"), type));

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    public PageInfo<WorkVacationTotalDO> getPersonalTotalVacationList(Integer pageNo, Integer pageSize, String personId, String year, Integer type) {
        List<WorkVacationTotalDO> list = leaveRepository.getPersonalTotalVacationList(personId,year,type);
        PageInfo<WorkVacationTotalDO> pageInfos = new PageInfo<>(list);
        return pageInfos;
    }

//    @Override
//    public List<LeaveDO> getTodayLeaveList() {
//        Date serverDate = serverDateManager.getServerDate();
//        List<LeaveDO> list = leaveDao.findAllByLeaveDateAndAuditFlag(serverDate, 1);
//        return list;
//    }

    @Override
    public List<LeaveDO> getLeaveListContainsToday() {
        Date serverDate = serverDateManager.getServerDate();
        List<LeaveDO> list = leaveDao.findAllWithLeave(serverDate, 1);
        return list;
    }

    @Override
    @Transactional
    public void updateLeaveAttendance() {
        LOGGER.info("????????????-??????????????????????????????");
        // ?????????????????????????????????
        List<LeaveDO> leaveList = this.getLeaveListContainsToday();
        if (leaveList.isEmpty()) {
            return;
        }

        // ?????????????????????????????????????????????
        Date attenanceDate = serverDateManager.getServerDate();
        // ??????????????????????????????????????????????????????????????????????????????????????????
        Boolean workDay = nonWorkDayManager.isWorkDay(attenanceDate);
        if (!workDay) {
            LOGGER.info("????????????-???????????????????????????");
            return;
        }
        updateAttendanceInfo(leaveList,attenanceDate);
    }


    private void updateAttendanceInfo(List<LeaveDO> leaveList,Date attenanceDate) {
        // ??????????????????map
        Map<String, String> attendanceDicMap = humanDicManager.getDic(30);
        // ??????????????????
        List<String> personIdList = leaveList.stream().map(LeaveDO::getPersonId).collect(Collectors.toList());
        java.util.Date modifyTime = serverDateManager.getServerDateTime();
        List<AttendanceDO> attendanceDOS = attendanceManager.getNeedUpdateAttendanceRecord(personIdList,attenanceDate);
        LOGGER.info("????????????-??????????????????????????????????????????");

        List<ModifyRecordDO> modifyDOS = new ArrayList<>();
        Map<String, AttendanceDO> attendanceDOMap = attendanceDOS.stream().collect(Collectors.toMap(AttendanceDO::getPersonId, attendanceDO -> attendanceDO));
        leaveList.forEach(leaveDO -> {
            AttendanceDO attendanceDO = attendanceDOMap.get(leaveDO.getPersonId());
            java.util.Date attendanceDate = attendanceDO.getAttendanceDate();
            String supplement = "???"+leaveDO.getLshid()+"?????????????????????????????????????????? " + attendanceDicMap.get(leaveDO.getType().toString());
            if(DateUtils.isSameDay(attendanceDate,leaveDO.getStartDate())){ //??????????????????????????????
                // ???????????????????????????
                if (leaveDO.getStartFlag() == 1){
                    // ????????????,????????????????????????
                    attendanceDO.setGoWorkStatus(leaveDO.getType().toString());
                }

                if (leaveDO.getStartFlag() == 2){
                    // ????????????,????????????????????????
                    attendanceDO.setOffWorkStatus(leaveDO.getType().toString());
                }
            }
            if(DateUtils.isSameDay(attendanceDate,leaveDO.getEndDate())){ //?????????????????????????????????
                // ???????????????????????????
                if (leaveDO.getEndFlag() == 1){
                    // ????????????,????????????????????????
                    attendanceDO.setGoWorkStatus(leaveDO.getType().toString());
                }

                if (leaveDO.getEndFlag() == 2){
                    // ????????????,????????????????????????
                    attendanceDO.setOffWorkStatus(leaveDO.getType().toString());
                }
            }
            if(attendanceDate.after(leaveDO.getStartDate()) && attendanceDate.before(leaveDO.getEndDate())){ //?????????????????????????????????
                attendanceDO.setGoWorkStatus(leaveDO.getType().toString());
                attendanceDO.setOffWorkStatus(leaveDO.getType().toString());
            }
            attendanceDO.setSupplement(supplement);

            // ????????????????????????
            ModifyRecordDO modifyDO = new ModifyRecordDO();
            modifyDO.setMainId(attendanceDO.getId().toString());
            modifyDO.setModifyDetail(3);
            modifyDO.setModifyType("??????");
            modifyDO.setModifyPersonId("system");
            modifyDO.setModifyDate(modifyTime);
            modifyDO.setModifyContent(supplement);
            modifyDOS.add(modifyDO);
        });
        // ??????????????????
        attendanceManager.saveAll(attendanceDOS);
        LOGGER.info("????????????-???????????????????????????????????????");
        // ??????????????????
        modifyRecordManager.saveAttendanceModifyRecords(modifyDOS);
        LOGGER.info("????????????-????????????????????????????????????");

    }

}
