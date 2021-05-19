package com.bsoft.cost.manager.impl;

import com.bsoft.cost.condition.FinanceCostQueryCnd;
import com.bsoft.cost.entity.primary.FinanceCostViewDO;
import com.bsoft.cost.manager.FinanceCostManager;
import com.bsoft.cost.repository.primary.FinanceCostRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zhanglf
 * @Date 2020-05-26 9:12
 * @Version 1.0
 * @Description
 */
@Component
public class FinanceCostManagerImpl implements FinanceCostManager {
    @Autowired
    private FinanceCostRepository financeCostRepository;
    @Override
    public PageInfo<FinanceCostViewDO> getFinanceCostList(FinanceCostQueryCnd queryCnd) {
        PageHelper.startPage(queryCnd.getPageNo(),queryCnd.getPageSize());
        Map<String, Object> data = new HashMap<>();
        data = initQueryData(queryCnd,data);
        List<FinanceCostViewDO> result = financeCostRepository.getFinanceCostViewList(data);
        PageInfo<FinanceCostViewDO> pageInfo = new PageInfo<>(result);
        return pageInfo;
    }

    @Override
    public List<FinanceCostViewDO> getFinanceCostDownload(FinanceCostQueryCnd queryCnd) {
        Map<String, Object> data = new HashMap<>();
        data = initQueryData(queryCnd,data);
        List<FinanceCostViewDO> result = financeCostRepository.getFinanceCostViewList(data);
        return result;
    }

    public Map<String, Object> initQueryData(FinanceCostQueryCnd queryCnd,Map<String, Object> data){
//        if(queryCnd.getSignDateStart() != null){
            data.put("signDateStart",queryCnd.getSignDateStart());
//        }
//        if(queryCnd.getSignDateEnd() != null){
            data.put("signDateEnd",queryCnd.getSignDateEnd());
//        }
//        if(queryCnd.getCostDateStart() != null){
            data.put("costDateStart",queryCnd.getCostDateStart());
//        }
//        if(queryCnd.getCostDateEnd() != null){
            data.put("costDateEnd",queryCnd.getCostDateEnd());
//        }
//        if(queryCnd.getFinishFlag() != null){
            data.put("finishFlag",queryCnd.getFinishFlag());
//        }
//        if(queryCnd.getFlag() != null){
            data.put("flag",queryCnd.getFlag());
//        }
//        if(queryCnd.getPaymentFlag() != null){
            data.put("paymentFlag",queryCnd.getPaymentFlag());
//        }
        if(StringUtils.isNotBlank(queryCnd.getProjectName())){
            data.put("projectName","%"+queryCnd.getProjectName()+"%");
        }else{
            data.put("projectName",queryCnd.getProjectName());
        }
        data.put("signYear",queryCnd.getSignYear());
        return data;
    }
}
