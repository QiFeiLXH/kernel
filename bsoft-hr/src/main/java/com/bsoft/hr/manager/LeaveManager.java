package com.bsoft.hr.manager;

import com.bsoft.hr.condition.LeaveQueryCnd;
import com.bsoft.hr.entity.primary.*;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/20 8:53
 * @Description
 */
public interface LeaveManager {
    PageInfo<WorkLeaveVacationDO> getWorkLeaveVacationList(LeaveQueryCnd cnd);

    Page<LeaveInfoDO> getLeaveList(Integer pageNo, Integer pageSize, String personId, Integer type, String year);

    PageInfo<WorkVacationTotalDO> getWorkVacationTotalList(Integer pageNo, Integer pageSize, String personId, Integer type, String year);

    PageInfo<PersonalWorkLeaveVacationDO> getPersonalVacationList(Integer pageNo, Integer pageSize, String personId, String year);

    Page<LeaveInfoDO> getPersonalVacationUsedList(Integer pageNo, Integer pageSize, String personId, String year,Integer type);

    PageInfo<WorkVacationTotalDO> getPersonalTotalVacationList(Integer pageNo, Integer pageSize, String personId, String year, Integer type);

//    List<LeaveDO> getTodayLeaveList();

    List<LeaveDO> getLeaveListContainsToday();

    void updateLeaveAttendance();
}
