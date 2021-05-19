package com.bsoft.common.manager.impl;

import com.bsoft.common.condition.PublicDicSelectQueryCnd;
import com.bsoft.common.dao.primary.PublicDicDao;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.manager.PublicDicManager;
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
public class PublicDicManagerImpl implements PublicDicManager {
    private static final String DEFAULT_CACHENAME = "PublicDic";
    private static final String DEFAULT_CACHENAME_DETAIL = DEFAULT_CACHENAME + ":detail";
    private static final String DEFAULT_CACHENAME_ALL = DEFAULT_CACHENAME + ":all";
    @Autowired
    private PublicDicDao publicDicDao;

    @Override
    public Map<String, String> getDic(Integer type) {
        List<PublicDicDO> dicList = publicDicDao.findByType(type);
        return dicList.stream().filter((dic)->!dic.getId().equals("0")).collect(Collectors.toMap((dic)->String.valueOf(dic.getId()),PublicDicDO::getName,(key1,key2)->key1));
    }

    @Override
    public List<PublicDicDO> getPublicDic(Integer type) {
        return publicDicDao.findByTypeAndIdIsGreaterThan(type,0);
    }

    @Override
    public List<PublicDicDO> getPublicDicSelectList(PublicDicSelectQueryCnd queryCnd) {
        List<PublicDicDO> list = publicDicDao.findAll(new Specification<PublicDicDO>() {
            @Override
            public Predicate toPredicate(Root<PublicDicDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.greaterThan(root.get("id"), 0));
                predicates.add(criteriaBuilder.equal(root.get("type"), queryCnd.getType()));
                if (queryCnd.getFlag() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("flag"), queryCnd.getFlag()));
                }
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

    @Override
    public List<PublicDicDO> getSystemListDic() {
        return publicDicDao.findAllByTypeAndFlag(9908,1);
    }

    @Override
    @Cacheable(cacheNames = DEFAULT_CACHENAME_DETAIL,key = "#type + ':' + #key")
    public PublicDicDO getValue(Integer type, String key) {
        return publicDicDao.findByTypeAndId(type,Integer.valueOf(key));
    }

    @Override
    public PublicDicDO getValueWithName(Integer type, String name) {
        return publicDicDao.findByTypeAndName(type,name);
    }

    @Override
    public List<PublicDicDO> getPublicDicWithFlag(Integer type, Integer flag) {
        return publicDicDao.findByTypeAndFlagAndIdIsGreaterThan(type, flag, 0);
    }

    @Override
    public void logout(Integer id) {
        publicDicDao.logout(id);
    }

    @Override
    public int selectMaxId() {
        return publicDicDao.selectMaxId();
    }

}
