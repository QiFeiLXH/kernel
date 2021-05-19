package com.bsoft.person.dao.primary;

import com.bsoft.person.entity.primary.AwardDO;
import com.bsoft.person.entity.primary.WorkCertificateDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AwardDao extends JpaRepository<AwardDO,Integer>, JpaSpecificationExecutor<AwardDO> {
    List<AwardDO> findByPersonId(String personId);
}
