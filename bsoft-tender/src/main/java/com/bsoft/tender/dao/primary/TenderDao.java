package com.bsoft.tender.dao.primary;

import com.bsoft.tender.entity.primary.TenderDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface TenderDao  extends JpaRepository<TenderDO,Integer>, JpaSpecificationExecutor<TenderDO> {
    @Query("select a from TenderDO a where a.submitDate >= :start and a.submitDate <= :end")
    public List<TenderDO> getTender(@Param("start") Date start, @Param("end") Date end);
}
