package com.bsoft.workflow.dao.primary;

import com.bsoft.workflow.entity.primary.ActionRecordDO;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionRecordDao extends JpaRepository<ActionRecordDO,Integer>, JpaSpecificationExecutor<ActionRecordDO> {

    List<ActionRecordDO> findAllByProcessInstanceIdOrderById(@Param("processInstanceId") String processInstanceId);
    List<ActionRecordDO> findAllByProcessInstanceIdOrderByAuditDateAscIdAsc(@Param("processInstanceId") String processInstanceId);

}
