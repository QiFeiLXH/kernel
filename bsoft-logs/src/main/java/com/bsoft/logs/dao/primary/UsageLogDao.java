package com.bsoft.logs.dao.primary;

import com.bsoft.logs.entity.primary.UsageLogDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UsageLogDao extends JpaRepository<UsageLogDO,Integer>, JpaSpecificationExecutor<UsageLogDO> {

}
