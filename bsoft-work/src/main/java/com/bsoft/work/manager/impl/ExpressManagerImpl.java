package com.bsoft.work.manager.impl;

import com.alibaba.fastjson.JSONObject;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.entity.primary.ImportResultDO;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.exception.ServiceException;
import com.bsoft.work.condition.ExpressQueryCnd;
import com.bsoft.work.dao.primary.ExpressDetailDao;
import com.bsoft.work.dao.primary.ExpressDetailViewDao;
import com.bsoft.work.entity.primary.ExpressDetailDO;
import com.bsoft.work.entity.primary.ExpressDetailViewDO;
import com.bsoft.work.manager.ExpressManager;
import com.bsoft.work.repository.primary.ExpressRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Author Xuhui Lin
 * @Date 2020/12/30 15:09
 * @Description
 */
@Service
public class ExpressManagerImpl implements ExpressManager {
    private static final String DEFAULT_ERROR_DATA_TOKEN = "ErrorDataToken";

    @Autowired
    private ExpressDetailViewDao expressDetailViewDao;
    @Autowired
    private ExpressRepository expressRepository;
    @Autowired
    private ExpressDetailDao expressDetailDao;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Page<ExpressDetailViewDO> getExpressList(ExpressQueryCnd cnd) {
        Sort sort = Sort.by("shipmentDate").descending().and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1, cnd.getPageSize(), sort);
        Page<ExpressDetailViewDO> pages = expressDetailViewDao.findAll(new Specification<ExpressDetailViewDO>() {
            @Override
            public Predicate toPredicate(Root<ExpressDetailViewDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.between(root.get("shipmentDate"),cnd.getStartDate(),cnd.getEndDate()));

                if (StringUtils.isNotBlank(cnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("applicant"),"%" + cnd.getInputContent() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("applicantName"),"%" + cnd.getInputContent() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("simpleCode"),"%" + cnd.getInputContent().toLowerCase() + "%");
                    Predicate c4 = criteriaBuilder.like(root.get("expressNo"),"%" + cnd.getInputContent().toLowerCase() + "%");
                    Predicate c5 = criteriaBuilder.like(root.get("expressNo"),"%" + cnd.getInputContent().toUpperCase() + "%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3,c4,c5));
                }

                if (StringUtils.isNotBlank(cnd.getDeptId())) {
                    predicates.add(criteriaBuilder.equal(root.get("deptId"),cnd.getDeptId()));
                }
                if (cnd.getStatus() != -1) {
                    predicates.add(criteriaBuilder.equal(root.get("status"),cnd.getStatus()));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        return pages;
    }

    @Override
    public Integer getExpressUnpaidCount(ExpressQueryCnd cnd) {
        return expressRepository.getExpressUnpaidCount(cnd);
    }

    @Override
    public Double getExpressUnpaidAmount() {
        return expressDetailViewDao.getExpressUnpaidAmount();
    }

    @Override
    public Double getExpressTotalAmount(List<Integer> expressIds) {
        if (expressIds == null || expressIds.isEmpty()) {
            return 0.0;
        } else {
            return expressDetailViewDao.getExpressTotalAmount(expressIds);
        }
    }

    @Override
    public List<Integer> getExpressIdList(ExpressQueryCnd cnd) {
        return expressRepository.getExpressIdList(cnd);
    }

    @Override
    @Transactional
    public ImportResultDO saveExpressDetails(List<ExpressDetailViewDO> needSaveDatas, List<ExpressDetailViewDO> errorDatas, String personId) {
        Map<String, Object> dataMap = this.doValidateExpressDetails(needSaveDatas, errorDatas);
        List<ExpressDetailDO> successData = (List<ExpressDetailDO>) dataMap.get("success");
        List<ExpressDetailViewDO> errorData = (List<ExpressDetailViewDO>) dataMap.get("error");
        if (!successData.isEmpty()) {
            expressDetailDao.saveAll(successData);
            expressDetailDao.flush();
            // ?????????????????????
            List<String> lshIds = successData.stream().map(ExpressDetailDO::getLshid).collect(Collectors.toList());

            expressRepository.syncUpdateCostAmount(lshIds);
        }

        if (!errorData.isEmpty()) {
            this.cacheErrorData(personId, "expressDetail", errorData);
        }
        ImportResultDO result = new ImportResultDO();
        result.setSuccessCount(successData.size());
        result.setFailCount(errorData.size());
        return result;
    }


    @Override
    public List<ExpressDetailViewDO> getErrorExpressList(String personId) {
        String errorDataString = redisTemplate.opsForValue().get(getKey(personId, "expressDetail"));
        List<ExpressDetailViewDO> errorData = (List<ExpressDetailViewDO>)JSONObject.parse(errorDataString);
        return errorData;
    }

    @Override
    @Transactional
    public List<ExpressDetailViewDO> updateExpressApplyPay(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new ServiceException("??????????????????????????????");
        }
        Date serverDate = serverDateManager.getServerDate();
        expressDetailDao.updateStatusAndApplyPayDateByIdIn(ids,serverDate);
        expressDetailDao.flush();
        return expressDetailViewDao.findAllByIdIn(ids);
    }

    @Override
    @Transactional
    public void updateExpressPay(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new ServiceException("??????????????????????????????");
        }
        expressDetailDao.updateStatusByIdIn(ids);
    }

    @Override
    public List<ExpressDetailViewDO> getExpressList(List<Integer> ids) {
        return expressDetailViewDao.findAllByIdIn(ids);
    }

    @Override
    @Transactional
    public void saveExpressDetail(ExpressDetailDO detailDO) {
        // ???????????????????????????
        if (detailDO.getId() == null) {
            throw new ServiceException("??????????????????????????????");
        }
        if (detailDO.getStatus() != 0) {
            throw new ServiceException("??????????????????????????????????????????????????????");
        }
        expressDetailDao.updateApprovalById(detailDO.getId(), detailDO.getApproval());
        expressDetailDao.flush();
        // ?????????????????????
        expressRepository.updateCostAmountByLshid(detailDO.getLshid());
    }

    private String getKey(String personId, String key){
        return new StringBuilder(DEFAULT_ERROR_DATA_TOKEN).append(":").append(key).append(":").append(personId).toString();
    }

    private void cacheErrorData(String personId, String key,List data){
        String redisKey = this.getKey(personId, key);
        // ?????????redis??????
        redisTemplate.delete(redisKey);
        // ?????????????????????,?????????30min???????????????
        redisTemplate.opsForValue().set(redisKey, JSONObject.toJSONString(data), 30, TimeUnit.MINUTES);
    }


    private Map<String, Object> doValidateExpressDetails(List<ExpressDetailViewDO> needSaveDatas, List<ExpressDetailViewDO> errorDatas) {
        // ??????????????????????????????
        List<String> expressNos = needSaveDatas.stream().map(ExpressDetailViewDO::getExpressNo).filter(expressNo -> StringUtils.isNotBlank(expressNo)).collect(Collectors.toList());
        Map<String, Object> map = new HashMap();
        // ?????????????????????
        List<ExpressDetailViewDO> newNeedSaveDatas = new ArrayList<>();
        // ????????????????????????
        if (!expressNos.isEmpty()) {
            List<ExpressDetailViewDO> expressDetails = expressDetailViewDao.findAllByExpressNoIn(expressNos);
            Map<String, List<ExpressDetailViewDO>> expressDetailMap = expressDetails.stream().collect(Collectors.groupingBy(ExpressDetailViewDO::getExpressNo));
            needSaveDatas.forEach(expressDetailViewDO -> {
                ExpressDetailViewDO expressDetail = this.checkExpressDetail(expressDetailViewDO, expressDetailMap);
                if(expressDetail.getId() != null) {
                    newNeedSaveDatas.add(expressDetail);
                } else {
                    errorDatas.add(expressDetail);
                }
            });
        }
        List<ExpressDetailDO> expressDetailDOS = iGenerator.convert(newNeedSaveDatas, ExpressDetailDO.class);
        map.put("success", expressDetailDOS);
        map.put("error", errorDatas);
        return map;
    }

    private ExpressDetailViewDO checkExpressDetail(ExpressDetailViewDO expressDetailViewDO, Map<String, List<ExpressDetailViewDO>> expressDetailMap) {
        // ???????????????
        if (StringUtils.isBlank(expressDetailViewDO.getExpressNo())) {
            expressDetailViewDO.setFailureReason("??????????????????");
            return expressDetailViewDO;
        }
        // ???????????????????????????????????????????????????
        if (!expressDetailMap.containsKey(expressDetailViewDO.getExpressNo())) {
            expressDetailViewDO.setFailureReason("?????????????????????????????????");
            return expressDetailViewDO;
        } else {
            // ????????????????????????
            List<ExpressDetailViewDO> expressData = expressDetailMap.get(expressDetailViewDO.getExpressNo());
            List<ExpressDetailViewDO> list = expressData.stream().filter(express -> express.getApproval() != null && express.getApproval() > 0).collect(Collectors.toList());
            if (!list.isEmpty()) {
                expressDetailViewDO.setFailureReason("???????????????????????????");
                return expressDetailViewDO;
            } else {
                ExpressDetailViewDO expressDetail = expressData.get(0);
                ExpressDetailViewDO detail = iGenerator.convert(expressDetail, ExpressDetailViewDO.class);
                detail.setApproval(expressDetailViewDO.getApproval());
                return detail;
            }
        }
    }

}
