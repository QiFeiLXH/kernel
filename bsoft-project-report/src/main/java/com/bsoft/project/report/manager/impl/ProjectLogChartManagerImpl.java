package com.bsoft.project.report.manager.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.project.report.condition.ProjectLogChartQueryCnd;
import com.bsoft.project.report.dao.primary.ProjectLogChartMonthViewDao;
import com.bsoft.project.report.dao.primary.ProjectLogChartViewDao;
import com.bsoft.project.report.entity.primary.ProjectLogChartMonthViewDO;
import com.bsoft.project.report.entity.primary.ProjectLogChartViewDO;
import com.bsoft.project.report.manager.ProjectLogChartManager;
import com.bsoft.project.report.repository.primary.ProjectLogChartMonthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zy
 * @date: 2020/8/7 9:01
 */

@Component
public class ProjectLogChartManagerImpl implements ProjectLogChartManager {

    @Autowired
    private ProjectLogChartViewDao projectLogChartViewDao;
    @Autowired
    private ProjectLogChartMonthViewDao projectLogChartMonthViewDao;
    @Autowired
    private ProjectLogChartMonthRepository projectLogChartMonthRepository;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public List<ProjectLogChartViewDO> getLogChartList(ProjectLogChartQueryCnd logChartViewCnd) {
        List<ProjectLogChartViewDO> result = projectLogChartViewDao.findAll(new Specification<ProjectLogChartViewDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectLogChartViewDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.between(root.get("date"), logChartViewCnd.getStartDate(), logChartViewCnd.getEndDate()));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        List<ProjectLogChartViewDO> sortedResult = result.stream().sorted(Comparator.comparing(ProjectLogChartViewDO::getDate)).collect(Collectors.toList());
        return sortedResult;
    }

    @Override
    public List<ProjectLogChartMonthViewDO> getLogChartMonthList(ProjectLogChartQueryCnd cnd) {
        /*List<ProjectLogChartMonthViewDO> result = projectLogChartMonthViewDao.findAll(new Specification<ProjectLogChartMonthViewDO>() {
            @Override
            public Predicate toPredicate(Root<ProjectLogChartMonthViewDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.between(root.get("date"), cnd.getYear() * 100 , (cnd.getYear() + 1) * 100) );
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });*/
        String startDateStr = cnd.getYear() + "0101";
        String endDateStr = cnd.getYear() + "1231";
        List<ProjectLogChartMonthViewDO> result = projectLogChartMonthRepository.listLogChartMonthInfos(startDateStr, endDateStr);
        List<ProjectLogChartMonthViewDO> sortedResult = result.stream().sorted(Comparator.comparing(ProjectLogChartMonthViewDO::getDate)).collect(Collectors.toList());
        return sortedResult;
    }
}
