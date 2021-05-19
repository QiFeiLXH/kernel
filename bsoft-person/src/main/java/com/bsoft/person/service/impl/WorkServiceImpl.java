package com.bsoft.person.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.person.dto.WorkDTO;
import com.bsoft.person.entity.primary.WorkDO;
import com.bsoft.person.manager.WorkManager;
import com.bsoft.person.service.WorkService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    private WorkManager workManager;
    @Autowired
    private IGenerator generator;
    @Override
    public List<WorkDTO> getWorkWithPersonId(String personId) {
        List<WorkDO> result = workManager.getWorksWithPersonId(personId);
        return generator.convert(result,WorkDTO.class);
    }
}
