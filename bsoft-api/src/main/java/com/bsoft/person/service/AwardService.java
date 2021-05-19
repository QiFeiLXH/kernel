package com.bsoft.person.service;

import com.bsoft.person.dto.AwardDTO;

import java.util.List;

public interface AwardService {
    List<AwardDTO> getAwards(String personId);
}
