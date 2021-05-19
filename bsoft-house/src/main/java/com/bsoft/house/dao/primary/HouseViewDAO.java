package com.bsoft.house.dao.primary;

import com.bsoft.house.entity.primary.HouseViewDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseViewDAO extends JpaRepository<HouseViewDO,Integer>, JpaSpecificationExecutor<HouseViewDO> {
}
