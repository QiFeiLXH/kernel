package com.bsoft.attendance.manager;

import com.bsoft.attendance.condition.AttendanceStatisticsCnd;
import com.bsoft.attendance.entity.primary.AttendanceAbnormalDO;
import com.bsoft.attendance.entity.primary.AttendanceCountDetailDO;
import com.bsoft.attendance.entity.primary.AttendanceStatisticsDO;
import com.bsoft.common.result.Result;

import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/1/19 15:15
 * @Description: 考勤统计Manager
 */
public interface AttendanceStatisticsManager {

    //获取考勤异常的人员信息
    List<AttendanceAbnormalDO> getAttendanceAbnormal(AttendanceStatisticsCnd cnd);

    Result<AttendanceStatisticsDO> getAttendanceCount(AttendanceStatisticsCnd cnd);

    List<AttendanceStatisticsDO> getAllAttendanceCount(AttendanceStatisticsCnd cnd);

    void generAttendanceCount(AttendanceStatisticsCnd cnd);

    void commitAttendanceCount(AttendanceStatisticsCnd cnd);

    void backAttendanceCount(Date month, List<String> personIds);

    List<AttendanceCountDetailDO> getAttendanceCountDetail(Date startDate, Date endDate, String personId, String type);
}
