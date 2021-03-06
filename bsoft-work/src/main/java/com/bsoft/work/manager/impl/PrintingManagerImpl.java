package com.bsoft.work.manager.impl;

import com.alibaba.fastjson.JSONObject;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.entity.primary.ImportResultDO;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.exception.ServiceException;
import com.bsoft.work.condition.PrintingQueryCnd;
import com.bsoft.work.dao.primary.PrintingDao;
import com.bsoft.work.dao.primary.PrintingDetailDao;
import com.bsoft.work.dao.primary.PrintingViewDao;
import com.bsoft.work.entity.primary.*;
import com.bsoft.work.manager.PrintingManager;
import com.bsoft.work.repository.primary.PrintingRepository;
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
 * @Date 2021/1/27 15:07
 * @Description
 */
@Service
public class PrintingManagerImpl implements PrintingManager {
    private static final String DEFAULT_ERROR_DATA_TOKEN = "ErrorDataToken";
    @Autowired
    private PrintingDao printingDao;
    @Autowired
    private PrintingViewDao printingViewDao;
    @Autowired
    private PrintingRepository printingRepository;
    @Autowired
    private PrintingDetailDao printingDetailDao;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private IGenerator iGenerator;

    @Override
    public Page<PrintingViewDO> getPrintingList(PrintingQueryCnd cnd) {
        Sort sort = Sort.by("printDate").descending().and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(cnd.getPageNo() - 1, cnd.getPageSize(), sort);
        Page<PrintingViewDO> pages = printingViewDao.findAll(new Specification<PrintingViewDO>() {
            @Override
            public Predicate toPredicate(Root<PrintingViewDO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.between(root.get("printDate"),cnd.getStartDate(),cnd.getEndDate()));

                if (StringUtils.isNotBlank(cnd.getInputContent())) {
                    Predicate c1 = criteriaBuilder.like(root.get("applicant"),"%" + cnd.getInputContent() + "%");
                    Predicate c2 = criteriaBuilder.like(root.get("applicantName"),"%" + cnd.getInputContent() + "%");
                    Predicate c3 = criteriaBuilder.like(root.get("simpleCode"),"%" + cnd.getInputContent().toLowerCase() + "%");
                    Predicate c4 = criteriaBuilder.like(root.get("lshid"),"%" + cnd.getInputContent().toLowerCase() + "%");
                    Predicate c5 = criteriaBuilder.like(root.get("lshid"),"%" + cnd.getInputContent().toUpperCase() + "%");
                    Predicate c6 = criteriaBuilder.like(root.get("orderNum"),"%" + cnd.getInputContent().toLowerCase() + "%");
                    Predicate c7 = criteriaBuilder.like(root.get("orderNum"),"%" + cnd.getInputContent().toUpperCase() + "%");
                    predicates.add(criteriaBuilder.or(c1,c2,c3,c4,c5,c6,c7));
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
    public Integer getPrintingUnpaidCount(PrintingQueryCnd cnd) {
        return printingRepository.getPrintingUnpaidCount(cnd);
    }

    @Override
    public Double getPrintingUnpaidAmount() {
        return printingViewDao.getPrintingUnpaidAmount();
    }

    @Override
    public Double getPrintingTotalAmount(List<Integer> printingIds) {
        if (printingIds == null || printingIds.isEmpty()) {
            return 0.0;
        } else {
            return printingViewDao.getPrintingTotalAmount(printingIds);
        }
    }

    @Override
    public List<Integer> getPrintingIdList(PrintingQueryCnd cnd) {
        return printingRepository.getPrintingIdList(cnd);
    }

    @Override
    @Transactional
    public ImportResultDO savePrintings(List<PrintingViewDO> needSaveDatas, List<PrintingViewDO> errorDatas, String personId) {
        Map<String, Object> dataMap = this.doValidatePrinting(needSaveDatas, errorDatas);
        List<PrintingDO> successData = (List<PrintingDO>) dataMap.get("success");
        List<PrintingViewDO> errorData = (List<PrintingViewDO>) dataMap.get("error");
        if (!successData.isEmpty()) {
            printingDao.saveAll(successData);
            printingDao.flush();
            // ?????????????????????
            List<String> lshIds = successData.stream().map(PrintingDO::getLshid).collect(Collectors.toList());
            printingRepository.syncUpdateCostAmount(lshIds);
        }

        if (!errorData.isEmpty()) {
            this.cacheErrorData(personId, "printing", errorData);
        }
        ImportResultDO result = new ImportResultDO();
        result.setSuccessCount(successData.size());
        result.setFailCount(errorData.size());
        return result;
    }

    @Override
    public List<PrintingViewDO> getErrorPrintingList(String personId) {
        String errorDataString = redisTemplate.opsForValue().get(getKey(personId, "printing"));
        List<PrintingViewDO> errorData = (List<PrintingViewDO>) JSONObject.parse(errorDataString);
        return errorData;
    }

    @Override
    @Transactional
    public List<PrintingViewDO> updatePrintingApplyPay(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new ServiceException("??????????????????????????????");
        }
        Date serverDate = serverDateManager.getServerDate();
        printingDao.updateStatusAndApplyPayDateByIdIn(ids,serverDate);
        printingDao.flush();
        return printingViewDao.findAllByIdIn(ids);
    }

    @Override
    @Transactional
    public void updatePrintingPay(List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new ServiceException("??????????????????????????????");
        }
        printingDao.updateStatusByIdIn(ids);
    }

    @Override
    public List<PrintingDetailDO> getPrintingDetailList(Integer printingId) {
        return printingDetailDao.findAllByPrintingId(printingId);
    }

    @Override
    @Transactional
    public void savePrinting(PrintingDO printingDO) {
        // ???????????????????????????
        if (printingDO.getId() == null) {
            throw new ServiceException("??????????????????????????????");
        }
        if (printingDO.getStatus() != 0) {
            throw new ServiceException("????????????????????????????????????????????????");
        }
        printingDao.updateApprovalById(printingDO.getId(), printingDO.getApproval());
        printingDao.flush();
        // ?????????????????????
        printingRepository.updateCostAmountByLshid(printingDO.getLshid());
    }

    private void cacheErrorData(String personId, String key,List data){
        String redisKey = this.getKey(personId, key);
        // ?????????redis??????
        redisTemplate.delete(redisKey);
        // ?????????????????????,?????????30min???????????????
        redisTemplate.opsForValue().set(redisKey, JSONObject.toJSONString(data), 30, TimeUnit.MINUTES);
    }

    private String getKey(String personId, String key){
        return new StringBuilder(DEFAULT_ERROR_DATA_TOKEN).append(":").append(key).append(":").append(personId).toString();
    }

    private Map<String, Object> doValidatePrinting(List<PrintingViewDO> needSaveDatas, List<PrintingViewDO> errorDatas) {
        // ??????????????????????????????
        List<String> orderNums = needSaveDatas.stream().map(PrintingViewDO::getOrderNum).filter(orderNum -> StringUtils.isNotBlank(orderNum)).collect(Collectors.toList());
        Map<String, Object> map = new HashMap();
        // ?????????????????????
        List<PrintingViewDO> newNeedSaveDatas = new ArrayList<>();
        // ????????????????????????
        if (!orderNums.isEmpty()) {
            List<PrintingViewDO> printings = printingViewDao.findAllByOrderNumIn(orderNums);
            Map<String, List<PrintingViewDO>> printingMap = printings.stream().collect(Collectors.groupingBy(PrintingViewDO::getOrderNum));
            needSaveDatas.forEach(printingViewDO -> {
                PrintingViewDO printing = this.checkPrinting(printingViewDO, printingMap);
                if(printing.getId() != null) {
                    newNeedSaveDatas.add(printing);
                } else {
                    errorDatas.add(printing);
                }
            });
        }
        List<PrintingDO> printingDOS = iGenerator.convert(newNeedSaveDatas, PrintingDO.class);
        map.put("success", printingDOS);
        map.put("error", errorDatas);
        return map;
    }

    private PrintingViewDO checkPrinting(PrintingViewDO printingViewDO, Map<String, List<PrintingViewDO>> printingMap) {
        // ??????????????????
        if (StringUtils.isBlank(printingViewDO.getOrderNum())) {
            printingViewDO.setFailureReason("?????????????????????");
            return printingViewDO;
        }
        // ???????????????????????????????????????????????????
        if (!printingMap.containsKey(printingViewDO.getOrderNum())) {
            printingViewDO.setFailureReason("?????????????????????????????????");
            return printingViewDO;
        } else {
            // ????????????????????????
            List<PrintingViewDO> printingData = printingMap.get(printingViewDO.getOrderNum());
            List<PrintingViewDO> list = printingData.stream().filter(printing -> printing.getApproval() != null && printing.getApproval() > 0).collect(Collectors.toList());
            if (!list.isEmpty()) {
                printingViewDO.setFailureReason("?????????????????????????????????");
                return printingViewDO;
            } else {
                PrintingViewDO printing = printingData.get(0);
                PrintingViewDO printingViewData = iGenerator.convert(printing, PrintingViewDO.class);

                printingViewData.setApproval(printingViewDO.getApproval());
                return printingViewData;
            }
        }
    }
}
