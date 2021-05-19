package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.LeaveDO;
import com.bsoft.hr.entity.primary.WorkVacationDetailDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkVacationDetailDao extends JpaRepository<WorkVacationDetailDO, Integer>, JpaSpecificationExecutor<WorkVacationDetailDO> {
    List<WorkVacationDetailDO> findAllByWorkIdIn(List<Integer> workIds);

    List<WorkVacationDetailDO> findAllByTypeAndUseFlagOrderByEndDateAsc(Integer type,Integer useFlag);
}
