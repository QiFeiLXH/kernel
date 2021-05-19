package com.bsoft.opinion.dao.primary;

import com.bsoft.opinion.entity.primary.OpinionDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionDao extends JpaRepository<OpinionDO,Integer>, JpaSpecificationExecutor<OpinionDO> {

}
