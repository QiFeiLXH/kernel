package com.bsoft.clue.dao.primary;

import com.bsoft.clue.entity.primary.SalesCluesApprovalDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesCluesApprovalDao extends JpaRepository<SalesCluesApprovalDO,Integer>, JpaSpecificationExecutor<SalesCluesApprovalDO> {
    SalesCluesApprovalDO getByProcessInstanceId(String processInstancesID);
}
