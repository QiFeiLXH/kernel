package com.bsoft.hr.manager.impl;

import com.bsoft.hr.condition.WorkVacationQueryCnd;
import com.bsoft.hr.dao.primary.WorkVacationDao;
import com.bsoft.hr.dao.primary.WorkVacationTotalViewDao;
import com.bsoft.hr.entity.primary.WorkVacationDO;
import com.bsoft.hr.entity.primary.WorkVacationTotalViewDO;
import com.bsoft.hr.manager.WorkVacationManager;
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
import java.util.Date;
import java.util.List;

/**
 * @author: zy
 * @date: 2020/8/20
 * @description 员工加班调休假ManagerImpl
 */
@Component
public class WorkVacationManagerImpl implements WorkVacationManager {
    @Autowired
    private WorkVacationTotalViewDao workVacationTotalViewDao;
    @Autowired
    private WorkVacationDao workVacationDao;

    /**
     * 获取加班调休假（总览）
     */
    @Override
    public Page<WorkVacationTotalViewDO> getWorkVacationTotal(WorkVacationQueryCnd cnd) {
        String year = cnd.getYear();
        String deptId = cnd.getDeptId();
        String personId = cnd.getPersonId();
        String personName = cnd.getPersonName();
        Sort sort = Sort.by("personId").ascending();
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1, cnd.getPageSize(), sort);
        Page<WorkVacationTotalViewDO> page = workVacationTotalViewDao.findAll(new Specification<WorkVacationTotalViewDO>() {
            @Override
            public Predicate toPredicate(Root<WorkVacationTotalViewDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("year"), year));
                if (StringUtils.isNotBlank(cnd.getDeptId())) {
                    predicates.add(criteriaBuilder.equal(root.get("deptId"), deptId));
                }
                if (StringUtils.isNotBlank(personId)) {
                    predicates.add(criteriaBuilder.equal(root.get("personId"), personId));
                }
                if (StringUtils.isNotBlank(cnd.getPersonName())){
                    Predicate c1 = criteriaBuilder.like(root.get("nameCode"),"%" + personName + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("nameCode"),"%" + personName.toLowerCase() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("personName"),"%" + personName + "%");
                   predicates.add(criteriaBuilder.or(c1,c2,c3));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return page;
    }

    /**
     * 获取加班调休假（个人）
     */
    @Override
    public Page<WorkVacationDO> getWorkVacationPersonal(WorkVacationQueryCnd cnd) {
        String personId = cnd.getPersonId();
        String deptId = cnd.getDeptId();
        Date startDate = cnd.getStartDate();
        Date endDate = cnd.getEndDate();
        Sort sort = Sort.by("workStartDate").descending();
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1, cnd.getPageSize(), sort);
        Page<WorkVacationDO> page = workVacationDao.findAll(new Specification<WorkVacationDO>() {
            @Override
            public Predicate toPredicate(Root<WorkVacationDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("personId"), personId));
                if (StringUtils.isNotBlank(deptId)) {
                    predicates.add(criteriaBuilder.equal(root.get("dept"), deptId));
                }
                predicates.add(criteriaBuilder.between(root.get("createDate"), startDate, endDate));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return page;
    }
}
