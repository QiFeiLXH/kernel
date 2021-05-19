package com.bsoft.person.manager.impl;

import com.bsoft.common.dao.primary.HumanDicDao;
import com.bsoft.common.dao.primary.PublicDicDao;
import com.bsoft.common.dao.primary.SystemDicDao;
import com.bsoft.common.entity.primary.HumanDicDO;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.entity.primary.SystemDicDO;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.dept.dao.primary.DeptDao;
import com.bsoft.dept.entity.primary.DeptDO;
import com.bsoft.exception.ServiceException;
import com.bsoft.hr.dto.HrFeeRulesRecordDTO;
import com.bsoft.hr.service.PostAndCostRuleService;
import com.bsoft.person.condition.PersonSelectQueryCnd;
import com.bsoft.person.dao.primary.*;
import com.bsoft.person.dto.PersonTransferConditionDTO;
import com.bsoft.person.dto.PersonTransferQueryCndDTO;
import com.bsoft.person.entity.primary.*;
import com.bsoft.person.manager.PersonManager;
import com.bsoft.person.repository.primary.PersonRepository;
import org.apache.commons.lang3.StringUtils;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class PersonManagerImpl implements PersonManager {
    private static final String DEFAULT_CACHENAME = "PersonWithId";

    @Autowired
    private PersonDao personDao;
    @Autowired
    private PersonViewDao personViewDao;
    @Autowired
    private PersonSelectViewDao personSelectViewDao;
    @Autowired
    private RankPersonDao rankPersonDao;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonTransferConditionDao personTransferConditionDao;
    @Autowired
    private CloudschoolUserSynDao cloudschoolUserSynDao;


    @Override
    public PersonDO getPerson(String personid) {
        Optional<PersonDO> person = personDao.findById(personid);
        PersonDO personDO = person.orElseThrow(()->new ServiceException("没有该用户信息"));
        return personDO;
    }

    @Override
    public List<PersonDO> getPersonList(List<String> personIds) {
        return personDao.findByPersonIdIn(personIds);
    }

    @Override
    public PersonViewDO getPersonView(String personid) {
        Optional<PersonViewDO> person = personViewDao.findById(personid);
        PersonViewDO personViewDO = person.orElseThrow(()->new ServiceException("没有该用户信息"));
        return personViewDO;
    }

    @Override
    public List<PersonDO> getPerson(){
        return personDao.findAll();
    }

    @Override
    public Map<String, String> getDicPerson() {
        List<PersonDO> personDOList = this.getPerson();
        return personDOList.stream().collect(Collectors.toMap(PersonDO::getPersonId,PersonDO::getPersonName,(key1,key2)->key1));
    }

    @Override
    public Map<String,String> getIdDicPerson(){
        List<PersonDO> personDOList = this.getPerson();
        return personDOList.stream().collect(Collectors.toMap((x)->String.valueOf(x.getUserId()),PersonDO::getPersonName,(key1,key2)->key1));
    }

    @Override
    @Cacheable(cacheNames = DEFAULT_CACHENAME,key = "#id")
    public PersonDO getPersonWithId(Integer id) {
        List<PersonDO> results = personDao.findByUserId(id);
        return results != null && !results.isEmpty() ? results.get(0) : null;
    }

    @Override
    public List<PersonDO> getVaildPerson() {
        return personDao.findByIsValid("0");
    }

    @Override
    public List<String> getVaildPersonId() {
        return personDao.getVaildPersonId();
    }

    @Override
    public List<PersonDO> getDeptPerson(String bmdm) {
        return personDao.findByDeptIdAndIsValidAndCompany(bmdm,"0",1);
    }

    @Override
    public List<PersonDO> getPersonInfo(String value) {
        value = "%" + value + "%";
        return personDao.findByPerson(value);
    }

    @Override
    public RankPersonDO getRankPerson(String personId) {
        Optional<RankPersonDO> rankPerson = rankPersonDao.findById(personId);
        rankPerson.orElseThrow(()-> new ServiceException("没有该员工信息"));
        return rankPerson.get();
    }

    @Override
    public List<String> getEmails(List<String> personId) {
        return personDao.getEmails(personId);
    }

    @Override
    public void savePersons(List<PersonDO> personDOS) {
        personDao.saveAll(personDOS);
    }

    @Override
    public List<PersonDO> getPersonsEvaluated() {
        return personRepository.getPersonsEvaluated();
    }

    @Override
    public List<PersonDO> getPersonsEvaluated(List<String> personIds) {
        return personRepository.getPersonsEvaluatedByPersonIds(personIds);
    }

    @Override
    public List<PersonSelectViewDO> getPersonSelectList(String simpleCode) {
        Specification<PersonSelectViewDO> spec = new Specification<PersonSelectViewDO>() {
            @Override
            public Predicate toPredicate(Root<PersonSelectViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("isValid"),0));
                Predicate c1 = criteriaBuilder.like(root.get("personName"),"%"+simpleCode+"%");
                Predicate c2 = criteriaBuilder.like(root.get("simpleCode"),"%"+simpleCode.toLowerCase()+"%");
                predicates.add(criteriaBuilder.or(c1,c2));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        List<PersonSelectViewDO> persons = personSelectViewDao.findAll(spec);
        return persons;
    }

    @Override
    public List<PersonSelectViewDO> getPersonSelectList(String inputContent, Integer isValid) {
        Specification<PersonSelectViewDO> spec = new Specification<PersonSelectViewDO>() {
            @Override
            public Predicate toPredicate(Root<PersonSelectViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("isValid"),isValid));
                Predicate c1 = criteriaBuilder.like(root.get("personName"),"%"+inputContent+"%");
                Predicate c2 = criteriaBuilder.like(root.get("simpleCode"),"%"+inputContent.toLowerCase()+"%");
                predicates.add(criteriaBuilder.or(c1,c2));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        List<PersonSelectViewDO> persons = personSelectViewDao.findAll(spec);
        return persons;
    }

    @Override
    public List<PersonSelectViewDO> getPersonSelectList(PersonSelectQueryCnd queryCnd) {
        List<PersonSelectViewDO> result = personSelectViewDao.findAll(new Specification<PersonSelectViewDO>() {
            @Override
            public Predicate toPredicate(Root<PersonSelectViewDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(queryCnd.getPersonId())) {
                    predicates.add(criteriaBuilder.equal(root.get("personId"), queryCnd.getPersonId()));
                } else if (StringUtils.isNotBlank(queryCnd.getPersonName())) {
                    predicates.add(criteriaBuilder.equal(root.get("personName"), queryCnd.getPersonName()));
                } else if (StringUtils.isNotBlank(queryCnd.getSimpleCode())) {
                    predicates.add(criteriaBuilder.like(root.get("simpleCode"), "%" + queryCnd.getSimpleCode().toLowerCase() + "%"));
                } else if (StringUtils.isNotBlank(queryCnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("personName"), "%" + queryCnd.getInputContent() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("simpleCode"), "%" + queryCnd.getInputContent().toLowerCase() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("personId"), "%" + queryCnd.getInputContent() + "%");
                    predicates.add(criteriaBuilder.or(c1, c2, c3));
                }
                    predicates.add(criteriaBuilder.equal(root.get("isValid"), 0));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        return result;
    }

    @Override
    @Transactional
    public void updateBatchPersonPaymentPlace(List<PersonDO> persons) {
        personRepository.updateBatchPersonPaymentPlace(persons);
    }

    @Override
    public void updatePerson(PersonDO personDO) {
        personDao.save(personDO);
    }

    @Override
    public Page<PersonTransferConditionsDO> getPersonTransfer(PersonTransferQueryCndDTO cndDTO) throws ParseException {
        Sort sort = Sort.by("transferDate").descending();
        Date addMonth = this.getAddMonth(cndDTO.getTransferDate());
        if(cndDTO.getPageNo()==null&&cndDTO.getPageSize()==null){
            cndDTO.setPageNo(1);
            cndDTO.setPageSize(25);
        }
        Pageable pageable = PageRequest.of(cndDTO.getPageNo()-1,cndDTO.getPageSize(),sort);
        Page<PersonTransferConditionsDO> personTransferConditionsDOS = personTransferConditionDao.findAll(new Specification<PersonTransferConditionsDO>() {
            @Override
            public Predicate toPredicate(Root<PersonTransferConditionsDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(cndDTO!=null){
                    if (StringUtils.isNotBlank(cndDTO.getXuslgname())) {
                        Predicate c1 = criteriaBuilder.like(root.get("personName"), "%" + cndDTO.getXuslgname() + "%");
                        Predicate c2 = criteriaBuilder.like(root.get("simpleCode"), "%" + cndDTO.getXuslgname().toLowerCase() + "%");
                        Predicate c3 = criteriaBuilder.like(root.get("personId"), "%" + cndDTO.getXuslgname() + "%");
                        predicates.add(criteriaBuilder.or(c1, c2, c3));                    }

                    if (StringUtils.isNotBlank(cndDTO.getXdno())) {
                        predicates.add(criteriaBuilder.equal(root.get("laterDept"), cndDTO.getXdno()));
                    }
                    if (cndDTO.getTransferDate()!=null) {
                        predicates.add(criteriaBuilder.between(root.get("transferDate"),  cndDTO.getTransferDate(),addMonth));
                    }
                    String flag = cndDTO.getFlag().toString();
                    if ("0".equals(flag)){//不含新入司
                        predicates.add(criteriaBuilder.isNotNull(root.get("aheadDept")));
                    }
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return personTransferConditionsDOS;
    }


    @Override
    public List<PersonTransferConditionsDO> getExcelPersonTransfer(PersonTransferQueryCndDTO cndDTO) throws ParseException {
        Sort sort = Sort.by("transferDate").ascending();
        Date addMonth = this.getAddMonth(cndDTO.getTransferDate());
        List<PersonTransferConditionsDO> personTransferConditionsDOS = personTransferConditionDao.findAll(new Specification<PersonTransferConditionsDO>() {
            @Override
            public Predicate toPredicate(Root<PersonTransferConditionsDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(cndDTO!=null){
                    if (StringUtils.isNotBlank(cndDTO.getXuslgname())) {
                        Predicate c1 = criteriaBuilder.like(root.get("personName"), "%" + cndDTO.getXuslgname() + "%");
                        Predicate c2 = criteriaBuilder.like(root.get("simpleCode"), "%" + cndDTO.getXuslgname().toLowerCase() + "%");
                        Predicate c3 = criteriaBuilder.like(root.get("personId"), "%" + cndDTO.getXuslgname() + "%");
                        predicates.add(criteriaBuilder.or(c1, c2, c3));
                    }
                    if (StringUtils.isNotBlank(cndDTO.getXdno())) {
                        predicates.add(criteriaBuilder.equal(root.get("laterDept"), cndDTO.getXdno()));
                    }
                    if (cndDTO.getTransferDate()!=null) {
                        predicates.add(criteriaBuilder.between(root.get("transferDate"),  cndDTO.getTransferDate(),addMonth));
                    }
                    String flag = cndDTO.getFlag().toString();
                    if ("0".equals(flag)){//不含新入司
                        predicates.add(criteriaBuilder.isNotNull(root.get("aheadDept")));
                    }
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        List<PersonTransferConditionsDO> collect = personTransferConditionsDOS.stream().sorted(Comparator.comparing(PersonTransferConditionsDO::getTransferDate).reversed()).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<PersonDO> findByFlag() {
        return   cloudschoolUserSynDao.findByFlag("0");

    }

    public Date getAddMonth(Date date) throws ParseException {
        if(date!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(date);
            rightNow.add(Calendar.MONTH, 1);
            rightNow.add(Calendar.DATE, -1);
            Date dt1 = rightNow.getTime();
            String format = sdf.format(dt1);
            Date endDate = sdf.parse(format);
            return endDate;
        }else{
            return  null;
        }
    }
}
