package com.bsoft.clue.dao.primary;

import com.bsoft.clue.entity.primary.SalesCluesDeptDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesCluesDeptDao extends JpaRepository<SalesCluesDeptDO,Integer>, JpaSpecificationExecutor<SalesCluesDeptDO> {
}
