package com.bsoft.person.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.person.dto.ContinueLearnDTO;
import com.bsoft.person.entity.primary.ContinueLearnDO;
import com.bsoft.person.manager.ContinueLearnManager;
import com.bsoft.person.service.ContinueLearnService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ContinueLearnServiceImpl implements ContinueLearnService {
    @Autowired
    private ContinueLearnManager continueLearnManager;
    @Autowired
    private IGenerator generator;
    @Override
    public List<ContinueLearnDTO> getContinueLearns(String personId) {
        List<ContinueLearnDO> result = continueLearnManager.getContinueLearns(personId);
        return generator.convert(result,ContinueLearnDTO.class);
    }
}
