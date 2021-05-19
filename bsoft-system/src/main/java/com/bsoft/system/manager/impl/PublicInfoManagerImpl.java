package com.bsoft.system.manager.impl;

import com.bsoft.system.condition.PublicInfoQueryCnd;
import com.bsoft.system.dao.primary.PublicInfoDao;
import com.bsoft.system.entity.primary.PublicInfoDO;
import com.bsoft.system.manager.PublicInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Component
public class PublicInfoManagerImpl implements PublicInfoManager {
    @Autowired
    private PublicInfoDao publicInfoDao;
    @Override
    public List<PublicInfoDO> getNews(Long count) {
        return publicInfoDao.getNews(count);
    }

    @Override
    public List<PublicInfoDO> getNotice(Long count) {
        return publicInfoDao.getNotice(count);
    }

    @Override
    public List<PublicInfoDO> getSystemNotice(Long count) {
        return publicInfoDao.getSystemNotice(count);
    }

    @Override
    public Page<PublicInfoDO> getNewsByType(PublicInfoQueryCnd cnd) {
        Sort sort = Sort.by("top").descending().and(Sort.by("displaydate").descending()).and(Sort.by("id").ascending());
        Pageable pageable = PageRequest.of(cnd.getPageNo()-1,cnd.getPageSize(),sort);
        Page<PublicInfoDO> pages = publicInfoDao.findAll(new Specification<PublicInfoDO>() {
            @Override
            public Predicate toPredicate(Root<PublicInfoDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("type"), cnd.getType())); //新闻类型
                predicates.add(criteriaBuilder.equal(root.get("publishState"),1));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }
}
