package com.bsoft.contract.manager.impl;

import com.bsoft.contract.dao.primary.ContractSubjectDao;
import com.bsoft.contract.entity.primary.ContractSubjectDO;
import com.bsoft.contract.manager.ContractSubjectManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ContractSubjectManagerImpl implements ContractSubjectManager {
    @Autowired
    private ContractSubjectDao contractSubjectDao;
    @Override
    public Map<String, String> getDic() {
        List<ContractSubjectDO> dicList = contractSubjectDao.findAll();
        return dicList.stream().collect(Collectors.toMap((contract)->String.valueOf(contract.getId()),ContractSubjectDO::getName,(key1,key2)->key1));
    }

    @Override
    @Cacheable(cacheNames = "ContractSubject",key = "#key")
    public ContractSubjectDO getValue(Integer key) {
        return contractSubjectDao.findById(key).get();
    }
}
