package com.bsoft.project.report.manager.impl;

import com.bsoft.common.performance.TimeConsumer;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.project.report.dao.primary.ProjectAllByMonthDao;
import com.bsoft.project.report.dao.primary.ProjectAllSubTotalDao;
import com.bsoft.project.report.dao.primary.ProjectDepTypeByMonthDao;
import com.bsoft.project.report.dao.primary.ProjectDepTypeByYearDao;
import com.bsoft.project.report.entity.primary.ProjectAllByMonthDO;
import com.bsoft.project.report.entity.primary.ProjectAllSubTotalDO;
import com.bsoft.project.report.entity.primary.ProjectDepTypeByMonthDO;
import com.bsoft.project.report.entity.primary.ProjectDepTypeByYearDO;
import com.bsoft.project.report.manager.ProjectLevelManager;
import com.bsoft.project.report.repository.primary.ProjectLevelRepository;
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

/**
 * @Author zhanglf
 * @Date 2019-12-19 16:43
 * @Version 1.0
 * @Description
 */
@Component
public class ProjectLevelManagerImpl implements ProjectLevelManager {
    private static final Logger logger = LoggerFactory.getLogger(ProjectLevelManagerImpl.class);
    @Autowired
    private ProjectAllSubTotalDao projectAllSubTotalDao;
    @Autowired
    private ProjectAllByMonthDao projectAllByMonthDao;
    @Autowired
    private ProjectDepTypeByYearDao projectDepTypeByYearDao;
    @Autowired
    private ProjectDepTypeByMonthDao projectDepTypeByMonthDao;
    @Autowired
    private ProjectLevelRepository projectLevelRepository;
    @Override
    public PageInfo<ProjectAllSubTotalDO> findAllSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectAllSubTotalDO> list =  projectLevelRepository.findAllSubTotal(startYear,endYear);
        PageInfo<ProjectAllSubTotalDO> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<ProjectAllSubTotalDO> findAllSubTotal(Integer startYear, Integer endYear) {
        List<ProjectAllSubTotalDO> list =  projectLevelRepository.findAllSubTotal(startYear,endYear);
        return list;
    }

    @Override
    public Page<ProjectAllSubTotalDO> findAllGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC,"projectId");
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,sort);
        Specification<ProjectAllSubTotalDO> spec = (Specification<ProjectAllSubTotalDO>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.between(root.get("year"),startYear,endYear));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        Page<ProjectAllSubTotalDO> pages = projectAllSubTotalDao.findAll(spec,pageable);
        return  pages;
    }

    @Override
    public List<ProjectAllSubTotalDO> findAllGroupByYear(Integer startYear, Integer endYear) {
        Sort sort = Sort.by(Sort.Direction.ASC,"projectId");
        Specification<ProjectAllSubTotalDO> spec = (Specification<ProjectAllSubTotalDO>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.between(root.get("year"),startYear,endYear));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        List<ProjectAllSubTotalDO> list = projectAllSubTotalDao.findAll(spec,sort);
        return  list;
    }

    @Override
    public Page<ProjectAllByMonthDO> findAllGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC,"projectId");
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,sort);
        Specification<ProjectAllByMonthDO> spec = (Specification<ProjectAllByMonthDO>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.between(root.get("year"),startYear,endYear));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        Page<ProjectAllByMonthDO> pages = projectAllByMonthDao.findAll(spec,pageable);
        return  pages;
    }

    @Override
    public List<ProjectAllByMonthDO> findAllGroupByMonth(Integer startYear, Integer endYear) {
        Sort sort = Sort.by(Sort.Direction.ASC,"projectId");
        Specification<ProjectAllByMonthDO> spec = (Specification<ProjectAllByMonthDO>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.between(root.get("year"),startYear,endYear));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        List<ProjectAllByMonthDO> list = projectAllByMonthDao.findAll(spec,sort);
        return  list;
    }

    @Override
    public PageInfo<ProjectDepTypeByYearDO> findDepTypeSubTotal(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ProjectDepTypeByYearDO> list = projectLevelRepository.findDepTypeSubTotal(startYear,endYear);
        PageInfo<ProjectDepTypeByYearDO> pageInfos = new PageInfo<>(list);
        return pageInfos;
    }

    @Override
    public List<ProjectDepTypeByYearDO> findDepTypeSubTotal(Integer startYear, Integer endYear) {
        List<ProjectDepTypeByYearDO> list = projectLevelRepository.findDepTypeSubTotal(startYear,endYear);
        return list;
    }

    @Override
    public Page<ProjectDepTypeByYearDO> findDepTypeGroupByYear(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC,"projectId");
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,sort);
        Specification<ProjectDepTypeByYearDO> spec = (Specification<ProjectDepTypeByYearDO>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.between(root.get("year"),startYear,endYear));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        Page<ProjectDepTypeByYearDO> pages = projectDepTypeByYearDao.findAll(spec,pageable);
        return pages;
    }

    @Override
    public List<ProjectDepTypeByYearDO> findDepTypeGroupByYear(Integer startYear, Integer endYear) {
        Sort sort = Sort.by(Sort.Direction.ASC,"projectId");
        Specification<ProjectDepTypeByYearDO> spec = (Specification<ProjectDepTypeByYearDO>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.between(root.get("year"),startYear,endYear));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        List<ProjectDepTypeByYearDO> list = projectDepTypeByYearDao.findAll(spec,sort);
        return list;
    }

    @Override
    public Page<ProjectDepTypeByMonthDO> findDepTypeGroupByMonth(Integer startYear, Integer endYear, Integer pageNo, Integer pageSize) {
        Sort sort = Sort.by(Sort.Direction.ASC,"projectId");
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,sort);
        Specification<ProjectDepTypeByMonthDO> spec = (Specification<ProjectDepTypeByMonthDO>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.between(root.get("year"),startYear,endYear));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        Page<ProjectDepTypeByMonthDO> pages = projectDepTypeByMonthDao.findAll(spec,pageable);
        return  pages;
    }

    @Override
    public List<ProjectDepTypeByMonthDO> findDepTypeGroupByMonth(Integer startYear, Integer endYear) {
        Sort sort = Sort.by(Sort.Direction.ASC,"projectId");
        Specification<ProjectDepTypeByMonthDO> spec = (Specification<ProjectDepTypeByMonthDO>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.between(root.get("year"),startYear,endYear));
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        List<ProjectDepTypeByMonthDO> list = projectDepTypeByMonthDao.findAll(spec,sort);
        return  list;
    }
}
