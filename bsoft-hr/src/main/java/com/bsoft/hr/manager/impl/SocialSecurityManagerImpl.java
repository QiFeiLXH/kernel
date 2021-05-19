package com.bsoft.hr.manager.impl;

import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.hr.condition.PersonSocialPlaceQueryCnd;
import com.bsoft.hr.dao.primary.*;
import com.bsoft.hr.entity.primary.*;
import com.bsoft.hr.manager.SocialSecurityManager;
import com.bsoft.hr.repository.primary.SocialSecurityRepository;
import com.bsoft.person.entity.primary.PersonDO;
import com.bsoft.person.manager.PersonManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Xuhui Lin
 * @Date 2020/11/26 17:40
 * @Description
 */
@Service
public class SocialSecurityManagerImpl implements SocialSecurityManager {
    @Autowired
    private CompanySocialMeeterDao companySocialMeeterDao;
    @Autowired
    private CompanySocialMeeterViewDao companySocialMeeterViewDao;
    @Autowired
    private SocialSecurityRepository socialSecurityRepository;
    @Autowired
    private PersonSocialPlaceViewDao personSocialPlaceViewDao;
    @Autowired
    private SocialAdjustmentRecordDao socialAdjustmentRecordDao;
    @Autowired
    private SocialAdjustmentRecordViewDao socialAdjustmentRecordViewDao;
    @Autowired
    private PersonManager personManager;
    @Autowired
    private ServerDateManager serverDateManager;

    @Override
    public Page<CompanySocialMeeterViewDO> getCompanySocialMeeterList(String inputContent, List<Integer> socialCompanyFlag, Integer pageNo, Integer pageSize) {
        Sort sort = Sort.by("sortNo").ascending();
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,sort);
        Page<CompanySocialMeeterViewDO> pages = companySocialMeeterViewDao.findAll(new Specification<CompanySocialMeeterViewDO>() {
            @Override
            public Predicate toPredicate(Root<CompanySocialMeeterViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(inputContent)) {
                    Predicate c1 = criteriaBuilder.like(root.get("placeName"),"%"+inputContent+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("abbreviation"),"%"+inputContent+"%");
                    Predicate c3 = criteriaBuilder.like(root.get("simpleCode"),"%"+inputContent.toLowerCase()+"%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3));
                }
                if (socialCompanyFlag.isEmpty()) {
                    predicates.add(criteriaBuilder.isNull(root.get("socialCompanyFlag")));
                } else if (socialCompanyFlag.size() == 1) {
                    predicates.add(criteriaBuilder.equal(root.get("socialCompanyFlag"), socialCompanyFlag.get(0)));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    @Transactional
    public void saveCompanySocialMeeter(CompanySocialMeeterDO companySocialMeeterDO) {
        companySocialMeeterDao.updateSocialMeeter(companySocialMeeterDO);
    }

    @Override
    public void generateLackSocialCompanys() {
        // 查询缺少的数据
        List<CompanySocialMeeterDO> lackSocialCompanys = socialSecurityRepository.getLackSocialCompanys();
        // 保存缺少的数据
        if (!lackSocialCompanys.isEmpty()) {
            companySocialMeeterDao.saveAll(lackSocialCompanys);
        }
    }

    @Override
    public Page<PersonSocialPlaceViewDO> getPersonalSocialPlaceList(PersonSocialPlaceQueryCnd cnd) {
        Sort sort = Sort.by("personId").descending();
        Pageable pageable = PageRequest.of(cnd.getPageNo()-1,cnd.getPageSize(),sort);
        Page<PersonSocialPlaceViewDO> pages = personSocialPlaceViewDao.findAll(new Specification<PersonSocialPlaceViewDO>() {
            @Override
            public Predicate toPredicate(Root<PersonSocialPlaceViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (cnd.getDeptId().equals("all")) {
                    predicates.add(criteriaBuilder.equal(root.get("deptType"), cnd.getDeptType()));
                } else {
                    predicates.add(criteriaBuilder.equal(root.get("deptId"), cnd.getDeptId()));
                }
                if (cnd.getSocialPlaceId() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("nowPlace"), cnd.getSocialPlaceId()));
                }
                if (StringUtils.isNotBlank(cnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("personName"),"%"+cnd.getInputContent()+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("personId"),"%"+cnd.getInputContent()+"%");
                    Predicate c3 = criteriaBuilder.like(root.get("simpleCode"),"%"+cnd.getInputContent().toLowerCase()+"%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3));
                }
                if (cnd.getValid() == null || cnd.getValid().isEmpty()) {
                    predicates.add(criteriaBuilder.isNull(root.get("valid")));
                }else if (cnd.getValid().size() == 1) {
                    predicates.add(criteriaBuilder.equal(root.get("valid"), cnd.getValid().get(0)));
                }else if (cnd.getValid().size() == 2) {
                    predicates.add(criteriaBuilder.or(root.get("valid").as(String.class).in(cnd.getValid())));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);

        return pages;
    }

    @Override
    public Page<SocialAdjustmentRecordViewDO> getPersonalSocialAdjustmentRecordList(String personId, Integer pageNo, Integer pageSize) {
        Sort sort = Sort.by("submitDate").descending().and(Sort.by("id").descending()).and(Sort.by("month").descending());
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,sort);
        return socialAdjustmentRecordViewDao.findAllByPersonId(personId, pageable);
    }

    @Override
    @Transactional
    public void savePersonalSocialPlaces(List<SocialAdjustmentRecordDO> recordDOS, String personId) {
        Date serverDate = serverDateManager.getServerDate();

        // 取出工号及调整后的社保缴纳地
        Map<String, Integer> personMap = recordDOS.stream().collect(Collectors.toMap(SocialAdjustmentRecordDO::getPersonId, SocialAdjustmentRecordDO::getPlace));
        recordDOS.forEach(recordDO -> {
            recordDO.setSubmitDate(serverDate);
            recordDO.setSubmitter(personId);
        });
        List<PersonDO> persons = new ArrayList<>();
        personMap.forEach((personid,companyId) -> {
            PersonDO personDO = new PersonDO();
            personDO.setPersonId(personid);
            personDO.setPaymentPlace(companyId);
            persons.add(personDO);
        });
        // 更新员工社保缴纳地
        personManager.updateBatchPersonPaymentPlace(persons);
        // 新增调整记录
        socialAdjustmentRecordDao.saveAll(recordDOS);
    }
}
