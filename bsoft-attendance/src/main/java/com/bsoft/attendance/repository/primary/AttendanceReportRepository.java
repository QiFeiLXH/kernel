package com.bsoft.attendance.repository.primary;

import com.bsoft.attendance.entity.primary.DeptSecretaryPersonDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2021/1/8 9:37
 * @Description 考勤统计
 */
@Mapper
@Repository
public interface AttendanceReportRepository {
    List<DeptSecretaryPersonDO> getDeptSecretaryPerson();
}
