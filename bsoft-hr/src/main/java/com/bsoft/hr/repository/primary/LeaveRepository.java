package com.bsoft.hr.repository.primary;

import com.bsoft.hr.condition.LeaveQueryCnd;
import com.bsoft.hr.entity.primary.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/19 10:45
 * @Description
 */
@Mapper
@Repository
public interface LeaveRepository {
    List<WorkLeaveVacationDO> getWorkLeaveVacationList(@Param("cnd") LeaveQueryCnd cnd);

    List<WorkVacationTotalDO> getLastYearVacationDaysList(@Param("personId")String personId, @Param("type")Integer type, @Param("year")String year);

    List<WorkVacationTotalDO> getCurrentYearVacationList(@Param("personId")String personId, @Param("type")Integer type, @Param("year")String year);

    List<PersonalWorkLeaveVacationDO> getPersonalVacationList(@Param("personId")String personId, @Param("year")String year);

    List<WorkVacationTotalDO> getTotalVacationList(@Param("personId")String personId, @Param("year")String year,@Param("type")Integer type);

    List<WorkVacationTotalDO> getPersonalTotalVacationList(@Param("personId")String personId, @Param("year")String year,@Param("type")Integer type);

    List<LeaveDO> getPersonalLeaveList(@Param("personId")String personId, @Param("year")String year, @Param("type")Integer type);


    /**
     * 统一扣除年假时，获取还有剩余年假的员工
     * @param cnd
     * @return
     */
    List<WorkLeaveVacationDO> getAnnualVacationUnified(@Param("cnd") LeaveQueryCnd cnd);
}
