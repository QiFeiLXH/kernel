package com.bsoft.sales.report.processor.impl;

import com.bsoft.auth.validator.SalesDynamicValidator;
import com.bsoft.sales.report.entity.primary.DynamicTenderDO;
import com.bsoft.sales.report.entity.primary.SalesDynamicDO;
import com.bsoft.sales.report.manager.DynamicTenderManager;
import com.bsoft.sales.report.processor.DynamicProcessor;
import com.bsoft.tender.entity.primary.TenderDO;
import com.bsoft.tender.entity.primary.TenderViewDO;
import com.bsoft.tender.manager.TenderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@Scope("prototype")
public class DynamicTenderProcessorImpl implements DynamicProcessor {
    @Autowired
    private DynamicTenderManager dynamicTenderManager;
    @Autowired
    private SalesDynamicValidator salesDynamicValidator;
    @Autowired
    private TenderManager tenderManager;
    private List<DynamicTenderDO> tenders;

    public DynamicTenderProcessorImpl(){
        tenders = new ArrayList<>();
    }

    @Override
    public void process(Map<String, SalesDynamicDO> dynamic) {
        List<TenderViewDO> tenders = tenderManager.getTodayTender();
        for(TenderViewDO tender : tenders){
            Set<String> users = salesDynamicValidator.getHavePermissionUsers(tender.getArea(),tender.getGroup());
            for(String user : users){
                SalesDynamicDO salesDynamic = dynamic.get(user);
                if(isValid(salesDynamic)){
                    salesDynamic.setTender(salesDynamic.getTender()+1);
                    addDynamicTender(tender,salesDynamic);
                }
            }
        }
    }

    @Override
    public void save() {
        dynamicTenderManager.saveTender(tenders);
    }

    private Boolean isValid(Object object){
        return object != null;
    }

    private void addDynamicTender(TenderViewDO tender,SalesDynamicDO salesDynamic){
        DynamicTenderDO dynamicTender = new DynamicTenderDO();
        dynamicTender.setArea(tender.getArea());
        dynamicTender.setCustomerId(tender.getCustomerId());
        dynamicTender.setProjectName(tender.getProjectName());
        dynamicTender.setTenderAgency(tender.getTenderAgency());
        dynamicTender.setTenderAmount(tender.getTenderAmount());
        dynamicTender.setTenderId(tender.getId());
        dynamicTender.setTenderNumber(tender.getTenderNumber());
        dynamicTender.setDynamicId(salesDynamic.getId());
        tenders.add(dynamicTender);
    }
}
