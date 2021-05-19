package com.bsoft.attendance.service.impl;

import com.bsoft.attendance.condition.AttendanceStatisticsCnd;
import com.bsoft.attendance.dto.AttendanceAbnormalDTO;
import com.bsoft.attendance.dto.AttendanceCountDetailDTO;
import com.bsoft.attendance.dto.AttendanceStatisticsCndDTO;
import com.bsoft.attendance.dto.AttendanceStatisticsDTO;
import com.bsoft.attendance.entity.primary.AttendanceAbnormalDO;
import com.bsoft.attendance.entity.primary.AttendanceCountDetailDO;
import com.bsoft.attendance.entity.primary.AttendanceStatisticsDO;
import com.bsoft.attendance.manager.AttendanceStatisticsManager;
import com.bsoft.attendance.service.AttendanceStatisticsService;
import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/1/19 17:32
 * @Description:
 */
@Service
public class AttendanceStatisticsServiceImpl implements AttendanceStatisticsService {
    private static final Logger logger = LoggerFactory.getLogger(AttendanceStatisticsServiceImpl.class);

    @Autowired
    private AttendanceStatisticsManager attendanceManager;
    @Autowired
    private GeneratorUtil generatorUtil;

    @Override
    public List<AttendanceAbnormalDTO> getAttendanceAbnormal(AttendanceStatisticsCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        AttendanceStatisticsCnd cnd = generatorUtil.convert(cndDTO,AttendanceStatisticsCnd.class);
        List<AttendanceAbnormalDO> abnormalDOList = attendanceManager.getAttendanceAbnormal(cnd);
        List<AttendanceAbnormalDTO> attendanceAbnormalDTOS = generatorUtil.convert(abnormalDOList,AttendanceAbnormalDTO.class);
        long times = timeConsumer.end();
        logger.info("考勤统计，获取是否有考勤异常信息耗时:[{}]",times);
        return attendanceAbnormalDTOS;
    }

    @Override
    public Result<AttendanceStatisticsDTO> getAttendanceCount(AttendanceStatisticsCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        AttendanceStatisticsCnd cnd = generatorUtil.convert(cndDTO,AttendanceStatisticsCnd.class);
        Result<AttendanceStatisticsDO> attendanceStatisticsDOS = attendanceManager.getAttendanceCount(cnd);
        Result<AttendanceStatisticsDTO> attendanceStatisticsDTOS = generatorUtil.convert(attendanceStatisticsDOS,AttendanceStatisticsDTO.class);
        long times = timeConsumer.end();
        logger.info("考勤统计，获取已生成的考勤统计信息耗时:[{}]",times);
        return attendanceStatisticsDTOS;
    }

    @Override
    public List<AttendanceStatisticsDTO> getAllAttendanceCount(AttendanceStatisticsCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        AttendanceStatisticsCnd cnd = generatorUtil.convert(cndDTO,AttendanceStatisticsCnd.class);
        List<AttendanceStatisticsDO> attendanceStatisticsDOS = attendanceManager.getAllAttendanceCount(cnd);
        List<AttendanceStatisticsDTO> attendanceStatisticsDTOS = generatorUtil.convert(attendanceStatisticsDOS,AttendanceStatisticsDTO.class);
        long times = timeConsumer.end();
        logger.info("考勤统计，员工[{}]获取已生成的考勤统计信息耗时:[{}]",cndDTO.getPersonId(),times);
        return attendanceStatisticsDTOS;
    }

    @Override
    public void generAttendanceCount(AttendanceStatisticsCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        AttendanceStatisticsCnd cnd = generatorUtil.convert(cndDTO,AttendanceStatisticsCnd.class);
        attendanceManager.generAttendanceCount(cnd);
        long times = timeConsumer.end();
        logger.info("考勤统计，生成考勤统计信息耗时:[{}]",times);
    }

    @Override
    public void commitAttendanceCount(AttendanceStatisticsCndDTO cndDTO) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        AttendanceStatisticsCnd cnd = generatorUtil.convert(cndDTO,AttendanceStatisticsCnd.class);
        attendanceManager.commitAttendanceCount(cnd);
        long times = timeConsumer.end();
        logger.info("考勤统计，提交已生成的考勤统计信息耗时:[{}]",times);
    }

    @Override
    public void backAttendanceCount(Date month, List<String> personIds) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        attendanceManager.backAttendanceCount(month,personIds);
        long times = timeConsumer.end();
        logger.info("考勤统计，退回已生成的考勤统计信息耗时:[{}]",times);
    }

    @Override
    public List<AttendanceCountDetailDTO> getAttendanceCountDetail(Date startDate, Date endDate, String personId, String type) {
        TimeConsumer timeConsumer = TimeConsumer.start();
        List<AttendanceCountDetailDO> list = attendanceManager.getAttendanceCountDetail(startDate,endDate,personId,type);
        long times = timeConsumer.end();
        logger.info("考勤统计，获取考勤明细信息耗时:[{}]",times);
        return generatorUtil.convert(list,AttendanceCountDetailDTO.class);
    }
}
