package com.bsoft.sales.report.processor.impl;

import com.bsoft.auth.validator.SalesDynamicValidator;
import com.bsoft.contract.entity.primary.ContractDO;
import com.bsoft.contract.entity.primary.ContractViewDO;
import com.bsoft.contract.manager.ContractManager;
import com.bsoft.sales.report.entity.primary.DynamicContractDO;
import com.bsoft.sales.report.entity.primary.SalesDynamicDO;
import com.bsoft.sales.report.manager.DynamicContractManager;
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
public class DynamicContractProcessorImpl implements DynamicProcessor {

    @Autowired
    private DynamicContractManager dynamicContractManager;
    @Autowired
    private SalesDynamicValidator salesDynamicValidator;
    @Autowired
    private ContractManager contractManager;

    private List<DynamicContractDO> contracts;

    public DynamicContractProcessorImpl(){
        contracts = new ArrayList<>();
    }

    @Override
    public void process(Map<String, SalesDynamicDO> dynamic) {
        List<ContractViewDO> results = contractManager.getTodayContract();
        for(ContractViewDO contract : results){
            Set<String> users = salesDynamicValidator.getHavePermissionUsers(contract.getArea(),contract.getGroup());
            for(String user : users){
                SalesDynamicDO salesDynamic = dynamic.get(user);
                if(isValid(salesDynamic)){
                    salesDynamic.setContract(salesDynamic.getContract() + 1);
                    salesDynamic.setContractAmount(salesDynamic.getContractAmount() + contract.getAmount());
                    addDynamicContract(contract,salesDynamic);
                }
            }
        }
    }

    @Override
    public void save() {
        dynamicContractManager.saveContract(contracts);
    }

    private Boolean isValid(Object object){
        return object != null;
    }

    private void addDynamicContract(ContractViewDO contract,SalesDynamicDO salesDynamic){
        DynamicContractDO dynamicContract = new DynamicContractDO();
        dynamicContract.setContractId(contract.getId());
        dynamicContract.setContractName(contract.getName());
        dynamicContract.setContractno(contract.getNumber());
        dynamicContract.setSignDate(contract.getSignDate());
        dynamicContract.setAmount(contract.getAmount());
        dynamicContract.setContractType(contract.getContractType());
        dynamicContract.setCustomerId(contract.getCustomer());
        dynamicContract.setDynamicId(salesDynamic.getId());
        dynamicContract.setArea(contract.getArea());
        contracts.add(dynamicContract);
    }
}
