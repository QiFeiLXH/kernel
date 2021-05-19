package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.EducationDO;
import com.bsoft.person.entity.primary.WorkDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EducationDao extends JpaRepository<EducationDO,Integer>, JpaSpecificationExecutor<EducationDO> {

    public List<EducationDO> findAllByZpidOrderByEndDateDesc(Integer zpid);

    @Query("select a from EducationDO a where a.zpid = :zpid and a.startDate <= :start and a.endDate >= :start order by a.endDate desc")
    List<EducationDO> findAllByEducationsByStartDate(@Param("zpid") Integer zpid,@Param("start") Date start);

}
