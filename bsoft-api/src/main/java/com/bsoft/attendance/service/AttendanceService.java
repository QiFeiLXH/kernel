package com.bsoft.attendance.service;

import com.bsoft.attendance.dto.AttendanceDTO;
import com.bsoft.attendance.dto.AttendanceViewDTO;
import com.bsoft.attendance.dto.AttendanceWholeDTO;
import com.bsoft.attendance.dto.WorkLogDTO;
import com.bsoft.common.result.Result;
import com.bsoft.house.dto.HouseDTO;
import com.bsoft.project.dto.ProjectDTO;

import java.sql.Date;
import java.util.List;

public interface AttendanceService {

    /**
     * 获取当日的考勤记录信息
     * @param personId
     * @return
     */
    public AttendanceViewDTO getTodayAttendance(String personId);

    /**
     * 获取当月所有考勤记录信息
     * @param personId
     * @return
     */
    public List<AttendanceViewDTO> getMonthAttendance(String personId);

    /**
     * 更新考勤上下班打卡时间及地点
     * @param attendanceViewDTO
     */
    void updateAttendance(AttendanceViewDTO attendanceViewDTO);

    /**
     * @Description: 根据考勤日期和工号获取当天的考勤记录和工作日志
     * @param date 考勤日期
     * @param personId 工号
     * @return AttendanceWholeDTO 考勤记录和工作日志对象
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public AttendanceWholeDTO getAttendance(Date date,String personId);

    /**
     * @Description: 根据工号获取当天的考勤记录和工作日志
     * @param personId 工号
     * @return AttendanceWholeDTO 考勤记录和工作日志对象
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public AttendanceWholeDTO getAttendance(String personId);

    /**
     * @Description: 保存考勤记录和工作日志
     * @param aw 考勤记录和工作日志整合对象
     * @return AttendanceWholeDTO 考勤记录和工作日志整合对象
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public AttendanceWholeDTO saveAttendance(AttendanceWholeDTO aw);
    /**
     * @Description: 保存考勤记录和工作日志
     * @param attendanceDTO 考勤表对象
     * @param workLog 日志对象
     * @return WorkLogDTO 日志对象
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public WorkLogDTO saveAttendance(AttendanceDTO attendanceDTO,WorkLogDTO workLog);

    /**
     * @Description: 根据主键删除工作日志
     * @param id
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public void deleteWorklog(Integer id);

    /**
     * @Description: 根据工号获取员工近七天写日志的项目列表
     * @param personId
     * @return List<ProjectDTO> 项目列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public List<ProjectDTO> getUsefulProject(String personId);

    /**
     * @Description: 根据工号获取员工近七天写日志的租房房屋列表
     * @param personId
     * @return List<HouseDTO> 租房房屋列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public List<HouseDTO> getUsefulHouse(String personId);

    /**
     * @Description: 根据工号获取员工最新rows条的考勤记录
     * @param personId 工号
     * @param days 最近days天
     * @return List<AttendanceDTO> 考勤详情列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public List<AttendanceDTO> getAttendanceList(String personId,Integer days);

    /**
     * @Description: 根据工号获取员工时间段内的考勤记录
     * @param personId 工号
     * @param start 开始时间
     * @param end 结束时间
     * @return List<AttendanceDTO> 考勤详情列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public Result<AttendanceViewDTO> getAttendanceList(String personId, java.util.Date start, java.util.Date end, Integer page, Integer size);

    /**
     * @Description: 根据考勤Id获取工作日志列表
     * @param attendanceId 考勤Id
     * @return List<AttendanceDTO> 考勤详情列表
     * @author xiangqj@bsoft.com.cn
     * @Time 2019年07月16日 下午3:53:24
     */
    public List<WorkLogDTO> getWorkLogList(Integer attendanceId);

    /**
     * App 端获取最近几天的考勤记录
     * @param personId
     * @param days
     * @return
     */
    public List<AttendanceViewDTO> getAttendanceByDays(String personId,Integer days);
}
