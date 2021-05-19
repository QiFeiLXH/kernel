package com.bsoft.person.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.person.dto.AwardDTO;
import com.bsoft.person.entity.primary.AwardDO;
import com.bsoft.person.manager.AwardManager;
import com.bsoft.person.service.AwardService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AwardServiceImpl implements AwardService {
    @Autowired
    private AwardManager awardManager;
    @Autowired
    private IGenerator generator;
    @Override
    public List<AwardDTO> getAwards(String personId) {
        List<AwardDO> result = awardManager.getAwards(personId);
        return generator.convert(result,AwardDTO.class);
    }
}
