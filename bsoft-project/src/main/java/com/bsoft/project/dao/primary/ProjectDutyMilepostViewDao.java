package com.bsoft.project.dao.primary;

import com.bsoft.project.entity.primary.ProjectDutyMilepostViewDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDutyMilepostViewDao extends JpaRepository<ProjectDutyMilepostViewDO,Integer>, JpaSpecificationExecutor<ProjectDutyMilepostViewDO> {
    Page<ProjectDutyMilepostViewDO> findAllByContractNoAndDutyId(String contractNo, Integer dutyId, Pageable pageable);

    List<ProjectDutyMilepostViewDO> findAllByDutyId(Integer dutyId);
}
