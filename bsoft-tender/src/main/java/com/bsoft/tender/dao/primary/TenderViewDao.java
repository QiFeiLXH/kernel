package com.bsoft.tender.dao.primary;

import com.bsoft.tender.entity.primary.TenderDO;
import com.bsoft.tender.entity.primary.TenderViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TenderViewDao extends JpaRepository<TenderViewDO,Integer>, JpaSpecificationExecutor<TenderViewDO> {
    @Query("select a from TenderViewDO a where a.submitDate >= :start and a.submitDate <= :end")
    public List<TenderViewDO> getTender(@Param("start") Date start, @Param("end") Date end);
}
