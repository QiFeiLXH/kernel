package com.bsoft.sales.manager.impl;

import com.bsoft.sales.dao.primary.CustomerContactViewDao;
import com.bsoft.sales.dao.primary.CustomerContactsDao;
import com.bsoft.sales.entity.primary.CustomerContactViewDO;
import com.bsoft.sales.entity.primary.CustomerContactsDO;
import com.bsoft.sales.manager.CusotmerContactsManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/24 15:33
 * @Description
 */
@Service
public class CusotmerContactsManagerImpl implements CusotmerContactsManager {
    @Autowired
    private CustomerContactsDao customerContactsDao;
    @Autowired
    private CustomerContactViewDao customerContactViewDao;

    @Override
    public Page<CustomerContactsDO> getCustomerContactsList(Integer pageNo, Integer pageSize, String inputContent) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        Page<CustomerContactsDO> pages = customerContactsDao.findAll(new Specification<CustomerContactsDO>() {
            @Override
            public Predicate toPredicate(Root<CustomerContactsDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(inputContent)) {
                    Predicate c1 = criteriaBuilder.like(root.get("customerName"), "%" + inputContent + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("simpleCode"), "%" + inputContent.toUpperCase() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("simpleCode"), "%" + inputContent.toLowerCase() + "%");
                    predicates.add(criteriaBuilder.or(c1, c2, c3));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return pages;
    }

    @Override
    public Page<CustomerContactViewDO> getCustomerContacts(Integer pageNo, Integer pageSize, String inputContent) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        Page<CustomerContactViewDO> pages = customerContactViewDao.findAll(new Specification<CustomerContactViewDO>() {
            @Override
            public Predicate toPredicate(Root<CustomerContactViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(inputContent)) {
                    Predicate c1 = criteriaBuilder.like(root.get("customerName"), "%" + inputContent + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("simpleCode"), "%" + inputContent.toUpperCase() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("simpleCode"), "%" + inputContent.toLowerCase() + "%");
                    predicates.add(criteriaBuilder.or(c1, c2, c3));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return pages;
    }
}
