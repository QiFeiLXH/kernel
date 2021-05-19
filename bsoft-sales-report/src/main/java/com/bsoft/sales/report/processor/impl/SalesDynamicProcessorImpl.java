package com.bsoft.sales.report.processor.impl;

import com.bsoft.auth.entity.primary.SalesPersonPermissionDO;
import com.bsoft.auth.manager.SalesPermissionManager;
import com.bsoft.common.manager.ServerDateManager;
import com.bsoft.common.spring.SpringContextUtil;
import com.bsoft.sales.report.entity.primary.SalesDynamicDO;
import com.bsoft.sales.report.manager.SalesDynamicManager;
import com.bsoft.sales.report.processor.DynamicProcessor;
import com.bsoft.sales.report.processor.SalesDynamicProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.*;

@Component
@Scope("prototype")
public class SalesDynamicProcessorImpl implements SalesDynamicProcessor {
    private static final Logger logger = LoggerFactory.getLogger(SalesDynamicProcessorImpl.class);
    private List<DynamicProcessor> dynamicProcessors;
    @Autowired
    private SalesPermissionManager salesPermissionManager;
    @Autowired
    private ServerDateManager serverDateManager;
    @Autowired
    private SalesDynamicManager salesDynamicManager;

    private Map<String,SalesDynamicDO> dynamic;

    public SalesDynamicProcessorImpl(){
        logger.info("准备开始统计和处理销售动态数据");
        dynamicProcessors = new ArrayList<>(SpringContextUtil.getBeansForType(DynamicProcessor.class).values());
    }

    @Override
    public void process() {
        dynamic = initAndSaveDynamic();
        for(DynamicProcessor dynamicProcessor : dynamicProcessors){
            dynamicProcessor.process(dynamic);
        }
    }

    @Override
    @Transactional
    public void doSave() {
        salesDynamicManager.saveSalesDynamic(dynamic);
        for(DynamicProcessor dynamicProcessor : dynamicProcessors){
            dynamicProcessor.save();
        }
    }

    private Map<String, SalesDynamicDO> initAndSaveDynamic(){
        Map<String,SalesPersonPermissionDO> userPermissions = getUserPermission();
        List<SalesDynamicDO> salesDynamics = new ArrayList<>();
        for(String user : userPermissions.keySet()){
            SalesDynamicDO salesDynamic = createSalesDynamic(user);
            salesDynamics.add(salesDynamic);
        }
        salesDynamics = salesDynamicManager.saveSalesDynamic(salesDynamics);
        return convertToMap(salesDynamics);

    }

    private Map<String,SalesPersonPermissionDO> getUserPermission(){
        return salesPermissionManager.getSalesDynamicPermission();
    }

    private SalesDynamicDO createSalesDynamic(String personId){
        Date now = serverDateManager.getServerDateTime();
        SalesDynamicDO salesDynamic = new SalesDynamicDO();
        salesDynamic.setContract(0);
        salesDynamic.setContractAmount(0D);
        salesDynamic.setContractReview(0);
        salesDynamic.setSalesClue(0);
        salesDynamic.setTender(0);
        salesDynamic.setSendDate(now);
        salesDynamic.setPersonId(personId);
        return salesDynamic;
    }

    private Map<String,SalesDynamicDO> convertToMap(List<SalesDynamicDO> salesDynamics){
        Map<String,SalesDynamicDO> dynamic = new HashMap<>();
        for(SalesDynamicDO salesDynamic : salesDynamics){
            dynamic.put(salesDynamic.getPersonId(),salesDynamic);
        }
        return dynamic;
    }

}
