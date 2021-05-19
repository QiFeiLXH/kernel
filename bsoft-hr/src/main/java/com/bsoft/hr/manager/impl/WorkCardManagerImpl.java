package com.bsoft.hr.manager.impl;

import com.bsoft.auth.manager.MenuAuthorityManager;
import com.bsoft.exception.ServiceException;
import com.bsoft.hr.condition.WorkCardQueryCnd;
import com.bsoft.hr.dao.primary.WorkCardDao;
import com.bsoft.hr.dao.primary.WorkCardViewDao;
import com.bsoft.hr.entity.primary.WorkCardDO;
import com.bsoft.hr.entity.primary.WorkCardDateCountViewDO;
import com.bsoft.hr.entity.primary.WorkCardViewDO;
import com.bsoft.hr.manager.WorkCardManager;
import com.bsoft.hr.repository.primary.WorkCardRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import java.math.BigDecimal;
import java.util.*;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/15 17:38
 * @Description
 */
@Service
public class WorkCardManagerImpl implements WorkCardManager {
    @Autowired
    private WorkCardDao workCardDao;
    @Autowired
    private WorkCardViewDao workCardViewDao;
    @Autowired
    private WorkCardRepository workCardRepository;
    @Autowired
    private MenuAuthorityManager menuAuthorityManager;

    @Override
    public List<WorkCardDateCountViewDO> getDateList() {
        return workCardRepository.getDateCountList();
    }

