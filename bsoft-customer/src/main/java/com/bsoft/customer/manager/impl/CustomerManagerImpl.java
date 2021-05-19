package com.bsoft.customer.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.customer.condition.CustomerQueryCnd;
import com.bsoft.customer.dao.primary.CustomerDao;
import com.bsoft.customer.entity.primary.CustomerDO;
import com.bsoft.customer.manager.CustomerManager;
import com.mchange.v1.db.sql.ResultSetUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 客户基本信息
 */
@Component
public class CustomerManagerImpl implements CustomerManager {
    @Autowired
    private CustomerDao customerDao;
    @Override
    @Cacheable(cacheNames = "Customer",key = "#id")
    public CustomerDO getCustomer(String id) {
        return customerDao.findById(id).get();
    }

    @Override
    public List<CustomerDO> getCustomerList(List<String> nameList) {
        return customerDao.findByNameIn(nameList);
    }

    @Override
    public Result<CustomerDO> getCustomerList(CustomerQueryCnd queryCnd) {
        Sort sort = Sort.by("id");
        Pageable pageable = PageRequest.of(queryCnd.getPageNo() - 1, queryCnd.getPageSize(), sort);
        Page<CustomerDO> page = customerDao.findAll(new Specification<CustomerDO>() {
            @Override
            public Predicate toPredicate(Root<CustomerDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(queryCnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("name"), "%" + queryCnd.getInputContent() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("pinyin"), "%" + queryCnd.getInputContent() + "%");
                    predicates.add(criteriaBuilder.or(c1, c2));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return ResultUtils.parseResult(page, CustomerDO.class);
    }
}
