package com.bsoft.hr.repository.primary;

import com.bsoft.hr.condition.LeaveQueryCnd;
import com.bsoft.hr.entity.primary.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/8/19 10:45
 * @Description
 */
@Mapper
@Repository
public interface SickLeaveEmailRepository {

    /**
     * 查询过去一年来，员工的病假和长病假情况（单请上午，单请下午，上下午都请的次数）
     * @param date
     * @return
     */
    List<PersonSickLeaveDO> getSickLeave();
}
