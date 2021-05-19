package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectDutyMilepostDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDutyMilepostDao extends JpaRepository<ProjectDutyMilepostDO,Integer>, JpaSpecificationExecutor<ProjectDutyMilepostDO> {
    List<ProjectDutyMilepostDO> findByContractNoOrderById(String contractNo);

    List<ProjectDutyMilepostDO> findByContractNoAndDutyIdOrderById(String contractNo, Integer dutyId);

    @Query("select milepost from ProjectDutyDO duty,ProjectDutyMilepostDO milepost where duty.id = milepost.dutyId and duty.auditFlag = 1 and milepost.contractNo = :contractNo and to_number(to_char(duty.startDate,'yyyy')) = :year")
    List<ProjectDutyMilepostDO> getDutyMilepostWithPlan(@Param("contractNo") String contractNo, @Param("year") Integer year);

    void deleteAllByDutyId(Integer dutyId);

    void deleteAllByIdIn(List<Integer> id);

    void deleteAllByDutyIdAndContractNoIn(Integer dutyId, List<String> contractNo);
}
