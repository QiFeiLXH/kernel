package com.bsoft.person.manager.impl;

import com.bsoft.common.utils.DateUtils;
import com.bsoft.person.condition.PersonToFormalQueryCnd;
import com.bsoft.person.dao.primary.PersonToFormalDao;
import com.bsoft.person.entity.primary.PersonToFormalCountDO;
import com.bsoft.person.entity.primary.PersonToFormalDO;
import com.bsoft.person.entity.primary.PersonTransferDO;
import com.bsoft.person.entity.primary.PersonTurViewDO;
import com.bsoft.person.manager.PersonToFormalManager;
import com.bsoft.person.manager.PersonTurManager;
import com.bsoft.person.repository.primary.PersonToFormalRepository;
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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2021/1/29 17:23
 * @Description:
 */

@Component
public class PersonToFormalManagerImpl implements PersonToFormalManager {

    @Autowired
    private PersonToFormalRepository formalRepository;
    @Autowired
    private PersonToFormalDao personToFormalDao;
    @Autowired
    private PersonTurManager personTurManager;

    @Override
    public List<PersonToFormalCountDO> getMonthCount(Integer year) {
        return formalRepository.getPersonToFormalMonthCount(year.toString());
    }

    @Override
    public Page<PersonToFormalDO> getMonthPersonToFormalList(PersonToFormalQueryCnd cnd) {
        Sort sort = Sort.by(Sort.Direction.DESC,"probationEndDate");
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1,cnd.getPageSize(),sort);
        Page<PersonToFormalDO> pages = personToFormalDao.findAll(new Specification<PersonToFormalDO>() {
            @Override
            public Predicate toPredicate(Root<PersonToFormalDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                try {
                    String month = cnd.getMonth();
                    String firstDayStr;
                    String lastDayStr;
                    if (month.endsWith("全部")){
                        firstDayStr = month.substring(0,4) + "-01-01";
                        lastDayStr = month.substring(0,4) + "-12-31";
                    }else{
                        firstDayStr = month + "-01";
                        lastDayStr = DateUtils.getLastDayOfMonth(month);
                    }
                    Date firstDay = DateUtils.stringToDate(firstDayStr,"yyy-MM-dd");
                    Date lastDay = DateUtils.stringToDate(lastDayStr,"yyy-MM-dd");
                    Predicate predicate = criteriaBuilder.between(root.get("probationEndDate"),firstDay,lastDay);
                    predicates.add(predicate);
                    String input = cnd.getInputContent();
                    if (StringUtils.isNotBlank(input)){
                        Predicate c1 = criteriaBuilder.like(root.get("personId"),"%"+input+"%");
                        Predicate c2 = criteriaBuilder.like(root.get("personName"),"%"+input+"%");
                        Predicate c3 = criteriaBuilder.like(root.get("pym"),"%"+input.toLowerCase()+"%");
                        predicates.add(criteriaBuilder.or(c1,c2,c3));
                    }
                    if ("1".equals(cnd.getFlag().toString())){//未申请
                        Predicate predicate4 = criteriaBuilder.in(root.get("status")).value(1).value(5);
                        predicates.add(predicate4);
                    }
                    if ("2".equals(cnd.getFlag().toString())){//办理中
                        Predicate predicate4 = criteriaBuilder.in(root.get("status")).value(2).value(6).value(7).value(8);
                        predicates.add(predicate4);
                    }
                    if ("3".equals(cnd.getFlag().toString())){//已通过
                        Predicate predicate4 = criteriaBuilder.equal(root.get("status"),cnd.getFlag());
                        predicates.add(predicate4);
                    }
                    if (StringUtils.isNotBlank(cnd.getDept())){
                        Predicate predicate5 = criteriaBuilder.equal(root.get("dept"),cnd.getDept());
                        predicates.add(predicate5);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    public PersonTurViewDO getPersonTur(Integer id) {
        return personTurManager.getPersonTur(id);
    }
}
