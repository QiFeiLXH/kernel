package com.bsoft.attendance.service.impl;

import com.bsoft.attendance.dto.AttendanceDTO;
import com.bsoft.attendance.dto.AttendanceViewDTO;
import com.bsoft.attendance.dto.AttendanceWholeDTO;
import com.bsoft.attendance.dto.WorkLogDTO;
import com.bsoft.attendance.entity.primary.*;
import com.bsoft.attendance.manager.AttendanceManager;
import com.bsoft.attendance.manager.NonWorkDayManager;
import com.bsoft.attendance.service.AttendanceService;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.key.KeyGenerator;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.exception.ServiceException;
import com.bsoft.house.dto.HouseDTO;
import com.bsoft.house.entity.primary.HouseDO;
import com.bsoft.project.dto.ProjectDTO;
import com.bsoft.project.entity.primary.ProjectDO;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.sql.Date;
import java.text.DecimalFormat;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private static final Logger logger = LoggerFactory.getLogger(AttendanceServiceImpl.class);

    @Autowired
    private AttendanceManager attendanceManager;

    @Autowired
    private IGenerator generatorUtil;
    @Autowired
    private KeyGenerator keyGenerator;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private NonWorkDayManager nonWorkDayManager;

    @Override
    public AttendanceViewDTO getTodayAttendance(String personId) {
        AttendanceViewDO attendanceViewDO = attendanceManager.getAttendanceView(personId);
        return generatorUtil.convert(attendanceViewDO,AttendanceViewDTO.class);
    }

    @Override
    public List<AttendanceViewDTO> getMonthAttendance(String personId) {
        List<AttendanceViewDO> list = attendanceManager.getMonthAttendance(personId);
        return generatorUtil.convert(list,AttendanceViewDTO.class);
    }

    @Override
    public void updateAttendance(AttendanceViewDTO attendanceViewDTO) {
        AttendanceViewDO attendanceViewDO = generatorUtil.convert(attendanceViewDTO,AttendanceViewDO.class);
        attendanceManager.updateAttendance(attendanceViewDO);
    }

    @Override
    public AttendanceWholeDTO getAttendance(Date date, String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        AttendanceViewDO attendance = attendanceManager.getAttendanceView(personId,date);
        Integer id = attendance.getId();
        List<WorkLogViewDO> workLogList = attendanceManager.getWorkLogViewList(id);
        AttendanceDTO attendanceDTO = generatorUtil.convert(attendance,AttendanceDTO.class);
        List<WorkLogDTO> workLogDTOList = null;
        if(workLogList.size() > 0 ){
            workLogDTOList = generatorUtil.convert(workLogList,WorkLogDTO.class);
        }
        long times = timeConsumer.end();
        logger.info("工号{}获取{}的考勤和日志信息耗时:{}",new Object[]{personId,date.toString(),times});

        return new AttendanceWholeDTO(attendanceDTO,workLogDTOList);
    }

    @Override
    public AttendanceWholeDTO getAttendance(String personId) {
        Date date = serverDateManager.getServerDate();
        return getAttendance(date,personId);
    }

    @Override
    public AttendanceWholeDTO saveAttendance(AttendanceWholeDTO aw) {
        AttendanceDO attendance = generatorUtil.convert(aw.getAttendanceDTO(),AttendanceDO.class);
        List<WorkLogDO> workLogs = generatorUtil.convert(aw.getWorkLogList(),WorkLogDO.class);
        java.util.Date now = serverDateManager.getServerDateTime();
        attendance.setSubmitDate(now);
        for(WorkLogDO workLog : workLogs){
            if(workLog.getId() == null){
                Integer id = keyGenerator.increaseWorkLog();
                workLog.setId(id);
            }
            if(workLog.getSubmitDate() == null){
                workLog.setSubmitDate(now);
            }
        }
        AttendanceWholeDO attendanceWholeDO = attendanceManager.saveAttendanceWhole(attendance,workLogs);
        attendance = attendanceWholeDO.getAttendanceDO();
        workLogs = attendanceWholeDO.getWorkLogList();
        AttendanceDTO attendanceDTO = generatorUtil.convert(attendance,AttendanceDTO.class);
        List<WorkLogDTO> workLogList = generatorUtil.convert(workLogs,WorkLogDTO.class);
        return new AttendanceWholeDTO(attendanceDTO,workLogList);
    }

    @Override
    public WorkLogDTO saveAttendance(AttendanceDTO attendanceDTO, WorkLogDTO workLog) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        java.util.Date now = serverDateManager.getServerDateTime();
        AttendanceDO attendanceDO = generatorUtil.convert(attendanceDTO,AttendanceDO.class);
        if(attendanceDO.getId() == null){
            throw new ServiceException("没有主键，请检查");
        }
        WorkLogDO workLogDO = generatorUtil.convert(workLog,WorkLogDO.class);
        if(workLogDO.getId() == null){
            Integer id = keyGenerator.increaseWorkLog();
            workLogDO.setId(id);
        }
        if(workLogDO.getSubmitDate() == null){
            workLogDO.setSubmitDate(now);
        }
        workLogDO = attendanceManager.saveWorkLogWithTransactional(attendanceDO,workLogDO);
        long times = timeConsumer.end();
        logger.info("工号:{}保存日志耗时:{}",attendanceDTO.getPersonId(),times);
        return generatorUtil.convert(workLogDO,WorkLogDTO.class);
    }


    @Override
    public void deleteWorklog(Integer id) {
        attendanceManager.deleteWorkLog(id);
    }

    @Override
    public List<ProjectDTO> getUsefulProject(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<ProjectDO> list = attendanceManager.getUsefulProject(personId);
        long times = timeConsumer.end();
        logger.info("工号:{}获取常用日志项目耗时:{}",personId,times);
        return generatorUtil.convert(list,ProjectDTO.class);
    }

    @Override
    public List<HouseDTO> getUsefulHouse(String personId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<HouseDO> list = attendanceManager.getUsefulHouse(personId);
        long times = timeConsumer.end();
        logger.info("工号:{}获取常用日志房屋耗时:{}",personId,times);
        return generatorUtil.convert(list,HouseDTO.class);
    }

    @Override
    public List<AttendanceDTO> getAttendanceList(String personId, Integer days) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<AttendanceDO> list = attendanceManager.getAttendanceList(personId,days);
        List<AttendanceDTO> dtoList = generatorUtil.convert(list,AttendanceDTO.class);
        for(AttendanceDTO attendance  : dtoList){
            java.util.Date attendanceDate = attendance.getAttendanceDate();
            attendance.setWorkDay(nonWorkDayManager.isWorkDay(attendanceDate));
        }
        long times = timeConsumer.end();
        logger.info("工号:{}获取最近{}天的日志耗时:{}",new Object[]{personId,days,times});
        return dtoList;
    }

    @Override
    public Result<AttendanceViewDTO> getAttendanceList(String personId, java.util.Date start, java.util.Date end,Integer page,Integer size) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        Page<AttendanceViewDO> result = attendanceManager.getAttendanceList(personId,start,end,page,size);
        Result<AttendanceViewDTO> dtoList = ResultUtils.parseResult(result, AttendanceViewDTO.class);
        for(AttendanceViewDTO attendance  : dtoList.getItems()){
            java.util.Date attendanceDate = attendance.getAttendanceDate();
            attendance.setWorkDay(nonWorkDayManager.isWorkDay(attendanceDate));
        }
        long times = timeConsumer.end();
        logger.info("工号:{}获取{}到{}的日志耗时:{}",new Object[]{personId,start,end,times});
        return dtoList;
    }

    @Override
    public List<WorkLogDTO> getWorkLogList(Integer attendanceId) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<WorkLogViewDO> result = attendanceManager.getWorkLogViewList(attendanceId);
        long times = timeConsumer.end();
        logger.info("获取考勤Id:{}的工作日志耗时:{}",attendanceId,times);
        return generatorUtil.convert(result,WorkLogDTO.class);
    }

    @Override
    public List<AttendanceViewDTO> getAttendanceByDays(String personId, Integer days) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<AttendanceViewDO> list = attendanceManager.getAttendanceByDays(personId,days);
        long times = timeConsumer.end();
        logger.info("App获取{}考勤最近{}天的考勤记录耗时:{}",personId,days,times);
        return generatorUtil.convert(list,AttendanceViewDTO.class);
    }
}
