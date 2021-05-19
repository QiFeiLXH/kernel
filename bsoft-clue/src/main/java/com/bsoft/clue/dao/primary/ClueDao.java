package com.bsoft.clue.dao.primary;

import com.bsoft.clue.entity.primary.ClueDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface ClueDao extends JpaRepository<ClueDO,Integer>, JpaSpecificationExecutor<ClueDO> {
}
