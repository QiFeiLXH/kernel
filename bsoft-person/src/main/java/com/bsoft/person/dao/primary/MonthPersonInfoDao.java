package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.MonthPersonInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @Author: xucl
 * @DateTime: 2020/12/31 14:30
 * @Description:
 */
@Repository
public interface MonthPersonInfoDao extends JpaRepository<MonthPersonInfoDO,String>, JpaSpecificationExecutor<MonthPersonInfoDO> {

    @Modifying
    @Query("update MonthPersonInfoDO a set a.dept =:dept,a.deptType =:deptType,a.jobCategory =:jobCategory,a.post =:post " +
            " where a.personId =:personId and a.month >= :startdate")
    void updateLastPersonInfo(@Param("dept") String dept,
                              @Param("deptType") Integer deptType,
                              @Param("jobCategory") Integer jobCategory,
                              @Param("post") String post,
                              @Param("personId") String personId,
                              @Param("startdate") Date startdate);
}
