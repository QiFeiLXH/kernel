package com.bsoft.house.dao.primary;

import com.bsoft.house.entity.primary.HouseDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseDAO extends JpaRepository<HouseDO,Integer>, JpaSpecificationExecutor<HouseDO> {
    public List<HouseDO> findByIdIn(List<Integer> houseId);
}
