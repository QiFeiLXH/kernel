package com.bsoft.sales.manager.impl;

import com.bsoft.common.key.KeyGenerator;
import com.bsoft.common.service.ServerDateService;
import com.bsoft.sales.condition.OriginalAcceptanceQueryCnd;
import com.bsoft.sales.dao.primary.OriginalAcceptanceDao;
import com.bsoft.sales.dao.primary.ProjectWordDao;
import com.bsoft.sales.dao.primary.WordOriginalReceiptDao;
import com.bsoft.sales.entity.primary.OriginalAcceptanceDO;
import com.bsoft.sales.entity.primary.ProjectWordDO;
import com.bsoft.sales.entity.primary.WordOriginalReceiptDO;
import com.bsoft.sales.manager.OriginalAcceptanceManager;
import org.apache.dubbo.config.annotation.Reference;
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
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xucl
 * @DateTime: 2020/7/29 15:50
 * @Description: 合同原件接收、归档
 */
@Component
public class OriginalAcceptanceManagerImpl implements OriginalAcceptanceManager {
    @Autowired
    OriginalAcceptanceDao originalAcceptanceDao;
    @Autowired
    ProjectWordDao projectWordDao;
    @Autowired
    WordOriginalReceiptDao wordOriginalReceiptDao;
    @Reference
    ServerDateService serverDateService;
    @Autowired
    private KeyGenerator keyGenerator;
    @Override
    public Page<OriginalAcceptanceDO> getOriginalAcceptance(OriginalAcceptanceQueryCnd cnd) {
        Sort sort = Sort.by("signDate").descending().and(Sort.by("recordId").descending());
        Pageable pageable = PageRequest.of(cnd.getPageNo()-1,cnd.getPageSize(),sort);
        Page<OriginalAcceptanceDO> pages = originalAcceptanceDao.findAll(new Specification<OriginalAcceptanceDO>() {
            @Override
            public Predicate toPredicate(Root<OriginalAcceptanceDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                Integer status = cnd.getStatus();
                predicates.add(criteriaBuilder.equal(root.get("status"),status));
                if(cnd.getStartDate() != null && cnd.getEndDate() != null){
                    predicates.add(criteriaBuilder.between(root.get("signDate"),cnd.getStartDate(),cnd.getEndDate()));
                }
                String inpitContent =  cnd.getInputContent();
                if (inpitContent != null){
                    Predicate c1 = criteriaBuilder.like(root.get("contractno"), "%" + inpitContent + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("contractName"), "%" + inpitContent + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("pinYinCode"), "%" + inpitContent.toLowerCase() + "%");
                    Predicate c4 = criteriaBuilder.like(root.get("contractReviewerText"), "%" + inpitContent + "%");
                    predicates.add(criteriaBuilder.or(c1, c2,c3, c4));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    @Transactional
    public void auditOriginalAcceptance(List<OriginalAcceptanceDO> words, String userId, Integer status) {
        List<ProjectWordDO> projectWordDOS = new ArrayList<>();
        List<WordOriginalReceiptDO> wordOriginalReceiptDOS = new ArrayList<>();
        for (OriginalAcceptanceDO originalAcceptanceDO:words){
            ProjectWordDO projectWordDO = projectWordDao.getOne(originalAcceptanceDO.getRecordId());
            if (status == 3){//财务归档
                projectWordDO.setFilingFlag(1);
                projectWordDO.setFilingDate(serverDateService.getServerDateTime());
                projectWordDO.setArchivist(userId);
                projectWordDO.setStatus(status);
                projectWordDO.setFilingNumber(originalAcceptanceDO.getNewDocumentNumber()); // 修改新的归档数量
            }else{//财务接收、法务接收
                projectWordDO.setReceivingFlag(1);
                projectWordDO.setReceivingDate(serverDateService.getServerDateTime());
                projectWordDO.setReceiver(userId);
                projectWordDO.setStatus(status);
                projectWordDO.setReceivingNumber(originalAcceptanceDO.getNewDocumentNumber()); // 修改新的接收数量
            }
            //插入原件接收明细
            WordOriginalReceiptDO wordOriginalReceiptDO = new WordOriginalReceiptDO();
            wordOriginalReceiptDO.setCount(originalAcceptanceDO.getNewDocumentNumber()); // 修改成新的接收（归档）数量
            wordOriginalReceiptDO.setReceiver(userId);
            wordOriginalReceiptDO.setReceivingDate(projectWordDO.getReceivingDate());
            wordOriginalReceiptDO.setReceivingFlag(1);
            wordOriginalReceiptDO.setStatus(status);
            wordOriginalReceiptDO.setRecoreId(projectWordDO.getId());
            wordOriginalReceiptDO.setId(keyGenerator.increaseWordOriginalAcceptance());
            wordOriginalReceiptDOS.add(wordOriginalReceiptDO);
            projectWordDOS.add(projectWordDO);
        }
        projectWordDao.saveAll(projectWordDOS);
        wordOriginalReceiptDao.saveAll(wordOriginalReceiptDOS);
    }
}
