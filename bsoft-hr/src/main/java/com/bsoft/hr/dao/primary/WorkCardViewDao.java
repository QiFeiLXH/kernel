package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.WorkCardViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkCardViewDao extends JpaRepository<WorkCardViewDO, Integer>, JpaSpecificationExecutor<WorkCardViewDO> {
    @Query("select count(1) from WorkCardViewDO a where  a.status = 1")
    Integer getPortalWorkCardVerifyNeedDoCount();

    @Query("select count(1) from WorkCardViewDO a where  a.status = 2")
    Integer getPortalWorkCardMakeNeedDoCount();

    @Query("select count(1) from WorkCardViewDO a where  a.status = 3")
    Integer getPortalWorkCardOpenNeedDoCount();

    @Query("select count(1) from WorkCardViewDO a where  a.status > 2 and a.received = 0")
    Integer getPortalWorkCardReceiveNeedDoCount();

    List<WorkCardViewDO> findAllByPersonIdIn(List<String> personIds);
}

