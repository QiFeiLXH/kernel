package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.PersonCostLimitDO;
import com.bsoft.person.entity.primary.PersonTransferConditionsDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonTransferConditionDao extends JpaRepository<PersonTransferConditionsDO,String>, JpaSpecificationExecutor<PersonTransferConditionsDO> {

}
