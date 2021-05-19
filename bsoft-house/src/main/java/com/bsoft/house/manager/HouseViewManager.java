package com.bsoft.house.manager;

import com.bsoft.house.entity.primary.HouseViewDO;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;


public interface HouseViewManager {
    public PageInfo<HouseViewDO> searchHouses(String context,String area,String userId, Integer page, Integer size);
}
