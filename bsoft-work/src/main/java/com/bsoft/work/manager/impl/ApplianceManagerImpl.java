package com.bsoft.work.manager.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.entity.primary.CostDicDO;
import com.bsoft.common.manager.CostDicManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.result.Result;
import com.bsoft.common.utils.PinyinUtil;
import com.bsoft.common.utils.ResultUtils;
import com.bsoft.work.condition.ApplianceNameQueryCnd;
import com.bsoft.work.condition.ApplianceQueryCnd;
import com.bsoft.work.dao.primary.ApplianceNameDao;
import com.bsoft.work.dao.primary.ApplianceStockDao;
import com.bsoft.work.dao.primary.ApplianceStoreDao;
import com.bsoft.work.entity.primary.ApplianceNameDO;
import com.bsoft.work.entity.primary.ApplianceStockDO;
import com.bsoft.work.entity.primary.ApplianceStoreDO;
import com.bsoft.work.entity.primary.ApplianceUseDO;
import com.bsoft.work.manager.ApplianceManager;
import com.bsoft.work.repository.primary.ApplianceStockRepository;
import com.bsoft.work.repository.primary.ApplianceStoreRepository;
import com.bsoft.work.repository.primary.ApplianceUseRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zy
 * @date: 2020/11/5
 * @description
 */
@Component
public class ApplianceManagerImpl implements ApplianceManager {

    private static final Integer STATUS_UNPAY = 1; // ????????????????????????
    private static final Integer STATUS_APPLYPAY = 2; // ??????????????????????????????
    private static final Integer STATUS_PAY = 3; // ????????????????????????
    /** ???????????????????????????2????????????*/
    private static final Integer COST_DIC_TYPE_APPLIANCE = 2;
    @Autowired
    private ApplianceStockDao applianceStockDao;
    @Autowired
    private ApplianceStoreDao applianceStoreDao;
    @Autowired
    private ApplianceNameDao applianceNameDao;
    @Autowired
    private ApplianceStockRepository applianceStockRepository;
    @Autowired
    private ApplianceUseRepository applianceUseRepository;
    @Autowired
    private ApplianceStoreRepository applianceStoreRepository;
    @Autowired
    private CostDicManager costDicManager;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Result<ApplianceStockDO> getApplianceStockList(ApplianceQueryCnd queryCnd) {
        PageHelper.startPage(queryCnd.getPageNo(), queryCnd.getPageSize());
        List<ApplianceStockDO> list = applianceStockRepository.findByQueryCnd(queryCnd);
        PageInfo<ApplianceStockDO> page = new PageInfo<>(list);
        return ResultUtils.parseResult(page, ApplianceStockDO.class);
    }

    @Override
    public void saveApplianceStock(ApplianceStockDO saveDO) {
        if(saveDO.getId() == null) {
            saveDO.setSurplusQuantity(saveDO.getQuantity());//????????????
            saveDO.setStatus(STATUS_UNPAY);//???????????????????????????
            saveDO.setSubmitFlag(0);//?????????
            applianceStockDao.save(saveDO);
        } else {
            ApplianceStockDO findDO = applianceStockDao.findById(saveDO.getId()).get();
            findDO.setType(saveDO.getType());
            findDO.setName(saveDO.getName());
            findDO.setStandards(saveDO.getStandards());
            findDO.setQuantity(saveDO.getQuantity());
            findDO.setUnitPrice(saveDO.getUnitPrice());
            findDO.setMoney(saveDO.getMoney());
            findDO.setSupplier(saveDO.getSupplier());
            findDO.setRemark(saveDO.getRemark());
            findDO.setSurplusQuantity(saveDO.getQuantity());
            saveDO.setSubmitFlag(0);//?????????
            applianceStockDao.save(findDO);
        }

    }

    @Override
    @Transactional
    public void submitApplianceStock(String userId, ApplianceStockDO saveDO) {
        // ??????????????????
        if(saveDO.getId() == null) {
            saveDO.setSurplusQuantity(saveDO.getQuantity());// ????????????
            saveDO.setStatus(STATUS_UNPAY);// ???????????????????????????
            saveDO.setRegister(userId);// ?????????
            saveDO.setInDate(serverDateManager.getServerDateTime());// ????????????
            saveDO.setSubmitFlag(1);//?????????
            applianceStockDao.save(saveDO);
        } else {
            ApplianceStockDO findDO = applianceStockDao.findById(saveDO.getId()).get();
            findDO.setType(saveDO.getType());
            findDO.setName(saveDO.getName());
            findDO.setStandards(saveDO.getStandards());
            findDO.setQuantity(saveDO.getQuantity());
            findDO.setUnitPrice(saveDO.getUnitPrice());
            findDO.setMoney(saveDO.getMoney());
            findDO.setSupplier(saveDO.getSupplier());
            findDO.setRemark(saveDO.getRemark());
            findDO.setSurplusQuantity(saveDO.getQuantity());
            findDO.setRegister(userId);
            findDO.setInDate(serverDateManager.getServerDateTime());
            findDO.setSubmitFlag(1);
            applianceStockDao.save(findDO);
        }

        // ????????????
        ApplianceStoreDO findStoreDO = applianceStoreDao.findByNameAndUnitPrice(saveDO.getName(), saveDO.getUnitPrice());
        if (findStoreDO == null) {
            findStoreDO = new ApplianceStoreDO();
            findStoreDO.setType(saveDO.getType());
            findStoreDO.setName(saveDO.getName());
            findStoreDO.setStandards(saveDO.getStandards());
            findStoreDO.setUnitPrice(saveDO.getUnitPrice());
            findStoreDO.setSurplusQuantity(saveDO.getQuantity());
        } else {
            findStoreDO.setSurplusQuantity( findStoreDO.getSurplusQuantity() + saveDO.getQuantity());
        }
        applianceStoreDao.save(findStoreDO);
    }

