package com.bsoft.hr.manager.impl;

import com.bsoft.hr.condition.NewEntryPersonInfoQueryCnd;
import com.bsoft.hr.dao.primary.NewEntryPersonInfoDao;
import com.bsoft.hr.entity.primary.PersonCompanyDO;
import com.bsoft.hr.entity.primary.NewEntryPersonInfoDO;
import com.bsoft.hr.manager.NewEntryPersonInfoManager;
import com.bsoft.hr.repository.primary.NewEntryPersonInfoRepository;
import com.bsoft.person.entity.primary.PersonDO;
import com.bsoft.person.manager.PersonManager;
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
public class NewEntryPersonInfoManagerImpl implements NewEntryPersonInfoManager {
    @Autowired
    private NewEntryPersonInfoDao entryPersonInfoDao;
    @Autowired
    private PersonManager personManager;
    @Autowired
    private NewEntryPersonInfoRepository newEntryPersonInfoRepository;

    @Override
    public Page<NewEntryPersonInfoDO> getPersonInfoList(NewEntryPersonInfoQueryCnd cnd) {
        List<Sort.Order> list = new ArrayList<>();
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "startDate");
        Sort.Order order2 = new Sort.Order(Sort.Direction.ASC, "personId");
        list.add(order1);
        list.add(order2);
        Sort sort = Sort.by(list);
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1, cnd.getPageSize(), sort);
        Page<NewEntryPersonInfoDO> page = entryPersonInfoDao.findAll(new Specification<NewEntryPersonInfoDO>() {
            @Override
            public Predicate toPredicate(Root<NewEntryPersonInfoDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (cnd.getStartDate() != null && cnd.getEndDate() != null) {
                    if(cnd.getDateType() == 1){ //时间判断为报到日期
                        predicates.add(criteriaBuilder.between(root.get("startDate"), cnd.getStartDate(), cnd.getEndDate()));
                    }
                    if(cnd.getDateType() == 2){//时间判断为转正日期
                        predicates.add(criteriaBuilder.between(root.get("regularDate"), cnd.getStartDate(), cnd.getEndDate()));
                    }
                    if(cnd.getDateType() == 3){//时间判断为到职日期
                        predicates.add(criteriaBuilder.between(root.get("entryDate"), cnd.getStartDate(), cnd.getEndDate()));
                    }
                }
                if (StringUtils.isNotBlank(cnd.getDeptNo())) {
                    predicates.add(criteriaBuilder.equal(root.get("deptNo"), cnd.getDeptNo()));
                }
                if (StringUtils.isNotBlank(cnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("personName"), "%" + cnd.getInputContent() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("pinyin"), "%" + cnd.getInputContent().toLowerCase() + "%");
                    predicates.add(criteriaBuilder.or(c1, c2));
                }
                if(cnd.getCompany() != null){
                    predicates.add(criteriaBuilder.equal(root.get("company"), cnd.getCompany()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return page;
    }

    @Override
    public void updateSalary(String personId, Double probationSalary, Double regularSalary, Double paymentBase,Integer place) {
        PersonDO personDO = personManager.getPerson(personId);
        personDO.setProbationSalary(probationSalary);
        personDO.setRegularSalary(regularSalary);
        personDO.setPaymentBase(paymentBase);
        personDO.setPaymentPlace(place);
        List<PersonDO> personDOS = new ArrayList<>();
        personDOS.add(personDO);
        personManager.savePersons(personDOS);
    }

    @Override
    public List<NewEntryPersonInfoDO> getAllPersonInfoList(NewEntryPersonInfoQueryCnd cnd) {
        List<Sort.Order> list = new ArrayList<>();
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "startDate");
        Sort.Order order2 = new Sort.Order(Sort.Direction.ASC, "personId");
        list.add(order1);
        list.add(order2);
        Sort sort = Sort.by(list);
        List<NewEntryPersonInfoDO> page = entryPersonInfoDao.findAll(new Specification<NewEntryPersonInfoDO>() {
            @Override
            public Predicate toPredicate(Root<NewEntryPersonInfoDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(cnd.getStartDate() != null && cnd.getEndDate() != null){
                    if(cnd.getDateType() == 1){ //时间判断为报到日期
                        predicates.add(criteriaBuilder.between(root.get("startDate"), cnd.getStartDate(), cnd.getEndDate()));
                    }
                    if(cnd.getDateType() == 2){//时间判断为转正日期
                        predicates.add(criteriaBuilder.between(root.get("regularDate"), cnd.getStartDate(), cnd.getEndDate()));
                    }
                }
                if(StringUtils.isNotBlank(cnd.getDeptNo())){
                    predicates.add(criteriaBuilder.equal(root.get("deptNo"),cnd.getDeptNo()));
                }
                if(StringUtils.isNotBlank(cnd.getInputContent())){
                    Predicate c1 = criteriaBuilder.like(root.get("personName"),"%"+cnd.getInputContent()+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("pinyin"),"%"+cnd.getInputContent().toLowerCase()+"%");
                    predicates.add(criteriaBuilder.or(c1,c2));
                }
                if(cnd.getCompany() != null){
                    predicates.add(criteriaBuilder.equal(root.get("company"), cnd.getCompany()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, sort);
        return page;
    }

    @Override
    public List<PersonCompanyDO> getAllCompany() {
        return newEntryPersonInfoRepository.findAllCompany();
    }
}

