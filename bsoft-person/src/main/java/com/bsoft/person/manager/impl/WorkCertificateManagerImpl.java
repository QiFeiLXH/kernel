package com.bsoft.person.manager.impl;

import com.bsoft.person.dao.primary.WorkCertificateDao;
import com.bsoft.person.dao.primary.WorkCertificateNumViewDao;
import com.bsoft.person.entity.primary.WorkCertificateDO;
import com.bsoft.person.entity.primary.WorkCertificateNumViewDO;
import com.bsoft.person.manager.WorkCertificateManager;
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
public class WorkCertificateManagerImpl implements WorkCertificateManager {
    @Autowired
    private WorkCertificateDao workCertificateDao;
    @Autowired
    private WorkCertificateNumViewDao workCertificateNumViewDao;
    @Override
    public WorkCertificateDO saveWorkCertificate(WorkCertificateDO workCertificate) {
        return workCertificateDao.save(workCertificate);
    }

    @Override
    public List<WorkCertificateDO> saveWorkCertificates(List<WorkCertificateDO> workCertificates) {
        if(workCertificates == null){return null;}
        return workCertificateDao.saveAll(workCertificates);
    }

    @Override
    public List<WorkCertificateDO> getWorkCertificates(String personId) {
        return workCertificateDao.findByPersonId(personId);
    }

    @Override
    public Page<WorkCertificateNumViewDO> getCertificateNumList(String deptId, String inputContent, Integer pageNo, Integer pageSize) {
        Sort sort = Sort.by("personId").descending();
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,sort);
        Page<WorkCertificateNumViewDO> pages = workCertificateNumViewDao.findAll(new Specification<WorkCertificateNumViewDO>() {
            @Override
            public Predicate toPredicate(Root<WorkCertificateNumViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(deptId)) {
                    predicates.add(criteriaBuilder.equal(root.get("deptId"), deptId));
                }
                if (StringUtils.isNotBlank(inputContent)) {
                    Predicate c1 = criteriaBuilder.like(root.get("simpleCode"),"%"+inputContent+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("simpleCode"),"%"+inputContent.toLowerCase()+"%");
                    Predicate c3 = criteriaBuilder.like(root.get("personName"),"%"+inputContent+"%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);

        return pages;
    }

    @Override
    public Page<WorkCertificateDO> getPersonalCertificateList(String personId, Integer pageNo, Integer pageSize) {
        Sort sort = Sort.by("getDate").descending().by("id").descending();
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,sort);
        Page<WorkCertificateDO> pages = workCertificateDao.findAllByPersonId(personId, pageable);
        return pages;
    }
}
