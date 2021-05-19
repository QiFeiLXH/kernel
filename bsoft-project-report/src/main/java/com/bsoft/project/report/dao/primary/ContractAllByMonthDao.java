package com.bsoft.project.report.dao.primary;

import com.bsoft.project.report.entity.primary.ContractAllByMonthDO;
import com.bsoft.project.report.entity.primary.ProjectAllByMonthDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author Xuhui Lin
 * @Date 2020-04-01
 * @Version 1.0
 * @Description
 */
@Repository
public interface ContractAllByMonthDao extends JpaRepository<ContractAllByMonthDO,Integer>, JpaSpecificationExecutor<ContractAllByMonthDO> {

}
