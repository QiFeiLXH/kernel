package com.bsoft.common.service;

import com.bsoft.common.dto.PublicDicDTO;
import com.bsoft.common.dto.PublicDicSelectQueryCndDTO;

import java.util.List;

public interface PublicDicService {
    List<PublicDicDTO> getPublicDic(Integer type);
    List<PublicDicDTO> getPublicDicWithFlag(Integer type, Integer flag);
    List<PublicDicDTO> getPublicDicSelectList(PublicDicSelectQueryCndDTO queryCndDTO);
}
