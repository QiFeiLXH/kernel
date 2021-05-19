package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectDutyPaymentViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/5/13 10:33
 * @Description
 */
@Repository
public interface ProjectDutyPaymentViewDao extends JpaRepository<ProjectDutyPaymentViewDO,String>, JpaSpecificationExecutor<ProjectDutyPaymentViewDO> {
    List<ProjectDutyPaymentViewDO> findAllByDutyIdOrderByPaymentItemAsc(Integer dutyId);
}
