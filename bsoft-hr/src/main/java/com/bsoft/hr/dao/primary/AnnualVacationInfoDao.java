package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.AnnualVacationInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: zy
 * @date: 2020/8/26
 * @description
 */
@Repository
public interface AnnualVacationInfoDao extends JpaRepository<AnnualVacationInfoDO, Integer>, JpaSpecificationExecutor<AnnualVacationInfoDO> {
}
