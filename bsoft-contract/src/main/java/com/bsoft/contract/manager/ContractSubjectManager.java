package com.bsoft.contract.manager;

import com.bsoft.contract.entity.primary.ContractSubjectDO;

import java.util.Map;

public interface ContractSubjectManager {
    public Map<String,String> getDic();

    public ContractSubjectDO getValue(Integer key);
}
