package com.bsoft.sales.report.manager;

import com.bsoft.sales.report.entity.primary.DynamicContractDO;
import com.bsoft.sales.report.entity.primary.DynamicContractViewDO;

import java.util.List;

public interface DynamicContractManager {
    public DynamicContractDO saveContract(DynamicContractDO dynamicContract);
    public List<DynamicContractDO> getContract(Integer dynamicId);
    public List<DynamicContractViewDO> getContractView(Integer dynamicId);
    public List<DynamicContractDO> saveContract(List<DynamicContractDO> contracts);
}
