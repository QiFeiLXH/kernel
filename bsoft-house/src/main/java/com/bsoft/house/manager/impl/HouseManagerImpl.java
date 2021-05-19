package com.bsoft.house.manager.impl;

import com.bsoft.house.dao.primary.HouseDAO;
import com.bsoft.house.entity.primary.HouseDO;
import com.bsoft.house.manager.HouseManager;
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

@Component
public class HouseManagerImpl implements HouseManager {
    @Autowired
    private HouseDAO houseDAO;
    @Override
    public List<HouseDO> getHouses() {
        return houseDAO.findAll();
    }

    @Override
    public Page<HouseDO> getHouses(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        return houseDAO.findAll(pageable);
    }

    @Override
    public List<HouseDO> getHouses(List<Integer> houseId) {
        return houseDAO.findByIdIn(houseId);
    }

    @Override
    public Page<HouseDO> searchHouses(String context, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<HouseDO> housePage = houseDAO.findAll(new Specification<HouseDO>() {
            @Override
            public Predicate toPredicate(Root<HouseDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate4 = criteriaBuilder.equal(root.get("status"),1);
                Predicate predicate5 = criteriaBuilder.notEqual(root.get("purpose"),2);
                if(StringUtils.isEmpty(context)){
                    return criteriaBuilder.and(predicate4,predicate5);
                }else{
                    Predicate predicate1 = criteriaBuilder.like(root.get("name"),"%"+context+"%");
                    Predicate predicate2 = criteriaBuilder.like(root.get("address"),"%"+context+"%");
                    Predicate predicate3 = criteriaBuilder.or(predicate1,predicate2);
                    return criteriaBuilder.and(predicate3,predicate4,predicate5);
                }
            }
        },pageable);
        return housePage;
    }


}
