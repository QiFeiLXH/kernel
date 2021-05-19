package com.bsoft.common.service;

import com.bsoft.common.dto.SystemDicDTO;
import com.bsoft.common.dto.SystemDicSelectQueryCndDTO;

import java.util.List;

/**
 * @Author Xuhui Lin
 * @Date 2020/9/25 13:01
 * @Description
 */
public interface SystemDicService {
    List<SystemDicDTO> getSystemDic(Integer type);
    List<SystemDicDTO> getSystemDicSelectList(SystemDicSelectQueryCndDTO queryCndDTO);
}
