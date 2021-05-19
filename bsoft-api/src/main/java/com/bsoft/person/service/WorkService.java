package com.bsoft.person.service;

import com.bsoft.person.dto.WorkDTO;

import java.util.List;

public interface WorkService {
    List<WorkDTO> getWorkWithPersonId(String personId);
}
