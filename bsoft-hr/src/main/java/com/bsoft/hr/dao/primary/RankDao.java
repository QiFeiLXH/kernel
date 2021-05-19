package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.RankDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RankDao extends JpaRepository<RankDO,Integer>, JpaSpecificationExecutor<RankDO> {
    @Query("select max(execDate) from RankDO where personId = :personId")
    Date getNewestRankDate(@Param("personId") String personId);

}
