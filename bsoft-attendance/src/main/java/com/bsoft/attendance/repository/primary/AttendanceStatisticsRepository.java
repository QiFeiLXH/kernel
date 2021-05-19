package com.bsoft.attendance.repository.primary;

import com.bsoft.attendance.condition.AttendanceStatisticsCnd;
import com.bsoft.attendance.entity.primary.AttendanceAbnormalDO;
import com.bsoft.attendance.entity.primary.AttendanceCountDetailDO;
import com.bsoft.attendance.entity.primary.AttendancePositionDO;
import com.bsoft.attendance.entity.primary.AttendanceStatisticsDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/1/19 10:02
 * @Description: 考勤統計
 */
@Mapper
@Repository
public interface AttendanceStatisticsRepository {

    /**
     * 获取异常考勤信息
     * @param cnd
     * @return
     */
    List<AttendanceAbnormalDO> getAttendanceAbnormal(@Param("cnd") AttendanceStatisticsCnd cnd);

    List<AttendanceStatisticsDO> getAttendanceCount(@Param("kqyf") Date kqyf,@Param("cnd") AttendanceStatisticsCnd cnd);

    List<AttendanceStatisticsDO> getAttendanceCountCommited(@Param("kqyf") Date kqyf,@Param("cnd") AttendanceStatisticsCnd cnd);

    void backAttendance(@Param("startDate") Date startDate,@Param("endDate") Date endDate,@Param("personIds") List<String> personIds);

    List<AttendanceCountDetailDO> getAttendanceCountDetail(@Param("startDate") Date startDate,
                                                           @Param("endDate") Date endDate,
                                                           @Param("personId") String personId,
                                                           @Param("type") String type);

    Double getCommitFlag(@Param("startDate") Date startDate,
                         @Param("endDate") Date endDate,
                         @Param("personId") String personId,
                         @Param("dept") String dept,
                         @Param("inputContent") String inputContent);
}
