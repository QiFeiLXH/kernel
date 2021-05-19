package com.bsoft.person.service;

import com.bsoft.person.dto.ExpertDTO;

import java.util.List;

public interface ExpertService {
    List<ExpertDTO> getAllExpert();

    List<ExpertDTO> getExperts(String context);

    List<ExpertDTO> getExpertWithType(Integer type);

    ExpertDTO saveExpert(ExpertDTO expertDTO);

    void removeExpert(Integer id);
}
