package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.PositionDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PositionDao extends JpaRepository<PositionDO,Integer>, JpaSpecificationExecutor<PositionDO> {
    void deleteAllByRecruitmentId(Integer recruitmentId);

    @Query("select a from PositionDO a where a.TransferDate = :ddrq and a.personId = :yggh")
    List<PositionDO> findAllByDate(@Param("ddrq") Date ddrq,@Param("yggh") String yggh);

    @Query("select a from PositionDO a where a.TransferDate > :ddrq and a.personId = :yggh")
    List<PositionDO> findAllByDateAfter(@Param("ddrq") Date ddrq,@Param("yggh") String yggh);
}
