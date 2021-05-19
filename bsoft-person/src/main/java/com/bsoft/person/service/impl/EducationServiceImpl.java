package com.bsoft.person.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.person.dto.EducationDTO;
import com.bsoft.person.entity.primary.EducationViewDO;
import com.bsoft.person.manager.EducationManager;
import com.bsoft.person.service.EducationService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    private EducationManager educationManager;
    @Autowired
    private IGenerator generator;
    @Override
    public List<EducationDTO> getEducationWithPersonId(String personId) {
        List<EducationViewDO> result = educationManager.getEducationsWithPersonId(personId);
        return generator.convert(result,EducationDTO.class);
    }
}
