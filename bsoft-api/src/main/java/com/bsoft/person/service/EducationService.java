package com.bsoft.person.service;

import com.bsoft.person.dto.EducationDTO;

import java.util.List;

public interface EducationService {
    List<EducationDTO> getEducationWithPersonId(String personId);
}
