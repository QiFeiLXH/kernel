package com.bsoft.attendance.manager.impl;

import com.bsoft.attendance.condition.AttendanceStatisticsCnd;
import com.bsoft.attendance.dao.primary.AttendanceCountDao;
import com.bsoft.attendance.entity.primary.*;
import com.bsoft.attendance.manager.AttendanceStatisticsManager;
import com.bsoft.attendance.repository.primary.AttendanceStatisticsRepository;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.exception.ServiceException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * @Author: xucl
 * @DateTime: 2021/1/19 15:19
 * @Description:
 */

@Service
public class AttendanceStatisticsManagerImpl implements AttendanceStatisticsManager {
    @Autowired
    private AttendanceStatisticsRepository attendanceStatisticsRepository;
    @Autowired
    private AttendanceCountDao attendanceCountDao;

    //查询考勤异常信息
    @Override
    public List<AttendanceAbnormalDO> getAttendanceAbnormal(AttendanceStatisticsCnd cnd) {
        if (StringUtils.isBlank(cnd.getDept())){
            cnd.setDept("全部");
        }
        if ("1".equals(cnd.getAll().toString())){
            cnd.setPersonId("全部");
        }
        return attendanceStatisticsRepository.getAttendanceAbnormal(cnd);
    }

    //翻页查询考勤统计信息
    @Override
    public Result<AttendanceStatisticsDO> getAttendanceCount(AttendanceStatisticsCnd cnd) {
        PageHelper.startPage(cnd.getPageNo(), cnd.getPageSize());
        if (StringUtils.isBlank(cnd.getDept())){
            cnd.setDept("全部");
        }
        if ("1".equals(cnd.getAll().toString())){
            cnd.setPersonId("全部");
        }
        Date attendanceMonth = getFirstDay(cnd.getStartDate());
        //考勤统计列表信息
        List<AttendanceStatisticsDO> statisticsDOList = attendanceStatisticsRepository.getAttendanceCount(attendanceMonth,cnd);
        PageInfo<AttendanceStatisticsDO> pageInfo = new PageInfo<>(statisticsDOList);
        return ResultUtils.parseResult(pageInfo);
    }

    //不翻页查询考勤统计信息
    @Override
    public List<AttendanceStatisticsDO> getAllAttendanceCount(AttendanceStatisticsCnd cnd) {
        if (StringUtils.isBlank(cnd.getDept())){
            cnd.setDept("全部");
        }
        if ("1".equals(cnd.getAll().toString())){
            cnd.setPersonId("全部");
        }
        Date attendanceMonth = getFirstDay(cnd.getStartDate());
        List<AttendanceStatisticsDO> statisticsDOList = attendanceStatisticsRepository.getAttendanceCountCommited(attendanceMonth,cnd);
        return statisticsDOList;
    }

    //生成考勤统计
    @Override
    public void generAttendanceCount(AttendanceStatisticsCnd cnd) {
        String dept = StringUtils.isBlank(cnd.getDept()) ? "全部":cnd.getDept();
        String personId = "1".equals(cnd.getAll().toString()) ? "全部":cnd.getPersonId();
        String input = StringUtils.isBlank(cnd.getInputContent()) ?"":cnd.getInputContent();
        Double d = attendanceStatisticsRepository.getCommitFlag(cnd.getStartDate(),cnd.getEndDate(),personId,dept,input);
        if (d>0){
            throw new ServiceException("统计范围内有员工的考勤统计已提交，无法统计!");
        }
        attendanceCountDao.pd_ker_attendance_statis(cnd.getStartDate(),cnd.getEndDate(),personId,dept,input);
    }

    //提交考勤统计
    @Override
    public void commitAttendanceCount(AttendanceStatisticsCnd cnd) {
        String dept = StringUtils.isBlank(cnd.getDept()) ? "全部":cnd.getDept();
        String personId = "1".equals(cnd.getAll().toString()) ? "全部":cnd.getPersonId();
        String input = StringUtils.isBlank(cnd.getInputContent())?"":cnd.getInputContent();
        attendanceCountDao.pd_ker_attendance_statiscommit(cnd.getStartDate(),cnd.getEndDate(),personId,dept,input);
    }

    //退回考勤统计
    @Override
    public void backAttendanceCount(Date month, List<String> personIds) {
        Date startDate = getFirstDay(month);
        Date endDate = getLastDay(month);
        attendanceStatisticsRepository.backAttendance(startDate,endDate,personIds);
    }

    //查询考勤统计明细信息
    @Override
    public List<AttendanceCountDetailDO> getAttendanceCountDetail(Date startDate, Date endDate, String personId, String type) {
        return attendanceStatisticsRepository.getAttendanceCountDetail(startDate,endDate,personId,type);
    }

    /**
     * 获取当月首日
     * @param date
     * @return
     */
    private static Date getFirstDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        return calendar.getTime();
    }

    /**
     * 获取当月最后一日
     * @param date
     * @return
     */
    private static Date getLastDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.add(Calendar.MONTH,1);
        calendar.add(Calendar.DATE,-1);
        return calendar.getTime();
    }

}
