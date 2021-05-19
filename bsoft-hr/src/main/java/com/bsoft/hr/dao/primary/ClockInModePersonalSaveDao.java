package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.ClockInModePersonalSaveDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: zy
 * @date: 2020/8/30
 * @description 个人打卡方式
 */
@Repository
public interface ClockInModePersonalSaveDao extends JpaRepository<ClockInModePersonalSaveDO, String>, JpaSpecificationExecutor<ClockInModePersonalSaveDO> {
}
