package com.bsoft.hr.manager.impl;

import com.bsoft.hr.condition.TrainChartViewCnd;
import com.bsoft.hr.dao.primary.TrainChartViewDao;
import com.bsoft.hr.entity.primary.TrainChartViewDO;
import com.bsoft.hr.manager.TrainChartManager;
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

/**
 * @author: zy
 * @date: 2020/8/5 14:20
 */
@Component
public class TrainChartManagerImpl implements TrainChartManager {

    @Autowired
    private TrainChartViewDao trainReportDao;

    @Override
    public Page<TrainChartViewDO> getTrainChartList(TrainChartViewCnd cnd) {
        Sort sort = Sort.by("attendCount").descending();
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1, cnd.getPageSize(), sort);
        Page<TrainChartViewDO> pages = trainReportDao.findAll(new Specification<TrainChartViewDO>() {
            @Override
            public Predicate toPredicate(Root<TrainChartViewDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("trainYear"), cnd.getTrainYear()));
                if(cnd.getDepartmentType().intValue() != 0) {
                    predicates.add(criteriaBuilder.equal(root.get("departmentType"), cnd.getDepartmentType()));
                }
                predicates.add(criteriaBuilder.equal(root.get("trainType"), cnd.getTrainType()));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return pages;
    }
}
