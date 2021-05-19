package com.bsoft.workflow.dao.primary;

import com.bsoft.workflow.entity.primary.ProcessDeployDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessDeployDao extends JpaRepository<ProcessDeployDO,Integer>, JpaSpecificationExecutor<ProcessDeployDO> {
    List<ProcessDeployDO> findByStatus(Integer status);
    List<ProcessDeployDO> findByKey(String processKey);
}
