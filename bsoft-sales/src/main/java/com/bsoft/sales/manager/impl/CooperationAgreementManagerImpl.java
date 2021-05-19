package com.bsoft.sales.manager.impl;

import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.utils.PinyinUtil;
import com.bsoft.sales.condition.SalesAgreementQueryCnd;
import com.bsoft.sales.dao.primary.*;
import com.bsoft.sales.entity.primary.*;
import com.bsoft.sales.manager.CooperationAgreementManager;
import com.bsoft.sales.repository.primary.CooperationAgreementRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/30 13:16
 * @Description
 */
@Service
public class CooperationAgreementManagerImpl implements CooperationAgreementManager {
    @Autowired
    private SalesPartnerViewDao salesPartnerViewDao;
    @Autowired
    private SalesPartnerDao salesPartnerDao;
    @Autowired
    private SalesPartnerUpdateDao salesPartnerUpdateDao;
    @Autowired
    private CooperationAgreementRepository cooperationAgreementRepository;
    @Autowired
    private SalesAgreementDao salesAgreementDao;
    @Autowired
    private SalesAgreementUpdateDao salesAgreementUpdateDao;
    @Autowired
    private SalesAgreementViewDao salesAgreementViewDao;
    @Autowired
    private ServerDateManager serverDateManager;

    @Override
    public Page<SalesPartnerViewDO> getSalesPartnerList(String inputContent,Integer pageNo, Integer pageSize) {
        Sort sort = Sort.by("registerDate").descending()
                .and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        Page<SalesPartnerViewDO> pages = salesPartnerViewDao.findAll(new Specification<SalesPartnerViewDO>() {
            @Override
            public Predicate toPredicate(Root<SalesPartnerViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(inputContent)) {
                    Predicate c1 = criteriaBuilder.like(root.get("partnerName"), "%" + inputContent + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("nameCode"), "%" + inputContent + "%");
                    predicates.add(criteriaBuilder.or(c1, c2));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return pages;
    }

    @Override
    @Transactional
    public Integer saveSalesPartner(SalesPartnerDO salesPartner, String provinceText, String cityText, String countyText) {
        String context = new StringBuilder().append(salesPartner.getPartnerName()).append(provinceText).append(cityText).append(countyText).append(salesPartner.getAddress()).toString();
        Integer count = cooperationAgreementRepository.getSimilarPartnerCount(context);
        if (count > 0) {
            return -1;// -1表示已存在类似的合作单位
        } else {
            String nameCode = PinyinUtil.getFirstSpell(salesPartner.getPartnerName());
            Date currentDate = serverDateManager.getServerDateTime();
            salesPartner.setRegisterDate(currentDate);
            salesPartner.setNameCode(nameCode);
            salesPartnerDao.save(salesPartner);
            return salesPartner.getId();
        }
    }

    @Override
    @Transactional
    public Integer updateSalesPartner(SalesPartnerUpdateDO salesPartner, String provinceText, String cityText, String countyText) {
        String nameCode = PinyinUtil.getFirstSpell(salesPartner.getPartnerName());
        salesPartner.setNameCode(nameCode);
        salesPartnerUpdateDao.save(salesPartner);
        return salesPartner.getId();
    }

    @Override
    @Transactional
    public void deleteSalesPartner(Integer id) {
        salesPartnerDao.deleteById(id);
    }

    @Override
    public Page<SalesAgreementViewDO> getSalesAgreementList(SalesAgreementQueryCnd cnds) {
        Sort sort = Sort.by("signDate").descending()
                .and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(cnds.getPageNo() - 1, cnds.getPageSize(), sort);
        Page<SalesAgreementViewDO> pages = salesAgreementViewDao.findAll(new Specification<SalesAgreementViewDO>() {
            @Override
            public Predicate toPredicate(Root<SalesAgreementViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(cnds.getPartnerName())) {
                    Predicate c1 = criteriaBuilder.like(root.get("partnerOneName"), "%" + cnds.getPartnerName() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("partnerOneNameCode"), "%" + cnds.getPartnerName() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("partnerTwoName"), "%" + cnds.getPartnerName() + "%");
                    Predicate c4 = criteriaBuilder.like(root.get("partnerTwoNameCode"), "%" + cnds.getPartnerName() + "%");
                    predicates.add(criteriaBuilder.or(c1, c2, c3, c4));
                }
                if (cnds.getNotice() != -1) {
                    predicates.add(criteriaBuilder.equal(root.get("notice"), cnds.getNotice()));
                }
                if (cnds.getCooperateType() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("cooperateType"), cnds.getCooperateType()));
                }
                if (cnds.getOriginalStatus() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("originalStatus"), cnds.getOriginalStatus()));
                }
                if (cnds.getStartDate() != null) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("registerDate"), cnds.getStartDate()));
                }
                if (cnds.getEndDate() != null) {
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("registerDate"), cnds.getEndDate()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return pages;
    }

    @Override
    @Transactional
    public void deleteSalesAgreement(Integer id) {
        salesAgreementDao.deleteById(id);
        // ToDo 删除合作协议同时删除文件
    }

    @Override
    public List<SalesPartnerViewDO> getSalesPartnerList(String partnerName) {
        return salesPartnerViewDao.findAllByPartnerNameOrNameCodeLike(partnerName);
    }

    @Override
    public SalesAgreementDO saveSalesAgreement(SalesAgreementDO salesAgreementDO, String personId) {
        Date currentDate = serverDateManager.getServerDateTime();
        salesAgreementDO.setRegisterDate(currentDate);
        salesAgreementDO.setRegisterant(personId);
        salesAgreementDao.save(salesAgreementDO);
        return salesAgreementDO;
    }

    @Override
    public SalesAgreementUpdateDO updateSalesAgreement(SalesAgreementUpdateDO salesAgreementUpdateDO, String personId) {
        Date currentDate = serverDateManager.getServerDateTime();
        salesAgreementUpdateDO.setModifyDate(currentDate);
        salesAgreementUpdateDO.setModifier(personId);
        salesAgreementUpdateDao.save(salesAgreementUpdateDO);
        return salesAgreementUpdateDO;
    }
}
