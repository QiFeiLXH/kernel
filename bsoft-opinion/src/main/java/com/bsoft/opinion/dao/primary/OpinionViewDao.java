package com.bsoft.opinion.dao.primary;

import com.bsoft.opinion.entity.primary.OpinionViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionViewDao extends JpaRepository<OpinionViewDO,Integer>, JpaSpecificationExecutor<OpinionViewDO> {

}
