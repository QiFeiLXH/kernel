package com.bsoft.common.service;

import com.bsoft.common.dto.AreaDicDTO;
import com.bsoft.common.dto.PublicDicDTO;

import java.util.List;

public interface AreaDicService {
    /**
     * 获取省市县
     * @param level 1省  2 市 3 县
     * @return
     */
    List<AreaDicDTO> getAreaDic(Integer level);
}
