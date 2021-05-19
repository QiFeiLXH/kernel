package com.bsoft.logs.manager.impl;

import com.bsoft.common.dozer.GeneratorUtil;
import com.bsoft.logs.condition.UsageLogCountQueryCnd;
import com.bsoft.logs.dao.primary.UsageLogCountDao;
import com.bsoft.logs.dao.primary.UsageLogCountViewDao;
import com.bsoft.logs.dto.UsageLogReportDTO;
import com.bsoft.logs.entity.primary.UsageLogCountDO;
import com.bsoft.logs.entity.primary.UsageLogCountWithDateDO;
import com.bsoft.logs.entity.primary.UsageLogReportDO;
import com.bsoft.logs.manager.UsageLogReportManager;
import com.bsoft.logs.repository.primary.UsageLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class UsageLogReportManagerImpl implements UsageLogReportManager {

    @Autowired
    UsageLogRepository usageLogRepository;

    @Autowired
    GeneratorUtil generatorUtil;

    @Autowired
    private UsageLogCountDao usageLogCountDao;

    @Autowired
    private UsageLogCountViewDao usageLogCountViewDao;

    @Override
    @Transactional
    public List<UsageLogReportDTO> countUsageLog(Date startDate, Date endDate) {
        List<UsageLogReportDO> usageLogReportDOS = usageLogRepository.countUsageLogReport(startDate,endDate);
        List<UsageLogReportDTO> usageLogReportDTOS = generatorUtil.convert(usageLogReportDOS,UsageLogReportDTO.class);
        return usageLogReportDTOS;
    }

    @Override
    public List<UsageLogCountDO> countUsageLogs(UsageLogCountQueryCnd countQueryCnd) {
        Sort sort = Sort.by("countDate").ascending();
        List<UsageLogCountDO> list = usageLogCountDao.findAll(new Specification<UsageLogCountDO>(){

            @Override
            public Predicate toPredicate(Root<UsageLogCountDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(countQueryCnd.getMenuId() != null){
                    predicates.add(criteriaBuilder.equal(root.get("menuId"),countQueryCnd.getMenuId()));
                }
                if(countQueryCnd.getStartDate() != null && countQueryCnd.getEndDate() != null){
                    predicates.add(criteriaBuilder.between(root.get("countDate"),countQueryCnd.getStartDate(),countQueryCnd.getEndDate()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },sort);
        return list;
    }

    @Override
    public List<UsageLogCountWithDateDO> countUsageLogGroup(Date startDate,Date endDate) {
        List<UsageLogCountWithDateDO> list = usageLogCountViewDao.count(startDate,endDate);
        return list;
    }
}
