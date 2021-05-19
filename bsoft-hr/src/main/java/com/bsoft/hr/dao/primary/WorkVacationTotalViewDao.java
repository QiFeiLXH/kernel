package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.WorkVacationTotalViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: zy
 * @date: 2020/8/20
 * @description 员工加班调休假（总览）Dao
 */
@Repository
public interface WorkVacationTotalViewDao extends JpaRepository<WorkVacationTotalViewDO, String>, JpaSpecificationExecutor<WorkVacationTotalViewDO> {
}
