package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.ClockInModeDeptSaveDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: zy
 * @date: 2020/8/30
 * @description 部门打卡方式
 */
@Repository
public interface ClockInModeDeptSaveDao extends JpaRepository<ClockInModeDeptSaveDO, String>, JpaSpecificationExecutor<ClockInModeDeptSaveDO> {
}
