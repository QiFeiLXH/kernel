package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.ClockInModePersonalInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: zy
 * @date: 2020/8/30
 * @description 个人打卡方式
 */
@Repository
public interface ClockInModePersonalInfoDao extends JpaRepository<ClockInModePersonalInfoDO, String>, JpaSpecificationExecutor<ClockInModePersonalInfoDO> {
    List<ClockInModePersonalInfoDO> findByDept(String dept);
}
