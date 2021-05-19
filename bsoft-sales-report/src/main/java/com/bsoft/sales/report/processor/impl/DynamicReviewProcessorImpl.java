package com.bsoft.sales.report.processor.impl;

import com.bsoft.auth.validator.SalesDynamicValidator;
import com.bsoft.contract.entity.primary.ContractReviewViewDO;
import com.bsoft.contract.manager.ContractReviewManager;
import com.bsoft.sales.report.entity.primary.DynamicReviewDO;
import com.bsoft.sales.report.entity.primary.SalesDynamicDO;
import com.bsoft.sales.report.manager.DynamicReviewManager;
import com.bsoft.sales.report.processor.DynamicProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@Scope("prototype")
public class DynamicReviewProcessorImpl implements DynamicProcessor {
    @Autowired
    private DynamicReviewManager dynamicReviewManager;
    @Autowired
    private SalesDynamicValidator salesDynamicValidator;
    @Autowired
    private ContractReviewManager contractReviewManager;

    private List<DynamicReviewDO> reviews;

    private DynamicReviewProcessorImpl(){
        reviews = new ArrayList<>();
    }

    @Override
    public void process(Map<String, SalesDynamicDO> dynamic) {
        List<ContractReviewViewDO> contractReviews = contractReviewManager.getTodayContractReview();
        for(ContractReviewViewDO contractReviewView : contractReviews){
            Set<String> users = salesDynamicValidator.getHavePermissionUsers(contractReviewView.getArea(),"");
            for(String user : users){
                SalesDynamicDO salesDynamic = dynamic.get(user);
                if(isValid(salesDynamic)){
                    salesDynamic.setContractReview(salesDynamic.getContractReview()+1);
                    addDynamicReview(contractReviewView,salesDynamic);
                }
            }
        }
    }

    @Override
    public void save() {
        dynamicReviewManager.saveReview(reviews);
    }

    private Boolean isValid(Object object){
        return object != null;
    }

    private void addDynamicReview(ContractReviewViewDO contractReviewView,SalesDynamicDO salesDynamic) {
        DynamicReviewDO dynamicReview= new DynamicReviewDO();
        dynamicReview.setAmount(contractReviewView.getAmount());
        dynamicReview.setArea(contractReviewView.getArea());
        dynamicReview.setContractType(contractReviewView.getContractType());
        dynamicReview.setCustomerId(contractReviewView.getCustomerId());
        dynamicReview.setReviewId(contractReviewView.getId());
        dynamicReview.setSubject(contractReviewView.getSubject());
        dynamicReview.setOriginalStatus(contractReviewView.getOriginalStatus());
        dynamicReview.setDynamicId(salesDynamic.getId());
        reviews.add(dynamicReview);
    }
}
