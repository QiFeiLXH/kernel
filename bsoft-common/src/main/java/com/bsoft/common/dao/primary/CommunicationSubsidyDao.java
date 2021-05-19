package com.bsoft.common.dao.primary;

import com.bsoft.common.entity.primary.CommunicationSubsidyDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: xucl
 * @DateTime: 2020/12/30 15:19
 * @Description:
 */
@Repository
public interface CommunicationSubsidyDao extends JpaRepository<CommunicationSubsidyDO,Integer>, JpaSpecificationExecutor<CommunicationSubsidyDO> {
}

