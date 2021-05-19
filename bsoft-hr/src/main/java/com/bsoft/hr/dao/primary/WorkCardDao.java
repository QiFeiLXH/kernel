package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.WorkCardDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkCardDao extends JpaRepository<WorkCardDO, Integer>, JpaSpecificationExecutor<WorkCardDO> {
    @Modifying
    @Query("update WorkCardDO a set a.workcardFlag = :#{#workCardDO.workcardFlag}, a.recharge = :#{#workCardDO.recharge}, a.amount = :#{#workCardDO.amount}, a.accessControl = :#{#workCardDO.accessControl}, a.verifier = :#{#workCardDO.verifier}, a.verifyDate = :#{#workCardDO.verifyDate} , a.status = :#{#workCardDO.status}, a.received = :#{#workCardDO.received} , a.cardType = :#{#workCardDO.cardType} where a.personId = :#{#workCardDO.personId}")
    void verifyWorkCard(@Param("workCardDO")WorkCardDO workCardDO);

    @Modifying
    @Query("update WorkCardDO a set a.workCardNo = :#{#workCardDO.workCardNo}, a.maker = :#{#workCardDO.maker}, a.makeDate = :#{#workCardDO.makeDate}, a.status = :#{#workCardDO.status} where a.personId = :#{#workCardDO.personId}")
    void makeWorkCard(@Param("workCardDO")WorkCardDO workCardDO);

    @Modifying
    @Query("update WorkCardDO a set a.opener = :#{#workCardDO.opener}, a.openDate = :#{#workCardDO.openDate}, a.status = :#{#workCardDO.status} where a.personId = :#{#workCardDO.personId}")
    void openAccessWorkCard(@Param("workCardDO")WorkCardDO workCardDO);

    @Modifying
    @Query("update WorkCardDO a set a.received = 1 where a.personId = :personId")
    void receiveWorkCard(@Param("personId")String personId);
}

