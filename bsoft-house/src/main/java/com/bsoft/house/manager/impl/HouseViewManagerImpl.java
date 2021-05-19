package com.bsoft.house.manager.impl;

import com.bsoft.house.dao.primary.HouseViewDAO;
import com.bsoft.house.entity.primary.HouseDO;
import com.bsoft.house.entity.primary.HouseViewDO;
import com.bsoft.house.manager.HouseViewManager;
import com.bsoft.house.repository.primary.HouseRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/*
 * @author  hy
 * @date  2020/4/13 10:36
 * @description
 */
@Component
public class HouseViewManagerImpl implements HouseViewManager {

    @Autowired
    private HouseRepository houseRepository;

    @Override
    public PageInfo<HouseViewDO> searchHouses(String context,String area,String userId, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<HouseViewDO> result = houseRepository.searchHouseWithCommon(area,userId,context);
        PageInfo<HouseViewDO> pageInfo = new PageInfo<>(result);
        return pageInfo;
    }
}
