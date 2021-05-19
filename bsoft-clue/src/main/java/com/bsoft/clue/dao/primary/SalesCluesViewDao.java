package com.bsoft.clue.dao.primary;

import com.bsoft.clue.entity.primary.SalesCluesViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesCluesViewDao extends JpaRepository<SalesCluesViewDO,Integer>, JpaSpecificationExecutor<SalesCluesViewDO> {

}
