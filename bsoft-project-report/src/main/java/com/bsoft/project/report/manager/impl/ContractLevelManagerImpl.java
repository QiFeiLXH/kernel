package com.bsoft.project.report.manager.impl;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.project.report.dao.primary.ContractAllByMonthDao;
import com.bsoft.project.report.dao.primary.ContractAllSubTotalDao;
import com.bsoft.project.report.dao.primary.ContractDepTypeByMonthDao;
import com.bsoft.project.report.dao.primary.ContractDepTypeByYearDao;
import com.bsoft.project.report.dto.ContractAllByMonthDTO;
import com.bsoft.project.report.entity.primary.*;
import com.bsoft.project.report.manager.ContractLevelManager;
import com.bsoft.project.report.repository.primary.ContractLevelRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author zhanglf
 * @Date 2019-12-23 15:21
 * @Version 1.0
 * @Description
 */
@Component
public class ContractLevelManagerImpl implements ContractLevelManager {
    private final static Logger logger = LoggerFactory.getLogger(ContractLevelManagerImpl.class);
    @Autowired
    private ContractLevelRepository contractLevelRepository;
    @Autowired
    private ContractAllSubTotalDao contractAllSubTotalDao;
    @Autowired
    private ContractAllByMonthDao contractAllByMonthDao;
    @Autowired
    private ContractDepTypeByYearDao contractDepTypeByYearDao;
    @Autowired
    private ContractDepTypeByMonthDao contractDepTypeByMonthDao;
    @Override
    public PageInfo<ContractAllSubTotalDO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ContractAllSubTotalDO> list =  contractLevelRepository.findAllSubTotal(startYear,endYear);
        PageInfo<ContractAllSubTotalDO> pageInfos = new PageInfo<>(list);
        return pageInfos;
    }

    @Override
    public List<ContractAllSubTotalDO> findAllSubTotal(Integer startYear, Integer endYear) {
        List<ContractAllSubTotalDO> list =  contractLevelRepository.findAllSubTotal(startYear,endYear);
        return list;
    }

    @Override
    public Page<ContractAllSubTotalDO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "projectId"));
        orders.add(new Sort.Order(Sort.Direction.DESC, "year"));
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,Sort.by(orders));
        Specification<ContractAllSubTotalDO> spec = (Specification<ContractAllSubTotalDO>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.between(root.get("year"),startYear,endYear));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        Page<ContractAllSubTotalDO> pages = contractAllSubTotalDao.findAll(spec,pageable);
        return pages;
    }

    @Override
    public List<ContractAllSubTotalDO> findAllGroupByYear(Integer startYear, Integer endYear) {
        Sort sort = Sort.by("year").descending()
                .and(Sort.by("projectId").descending());
        Specification<ContractAllSubTotalDO> spec = (Specification<ContractAllSubTotalDO>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.between(root.get("year"),startYear,endYear));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        List<ContractAllSubTotalDO> list = contractAllSubTotalDao.findAll(spec,sort);
        return list;
    }

    @Override
    public Page<ContractAllByMonthDO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "projectId"));
        orders.add(new Sort.Order(Sort.Direction.DESC, "year"));
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,Sort.by(orders));
        Specification<ContractAllByMonthDO> spec = (Specification<ContractAllByMonthDO>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.between(root.get("year"),startYear,endYear));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        Page<ContractAllByMonthDO> pages = contractAllByMonthDao.findAll(spec,pageable);
        return pages;
    }

    @Override
    public List<ContractAllByMonthDO> findAllGroupByMonth(Integer startYear, Integer endYear) {
        Sort sort = Sort.by("year").descending()
                .and(Sort.by("projectId").descending());
        Specification<ContractAllByMonthDO> spec = (Specification<ContractAllByMonthDO>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.between(root.get("year"),startYear,endYear));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        List<ContractAllByMonthDO> list = contractAllByMonthDao.findAll(spec,sort);
        return list;
    }

    @Override
    public PageInfo<ContractDepTypeByYearDO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ContractDepTypeByYearDO> list =  contractLevelRepository.findDepTypeSubTotal(startYear,endYear);
        PageInfo<ContractDepTypeByYearDO> pageInfos = new PageInfo<>(list);
        return pageInfos;
    }

    @Override
    public List<ContractDepTypeByYearDO> findDepTypeSubTotal(Integer startYear, Integer endYear) {
        List<ContractDepTypeByYearDO> list =  contractLevelRepository.findDepTypeSubTotal(startYear,endYear);
        return list;
    }

    @Override
    public Page<ContractDepTypeByYearDO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "projectId"));
        orders.add(new Sort.Order(Sort.Direction.DESC, "year"));
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,Sort.by(orders));
        Specification<ContractDepTypeByYearDO> spec = (Specification<ContractDepTypeByYearDO>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.between(root.get("year"),startYear,endYear));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        Page<ContractDepTypeByYearDO> pages = contractDepTypeByYearDao.findAll(spec,pageable);
        return pages;
    }

    @Override
    public List<ContractDepTypeByYearDO> findDepTypeGroupByYear(Integer startYear, Integer endYear) {
        Sort sort = Sort.by("year").descending()
                .and(Sort.by("projectId").descending());
        Specification<ContractDepTypeByYearDO> spec = (Specification<ContractDepTypeByYearDO>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.between(root.get("year"),startYear,endYear));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        List<ContractDepTypeByYearDO> list = contractDepTypeByYearDao.findAll(spec,sort);
        return list;
    }

    @Override
    public Page<ContractDepTypeByMonthDO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "projectId"));
        orders.add(new Sort.Order(Sort.Direction.DESC, "year"));
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,Sort.by(orders));
        Specification<ContractDepTypeByMonthDO> spec = (Specification<ContractDepTypeByMonthDO>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.between(root.get("year"),startYear,endYear));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        Page<ContractDepTypeByMonthDO> pages = contractDepTypeByMonthDao.findAll(spec,pageable);
        return pages;
    }

    @Override
    public List<ContractDepTypeByMonthDO> findDepTypeGroupByMonth(Integer startYear, Integer endYear) {
        Sort sort = Sort.by("year").descending()
                .and(Sort.by("projectId").descending());
        Specification<ContractDepTypeByMonthDO> spec = (Specification<ContractDepTypeByMonthDO>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.between(root.get("year"),startYear,endYear));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        List<ContractDepTypeByMonthDO> list = contractDepTypeByMonthDao.findAll(spec,sort);
        return list;
    }
}
