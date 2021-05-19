package com.bsoft.common.service;

import com.bsoft.common.dto.HumanDicSelectQueryCndDTO;
import com.bsoft.person.dto.HumanDicDTO;

import java.util.List;

public interface HumanDicService {
    List<HumanDicDTO> getHumanDic(Integer type);
    List<HumanDicDTO> getHumanDicSelectList(HumanDicSelectQueryCndDTO queryCndDTO);
}
