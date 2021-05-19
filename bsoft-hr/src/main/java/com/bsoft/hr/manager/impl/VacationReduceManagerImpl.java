package com.bsoft.hr.manager.impl;

import com.bsoft.hr.condition.VacationReduceQueryCnd;
import com.bsoft.hr.dao.primary.VacationReduceDao;
import com.bsoft.hr.entity.primary.LeaveDO;
import com.bsoft.hr.entity.primary.VacationReduceDO;
import com.bsoft.hr.manager.VacationReduceManager;
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
public class VacationReduceManagerImpl implements VacationReduceManager {
    @Autowired
    private VacationReduceDao vacationReduceDao;
    @Override
    public Page<VacationReduceDO> getVacationReduceList(VacationReduceQueryCnd cnd) {
        Sort sort = Sort.by("year").descending();
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1, cnd.getPageSize(), sort);
        org.springframework.data.domain.Page<VacationReduceDO> pages = vacationReduceDao.findAll(new Specification<VacationReduceDO>() {
            @Override
            public Predicate toPredicate(Root<VacationReduceDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(StringUtils.isNotBlank(cnd.getYear())){
                    predicates.add(criteriaBuilder.equal(root.get("year"), cnd.getYear()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return pages;
    }

    @Override
    public void save(VacationReduceDO vacationReduce) {
        vacationReduceDao.save(vacationReduce);
    }

    @Override
    public void delete(VacationReduceDO vacationReduce) {
        vacationReduceDao.delete(vacationReduce);
    }

    @Override
    public void setFlag(Integer id) {
        VacationReduceDO vacationReduceDO = vacationReduceDao.findById(id).get();
        vacationReduceDO.setFlag(1);
        vacationReduceDao.save(vacationReduceDO);
    }


}
