package com.bsoft.project.report.dao.primary;

import com.bsoft.project.report.entity.primary.ContractAllSubTotalDO;
import com.bsoft.project.report.entity.primary.ProjectAllSubTotalDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020-04-01
 * @Version 1.0
 * @Description
 */
@Repository
public interface ContractAllSubTotalDao extends JpaRepository<ContractAllSubTotalDO,Integer>, JpaSpecificationExecutor<ContractAllSubTotalDO> {
}