    @Override
    public PageInfo<WorkCardViewDO> getWorkCardList(WorkCardQueryCnd cnd) {
        PageHelper.startPage(cnd.getPageNo(),cnd.getPageSize());
        List<WorkCardViewDO> list = new ArrayList<>();
        if (!cnd.getRecharge().isEmpty()) {
            list = workCardRepository.getWorkCardList(cnd);
        }
        PageInfo<WorkCardViewDO> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    @Transactional
    public Double getPersonWorkCardAmount(Integer personType, Date startDate) {
        Double amount = 0.0;
        List<Integer> leve1l = new ArrayList<>(Arrays.asList(0,1,2));// 普通、实习、中层
        List<Integer> leve12 = new ArrayList<>(Arrays.asList(3));// 领导
        // 查询当前月份总天数（工作日）、与剩余天数（包含今天的工作日）
        Map<String, Object> dayMap = workCardRepository.getCurrentMonthAllAndLeftDays(startDate);
        Integer allCount = new BigDecimal(dayMap.get("ALLDAYS").toString()).intValue();
        Integer leftCount = new BigDecimal(dayMap.get("LEFTDAYS").toString()).intValue();
        if (leve1l.contains(personType)) {
            amount = 300.0 / allCount * leftCount;
        } else if (leve12.contains(personType)) {
            amount = 500.0 / allCount * leftCount;
        }
        return Math.floor(amount);
    }
    @Override
    public Page<WorkCardViewDO> getWorkCardMakeList(WorkCardQueryCnd cnd) {
        Sort sort = Sort.by("personId").descending();
        Pageable pageable = PageRequest.of(cnd.getPageNo()-1,cnd.getPageSize(),sort);
        Page<WorkCardViewDO> pages = workCardViewDao.findAll(new Specification<WorkCardViewDO>() {
            @Override
            public Predicate toPredicate(Root<WorkCardViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(cnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("personId"),"%"+cnd.getInputContent()+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("simpleCode"),"%"+cnd.getInputContent().toLowerCase()+"%");
                    Predicate c3 = criteriaBuilder.like(root.get("personName"),"%"+cnd.getInputContent()+"%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3));
                }
                if (cnd.getFlag() == 1) {
                    predicates.add(criteriaBuilder.equal(root.get("status"), 2));
                } else if (cnd.getFlag() == 2) {
                    predicates.add(criteriaBuilder.greaterThan(root.get("status"), 2));
                    predicates.add(criteriaBuilder.equal(root.get("workcardFlag"), 1));
                }
                if (cnd.getRecharge().size() == 1) {
                    predicates.add(criteriaBuilder.equal(root.get("recharge"), cnd.getRecharge().get(0)));
                } else if (cnd.getRecharge().isEmpty()) {
                    predicates.add(criteriaBuilder.isNull(root.get("recharge")));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    public Page<WorkCardViewDO> getWorkCardOpenAccessList(WorkCardQueryCnd cnd) {
        Sort sort = Sort.by("personId").descending();
        Pageable pageable = PageRequest.of(cnd.getPageNo()-1,cnd.getPageSize(),sort);
        Page<WorkCardViewDO> pages = workCardViewDao.findAll(new Specification<WorkCardViewDO>() {
            @Override
            public Predicate toPredicate(Root<WorkCardViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (StringUtils.isNotBlank(cnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("personId"),"%"+cnd.getInputContent()+"%");
                    Predicate c2 = criteriaBuilder.like(root.get("simpleCode"),"%"+cnd.getInputContent().toLowerCase()+"%");
                    Predicate c3 = criteriaBuilder.like(root.get("personName"),"%"+cnd.getInputContent()+"%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3));
                }
                if (cnd.getFlag() == 1) {
                    predicates.add(criteriaBuilder.equal(root.get("status"), 3));
                } else if (cnd.getFlag() == 2) {
                    predicates.add(criteriaBuilder.greaterThan(root.get("status"), 3));
                    predicates.add(criteriaBuilder.equal(root.get("workcardFlag"), 1));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    public Integer getWorkCardVerifyCount(WorkCardQueryCnd cnd) {
        return cnd.getRecharge().isEmpty() ? 0 : workCardRepository.getWorkCardVerifyCount(cnd);
    }

    @Override
    public Integer getWorkCardReceiveCount(WorkCardQueryCnd cnd) {
        return cnd.getRecharge().isEmpty() ? 0 : workCardRepository.getWorkCardReceiveCount(cnd);
    }

    @Override
    public Integer getWorkCardMakeCount(WorkCardQueryCnd cnd) {
        return cnd.getRecharge().isEmpty() ? 0 : workCardRepository.getWorkCardMakeCount(cnd);
    }

    @Override
    public Integer getWorkCardOpenAccessCount(WorkCardQueryCnd cnd) {
        return workCardRepository.getWorkCardOpenAccessCount(cnd);
    }

    @Override
    public Integer getPortalWorkCardVerifyNeedDoCount(String personId) {
        boolean result = menuAuthorityManager.checkPrivateMenuPermission(personId, "workcardverifyreceive");
        Integer count = 0;
        if (result) {
            count = workCardViewDao.getPortalWorkCardVerifyNeedDoCount();
        }
        return count;
    }

    @Override
    public Integer getPortalWorkCardMakeNeedDoCount(String personId) {
        boolean result = menuAuthorityManager.checkPrivateMenuPermission(personId, "workcardmake");
        Integer count = 0;
        if (result) {
            count = workCardViewDao.getPortalWorkCardMakeNeedDoCount();
        }
        return count;
    }

    @Override
    public Integer getPortalWorkCardOpenNeedDoCount(String personId) {
        boolean result = menuAuthorityManager.checkPrivateMenuPermission(personId, "workcardopenaccess");
        Integer count = 0;
        if (result) {
            count = workCardViewDao.getPortalWorkCardOpenNeedDoCount();
        }
        return count;
    }

    @Override
    public Integer getPortalWorkCardReceiveNeedDoCount(String personId) {
        boolean result = menuAuthorityManager.checkPrivateMenuPermission(personId, "workcardverifyreceive");
        Integer count = 0;
        if (result) {
            count = workCardViewDao.getPortalWorkCardReceiveNeedDoCount();
        }
        return count;
    }

    @Override
    @Transactional
    public void batchReceiveWorkCard(List<String> personIds) {
        personIds.forEach(personId -> {
            workCardDao.receiveWorkCard(personId);
        });
    }

    @Override
    public List<WorkCardViewDO> getWorkCardNeedMakingList(List<String> personIds) {
        if (personIds == null || personIds.isEmpty()) {
            throw new ServiceException("工号列表不能为空");
        }
        return workCardViewDao.findAllByPersonIdIn(personIds);
    }

    @Override
    @Transactional
    public void verifyWorkCard(WorkCardDO workCardDO) {
        workCardDao.verifyWorkCard(workCardDO);
    }

    @Override
    @Transactional
    public void makeWorkCard(WorkCardDO workCardDO) {
        workCardDao.makeWorkCard(workCardDO);
    }

    @Override
    @Transactional
    public void openAccessWorkCard(WorkCardDO workCardDO) {
        workCardDao.openAccessWorkCard(workCardDO);
    }

    @Override
    @Transactional
    public void receiveWorkCard(String personId) {
        workCardDao.receiveWorkCard(personId);
    }

}
