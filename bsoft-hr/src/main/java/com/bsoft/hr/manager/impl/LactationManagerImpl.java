package com.bsoft.hr.manager.impl;

import com.bsoft.attendance.entity.primary.AttendanceDO;
import com.bsoft.attendance.manager.AttendanceManager;
import com.bsoft.attendance.manager.NonWorkDayManager;
import com.bsoft.common.entity.primary.ModifyRecordDO;
import com.bsoft.common.manager.ModifyRecordManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.utils.JSONUtils;
import com.bsoft.common.validate.ValidateUtil;
import com.bsoft.exception.ServiceException;
import com.bsoft.hr.condition.LactationQueryCnd;
import com.bsoft.hr.dao.primary.LactationDao;
import com.bsoft.hr.dao.primary.LactationViewDao;
import com.bsoft.hr.entity.primary.LactationDO;
import com.bsoft.hr.entity.primary.LactationViewDO;
import com.bsoft.hr.manager.LactationManager;
import org.apache.commons.lang3.StringUtils;
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
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/5 10:17
 * @Description
 */
@Service
public class LactationManagerImpl implements LactationManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(LactationManagerImpl.class);

    @Autowired
    private LactationDao lactationDao;
    @Autowired
    private LactationViewDao lactationViewDao;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private NonWorkDayManager nonWorkDayManager;
    @Autowired
    private ModifyRecordManager modifyRecordManager;
    @Autowired
    private AttendanceManager attendanceManager;

    @Override
    public Page<LactationViewDO> getLactationList(LactationQueryCnd cnd) {
        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(cnd.getPageNo()-1,cnd.getPageSize(),sort);
        Page<LactationViewDO> pages = lactationViewDao.findAll(new Specification<LactationViewDO>() {
            @Override
            public Predicate toPredicate(Root<LactationViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(cnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("personId"),"%"+cnd.getInputContent()+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("simpleCode"),"%"+cnd.getInputContent().toLowerCase()+"%");
                    Predicate c3 = criteriaBuilder.like(root.get("personName"),"%"+cnd.getInputContent()+"%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3));
                }
                if (cnd.getStatus().isEmpty()) {
                    predicates.add(criteriaBuilder.isNull(root.get("status")));
                } else if (cnd.getStatus().size() == 1) {
                    predicates.add(criteriaBuilder.equal(root.get("status"), cnd.getStatus().get(0)));
                } else {
                    predicates.add(criteriaBuilder.or(root.get("status").as(Integer.class).in(cnd.getStatus())));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    @Transactional
    public Integer saveLactation(LactationDO lactationDO) {
        List<LactationViewDO> lactations = lactationViewDao.findAllByPersonIdAndStatusIn(lactationDO.getPersonId(), Arrays.asList(1, 2));
        java.util.Date startDate = lactationDO.getStartDate();
        java.util.Date endDate = lactationDO.getEndDate();
        lactations.forEach(lactation -> {
            if (!(lactation.getStartDate().after(endDate) || lactation.getStartDate().equals(endDate) || lactation.getEndDate().before(startDate) || lactation.getEndDate().equals(startDate))) {
                throw new ServiceException("????????? " + lactationDO.getPersonId() + " ?????????????????????????????????????????????????????????????????????????????????????????????");
            }
        });
        Date serverDate = serverDateManager.getServerDate();
        lactationDO.setSubmitDate(serverDate);
        ValidateUtil.check(lactationDO);
        lactationDao.save(lactationDO);
        return lactationDO.getId();
    }

    @Override
    @Transactional
    public void updateLactation(LactationDO lactationDO) {
        List<LactationViewDO> lactations = lactationViewDao.findAllByPersonIdAndStatusIn(lactationDO.getPersonId(), Arrays.asList(1, 2));
        java.util.Date startDate = lactationDO.getStartDate();
        java.util.Date endDate = lactationDO.getEndDate();
        lactations.forEach(lactation -> {
            if (!lactation.getId().equals(lactationDO.getId())) {
                if (!(lactation.getStartDate().after(endDate) || lactation.getStartDate().equals(endDate) || lactation.getEndDate().before(startDate) || lactation.getEndDate().equals(startDate))) {
                    throw new ServiceException("????????? " + lactationDO.getPersonId() + " ?????????????????????????????????????????????????????????????????????????????????????????????");
                }
            }
        });
        lactationDao.updateLactation(lactationDO);
    }

    @Override
    public List<LactationViewDO> getValidLactationPersonIdList() {
        return lactationViewDao.getValidLactationPersonIdList();
    }

    @Override
    @Transactional
    public void updateLactationAttendance() {
        LOGGER.info("????????????-?????????????????????????????????");
        // ?????????????????????????????????????????????
        Date attenanceDate = serverDateManager.getServerDate();
        // ??????????????????????????????????????????????????????????????????????????????????????????
        Boolean workDay = nonWorkDayManager.isWorkDay(attenanceDate);
        if (!workDay) {
            LOGGER.info("????????????-???????????????????????????");
            return;
        }
        // ????????????????????????????????????
        List<LactationViewDO> lactations = this.getValidLactationPersonIdList();
        LOGGER.info("????????????-????????????????????????????????????[{}}", JSONUtils.toString(lactations));

        if (!lactations.isEmpty()) {
            List<String> personIds = lactations.stream().map(LactationViewDO::getPersonId).collect(Collectors.toList());
            Map<String, Double> personDurationMap = lactations.stream().collect(Collectors.toMap(LactationViewDO::getPersonId, LactationViewDO::getDuration));

            // ???????????????????????????????????????????????????????????????
            List<AttendanceDO> attendanceDOS = attendanceManager.getNeedUpdateLactationAttendanceRecord(personIds, attenanceDate);
            // ????????????
            Map<String, Object> data = processAttendanceAndLactationRecord(attendanceDOS, personDurationMap, attenanceDate);
            List<AttendanceDO> attendances = (List<AttendanceDO>)data.get("attendance");
            List<ModifyRecordDO> modifys = (List<ModifyRecordDO>)data.get("modify");
            // ??????????????????
            if (!attendances.isEmpty()) {
                attendanceManager.saveAll(attendances);
                LOGGER.info("????????????-???????????????????????????????????????");
            }

            // ??????????????????
            if (!modifys.isEmpty()) {
                modifyRecordManager.saveAttendanceModifyRecords(modifys);
                LOGGER.info("????????????-???????????????????????????????????????");
            }

        }
    }

    private Map<String, Object> processAttendanceAndLactationRecord(List<AttendanceDO> attendanceDOS, Map<String, Double> personDurationMap, Date attenanceDate) {
        List<AttendanceDO> needUpdateAttendDOS = new ArrayList<>();
        List<ModifyRecordDO> modifyDOS = new ArrayList<>();
        java.util.Date modifyTime = serverDateManager.getServerDateTime();
        LocalDate localDate = attenanceDate.toLocalDate();
        LocalTime goTime = LocalTime.of(9,0,0);
        LocalTime offTime = LocalTime.of(17,45,0);
        // ??????????????????
        LocalDateTime goWorkTime = LocalDateTime.of(localDate,goTime);
        // ??????????????????
        LocalDateTime offWorkTime = LocalDateTime.of(localDate,offTime);
        attendanceDOS.forEach(attendanceDO -> {
            StringBuffer supplement = new StringBuffer("?????????????????????????????????");
            Double totalDiff = 0.0;
            // ??????????????????
            java.util.Date realGoWorkTime = attendanceDO.getGoWorkTime();
            // ??????????????????
            java.util.Date realOffWorkTime = attendanceDO.getOffWorkTime();
            // ??????
            if ("3".equals(attendanceDO.getGoWorkStatus())) {
                totalDiff += (new BigDecimal(realGoWorkTime.getTime()).doubleValue() - new BigDecimal(goWorkTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()).doubleValue()) / 1000 / 60 / 60;
            }
            //  ??????
            if ("4".equals(attendanceDO.getOffWorkStatus())) {
                totalDiff += (new BigDecimal(offWorkTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()).doubleValue() - new BigDecimal(realOffWorkTime.getTime()).doubleValue()) / 1000 / 60 / 60;
            }
            // ???????????????????????????
            if (totalDiff <= personDurationMap.get(attendanceDO.getPersonId())) {
                // ??????
                if ("3".equals(attendanceDO.getGoWorkStatus())) {
                    attendanceDO.setGoWorkStatus("1");
                    supplement.append("??????????????????????????????????????????");
                }
                //  ??????
                if ("4".equals(attendanceDO.getOffWorkStatus())) {
                    attendanceDO.setOffWorkStatus("1");
                    supplement.append("??????????????????????????????????????????");
                }
                attendanceDO.setSupplement(supplement.toString());
                needUpdateAttendDOS.add(attendanceDO);

                // ????????????????????????
                ModifyRecordDO modifyDO = new ModifyRecordDO();
                modifyDO.setMainId(attendanceDO.getId().toString());
                modifyDO.setModifyDetail(3);
                modifyDO.setModifyType("??????");
                modifyDO.setModifyPersonId("system");
                modifyDO.setModifyDate(modifyTime);
                modifyDO.setModifyContent(supplement.toString());
                modifyDOS.add(modifyDO);
            }

        });
        Map<String, Object> data = new HashMap<>();
        data.put("attendance", needUpdateAttendDOS);
        data.put("modify", modifyDOS);
        return data;
    }
}
