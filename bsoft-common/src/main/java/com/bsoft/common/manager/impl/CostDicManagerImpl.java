package com.bsoft.common.manager.impl;

import com.bsoft.common.dao.primary.CostDicDao;
import com.bsoft.common.entity.primary.CostDicDO;
import com.bsoft.common.manager.CostDicManager;
import com.bsoft.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description 成本代码字典
 */
@Component
public class CostDicManagerImpl implements CostDicManager {

    @Autowired
    private CostDicDao costDicDao;


    @Override
    public CostDicDO getCostDic(Integer type, Integer id) {
        return costDicDao.findByTypeAndId(type, id);
    }

    @Override
    public List<CostDicDO> getCostDicList(Integer type) {
        return costDicDao.findByType(type);
    }

    @Override
    public List<CostDicDO> getCostDicList(Integer type, Integer logout) {
        List<CostDicDO> resultList = costDicDao.findByTypeAndLogout(type, logout);
        return resultList;
    }

    @Override
    public List<CostDicDO> getCostDicList(Integer type, Integer subType, Integer logout, String inputContent) {
        List<CostDicDO> result = costDicDao.findAll(new Specification<CostDicDO>() {
            @Override
            public Predicate toPredicate(Root<CostDicDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("type"), type));
                predicates.add(criteriaBuilder.equal(root.get("subType"), subType));
                predicates.add(criteriaBuilder.equal(root.get("logout"), logout));
                if (StringUtils.isNotBlank(inputContent)) {
                    Predicate c1 = criteriaBuilder.like(root.get("name"), "%" + inputContent + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("pinyin"), "%" + inputContent.toLowerCase() + "%");
                    predicates.add(criteriaBuilder.or(c1,c2));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        List<CostDicDO> sortedResult = result.stream().sorted(Comparator.comparing(CostDicDO::getId).reversed()).collect(Collectors.toList());
        return sortedResult;
    }

    @Override
    public void save(CostDicDO saveDO) {
        if (saveDO.getType() == null) {
            throw new ServiceException("代码类别不能为空！");
        }
        if(saveDO.getId()==null) {
            List<CostDicDO> findList = costDicDao.findByType(saveDO.getType());
            Integer maxId = findList.stream().mapToInt(CostDicDO::getId).max().getAsInt();
            saveDO.setId(maxId + 1);
        }
        costDicDao.save(saveDO);
    }
}
