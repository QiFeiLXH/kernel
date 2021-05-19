package com.bsoft.attendance.service;

import com.bsoft.attendance.dto.AttendanceAbnormalDTO;
import com.bsoft.attendance.dto.AttendanceCountDetailDTO;
import com.bsoft.attendance.dto.AttendanceStatisticsCndDTO;
import com.bsoft.attendance.dto.AttendanceStatisticsDTO;
import com.bsoft.common.result.Result;

import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/1/19 17:31
 * @Description:
 */
public interface AttendanceStatisticsService {

    /**
     * 获取异常考勤信息
     * @param cndDTO
     * @return
     */
    List<AttendanceAbnormalDTO> getAttendanceAbnormal(AttendanceStatisticsCndDTO cndDTO);

    /**
     * 已生成的考勤统计信息
     * @param cndDTO
     * @return
     */
    Result<AttendanceStatisticsDTO> getAttendanceCount(AttendanceStatisticsCndDTO cndDTO);


    /**
     * 导出已生成的考勤统计信息
     * @param cndDTO
     * @return
     */
    List<AttendanceStatisticsDTO> getAllAttendanceCount(AttendanceStatisticsCndDTO cndDTO);

    /**
     * 生成考勤统计
     * @param cndDTO
     */
    void generAttendanceCount(AttendanceStatisticsCndDTO cndDTO);

    /**
     * 提交考勤统计
     * @param cndDTO
     */
    void commitAttendanceCount(AttendanceStatisticsCndDTO cndDTO);

    /**
     * 退回考勤统计
     * @param month
     * @param personIds
     */
    void backAttendanceCount(Date month, List<String> personIds);

    /**
     * 考勤统计明细考勤信息
     * @param startDate
     * @param endDate
     * @param personId
     * @param type
     * @return
     */
    List<AttendanceCountDetailDTO> getAttendanceCountDetail(Date startDate, Date endDate, String personId, String type);
}
