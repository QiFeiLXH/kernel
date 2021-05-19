package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectPlanDetailDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhanglf
 * @Date 2020-01-19 10:22
 * @Version 1.0
 * @Description
 */
@Repository
public interface ProjectPlanDetailDao extends JpaRepository<ProjectPlanDetailDO,Integer>, JpaSpecificationExecutor<ProjectPlanDetailDO> {
    List<ProjectPlanDetailDO> findByPlanIdOrderByLogoffAscMilepostIdAscSortAsc(Integer planId);

    @Query(value = "select b from ProjectPlanDO a,ProjectPlanDetailDO b where a.id = b.planId and a.htbh = :contractId and b.milepostDutyId = :milepostDutyId")
    List<ProjectPlanDetailDO> findByContractIdAndMilepostDutyId(@Param("contractId") String contractId,@Param("milepostDutyId") Integer milepostDutyId);
}
