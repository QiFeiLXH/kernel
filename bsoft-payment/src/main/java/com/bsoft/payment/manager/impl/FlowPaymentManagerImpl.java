package com.bsoft.payment.manager.impl;

import com.alibaba.fastjson.JSONObject;
import com.bsoft.common.dozer.IGenerator;
import com.bsoft.common.entity.primary.ImportResultDO;
import com.bsoft.common.entity.primary.PublicDicDO;
import com.bsoft.common.manager.PublicDicManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.dept.entity.primary.DeptDO;
import com.bsoft.dept.manager.DeptManager;
import com.bsoft.payment.condition.FlowPaymentQueryCnd;
import com.bsoft.payment.dao.primary.FlowPaymentDao;
import com.bsoft.payment.dao.primary.FlowPaymentViewDao;
import com.bsoft.payment.entity.primary.FlowPaymentDO;
import com.bsoft.payment.entity.primary.FlowPaymentViewDO;
import com.bsoft.payment.manager.FlowPaymentManager;
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
 * @BelongsProject: bsoft-kernel
 * @BelongsPackage: com.bsoft.payment.manager.impl
 * @Author: Qi fei
 * @CreateTime: 2020-07-25 18:26
 * @Description:
 */
@Service
public class FlowPaymentManagerImpl implements FlowPaymentManager {
    private static final String DEFAULT_ERROR_DATA_TOKEN = "ErrorDataToken";
    @Autowired
    private FlowPaymentViewDao flowPaymentViewDao;
    @Autowired
    private FlowPaymentDao flowPaymentDao;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private DeptManager deptManager;
    @Autowired
    private IGenerator iGenerator;
    @Autowired
    private PublicDicManager publicDicManager;
    @Override
    public Page<FlowPaymentViewDO> getFinancialPaymentList(FlowPaymentQueryCnd cnd) {
        Sort sort = Sort.by("accountDate").descending()
                .and(Sort.by("id").descending());
        Pageable pageable = PageRequest.of(cnd.getPageNo()-1,cnd.getPageSize(),sort);
        Page<FlowPaymentViewDO> pages = flowPaymentViewDao.findAll(new Specification<FlowPaymentViewDO>() {
            @Override
            public Predicate toPredicate(Root<FlowPaymentViewDO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("flag"), cnd.getFlag()));
                if (StringUtils.isNotBlank(cnd.getParentDeptId())) {
                    predicates.add(criteriaBuilder.equal(root.get("parentDeptId"), cnd.getParentDeptId()));
                }
                if (cnd.getType() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("type"), cnd.getType()));
                }
                if (cnd.getBusinessLine() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("businessLine"), cnd.getBusinessLine()));
                }
                if (cnd.getAuditFlag() != -1) {
                    predicates.add(criteriaBuilder.equal(root.get("auditFlag"), cnd.getAuditFlag()));
                }
                predicates.add(criteriaBuilder.between(root.get("accountDate"),cnd.getStartDate(),cnd.getEndDate()));
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        },pageable);
        return pages;
    }

    @Override
    @Transactional
    public void deleteFinancialPayments(List<Integer> ids) {
        flowPaymentDao.deleteAllByIdIn(ids);
    }

    @Override
    @Transactional
    public void auditFinancialPayments(List<FlowPaymentDO> flowPaymentDOS, String personId) {
        Date serverDate = serverDateManager.getServerDate();
        flowPaymentDOS.forEach(financialPaymentDO -> {
            financialPaymentDO.setAuditDate(serverDate);
            financialPaymentDO.setAuditFlag(1);
            financialPaymentDO.setAuditter(personId);
        });
        flowPaymentDao.saveAll(flowPaymentDOS);
    }

    @Override
    public ImportResultDO saveFinancialPayments(List<FlowPaymentViewDO> savesData, List<FlowPaymentViewDO> errorData, String personId, Integer flag) {
        List<DeptDO> validDepts = deptManager.getValidDept();
        List<PublicDicDO> businessLineDic = publicDicManager.getPublicDic(1506);
        List<PublicDicDO> typeDic = publicDicManager.getPublicDic(1507);

        //处理字典
        Map<String, String> validDeptMap = validDepts.stream().collect(Collectors.toMap(DeptDO::getDeptName, DeptDO::getDeptId));
        Map<String, Integer> businessLineMap = businessLineDic.stream().collect(Collectors.toMap(PublicDicDO::getName, PublicDicDO::getId));
        Map<String, Integer> typeMap = typeDic.stream().collect(Collectors.toMap(PublicDicDO::getName, PublicDicDO::getId));
        Map<String, Object> data = this.doJudgePaymentData(savesData, validDeptMap, businessLineMap, typeMap);
        List<FlowPaymentDO> saveData = (List<FlowPaymentDO>)data.get("saveData");
        List<FlowPaymentViewDO> allErrorDatas = (List<FlowPaymentViewDO>)data.get("errorData");
        allErrorDatas.addAll(errorData);
        flowPaymentDao.saveAll(saveData);

        String key = "";
        if (flag == 1) {
            key = "flow";
        }
        if (flag == 2) {
            key = "income";
        }
        this.cacheErrorData(personId, key, allErrorDatas);
        ImportResultDO result = new ImportResultDO();
        result.setSuccessCount(saveData.size());
        result.setFailCount(allErrorDatas.size());
        return result;
    }

    @Override
    public List<FlowPaymentViewDO> getErrorFinancialPayments(String personId, Integer flag) {
        String key = "";
        if (flag == 1) {
            key = "flow";
        }
        if (flag == 2) {
            key = "income";
        }
        String errorDataString = redisTemplate.opsForValue().get(getKey(personId, key));
        List<FlowPaymentViewDO> errorData = (List<FlowPaymentViewDO>)JSONObject.parse(errorDataString);
        return errorData;
    }

    private String getKey(String personId, String key){
        return new StringBuilder(DEFAULT_ERROR_DATA_TOKEN).append(":").append(key).append(":").append(personId).toString();
    }

    private void cacheErrorData(String personId, String key,List data){
        // 先删除redis数据
        redisTemplate.delete(getKey(personId, key));
        // 再重新缓存数据,并设置30min的过期时间
        redisTemplate.opsForValue().set(getKey(personId, key), JSONObject.toJSONString(data), 30, TimeUnit.MINUTES);
    }

    private Map<String, Object> doJudgePaymentData(List<FlowPaymentViewDO> paymentViewDOS, Map<String, String> validDeptMap, Map<String, Integer> businessLineMap, Map<String, Integer> typeMap) {
        List<FlowPaymentViewDO> needSaveData = new ArrayList<>();
        List<FlowPaymentViewDO> errorData = new ArrayList<>();
        paymentViewDOS.forEach(paymentViewDO -> {
            if (!checkPayment(paymentViewDO, validDeptMap, businessLineMap, typeMap)) {
                errorData.add(paymentViewDO);
            } else {
                // 所属部门赋值
                paymentViewDO.setDeptId(validDeptMap.get(paymentViewDO.getDeptName()));
                // 业务条线赋值
                paymentViewDO.setBusinessLine(businessLineMap.get(paymentViewDO.getBusinessLineText()));
                // 类别赋值
                paymentViewDO.setType(typeMap.get(paymentViewDO.getTypeText()));
                needSaveData.add(paymentViewDO);
            }
        });

        //转换需要保存的bean
        List<FlowPaymentDO> trainShareDOS = iGenerator.convert(needSaveData, FlowPaymentDO.class);
        Map<String, Object> data = new HashMap<>();
        data.put("saveData", trainShareDOS);
        data.put("errorData", errorData);
        return data;
    }

    private Boolean checkPayment(FlowPaymentViewDO paymentViewDO, Map<String, String> validDeptMap, Map<String, Integer> businessLineMap, Map<String, Integer> typeMap) {
        // 校验所属部门有效性
        if (!validDeptMap.containsKey(paymentViewDO.getDeptName())) {
            return false;
        }
        // 校验业务条线有效性
        if (!businessLineMap.containsKey(paymentViewDO.getBusinessLineText())) {
            return false;
        }
        // 校验类别有效性
        if (!typeMap.containsKey(paymentViewDO.getTypeText())) {
            return false;
        }
        // 校验机构名称长度有效性,且机构名称不能为空
        if (StringUtils.isBlank(paymentViewDO.getOrgName()) || (StringUtils.isNotBlank(paymentViewDO.getOrgName()) && paymentViewDO.getOrgName().length() > 160)) {
            return false;
        }
        // 校验备注信息长度有效性
        if (StringUtils.isNotBlank(paymentViewDO.getRemark()) && paymentViewDO.getRemark().length() > 160) {
            return false;
        }
        return true;
    }

}
