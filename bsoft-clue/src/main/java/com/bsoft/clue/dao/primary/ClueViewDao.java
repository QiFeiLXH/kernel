package com.bsoft.clue.dao.primary;

import com.bsoft.clue.entity.primary.ClueViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ClueViewDao extends JpaRepository<ClueViewDO,Integer>, JpaSpecificationExecutor<ClueViewDO> {
    @Query("select a from ClueViewDO a where a.submitDate >= :start and a.submitDate <= :end")
    public List<ClueViewDO> getClue(@Param("start") Date start, @Param("end") Date end);
}
