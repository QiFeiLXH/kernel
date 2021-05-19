package com.bsoft.house.manager;

import com.bsoft.house.entity.primary.HouseDO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface HouseManager {
    public List<HouseDO> getHouses();
    public Page<HouseDO> getHouses(Integer page,Integer size);
    public List<HouseDO> getHouses(List<Integer> houseId);
    public Page<HouseDO> searchHouses(String context,Integer page,Integer size);
}
