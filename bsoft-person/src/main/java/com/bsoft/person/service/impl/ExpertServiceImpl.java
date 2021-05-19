package com.bsoft.person.service.impl;

import com.bsoft.common.dozer.IGenerator;
import com.bsoft.person.dto.ExpertDTO;
import com.bsoft.person.entity.primary.ExpertDO;
import com.bsoft.person.entity.primary.ExpertViewDO;
import com.bsoft.person.manager.ExpertManager;
import com.bsoft.person.service.ExpertService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class ExpertServiceImpl implements ExpertService {
    @Autowired
    private ExpertManager expertManager;
    @Autowired
    private IGenerator generator;
    @Override
    public List<ExpertDTO> getAllExpert() {
        List<ExpertViewDO> result = expertManager.getAllExpert();
        return generator.convert(result,ExpertDTO.class);
    }

    @Override
    public List<ExpertDTO> getExperts(String context) {
        List<ExpertViewDO> result = expertManager.getExperts(context);
        return generator.convert(result,ExpertDTO.class);
    }

    @Override
    public List<ExpertDTO> getExpertWithType(Integer type) {
        List<ExpertDO> result = expertManager.getExpertWithType(type);
        return generator.convert(result,ExpertDTO.class);
    }

    @Override
    public ExpertDTO saveExpert(ExpertDTO expertDTO) {
        ExpertDO expertDO = generator.convert(expertDTO,ExpertDO.class);
        expertDO = expertManager.saveExpert(expertDO);
        return generator.convert(expertDO,ExpertDTO.class);
    }

    @Override
    public void removeExpert(Integer id) {
        expertManager.removeExpert(id);
    }
}
