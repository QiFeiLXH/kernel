package com.bsoft.sales.report.processor.impl;

import com.bsoft.auth.validator.SalesDynamicValidator;
import com.bsoft.clue.entity.primary.ClueViewDO;
import com.bsoft.clue.manager.ClueManager;
import com.bsoft.sales.report.entity.primary.DynamicClueDO;
import com.bsoft.sales.report.entity.primary.SalesDynamicDO;
import com.bsoft.sales.report.manager.DynamicClueManager;
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
public class DynamicClueProcessorImpl implements DynamicProcessor {
    @Autowired
    private DynamicClueManager dynamicClueManager;
    @Autowired
    private SalesDynamicValidator salesDynamicValidator;
    @Autowired
    private ClueManager clueManager;

    private List<DynamicClueDO> clues;

    private DynamicClueProcessorImpl(){
        clues = new ArrayList<>();
    }

    @Override
    public void process(Map<String, SalesDynamicDO> dynamic) {
        List<ClueViewDO> clues = clueManager.getTodayClue();
        for(ClueViewDO clue : clues){
            Set<String> users = salesDynamicValidator.getHavePermissionUsers(clue.getArea(),clue.getGroup());
            for(String user : users){
                SalesDynamicDO salesDynamic = dynamic.get(user);
                if(isValid(salesDynamic)){
                    salesDynamic.setSalesClue(salesDynamic.getSalesClue()+1);
                    addDynamicClue(clue,salesDynamic);
                }
            }
        }
    }

    @Override
    public void save() {
        dynamicClueManager.save(clues);
    }

    private Boolean isValid(Object object){
        return object != null;
    }

    private void addDynamicClue(ClueViewDO clue, SalesDynamicDO salesDynamic){
        DynamicClueDO dynamicClue = new DynamicClueDO();
        dynamicClue.setClueId(clue.getClueId());
        dynamicClue.setAmount(clue.getSoftware());
        dynamicClue.setArea(clue.getArea());
        dynamicClue.setCustomerId(clue.getCustomerId());
        dynamicClue.setStage(clue.getStage());
        dynamicClue.setSignDate(clue.getSignDate());
        dynamicClue.setContent(clue.getProductContent());
        dynamicClue.setDynamicId(salesDynamic.getId());
        clues.add(dynamicClue);
    }
}
