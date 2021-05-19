package com.bsoft.person.service;

import com.bsoft.person.dto.ContinueLearnDTO;

import java.util.List;

public interface ContinueLearnService {
    List<ContinueLearnDTO> getContinueLearns(String personId);
}
