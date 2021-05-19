package com.bsoft.logs.manager.impl;

import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.logs.condition.OperLogQueryCnd;
import com.bsoft.logs.dao.primary.OperLogDao;
import com.bsoft.logs.entity.primary.OperLogDO;
import com.bsoft.logs.manager.OperLogManager;
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

/**
 * @Author: xucl
 * @DateTime: 2021/2/7 10:31
 * @Description:
 */
@Component
public class OperLogManagerImpl implements OperLogManager {
    @Autowired
    private OperLogDao operLogDao;
    @Override
    public Result<OperLogDO> getLogList(OperLogQueryCnd cnd) {
        Sort sort = Sort.by(Sort.Direction.DESC,"requestDate");
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1,cnd.getPageSize(),sort);
        Page<OperLogDO> page = operLogDao.findAll(new Specification<OperLogDO>(){
            @Override
            public Predicate toPredicate(Root<OperLogDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (cnd.getStartDate() != null && cnd.getEndDate() != null){
                    Predicate p = criteriaBuilder.between(root.get("requestDate"),cnd.getStartDate(),cnd.getEndDate());
                    predicates.add(p);
                }
                if (cnd.getSystem() != null){
                    Predicate p = criteriaBuilder.equal(root.get("system"),cnd.getSystem());
                    predicates.add(p);
                }
                if (StringUtils.isNotBlank(cnd.getInputContent())){
                    Predicate c1 = criteriaBuilder.like(root.get("personId"),"%"+cnd.getInputContent()+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("personName"),"%"+cnd.getInputContent()+"%");
                    Predicate c3 = criteriaBuilder.like(root.get("pyCode"),"%"+cnd.getInputContent().toLowerCase()+"%");
                    Predicate c4 = criteriaBuilder.like(root.get("menuName"),"%"+cnd.getInputContent()+"%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3,c4));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return ResultUtils.parseResult(page);
    }
}
