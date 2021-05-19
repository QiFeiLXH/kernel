package com.bsoft.common.manager.impl;

import com.bsoft.common.dao.primary.CompanyDao;
import com.bsoft.common.dao.primary.CompanyViewDao;
import com.bsoft.common.entity.primary.CompanyDO;
import com.bsoft.common.entity.primary.CompanyViewDO;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.key.KeyGenerator;
import com.bsoft.common.manager.CompanyManager;
import com.bsoft.common.manager.PublicDicManager;
import com.bsoft.common.validate.ValidateUtil;
import org.apache.commons.lang3.StringUtils;
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
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyManagerImpl implements CompanyManager {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private CompanyViewDao companyViewDao;
    @Autowired
    private KeyGenerator keyGenerator;
    @Autowired
    private PublicDicManager publicDicManager;

    @Override
    public List<CompanyDO> getCompanyList() {
        return companyDao.getCompanyList();
    }

    @Override
    public Integer saveCompany(CompanyDO companyDO) {
        ValidateUtil.check(companyDO);
        if (companyDO.getCompanyId() == null){
            Integer key = keyGenerator.increaseCompany();
            companyDO.setCompanyId(key);
        }
        return companyDao.save(companyDO).getCompanyId();
    }

    @Override
    public List<CompanyViewDO> getAllCompany() {
        return companyViewDao.findAll(Sort.by("unitcode").ascending());
    }

    @Override
    public CompanyViewDO getCompanyById(Integer id) {
        return companyViewDao.getOne(id);
    }

    @Override
    public List<CompanyViewDO> getCompanyDic(Integer type) {
        return companyViewDao.findCompanyDic(type);
    }

    @Override
    public List<CompanyViewDO> getCompanyDic(Integer type,String context) {
        return companyViewDao.findCompanyDic(type,context);
    }

    @Override
    public List<CompanyViewDO> getNotCancelledCompany() {
        return companyViewDao.findAllBySignOffOrderByUnitcodeAsc(0);
    }

    @Override
    @Transactional
    public void cancelCompany(Integer companyId) {
        companyDao.doCancelCompany(companyId);
    }

    @Override
    public List<CompanyDO> findByUnitCode(String unitCode, Integer companyId) {
        return companyDao.findAllByUnitcodeAndCompanyIdNot(unitCode,companyId);
    }

    @Override
    public List<CompanyDO> findByName(String Name, Integer companyId) {
        return companyDao.findAllByAbbreviationAndCompanyIdNot(Name,companyId);
    }

    @Override
    @Transactional
    public void saveCompanyPurpose() {
        List<PublicDicDO> publicDicDOS = publicDicManager.getPublicDic(9912);
        List<CompanyDO> companyDOS = companyDao.getCompany(publicDicDOS.size());
        if (companyDOS.size()>0){
            companyDOS.forEach(CompanyDO->{
                if (CompanyDO.getPurpose() == null){
                    String purpose = String.format("%1$0"+(publicDicDOS.size())+"d",0);
                    CompanyDO.setPurpose(purpose);
                }else{
                    String p = CompanyDO.getPurpose();
                    String purpose = p + String.format("%1$0"+(publicDicDOS.size()-p.length())+"d",0);
                    CompanyDO.setPurpose(purpose);
                }
            });
            companyDao.saveAll(companyDOS);
        }
    }

    @Override
    public List<CompanyViewDO> getCompanyViewList(String inputContent) {
        List<CompanyViewDO> result = companyViewDao.findAll(new Specification<CompanyViewDO>() {
            @Override
            public Predicate toPredicate(Root<CompanyViewDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                   if (StringUtils.isNotBlank(inputContent)) {
                    Predicate c1 = criteriaBuilder.like(root.get("companyName"), "%" + inputContent + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("pinyinCode"), "%" + inputContent.toLowerCase() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("pinyinCode"), "%" + inputContent.toUpperCase() + "%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3));
                }
                    predicates.add(criteriaBuilder.equal(root.get("signOff"), 0));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
        result=result.stream().sorted(Comparator.comparing(CompanyViewDO::getUnitcode)).collect(Collectors.toList());
        return result;
    }
}
