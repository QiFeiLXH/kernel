package com.bsoft.common.manager.impl;

import com.bsoft.common.condition.SystemDicSelectQueryCnd;
import com.bsoft.common.dao.primary.SystemDicDao;
import com.bsoft.common.entity.primary.SystemDicDO;
import com.bsoft.common.manager.SystemDicManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class SystemDicManagerImpl implements SystemDicManager {
    private static final String DEFAULT_CACHENAME = "SystemDic";
    private static final String DEFAULT_CACHENAME_DETAIL = DEFAULT_CACHENAME + ":detail";
    private static final String DEFAULT_CACHENAME_ALL = DEFAULT_CACHENAME + ":all";
    @Autowired
    private SystemDicDao systemDicDao;

    @Override
    public Map<String, String> getDic(Integer type) {
        List<SystemDicDO> dicList = systemDicDao.findByType(type);
        return dicList.stream().filter((dic)->!dic.getId().equals("0")).collect(Collectors.toMap((dic)->String.valueOf(dic.getId()),SystemDicDO::getName,(key1,key2)->key1));
    }

    @Override
    @Cacheable(cacheNames = DEFAULT_CACHENAME_ALL,key = "#type")
    public List<SystemDicDO> getSystemDic(Integer type) {
        return systemDicDao.findByTypeAndIdIsGreaterThan(type,0);
    }

    @Override
    @Cacheable(cacheNames = DEFAULT_CACHENAME_DETAIL,key = "#type + ':' + #key")
    public SystemDicDO getValue(Integer type, String key) {
        return systemDicDao.findByTypeAndId(type,Integer.valueOf(key));
    }

    @Override
    public List<SystemDicDO> getSystemDicSelectList(SystemDicSelectQueryCnd queryCnd) {
        List<SystemDicDO> list = systemDicDao.findAll(new Specification<SystemDicDO>() {
            @Override
            public Predicate toPredicate(Root<SystemDicDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.greaterThan(root.get("id"), 0));
                predicates.add(criteriaBuilder.equal(root.get("type"), queryCnd.getType()));
                if (StringUtils.isNotBlank(queryCnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("name"), "%" + queryCnd.getInputContent() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("pinyin"), "%" + queryCnd.getInputContent().toLowerCase() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("pinyin"), "%" + queryCnd.getInputContent().toUpperCase() + "%");
                    predicates.add(criteriaBuilder.or(c1, c2, c3));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        return list;
    }

}
