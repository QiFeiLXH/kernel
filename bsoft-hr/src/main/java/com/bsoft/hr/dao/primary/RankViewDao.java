package com.bsoft.hr.dao.primary;

import com.bsoft.hr.entity.primary.RankViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RankViewDao extends JpaRepository<RankViewDO,Integer>, JpaSpecificationExecutor<RankViewDO> {

}