    @Override
    public Double countApplianceUnPayMoney(Integer type) {
        return applianceStockRepository.countUnPayMoney(type);
    }

    @Override
    public Result<ApplianceStoreDO> getApplianceStoreList(ApplianceQueryCnd queryCnd) {
        PageHelper.startPage(queryCnd.getPageNo(), queryCnd.getPageSize());
        List<ApplianceStoreDO> list = applianceStoreRepository.findByCondition(queryCnd);
        PageInfo<ApplianceStoreDO> page = new PageInfo<>(list);
        return ResultUtils.parseResult(page, ApplianceStoreDO.class);
    }

    @Override
    public void countStore() {
        List<ApplianceStoreDO> list = applianceStockRepository.countStore();
        if(list != null) {
            applianceStoreDao.saveAll(list);
        }
    }

    @Override
    public Result<ApplianceUseDO> getApplianceUseList(ApplianceQueryCnd queryCnd) {
        PageHelper.startPage(queryCnd.getPageNo(), queryCnd.getPageSize());
        List<ApplianceUseDO> list = applianceUseRepository.listByLimits(queryCnd);
        PageInfo<ApplianceUseDO> page = new PageInfo<>(list);
        return ResultUtils.parseResult(page, ApplianceUseDO.class);
    }

    @Override
    public List<ApplianceUseDO> getApplianceUseDetail(Integer stockId) {
        ApplianceQueryCnd queryCnd = new ApplianceQueryCnd();
        queryCnd.setStockId(stockId);
        return applianceUseRepository.listByLimits(queryCnd);
    }

    @Override
    public Result<ApplianceNameDO> getApplianceNameList(ApplianceNameQueryCnd queryCnd) {
        Sort sort = Sort.by("logout").ascending().and(Sort.by("id").ascending());
        Pageable pageable = PageRequest.of(queryCnd.getPageNo() - 1, queryCnd.getPageSize(), sort);
        Page<ApplianceNameDO> page = applianceNameDao.findAll(new Specification<ApplianceNameDO>() {
            @Override
            public Predicate toPredicate(Root<ApplianceNameDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.notEqual(root.get("id"), 0));
                predicates.add(criteriaBuilder.equal(root.get("type"), COST_DIC_TYPE_APPLIANCE));
                if (queryCnd.getLogoutList() != null && queryCnd.getLogoutList().size() > 0) {
                    predicates.add(criteriaBuilder.in(root.get("logout")).value(queryCnd.getLogoutList()));
                }
                if (queryCnd.getApplianceType()!=null && queryCnd.getApplianceType() != 0) {
                    predicates.add(criteriaBuilder.equal(root.get("applianceType"), queryCnd.getApplianceType()));
                }
                if (StringUtils.isNotBlank(queryCnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("pinyin"),"%" + queryCnd.getInputContent() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("pinyin"),"%" + queryCnd.getInputContent().toLowerCase() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("name"),"%" + queryCnd.getInputContent() + "%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        Result<ApplianceNameDO> result = ResultUtils.parseResult(page);
        return result;
    }

    /** ??????????????????????????????*/
    @Override
    public void saveApplianceName(ApplianceNameDO saveDO) {
        // ??????????????????
        saveDO.setType(2);
        // ?????????
        saveDO.setPinyin(PinyinUtil.getFirstSpell(saveDO.getName()));

        if(saveDO.getId() == null) { // ??????
            List<CostDicDO> findList = costDicManager.getCostDicList(COST_DIC_TYPE_APPLIANCE);
            Integer findId = applianceNameDao.findMaxId(COST_DIC_TYPE_APPLIANCE);
            saveDO.setId(findId + 1);
            saveDO.setLogout(0);
            CostDicDO costDicDO = iGenerator.convert(saveDO, CostDicDO.class);
            costDicDO.setSubType(saveDO.getApplianceType());
            costDicDO.setProtect(0);// ????????????
            costDicManager.save(costDicDO);
        } else { // ??????
            CostDicDO findDO = costDicManager.getCostDic(COST_DIC_TYPE_APPLIANCE, saveDO.getId());
            findDO.setName(saveDO.getName());
            findDO.setStandards(saveDO.getStandards());
            findDO.setLogout(saveDO.getLogout());
            costDicManager.save(findDO);
        }
    }

}
