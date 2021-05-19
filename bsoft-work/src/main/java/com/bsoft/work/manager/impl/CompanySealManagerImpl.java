package com.bsoft.work.manager.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.work.dao.primary.CompanySealDao;
import com.bsoft.work.dao.primary.CompanySealViewDao;
import com.bsoft.work.entity.primary.CompanySealDO;
import com.bsoft.work.entity.primary.CompanySealViewDO;
import com.bsoft.work.manager.CompanySealManager;
import com.bsoft.work.dto.CompanySealDTO;
import com.bsoft.work.dto.CompanySealQueryCnd;
import org.apache.commons.lang3.StringUtils;
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
public class CompanySealManagerImpl implements CompanySealManager {
    @Autowired
    private CompanySealViewDao companySealViewDao;
    @Autowired
    private CompanySealDao companySealDao;
    @Autowired
    private IGenerator iGenerator;
    @Override
    public Page<CompanySealViewDO> getCompanySealList(CompanySealQueryCnd queryCnd) {
        Sort sort = Sort.by("companyType").ascending().and(Sort.by("id").descending());
        if(queryCnd.getPageNo()==null&&queryCnd.getPageSize()==null){
            queryCnd.setPageNo(1);
            queryCnd.setPageSize(25);
        }
        Pageable pageable = PageRequest.of(queryCnd.getPageNo()-1,queryCnd.getPageSize(),sort);
        Page<CompanySealViewDO> pages = companySealViewDao.findAll(new Specification<CompanySealViewDO>() {
            @Override
            public Predicate toPredicate(Root<CompanySealViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                 if(queryCnd.getCompanyType()!=null){
                    predicates.add(criteriaBuilder.equal(root.get("companyType"),queryCnd.getCompanyType()));
                }

                if(queryCnd.getId()!=null){
                    predicates.add(criteriaBuilder.equal(root.get("id"),queryCnd.getId()));
                }

                if(StringUtils.isNotBlank(queryCnd.getInputContent())){
                    Predicate c1 = criteriaBuilder.like(root.get("officialSealCustodianName"),"%"+queryCnd.getInputContent()+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("contractSealCustodianName"),"%"+queryCnd.getInputContent()+"%");
                    Predicate c3 = criteriaBuilder.like(root.get("companyName"),"%"+queryCnd.getInputContent()+"%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3));
                }
                predicates.add(criteriaBuilder.gt(root.get("companyId"), 0));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    public void saveCompanySeal(CompanySealDO companySealDO) {
        companySealDao.save(companySealDO);
    }

    @Override
    public CompanySealViewDO getCompanySealView(Integer id) {
        return companySealViewDao.getCompanySealView(id);
    }

}
